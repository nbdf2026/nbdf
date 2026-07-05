package erp.com.web;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nexacro.uiadapter.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter.spring.core.data.NexacroResult;
import erp.com.service.COM10010MService;
import lombok.extern.slf4j.Slf4j;



/**
* @packageName    : erp.com.web
* @fileName       : COM10010MController.java
* @author         : Built1
* @date           : 2026.06.30
* @description    : 메시지 데이터를 조회/저장하는 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.30        Built1             최초 생성
*/
@Slf4j
@Controller
@RequestMapping(value = "com/COM10010M")
public class COM10010MController {

	//구현체 인터페이스를 위한 변수
	@Resource
	private COM10010MService service;
		
	/**
	* @methodName     : selectMessageList
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 조회하는 메서드
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "selectMessageList.do")
	public NexacroResult selectMessageList(@ParamVariable(name = "userId") String userId
			                              ,@ParamVariable(name = "userPassword") String userPassword) throws Exception {
		
		log.info("############################################################");
		log.debug("Controller 					: selectMessageList.do");
		log.debug("userId					: " + userId);
		log.debug("userPassword				: " + userPassword);
		log.debug("############################################################");
		
		//자바 데이터 형식에서 넥사크로 DataSet 형식으로 데이터 전환을 위한 변수
		NexacroResult result = new NexacroResult();
		
		//로그인 사용자정보 조회
		List<Map<String, Object>> outSelectUserList = service.selectUserList(userId, userPassword);		
		result.addDataSet("outSelectUserList", outSelectUserList);
		
		//로그인 사용자 조회 오류 발생
		if (outSelectUserList == null || outSelectUserList.isEmpty() || outSelectUserList.size() == 0) {
			result.setErrorCode(-1);
			result.setErrorMsg("사용자ID 또는 비밀번호가 불일치합니다.");
		} else {		
			//메시지 조회
			List<Map<String, Object>> outSelectMessageList = service.selectMessageList();		
			result.addDataSet("outSelectMessageList", outSelectMessageList);
		}		
		return result;
	}
	
	
	/**
	* @methodName     : saveMessageData
	* @author         : Built1
	* @date           : 2026.06.30
	* @description    : 메시지 데이터를 저장하는 메서드
	* @param inMessageList
	* @param userId
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "saveMessageData.do")
	public NexacroResult saveMessageData(@ParamDataSet(name = "inMessageList") List<Map<String, Object>> inMessageList
                                        ,@ParamVariable(name = "userId")   String userId) throws Exception {
		
		 		
		log.info("############################################################");
		log.debug("Controller 				: saveMessageData.do");
		log.debug("inMessageList			: " + inMessageList);
		log.debug("userId					: " + userId);
		log.info("############################################################");
		
		//메시지 저장
		service.saveMessageData(inMessageList, userId);		
		
		return null;
	}
}
