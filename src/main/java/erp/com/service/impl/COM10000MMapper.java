package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10000MMapper.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 파일
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
	* @param inSearchMap
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearchMap) throws Exception;

	/**
	* @methodName     : insertCodeTypeMap
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 신규 저장하는 메소드
	* @param inCodeTypeListMap
	* @throws Exception
	*/
	public void insertCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

	/**
	* @methodName     : updateCodeTypeMap
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 수정하는 메소드
	* @param inCodeTypeListMap
	* @throws Exception
	*/
	public void updateCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

	/**
	* @methodName     : deleteCodeTypeMap
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 삭제하는 메소드
	* @param inCodeTypeListMap
	* @throws Exception
	*/
	public void deleteCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

}
