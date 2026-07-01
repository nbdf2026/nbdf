package erp.com.service;

import java.util.List;
import java.util.Map;

/**
* @packageName    : erp.com.service
* @fileName       : COM10000MService.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.19        Built1             최초 생성
*/
public interface COM10000MService {

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
	* @methodName     : saveCode
	* @author         : built1
	* @date           : 2026.06.23
	* @description    : 공통코드 데이터를 조회/저장하는 메소드
	* @param inCodeType
	* @param inCode
	* @param userId
	* @throws Exception
	*/
	public void saveCode(List<Map<String, Object>> inCodeType
			                ,List<Map<String, Object>> inCode
			                ,String userId) throws Exception;
}
