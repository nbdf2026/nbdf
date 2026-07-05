package erp.core.nbdf.builder;

import java.util.HashMap;
import java.util.Map;

import erp.core.nbdf.exception.NBDFException;

/**
* @packageName    : erp.core.nbdf.builder
* @fileName       : NBDFTransferDataBuilder.java
* @author         : Built1
* @date           : 2026.07.03
* @description    : NBDF 전송 데이터(TransferData)를 생성하는 Builder 클래스
* 					View ↔ Service ↔ DAO 간 데이터 전달 표준화
* 
*  <pre>
 * --------------------------------------------------------------
 * [1] NBDF Layer Structure
 * --------------------------------------------------------------
 * 1. Metadata Layer
 * 2. Builder Layer (Current)
 * 3. Constants Layer
 * 4. Exception Layer
 * 5. Type Mapping Layer
 * 6. Utility Layer
 * 7. Result Layer
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
 * Database
 *      ↓
 * ResultSet
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * NBDFTransferDataBuilder (Current Module)
 *      ↓
 * NBDFTransferData
 *      ↓
 * NBDFResult
 *      ↓
 * PlatformData
 *      ↓
 * Nexacro Client
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [3] Responsibilities
 * --------------------------------------------------------------
 * 1. NBDFTransferData 객체를 생성
 * 2. DataSet 및 Variable 정보를 통합
 * 3. Metadata Layer와 Builder Layer를 연결
 * 4. 전송 가능한 표준 데이터 객체를 구성
 * 5. Result Layer에서 사용할 데이터를 제공
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [4] Key Features
 * --------------------------------------------------------------
 * 1. NBDFTransferData 생성
 * 2. DataSet 통합 관리
 * 3. Variable 통합 관리
 * 4. Builder Layer의 중심 역할 수행
 * 5. 표준 전송 객체 구성
 * 6. Nexacro 전송 데이터 생성 지원
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [5] Design Principles
 * --------------------------------------------------------------
 * 1. Builder Pattern 적용
 * 2. Metadata와 DataSet 생성 로직 분리
 * 3. 전송 객체 생성 책임 집중
 * 4. 상위 계층과 하위 계층의 결합도 최소화
 * 5. 확장 가능한 Builder 구조 제공
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [6] Related Classes
 * --------------------------------------------------------------
 * ResultSet
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * NBDFTransferDataBuilder (Current)
 *      ↓
 * NBDFTransferData
 *      ↓
 * NBDFResult
 *      ↓
 * PlatformData
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [7] Extension Point
 * --------------------------------------------------------------
 * 신규 DataSet, Variable 또는 전송 정책이 추가되는 경우,
 * Builder 내부 구성 로직만 확장하여 상위 계층의 변경 없이 적용할 수 있음
 * --------------------------------------------------------------
 *
 * </pre>
 * 
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFTransferDataBuilder {
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * NBDF Framework Layer
	 * --------------------------------------------------------------
	 * 1. Metadata Layer
	 * 2. Builder Layer(현재)
	 * 3. Constants Layer
	 * 4. Exception Layer
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
	 * 7. Result Layer
	 * 8. Message Layer
	 * 9. Validation Layer
	 * 10. Converter Layer
	 * --------------------------------------------------------------
	 * </pre>
	 */
	
    /**
     * <pre>
     * --------------------------------------------------------------
     * 데이터 전송 생성 흐름
     * --------------------------------------------------------------
     * 
     * ResultSet
     *      ↓
     * NBDFMetaDataReader
     *      ↓
     * List<NBDFColumn>
     *      ↓
     * NBDFDataSetBuilder
     *      ↓
     * DataSet
     *      ↓
     * NBDFTransferDataBuilder (현재)
     *      ↓
     * PlatformData
     *      ↓
     * Nexacro Client
     * 
     * </pre>
     */
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * 클래스 내 메소드 작성 순서
	 * --------------------------------------------------------------
	 * 
	 * 1. 상수(static final) 
	 * 2. 멤버 변수(field)
	 * 3. 생성자(Constructor)	: NBDFTransferDataBuilder()
	 * 4. Static Factory Method : create()
	 * 5. 데이터 추가(Put)		: put(), putAll()
	 * 6. 데이터 조회(Get)    	: get(), getString(), getInt()
	 * 7. 결과 생성(Build)		: build()
	 * 8. 초기화(Clear)    		: clear()
	 * 
	 * </pre>
	 */

    /**
     * 전달 데이터를 저장하는 내부 Map 객체
     */
    private final Map<String, Object> dataMap;
    
    /**
     * 생성자(Constructor)
     * 메소드 내부 저장장소(HashMap) 선언 및 데이터 저장이 가능한 초기상태
     */
    public NBDFTransferDataBuilder() {
    	this.dataMap = new HashMap<>();
	}
    
    /**
     * @description    					: NBDFTransferDataBuilder 인스턴스를 생성하는 메서드
     * @return NBDFTransferDataBuilder	: 생성된 NBDFTransferDataBuilder
     */
    public static NBDFTransferDataBuilder create() {
        return new NBDFTransferDataBuilder();
    }
	
    /**
    * @methodName     	: put
    * @author         	: Built1
    * @date           	: 2026.07.04
    * @description    	: 지정한 키와 값을 TransferData(this.dataMap)에 저장하는 메서드
    * @param key	  	: 데이터 식별 키
    * @param value	  	: 저장할 데이터
    * @return	      	: 현재 NBDFTransferDataBuilder
    */
    public NBDFTransferDataBuilder put(String key, Object value) {
    	if (key == null || key.trim().isEmpty()) {
    	    throw new NBDFException("MSG-A-20000", key); //데이터맵 저장시 키 값이 존재하지 않습니다.
    	}
    	this.dataMap.put(key, value);
    	return this;
    }
    
    /**
    * @methodName     	: putAll
    * @author         	: Built1
    * @date           	: 2026.07.04
    * @description    	: 달받은 Map의 모든 키와 값을 TransferData(this.dataMap)에 저장하는 메서드
    * @param map      	: 추가할 데이터 목록
    * @return	      	: 현재 NBDFTransferDataBuilder
    */
    public NBDFTransferDataBuilder putAll(Map<String, Object> map) {
    	if (map != null) {
    		this.dataMap.putAll(map);
    	}
    	return this;
    }
    
    /**
    * @methodName     	: get
    * @author         	: Built1
    * @date           	: 2026.07.04
    * @description    	: TransferData(this.dataMap)에서 지정한 키에 해당하는 데이터를 조회하는 메소드
    * @param key		: 조회할 데이터의 키
    * @return			: 키에 해당하는 데이터, 존재하지 않으면 null
    */
    public Object get(String key) {
    	return this.dataMap.get(key);
    }
    
    /**
    * @methodName     	: getString
    * @author         	: Built1
    * @date           	: 2026.07.04
    * @description    	: TransferData에서 지정한 키에 해당하는 데이터를 문자열로 조회하는 메소드
    * @param key		: 조회할 데이터의 키
    * @return			: 문자열로 변환된 데이터, 존재하지 않으면 null
    */
    public String getString(String key) {
    	Object value = this.dataMap.get(key);
    	return value != null ? String.valueOf(value) : null;
    }
    
    /**
    * @methodName     	: getInt
    * @author         	: Built1
    * @date           	: 2026.07.04
    * @description    	: TransferData에서 지정한 키에 해당하는 데이터를 숫자로 조회하는 메소드
    * @param key		: 조회할 데이터의 키
    * @return			: 숫자로 변환된 데이터, 존재하지 않으면 0
    */
    public int getInt(String key) {
    	Object value = this.dataMap.get(key);
    	return value != null ? Integer.parseInt(String.valueOf(value)) : 0;
    }
    
    /**
     * @description    	: Builder에 저장된 데이터를 Map으로 생성하여 반환하는 메소드
     * @return 			: 생성된 데이터 맵
     */
    public Map<String, Object> build() {
    	return new HashMap<>(this.dataMap);
    }
    
    /**
     * @description    	: Builder 내부 모든 데이터를 삭제하는 메소드
     */    
    public void clear() {
    	this.dataMap.clear();
    }    
}