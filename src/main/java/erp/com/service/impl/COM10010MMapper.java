package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10010MMapper.java
* @author         : Built1
* @date           : 2026.06.24
* @description    : 메시지 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.24        Built1             최초 생성
*/
@Mapper
public interface COM10010MMapper {
	
	/**
	* @methodName     : selectMessageList
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회하는 메소드
	* @param inSearch
	* @return
	* @throws Exception
	*/
	public List<Map<String, Object>> selectMessageList(Map<String, Object> inSearchMap) throws Exception;

	/**
	* @methodName     : insertMessage
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 신규 저장하기 위한 매퍼 인터페이스
	* @param inMessage
	* @throws Exception
	*/
	public void insertMessage(Map<String, Object> inMessageMap) throws Exception;

	/**
	* @methodName     : updateMessage
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 수정하기 위한 매퍼 인터페이스
	* @param inMessage
	* @throws Exception
	*/
	public void updateMessage(Map<String, Object> inMessageMap) throws Exception;

	/**
	* @methodName     : deleteMessage
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 삭제하기 위한 매퍼 인터페이스
	* @param inMessage
	* @throws Exception
	*/
	public void deleteMessage(Map<String, Object> inMessageMap ) throws Exception;
}
