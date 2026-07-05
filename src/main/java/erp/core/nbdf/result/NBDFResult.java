package erp.core.nbdf.result;

import java.io.Serializable;

/**
* @packageName    	: erp.core.nbdf.result
* @fileName       	: NBDFResult.java
* @author         	: Built1
* @date           	: 2026.07.04
* @description    	: 서비스 처리 결과를 저장하는 표준 반환 객체 클래스
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
	 *      ↓
	 * Service
	 *      ↓
	 * NBDFResult (Current Module)
	 *      ↓
	 * NBDFTransferData
	 *      ↓
	 * PlatformData
	 *      ↓
	 * HttpPlatformResponse
	 *      ↓
	 * Nexacro Client
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
	 * [7] Comment rules
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
	 * </pre>
	 */
	
	/**
	 * Serializable Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 처리결과
	 */
	private String result;
	
	/**
	 * 메시지 번호 
	 */
	private String messageNo;
	
	/**
	 * 메시지
	 */
	private String message;
	
	/**
	 * 전송 데이터 : 아직 구현되지 않음
	 */
	//private NBDFTransferData transferData;
	
	
	/**
     * 기본 생성자
     */
    public NBDFResult() {
    	
    }

	/**
	 * @description    	: 처리결과 값을 조회하는 메서드 
	 * @return 			: 처리결과 값
	 */
	public String getResult() {
		return result;
	}
    
	/**
	 * @description    	: 처리결과 값을 할당하는 매서드
	 * @param result 	: 처리결과
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @description    	: 메시지번호 조회하는 메서드
	 * @return 			: 메시지번호
	 */
	public String getMessageNo() {
		return messageNo;
	}

	/**
	 * @description    	: 메시지번호 값을 할당하는 메서드 
	 * @param messageNo : 메시지번호
	 */
	public void setMessageNo(String messageNo) {
		this.messageNo = messageNo;
	}

	/**
	 * @description    	: 메시지 텍스트를 조회하는 메서드
	 * @return 			: 메시지 텍스트
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @description    	: 메시지 텍스트 할당하는 메소드
	 * @param message 	: 메시지 텍스트
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
     * @description    	: 전송 데이터를 조회하는 메소드
     * @return 			: 전송 데이터
     */
    //public NBDFTransferData getTransferData() {
    //    return transferData;
    //}

    /**
     * @description    		: 전송 데이터를 할당하는 메소드
     * @param transferData	: 전송 데이터
     */
    //public void setTransferData(NBDFTransferData transferData) {
    //    this.transferData = transferData;
    //}
}
