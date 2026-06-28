package erp.com.service.impl;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.nexacro.java.xapi.data.DataSet;
import erp.cmmn.exception.UserException;
import erp.com.service.COM10010MService;
import lombok.extern.slf4j.Slf4j;


/**
* @packageName    : erp.com.service.impl
* @fileName       : COM10010MServiceimpl.java
* @author         : Built1
* @date           : 2026.06.24
* @description    : 메시지 데이터를 조회/저장하는 파일
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.06.19        Built1             최초 생성
*/
@Slf4j
@Service
public class COM10010MServiceimpl implements COM10010MService {
	
	//매퍼 인터페이스를 위한 변수
	@Resource
	private COM10010MMapper mapper;
	
	
	/**
	* @methodName     : selectMessageList
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회하는 상속메소드
	* @param inSearch
	* @return
	* @throws Exception
	*/
	@Override
	public List<Map<String, Object>> selectMessageList() throws Exception {		
		return mapper.selectMessageList();
	}

	/**
	* @methodName     : saveMessageData
	* @author         : built1
	* @date           : 2026.06.24
	* @description    : 메시지 데이터를 조회/저장하는 상속메소드
	* @param inMessage
	* @param inCode
	* @param userId
	* @throws Exception
	*/
	@Override
	public void saveMessageData(List<Map<String, Object>> inMessageList, String userId) throws Exception {		
		
		//코드유형에 대한 데이터 건수
		int iSize = inMessageList.size();		
		
		//코드유형 데이터에서 1개의 Row씩 데이터를 추출하여 신규/수정/삭제 데이터유형에 따라 매퍼 인터페이스 호출
		for(int i=0; i<iSize; i++) {
			Map<String, Object> inMessageMap = inMessageList.get(i);
			
		//Row 데이터 유형을 추출
		int iRowType = (int) inMessageMap.get("DataSetRowType");
		
		//Row 데이터 유형에 따른 매퍼 호출
		try {				
			if(iRowType==DataSet.ROW_TYPE_INSERTED) {
				inMessageMap.put("CREATE_BY", userId);
				inMessageMap.put("UPDATE_BY", userId);				
				mapper.insertMessage(inMessageMap);				
				
			} else if (iRowType==DataSet.ROW_TYPE_UPDATED) {
				inMessageMap.put("UPDATE_BY", userId);
				mapper.updateMessage(inMessageMap);
				
			} else if (iRowType==DataSet.ROW_TYPE_DELETED) {
				mapper.deleteMessage(inMessageMap);
				
			}
		} catch (Exception e) {
			throw new UserException(e);
			}	
		}
	}
}
