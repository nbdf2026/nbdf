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
	 * NBDF Framework Layer
	 * --------------------------------------------------------------
	 * 1. Metadata Layer
	 * 2. Builder Layer
	 * 3. Constants Layer
	 * 4. Exception Layer
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
	 * 7. Result Layer(현재)
	 * 8. Message Layer
	 * 9. Validation Layer
	 * 10. Converter Layer
	 * --------------------------------------------------------------
	 * </pre>
	 */
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * NBDFResult 설계 흐름도
	 * --------------------------------------------------------------
	 * Controller
	 *       ↓
	 * Service
	 *       ↓
	 * NBDFResult (현재)`
	 *       ↓
	 * NBDFTransferData
	 *       ↓
	 * PlatformData
	 *       ↓
	 * Nexacro
	 * 
	 * </pre>
	 */
	
	/**
	 * <pre>
	 * --------------------------------------------------------------
	 * Controller와 Service 사이의 표준 반환 객체로 사용
	 * --------------------------------------------------------------
	 * 
	 * 1. 처리 성공/실패 상태 저장
	 * 2. 메시지 번호 저장
	 * 3. 메시지 내용 저장
	 * 4. 전송 데이터 저장
	 *  
	 * </pre> 
	 */
	
	/*
	 * 주석 작성 기준
	 * get 		→ 조회합니다.
	 * set 		→ 할당합니다.
	 * add 		→ 추가합니다.
	 * remove 	→ 삭제합니다.
	 * build 	→ 생성합니다.
	 * convert 	→ 변환합니다.
	 * validate → 검증합니다.
	 * parse 	→ 분석합니다.
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
