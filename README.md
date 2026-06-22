# nbdf 프로젝트
[nbdf 프로젝트]
 1. 작업일자 : 2026.06.22
 2. 작업내용
  - .gitignore : commit and push 제외 파일 설정 (cmd 창)
  - E:\nBDF\workspace\nbdf>git rm --cached "src/main/nbdf-ui/$Geninfo$.geninfo"
  - E:\nBDF\workspace\nbdf>git rm --cached "target/m2e-wtp/web-resources/META-INF/maven/com.nbdf/nbdf/pom.properties"
  
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
