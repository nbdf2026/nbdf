package erp.core.nbdf.builder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map.Entry;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.PlatformData;
import com.nexacro.java.xapi.data.Variable;
import com.nexacro.java.xapi.data.VariableList;

import erp.core.nbdf.exception.NBDFException;
import erp.core.nbdf.result.NBDFTransferData;

/**
* @packageName    : erp.core.nbdf.builder
* @fileName       : NBDFPlatformDataBuilder.java
* @author         : Built1
* @date           : 2026.07.08
* @description    : NBDFTransferData 객체를 Nexacro PlatformData 객체로 변환하는 Builder 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.08        Built1             최초 생성
*/
public final class NBDFPlatformDataBuilder {
	
	/** 생성자(Constructor) */
	public NBDFPlatformDataBuilder() {		
	}
	
	/**
	* @methodName     		: build
	* @author         		: built1
	* @date           		: 2026.07.08
	* @description    		: NBDFTransferData를 PlatformData로 변환하는 메소드
	* @param transferData	: transferData 전달 객체
	* @return				: PlatformData
	* @throws NBDFException : 전달 객체가 null인 경우
	*/
	public PlatformData build(final NBDFTransferData transferData) {
		
		// transferData 널 체크
		if (transferData == null) {
			throw new NBDFException("FMSG-BLD-10000");
		}
		
		// 넥사크로 플렛폼 데이터 생성
		PlatformData platformData = new PlatformData();
		
		// 사용자변수 등록(userVariables)
		addVariables(platformData, transferData);
		
		// 데이터셋 등록(dataSets)
		addDataSets(platformData, transferData);
		
		// 시스템변수 등록(systemVariables)
		addSystemVariables(platformData, transferData);
		
		// 플랫폼 데이터 반환
		return platformData;
		
	}
	
	/**
	* @methodName     		: addVariables
	* @author         		: built1
	* @date           		: 2026.07.08
	* @description    		: NBDFTransferData에 저장된 모든 Variable을 PlatformData로 옮기는 메소드
	* @param platformData	: 대상 PlatformData
	* @param transferData	: 전달 객체
	*/
	private void addVariables(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// Variables 데이터(key, value)가 존재하는지 않으면 종료
		if (transferData.hasVariables()) {
			return;
		}
		
		// VariableList 생성 
		VariableList variableList = platformData.getVariableList();
		
		// NBDFTransferData 객체의 Variables의 Map객체 반환 후 key, value 값을 추출 후 entry Map에 할당
		for (final Entry<String, Object> entry : transferData.getVariables().entrySet()) {
			
			// variable 객체에 key and value 추가
			Variable variable = createVariable(entry.getKey(), entry.getValue());
			
			// variableList에 variable 객체 추가
			variableList.add(variable);
		}
	}
	
	/**
	* @methodName     		: createVariable
	* @author         		: built1
	* @date           		: 2026.07.08
	* @description    		: Variable 객체를 생성하는 메소드
	* @param name			: 변수명
	* @param value			: 변수값
	* @return				: Variable 객체
	*/
	private Variable createVariable(final String name, final Object value) {
		
		// Variable 객체 생성
		Variable variable = new Variable(name);
		
		// Variable 변수명에 값(key, value) 할당
		setVariable(variable, value);
		
		// Variable 객체 반환
		return variable;
		
	}
	
	/**
	* @methodName     		: addDataSets
	* @author         		: built1
	* @date           		: 2026.07.09
	* @description    		: NBDFTransferData를 PlatformData에 추가하는 메소드
	* @param platformData	: 넥사크로 platformData 객체
	* @param transferData	: NBDF transferData 객체
	*/
	private void addDataSets(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// transferData 객체에 DataSet이 존재하지 않으면 종료
		if (!transferData.hasDataSets()) {
	        return;
	    }
		
		// transferData 객체에서 DataSet의 데이터 (행, 열 전체?)
		// key              	DataSet
		// ------------------------------------
		// "ds_employee"		DataSet 객체 (ds_employee)
		// "ds_dept"	 		DataSet 객체 (ds_dept)		
		for (final Entry<String, DataSet> entry : transferData.getDataSets().entrySet())
			
			// entrySet() : entry.getKey() or entry.getValue()
			// platformData 객체에 DataSet을 추가 : DataSet 객체(ds_employee, ds_dept)
			platformData.addDataSet(entry.getValue());
	}
	
	/**
	* @methodName     : addSystemVariables
	* @author         : built1
	* @date           : 2026.07.09
	* @description    : 시스템 Variable을 PlatformData에 추가하는 메소드
	* @param platformData
	* @param transferData
	*/
	private void addSystemVariables(final PlatformData platformData, final NBDFTransferData transferData) {
		
		// SystemVariables 데이터(key, value)가 존재하는지 않으면 종료
		if (transferData.hasSystemVariables()) {
			return;
		}
				
		// variableList 객체 생성
		VariableList variableList = platformData.getVariableList();
		
		// transferData 객체에서 getSystemVariables의 Map 데이터 반복적으로 추출
		for (Entry<String, Object> entry : transferData.getSystemVariables().entrySet()) {
			
			// variableList에 getSystemVariables 추가 
			variableList.add(createVariable(entry.getKey(), entry.getValue()));
			
		}		
	}
	
	/**
	* @methodName     		: setVariable
	* @author         		: built1
	* @date           		: 2026.07.10
	* @description    		: 전달된 값을 Variable 타입에 맞게 저장하는 메소드
	* @param variable		: PlatformData Variable
	* @param value			: 저장할 값  
	*/
	private void setVariable(final Variable variable, final Object value) {
		
	    // Null은 빈 문자열로 저장
	    if (value == null) {
	        variable.set("");
	        return;
	    }

	    // 문자열
	    if (value instanceof String) {
	        variable.set((String) value);

	    // 정수형
	    } else if (value instanceof Integer) {
	        variable.set((Integer) value);

	    } else if (value instanceof Long) {
	        variable.set((Long) value);

	    } else if (value instanceof Short) {
	        variable.set(((Short) value).intValue());

	    } else if (value instanceof Byte) {
	        variable.set((Byte) value);

	    // 실수형
	    } else if (value instanceof Double) {
	        variable.set((Double) value);

	    } else if (value instanceof Float) {
	        variable.set((Float) value);

	    } else if (value instanceof BigDecimal) {
	        variable.set((BigDecimal) value);

	    // BigInteger는 Variable에서 직접 지원하지 않으므로 문자열 저장
	    } else if (value instanceof BigInteger) {
	        variable.set(value.toString());

	    // 논리형
	    } else if (value instanceof Boolean) {
	        variable.set((Boolean) value);

	    // 문자형
	    } else if (value instanceof Character) {
	        variable.set(value.toString());

	    // Enum은 이름(String)으로 저장
	    } else if (value instanceof Enum<?>) {
	        variable.set(((Enum<?>) value).name());

	    // 날짜(java.util.Date, java.sql.Date, java.sql.Timestamp 모두 포함)
	    } else if (value instanceof java.util.Date) {
	        variable.set((java.util.Date) value);

	    // Java 8 날짜
	    } else if (value instanceof LocalDateTime) {
	        variable.set(Timestamp.valueOf((LocalDateTime) value));

	    } else if (value instanceof LocalDate) {
	        variable.set(value.toString());

	    } else if (value instanceof LocalTime) {
	        variable.set(value.toString());

	    // 기타 타입은 문자열 저장
	    } else {
	        variable.set(String.valueOf(value));
	    }
	}
	// 다음은 buildDataSet()
}


