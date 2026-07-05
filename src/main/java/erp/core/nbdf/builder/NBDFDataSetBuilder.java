package erp.core.nbdf.builder;

import java.util.List;
import java.util.Map;

import com.nexacro.java.xapi.data.DataSet;

import erp.core.nbdf.metadata.NBDFColumn;

/**
* @packageName    	: erp.core.nbdf.builder
* @fileName       	: NBDFDataSetBuilder.java
* @author         	: Built1
* @date           	: 2026.07.03
* @description    	: NBDF 메타정보와 조회 데이터를 Nexacro DataSet으로 생성하는 Builder 클래스
* 
*  <pre>
 * --------------------------------------------------------------
 * [1] NBDF Layer Structure
 * --------------------------------------------------------------
 * 1. Metadata Layer
 * 2. Builder Layer (Current)
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
 * 		↓
 * ResultSet
 *      ↓
 * ResultSetMetaData
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * List<NBDFColumn>
 *      ↓
 * NBDFDataSetBuilder (Current Module)
 *      ↓
 * DataSet
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
 * 1. NBDFColumn 정보를 이용하여 DataSet을 생성
 * 2. DataSet 컬럼(ColumnInfo)을 구성
 * 3. 컬럼의 데이터 타입 및 크기를 설정
 * 4. ResultSet 데이터를 DataSet Row로 변환
 * 5. Builder Layer의 DataSet 생성 기능을 담당
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [4] Key Features
 * --------------------------------------------------------------
 * 1. DataSet 자동 생성
 * 2. ColumnInfo 자동 구성
 * 3. ResultSet Row 자동 매핑
 * 4. JDBC ↔ Nexacro 데이터 변환 지원
 * 5. NBDFColumn 기반 표준 DataSet 생성
 * 6. Builder Pattern 기반 구현
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [5] Design Principles
 * --------------------------------------------------------------
 * 1. Builder Pattern 적용
 * 2. Metadata와 Data 생성 로직 분리
 * 3. 데이터 타입 일관성 유지
 * 4. 재사용 가능한 DataSet 생성 구조 제공
 * 5. 확장 가능한 Builder 구조 설계
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [6] Related Classes
 * --------------------------------------------------------------
 * ResultSet
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFColumn
 *      ↓
 * NBDFDataSetBuilder (Current)
 *      ↓
 * DataSet
 *      ↓
 * NBDFTransferData
 *      ↓
 * NBDFResult
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [7] Extension Point
 * --------------------------------------------------------------
 * DataSet 생성 정책이 변경되거나 신규 데이터 타입 또는 컬럼 속성이 추가되는 경우,
 * Builder 내부 로직만 확장하면 상위 계층의 변경 없이 적용할 수 있음
 * --------------------------------------------------------------
 *
 * </pre>
 * 
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFDataSetBuilder {
	
	/**
	 * 생성자(Constructor)
	 * Utility 클래스이므로 객체 생성 방지
	 */
	private NBDFDataSetBuilder() {		
	}
	
	/**
	* @methodName     	: build
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 컬럼 정보와 데이터를 이용하여 Nexacro DataSet을 생성하는 메서드
	* @param dataSetName: 생성할 DataSet 이름
	* @param column		: DataSet 컬럼 정보
	* @param data		: DataSet에 추가할 데이터 목록
	* @return			: 생성된 DataSet
	*/
	public static DataSet build(String dataSetName, List<NBDFColumn> columns, List<Map<String, Object>> data) {
		
		//데이터셋 생성
		DataSet dataSet = new DataSet(dataSetName);
		
		//데이터셋의 컬럼 생성(헤더생성)
		createColumns(dataSet, columns);
		
		//데이터셋의 데이터 생성(데이터생성)
		createRows(dataSet, columns, data);
		
		//DataSet 반환
		return dataSet;		
	}
	
	/**
	* @methodName     	: createColumns
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: NBDF 컬럼 정보를 이용하여 DataSet의 컬럼을 생성하는 메서드
	* @param dataSet  	: 컬럼을 생성할 DataSet
	* @param columns  	: DataSet에 추가할 컬럼 정보 목록
	*/
	private static void createColumns(DataSet dataSet, List<NBDFColumn> columns) {
		
		//컬럼정보를 이용하여 데이터셋 컬럼 생성
		for (NBDFColumn column : columns) {
			dataSet.addColumn(column.getColumnName()
					         ,column.getNexacroType()
					         ,column.getColumnSize());
		}
	}
	
	/**
	* @methodName     	: createRows
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 데이터 목록을 이용하여 DataSet의 행(Row)을 생성하는 메서드
	* @param dataSet	: 행을 생성할 DataSet
	* @param columns	: DataSet 컬럼 정보
	* @param rows		: DataSet에 추가할 데이터 목록
	*/
	private static void createRows(DataSet dataSet, List<NBDFColumn> columns, List<Map<String, Object>> rows) {
		
		// 조회 데이터가 없을 경우 Skip
		if (rows==null || rows.isEmpty()) {
			return;
		}
		
		// 조회 데이터를 이용하여 데이터 생성
		for (Map<String, Object> rowData : rows) {
			
			// 신규 Row 생성 후 Row Index 반환
			int row = dataSet.newRow();
			
			// 컬럼별 데이터 할당
			for (NBDFColumn column : columns) {
				Object value = rowData.get(column.getColumnName());				
				dataSet.set(row, column.getColumnName(), convertValue(value));
			}
		}
	}	
	
	/**
	* @methodName     	: convertValue
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: DataSet에 저장 가능한 데이터로 변환하는 메서드
	* @param value	  	: 원본 데이터
	* @return		  	: 변환된 데이터
	*/
	private static Object convertValue(Object value) {
		
		/*
		 * Java Type           Nexacro 저장 형태
		 * -----------------------------------------
		 * String              String
		 * Integer             Integer
		 * Long                Long
		 * BigDecimal          BigDecimal
		 * Boolean             Boolean
		 * LocalDate           yyyyMMdd
		 * LocalDateTime       yyyyMMddHHmmss
		 */
		
		// 널일 경우 null 리턴
		if (value == null) return null;
		
		// 그렇지 않으면 원본 데이터 리턴
		return value;		
	}
}
