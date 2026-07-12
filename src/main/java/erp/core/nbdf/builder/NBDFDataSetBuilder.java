package erp.core.nbdf.builder;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
	* @param dataSetName: DataSet 이름
	* @param column		: 컬럼 메타정보
	* @param rows		: 조회 데이터
	* @return			: 생성된 DataSet
	* 
	* @구조
	* ---------------------------------------------------------------
	* build()
	*    │
	*    ├── createColumns()
	*    │
	*    ├── addRows()
	*    │        │
	*    │        └── setColumnValue()
	*    │        │         │
	*    │        │         └── convertValue()
	*    │        │
	*    │        └── addRow()
	*    │
	*    └── return DataSet
	*/
	public static DataSet build(final String dataSetName, final List<NBDFColumn> columns, final List<Map<String, Object>> rows) {
		
		// DataSet 생성
		DataSet dataSet = new DataSet(dataSetName);
		
		// 컬럼 생성(헤더 생성)
		createColumns(dataSet, columns);
		
		// 행 생성(데이터 생성)
		addRows(dataSet, columns, rows);
		
		// DataSet 반환
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
	private static void createColumns(final DataSet dataSet, final List<NBDFColumn> columns) {
		
		// 컬럼정보가 널 또는 공백일 경우 종료
		if (columns == null || columns.isEmpty()) {
		    return;
		}
		
		//DataSet 컬럼 생성
		for (final NBDFColumn column : columns) {
			dataSet.addColumn(column.getColumnName(), column.getNexacroType(), column.getColumnSize());
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
	private static void addRows(final DataSet dataSet, final List<NBDFColumn> columns, final List<Map<String, Object>> rows) {
		
		// 조회 데이터가 없을 경우 종료
		if (rows==null || rows.isEmpty()) {
			return;
		}
		
		// 조회 데이터를 이용하여 데이터 생성
		for (final Map<String, Object> rowData : rows) {
			// Row 생성
			final int rowIndex = dataSet.newRow();
	        
			// Row에 대한 컬럼별 데이터를 생성
			addRow(dataSet, rowIndex, columns, rowData);
		}
	}

	/**
	* @methodName     	: createRow
	* @author         	: Built1
	* @date           	: 2026.07.12
	* @description    	: DataSet의 Row 데이터를 생성하는 메서드
	* @param dataSet	: DataSet 객체
	* @param rowIndex	: Row Index
	* @param columns	: 컬럼정보
	* @param rowData	: Row 데이터
	*/
	private static void addRow(final DataSet dataSet, final int rowIndex, final List<NBDFColumn> columns, final Map<String, Object> rowData) {
		
		// 데이터셋의 생성된 행 데이터를 기준으로 컬럼을 비교하여 값을 할당
		for (final NBDFColumn column : columns) {
			setColumnValue(dataSet, rowIndex, column, rowData.get(column.getColumnName()));
		}
	}
	
	/**
	* @methodName     	: setColumnValue
	* @author         	: Built1
	* @date           	: 2026.07.12
	* @description    	: DataSet Cell에 값을 저장하는 메서드
	* @param dataSet	: 넥사크로 DataSet 객체
	* @param rowIndex   : Row index
	* @param column		: 컬럼 정보
	* @param value		: 저장할 값
	*/
	private static void setColumnValue(final DataSet dataSet, final int rowIndex, final NBDFColumn column, final Object value ) {
	
		// DataSet에 행, 컬럼명, 값을 설정
		dataSet.set(rowIndex, column.getColumnName(), convertValue(value));
		
	}
	
	/**
	* @methodName     	: convertValue
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: DataSet에 저장 가능한 데이터로 변환하는 메서드
	*                     Oracle JDBC의 최신 드라이버(12c/19c 이상)는 TIMESTAMP를
	*                     대부분 java.sql.Timestamp로 반환하므로 별도 처리하지 않음 
	*                     단) 구버전일 경우 oracle.sql.TIMESTAMP 코드 추가 필요
	*                     if (value instanceof oracle.sql.TIMESTAMP) {
	*                         try {
	*                                 return ((oracle.sql.TIMESTAMP) value).timestampValue();
	*                             } catch (SQLException e) {
	*                                 throw new NBDFException("FMSG-BLD-10001", e);
	*                             }
	*                     }
	* @param value	  	: 원본 데이터
	* @return		  	: 변환된 데이터
	*/
	private static Object convertValue(final Object value) {
		
		/*
		 * ----------------------------------------------------------
		 * Java타입           예제값        예상결과
		 * ----------------------------------------------------------
		 * String             "홍길동"      String
		 * Integer            100        	Integer
		 * Long               1000L      	Long
		 * BigDecimal         123.45      	BigDecimal
		 * Boolean            true       	Boolean
		 * java.sql.Date      2026-07-12 	Timestamp
		 * java.sql.Timestamp 현재시각      Timestamp
		 * java.util.Date     현재시각      Timestamp
		 * LocalDate          2026-07-12 	"2026-07-12"
		 * LocalDateTime      현재시각      Timestamp
		 * LocalTime          10:30:15   	"10:30:15"
		 * null               null       	null
		 */
		
		// 널일 경우 null 리턴
		if (value == null) {
			return null;
		}
		
		
		/*
		 * BigInteger Type
		 */
		// BigInteger 유형
		if (value instanceof BigInteger) {
		    return value.toString();
		}
		
		
		/*
		 * Boolean 유형
		 * Character 유형
		 * Enum 유형
		 */
		// Boolean 유형
		if (value instanceof Boolean) {
		    return value;
		}
		
		// Character 유형
		if (value instanceof Character) {
		    return value.toString();
		}
		
		// Enum 유형
		if (value instanceof Enum<?>) {
		    return ((Enum<?>) value).name();
		}
		
		
		/*
		 * SQL Date 유형
		 */		
		// java.sql.Date 유형
		if (value instanceof java.sql.Date) {
			return new Timestamp(((java.sql.Date) value).getTime());
		}
		
		// java.sql.Timestamp 유형
		if (value instanceof java.sql.Timestamp) {
			return value;
		}
		
		
		/*
		 * Java Date 유형
		 */			
		// java.util.Date 유형
		if (value instanceof java.util.Date) {
			return new Timestamp(((java.util.Date) value).getTime());
		}
		
		
		/*
		 * Java 8 Date 유형
		 */			
		// Java 8 LocalDateTime 유형
		if (value instanceof LocalDateTime) {
	        return Timestamp.valueOf((LocalDateTime) value);
	    }
		
		// Java 8 LocalDate 유형
		if (value instanceof LocalDate) {
	        return value.toString();
	    }
		
		// Java 8 LocalTime 유형
		if (value instanceof LocalTime) {
	        return value.toString();
	    }
		
		
		// 그렇지 않으면 원본 데이터 리턴
		return value;		
	}
}
