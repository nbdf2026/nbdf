package erp.core.nbdf.builder;

import java.util.HashMap;
import java.util.Map;

import org.antlr.grammar.v3.ANTLRParser.finallyClause_return;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.PlatformData;

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
	 * NBDF Framework Layer
	 * 
	 * <pre>
	 * 1. Metadata Layer
	 * 2. Builder Layer (현재)
	 * 3. Exception Layer
	 * 4. Message Layer
	 * 5. Query Layer
	 * 6. Controller Layer
	 * </pre>
	 */
	
    /**
     * 데이터 전송 생성 흐름
     *
     * <pre>
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
    * @methodName     : put
    * @author         : built1
    * @date           : 2026.07.04
    * @description    : 데이터 맵에 단일 항목에 대한 데이터를 추가 또는 수정하는 메서드
    * @param key	  : 데이터를 저장할 키
    * @param value	  : 저장할 데이터
    * @return	      : 현재 Builder 객체를 반환
    */
    public NBDFTransferDataBuilder put(String key, Object value) {
    	this.dataMap.put(key, value);
    	return this;
    }
    
    /**
    * @methodName     : putAll
    * @author         : built1
    * @date           : 2026.07.04
    * @description    : 데이터 맵에 여러개의 데이터를 추가 또는 수정하는 메서드
    * @param map      : 추가할 데이터 맵
    * @return	      : 현재 Builder 객체를 반환
    */
    public NBDFTransferDataBuilder putAll(Map<String, Object> map) {
    	if (map != null) {
    		this.dataMap.putAll(map);
    	}
    	return this;
    }
    
}
