package erp.core.nbdf.exception;

/**
* @packageName    	: erp.core.nbdf.exception
* @fileName       	: NBDFException.java
* @author         	: Built1
* @date           	: 2026.07.03
* @description    	: NBDF 프레임워크 예외 처리 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public class NBDFException extends RuntimeException {

	/**  
	 * <pre>
	 * --------------------------------------------------------------
	 * [1] NBDF Layer Structure
	 * --------------------------------------------------------------
	 * 1. Metadata Layer
	 * 2. Builder Layer
	 * 3. Constants Layer
	 * 4. Exception Layer (Current)
	 * 5. Type Mapping Layer
	 * 6. Utility Layer
	 * 7. Result Layer
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
	 * DAO
	 *      ↓
	 * Exception 발생
	 *      ↓
	 * NBDFException (Current Module)
	 *      ↓
	 * NBDFResult
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
	 * 1. NBDF 프레임워크의 표준 예외 객체를 제공
	 * 2. 시스템 및 업무 예외를 일관된 방식으로 관리
	 * 3. 예외 코드와 메시지를 함께 관리
	 * 4. 원인 예외(Cause)를 보존하여 디버깅을 지원
	 * 5. Result Layer와 연계하여 표준 오류 응답을 제공
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [4] Key Features
	 * --------------------------------------------------------------
	 * 1. 프레임워크 표준 Exception 제공
	 * 2. Exception Code 관리
	 * 3. Message 관리
	 * 4. Cause Exception 유지
	 * 5. 예외 정보의 일관성 유지
	 * 6. 시스템 및 업무 예외 통합 처리
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [5] Design Principles
	 * --------------------------------------------------------------
	 * 1. Exception 표준화
	 * 2. 업무와 시스템 예외의 일관된 관리
	 * 3. Exception 정보의 재사용성 향상
	 * 4. 디버깅 및 유지보수 용이성 확보
	 * 5. Result Layer와의 결합 최소화
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [6] Related Classes
	 * --------------------------------------------------------------
	 * Controller
	 *      ↓
	 * Service
	 *      ↓
	 * DAO
	 *      ↓
	 * NBDFException (Current)
	 *      ↓
	 * NBDFExceptionHandler
	 *      ↓
	 * NBDFResult
	 *      ↓
	 * PlatformData
	 * --------------------------------------------------------------
	 *
	 * --------------------------------------------------------------
	 * [7] Extension Point
	 * --------------------------------------------------------------
	 * 신규 예외 코드, 오류 등급(Level), 오류 유형(Type), 상세 오류 정보 등을
	 * 추가하더라도 NBDFException을 확장하여 프레임워크 전체에 동일한 예외 처리 정책을 적용할 수 있음
	 * --------------------------------------------------------------
	 *
	 * </pre>
	 */
	
	/**
	 * Serializable Version UID
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * 메시지코드
	 */
	private final String messageCode;
	
	/**
	 * 메시지로 전달된 배열
	 * 추출된 메시지 텍스트 치환
	 */
	private final Object[] messageArguments;

	/**
	 * @description    			: 메시지 코드만 지정하여 NBDF 예외를 생성하는 메서드
	 * @param messageCode		: 공통 메시지 코드
	 */
	public NBDFException(String messageCode) {
		super(messageCode);
		this.messageCode = messageCode;
		this.messageArguments = null;
	}
	
	/**
	 * @description    			: 메시지 코드와 치환 변수 지정을 통하여 예외를 생성하는 메서드
	 * @param messageCode  		: 공통 메시지 코드
	 * @param messageArguments	: 메시지 치환에 사용할 인수(배열)
	 */
	public NBDFException(String messageCode, Object... messageArguments) {
		 super(messageCode);
		this.messageCode      = messageCode;
		this.messageArguments = messageArguments;
	}
	
	/**
	 * @description    			: 메시지 코드 및 예외 원인을 전달하는 생성자
	 * @param messageCode		: 메시지 코드
	 * @param cause				: 예외 원인
	 */
	public NBDFException(String messageCode, Throwable cause) {
		super(messageCode, cause);
		this.messageCode = messageCode;
		this.messageArguments = null;
	}
	
	/**
	 * @description    			: 메시지 코드 및 예외 원인을 지정하여 예외를 생성하는 메서드
	 * @param messageCode		: 공통 메시지 코드
	 * @param cause				: 예외 원인
	 * @param messageArguments	: 메시지 치환 변수
	 */	
	public NBDFException(String messageCode, Throwable cause, Object... messageArguments) {
		super(messageCode, cause);
		this.messageCode = messageCode;
		this.messageArguments = messageArguments;
	}
	
	/**
	 * @description    			: 메시지 코드를 반환 
	 * @return 					: 공통 메시지 코드
	 */
	public String getMessageCode() {
		return messageCode;
	}
	
	/**
	 * @description    			: 메시지 치환 변수를 반환
	 * @return 					: 메시지 치환 인수(배열)
	 */
	public Object[] getMessageArguments() {
		return messageArguments;
	}
	
}
