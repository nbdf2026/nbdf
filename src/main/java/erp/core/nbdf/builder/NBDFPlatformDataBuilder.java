package erp.core.nbdf.builder;

import java.util.Map.Entry;

import org.antlr.grammar.v3.ANTLRParser.finallyClause_return;

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
		
		// Variables 데이터(key, value)가 존재하는지 체크
		if (transferData.hasVariables()) {
			return;
		}
		
		// VariableList 생성 
		VariableList variableList = platformData.getVariableList();
		
		// NBDFTransferData 객체의 Variables의 Map객체 반환 후 key, value 값을 추출 후 entry Map에 할당
		for (Entry<String, Object> entry : transferData.getVariables().entrySet()) {
			
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
		
		// 키에 대한 갑을 할당
		if (name == null) {
			variable.set((Object) null);
		} else {
			variable.set(value);
		}
		
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
	private void addDataSets(final PlatformData platformData, NBDFTransferData transferData) {
		
		// transferData 객체에서 DataSet의 데이터 (행, 열 전체?)
		// key              	DataSet
		// ------------------------------------
		// "ds_employee"		DataSet 객체 (ds_employee)
		// "ds_dept"	 		DataSet 객체 (ds_dept)		
		for (Entry<String, DataSet> entry : transferData.getDataSets().entrySet())
			
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
		
		// variableList 객체 생성
		VariableList variableList = platformData.getVariableList();
		
		// transferData 객체에서 getSystemVariables의 Map 데이터 반복적으로 추출
		for (Entry<String, Object> entry : transferData.getSystemVariables().entrySet()) {
			
			// variableList에 getSystemVariables 추가 
			variableList.add(createVariable(entry.getKey(), entry.getValue()));
			
		}		
	}
	
	// 다음 단계에서는 아래 메서드를 추가하는 것을 추천 : 2026.07.09
	// private void setVariableValue(Variable variable, Object value)
}
