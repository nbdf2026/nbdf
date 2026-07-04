# nbdf 프로젝트
[nbdf 프로젝트]
 1. 작업일자 : 2026.07.04
 2. 작업내용
  - scr/main/java/erp : nbdf core 폴더로 이동 분리
    : nbdf framework 구성
    : nbdf utility 폴더 구성 (기존 전자정보 프레임워크에서 제공된 핸들러 귀속)
  - Eclipse Java template : XML 파일 Import
  - NBDFTransferDataBuilder : NBDF 전송 데이터(TransferData)를 생성하는 Builder 클래스中
  - NBDF Framework 주석 조정 및 상세화 작업
  - NBDF Framework 주석 조정에 따른 JavaDOC 생성 테스트
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.07.03
 2. 작업내용
  - NBDFMetaDataReader : ResultSetMetaData를 읽어 NBDFColumn 목록을 생성하는 클래스
  - NBDFDataSetBuilder : NBDF 메타정보와 조회 데이터를 Nexacro DataSet으로 생성하는 Builder 클래스
  - UserDbException : 폴더 및 명칭 변경(exception\UserException.java -> dbexception\UserDbException.java)
  - NBDFTransferDataBuilder : NBDF 전송 데이터(TransferData)를 생성하는 Builder 클래스 작업中
  - NBDF Framework 클래스 주석 일괄 변경
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.07.01
 2. 작업내용
  - NBDFConstants 	: NBDF 프레임워크 전체에서 공통으로 사용하고 변경되지 않는 기준값을 관리하는 클래스
  - NBDFJavaType	: Java 데이터 유형을 관리하는 클래스
  - NBDFNexacroType	: Nexacro 데이터셋 데이터 유형을 관리하는 클래스
  - NBDFColumn		: 데이터셋 컬럼정보를 관리하는 메타 객체 클래스
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.07.01
 2. 작업내용
  - 쿼리 파싱할 경우 2번 나오은 문제로 인하여 
  - nbdf core 자바 프레임워크 작업 후 넥사크로 객체 대체 예정
  - NBDFConstants 클래스 작업 완료 : Dataset Column 정보를 관리하는 공통 Metadata 객체
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.30
 2. 작업내용
  - 로그인 사용자정보(사용자+인사정보+발령정보) 조회 추가 및 gds_user 반영
  - 로그인 사용자정보 application variable 등록(userId, userName, userEmailAddress, userMobileNumber)
  - COM10010M : 자바 메서드 및 인터페이스 자동 주석 처리
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.30
 2. 작업내용
  - 공통 라이브러리 재설정
  - 사용자 매뉴얼 업데이트 : 빌트원-Nexacro N v24-nBDF_20260428_v0.58.pptx
  - COM10020M : 사용자 프로그램 개발 예정 / 로그인에 따른 세션변수 초기화 및 값할당
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.29
 2. 작업내용
  - 사용자 테이블 생성
  - 비밀번호, 이메일, 전화번호 암호화 처리
  - COM10020M : 사용자 프로그램 개발 예정
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.29
 2. 작업내용
  - DB 암복호화 함수 생성
    : encrypt_f, decrypt_f, encrypt_password_f
  - 깃 제외 파일 등록 : *.~sql, *.~pdc)
  - nbdf db 디렉터리 재정리
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.29
 2. 작업내용
  - gds_message 공통 메시지 함수 처리 완료(Alert, Confirm)
    : 별도 팝업 작성하여 메시지 출력으로 변경 예정
  - gfn_msgBox : 넥사크로 공통 메시지 함수 추가
  - COM10020M : 사용자정보 추가 예정 및 단방향 암호화 적용
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.28
 2. 작업내용
  - COM10010M : 로그인 후 메시지 데이터 gds_message 복제
  - gds_message 공통 메시지 함수 처리 예정 (단변적인 부분은 테스트 완료)
  - 암복호화 : 암호화/보호화(양방향), 암호호(단방향) plsql function 개발완료
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.24
 2. 작업내용
  - 메시지 테이블 생성
  - 메시지 데이터 추가 및 스크립트 작성
  - COM10010M : 메시지등록 자바 프로그램 완료 / 넥사크로 프로그램 개발 예정
  - 로그인 완료 후 gds_message 데이터셋에 적재 및 화면에서 메시지번호로 조회 후 출력 (미진행)
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.22
 2. 작업내용
  - 넥사크로 공통함수 추가 및 include 처리 (pFORM으로 전환 예정)
  - 콘솔 파싱된 쿼리 문장 정규화 (SELECT / UPDATE / DELETE) 처리
  - INSERT 작업 예정 (미진행)
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.22
 2. 작업내용
  - .gitignore : commit and push 제외 파일 설정 (cmd 창)
  - E:\nBDF\workspace\nbdf>git rm --cached "src/main/nbdf-ui/$Geninfo$.geninfo"
  - E:\nBDF\workspace\nbdf>git rm --cached "target/m2e-wtp/web-resources/META-INF/maven/com.nbdf/nbdf/pom.properties"
  
  - .gitignore : commit and push 제외 파일 설정 (bash 창)
  - git rm -r --cached target
  - git rm --cached .factorypath
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.21
 2. 작업내용
  - PLSQL : ini or beautifier rules 파일 추가
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.18
 2. 작업내용
  - spy.properties : 콘솔 쿼리 파싱시 줄간격/매개변수 파싱 처리를 위한 프로퍼티 추가
  - @Slf4j : logger 출력을 어노테스이션으로 처리
  - COM10000M : 삭제 처리 로직 추가
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.18
 2. 작업내용
  - COM10000M : 공통코드조회 추가
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.18
 2. 작업내용
  - RefreshableSqlSessionFactoryBean : 전자정부 4.3.1 - XML 변경 자동 반영을 위한 클래스 추가
  - database.properties : 데이터베이스 프로퍼티 방식으로 설정 변경
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.18
 2. 작업내용
  - 데이터베이스, 사용자, 테이블 스크립트 추가
  
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.18
 2. 작업내용
  - 사용자 매뉴얼 수정 
    : 토큰정보가 존재하여 토큰 초기화로 push 진행 불가
    : 토큰 재발행 후 push 처리
    : 매뉴얼에 토큰정보는 이전 토근으로 push 진행 불가
    : 요청시 개별적으로 토근 공유
