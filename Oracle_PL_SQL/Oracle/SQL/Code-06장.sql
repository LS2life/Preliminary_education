/*
   [이것이 Oracle이다] 소스 코드
   6장. PL/SQL 기본
*/

------------------------------------
-- 6.1. SELECT 문  
------------------------------------

SELECT * FROM employees;	

SELECT * FROM HR.employees;

SELECT department_name FROM departments;

SELECT department_id, department_name FROM departments;

-- 한 줄 주석 연습
SELECT department_id, department_name -- 그룹 아이디, 이름
FROM departments;

/* 블록 주석 연습
SELECT department_id, department_name -- 그룹 아이디, 이름
FROM departments;
*/

------------ <실습1> ------------
SELECT * FROM SYS.DBA_USERS;

SELECT * FROM SYS.DBA_TABLES WHERE OWNER = 'HR';

SELECT * FROM SYS.DBA_TAB_COLUMNS WHERE OWNER = 'HR' AND TABLE_NAME = 'DEPARTMENTS';

SELECT department_name FROM HR.departments; 

SELECT  department_id 부서번호, department_name AS "부서 이름" FROM HR.departments;

------------ </실습1> ------------

------------ <실습2> ------------

CREATE USER sqlDB IDENTIFIED BY 1234 -- 사용자 이름: sqlDB, 비밀번호 : 1234
   DEFAULT TABLESPACE USERS
   TEMPORARY TABLESPACE TEMP;
   
GRANT connect, resource, dba TO sqlDB ;

CREATE TABLE userTBL -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  userName  	NVARCHAR2(10) NOT NULL, -- 이름
  birthYear 	NUMBER(4) NOT NULL,  -- 출생년도
  addr	  	NCHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(010, 011, 016, 017, 018, 019 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	NUMBER(3),  -- 키
  mDate    	DATE  -- 회원 가입일
);
CREATE TABLE buyTBL -- 회원 구매 테이블
(  idNum 	NUMBER(8) NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	NCHAR(6) NOT NULL, --  물품명
   groupName 	NCHAR(4)  , -- 분류
   price     	NUMBER(8)  NOT NULL, -- 단가
   amount    	NUMBER(3)  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES userTBL(userID)
);

INSERT INTO userTBL VALUES('LSG', '이승기', 1987, '서울', '011', '11111111', 182, '2008-8-8');
INSERT INTO userTBL VALUES('KBS', '김범수', 1979, '경남', '011', '22222222', 173, '2012-4-4');
INSERT INTO userTBL VALUES('KKH', '김경호', 1971, '전남', '019', '33333333', 177, '2007-7-7');
INSERT INTO userTBL VALUES('JYP', '조용필', 1950, '경기', '011', '44444444', 166, '2009-4-4');
INSERT INTO userTBL VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO userTBL VALUES('LJB', '임재범', 1963, '서울', '016', '66666666', 182, '2009-9-9');
INSERT INTO userTBL VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO userTBL VALUES('EJW', '은지원', 1972, '경북', '011', '88888888', 174, '2014-3-3');
INSERT INTO userTBL VALUES('JKW', '조관우', 1965, '경기', '018', '99999999', 172, '2010-10-10');
INSERT INTO userTBL VALUES('BBK', '바비킴', 1973, '서울', '010', '00000000', 176, '2013-5-5');

CREATE SEQUENCE idSEQ; -- 순차번호 입력을 위해서 시퀀스 생성
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buyTBL VALUES(idSEQ.NEXTVAL, 'KBS', '노트북', '전자', 1000, 1);
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

COMMIT;
SELECT * FROM userTBL;
SELECT * FROM buyTBL;

------------ </실습2> ------------

SELECT * FROM userTBL;

SELECT * FROM userTBL WHERE userName = '김경호';

SELECT userID, userName FROM userTBL WHERE birthYear >= 1970 AND height >= 182;

SELECT userID, userName FROM userTBL WHERE birthYear >= 1970 OR height >= 182;

SELECT userName, height FROM userTBL WHERE height >= 180 AND height <= 183;

SELECT userName, height FROM userTBL WHERE height BETWEEN 180 AND 183;

SELECT userName, addr FROM userTBL WHERE addr='경남' OR  addr='전남' OR addr='경북';

SELECT userName, addr FROM userTBL WHERE addr IN ('경남','전남','경북');

SELECT userName, height FROM userTBL WHERE userName LIKE '김%';

SELECT userName, height FROM userTBL WHERE userName LIKE '_종신';

SELECT userName, height FROM userTBL WHERE height  > 177;

SELECT userName, height FROM userTBL 
   WHERE height > (SELECT height FROM userTBL WHERE userName = '김경호');

SELECT userName, height FROM userTBL 
   WHERE height >= (SELECT height FROM userTBL WHERE addr = '경남');

SELECT rownum, userName, height FROM userTBL 
   WHERE height >= ANY (SELECT height FROM userTBL WHERE addr = '경남');

SELECT userName, height FROM userTBL 
   WHERE height = ANY (SELECT height FROM userTBL WHERE addr = '경남');

SELECT userName, height FROM userTBL 
   WHERE height IN (SELECT height FROM userTBL WHERE addr = '경남');

SELECT userName, mDate FROM userTBL ORDER BY mDate;

SELECT userName, mDate FROM userTBL ORDER BY mDate DESC;

SELECT userName, height FROM userTBL ORDER BY height DESC, userName ASC;

SELECT addr FROM userTBL;

SELECT addr FROM userTBL ORDER BY addr;

SELECT DISTINCT addr FROM userTBL;

SELECT employee_id, hire_date FROM employees 
   ORDER BY hire_date ASC;

SELECT * FROM 
   (SELECT employee_id, hire_date FROM employees  ORDER BY hire_date ASC)
   WHERE ROWNUM <= 5;
   
SELECT employee_id, hire_date FROM employees 
   WHERE ROWNUM <= 5;

SELECT employee_id, hire_date FROM EMPLOYEES SAMPLE(5);

CREATE TABLE buyTBL2 AS (SELECT * FROM buyTBL);
SELECT * FROM buyTBL2;

CREATE TABLE buyTBL3 AS (SELECT userID, prodName FROM buyTBL);
SELECT * FROM buyTBL3;

SELECT userID, amount FROM buyTBL ORDER BY userID;

SELECT userID, SUM(amount) FROM buyTBL GROUP BY userID;

SELECT userID AS "사용자 아이디", SUM(amount) AS "총 구매 개수"
   FROM buyTBL GROUP BY userID;

SELECT userID AS "사용자 아이디", SUM(price*amount) AS "총 구매액"
   FROM buyTBL GROUP BY userID;

SELECT AVG(amount) AS "평균 구매 개수" FROM buyTBL;

SELECT CAST(AVG(amount) AS NUMBER(5,3)) AS "평균 구매 개수" FROM buyTBL;

SELECT userID, CAST(AVG(amount) AS NUMBER(5,3)) AS "평균 구매 개수" FROM buyTBL  GROUP BY userID;

SELECT userName, MAX(height), MIN(height) FROM userTBL;

SELECT userName, MAX(height), MIN(height) FROM userTBL GROUP BY userName;

SELECT userName, height
   FROM userTBL 
   WHERE height = (SELECT MAX(height)FROM userTBL) 
       OR height = (SELECT MIN(height)FROM userTBL);

SELECT COUNT(*) FROM userTBL;

SELECT COUNT(mobile1) AS "휴대폰이 있는 사용자" FROM userTBL;

SELECT userID AS "사용자", SUM(price*amount) AS "총 구매액"  
   FROM buyTBL 
   GROUP BY userID;

SELECT userID AS "사용자", SUM(price*amount) AS "총 구매액"  
   FROM buyTBL 
   WHERE SUM(price*amount) > 1000 
   GROUP BY userID;

SELECT userID AS "사용자", SUM(price*amount) AS "총 구매액"  
   FROM buyTBL 
   GROUP BY userID
   HAVING SUM(price*amount) > 1000;

SELECT userID AS "사용자", SUM(price*amount) AS "총 구매액"  
   FROM buyTBL 
   GROUP BY userID
   HAVING SUM(price*amount) > 1000
   ORDER BY SUM(price*amount);

SELECT idNum,  groupName, SUM(price * amount) AS "비용" 
   FROM buyTbl
   GROUP BY ROLLUP (groupName, idNum);

SELECT groupName, SUM(price * amount) AS "비용" 
   FROM buyTbl
   GROUP BY ROLLUP (groupName);

SELECT groupName, SUM(price * amount) AS "비용" 
         , GROUPING_ID(groupName) AS "추가행 여부"
   FROM buyTbl
   GROUP BY ROLLUP(groupName) ;

CREATE TABLE cubeTbl(prodName NCHAR(3), color NCHAR(2), amount INT);
INSERT INTO cubeTbl VALUES('컴퓨터', '검정', 11);
INSERT INTO cubeTbl VALUES('컴퓨터', '파랑', 22);
INSERT INTO cubeTbl VALUES('모니터', '검정', 33);
INSERT INTO cubeTbl VALUES('모니터', '파랑', 44);
SELECT prodName, color, SUM(amount) AS "수량합계"
   FROM cubeTbl
   GROUP BY CUBE (color, prodName)
   ORDER BY prodName, color;

SELECT userID AS "사용자", SUM(price*amount) AS "총구매액"  
   FROM buyTbl  GROUP BY userID;

WITH abc(userID, total)
AS
(  SELECT userID, SUM(price*amount)  
      FROM buyTbl  GROUP BY userID  )
SELECT * FROM abc ORDER BY total DESC ;

WITH abc(userID, total)
AS
(  SELECT userID, SUM(price*amount)  
      FROM buyTbl  GROUP BY userID  )
SELECT userID AS "사용자", total AS "총 구매액" FROM abc ORDER BY total DESC ;

WITH cte_userTbl(addr, maxHeight)
AS
( SELECT addr, MAX(height) FROM userTbl GROUP BY addr)
SELECT AVG(maxHeight) AS "각 지역별 최고키 평균" FROM cte_userTbl;

WITH 
AAA(userID, total)
   AS
     (SELECT userID, SUM(price*amount) FROM buyTbl GROUP BY userID ),
BBB(sumtotal)
   AS
      (SELECT SUM(total) FROM AAA ),
CCC(sumavg)
   AS
      (SELECT  sumtotal / (SELECT count(*) FROM buyTbl) FROM BBB)
SELECT * FROM CCC;

------------ <실습3> ------------
CREATE TABLE empTbl (emp NCHAR(3), manager NCHAR(3), department NCHAR(3));

INSERT INTO empTbl VALUES('나사장','없음','없음');
INSERT INTO empTbl VALUES('김재무','나사장','재무부');
INSERT INTO empTbl VALUES('김부장','김재무','재무부');
INSERT INTO empTbl VALUES('이부장','김재무','재무부');
INSERT INTO empTbl VALUES('우대리','이부장','재무부');
INSERT INTO empTbl VALUES('지사원','이부장','재무부');
INSERT INTO empTbl VALUES('이영업','나사장','영업부');
INSERT INTO empTbl VALUES('한과장','이영업','영업부');
INSERT INTO empTbl VALUES('최정보','나사장','정보부');
INSERT INTO empTbl VALUES('윤차장','최정보','정보부');
INSERT INTO empTbl VALUES('이주임','윤차장','정보부');

WITH empCTE(empName, mgrName, dept, empLevel)
AS
(
 ( SELECT emp, manager, department , 0  
       FROM empTbl 
       WHERE manager = '없음' ) -- 상관이 없는 사람이 바로 사장
  UNION ALL
  (SELECT empTbl.emp, empTbl.manager, empTbl.department, empCTE.empLevel+1
   FROM empTbl INNER JOIN empCTE 
        ON empTbl.manager = empCTE.empName)
)
SELECT * FROM empCTE ORDER BY dept, empLevel;

WITH empCTE(empName, mgrName, dept, empLevel)
AS
(
 ( SELECT emp, manager, department , 0  
       FROM empTbl 
       WHERE manager = '없음' ) -- 상관이 없는 사람이 바로 사장
  UNION ALL
  (SELECT empTbl.emp, empTbl.manager, empTbl.department, empCTE.empLevel+1
   FROM empTbl INNER JOIN empCTE 
        ON empTbl.manager = empCTE.empName)
)
SELECT CONCAT(RPAD(' ㄴ', empLevel*2 + 1, 'ㄴ'),  empName) AS "직원이름", dept AS "직원부서"
   FROM empCTE  ORDER BY dept, empLevel;

WITH empCTE(empName, mgrName, dept, empLevel)
AS
(
 ( SELECT emp, manager, department , 0  
       FROM empTbl 
       WHERE manager = '없음' ) -- 상관이 없는 사람이 바로 사장
  UNION ALL
  (SELECT empTbl.emp, empTbl.manager, empTbl.department, empCTE.empLevel+1
   FROM empTbl INNER JOIN empCTE 
        ON empTbl.manager = empCTE.empName
   WHERE empLevel < 2)
)
SELECT CONCAT(RPAD(' ㄴ', empLevel*2 + 1, 'ㄴ'),  empName) AS "직원이름", dept AS "직원부서"
   FROM empCTE  ORDER BY dept, empLevel;

------------ </실습3> ------------


------------------------------------
-- 6.2. 데이터의 변경을 위한 SQL문 
------------------------------------

CREATE TABLE testTBL1 (id  NUMBER(4), userName NCHAR(3), age NUMBER(2));
INSERT INTO testTBL1 VALUES (1, '홍길동', 25);

INSERT INTO testTBL1(id, userName) VALUES (2, '설현');

INSERT INTO testTBL1(userName, age, id) VALUES ('지민', 26,  3);

CREATE TABLE testTBL2 
   (id NUMBER(4), 
    userName NCHAR(3), 
    age NUMBER(2),
    nation NCHAR(4) DEFAULT '대한민국');


CREATE SEQUENCE idSEQ
    START WITH 1   -- 시작값
    INCREMENT BY 1 ;  -- 증가값

DROP SEQUENCE idSEQ;

INSERT INTO testTBL2 VALUES (idSEQ.NEXTVAL, '유나' ,25 , DEFAULT);
INSERT INTO testTBL2 VALUES (idSEQ.NEXTVAL, '혜정' ,24 , '영국');
SELECT * FROM testTBL2;

INSERT INTO testTBL2 VALUES (11, '쯔위' , 18, '대만'); 
ALTER SEQUENCE idSEQ  
   INCREMENT BY  10; 
INSERT INTO testTBL2 VALUES (idSEQ.NEXTVAL, '미나' , 21, '일본'); 
ALTER SEQUENCE idSEQ  
   INCREMENT BY  1; 
SELECT * FROM testTBL2;

SELECT idSEQ.CURRVAL FROM DUAL;

SELECT 100*100 FROM DUAL;

CREATE TABLE testTBL3 (id  NUMBER(3));
CREATE  SEQUENCE cycleSEQ
  START WITH 100
  INCREMENT BY 100
  MINVALUE 100   -- 최소값
  MAXVALUE 300   -- 최대값
  CYCLE           -- 반복설정
  NOCACHE ;       -- 캐시 사용 안함
INSERT INTO testTBL3 VALUES  (cycleSEQ.NEXTVAL);
INSERT INTO testTBL3 VALUES  (cycleSEQ.NEXTVAL);
INSERT INTO testTBL3 VALUES  (cycleSEQ.NEXTVAL);
INSERT INTO testTBL3 VALUES  (cycleSEQ.NEXTVAL);
SELECT * FROM testTBL3;


CREATE TABLE testTBL4 (empID NUMBER(6), FirstName VARCHAR2(20), 
    LastName VARCHAR2(25), Phone VARCHAR2(20));
INSERT INTO testTBL4 
  SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER
    FROM HR.employees ;

CREATE TABLE testTBL5 AS
   (SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER
       FROM HR.employees) ;

COMMIT;

UPDATE testTBL4
    SET Phone = '없음'
    WHERE FirstName = 'David';
    
UPDATE buyTBL SET price = price * 1.5 ;

DELETE FROM testTBL4 WHERE FirstName = 'Peter';

ROLLBACK; -- 앞에서 지운 'Peter'를 되돌림
DELETE FROM testTBL4 WHERE FirstName = 'Peter' AND ROWNUM <= 2;

------------ <실습4> ------------

CREATE TABLE bigTBL1 AS
    SELECT  level AS bigID,
        ROUND(DBMS_RANDOM.VALUE(1, 500000),0) AS  numData
    FROM DUAL
    CONNECT BY level <= 500000;

CREATE TABLE bigTBL2 AS
    SELECT  level AS bigID,
        ROUND(DBMS_RANDOM.VALUE(1, 500000),0) AS  numData
    FROM DUAL
    CONNECT BY level <= 500000;
    
CREATE TABLE bigTBL3 AS
    SELECT  level AS bigID,
        ROUND(DBMS_RANDOM.VALUE(1, 500000),0) AS  numData
    FROM DUAL
    CONNECT BY level <= 500000;

DELETE FROM bigTbl1;
COMMIT;

DROP TABLE bigTbl2;

TRUNCATE TABLE bigTbl3;

------------ </실습4> ------------

------------ <실습5> ------------

CREATE TABLE memberTBL AS
   (SELECT userID, userName, addr FROM userTbl ) ;
SELECT * FROM memberTBL;

CREATE TABLE changeTBL
( userID CHAR(8) , 
  userName NVARCHAR2(10), 
  addr NCHAR(2),
  changeType NCHAR(4) -- 변경 사유
  );
INSERT INTO changeTBL VALUES('TKV', '태권브이', '한국', '신규가입');
INSERT INTO changeTBL VALUES('LSG', null, '제주', '주소변경');
INSERT INTO changeTBL VALUES('LJB', null, '영국', '주소변경');
INSERT INTO changeTBL VALUES('BBK', null, '탈퇴', '회원탈퇴');
INSERT INTO changeTBL VALUES('SSK', null, '탈퇴', '회원탈퇴');

MERGE INTO memberTBL M  
  USING (SELECT changeType, userID, userName, addr FROM changeTBL)  C  
  ON (M.userID = C.userID)  
  WHEN MATCHED  THEN
      UPDATE SET M.addr = C.addr
      DELETE WHERE C.changeType = '회원탈퇴'
  WHEN NOT MATCHED  THEN
     INSERT (userID, userName,  addr)  VALUES(C.userID, C.userName,  C.addr) ;

SELECT * FROM memberTBL;
------------ </실습5> ------------