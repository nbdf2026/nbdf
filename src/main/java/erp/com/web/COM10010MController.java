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
* @date           : 2026.06.24
* @description    : 메시지 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.24        Built1             최초 생성
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
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회하는 메소드
	* @param inSearch
	* @param userId
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "selectMessageList.do")
	public NexacroResult selectMessageList() throws Exception {
		
		log.info("############################################################");
		log.debug("Controller 					: selectMessageList.do");
		log.debug("############################################################");
		
		//자바 데이터 형식에서 넥사크로 데이터셋 형식으로 데이터 전환을 위한 변수
		NexacroResult result = new NexacroResult();
		
		//메시지 조회
		List<Map<String, Object>> outSelectMessageList = service.selectMessageList();
		
		result.addDataSet("outSelectMessageList", outSelectMessageList);
		
		return result;
	}
	
	/**
	* @methodName     : saveMessageData
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회/저장하는 메소드
	* @param inCodeType
	* @param inCode
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
		log.debug("userID					: " + userId);
		log.info("############################################################");
		
		//메시지 저장
		service.saveMessageData(inMessageList, userId);		
		
		return null;
	}
}
