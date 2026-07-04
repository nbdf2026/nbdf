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
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFDataSetBuilder {
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * 메타데이터를 실제 데이터셋으로 변환하는 단계
	 * --------------------------------------------------------------
	 * 
	 * ResultSet
	 * ↓
	 * NBDFMetaDataReader
	 * ↓
	 * List<NBDFColumn>
	 * ↓
	 * NBDFDataSetBuilder
	 * ↓
	 * PlatformData
	 * ↓
	 * DataSet
	 * 
	 * </pre>
	 * 
	 */
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * Oracle, MyBatis, Nexacro의 쿼리 메타정보 및 쿼리 데이터 분리 
	 * --------------------------------------------------------------
	 * 
	 * NBDFQueryExecutor
	 *  │
	 *  ├──────────────────────┐
	 *  ▼                      ▼
	 *  ResultSetMetaData   ResultSet
	 *  │                      │
	 *  ▼                      ▼
	 *  NBDFMetaDataReader  List<Map>
	 *  │                      │
	 *  └───────────┬──────────┘
	 *              ▼
	 *      NBDFDataSetBuilder
	 *              ▼
	 *        Nexacro Dataset
	 * 
	 * </pre>
	 */
	
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
