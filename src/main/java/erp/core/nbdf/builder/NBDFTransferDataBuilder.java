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
	 * 2. Builder Layer
	 * 3. Constants Layer
	 * 4. Exception Layer
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
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
     * NBDFTransferDataBuilder
     *      ↓
     * PlatformData
     *      ↓
     * Nexacro Client
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