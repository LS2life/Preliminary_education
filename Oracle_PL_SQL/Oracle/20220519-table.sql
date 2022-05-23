-- p316
create user tableDB identified by 1234
default tablespace users
temporary tablespace temp;

grant connect,resource,dba to tableDB;

-- sql로 테이블 생성
-- create table tableName(
-- columnName datatype constraint,
-- columnName datatype constraint,
-- ...
--)
-- 오라클 데이터 타입
-- 숫자 number(p,[s]) p 전체 자릿수,s 소수점 이하 자릿수
-- binary_double 64bit 부동소수점(실수)
-- 문자
-- char[(n)] 1~2000
-- nchar[(n)] 유니코드 1~1000, 한글, 2byte ex)nchar(20) 10자->20byte
-- varchar2(n) 가변길이 1~4000 varchar2(10)->10자,"abc" ->3byte
-- nvarchar2(n) 유니코드 1~2000
-- 날짜와 시간 형식
-- date
-- timestamp
-- 제약 조건
-- primary key -주키, 기본키
-- 회원 테이블-회원 아이디, 학생 테이블-학번, 직원 테이블-사전
-- not null - 없음을 허용하지 않습니다
-- 중복 허용 안함
-- 외래키
-- 다른 테이블의 주키를 자기 테이블에서 참조
-- 예)usertbl 기준테이블, buytbl 외래키 테이블
-- 기준테이블 PK, Unique
-- Unique 제약 조건
-- 중복 허용 불가 - 중복되지 않는 유일한 값
-- null 비어 있는 값은 허용
-- check 제약 조건
-- age number(100) check(age>=0)
-- default 제약 조건
-- addr nchar(2) default '서울'
-- null 제약 조건
-- email nchar(50) null
-- email nchar(50) not null
create table userTBL(
    userID char(8) primary key,
    userName nvarchar2(10) not null,
    birthYear number(4) not null,
    addr nchar(2) not null,
    mobile1 char(3) null,
    mobile2 char(8),
    height number(3),
    mDate DATE
);
--회원 구매 테이블
create table buyTBL(
    idNum number(8) primary key,
    --userID char(8) references userTBL(userID),--외래키
    userID char(8) not null,
    prodName nchar(6) not null,
    groupName nchar(4),
    price number(8) not null,
    amount number(3) not null,
    foreign key (userID) references userTBL(userID)
);

insert into userTBL 
values('LSG','이승기',1987,'서울','011','11111111',182,'2008-8-8');
select * from userTBL;
insert into userTBL 
values('KBS','김범수',1979,'서울','011','11111111',173,'2012-4-4');
--테이블 삭제
drop table buyTBL;
-- idNum primary key 순차적으로 1씩 ++
create sequence idSEQ;
-- idSEQ++
insert into buytbl values(idSEQ.NEXTVAL,'KBS','운동화',null,30,2);
insert into buytbl values(idSEQ.NEXTVAL,'KBS','운동화','',30,2);
-- 테이블 수정
-- alter table
-- 열 추가
alter table userTBL
    add homepage varchar(30)
    default 'http://www.naver.com'
    null;
alter table userTBL
    add(homepage nvarchar2(20),
    postNum varchar(5));
-- 열 삭제
alter table userTBL
    drop column homepage;
-- 열의 이름 변경
alter table userTBL
    rename column userName to uName;
-- 열의 데이터 형식 변경
alter table userTBL
    modify (addr nvarchar2(10) null);
-- 열의 제약 조건 추가 및 삭제
alter table buyTBL
    drop constraint sys_c007053;
alter table userTBL
    drop primary key;
-- p349 테이블 생성 p350 데이터 삽입
    
select * from user_constraints
where owner='tableDB' and
table_name='buyTBL';

DROP TABLE buyTbl;
DROP TABLE userTbl;

CREATE TABLE userTBL 
( userID  	CHAR(8),
  userName  	NVARCHAR2(10),
  birthYear 	NUMBER(4),
  addr	  	NCHAR(2),
  mobile1	CHAR(3),
  mobile2	CHAR(8),
  height    	NUMBER(3),
  mDate    	DATE
);
CREATE TABLE buyTBL
(  idNum 	NUMBER(8) PRIMARY KEY,
   userID  	CHAR(8),
   prodName 	NCHAR(6),
   groupName 	NCHAR(4),
   price     	NUMBER(8),
   amount    	NUMBER(3)
);
DROP SEQUENCE idSEQ;
CREATE SEQUENCE idSEQ;

INSERT INTO userTBL VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO userTBL VALUES('KBS', '김범수', NULL, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO userTBL VALUES('KKH', '김경호', 1871, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO userTBL VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL,'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL,'JYP', '모니터', '전자', 200,  1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL,'BBK', '모니터', '전자', 200,  5);

-- 회원 primary key 삽입
alter table userTBL
    add constraint pk_usertbl_userid
    primary key (userid);
--구매 테이블 외래키 설정
alter table buytbl
    add constraint fk_usertbl_buytbl
    foreign key (userid)
    references usertbl (userid);
delete from buytbl where userid='BBK';
-- 제약조건 임시 중지
alter table buytbl
    disable constraint fk_usertbl_buytbl;
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL,'BBK', '모니터', '전자', 200,  5);
-- 제약조건 회복
alter table buytbl
    enable novalidate constraint fk_usertbl_buytbl;
insert into usertbl 
values('BBK','바비킴',1973,'서울','010','00000000',176,'2013-5-5');
-- 바비킴이 회원 탈퇴
delete from usertbl where userid='BBK';
-- 회원탈퇴 버튼->백엔드 자바 구매테이블 삭제, 회원테이블
alter table buytbl
drop constraint fk_usertbl_buytbl;
alter table buytbl
    add constraint fk_usertbl_buytbl
    foreign key (userid)
    references usertbl (userid)
    on delete cascade;
-- on delete cascade 연관된 외래키를 가지고 있는 테이블의 데이터가 동시 삭제
alter table usertbl
drop column birthyear;
--칼럽이 삭제 되면서 제약 조건도 모두 삭제






























