package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;


/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10000MMapper.java
* @author         : Built1
* @date           : 2026.06.18
* @description    : 공통코드 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.18        Built1             최초 생성
*/
@Mapper
public interface COM10000MMapper {

	/**
	* @methodName     : selectCodeList
	* @author         : built1
	* @date           : 2026.06.18
	* @description    : 공통코드 데이터를 조회하는 메소드
	* @return
	*/
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearchMap) throws Exception;

	public void insertCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

	public void updateCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

	public void deleteCodeTypeMap(Map<String, Object> inCodeTypeListMap) throws Exception;

}
