package erp.com.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nexacro.java.xapi.data.DataSet;
import erp.cmmn.exception.UserException;
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
	private COM10000MMapper mapper;
	
	
	/**
	* @methodName     : selectCodeTypeList
	* @author         : built1
	* @date           : 2026.06.19
	* @description    : 공통코드 데이터를 조회하는 상속메소드
	* @param inSearch
	* @return
	* @throws Exception
	*/
	@Override
	public List<Map<String, Object>> selectCodeTypeList(Map<String, Object> inSearch) throws Exception {		
		return mapper.selectCodeTypeList(inSearch);
	}

	/**
	* @methodName     : saveCode
	* @author         : built1
	* @date           : 2026.06.23
	* @description    : 공통코드 데이터를 조회/저장하는 상속메소드
	* @param inCodeType
	* @param inCode
	* @param userId
	* @throws Exception
	*/
	@Override
	public void saveCode(List<Map<String, Object>> inCodeType
                        ,List<Map<String, Object>> inCode
                        ,String userId) throws Exception {		
		//코드유형에 대한 데이터 건수
		int iSize = inCodeType.size();		
		
		//코드유형 데이터에서 1개의 Row씩 데이터를 추출하여 신규/수정/삭제 데이터유형에 따라 매퍼 인터페이스 호출
		for(int i=0; i<iSize; i++) {
			Map<String, Object> inCodeTypeMap = inCodeType.get(i);
			
			//Row 데이터 유형을 추출
			int iDataSetRowType = (int) inCodeTypeMap.get("DataSetRowType");
			
			//Row 데이터 유형에 따른 매퍼 호출
			try {				
				if(iDataSetRowType==DataSet.ROW_TYPE_INSERTED) {
					inCodeTypeMap.put("CREATE_BY", userId);
					inCodeTypeMap.put("UPDATE_BY", userId);				
					mapper.insertCodeType(inCodeTypeMap);				
					
				} else if (iDataSetRowType==DataSet.ROW_TYPE_UPDATED) {
					inCodeTypeMap.put("UPDATE_BY", userId);
					mapper.updateCodeType(inCodeTypeMap);
					
				} else if (iDataSetRowType==DataSet.ROW_TYPE_DELETED) {
					mapper.deleteCodeType(inCodeTypeMap);
					
				}
			} catch (Exception e) {
				throw new UserException(e);
			}
		}
		
		
		//코드에 대한 데이터 건수
		iSize = inCode.size();		
		
		//코드 데이터에서 1개의 Row씩 데이터를 추출하여 신규/수정/삭제 데이터유형에 따라 매퍼 인터페이스 호출
		for(int i=0; i<iSize; i++) {
			Map<String, Object> inCodeMap = inCodeType.get(i);
			
			//Row 데이터 유형을 추출
			int iDataSetRowType = (int) inCodeMap.get("DataSetRowType");
			
			//Row 데이터 유형에 따른 매퍼 호출
			try {				
				if(iDataSetRowType==DataSet.ROW_TYPE_INSERTED) {
					inCodeMap.put("CREATE_BY", userId);
					inCodeMap.put("UPDATE_BY", userId);				
					mapper.insertCode(inCodeMap);				
					
				} else if (iDataSetRowType==DataSet.ROW_TYPE_UPDATED) {
					inCodeMap.put("UPDATE_BY", userId);
					mapper.updateCode(inCodeMap);
					
				} else if (iDataSetRowType==DataSet.ROW_TYPE_DELETED) {
					mapper.deleteCode(inCodeMap);
					
				}
			} catch (Exception e) {
				throw new UserException(e);
			}
		}
	}

}
