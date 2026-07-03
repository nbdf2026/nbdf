package erp.cmmn.nbdf.metadata;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
* @packageName    : erp.cmmn.nbdf.metadata
* @fileName       : NBDFMetaDataReader.java
* @author         : Built1
* @date           : 2026.07.03
* @description    : ResultSetMetaData를 읽어 NBDFColumn 목록을 생성하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFMetaDataReader {
	
	/**
	 * 오라클에서 데이터 조회 후 NBDF 메타 데이터로 전환하는 단계 
	 * 
	 * ResultSet : 쿼리에서 실행된 데이터셋
	 * ↓
	 * ResultSetMetaData : 쿼리 결과 항목별 메타데이터 추출 
	 * ↓
	 * NBDFColumn 생성 : NBDFColumn 구성 요소별 메타 데이터 값 할당
	 * ↓
	 * DataTypeMapper 호출 : 언제 호출되는지?
	 * ↓
	 * List 반환 : column map 데이터를 List 객체 값 추가 후 반환
	 */
	
	/**
	 * 생성자(Constructor)
	 * Utility 클래스이므로 객체 생성 방지
	 */
	private NBDFMetaDataReader() {
		
	}
	
	/**
	* @methodName     : read
	* @author         : built1
	* @date           : 2026.07.03
	* @description    : 메타정보를 읽어 NBDFColumn 목록을 생성하는 메소드
	* @param rs		  : ResultSet
	* @return columns : NBDFColumn 목록
	* @throws SQLException
	*/
	public static List<NBDFColumn> read(ResultSet rs) throws SQLException {
		
		//List columns 선언
		List<NBDFColumn> columns = new ArrayList<>();
		
		//데이터 조회된 컬럼에 대상정보를 meta 전달
		ResultSetMetaData meta = rs.getMetaData();
		
		//조회된 컬럼의 갯수
		int columnCount = meta.getColumnCount();
		
		//컬럼의 갯수만큼 column 객체 값 할당
		//columnName, columnLabel, jdbcType, dbType, columnSize, scale, nullable 값 할당
		//NBDFDataTypeMapper : 컬럼의 데이터 유형에 따라 javaType, NexacroType 데이터 유형 확정
		for (int i=0; i<columnCount; i++) {
			
			//column map 객체 생성
			NBDFColumn column = new NBDFColumn();
			
			//컬럼에 대한 명칭 및 설명 할당
			column.setColumnName(meta.getColumnName(i));
			column.setColumnLabel(meta.getColumnLabel(i));
			
			//JDBC 컬럼유형 및 DB 컬럼유형 할당
			column.setJdbcType(meta.getColumnType(i));
			column.setDbType(meta.getColumnTypeName(i));
			
			//컬럼에 대한 사이즈 할당
			column.setColumnSize(meta.getPrecision(i));
			
			//컬럼의 소수점 사이즈 할당
			column.setScale(meta.getScale(i));
			
			//컬럼의 널여부 할당
			column.setNullable(meta.isNullable(i) == ResultSetMetaData.columnNullable);
			
			//Java and Nexacro 데이터 유형 자동 생성
			NBDFDataTypeMapper.mapDataType(column);
			
			//NBDFColumn List 객체에 Column map 추가
			columns.add(column);
			
		}
		
		return columns;
		
	}
}
