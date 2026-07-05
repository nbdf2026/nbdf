package erp.core.nbdf.constants;

/**
* @packageName    	: erp.core.nbdf.constants
* @fileName       	: NBDFConstants.java
* @author         	: Built1
* @date           	: 2026.07.01
* @description    	: NBDF 프레임워크 전체에서 공통으로 사용하고 변경되지 않는 기준값을 관리하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public final class NBDFConstants {
	 
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
	 * Application
	 *      ↓
	 * NBDFConstants (Current Module)
	 *      ↓
	 * Metadata Layer
	 *      ↓
	 * Builder Layer
	 *      ↓
	 * Result Layer
	 *      ↓
	 * PlatformData
	 *      ↓
	 * Nexacro Client
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [3] Responsibilities
	 * --------------------------------------------------------------
	 * 1. NBDF 프레임워크의 공통 상수를 정의
	 * 2. 데이터 타입 상수를 제공
	 * 3. DataSet 관련 상수를 제공
	 * 4. Result 및 Message 관련 상수를 제공
	 * 5. 프레임워크 전역에서 사용하는 표준 값을 관리
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. Framework 공통 상수 관리
	 * 2. 데이터 타입 상수 제공
	 * 3. Result Code 상수 제공
	 * 4. Message 관련 상수 제공
	 * 5. DataSet 및 Variable 상수 제공
	 * 6. Magic Number 및 Magic String 제거
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. 변경되지 않는 값만 정의
	 * 2. 모든 상수는 public static final로 선언
	 * 3. 기능별로 상수를 그룹화하여 관리
	 * 4. 프레임워크 전역에서 동일한 값을 사용
	 * 5. 유지보수성과 가독성을 향상
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * NBDFConstants (Current)
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
	 *      ↓
	 * NBDFResult
	 *      ↓
	 * NBDFException
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [7] Extension Point
	 * --------------------------------------------------------------
	 * 새로운 데이터 타입, Result Code, 메시지 코드, DataSet 속성 등이
	 * 추가되는 경우 Constants만 확장하면 프레임워크 전체에서 동일한 기준으로 사용할 수 있음
	 * --------------------------------------------------------------
	 *
	 * </pre>
	 */
			
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
