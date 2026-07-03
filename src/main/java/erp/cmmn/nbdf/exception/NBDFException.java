package erp.cmmn.nbdf.exception;

/**
* @packageName    : erp.cmmn.nbdf.exception
* @fileName       : NBDFException.java
* @author         : Built1
* @date           : 2026.07.03
* @description    : NBDF 프레임워크 예외 처리 클래스
* ===========================================================
* DATE              AUTHOR             NOTE
* -----------------------------------------------------------
* 2026.07.03        Built1             최초 생성
*/
public class NBDFException extends RuntimeException {

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
	 * @description    			: 메시지 코드를 전달하는 생성자
	 * @param messageCode		: 예외 코드
	 */
	public NBDFException(String messageCode) {
		super(messageCode);
		this.messageCode = messageCode;
		this.messageArguments = null;
	}
	
	/**
	 * @description    			: 메시지 코드와 치환 변수를 전달하는 생성자
	 * @param messageCode  		: 메시지 코드
	 * @param messageArguments	: 메시지 치환 변수
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
	 * 메시지 코드 및 예외 원인을 전달하는 생성자
	 * @param messageCode		: 메시지 코드
	 * @param cause				: 예외 원인
	 * @param messageArguments	: 메시지 치환 변수
	 */	
	public NBDFException(String messageCode, Throwable cause, Object... messageArguments) {
		super(messageCode, cause);
		this.messageCode = messageCode;
		this.messageArguments = messageArguments;
	}
	
	/**
	 * 메시지 코드를 반환
	 * 
	 * @return 	: 메시지 코드
	 */
	public String getMessageCode() {
		return messageCode;
	}
	
	/**
	 * 메시지 치환 변수를 반환
	 * 
	 * @return 	: 메시지 치환 변수
	 */
	public Object[] getMessageArguments() {
		return messageArguments;
	}
	
}
