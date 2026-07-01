package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10000MMapper.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 메퍼 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.19        Built1             최초 생성
*/
@Mapper
public interface COM10000MMapper {
	
	/**
	* @methodName     : selectCodeTypeList
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 조회하는 메소드
	* @param inSearch
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearch) throws Exception;

	/**
	* @methodName     : insertCodeType
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 신규 저장하는 메소드
	* @param inCodeTypeMap
	* @throws Exception
	*/
	public void insertCodeType(Map<String, Object> inCodeTypeMap) throws Exception;

	/**
	* @methodName     : updateCodeType
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 수정하는 메소드
	* @param inCodeTypeMap
	* @throws Exception
	*/
	public void updateCodeType(Map<String, Object> inCodeTypeMap) throws Exception;

	/**
	* @methodName     : deleteCodeType
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 삭제하는 메소드
	* @param inCodeTypeMap
	* @throws Exception
	*/
	public void deleteCodeType(Map<String, Object> inCodeTypeMap) throws Exception;

	/**
	* @methodName     : insertCode
	* @author         : built1
	* @date           : 2026.06.23
	* @description    : 코드 데이터를 신규 저장하는 메소드
	* @param inCodeMap
	* @throws Exception
	*/
	public void insertCode(Map<String, Object> inCodeMap) throws Exception;

	/**
	* @methodName     : updateCode
	* @author         : built1
	* @date           : 2026.06.23
	* @description    : 코드 데이터를 수정하는 메소드
	* @param inCodeMap
	* @throws Exception
	*/
	public void updateCode(Map<String, Object> inCodeMap) throws Exception;

	/**
	* @methodName     : deleteCode
	* @author         : built1
	* @date           : 2026.06.23
	* @description    : 코드 데이터를 삭제하는 메소드
	* @param inCodeMap
	* @throws Exception
	*/
	public void deleteCode(Map<String, Object> inCodeMap) throws Exception;

}
