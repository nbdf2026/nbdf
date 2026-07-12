package erp.core.nbdf.reader;

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
		
		// Nexacro platformData 없을 경우 오류 메시지 출력
		if (platformData == null) {
			throw new NBDFException("FMSG-RED-10000"); // PlatformData 객체에 값이 존재하지 않습니다.
		}
		
		// NBDF transferData 생성
		final NBDFTransferData transferData = new NBDFTransferData();
		
		// Nexacro platformData의 Variable 읽기 
		readVariables(platformData, transferData);
		
		// Nexacro platformData의 DataSet 읽기
		readDataSets(platformData, transferData);
		
		// Nexacro platformData의 SystemVariable 읽기
		readSystemVariable(platformData, transferData);
		
		// transferData 리턴
		return transferData;
	}

	/**
	* @methodName     		: readVariables
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: Nexacro PlatformData의 Variable을 읽어 TransferData에 저장하는 메서드
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
			
			// transferData에 variable 추가
			transferData.addVariable(variable.getName(), convertToJavaValue(variable.getObject()));
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
	* @methodName     		: readSystemVariable
	* @author         		: Built1
	* @date           		: 2026.07.12
	* @description    		: PlatformData의 시스템 Variable을 읽어 NBDFTransferData에 저장하는 메서드
	* @param platformData	: Nexacro PlatformData
	* @param transferData	: NBDF transferData 
	*/
	private static void readSystemVariable(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// variableList 조회
		final VariableList variableList = platformData.getVariableList();
		
		// variableList 없거나 갯수가 0일 경우 종료
		if (variableList == null || variableList.size() == 0) {
			return;
		}
		
		// variableList 갯수만큰 loop 저장
		for (int i=0; i<variableList.size(); i++) {
			
			// variable 값 할당(key, value)
			final Variable variable = variableList.get(i);
			
			// variable의 변수명 값 할당
			final String systemVariableName = variable.getName();
			
			// 시스템 variable 아니면 다음 loop
			if (!isSystemVariable(systemVariableName)) {
				continue;
			}
			
			// transferData에 systemVariable 추가
			transferData.addSystemVariable(systemVariableName, convertToJavaValue(variable.getObject()));
		}
	}

	/**
	* @methodName     			: isSystemVariable
	* @author         			: Built1
	* @date           			: 2026.07.12
	* @description    			: 시스템 Variable 여부를 판단하는 메서드
	* @param systemVariableName	: 시스템 변수명
	* @return					: true(시스템 변수명), false(일반 변수명)
	*/
	private static boolean isSystemVariable(String systemVariableName) {
		
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
	* @param value
	* @return
	*/
	private static Object convertToJavaValue(final Object value) {

		// value null일 경우 리턴 null 
		if (value == null) {
			return null;
		}
		
		return value;
	}

}
