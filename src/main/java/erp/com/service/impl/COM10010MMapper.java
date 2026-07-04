package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10010MMapper.java
* @author         : Built1
* @date           : 2026.06.30
* @description    : 메시지 데이터를 조회/저장하는 매퍼 인터페이스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.30        Built1             최초 생성
*/
@Mapper
public interface COM10010MMapper {
	
	/**
	* @methodName     : selectMessageList
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 조회하는 매퍼 인터페이스
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectMessageList() throws Exception;
	
	/**
	* @methodName     : selectUserList
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 로그인 사용자정보 데이터를 조회하는 매퍼 인터페이스
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectUserList(@Param("USER_ID") String userId
			                                       ,@Param("USER_PASSWORD") String userPassword) throws Exception;

	/**
	* @methodName     : insertMessage
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 신규 저장하기 위한 매퍼 인터페이스
	* @param inMessageMap
	* @throws Exception
	*/
	public void insertMessage(Map<String, Object> inMessageMap) throws Exception;

	/**
	* @methodName     : updateMessage
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 수정하기 위한 매퍼 인터페이스
	* @param inMessageMap
	* @throws Exception
	*/
	public void updateMessage(Map<String, Object> inMessageMap) throws Exception;

	/**
	* @methodName     : deleteMessage
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 삭제하기 위한 매퍼 인터페이스
	* @param inMessageMap
	* @throws Exception
	*/
	public void deleteMessage(Map<String, Object> inMessageMap ) throws Exception;
}
