package erp.cmmn.nbdf.builder;

import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.PlatformData;

/**
* @packageName    : erp.cmmn.nbdf.builder
* @fileName       : NBDFTransferDataBuilder.java
* @author         : Built1
* @date           : 2026.07.03
* @description    : NBDF 전송 데이터(TransferData)를 생성하는 Builder 클래스
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
	 * 2. Builder Layer
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
     * 생성자(Constructor)
     * Utility 클래스이므로 객체 생성을 방지한다.
     */
    private NBDFTransferDataBuilder() {

    }
    
    /**
    * @methodName     : build
    * @author         : Built1
    * @date           : 2026.07.03
    * @description    : NBDF DataSet을 Nexacro PlatformData로 변환하는 메소드
    * @param dataSet  		: NBDFDataSetBuilder에서 생성한 DataSet
    * @return platformData	: Nexacro PlatformData
    */
    public static PlatformData build(DataSet dataSet) {
    	
    	// Nexacro로 전송할 최상위 객체(PlatformData)를 생성
    	PlatformData platformData = new PlatformData();
    	
    	// DataSet이 존재할 경우에만 PlatformData에 추가
    	if (dataSet != null) {
    		platformData.addDataSet(dataSet);
    	}
    	
    	// 생성된 PlatformData 반환
    	return platformData;
    }
}
