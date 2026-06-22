package erp.com.web;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.nexacro.uiadapter.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter.spring.core.data.NexacroResult;
import erp.com.service.COM10000MService;
import lombok.extern.slf4j.Slf4j;



/**
* @packageName    : erp.com.web
* @fileName       : COM10000MController.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.19        Built1             최초 생성
*/
@Slf4j
@Controller
@RequestMapping(value = "com/COM10000M")
public class COM10000MController {

	//로그 출력을 위한 변수 (@Slf4j 대체)
	//private Logger log = LoggerFactory.getLogger(getClass());
	
	//구현체 인터페이스를 위한 변수
	@Resource
	private COM10000MService com10000MService;

	/**
	* @methodName     : selectCodeList
	* @author         : built1
	* @date           : 2026.06.18
	* @description    : 공통코드 데이터를 조회하는 메소드
	* @param inSearchMap
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "selectCodeList.do")
	public NexacroResult selectCodeList(@ParamDataSet(name = "inSearchMap") Map<String, Object> inSearchMap
			                           ,@ParamVariable(name = "userId") String userId) throws Exception {
		
		
		/*
		 * System.out.println("LoggerFactory = " +
		 * LoggerFactory.getILoggerFactory().getClass().getName());
		 * 
		 * System.out.println(org.slf4j.LoggerFactory.class .getPackage()
		 * .getImplementationVersion());
		 */		 
		
		log.info("############################################################");
		log.debug("Controller 				: selectCodeList");
		log.debug("inSearchMap   			: " + inSearchMap);
		log.debug("inSearchMap.CODE_TYPE	: " + inSearchMap.get("CODE_TYPE"));
		log.debug("inSearchMap.CODE_TYPE_NM	: " + inSearchMap.get("CODE_TYPE_NM"));
		log.debug("userID					: " + userId);
		log.debug("############################################################");
		
		//자바 데이터 형식에서 넥사크로 데이터셋 형식으로 데이터 전환을 위한 변수
		NexacroResult result = new NexacroResult();
		
		//공통코드 조회
		List<Map<String, Object>> outSelectCodeTypeList = com10000MService.selectCodeTypeList(inSearchMap);
		
		result.addDataSet("outSelectCodeTypeList", outSelectCodeTypeList);
		
		return result;
	}
	
	/**
	* @methodName     : saveCodeData
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 조회/저장하는 메소드
	* @param inCodeTypeList
	* @param userId
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "saveCodeData.do")
	public NexacroResult saveCodeData(@ParamDataSet(name = "inCodeTypeList") List<Map<String, Object>> inCodeTypeList
                                     ,@ParamVariable(name = "userId") String userId) throws Exception {
		
		 		
		log.info("############################################################");
		log.debug("Controller 				: saveCodeData");
		log.debug("inSearchMap   			: " + inCodeTypeList);
		log.debug("userID					: " + userId);
		log.info("############################################################");
		
		NexacroResult saveCodeTypeList = new NexacroResult();
		
		//공통코드 저장
		com10000MService.saveCodeTypeList(inCodeTypeList, userId);		
		
		return saveCodeTypeList;
	}
}
