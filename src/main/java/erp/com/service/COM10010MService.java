package erp.com.service;

import java.util.List;
import java.util.Map;

/**
* @packageName    : erp.com.service
* @fileName       : COM10010MService.java
* @author         : Built1
* @date           : 2026.06.30
* @description    : 메시지 데이터를 조회/저장하는 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.30        Built1             최초 생성
*/
public interface COM10010MService {
	
	/**
	* @methodName     : selectMessageList
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 조회하는 인터페이스
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectMessageList() throws Exception;
	
	/**
	* @methodName     : selectUserList
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 로그인 사용자정보 데이터를 조회하는 인터페이스
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectUserList(String userId, String userPassword) throws Exception;
	
	/**
	* @methodName     : saveMessageData
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 저장하는 인터페이스
	* @param inMessageList
	* @param userId
	* @throws Exception
	*/
	public void saveMessageData(List<Map<String, Object>> inMessageList, String userId) throws Exception;
}
