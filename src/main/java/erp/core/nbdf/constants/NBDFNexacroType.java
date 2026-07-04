package erp.core.nbdf.constants;

/**
* @packageName    : erp.core.nbdf.constants
* @fileName       : NBDFNexacroType.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : Java 및 DB 타입을 Nexacro Dataset 표준 타입으로 매핑하기 위한 정의 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFNexacroType {
	
	/**
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
	 * 1. Nexacro Dataset 표준 타입 정의
	 * 2. Backend(Java) → Front(Nexacro) 타입 통일
	 * 3. DataSet 생성 및 변환 기준 제공
	 * --------------------------------------------------------------
	 * 
	 * --------------------------------------------------------------
	 * [4] DB/Java 데이터 유형과 넥사크로 데이터유형 매핑 기준
	 * --------------------------------------------------------------
	 * DB / Java Type     →  Nexacro Type
	 * --------------------------------------------------------------
	 * String             →  STRING
	 * Integer            →  INT
	 * Long               →  BIGDECIMAL or INT
	 * BigDecimal         →  BIGDECIMAL
	 * Date               →  DATE
	 * Timestamp          →  DATETIME
	 * Boolean            →  STRING (Y/N or true/false)
	 * 
	 * </pre>
	 */
	
	/**
	 * 생성자(Constructor)
	 * Constants 클래스로 객체 생성 방지
	 */
	private NBDFNexacroType() {
		
	}
	
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
