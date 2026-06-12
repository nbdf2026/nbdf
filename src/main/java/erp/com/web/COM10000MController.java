package erp.com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter.spring.core.data.NexacroResult;

@Controller
@RequestMapping(value = "com/COM10000M")
public class COM10000MController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public NexacroResult selectCodeList() {
		
		log.debug("############################################################");
		
		return null; 
	}
}
