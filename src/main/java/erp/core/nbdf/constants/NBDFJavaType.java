package erp.core.nbdf.constants;

/**
* @packageName    : erp.core.nbdf.constants
* @fileName       : NBDFJavaType.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : Java 데이터 유형을 관리하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFJavaType {
	
	/**
	 * 생성자(Constructor)
	 * Constants 클래스로 객체 생성 방지
	 */
	private NBDFJavaType() {
	
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
	 * Java String 타입
	 */
    public static final String STRING = "String";

    /**
     * Java Integer 타입
     */
    public static final String INTEGER = "Integer";

    /**
     * Java Long 타입
     */
    public static final String LONG = "Long";

    /**
     * Java BigDecimal 타입
     * Oracle NUMBER 정밀 데이터 처리
     */
    public static final String BIG_DECIMAL = "BigDecimal";

    /**
     * Java LocalDate 타입
     */
    public static final String DATE = "Date";

    /**
     * Java LocalDateTime 타입
     */
    public static final String DATETIME = "DateTime";

    /**
     * Java Boolean 타입
     */
    public static final String BOOLEAN = "Boolean";
}
