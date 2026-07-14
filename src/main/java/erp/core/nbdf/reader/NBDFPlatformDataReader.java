package erp.core.nbdf.reader;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.PlatformData;
import com.nexacro.java.xapi.data.Variable;
import com.nexacro.java.xapi.data.VariableList;

import erp.core.nbdf.constants.NBDFConstants;
import erp.core.nbdf.exception.NBDFException;
import erp.core.nbdf.result.NBDFTransferData;

/**
* @packageName    	: erp.core.nbdf.reader
* @fileName       	: NBDFPlatformDataReader.java
* @author         	: Built1
* @date           	: 2026.07.12
* @description    	: Nexacro PlatformData를 NBDFTransferData로 변환하는 Reader 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.12        Built1             최초 생성
*/
public final class NBDFPlatformDataReader {
	
	/**
	 * -----------------------------------------------------------
	 * NBDFPlatformDataReader 구조
	 * -----------------------------------------------------------
	 * read()
	 *     │
	 *     ├── readVariables()
	 *     │
	 *     ├── readDataSets()
	 *     │     └── readDataSet()
	 *     │
	 *     ├── readSystemVariables()
	 *     │
	 *     ├── readSystemVariables()
	 *     │
	 *     └── convertToJavaValue()
	 *  
	 */	
	
	/**
	* @methodName     		: read
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: Nexacro PlatformData를 NBDFTransferData로 변환하는 메서드
	* @param platformData	: Nexacro PlatformData
	* @return				: NBDFTransferData
	*/
	public static NBDFTransferData read(final PlatformData platformData) {
		
		// NBDF transferData 생성
		final NBDFTransferData transferData = new NBDFTransferData();
				
		// Nexacro platformData 없을 경우 오류 메시지 출력
		if (platformData == null) {
			throw new NBDFException("FMSG-RED-10000"); // PlatformData 객체에 값이 존재하지 않습니다.
		}
		
		// Nexacro PlatformData의 Variable and SystemVariable을 읽어 TransferData에 저장하는 메서드
		readVariables(platformData, transferData);
		
		// PlatformData의 모든 DataSet을 읽어 TransferData에 저장하는 메서드
		readDataSets(platformData, transferData);
		
		// transferData 리턴
		return transferData;
	}
	
	/**
	* @methodName     		: readVariables
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: Nexacro PlatformData의 Variable 및 SystemVariable을 읽어 TransferData에 저장하는 메서드
	* @param platformData	: Nexacro PlatformData
	* @param transferData	: NBDFTransferData
	*/
	private static void readVariables(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// variableList 조회
		final VariableList variableList = platformData.getVariableList();
		
		// variableList 없거나 갯수가 0이면 종료
		if (variableList == null || variableList.size() == 0) {
			return;
		}
		
		// variableList 갯수 만큼 loop 저장
		for (int i=0; i<variableList.size(); i++) {
			
			// variableList에서 로우 단위로 데이터 variable 추출
			final Variable variable = variableList.get(i);
			
			// variable의 변수명(key)
			final String variableName = variable.getName();
			
			// variable 값 변환(value)
			final Object variableValue = convertToJavaValue(variable.getObject());
			
			// 시스템 SystemVariable일 경우
			if (isSystemVariable(variableName)) {
				// transferData에 systemVariable 추가
				transferData.addSystemVariable(variableName, variableValue);				
			} else {				
				// transferData에 variable 추가
				transferData.addVariable(variableName, variableValue);				
			}			
		}
		
	}
	
	/**
	* @methodName     		: readDataSets
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: PlatformData의 모든 DataSet을 읽어 TransferData에 저장하는 메서드
	* @param platformData	: Nexacro PlatformData
	* @param transferData	: NBDF NBDFTransferData
	*/
	private static void readDataSets(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// platformData의 DataSet 갯수가 0일 경우 종료
		if (platformData.getDataSetCount() == 0) {
			return;
		}
		
		// platformData의 DataSet 갯수만큰 loop 저장
		for (int i=0; i<platformData.getDataSetCount(); i++) {
			
			// platformData의 데이터셋을 하나씩 dataSet 저장
			final DataSet dataSet = platformData.getDataSet(i);
			
			// dataSet이 없는 다음 loop
			if (dataSet == null) {
				continue;
			}
			
			// DataSet 하나를 읽어 TransferData에 저장
			readDataSet(dataSet, transferData);
		}
		
	}

	/**
	* @methodName     		: readDataSet
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: DataSet 하나를 읽어 TransferData에 저장하는 메서드
	* @param dataSetName	: DataSet 명칭
	* @param DataSet		: DataSet
	*/
	private static void readDataSet(final DataSet dataSet, final NBDFTransferData transferData) {
		
		// dataSet이 없는 경우 종료  
		if (dataSet == null) {
			return;
		}
		
		// dataSet 명칭이 없거나 공백이면 종료
		if (dataSet.getName() == null || dataSet.getName().isEmpty()) {
			return;
		}
		
		// TransferData에 DataSet 추가
		transferData.addDataSet(dataSet.getName(), dataSet);
		
	}

	/**
	* @methodName     			: isSystemVariable
	* @author         			: Built1
	* @date           			: 2026.07.12
	* @description    			: 시스템 Variable 여부를 판단하는 메서드
	* @param systemVariableName	: 시스템 변수명
	* @return					: true(시스템 변수명), false(일반 변수명)
	*/
	private static boolean isSystemVariable(final String systemVariableName) {
		
		// systemVariableName가 없을 경우 일반 변수
		if (systemVariableName == null) {
			return false;
		}
		
		// systemVariableName 여부 
		switch (systemVariableName) {
			case NBDFConstants.ERR_CD:
			case NBDFConstants.ERR_MSG:
			case NBDFConstants.ERR_TYPE:
			case NBDFConstants.LANG_CD:
			case NBDFConstants.USER_ID:
			case NBDFConstants.USER_NM:
				return true;
	
			default:
				return false;
		}
	}

	/**
	* @methodName     	: convertToJavaValue
	* @author         	: Built1
	* @date           	: 2026.07.12
	* @description    	: Nexacro Variable 값을 Java 객체로 변환하는 메서드
	* @param value		: 오브젝트 값
	* @return			: 자바 데이터 유형으로 변환된 값
	*/
	private static Object convertToJavaValue(final Object value) {
		
		// value null일 경우 null 
		if (value == null) {
			return null;
		}
		
		// String → String
		if (value instanceof String) {
			return value.toString();
		} 
		
		// Integer, Long, Short, Double, Flat, Byte, BigDecimal, BigInteger 유지
		if (value instanceof Number) {
			return value;
		} 
		
		// Boolean → String
		if (value instanceof Boolean) {
			return value.toString();
		} 
		
		// Character → String
		if (value instanceof Character) {
			return value.toString();
		} 
		
		// Enum(Status.SUCCESS) → 코드("SUCCESS")
		if (value instanceof Enum<?>) {
			return ((Enum<?>) value).name();
		} 
		
		// java.sql.Timestamp 유지
		if (value instanceof java.sql.Timestamp) {
			return value;
		} 
		
		// Oracle JDBC 버전 oracle.sql.TIMESTAMP
		if (value instanceof oracle.sql.TIMESTAMP) {
			try {			
				return ((oracle.sql.TIMESTAMP) value).timestampValue();
			} catch (SQLException e) {
				throw new NBDFException("FMSG-RED-10010", e); // Oracle TIMESTAMP 변환 중 오류가 발생하였습니다.
			}
		} 
		
		// java.sql.Date 유지
		if (value instanceof java.sql.Date) {
		    return value;
		} 
		
		// java.util.Date 유지
		if (value instanceof java.util.Date) {
			return value;
		} 
		
		// LocalDate 유지
		if (value instanceof LocalDate) {
			return value;
		} 
		
		// LocalDateTime 유지
		if (value instanceof LocalDateTime) {
			return value;
		} 
		
		// byte[] 유지
		if (value instanceof byte[]) {
		    return value;
		}		
		
		return value;
	}

}
