package erp.core.nbdf.result;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import com.nexacro.java.xapi.data.DataSet;
import erp.core.nbdf.exception.NBDFException;

/**
* @packageName    	: erp.core.nbdf.result
* @fileName       	: NBDFTransferData.java
* @author         	: Built1
* @date           	: 2026.07.05
* @description    	: NBDF 전송 데이터를 관리하는 Container 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.05        Built1             최초 생성
*/
public class NBDFTransferData {
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * [1] NBDF Layer Structure
	 * --------------------------------------------------------------
	 * 1. Metadata Layer
	 * 2. Builder Layer
	 * 3. Constants Layer
	 * 4. Exception Layer
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
	 * 7. Result Layer (Current)
	 * 8. Message Layer
	 * 9. Validation Layer
	 * 10. Converter Layer
	 * 11. Configuration Layer
	 * 12. Extension Layer
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [2] NBDF Processing Flow
	 * --------------------------------------------------------------
	 * Nexacro Client
	 *      ↓
	 * HttpPlatformRequest
	 *      ↓
	 * PlatformData
	 *      ↓
	 * NBDFTransferData (Current Module)
	 *      ↓
	 * Controller
	 *      ↓
	 * Service
	 *      ↓
	 * NBDFResult
	 *      ↓
	 * PlatformData
	 *      ↓
	 * HttpPlatformResponse
	 *      ↓
	 * Nexacro Client
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [3] Responsibilities
	 * --------------------------------------------------------------
	 * 1. Nexacro Variable 데이터를 저장 및 관리
	 * 2. Nexacro DataSet 객체를 저장 및 관리
	 * 3. Controller와 Service 간 데이터 전달
	 * 4. PlatformData 변환을 위한 표준 전송 객체 제공
	 * 5. Builder 및 Result 객체와 연계되는 데이터 컨테이너 역할 수행
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. Variable 관리
	 * 2. DataSet 관리
	 * 3. LinkedHashMap 기반 입력 순서 유지
	 * 4. Key 기반 빠른 데이터 조회
	 * 5. PlatformData 생성의 기준 객체
	 * 6. 데이터 전달 객체(Transfer Object) 표준 제공
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. Variable와 DataSet의 역할 분리
	 * 2. 데이터 저장 구조의 표준화
	 * 3. 입력 순서 보장을 위한 LinkedHashMap 사용
	 * 4. Builder Pattern과 연계 가능한 구조
	 * 5. Controller, Service, Result 계층과 독립적인 데이터 컨테이너 유지
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * HttpPlatformRequest
	 *      ↓
	 * PlatformData
	 *      ↓
	 * NBDFTransferData (Current)
	 *      ↓
	 * NBDFTransferDataBuilder
	 *      ↓
	 * NBDFResult
	 *      ↓
	 * NBDFResultBuilder
	 *      ↓
	 * HttpPlatformResponse
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [7] Extension Point
	 * --------------------------------------------------------------
	 * 향후 FileData, PagingData, MultiDataSet,
	 * Transaction Metadata, 사용자 정의 Object 등이
	 * 추가되더라도 NBDFTransferData를 확장하여
	 * 동일한 데이터 전달 구조를 유지할 수 있음
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [8] Method coding sequence
	 * -------------------------------------------------------------- 
	 * 1. Constructor
	 * 2. Add Methods
	 * 3. Get Methods
	 * 4. Exists Methods
	 * 5. Get All Methods (read-only)
	 * 6. Remove Methods
	 * 7. Clear Methods
	 * 8. Internal Helper Methods
	 *
	 * </pre>
	 */
	
	/**
	 *  variable 정보
	 */
	private final Map<String, Object> variables;
	
	/**
	 * DataSet 정보
	 */
	private final Map<String, DataSet> dataSets;
	
	/**
	 * 시스템 variable 정보 
	 */
	private final Map<String, Object> systemVariables;
	
	/**
	 * 생성자(Constructor)
	 */
	public NBDFTransferData() {
		//LinkedHashMap: Map 데이터에 입력되는 순서대로 출력
		//variables, dataSets 변수 생성 및 초기화
		this.variables = new LinkedHashMap<String, Object>();
		this.dataSets  = new LinkedHashMap<String, DataSet>();
		this.systemVariables = new LinkedHashMap<String, Object>();
	}
	
	/**
	 * --------------------------------------------------------------
	 * [1] variables 메소드 선언 
	 * --------------------------------------------------------------
	 */
	
	/**
	* @methodName     		: putVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 변수명 및 값을 할당/수정(키 존재)하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @param value			: 변수값(e.g. ADMIN)
	*/
	public void putVariable(String variableName, Object value) {
		
		//null or empty일 경우 오류 메시지
		if (variableName == null || variableName.trim().isEmpty()) {
			throw new NBDFException("FMSG-RST-10010"); //변수명은 필수입니다.
		}
		variables.put(variableName, value);		
	}
	
	/**
	* @methodName     		: getVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수에 대한 값을 리턴하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: 변수값(e.g. ADMIN)
	*/
	public Object getVariable(String variableName) {
		return variables.get(variableName);
	}
	
	/**
	* @methodName     		: containsVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수가 존재하는지 확인하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: true(존재), false(미존재)
	*/
	public boolean containsVariable(String variableName) {
		return variables.containsKey(variableName);
	}
	
	/**
	* @methodName     		: removeVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수를 삭제하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: 삭제된 값(value : e.g ADMIN)
	*/
	public Object removeVariable(String variableName) {
		return variables.remove(variableName);
	}
	
	/**
	* @methodName     		: clearVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수를 모든 값을 삭제하는 메서드
	*/
	public void clearVariables() {
		variables.clear();
	}
	
	/**
	* @methodName     		: getVariabeCount
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수의 갯수를 조회하는 메서드
	* @return				: 변수의 갯수
	*/
	public int getVariableCount() {
		return variables.size();
	}
	
	/**
	* @methodName     		: hasVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 variable이 존재하는지 여부를 반환하는 메서드
	* @return				: true(존재), false(공백)
	*/
	public boolean hasVariables() {
		return !variables.isEmpty();
	}
	
	/**
	* @methodName     		: getVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: 읽기 전용 Map을 반환하여 외부 변경을 방지하는 메서드
	* @return				: Map
	*/
	public Map<String, Object> getVariables() {
		return Collections.unmodifiableMap(variables);
	}
	
	
	/**
	 * --------------------------------------------------------------
	 * [2] dataSets 메소드 선언 
	 * --------------------------------------------------------------
	 */
	
	/**
	* @methodName     		: putDataSet
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSet에 데이터셋명 및 데이터셋을 할당하는 메서드
	* @param dataSetName	: 데이터셋명
	* @param dateSet		: 데이터셋
	*/
	public void putDataSet(String dataSetName, DataSet dataSet) {
		if (dataSetName == null || dataSetName.trim().isEmpty()) {
			throw new NBDFException("FMSG-RST-10010"); //변수명은 필수입니다.
		}
		dataSets.put(dataSetName, dataSet);
	}
	
	/**
	* @methodName     		: getDataSet
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets에 등록된 데이터셋명을 조회하는 메서드
	* @param dataSetName	: 데이터셋명(e.g. ds_search)
	* @return				: 데이터셋
	*/
	public DataSet getDataSet(String dataSetName) {
		return dataSets.get(dataSetName);
	}
	
	/**
	* @methodName     		: containsDataSet
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets의 키 값이 존재하는지 확인하는 메서드
	* @param dataSetName	: 데이터셋명(e.g. ds_search)
	* @return				: true(존재), false(미존재)
	*/
	public boolean containsDataSet(String dataSetName) {
		return dataSets.containsKey(dataSetName);
	}
	
	/**
	* @methodName     		: removeDataSet
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets의 키 값에 대한 데이터셋을 삭제하는 메서드
	* @param dataSetName	: 데이터셋명(e.g. ds_search)
	* @return				: 삭제한 데이터셋(e.g. ds_search)
	*/
	public DataSet removeDataSet(String dataSetName) {
		return dataSets.remove(dataSetName);
	}
	
	/**
	* @methodName     		: clearDataSets
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets에 등록된 모든 DataSet을 삭제하는 메서드
	*/
	public void clearDataSets() {
		dataSets.clear();
	}
	
	/**
	* @methodName     		: getDataSetCount
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets에 등록된 DataSet의 갯수를 조회하는 메서드
	* @return				: DataSet의 갯수
	*/
	public int getDataSetCount() {
		return dataSets.size();
	}
	
	/**
	* @methodName     		: hasDataSets
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: dataSets이 공백인지 확인하는 메서드
	* @return				: true(존재), false(공백)
	*/
	public boolean hasDataSets() {
		return !dataSets.isEmpty();
	}
	
	/**
	* @methodName     		: getDataSets
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: 읽기 전용 dataSets을 반환하여 외부 변경을 방지하는 메서드
	* @return				: dataSets
	*/
	public Map<String, DataSet> getDataSets() {
		return Collections.unmodifiableMap(dataSets);
	}
	
	/**
	 * --------------------------------------------------------------
	 * [3] systemVariables 메소드 선언 
	 * --------------------------------------------------------------
	 */
	
	/**
	* @methodName     		: putSystemVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 변수명 및 값을 할당/수정(키 존재)하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @param value			: 변수값(e.g. ADMIN)
	*/
	public void putSystemVariable(String systemVariableName, Object value) {
		
		//null or empty일 경우 오류 메시지
		if (systemVariableName == null || systemVariableName.trim().isEmpty()) {
			throw new NBDFException("FMSG-RST-10010"); //변수명은 필수입니다.
		}
		systemVariables.put(systemVariableName, value);		
	}
	
	/**
	* @methodName     		: getSystemVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수에 대한 값을 리턴하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: 변수값(e.g. ADMIN)
	*/
	public Object getSystemVariable(String systemVariableName) {
		return systemVariables.get(systemVariableName);
	}
	
	/**
	* @methodName     		: containsSystemVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수가 존재하는지 확인하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: true(존재), false(미존재)
	*/
	public boolean containsSystemVariable(String systemVariableName) {
		return systemVariables.containsKey(systemVariableName);
	}
	
	/**
	* @methodName     		: removeSystemVariable
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수를 삭제하는 메서드
	* @param variableName	: 변수명(e.g. USER_ID)
	* @return				: 삭제된 값(value : e.g ADMIN)
	*/
	public Object removeSystemVariable(String systemVariableName) {
		return systemVariables.remove(systemVariableName);
	}
	
	/**
	* @methodName     		: clearSystemVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수를 모든 값을 삭제하는 메서드
	*/
	public void clearSystemVariables() {
		systemVariables.clear();
	}
	
	/**
	* @methodName     		: getSystemVariableCount
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 등록된 변수의 갯수를 조회하는 메서드
	* @return				: 변수의 갯수
	*/
	public int getSystemVariableCount() {
		return systemVariables.size();
	}
	
	/**
	* @methodName     		: hasSystemVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: Map에 systemVariable이 존재하는지 여부를 반환하는 메서드
	* @return				: true(존재), false(공백)
	*/
	public boolean hasSystemVariables() {
		return !systemVariables.isEmpty();
	}
	
	/**
	* @methodName     		: getSystemVariables
	* @author         		: Built1
	* @date           		: 2026.07.05
	* @description    		: 읽기 전용 Map을 반환하여 외부 변경을 방지하는 메서드
	* @return				: Map
	*/
	public Map<String, Object> getSystemVariables() {
		return Collections.unmodifiableMap(systemVariables);
	}

}
