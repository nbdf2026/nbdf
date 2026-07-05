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
	 * 3. Constants Layer (Current)
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
	 * JDBC(java.sql.Types)
	 *      ↓
	 * NBDFDataTypeMapper
	 *      ↓
	 * NBDFJavaType
	 *      ↓
	 * NBDFNexacroType (Current Module)
	 *      ↓
	 * DataSet ColumnInfo
	 *      ↓
	 * PlatformData
	 *      ↓
	 * Nexacro Client
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [3] Responsibilities
	 * --------------------------------------------------------------
	 * 1. Nexacro DataSet의 표준 데이터 타입을 정의
	 * 2. DataSet ColumnInfo 생성 시 타입 기준을 제공
	 * 3. Java 및 NBDF 데이터 타입과 연계하여 타입을 표준화
	 * 4. Nexacro 플랫폼과의 데이터 타입 호환성을 유지
	 * 5. Builder Layer에서 사용할 Nexacro 타입 정보를 제공
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. Nexacro 데이터 타입 정의
	 * 2. DataSet ColumnInfo 타입 지원
	 * 3. Java ↔ Nexacro 타입 연계
	 * 4. NBDF 표준 타입과의 호환성 유지
	 * 5. 플랫폼 독립적인 타입 관리
	 * 6. 프레임워크 전체 타입 일관성 유지
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. Nexacro 표준 데이터 타입을 기반으로 구성
	 * 2. 변경되지 않는 타입 정보만 정의
	 * 3. 데이터 타입의 일관성을 유지
	 * 4. Type Mapping Layer와 독립적으로 관리
	 * 5. 신규 Nexacro 타입 추가가 용이하도록 설계
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * NBDFJavaType
	 *      ↓
	 * NBDFDataTypeMapper
	 *      ↓
	 * NBDFNexacroType (Current)
	 *      ↓
	 * NBDFColumn
	 *      ↓
	 * NBDFDataSetBuilder
	 *      ↓
	 * NBDFTransferDataBuilder
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [7] Extension Point
	 * --------------------------------------------------------------
	 * Nexacro 플랫폼에서 신규 데이터 타입이 지원되는 경우,
	 * NBDFNexacroType에 타입을 추가하여
	 * Builder Layer와 Type Mapping Layer에서 동일한 기준으로 사용할 수 있음
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [8] DB/Java 데이터 유형과 넥사크로 데이터유형 매핑 기준
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
	 * --------------------------------------------------------------
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
