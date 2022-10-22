
/*  1. 호환성을위해 테이블 및 행렬, 기타 내용의 영문작성을 원칙으로하나
    과정의 학습이해와 습득평가의 내용이 '웹사이트에 필요한 데이터베이스의
    설계'라면 설계자와 평가자의 설계의 이해를 돕기위해 한글의 호환 사용
    하는것이  평가주제의 논지에 어긋나지 않을 것으로 판단되는바 편의상 
    직접구문 외의 내용은 한글사용을 혼용하고 있다는것을 양지하여
    주시기를 바랍니다.
    
    2. 사용 구문
        Data Type   Integer()
                    Number()
                    Char()
                    Varchar2()
                    Nchar()
                    Nvarchar2()
                    Clob
                    Date
        
        Unique Key  Primary key
                    Unique


        select - from - where -;
                - as

        create user - identified by -
            default tablespace users
            temporary tablespace temp;

        grant -, - to -

        create table - (
        );


*/

create user BOOKSTORE identified by 1234
    default tablespace USERS
    temporary tablespace TEMP;
grant connect, resource to BOOKSTORE;


create table DeliverInformation (
	--aaa      bbb  cc      dd       ee         123456
    --국가번호 도시 주문년  주문주차 주문자구분 주문번호
	DI_Number		char(16)		not null enable,
	MS_Number		char(16)		not null enable,
	BI_Number		char(16)		not null enable,
	DD_Number		char(16)		not null enable,
	PI_number		char(16)		not null enable
	);
select DI_Number 주문정보  from DeliverInformation;


create table BookInformation (
    -- aaa      bb       ccc      d                   123.1     00
    -- 국가번호 발행년도 언어약어 지점층(지상G,지하B) KDC       기타분류
	ean_13              integer         primary key,
    ean_5               integer,
    발행언어            char(3)         not null,
    발행국가            varchar2(3),     
	제목                nvarchar2(200)  Unique,
	저자                nvarchar2(200),
	편집자              nvarchar2(200)  not null,
	역자                nvarchar2(20)   not null,
	발행인              nvarchar2(20)   not null,
	판매가              integer        not null,
	Page                integer
);
select ean_13 국제표준도서번호, ean_5 국제표준도서부가번호  from BookInformation;


create table 국가코드테이블 (
    국가명                  varchar2(28),
    국가코드KICA            integer,
    국가코드DAC             varchar2(3),
    국가코드ISO_NUMBERIC    varchar2(3)     primary key,
    국가코드ISO_ALPHA2      varchar2(3),
    국가코드ISO_ALPHA3      varchar2(3)
);


create table MemberShip (
    --a         bb      cc      d    00000 
    --내외국인  가입년 가입주차 등급 무작위번호
	회원번호		    nvarchar2(20)  primary key,
	아이디  		    nvarchar2(24)  primary key,
	비밀번호		    nvarchar2(32)  not null,
	이름			    nvarchar2(14)  not null,
	주민등록번호        nchar(28) 		primary key,
	휴대전화			nchar(26) 		Primary key,
	전화번호			nvarchar2(40),
	이메일	    		nvarchar2(50)   unique,
	주소	    		nvarchar2(70)	not null,
    출생년도	    	integer	not null,
    성별		        char(6)
);


create table 사원 (
    --지역 지점 부서
    지역        Nvarchar2(14)  not null,
    지점번호    Integer     not null,
    부서        Nvarchar2(20)  not null,
    직급        Nvarchar2(8)   not null,
    입사번호    Integer     Primary key

);
select 지역 || 지점번호 || 부서 || 직급 || 입사번호 as 사원번호
    form 사원;
create table 지역 (
    지역번호    Nchar(3)        primary key,
    지역        Nvarchar2(14)  
);
Insert Into 지역 Values ('02', '서울특별시, 광명시, 과천시');
Insert Into 지역 Values ('031', '경기도');
Insert Into 지역 Values ('032', '인천광역시, 부천시');
Insert Into 지역 Values ('033', '강원특별자치도');
Insert Into 지역 Values ('041', '충청남도');
Insert Into 지역 Values ('042', '대전광역시, 계룡시');
Insert Into 지역 Values ('043', '충청북도');
Insert Into 지역 Values ('044', '세종특별자치시');
Insert Into 지역 Values ('051', '부산광역시');
Insert Into 지역 Values ('052', '울산광역시');
Insert Into 지역 Values ('053', '대구광역시, 경산시');
Insert Into 지역 Values ('054', '경상북도');
Insert Into 지역 Values ('055', '경상남도');
Insert Into 지역 Values ('061', '전라남도');
Insert Into 지역 Values ('062', '광주광역시, 전라북도');
Insert Into 지역 Values ('064', '제주특별자치도');


create table 지점 (
    지점명      Nvarchar2(20),
    지점번호    Integer     primary key,
    지역번호    Nchar(6)       not null,
    지점장      Nvarchar2(7)   not null,
    지점장실    Nchar(13)      not null,
    부지점장    Nvarchar2(7)   not null,
    부지점장실  Nchar(13)      not null,
    조직연락망  Clob
);
    
create table 부서 (
    부서번호    Integer         primary key,
    부서명      Nvarchar2(20)   not null,
    최상위부서  Nvarchar2(20)   Unique
);
    

create table 사원정보  (
    -- aa bb cc 0000
    사원번호            char(10),
    직책                Nvarchar2(20),
    입사                Date,
    퇴사                Date,
	이름			    nvarchar2(14)   not null,
	주민등록번호        nchar(28) 		primary key,
	휴대전화			nchar(26) 		not null,
	전화번호			nvarchar2(40),
	이메일	    		nvarchar2(50),
	주소	    		nvarchar2(70)	not null
    출생년도(나이)		Integer	not null
    성별		        char(6)	not null
    자격면허코드        Integer               
    이력
);


create table Inventory_Quantity (
	Inventory_Quantity
	Inventory_Point
	Inventory_location

create table Selling_Price (
	Selling_Price
	Fixed_Price
	Discounted_Price

create table DeliveryDestination (
	DD_Number		char(16)
	DT_Number		Number

create table DeliveryType (

이동준 C# 6월 2일~6월24일 목금 8일 스마트팩토리 
데이터베이스 정규화 검색

