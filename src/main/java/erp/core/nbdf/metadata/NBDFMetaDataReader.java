package erp.core.nbdf.metadata;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* @packageName    	: erp.core.nbdf.metadata
* @fileName       	: NBDFMetaDataReader.java
* @author         	: Built1
* @date           	: 2026.07.03
* @description    	: JDBC의 ResultSetMetaData를 읽어 NBDFColumn 목록을 생성하는 클래스* 
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFMetaDataReader {
	
	/**
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
	 * ResultSet
	 *      ↓
	 * ResultSetMetaData
	 *      ↓
	 * NBDFMetaDataReader (Current Module)
	 *      ↓
	 * NBDFDataTypeMapper
	 *      ↓
	 * NBDFColumn List
	 *      ↓
	 * NBDFDataSetBuilder
	 *      ↓
	 * NBDFTransferDataBuilder
	 *      ↓
	 * PlatformData
	 *      ↓
	 * Nexacro Client
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [3] Responsibilities
	 * --------------------------------------------------------------
	 * 1. ResultSetMetaData 정보를 분석
	 * 2. 컬럼 메타데이터를 NBDFColumn 객체로 생성
	 * 3. JDBC 데이터 타입을 NBDF 표준 타입으로 변환
	 * 4. 컬럼명, 데이터 타입, 길이, 정밀도 등의 속성을 추출
	 * 5. Builder Layer에서 사용할 메타데이터를 제공
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. ResultSetMetaData 기반 메타데이터 분석
	 * 2. NBDFColumn 객체 자동 생성
	 * 3. JDBC → NBDF 데이터 타입 변환
	 * 4. 컬럼 속성 표준화
	 * 5. DBMS 독립적인 메타데이터 처리
	 * 6. Builder Layer 연계 지원
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. Metadata 조회 기능만 담당(SRP)
	 * 2. Builder Layer와 역할을 분리
	 * 3. DBMS 독립적인 메타데이터 구조를 제공
	 * 4. NBDFColumn 중심의 메타데이터 모델을 구성
	 * 5. 유지보수와 확장이 용이한 구조를 제공
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * ResultSet
	 *      ↓
	 * ResultSetMetaData
	 *      ↓
	 * NBDFMetaDataReader (Current)
	 *      ↓
	 * NBDFDataTypeMapper
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
	 * 컬럼 설명(Remarks),
	 * Primary Key,
	 * Auto Increment,
	 * Default Value,
	 * Unique,
	 * Display Format 등의
	 * 메타데이터가 필요한 경우,
	 * Reader와 NBDFColumn만 확장하면 Builder Layer에서 동일하게 활용할 수 있음
	 * --------------------------------------------------------------
	 *
	 * </pre>
	 */
	
	/**
	 * 생성자(Constructor)
	 * Utility 클래스이므로 객체 생성 방지
	 */
	private NBDFMetaDataReader() {
		
	}
	
	/**
	* @methodName     	: read
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: ResultSetMetaData를 이용하여 컬럼명, JDBC 데이터 타입,
	* 					  Java 타입, Nexacro 타입 등의 정보를 추출한 후 NBDFColumn 객체를 생성하여 반환하는 메서드
	* @param rs		  	: 컬럼 정보를 조회할 ResultSet
	* @return columns 	: 조회된 컬럼 정보 목록
	* @throws SQLException
	*/
	public static List<NBDFColumn> read(ResultSet rs) throws SQLException {
		
		// List columns 선언
		List<NBDFColumn> columns = new ArrayList<>();
		
		// 데이터 조회된 컬럼에 대상정보를 meta 전달
		ResultSetMetaData meta = rs.getMetaData();
		
		// 조회된 컬럼의 갯수
		int columnCount = meta.getColumnCount();
		
		// 컬럼의 갯수만큼 column 객체 값 할당
		// columnName, columnLabel, jdbcType, dbType, columnSize, scale, nullable 값 할당
		// NBDFDataTypeMapper : 컬럼의 데이터 유형에 따라 javaType, NexacroType 데이터 유형 확정
		for (int i=0; i<columnCount; i++) {
			
			// column map 객체 생성
			NBDFColumn column = new NBDFColumn();
			
			// 컬럼에 대한 명칭 및 설명 할당
			column.setColumnName(meta.getColumnName(i));
			column.setColumnLabel(meta.getColumnLabel(i));
			
			// JDBC 컬럼유형 및 DB 컬럼유형 할당
			column.setJdbcType(meta.getColumnType(i));
			column.setDbType(meta.getColumnTypeName(i));
			
			// 컬럼에 대한 사이즈 할당
			column.setColumnSize(meta.getPrecision(i));
			
			// 컬럼의 소수점 사이즈 할당
			column.setScale(meta.getScale(i));
			
			// 컬럼의 널여부 할당
			column.setNullable(meta.isNullable(i) == ResultSetMetaData.columnNullable);
			
			//Java and Nexacro 데이터 유형 자동 생성
			NBDFDataTypeMapper.mapDataType(column);
			
			// NBDFColumn List 객체에 Column map 추가
			columns.add(column);
			
		}
		
		return columns;
		
	}
}
