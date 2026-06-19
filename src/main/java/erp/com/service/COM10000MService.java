package erp.com.service;

import java.util.List;
import java.util.Map;

/**
* @packageName    : erp.com.service
* @fileName       : COM10000MService.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 파일
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
	* @param inSearchMap
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearchMap) throws Exception;
	
	/**
	* @methodName     : saveCodeTypeList
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 저장하는 메소드
	* @param inCodeTypeList
	* @throws Exception
	*/
	public void saveCodeTypeList(List<Map<String, Object>> inCodeTypeList) throws Exception;
}
