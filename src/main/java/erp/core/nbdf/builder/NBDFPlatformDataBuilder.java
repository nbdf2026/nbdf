package erp.core.nbdf.builder;

import java.util.Map.Entry;
import com.nexacro.java.xapi.data.PlatformData;
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
		
		// 시스템변수 등록(systemVariables)
		
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
		
		// Variables 데이터(key, value)가 존재하는지 체크
		if (transferData.hasVariables()) {
			return;
		}
		
		// VariableList 생성 
		VariableList variableList = platformData.getVariableList();
		
		// NBDFTransferData 객체의 Variables의 Map객체 반환 후 key, value 값을 추출 후 entry Map에 할당
		for (Entry<String, Object> entry : transferData.getVariables().entrySet()) {			
			addVariable(variableList, entry.getKey(), entry.getValue());
		}
	}
	
	/**
	* @methodName     		: addVariable
	* @author         		: built1
	* @date           		: 2026.07.08
	* @description    		: Variable 하나를 PlatformData에 등록하는 메소드
	* @param variableList	: VariableList
	* @param name			: 변수명
	* @param value			: 변수값
	*/
	private void addVariable(final VariableList variableList, final String name, final Object value) {
		
		// 
		//Variable variable = createv
		
		//variableList.add(variable);
	}
}
