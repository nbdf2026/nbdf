package erp.cmmn.nbdf.constants;

/**
* @packageName    : erp.cmmn.nbdf.constants
* @fileName       : NBDFNexacroType.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : Nexacro 데이터셋 데이터 유형을 관리하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFNexacroType {
	
	/**
	 * 생성자(Constructor)
	 * Constants 클래스로 객체 생성 방지
	 */
	private NBDFNexacroType() {
		
	}
	
	/**
	 *  자바 데이터 유형에서 넥사크로 데이터유형 매핑표
	 * Java              Nexacro
	 * ----------------------------
	 * String       →   STRING		: 1
	 * Integer      →   INT			: 2
	 * Long         →   LONG		: 3
	 * BigDecimal   →   BIGDECIMAL	: 4
	 * Date         →   DATE		: 5
	 * DateTime     →   DATETIME	: 6
	 * Boolean      →   BOOLEAN		: 7
	 */
	
	/**
	 * Nexacro String 타입
	 */
    public static final int STRING = 1;

    /**
     * Nexacro Integer 타입
     */
    public static final int INT = 2;

    /**
     * Nexacro Long 타입
     */
    public static final int LONG = 3;

    /**
     * Nexacro BigDecimal 타입
     * 금액, 정밀 숫자 처리
     */
    public static final int BIG_DECIMAL = 4;

    /**
     * Nexacro Date 타입
     */
    public static final int DATE = 5;

    /**
     * Nexacro DateTime 타입
     */
    public static final int DATETIME = 6;

    /**
     * Nexacro Boolean 타입
     */
    public static final int BOOLEAN = 7;
}
