package erp.com.service;

import java.util.List;
import java.util.Map;

/**
* @packageName    : erp.com.service
* @fileName       : COM10010MService.java
* @author         : Built1
* @date           : 2026.06.234
* @description    : 메시지 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.24        Built1             최초 생성
*/
public interface COM10010MService {

	/**
	* @methodName     : selectMessageList
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회하기 위한 인터페이스 서비스
	* @param inSearch
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectMessageList(Map<String, Object> inSearchMap) throws Exception;

	/**
	* @methodName     : saveMessageData
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 저장하기 위한 인터페이스 서비스
	* @param inCodeType
	* @param inCode
	* @param userId
	* @throws Exception
	*/
	public void saveMessageData(List<Map<String, Object>> inMessageList, String userId) throws Exception;
}
