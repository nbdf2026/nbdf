package erp.core.nbdf.metadata;

import java.io.Serializable;

import erp.core.nbdf.constants.NBDFJavaType;
import erp.core.nbdf.constants.NBDFNexacroType;

/**
* @packageName    	: erp.core.nbdf.metadata
* @fileName       	: NBDFColumn.java
* @author         	: Built1
* @date           	: 2026.07.01
* @description    	: JDBC ResultSet 기반 컬럼 정보를 NBDF 표준 메타데이터로 관리하는 클래스
*  
 * <pre>
 * --------------------------------------------------------------
 * [1] NBDF Layer Structure
 * --------------------------------------------------------------
 * 1. Metadata Layer (Current)
 * 2. Builder Layer
 * 3. Constants Layer
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
 * ResultSetMetaData
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFColumn (Current Module)
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * DataSet ColumnInfo
 *      ↓
 * NBDFTransferData
 *      ↓
 * PlatformData
 *      ↓
 * Nexacro Client
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [3] Responsibilities
 * --------------------------------------------------------------
 * 1. 데이터베이스 컬럼 메타데이터를 관리
 * 2. 컬럼명, 데이터 타입, 길이 등의 속성을 보관
 * 3. Java, JDBC, NBDF 및 Nexacro 타입 정보를 관리
 * 4. DataSet ColumnInfo 생성의 기준 정보를 제공
 * 5. Metadata Layer의 표준 컬럼 객체 역할을 수행
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [4] Key Features
 * --------------------------------------------------------------
 * 1. 컬럼 메타데이터 통합 관리
 * 2. JDBC / Java / NBDF / Nexacro 타입 정보 제공
 * 3. 컬럼 길이, 정밀도, Scale 정보 관리
 * 4. Nullable 및 Primary Key 속성 관리
 * 5. DataSet ColumnInfo 생성 지원
 * 6. DBMS 독립적인 컬럼 정보 관리
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [5] Design Principles
 * --------------------------------------------------------------
 * 1. 컬럼 메타데이터만 관리하는 POJO 객체
 * 2. Builder Layer와 역할 분리
 * 3. DBMS 독립적인 구조 유지
 * 4. 데이터 타입의 일관성 유지
 * 5. 확장 가능한 메타데이터 모델 제공
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [6] Related Classes
 * --------------------------------------------------------------
 * ResultSetMetaData
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFColumn (Current)
 *      ↓
 * NBDFDataTypeMapper
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * NBDFTransferDataBuilder
 *      ↓
 * NBDFTransferData
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [7] Extension Point
 * --------------------------------------------------------------
 * 컬럼 기본값(Default Value),
 * 컬럼 설명(Comment),
 * Unique 여부,
 * Auto Increment,
 * Display Format,
 * Mask 정보 등
 * 추가 메타데이터가 필요한 경우,
 * NBDFColumn 속성을 확장하여 Builder Layer에서 동일하게 활용할 수 있음
 * --------------------------------------------------------------
 *
 * </pre>
* 
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.01        Built1             최초 생성
*/
public class NBDFColumn implements Serializable {
	
	/**
	 * Serializable Version UID
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * 생성자(Constructor)
	 * 객체를 생성할 때 가장 먼저 실행되는 메서드
	 */
	public NBDFColumn() {		
    }
		
	/**
	 * ● DB 정보
	 * 컬럼명
	 */
	private String columnName;
	
	/**
	 * 데이터베이스 데이터 유형
	 */
	private String dbType;
	
	/**
	 * JDBC 데이터 유형(java.sql.Types)
	 */
	private int jdbcType;
	
	/**
	 * 컬럼의 길이
	 */
	private int columnSize;
	
	/**
	 * 소수점 자릿수
	 */
	private int scale;
	
	/**
	 * 널 여부
	 */
	private boolean nullable;
	
	/**
	 * 기본값
	 */
	private String defaultValue;
	
	/**
	 * primary 키 여부
	 */
	private boolean primaryKey;
	
	/**
	 * unique 키 여부
	 */
	private boolean uniqueKey;
	
	/**
	 * ● Java 정보
	 * java 데이터 유형
	 */
	private String javaType = NBDFJavaType.STRING;
	
	
	/**
	 * ● Nexacro 정보
	 * 넥사크로 데이터 유형
	 */
	private int nexacroType = NBDFNexacroType.STRING;
	
	
	/**
	 * ● 화면(UI) 정보
	 * 화면 사이즈
	 */
	private int displayWidth = 100;
	
	/**
	 * 필수 입력 여부
	 */
	private boolean required;
	
	/**
	 * 수정 가능 여부
	 */
	private boolean editable = true;

	/**
	 * 화면 표시 여부
	 */
	private boolean visible = true;

	/**
	 * 조회 조건 사용 여부
	 */
	private boolean searchable = true;

	/**
	 * 입력 마스크 또는 표시 마스크
	 */
	private String mask;

	/**
	 * 데이터 표시 형식
	 */
	private String format;

	/**
	 * 공통코드(콤보) ID
	 */
	private String comboId;	

	/**
	 * 엑셀 출력 여부
	 */
	private boolean excelExport = true;
	
	
	/**  
	 * ● 문서화 정보
	 * 컬럼라벨
	 */
	private String columnLabel;
	
	/**
	 * 컬럼 설명
	 */
	private String columnComment;
	
	
	//Generate Getters and Setters
	//해당 소스에서 마우스 오른쪽 클릭 / Source → Generate Getters and Setters...

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public int getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(int jdbcType) {
		this.jdbcType = jdbcType;
	}

	public int getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(int columnSize) {
		this.columnSize = columnSize;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public boolean isUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(boolean uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public int getNexacroType() {
		return nexacroType;
	}

	public void setNexacroType(int nexacroType) {
		this.nexacroType = nexacroType;
	}

	public int getDisplayWidth() {
		return displayWidth;
	}

	public void setDisplayWidth(int displayWidth) {
		this.displayWidth = displayWidth;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public boolean isExcelExport() {
		return excelExport;
	}

	public void setExcelExport(boolean excelExport) {
		this.excelExport = excelExport;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getColumnComment() {
		return columnComment;
	}

	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
}
