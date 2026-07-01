package erp.cmmn.nbdf.metadata;

import java.io.Serializable;

/**
* @packageName    : erp.cmmn.nbdf.metadata
* @fileName       : NBDFColumn.java
* @author         : Built1
* @date           : 2026.07.01
* @description    : Dataset Column 정보를 관리하는 공통 Metadata 객체
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
	
	private static final long serialVersionUID = 1L;
		
	//생성자(Constructor) : 객체를 생성할 때 가장 먼저 실행되는 메서드
	public NBDFColumn() {

    }
	
	//컬럼명
	private String columnName;
	
	//컬럼라벨
	private String columnLabel;
	
	//jdbc 데이터 유형
	private String jdbcType;
	
	//java 데이터 유형
	private String javaType;
	
	//넥사크로 데이터 유형
	private int nexacroType;
	
	//컬럼의 길이
	private int size;
	
	//소수점 자릿수
	private int scale;
	
	//널 여부
	private boolean nullable;
	
	//primary 키 여부
	private boolean primaryKey;
	
	//화면 사이즈
	private int displayWidth = 100;
	
	//필수 입력 여부
	private boolean required;
	
	//수정 가능 여부
	private boolean editable;

	//화면 표시 여부
	private boolean visible;

	//엑셀 출력 여부
	private boolean excelExport;

	//조회 조건 사용 여부
	private boolean searchable;

	//입력 마스크 또는 표시 마스크
	private String mask;

	//데이터 표시 형식
	private String format;

	//공통코드(콤보) ID
	private String comboId;
		
	//Generate Getters and Setters
	//해당 소스에서 마우스 오른쪽 클릭 / Source → Generate Getters and Setters...

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnLabel() {
		return columnLabel;
	}

	public void setColumnLabel(String columnLabel) {
		this.columnLabel = columnLabel;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
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

	public boolean isExcelExport() {
		return excelExport;
	}

	public void setExcelExport(boolean excelExport) {
		this.excelExport = excelExport;
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
}
