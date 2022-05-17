/*
   [이것이 Oracle이다] 소스 코드
   8장. 테이블과 뷰
*/

------------------------------------
-- 8.1 테이블
------------------------------------

----------------- <실습 1> -------------------

CREATE USER tableDB IDENTIFIED BY 1234 -- 사용자 이름: tableDB, 비밀번호 : 1234
   DEFAULT TABLESPACE USERS
   TEMPORARY TABLESPACE TEMP;

GRANT connect, resource, dba TO tableDB ;

CREATE TABLE test (idNum NUMBER(5));

----------------- </실습 1> -------------------

----------------- <실습 2> -------------------
DROP TABLE buyTBL;
DROP TABLE userTBL;
DROP SEQUENCE idSEQ;


CREATE TABLE userTBL -- 회원 테이블
( userID  	CHAR(8), -- 사용자 아이디(PK)
  userName  	NVARCHAR2(10), -- 이름
  birthYear 	NUMBER(4),  -- 출생년도
  addr	  	NCHAR(2), -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(010, 011, 016, 017, 018, 019 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	NUMBER(3),  -- 키
  mDate    	DATE  -- 회원 가입일
);
CREATE TABLE buyTBL -- 회원 구매 테이블
(  idNum 	NUMBER(8), -- 순번(PK)
   userID  	CHAR(8), -- 아이디(FK)
   prodName 	NCHAR(6), --  물품명
   groupName 	NCHAR(4), -- 분류
   price     	NUMBER(8), -- 단가
   amount    	NUMBER(3) -- 수량
);

DROP TABLE buyTBL;
DROP TABLE userTBL;
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL 
);
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL,
   userID  	CHAR(8)  NOT NULL, 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
);

DROP TABLE buyTBL;
DROP TABLE userTBL;
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL PRIMARY KEY,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL 
);
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL, 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
);

DROP TABLE buyTBL;
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL, 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
   , FOREIGN KEY(userID) REFERENCES userTBL(userID)
);

CREATE SEQUENCE idSEQ;

INSERT INTO userTBL VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO userTBL VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO userTBL VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');

INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '운동화', NULL, 30, 2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'JYP', '모니터', '전자', 200, 1);

INSERT INTO userTBL VALUES('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4');
INSERT INTO userTBL VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO userTBL VALUES('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9');
INSERT INTO userTBL VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO userTBL VALUES('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3');
INSERT INTO userTBL VALUES('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10');
INSERT INTO userTBL VALUES('BBK', '바비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '운동화', NULL   , 30,   2);

----------------- </실습 2> -------------------

SELECT * FROM USER_CONSTRAINTS  -- 키 정보가 등록된 테이블
    WHERE OWNER='TABLEDB' AND 
          TABLE_NAME='USERTBL'  AND
          CONSTRAINT_TYPE='P';  -- P는 기본키, R은 외래키, C는 NOT NULL 또는 CHECK

DROP TABLE userTBL CASCADE CONSTRAINTS; -- 외래키 제약조건이 있어도 삭제
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL CONSTRAINT PK_userTBL_userID PRIMARY KEY ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL 
);


SELECT * FROM USER_CONSTRAINTS  -- 키 정보가 등록된 테이블
    WHERE OWNER='TABLEDB' AND 
          TABLE_NAME='USERTBL'  AND
          CONSTRAINT_TYPE='P';  -- P는 기본키, R은 외래키, C는 NOT NULL 또는 CHECK

DROP TABLE userTBL CASCADE CONSTRAINTS; 
CREATE TABLE userTBL
( userID  	CHAR(8) NOT NULL , 
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL
  , CONSTRAINT PK_userTBL_userID PRIMARY KEY (userID)
);

DROP TABLE userTBL CASCADE CONSTRAINTS; 
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL 
); 
ALTER TABLE userTBL
	ADD CONSTRAINT PK_userTBL_userID 
        PRIMARY KEY (userID);

CREATE TABLE prodTbl
( prodCode CHAR(3) NOT NULL,
  prodID   CHAR(4)  NOT NULL,
  prodDate DATE  NOT NULL,
  prodCur  CHAR(10) NULL
);
ALTER TABLE prodTbl
	ADD CONSTRAINT PK_prodTbl_proCode_prodID 
	PRIMARY KEY (prodCode, prodID) ;

DROP TABLE prodTbl;
CREATE TABLE prodTbl
( prodCode CHAR(3) NOT NULL,
  prodID   CHAR(4)  NOT NULL,
  prodDate DATE NOT NULL,
  prodCur  CHAR(10) NULL
  , CONSTRAINT PK_prodTbl_prodCode_prodID PRIMARY KEY (prodCode, prodID)
);

DROP TABLE buyTBL;
DROP TABLE userTBL;
CREATE TABLE userTBL 
(  userID  	CHAR(8) NOT NULL PRIMARY KEY ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL 
);
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL  REFERENCES userTBL(userID), 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
);

DROP TABLE buyTBL;
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL 
        CONSTRAINT FK_userTBL_buyTBL  REFERENCES userTBL(userID), 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
);

DROP TABLE buyTBL;
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL, 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
   , CONSTRAINT FK_userTBL_buyTBL FOREIGN KEY(userID) REFERENCES userTBL(userID)
);

DROP TABLE buyTBL;
CREATE TABLE buyTBL 
(  idNum 	NUMBER(8)  NOT NULL  PRIMARY KEY,
   userID  	CHAR(8)  NOT NULL, 
   prodName 	NCHAR(6)  NOT NULL,
   groupName 	NCHAR(4)  NULL, 
   price     	NUMBER(8) NULL,
   amount    	NUMBER(3)  NOT NULL
);
ALTER TABLE buyTbl
    ADD CONSTRAINT FK_userTbl_buyTbl 
    FOREIGN KEY (userID) 
    REFERENCES userTBL(userID) ;

ALTER TABLE buyTBL
	DROP CONSTRAINT FK_userTBL_buyTBL; -- 외래 키 제거
ALTER TABLE buyTBL
	ADD CONSTRAINT FK_userTBL_buyTBL
	FOREIGN KEY (userID)
	REFERENCES userTBL (userID)
	ON DELETE CASCADE ;
    
DROP TABLE userTbl CASCADE CONSTRAINTS;
CREATE TABLE userTBL 
(  userID  	CHAR(8) NOT NULL ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL,
  email     CHAR(30) NULL  UNIQUE
); 

DROP TABLE userTbl CASCADE CONSTRAINTS;
CREATE TABLE userTBL 
(  userID  	CHAR(8) NOT NULL ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL,
  email     CHAR(30) NULL
  , CONSTRAINT AK_email UNIQUE (email)
);

DROP TABLE userTbl CASCADE CONSTRAINTS;
CREATE TABLE userTBL 
(  userID  	CHAR(8) NOT NULL ,
  userName  	NVARCHAR2(10) NOT NULL,
  birthYear 	NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height    NUMBER(3) NULL, 
  mDate    	DATE  NULL,
  email     CHAR(30) NULL
); 
ALTER TABLE USERTBL
    ADD CONSTRAINT AK_EMAIL UNIQUE (EMAIL);
   

-- 키는 0이상이어야 함.
ALTER TABLE userTbl
	ADD CONSTRAINT CK_height
	CHECK   (height >= 0) ;

-- 휴대폰 국번 체크
ALTER TABLE userTbl
	ADD CONSTRAINT CK_mobile1
	CHECK  (mobile1 IN ('010','011','016','017','018','019')) ;

-- 휴대폰 국번 체크 (기존 무시)
ALTER TABLE userTbl
	ADD CONSTRAINT CK_mobile1_new
	CHECK  (mobile1 IN ('010','011','016','017','018','019')) 
	ENABLE NOVALIDATE ;

DROP TABLE userTbl CASCADE CONSTRAINTS;
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL PRIMARY KEY ,
  userName  	NVARCHAR2(10) NOT NULL ,
  birthYear 	NUMBER(4) DEFAULT -1 NOT NULL ,  
  addr	  	NCHAR(2) DEFAULT '서울' NOT NULL ,
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height	NUMBER(3) DEFAULT 170 NULL,
  mDate    	DATE  NULL 
);

DROP TABLE userTbl CASCADE CONSTRAINTS;
CREATE TABLE userTBL 
( userID  	CHAR(8) NOT NULL PRIMARY KEY ,
  userName  	NVARCHAR2(10) NOT NULL ,
  birthYear 	NUMBER(4) NOT NULL ,  
  addr	  	NCHAR(2) NOT NULL ,
  mobile1	CHAR(3) NULL,
  mobile2	CHAR(8) NULL,
  height	NUMBER(3) NULL,
  mDate    	DATE  NULL 
);
ALTER TABLE userTBL
	MODIFY birthYear DEFAULT -1;
ALTER TABLE userTBL
	MODIFY addr DEFAULT '서울';
ALTER TABLE userTBL
	MODIFY height DEFAULT 170;

-- default 문은 DEFAULT로 설정된 값을 자동 입력한다.
INSERT INTO userTBL VALUES ('LHL', '이혜리', DEFAULT, DEFAULT, '011', '1234567', DEFAULT, '2019.12.12');
-- 열이름이 명시되지 않으면 DEFAULT로 설정된 값을 자동 입력한다
INSERT INTO userTBL(userID, userName) VALUES('KAY', '김아영');
-- 값이 직접 명기되면 DEFAULT로 설정된 값은 무시된다.
INSERT INTO userTBL VALUES ('WB', '원빈', 1982, '대전', '019', '9876543', 176, '2020.5.5');
SELECT * FROM userTBL;

INSERT INTO userTBL(userID, userName, mobile1) VALUES('MGG', '마징가', NULL);
INSERT INTO userTBL(userID, userName, mobile1) VALUES('MKD', '메칸더', '');
INSERT INTO userTBL(userID, userName, mobile1) VALUES('JJK', '짱가', ' ');

----------------- <실습 3> -------------------

-- (워크시트 1)
CREATE GLOBAL TEMPORARY TABLE tempTBL (id CHAR(8), uName NCHAR(10));

SELECT TABLE_NAME, TEMPORARY FROM USER_TABLES; 

INSERT INTO tempTBL VALUES('Thomas', '토마스');
INSERT INTO tempTBL VALUES('James', '제임스');
SELECT * FROM tempTBL;

COMMIT;
SELECT * FROM tempTBL;

-- (워크시트 2)
CREATE GLOBAL TEMPORARY TABLE tempTBL2 (id CHAR(8), uName NCHAR(10))
     ON COMMIT PRESERVE ROWS;
INSERT INTO tempTBL2 VALUES('Arthur', '아서');
INSERT INTO tempTBL2 VALUES('Murdoch', '머독');

COMMIT;
SELECT * FROM tempTBL2;

SELECT * FROM tempTBL2;

DROP TABLE tempTBL;
DROP TABLE tempTBL2;
----------------- </실습 3> -------------------

ALTER TABLE userTBL
	ADD homepage VARCHAR(30)  -- 열 추가
		DEFAULT 'http://www.hanbit.co.kr' -- 디폴트값
		NULL; -- Null 허용함

ALTER TABLE userTBL
	ADD (homeAddr  NVARCHAR2(20), postNum VARCHAR(5) );

ALTER TABLE userTBL
	DROP COLUMN homeAddr;

ALTER TABLE userTBL
	DROP (homepage, postNum);

ALTER TABLE userTBL
	RENAME COLUMN userName TO uName;
    
ALTER TABLE userTBL
	MODIFY (addr NVARCHAR2(10) NULL);

ALTER TABLE userTBL
	DROP PRIMARY KEY;

ALTER TABLE buyTBL
	DROP CONSTRAINT SYS_C007801;

----------------- <실습 4> -------------------

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

ALTER TABLE userTBL
	ADD CONSTRAINT PK_userTBL_userID
	PRIMARY KEY (userID);

SELECT * FROM USER_CONSTRAINTS 
    WHERE OWNER='TABLEDB' AND TABLE_NAME='USERTBL' AND CONSTRAINT_TYPE='P';
DESCRIBE userTBL;

ALTER TABLE buyTBL
	ADD CONSTRAINT FK_userTBL_buyTBL
	FOREIGN KEY (userID)
	REFERENCES userTBL (userID);
    
DELETE FROM buyTBL WHERE userID = 'BBK';
ALTER TABLE buyTBL
	ADD CONSTRAINT FK_userTBL_buyTBL
	FOREIGN KEY (userID)
	REFERENCES userTBL (userID);
    
ALTER TABLE buyTBL
    DISABLE CONSTRAINT FK_userTBL_buyTBL;
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'BBK', '운동화', NULL   , 30,   2);
ALTER TABLE buyTBL
    ENABLE NOVALIDATE CONSTRAINT FK_userTBL_buyTBL;

ALTER TABLE userTBL
	ADD CONSTRAINT CK_birthYear
	CHECK  (birthYear >= 1900 AND birthYear <= 2017)
	ENABLE;

ALTER TABLE userTBL
	ADD CONSTRAINT CK_birthYear
	CHECK  (birthYear >= 1900 AND birthYear <= 2017)
	ENABLE NOVALIDATE ;
    
INSERT INTO userTBL VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL , 186, '2013-12-12');
INSERT INTO userTBL VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO userTBL VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL , 170, '2005-5-5');
INSERT INTO userTBL VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO userTBL VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO userTBL VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
    
DELETE FROM userTBL WHERE userID = 'BBK';

ALTER TABLE buyTBL
	DROP CONSTRAINT FK_userTBL_buyTBL;
ALTER TABLE buyTBL 
	ADD CONSTRAINT FK_userTBL_buyTBL
		FOREIGN KEY (userID)
		REFERENCES userTBL (userID)
		ON DELETE CASCADE;

DELETE FROM userTBL WHERE userID = 'BBK';
SELECT * FROM buyTBL;

ALTER TABLE userTBL
	DROP COLUMN birthYear ;

----------------- </실습 4> -------------------

------------------------------------
-- 8.2 뷰 (View)
------------------------------------

CREATE VIEW v_userTBL
AS
	SELECT userID, userName, addr FROM userTBL;

SELECT * FROM v_userTBL;  -- 뷰를 테이블이라고 생각해도 무방

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS "연락처"
FROM userTBL U
  INNER JOIN buyTBL B
     ON U.userID = B.userID ;

CREATE OR REPLACE VIEW v_userbuyTBL
AS
  SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS "연락처"
  FROM userTBL U
    INNER JOIN buyTBL B
       ON U.userID = B.userID ;

SELECT * FROM v_userbuyTBL WHERE userName = '김범수';


----------------- <실습 5> -------------------

CREATE OR REPLACE VIEW v_userbuyTBL
AS
   SELECT U.userID AS "USER ID", U.userName AS "USER NAME", B.prodName AS "PRODUCT NAME", 
		U.addr, CONCAT(U.mobile1, U.mobile2) AS "MOBILE PHONE"
      FROM userTBL U
	INNER JOIN buyTBL B
	 ON U.userID = B.userID;

SELECT "USER ID", "USER NAME" FROM v_userbuyTBL;

CREATE OR REPLACE VIEW v_userbuyTBL
AS
   SELECT U.userID AS "사용자 아이디", U.userName AS "이름", B.prodName AS "제품 이름", 
		U.addr, CONCAT(U.mobile1, U.mobile2)  AS "전화 번호"
      FROM userTBL U
          INNER JOIN buyTBL B
             ON U.userID = B.userID ;
             
SELECT "이름","전화 번호" FROM v_userbuyTBL;

DROP VIEW v_userbuyTBL;

CREATE OR REPLACE VIEW v_userTBL
AS
	SELECT userID, userName, addr FROM userTBL;

SELECT * FROM USER_VIEWS;

UPDATE v_userTBL SET addr = '부산' WHERE userID='JKW';

INSERT INTO v_userTBL(userID, userName, addr) VALUES('KBM','김병만','충북');

CREATE OR REPLACE VIEW v_userTBL
AS
	SELECT userID, userName, addr FROM userTBL
	WITH READ ONLY;

UPDATE v_userTBL SET addr = '태국' WHERE userID='SSK';

CREATE OR REPLACE VIEW v_sum
AS
	SELECT userID , SUM(price*amount) AS "Total"  
	   FROM buyTBL GROUP BY userID;

SELECT * FROM v_sum;

INSERT INTO v_sum VALUES('BAD', 1000);

CREATE OR REPLACE VIEW v_height177
AS
	SELECT * FROM userTBL WHERE height >= 177 ;

SELECT * FROM v_height177 ;

DELETE FROM v_height177 WHERE height < 177 ;

INSERT INTO v_height177 VALUES('KBM', '김병만', 1977, '경기', '010', '5555555', 158, '2019-01-01') ;

CREATE OR REPLACE VIEW v_height177
AS
	SELECT * FROM userTBL WHERE height >= 177 
	WITH CHECK OPTION ;

INSERT INTO v_height177 VALUES('WDT', '서장훈', 2006 , '서울', '010', '3333333', 155, '2019-3-3') ;

CREATE OR REPLACE VIEW v_userbuyTBL
AS
  SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS mobile
   FROM userTBL U
      INNER JOIN buyTBL B
         ON U.userID = B.userID ;

INSERT INTO v_userbuyTBL VALUES('PKL','박경리','운동화','경기','00000000000');

DROP TABLE userTbl CASCADE CONSTRAINTS;

SELECT * FROM v_userbuyTBL;
----------------- </실습 5> -------------------

----------------- <실습 6> -------------------

CREATE TABLE bigEmployees (
    emp_no  NUMBER(10) PRIMARY KEY,
    birth_date  DATE NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    gender  CHAR(1) NOT NULL,
    hire_date  DATE NOT NULL
);

SELECT COUNT(*) FROM bigEmployees; -- 약 30만건이 나오면 됨
SELECT * FROM bigEmployees WHERE ROWNUM <= 10;

CREATE TABLE bigTBL AS SELECT * FROM HR.bigEmployees;
CREATE TABLE smallTBL AS SELECT * FROM HR.Employees;

SELECT ROUND(AVG(EXTRACT(YEAR FROM B.birth_date)), 0) AS "평균 출생년도"
    FROM bigTBL B
        CROSS JOIN smallTBL S; -- 일부러 시간이 걸리도록 추가한 구문

CREATE MATERIALIZED VIEW mv_AvgYear
AS
    SELECT ROUND(AVG(EXTRACT(YEAR FROM B.birth_date)), 0) AS "평균 출생년도"
    FROM bigTBL B
        CROSS JOIN smallTBL S;

SELECT * FROM mv_AvgYear;

DROP MATERIALIZED VIEW mv_AvgYear;
CREATE MATERIALIZED VIEW mv_AvgYear 
    BUILD DEFERRED  
AS
    SELECT ROUND(AVG(EXTRACT(YEAR FROM B.birth_date)), 0) AS "평균 출생년도"
    FROM bigTBL B
        CROSS JOIN smallTBL S;

SELECT * FROM mv_AvgYear;

EXECUTE DBMS_MVIEW.REFRESH(LIST =>'mv_AvgYear');
SELECT * FROM mv_AvgYear;

ALTER TABLE buyTBL
    ADD sales GENERATED ALWAYS AS (price * amount) ;
SELECT * FROM buyTBL;

CREATE MATERIALIZED VIEW mv_SumSales 
    BUILD IMMEDIATE
    REFRESH COMPLETE   -- 전체 뷰가 변경됨
    ON COMMIT         -- 원본 테이블이 COMMIT 되는 즉시 변경됨.
AS
    SELECT SUM(sales) 
    FROM buyTBL;

SELECT * FROM mv_SumSales;

UPDATE buyTBL SET price = price*2;
COMMIT;
SELECT * FROM mv_SumSales;

----------------- </실습 6> -------------------










