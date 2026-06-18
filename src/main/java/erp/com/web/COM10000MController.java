package erp.com.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter.spring.core.data.NexacroResult;

import erp.com.service.COM10000MService;

@Controller
@RequestMapping(value = "com/COM10000M")
public class COM10000MController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	private COM10000MService com10000MService;
	
	@RequestMapping(value = "selectCodeList")
	public NexacroResult selectCodeList() {
		
		log.debug("############################################################");
		log.debug("Controller : selectCodeList");
		log.debug("############################################################");
		
		//자바 데이터 형식에서 넥사크로 데이터셋 형식으로 데이터 전환
		NexacroResult result = new NexacroResult();
		
		//공통코드 조회
		List<Map<String, Object>> outSelectCodeList = com10000MService.selectCodeList();
		
		result.addDataSet("outSelectCodeList", outSelectCodeList);
		
		return result;
	}
}
