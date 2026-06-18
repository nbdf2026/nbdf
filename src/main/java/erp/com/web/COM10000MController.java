package erp.com.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter.spring.core.data.NexacroResult;

import erp.com.service.COM10000MService;

/**
* @packageName    : erp.com.web
* @fileName       : COM10000MController.java
* @author         : Built1
* @date           : 2026.06.18
* @description    : 공통코드 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.18        Built1             최초 생성
*/
@Controller
@RequestMapping(value = "com/COM10000M")
public class COM10000MController {

	//로그 출력을 위한 변수
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//구현체 인터페이스를 위한 변수
	private COM10000MService com10000MService;

	/**
	* @methodName     : selectCodeList
	* @author         : built1
	* @date           : 2026.06.18
	* @description    : XXXX 데이터를 조회/저장하는 메소드
	* @param inSearch
	* @return
	* @throws Exception
	*/
	@RequestMapping(value = "selectCodeList")
	public NexacroResult selectCodeList(@ParamDataSet(name = "ds_search") Map<String, Object> inSearch) throws Exception {
		
		log.debug("############################################################");
		log.debug("Controller : selectCodeList");
		log.debug("inSearch   : " + inSearch);
		log.debug("############################################################");
		
		//자바 데이터 형식에서 넥사크로 데이터셋 형식으로 데이터 전환을 위한 변수
		NexacroResult result = new NexacroResult();
		
		//공통코드 조회
		List<Map<String, Object>> outSelectCodeList = com10000MService.selectCodeList();
		
		result.addDataSet("outSelectCodeList", outSelectCodeList);
		
		return result;
	}
}
