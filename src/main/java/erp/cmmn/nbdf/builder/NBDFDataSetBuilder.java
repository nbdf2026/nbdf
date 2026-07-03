package erp.cmmn.nbdf.builder;

import java.util.List;
import java.util.Map;

import com.nexacro.java.xapi.data.DataSet;
import erp.cmmn.nbdf.metadata.NBDFColumn;

/**
* @packageName    : erp.cmmn.nbdf.builder
* @fileName       : NBDFDataSetBuilder.java
* @author         : Built1
* @date           : 2026.07.03
* @description    : NBDF 메타정보와 조회 데이터를 Nexacro DataSet으로 생성하는 Builder 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFDataSetBuilder {
	/**
	 * 메타데이터를 실제 데이터셋으로 변환하는 단계
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
	 */
	
	/**
	 * Oracle, MyBatis, Nexacro의 쿼리 메타정보 및 쿼리 데이터 분리 
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
	 */
	
	/**
	 * 생성자(Constructor)
	 * Utility 클래스이므로 객체 생성 방지
	 */
	private NBDFDataSetBuilder() {
		
	}
	
	/**
	* @methodName     : build
	* @author         : built1
	* @date           : 2026.07.03
	* @description    :  NBDFColumn 정보와 조회 데이터를 이용하여 Nexacro DataSet 생성 메소드
	* @param dataSetName	: 데이터셋 이름
	* @param column			: 컬럼 메타정보
	* @param data			: 조회 데이터(List<Map>)
	* @return				: DataSet
	*/
	public static DataSet build(String dataSetName
			                   ,List<NBDFColumn> columns
			                   ,List<Map<String, Object>> data) {
		
		//데이터셋 생성
		DataSet dataSet = new DataSet(dataSetName);
		
		//데이터셋의 컬럼 생성(헤더생성)
		createColumns(dataSet, columns);
		
		//데이터셋의 데이터 생성(데이터생성)
		createRows(dataSet, columns, data);
		
		//리턴 데이터셋(List<Map>)
		return dataSet;
		
	}
	
	/**
	* @methodName     : createColumns
	* @author         : built1
	* @date           : 2026.07.03
	* @description    : XXXX 데이터를 조회/저장하는 메소드
	* @param dataSet  : DataSet 객체
	* @param columns  : 컬럼 메타정보
	*/
	private static void createColumns(DataSet dataSet
			                         ,List<NBDFColumn> columns) {
		
		//컬럼정보를 이용하여 데이터셋 컬럼 생성
		for (NBDFColumn column : columns) {
			dataSet.addColumn(column.getColumnName()
					         ,column.getNexacroType()
					         ,column.getColumnSize());
		}
	}
	
	/**
	* @methodName     : createRows
	* @author         : built1
	* @date           : 2026.07.03
	* @description    : 조회 데이터를 DataSet Row로 생성하는 메소드
	* @param dataSet
	* @param columns
	* @param rows
	*/
	private static void createRows(DataSet dataSet
			                      ,List<NBDFColumn> columns
			                      ,List<Map<String, Object>> rows) {
		
		//조회 데이터를 이용하여 데이터 생성
		for (Map<String, Object> rowData : rows) {
			//신규 row 생성
			int row = dataSet.newRow();
			
			//컬럼별 데이터 할당
			for (NBDFColumn column : columns) {
				Object value = rowData.get(column.getColumnName());				
				dataSet.set(row, column.getColumnName(), convertValue(value));
			}
		}
	}
	
	
	/**
	* @methodName     : cnnvertValue
	* @author         : built1
	* @date           : 2026.07.03
	* @description    : DataSet에 저장 가능한 데이터로 변환하는 메소드
	* @param value	  : 원본 데이터
	* @return		  : 변환된 데이터
	*/
	private static Object convertValue(Object value) {
		
		/**
		 * | Java Type     | Nexacro 저장 형태                                  |
		 * | ------------- | -------------------------------------------------- |
		 * | String        | String                                             |
		 * | Integer       | Integer                                            |
		 * | Long          | Long                                               |
		 * | BigDecimal    | BigDecimal 그대로 또는 프로젝트 정책에 맞는 숫자형 |
		 * | Boolean       | Boolean                                            |
		 * | LocalDate     | 'yyyyMMdd' 문자열                                  |
		 * | LocalDateTime | 'yyyyMMddHHmmss' 문자열                            |
		 * | null          | null                                               |
		 */
		//널일 경우 null 리턴
		if (value == null) return null;
		
		//그렇지 않으면 원본 데이터 리턴
		return value;		
	}
}
