package erp.core.nbdf.constants;

/**
* @packageName    	: erp.core.nbdf.constants
* @fileName       	: NBDFConstants.java
* @author         	: Built1
* @date           	: 2026.07.01
* @description    	: NBDF 프레임워크 전체에서 공통으로 사용하고 변경되지 않는 기준값을 관리하는 클래스
 * 
 * <pre>
 * --------------------------------------------------------------
 * [1] NBDF Layer Structure
 * --------------------------------------------------------------
 * 1. Metadata Layer
 * 2. Builder Layer
 * 3. Constants Layer (Current Module)
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
 * Framework
 *       ↓
 * NBDFConstants (Current)
 *       ↓
 * Builder
 *       ↓
 * Exception
 *       ↓
 * Result
 *       ↓
 * Application
 * 
 * --------------------------------------------------------------
 * [3] Key Features
 * --------------------------------------------------------------
 * 1. 프레임워크 공통 상수를 정의
 * 2. 처리 결과(SUCCESS/FAIL)를 관리
 * 3. NBDF 표준 데이터 유형 및 공통 상수를 제공
 * 4. NBDF 전역에서 공통으로 사용
 * --------------------------------------------------------------
 * 
 *</pre>
 *
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFConstants {
			
	/**
	 * 생성자(Constructor)
	 * Constants 클래스로 객체 생성 방지
	 */
	private NBDFConstants() {
		
    }

    /**
     * 프레임워크 버전
     */
    public static final String VERSION = "1.0";

    /**
     * 기본값
     */
    public static final String EMPTY_STRING = "";
    public static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * 데이터베이스
     */
    public static final String DB_ORACLE = "ORACLE";

    /**
     * 처리상태코드
     */
    public static final String SUCCESS = "SUCCESS";
    public static final String FAIL = "FAIL";
}
