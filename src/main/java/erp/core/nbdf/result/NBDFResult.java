package erp.core.nbdf.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @packageName    	: erp.core.nbdf.result
* @fileName       	: NBDFResult.java
* @author         	: Built1
* @date           	: 2026.07.04
* @description    	: NBDF Framework의 표준 응답(Result) 객체 클래스
*                     Controller → Service → Nexacro 화면까지 전달되는
*                     모든 응답 데이터를 표준화하기 위한 Wrapper 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.04        Built1             최초 생성
*/
public class NBDFResult implements Serializable {
	
	/**  
	 * <pre>
	 * --------------------------------------------------------------
	 * [1] NBDF Layer Structure
	 * --------------------------------------------------------------
	 * 1. Metadata Layer
	 * 2. Builder Layer
	 * 3. Constants Layer
	 * 4. Exception Layer
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
	 * 7. Result Layer (Current)
	 * 8. Message Layer
	 * 9. Validation Layer
	 * 10. Converter Layer
	 * 11. Configuration Layer
	 * 12. Extension Layer
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [2] NBDF Processing Flow
	 * --------------------------------------------------------------
	 * Controller
	 *     ↓
	 * Service
	 *     ↓
	 * NBDFResult 생성 (success / fail)
	 *     ↓
	 * NBDFTransferData 추가 (비즈니스 데이터)
	 *     ↓
	 * Controller 반환
	 *     ↓
	 * Nexacro PlatformData 변환 
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [3] Responsibilities
	 * --------------------------------------------------------------
	 * 1. 서비스 처리 결과를 표준 객체로 관리
	 * 2. DataSet 및 Variable 정보를 통합 관리
	 * 3. 처리 결과(Status)를 관리
	 * 4. 메시지(Message) 정보를 관리
	 * 5. Controller에서 반환되는 표준 응답 객체 역할을 수행
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. 표준 응답 객체 제공
	 * 2. DataSet 관리
	 * 3. Variable 관리
	 * 4. Result Code 관리
	 * 5. Message 관리
	 * 6. PlatformData 생성의 기준 객체
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. Result 객체와 전송 객체의 역할 분리
	 * 2. Controller의 반환 객체 표준화
	 * 3. Builder Pattern과 연계
	 * 4. 확장 가능한 Result 구조 제공
	 * 5. Nexacro 독립적인 응답 객체 유지
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * Controller
	 *      ↓
	 * NBDFResult (Current)
	 *      ↓
	 * NBDFTransferData
	 *      ↓
	 * NBDFResultBuilder
	 *      ↓
	 * PlatformData
	 *      ↓
	 * HttpPlatformResponse
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [7] Extension Point
	 * --------------------------------------------------------------
	 * 향후 페이징 정보(PageInfo), 파일 다운로드(FileInfo),
	 * 다중 DataSet, 응답 메타데이터(Response Metadata) 등이
	 * 추가되더라도 NBDFResult를 확장하여 동일한 응답 구조를 유지할 수 있음
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [8] Comment rules
	 * --------------------------------------------------------------
	 * get 		→ 조회합니다.
	 * set 		→ 할당합니다.
	 * add 		→ 추가합니다.
	 * remove 	→ 삭제합니다.
	 * build 	→ 생성합니다.
	 * convert 	→ 변환합니다.
	 * validate → 검증합니다.
	 * parse 	→ 분석합니다.
	 * --------------------------------------------------------------
	 * 
	 * --------------------------------------------------------------
	 * [9] 구조
	 * --------------------------------------------------------------
	 * NBDFResult
	 *   ├── success (boolean) : 성공/실패 상태
	 *   ├── messageCode       : 메시지 코드
	 *   ├── messageText       : 메시지 내용
	 *   └── dataMap           : 여러 Dataset 형태 데이터 저장
	 *         └── key(String)
	 *               └── NBDFTransferData
	 * --------------------------------------------------------------
	 * 
	 * </pre>
	 */
	
	/** Serializable Version UID */
	private static final long serialVersionUID = 1L;
	
	/** NBDFResult 객체 성공/실패 상태 여부 */
	private boolean success = true;
			
	/** 메시지 번호 */
	private String messageCode;
	
	/** 메시지 내용 */
	private String messageText;
	
	/** 다중 메시지 지원 */
	private List<String> messages = new ArrayList<>();
	
	/** 데이터 영역 */
	private Map<String, NBDFTransferData> dataMap = new HashMap<>();
	
	/** 시스템 변수 */
	private Map<String, Object> systemVariablesMap = new HashMap<>();
	
	/** 사용자 변수 */
	private Map<String, Object> userVariables = new HashMap<>();
	
	/** 예외 정보 */
	private Exception exception;
	
	
    // --------------------------------------------------
    // [1] NBDFResult 객체에 대한 성공 및 실패에 대한 메서드 선언
    // --------------------------------------------------
	
    /**
    * @methodName     		: success
    * @author         		: built1
    * @date           		: 2026.07.06
    * @description    		: NBDFResult 객체를 성공 상태로 만들어서 반환하는 메소드
    * 						  @static 객체를 선언하지 않고 메소드를 직접 호출 (e.g. NBDFResult.success())
    * @param messageCode	: 메시지코드
    * @param messageText	: 메시지내용
    * @return				: NBDFResult 객체
    */
    public static NBDFResult success(String messageCode, String messageText) {
    	NBDFResult result = new NBDFResult();
    	result.success = true;
    	result.messageCode = messageCode;
    	result.messageText = messageText;
    	return result;
    }
    
    /**
    * @methodName     		: fail
    * @author         		: built1
    * @date           		: 2026.07.06
    * @description    		: NBDFResult 객체를 실패 상태로 만들어서 반환하는 메소드
    * @param messageCode	: 메시지코드
    * @param messageText	: 메시지내용
    * @return				: NBDFResult 객체
    */
    public static NBDFResult fail(String messageCode, String messageText) {
    	NBDFResult result = new NBDFResult();
    	result.success = false;
    	result.messageCode = messageCode;
    	result.messageText = messageText;
    	return result;
    }
    

    // --------------------------------------------------
    // [2] NBDFTransferData 객체 데이터 처리
    // --------------------------------------------------
    
    /**
    * @methodName     		: addData
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 지정한 식별자(Key)로 NBDFTransferData 객체를 컨테이너에 저장
    * @param key			: 데이터를 식별하기 위한 고유 Key(dataSetName, BusinessCode, InterfaceName 등)
    * @param data			: 저장할 NBDFTransferData 객체
    * 
    *  [사용 예]
	 * --------------------------------------------------
	 * Controller
	 *     ↓
	 * Service
	 *     ↓
	 * NBDFTransferData 생성
	 *     ↓
	 * addData("EMP", transferData)
	 *     ↓
	 * Container 내부 저장
	 *
	 * 결과
	 * --------------------------------------------------
	 * Key      Value
	 * --------------------------------------------------
	 * EMP   -> NBDFTransferData
	 * DEPT  -> NBDFTransferData
	 * USER  -> NBDFTransferData
	 * --------------------------------------------------
	 * 
	 * 이후 필요한 위치에서 Key를 이용하여 해당 데이터를 조회
    */
    public void addData(String key, NBDFTransferData data) {
    	this.dataMap.put(key, data);
    }
    
    /**
    * @methodName     		: getData
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 지정한 Key에 해당하는 NBDFTransferData 객체를 조회하는 메서드
    * @param dataSetName	: 조회할 데이터의 Key(dataSetName, BusinessCode, InterfaceName 등) 식별자
    * @return				: 저장된 NBDFTransferData 객체, 저장된 데이터가 없는 경우 null
    * 
    *  [조회 과정]
	 * --------------------------------------------------
	 * Container
	 *     ↓
	 * getData("EMP")
	 *     ↓
	 * dataMap.get("EMP")
	 *     ↓
	 * NBDFTransferData 반환
	 *
	 * [반환 예]
	 *
	 * Key : EMP
	 *      ↓
	 * +-----------------------+
	 * | NBDFTransferData      |
	 * |  Variables            |
	 * |  DataSets             |
	 * |  SystemVariables      |
	 * +-----------------------+
	 * 
	 * --------------------------------------------------
    */
    public NBDFTransferData getData(String key) {
    	return this.dataMap.get(key);
    }
    
    /**
    * @methodName     		: getDataMap
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 컨테이너에 저장된 모든 NBDFTransferData 정보를 반환하는 메서드
    * @return				: 저장된 모든 NBDFTransferData Map
    * 
    *  [예]
	 * --------------------------------------------------
	 * for (Map.Entry<String, NBDFTransferData> entry : getDataMap().entrySet()) {
	 *     String key = entry.getKey();
	 *     NBDFTransferData data = entry.getValue();
	 *
	 *     // 데이터 처리
	 * }
	 * 
	 * --------------------------------------------------
    */
    public Map<String, NBDFTransferData> getDataMap() {
    	return Collections.unmodifiableMap(dataMap);
    }
    

    // --------------------------------------------------
    // [3] 메시지 처리
    // --------------------------------------------------
    
    /**
    * @methodName     		: addMessage
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 처리 결과 메시지를 메시지 목록에 추가하는 메서드
    * @param message		: 추가할 처리 결과 메시지
    * 
    *  [처리 예]
	 * --------------------------------------------------
	 * addMessage("저장되었습니다.");
	 * addMessage("사원정보가 변경되었습니다.");
	 * addMessage("메일 발송이 완료되었습니다.");
	 * --------------------------------------------------
	 * 
    */
    public void addMessage(String message) {
    	if (message != null && !message.isBlank()) {
            this.messages.add(message);
        }
    }
    

    // --------------------------------------------------
    // [4] 시스템 변수 처리
    // --------------------------------------------------
    
    /**
    * @methodName     		: addSystemVariable
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 시스템 변수를 등록하거나 기존 값을 변경하는 메서드
    * @param key			: 시스템 변수명
    * @param value			: 저장할 시스템 변수 값
    * 
    *  [시스템 변수 예]
	 * --------------------------------------------------
	 * USER_ID        		: 로그인 사용자 ID
	 * USER_NAME      		: 사용자명
	 * COMPANY_CD     		: 회사코드
	 * LANG_CD        		: 언어코드
	 * SESSION_ID     		: 세션 ID
	 * CLIENT_IP      		: 클라이언트 IP
	 * SERVER_TIME    		: 서버 처리시간
	 * TRANSACTION_ID 		: 트랜잭션 ID
	 * --------------------------------------------------
	 * 
	 * [사용 예]
	 * --------------------------------------------------
	 * addSystemVariable("USER_ID", "ADMIN");
	 * addSystemVariable("LANG_CD", "ko");
	 * addSystemVariable("CLIENT_IP", "192.168.0.10");
	 * --------------------------------------------------
	 * 
    */
    public void addSystemVariable(String key, Object value) {
		this.systemVariablesMap.put(key, value);
	}
    
    /**
    * @methodName     		: getSystemVariable
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 지정한 시스템 변수의 값을 조회하는 메서드 
    * @param key			: 조회할 시스템 변수명
    * @return				: 시스템 변수 값, 존재하지 않으면 null
    * 
    *  [조회 과정]
	 * --------------------------------------------------
	 * getSystemVariable("USER_ID")
	 *          ↓
	 * systemVariables.get("USER_ID")
	 *          ↓
	 * "ADMIN"
	 * --------------------------------------------------
	 * 
	 * 
	 * [사용 예]
	 * --------------------------------------------------
	 * Object userId = getSystemVariable("USER_ID");
	 * String langCd = (String)getSystemVariable("LANG_CD");
	 * --------------------------------------------------
    */
    public Object getSystemVariable(String key) {
    	return this.systemVariablesMap.get(key);
    }
    
    /**
    * @methodName     		: getSystemVariables
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 등록된 모든 시스템 변수 목록을 반환하는 메서드
    * @return				: 등록된 전체 시스템 변수 Map
    * 
    *  [반환 구조]
	 * --------------------------------------------------
	 * USER_ID      -> ADMIN
	 * COMPANY_CD   -> NBDF
	 * LANG_CD      -> ko
	 * CLIENT_IP    -> 192.168.0.10
	 * SESSION_ID   -> XXXXX
	 * --------------------------------------------------
	 * 
	 * [사용 예]
	 * --------------------------------------------------
	 * for (Map.Entry<String, Object> entry : getSystemVariables().entrySet()) {
	 *     System.out.println(entry.getKey());
	 *     System.out.println(entry.getValue());
	 * }
	 * --------------------------------------------------
	 * 
    */
    public Map<String, Object> getSystemVariables() {
    	return getSystemVariables();
    }

    // --------------------------------------------------
    // [5] 사용자 변수
    // --------------------------------------------------

    /**
    * @methodName     		: addUserVariable
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 사용자 변수를 등록하거나 기존 값을 변경하는 메서드
    * @param key			: 사용자 변수명
    * @param value			: 저장할 사용자 변수 값
    * 
    *  [사용 예]  
	 * --------------------------------------------------
	 * addUserVariable("SEARCH_TYPE", "EMP");
	 * addUserVariable("PAGE_NO", 1);
	 * addUserVariable("THEME", "DARK");
	 * --------------------------------------------------
    */
    public void addUserVariable(String key, Object value) {
        this.userVariables.put(key, value);
    }

    /**
    * @methodName     		: getUserVariable
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 지정한 사용자 변수의 값을 조회하는 메서드 
    * @param key			: 조회할 사용자 변수명
    * @return				: 시스템 변수 값, 존재하지 않으면 null
    * 
    *  [조회 과정]
	 * --------------------------------------------------
	 * getUserVariable("PAGE_NO")
	 *          ↓
	 * userVariables.get("PAGE_NO")
	 *          ↓
	 * 1
	 * --------------------------------------------------
	 * 
	 * [사용 예]
	 * --------------------------------------------------
	 * Integer pageNo = (Integer)getUserVariable("PAGE_NO");
	 * String searchType = (String)getUserVariable("SEARCH_TYPE");
	 * --------------------------------------------------
	 * 
    */
    public Object getUserVariable(String key) {
        return this.userVariables.get(key);
    }

    /**
    * @methodName     		: getUserVariables
    * @author         		: Built1
    * @date           		: 2026.07.06
    * @description    		: 등록된 모든 사용자 변수 목록을 반환하는 메서드
    * @return				: 등록된 전체 사용자 변수 Map
    * 
    *  [반환 구조]
	 * --------------------------------------------------
	 * SEARCH_TYPE -> EMP
	 * PAGE_NO     -> 1
	 * THEME       -> DARK
	 * OPTION      -> ALL
	 * --------------------------------------------------
	 * 
	 *
	 * [사용 예]
	 * --------------------------------------------------
	 * for (Map.Entry<String, Object> entry : getUserVariables().entrySet()) {
	 *     System.out.println(entry.getKey());
	 *     System.out.println(entry.getValue());
	 * }
	 * --------------------------------------------------
	 * 
    */
    public Map<String, Object> getUserVariables() {
        return userVariables;
    }
    
    
    // --------------------------------------------------
    // [6] Getter / Setter
    // --------------------------------------------------

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages the messages to set
	 */
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	/**
	 * @return the systemVariablesMap
	 */
	public Map<String, Object> getSystemVariablesMap() {
		return systemVariablesMap;
	}

	/**
	 * @param systemVariablesMap the systemVariablesMap to set
	 */
	public void setSystemVariablesMap(Map<String, Object> systemVariablesMap) {
		this.systemVariablesMap = systemVariablesMap;
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param dataMap the dataMap to set
	 */
	public void setDataMap(Map<String, NBDFTransferData> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * @param userVariables the userVariables to set
	 */
	public void setUserVariables(Map<String, Object> userVariables) {
		this.userVariables = userVariables;
	}
}
