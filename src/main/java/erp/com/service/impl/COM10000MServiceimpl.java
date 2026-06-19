package erp.com.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nexacro.java.xapi.data.DataSet;
import erp.com.service.COM10000MService;
import lombok.extern.slf4j.Slf4j;


/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10000MServiceimpl.java
* @author         : Built1
* @date           : 2026.06.19
* @description    : 공통코드 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.19        Built1             최초 생성
*/
@Slf4j
@Service
public class COM10000MServiceimpl implements COM10000MService {
	
	//로그 출력을 위한 변수 (@Slf4j 대체)
	//private Logger log = LoggerFactory.getLogger(getClass());
	
	//매퍼 인터페이스를 위한 변수
	@Resource
	private COM10000MMapper com10000MMapper;
	
	
	/**
	* @methodName     : selectCodeTypeList
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 조회하는 상속메소드
	* @param inSearchMap
	* @return
	* @throws Exception
	*/
	@Override
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearchMap) throws Exception {		
		return com10000MMapper.selectCodeTypeList(inSearchMap);
	}
	
	/**
	* @methodName     : saveCodeTypeList
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 저장하는 상속메소드
	* @param inCodeTypeList
	* @throws Exception
	*/
	@Override
	public void saveCodeTypeList(List<Map<String, Object>> inCodeTypeList) throws Exception {		
		//List row count
		int iSize = inCodeTypeList.size();
		
		//List에서 1개의 Row씩 데이터를 추출하여 신규/수정/삭제 데이터유형에 따라 매퍼 인터페이스 호출
		for(int i=0; i<iSize; i++) {
			Map<String, Object> inCodeTypeListMap = inCodeTypeList.get(i);
			
			//Row 데이터 유형을 추출
			int iDataSetRowType = (int) inCodeTypeListMap.get("DataSetRowType");
			
			//Row 데이터 유형에 따른 매퍼 호출
			if(iDataSetRowType==DataSet.ROW_TYPE_INSERTED) {
				com10000MMapper.insertCodeTypeMap(inCodeTypeListMap);
				
			} else if (iDataSetRowType==DataSet.ROW_TYPE_UPDATED) {
				com10000MMapper.updateCodeTypeMap(inCodeTypeListMap);
				
			} else if (iDataSetRowType==DataSet.ROW_TYPE_DELETED) {
				com10000MMapper.deleteCodeTypeMap(inCodeTypeListMap);
				
			}
		}
	}

}
