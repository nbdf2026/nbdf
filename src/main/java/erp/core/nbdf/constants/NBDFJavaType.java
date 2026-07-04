package erp.core.nbdf.constants;

/**
* @packageName    	: erp.core.nbdf.constants
* @fileName       	: NBDFJavaType.java
* @author         	: Built1
* @date           	: 2026.07.01
* @description    	: JDBC 및 DB 타입을 NBDF 표준 Java 타입으로 매핑하기 위한 정의 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFJavaType {
	
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
	 * 1. DB 타입을 Java 표준 타입으로 통일
	 * 2. NBDF 전체 데이터 처리 기준 제공
	 * 3. Builder / Converter / Metadata Layer에서 공통 사용
	 * --------------------------------------------------------------
	 * 
	 * --------------------------------------------------------------
	 * [4] DB 데이터 유형과 Java 데이터유형 매핑 기준
	 * --------------------------------------------------------------
	 * DB Type        →  Java Type
	 * --------------------------------------------------------------
	 * CHAR/VARCHAR   →  String
	 * INTEGER        →  Integer
	 * BIGINT         →  Long
	 * DECIMAL        →  BigDecimal
	 * NUMBER         →  BigDecimal / Integer
	 * DATE           →  java.util.Date
	 * TIMESTAMP      →  java.sql.Timestamp
	 * BOOLEAN        →  Boolean
	 * 
	 * </pre>
	 */
	
	/**
	 * 생성자(Constructor)
	 * Constants 클래스로 객체 생성 방지
	 */
	private NBDFJavaType() {
	
	}
	
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
