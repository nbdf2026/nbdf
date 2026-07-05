package erp.core.nbdf.metadata;

import java.sql.Types;

import erp.core.nbdf.constants.NBDFJavaType;
import erp.core.nbdf.constants.NBDFNexacroType;

/**
* @packageName    	: erp.core.nbdf.metadata
* @fileName       	: NBDFDataTypeMapper.java
* @author         	: Built1
* @date           	: 2026.07.03
* @description    	: JDBC DataType과 NBDF 내부 데이터 타입을 상호 변환하기 위한 매핑 클래스 
* 
 * <pre>
 * --------------------------------------------------------------
 * [1] NBDF Layer Structure
 * --------------------------------------------------------------
 * 1. Metadata Layer
 * 2. Builder Layer
 * 3. Constants Layer
 * 4. Exception Layer
 * 5. Type Mapping Layer (Current)
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
 * JDBC(java.sql.Types)
 *      ↓
 * NBDFDataTypeMapper (Current Module)
 *      ↓
 * NBDFJavaType
 *      ↓
 * NBDFNexacroType
 *      ↓
 * NBDFColumn
 *      ↓
 * NBDFDataSetBuilder
 *      ↓
 * PlatformData
 *      ↓
 * Nexacro Client
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [3] Responsibilities
 * --------------------------------------------------------------
 * 1. JDBC 데이터 타입을 NBDF 표준 타입으로 변환
 * 2. Java 데이터 타입과 Nexacro 데이터 타입을 매핑
 * 3. DBMS별 데이터 타입 차이를 표준화
 * 4. Metadata Layer와 Builder Layer의 타입 기준을 제공
 * 5. 프레임워크 전체의 데이터 타입 일관성을 유지
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [4] Key Features
 * --------------------------------------------------------------
 * 1. JDBC → NBDF 데이터 타입 변환
 * 2. Java ↔ NBDF 타입 매핑
 * 3. Nexacro 데이터 타입 매핑
 * 4. DBMS 독립적인 타입 관리
 * 5. Immutable Mapping 구조
 * 6. Thread Safe Utility Class
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [5] Design Principles
 * --------------------------------------------------------------
 * 1. Utility Class Pattern 적용
 * 2. 객체 생성 금지(private Constructor)
 * 3. Static Method 기반 제공
 * 4. 변경 불가능한(Immutable) Mapping 관리
 * 5. 타입 변환 책임만 담당(SRP)
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [6] Related Classes
 * --------------------------------------------------------------
 * java.sql.Types
 *      ↓
 * NBDFJavaType
 *      ↓
 * NBDFDataTypeMapper (Current)
 *      ↓
 * NBDFNexacroType
 *      ↓
 * NBDFColumn
 *      ↓
 * NBDFMetaDataReader
 *      ↓
 * NBDFDataSetBuilder
 * --------------------------------------------------------------
 *
 * --------------------------------------------------------------
 * [7] Extension Point
 * --------------------------------------------------------------
 * 신규 JDBC Type, Java Type 또는 Nexacro Type이 추가되는 경우,
 * Mapping 정보만 확장하면 프레임워크 전체에서 동일한 기준으로 사용할 수 있음
 * --------------------------------------------------------------
 *  * 
 * --------------------------------------------------------------
 * [8] NBDF Data type Structures
 * --------------------------------------------------------------
 *                     java.sql.Types
 *                         │
 *                         ▼
 *                  NBDFDataTypeMapper
 *               ┌─────────┼──────────┐
 *               ▼         ▼          ▼
 *        NBDFJavaType  NBDFType  NBDFNexacroType
 *               │         │          │
 *               └─────────┼──────────┘
 *                         ▼
 *                     NBDFColumn
 *                         ▼
 *                 NBDFMetaDataReader
 *                         ▼
 *                 NBDFDataSetBuilder
 *
 * </pre>
 *
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public final class NBDFDataTypeMapper {

	/**
	 * 생성자(Constructor)
	 * Utility 클래스이므로 객체 생성 방지
	 */
	private NBDFDataTypeMapper() {		
	}
	
	/**
	* @methodName     	: mapDataType
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 데이터베이스에서 조회한 JDBC 데이터 타입을 분석
	* 					  데이터를 Oracle, JDBC, Java, Nexacro 데이터 유형으로 매핑하는 메서드
	* 					  NBDF에서 사용하는 표준 데이터 타입과 Java 타입, Nexacro 타입을 NBDFColumn 객체에 설정하는 메소드
	*  					  표준 데이터 타입 정보를 {@link NBDFColumn} 객체에 설정
	* @param column		: 데이터 타입을 매핑할 컬럼 정보
	*/
	public static void mapDataType(NBDFColumn column) {
		
		// JDBC 데이터 유형(java.sql.Types) : int
		switch (column.getJdbcType()) {
			
			// 문자 데이터 유형
			case Types.CHAR:
			case Types.NCHAR:
			case Types.VARCHAR:
			case Types.NVARCHAR:
			case Types.LONGNVARCHAR:
			case Types.CLOB:
			case Types.NCLOB:
				mapString(column);
				break;
			
			// 숫자 데이터 유형
			case Types.NUMERIC:
			case Types.DECIMAL:
			case Types.INTEGER:
			case Types.BIGINT:
			case Types.SMALLINT:
			case Types.TINYINT:
				mapNumber(column);
				break;
			
			// 날짜 데이터 유형
			case Types.DATE:
				mapDate(column);
				break;
				
			// 날짜일시 데이터 유형
			case Types.TIMESTAMP:
			case Types.TIMESTAMP_WITH_TIMEZONE:
				mapDateTime(column);
				break;
			
			// 논리형 데이터 유형	
			case Types.BOOLEAN:	
			case Types.BIT:
				mapBoolean(column);				
				break;
			
			// 그외 데이터 유형
			default:
				mapString(column);
				break;
		}
	}
	
	
	/**
	* @methodName     	: mapString
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 문자형 JDBC 데이터 타입을 NBDF(자바, 넥사크로) 표준 문자열 타입으로 매핑
	* @param column		: 데이터 타입 정보를 설정할 컬럼 정보
	*/
	private static void mapString(NBDFColumn column) {
		// 문자형으로 전환 : STRING, STRING
		column.setJavaType(NBDFJavaType.STRING);
		column.setNexacroType(NBDFNexacroType.STRING);		
	}
	
	/**
	* @methodName     	: mapNumber
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 숫자형 JDBC 데이터 타입을 NBDF(자바, 넥사크로) 표준 숫자열 타입으로 매핑
	* @param column		: 데이터 타입 정보를 설정할 컬럼 정보
	*/
	private static void mapNumber(NBDFColumn column) {
		
		// 소수점이 존재할 경우 : BIGDECIMAL, BIGDECIMAL
		if (column.getScale() > 0) {
			column.setJavaType(NBDFJavaType.BIG_DECIMAL);
			column.setNexacroType(NBDFNexacroType.BIG_DECIMAL);
			return;
		}
		
		// 숫자형 길이가 9보다 작을 경우 : INTERGER, INT
		if (column.getColumnSize()<=9) {
			column.setJavaType(NBDFJavaType.INTEGER);
			column.setNexacroType(NBDFNexacroType.INT);
			
		// 숫자형 길이가 9보다 크고 18보다 작을 경우 : LONG, LONG	
		} else if (column.getColumnSize()<=18) {
			column.setJavaType(NBDFJavaType.LONG);
			column.setNexacroType(NBDFNexacroType.LONG);
		
		// 숫자형 길이가 18보다 클 경우 : BIGDECIMAL, BIGDECIMAL	
		} else {
			column.setJavaType(NBDFJavaType.BIG_DECIMAL);
			column.setNexacroType(NBDFNexacroType.BIG_DECIMAL);			
		}
	}
	
	/**
	* @methodName     	: mapDate
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 날짜형 JDBC 데이터 타입을 NBDF(자바, 넥사크로) 표준 날짜형 타입으로 매핑
	* @param column		: 데이터 타입 정보를 설정할 컬럼 정보
	*/
	private static void mapDate(NBDFColumn column) {
		// 날짜형으로 전환 : DATE, DATE
		column.setJavaType(NBDFJavaType.DATE);
		column.setNexacroType(NBDFNexacroType.DATE);
	}
	
	/**
	* @methodName     	: mapDateTime
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 날짜일시형 JDBC 데이터 타입을 NBDF(자바, 넥사크로) 표준 날짜일시형 타입으로 매핑
	* @param column		: 데이터 타입 정보를 설정할 컬럼 정보
	*/
	private static void mapDateTime(NBDFColumn column) {
		// 날짜일시형으로 전환 : DATETIME, DATETIME
		column.setJavaType(NBDFJavaType.DATETIME);
		column.setNexacroType(NBDFNexacroType.DATETIME);
	}
	
	/**
	* @methodName     	: mapBoolean
	* @author         	: Built1
	* @date           	: 2026.07.03
	* @description    	: 논리형 JDBC 데이터 타입을 NBDF(자바, 넥사크로) 표준 논리형 타입으로 매핑
	* @param column		: 데이터 타입 정보를 설정할 컬럼 정보
	*/
	private static void mapBoolean(NBDFColumn column) {
		// 논리형으로 전환 : BOOLEAN, BOOLEAN
		column.setJavaType(NBDFJavaType.BOOLEAN);
		column.setNexacroType(NBDFNexacroType.BOOLEAN);
	}
	
}
