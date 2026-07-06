package erp.core.nbdf.result;

import java.io.Serializable;
import java.util.ArrayList;
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
	private Map<String, Object> variables = new HashMap<>();
	
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
}
