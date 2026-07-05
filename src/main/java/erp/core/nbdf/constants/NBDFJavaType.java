package erp.core.nbdf.constants;

/**
* @packageName    	: erp.core.nbdf.constants
* @fileName       	: NBDFJavaType.java
* @author         	: Built1
* @date           	: 2026.07.01
* @description    	: JDBC 및 DB 타입을 NBDF 표준 Java 타입으로 매핑하기 위한 정의 클래스
* 
*  
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
 * Java Class
 *      ↓
 * NBDFJavaType (Current Module)
 *      ↓
 * NBDFDataTypeMapper
 *      ↓
 * NBDFColumn
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * NBDFTransferData
 *      ↓
 * Nexacro Client
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [3] Responsibilities
 * --------------------------------------------------------------
 * 1. Java 표준 데이터 타입을 정의
 * 2. NBDF에서 사용하는 Java 타입 기준을 제공
 * 3. JDBC 및 NBDF 데이터 타입 매핑의 기준 정보를 제공
 * 4. Metadata Layer에서 타입 판별 기준으로 사용
 * 5. 프레임워크 전반의 타입 일관성을 유지
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [4] Key Features
 * --------------------------------------------------------------
 * 1. Java 표준 타입 정의
 * 2. Primitive 및 Wrapper 타입 지원
 * 3. 날짜 및 시간 타입 지원
 * 4. BigDecimal 등 정밀 숫자 타입 지원
 * 5. 타입 매핑 기준 제공
 * 6. 프레임워크 전체 타입 표준화
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [5] Design Principles
 * --------------------------------------------------------------
 * 1. Java 표준 타입을 기반으로 구성
 * 2. 데이터 타입의 일관성을 유지
 * 3. 변경되지 않는 타입 정보만 정의
 * 4. Type Mapping Layer와 독립적으로 관리
 * 5. 신규 Java 타입 추가가 용이하도록 설계
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [6] Related Classes
 * --------------------------------------------------------------
 * NBDFJavaType (Current)
 *      ↓
 * NBDFDataTypeMapper
 *      ↓
 * NBDFColumn
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * NBDFTransferDataBuilder
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [7] Extension Point
 * --------------------------------------------------------------
 * Java의 신규 데이터 타입 또는 프레임워크에서 지원해야 하는 타입이
 * 추가되는 경우, NBDFJavaType에 정의만 추가하면
 * Type Mapping Layer에서 동일한 기준으로 사용할 수 있음
 * --------------------------------------------------------------
 *
 * </pre>
 * 
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
