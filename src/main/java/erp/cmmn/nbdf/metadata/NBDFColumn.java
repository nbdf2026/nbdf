package erp.cmmn.nbdf.metadata;

import java.io.Serializable;
import erp.cmmn.nbdf.constants.NBDFJavaType;
import erp.cmmn.nbdf.constants.NBDFNexacroType;

/**
* @packageName    : erp.cmmn.nbdf.metadata
* @fileName       : NBDFColumn.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : 데이터셋 컬럼정보를 관리하는 메타 객체 클래스
* -----------------------------------------------------------
* @사용처
 * Nexacro Dataset
 * Grid Header
 * Excel
 * Validation
 * Combo
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
