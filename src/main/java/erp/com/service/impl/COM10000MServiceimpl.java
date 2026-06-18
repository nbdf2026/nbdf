package erp.com.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import erp.com.service.COM10000MService;

/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10000MServiceimpl.java
* @author         : Built1
* @date           : 2026.06.18
* @description    : 공통코드 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.18        Built1             최초 생성
*/
@Service
public class COM10000MServiceimpl implements COM10000MService {
	
	//로그 출력을 위한 변수
	private Logger log = LoggerFactory.getLogger(getClass());
	
	//매퍼 인터페이스를 위한 변수
	@Resource
	private COM10000MMapper com10000MMapper;
	
	/**
	* @methodName     : selectCodeList
	* @author         : built1
	* @date           : 2026.06.18
	* @description    : 공통코드 데이터를 조회하는 상속메소드
	* @return
	 * @throws Exception 
	*/
	@Override
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearch) throws Exception {
		
		log.info("############################################################");
		log.debug("Controller 				: COM10000MServiceimpl / selectCodeTypeList");
		log.debug("inSearch   				: " + inSearch);
		log.debug("inSearch.CODE_TYPE		: " + inSearch.get("CODE_TYPE"));
		log.debug("inSearch.CODE_TYPE_NM	: " + inSearch.get("CODE_TYPE_NM"));
		log.debug("############################################################");
		
		return com10000MMapper.selectCodeTypeList(inSearch);
	}

}
