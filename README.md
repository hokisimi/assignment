# assignment
# 카카오페이 채용과제과제

# 1. 문제해결 방법

 * 데이터베이스
 > Mysql 데이터베이스를 사용하여 테이블을 생성 후 첨부된 데이터 csv파일을 테이블에 import.

 * 프로젝트 생성과 구조
 > spring boot 프레임워크를 사용하여 톰캣이 내장된 형태의 Maven 프로젝트로 생성.
 > RestController를 사용하여 json 형태로 입출력.

 * 과제문제 해결방식
 
  1번문제)
  
     - 거래금액의 합계를 년도, 계좌번호, 계좌명으로 Group by하여 내림차순으로 정렬한 후 최상위 년도별 한개씩만 추출.
     - 계좌정보와 거래내역 테이블을 Join
     
  2번문제) 
  
      - sql문의 not exists문을 사용하여 거래가 존재하지 않는 계좌정보 추출. 취소거래도 거래이므로 취소거래는 제외.
      - 계좌정보와 거래내역 테이블을 Join
     
   3번문제) 
   
     - 연도, 관리점명, 관리점코드로 Group by하고 년도는 오름차순으로, 합계금액은 내림차순으로 정렬하여 추출.
     - 년도, 관리점명, 관리점코드, 합계금액 필드를 갖는 Domain 객체에 값을 담아 Service에서 Dto객체에 전달.
     - 2018, 2019년 정보로 DTO객체를 2개 생성하여 Domain객체를 Dto객체에 맵핑. Service에서 Dto객체를 반환.
     - 계좌정보와 거래내역과 관리점정보 3개 테이블을 Join
     
   4번문제) 
   
    - 분당점과 판교점이 판교점으로 통페합됨으로써 실제 관리점정보 테이블의 관리점코드는 그대로 두고 
    - Select 문에서 분당점의 관리점코드를 판교점의 관리점코드로 변환한 후 합계금액 추출. ( case문사용 )
    - Domain 객체를 optional로 설정하여 Null이면 DealNotFoundException 에러를 던지도록 함. 
    - DealNotFoundException 에러 발생 시 커스텀하게 정의된 CustResponseEntityExceptionHandler에서 ErrorDetails 객체를 
      리턴하게 하여 NotFound 시 code : 404 , message: br code not found error 가 출력되도록 함.
  
# 2. 테스트
   
 Junit와 mokito 을 이용하여 테스트하여 크게 아래 2가지 기능을 점검함.
  
 > Controller 테스트
   
  Controller만을 테스트하여 4개 api에 대해서 컨트롤러 기능 검증.
    
 > Service 테스트
   
  Service의 함수를 호출하여 실제 함수호출이 이루어졌는지와 결과를 검증.
 
 

# 3. 사용 기술 및 툴

* Spring Boot
* JAVA
* Mockito
* Mysql(Database)
* Mybatis
* STS IDEA 

# 4. 프로젝트 실행환경

Mysql 서버가 설치되어 있어야 하며 src/main/resources/database폴더에 dump된 test.sql을 로컬pc에 복원

명령어 : mysql -u[사용자] -p[비밀번호]  [데이터베이스이름]< [파일이름]
  
mysql의 설정정보는 src/main/resources/application.properties 파일을 수정하시면 됩니다.

# 5. 실행 방법

 - Eclips, STS : FILE -> Import -> Maven -> Existing Maven Projects -> DealQryApplication.class 실행
 - 따로 화면을 구성하지는 않습니다. REST API서버만을 구성.
 - 클라이언트 테스트는 웹브라우저나 POSTMAN 프로그램을 사용.

# 6. 빌드 및 실행파일

- 빌드 : Eclips, STS :Run -> Run Configuration -> Maven Build -> Goals:package 입력, Profiles:'빈칸' -> Run
- 실행 : java -jar JAR파일경로

# 7. API 호출

1번문제 Api호출 경로 (GET)
http://localhost:8090/totalbyyear 

2번문제 Api호출 경로 (GET)
http://localhost:8090/nodealbyyear

3번문제 Api호출 경로 (GET)
http://localhost:8090/totalbyyearNbranch

4번문제 Api호출 경로 (POST)
http://localhost:8090/totalbybranch?brName=판교점



