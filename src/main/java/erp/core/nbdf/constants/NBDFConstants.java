package erp.core.nbdf.constants;

/**
* @packageName    : erp.core.nbdf.constants
* @fileName       : NBDFConstants.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : NBDF 프레임워크 전체에서 공통으로 사용하고 변경되지 않는 기준값을 관리하는 클래스
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
