/*
   [이것이 Oracle이다] 소스 코드
   7장. PL/SQL 고급
*/

------------------------------------
-- 7.1 Oracle의 데이터 형식  
------------------------------------

SELECT CAST(1234567.89 AS NUMBER(9,1)) FROM DUAL;

SELECT SYSDATE FROM DUAL ; -- 현재 날짜
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') "현재 날짜" FROM DUAL; 
SELECT TO_DATE('20201231235959', 'YYYYMMDDHH24MISS') "날짜 형식" FROM DUAL; 

SELECT ROWID, userName FROM userTBL;

CREATE TABLE person (       -- 사용자 테이블
   userId  NUMBER(5),         -- 사용자 ID
   korName  NVARCHAR2(10),  -- 한글 이름 (한글 사용)
   engName  VARCHAR2(20),   -- 영문 이름 (영어만 사용)
   email      VARCHAR2(30)   -- 이메일 주소 (영어 및 기호만 사용)
);

--------------- <실습 1> ---------------------

DROP USER sqlDB CASCADE; -- 기존 사용자 삭제
CREATE USER sqlDB IDENTIFIED BY 1234 -- 사용자 이름: sqlDB, 비밀번호 : 1234
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP;
GRANT connect, resource, dba TO sqlDB; -- 권한 부여

SET SERVEROUTPUT ON;

DECLARE
   myVar1 NUMBER(3) ; 
   myVar2 NUMBER(5,2) := 3.14 ; 
   myVar3 NVARCHAR2(20) := '이승기 키 -->' ; 
BEGIN
   myVar1 := 5;
   DBMS_OUTPUT.PUT_LINE(myVar1);
   DBMS_OUTPUT.PUT_LINE(myVar1 + myVar2);
   SELECT height INTO myVar1 FROM userTbl WHERE userName = '이승기' ;
   DBMS_OUTPUT.PUT_LINE(myVar3 || TO_CHAR(myVar1));
END ;

--------------- </실습 1> ---------------------

SELECT AVG(amount) AS "평균 구매 개수" FROM buyTBL ;

SELECT CAST(AVG(amount) AS NUMBER(3)) AS "평균 구매 개수" FROM buyTBL ;

SELECT CAST('2020$12$12' AS DATE) FROM DUAL;
SELECT CAST('2020/12/12' AS DATE) FROM DUAL;
SELECT CAST('2020%12%12' AS DATE) FROM DUAL;
SELECT CAST('2020@12@12' AS DATE) FROM DUAL;

SELECT CAST(price AS CHAR(5)) || 'X' || CAST(amount AS CHAR(4)) || '=' AS "단가X수량",	price*amount AS "구매액" 
  FROM buyTbl ;

SELECT TO_CHAR(12345, '$999,999') FROM DUAL;
SELECT TO_CHAR(12345, '$000,999') FROM DUAL;
SELECT TO_CHAR(12345, 'L999,999') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH:MM:SS') FROM DUAL;

SELECT TO_CHAR(10, 'X'), TO_CHAR(255, 'XX') FROM DUAL;

SELECT TO_NUMBER('A', 'X'), TO_NUMBER('FF', 'XX') FROM DUAL;

SELECT TO_NUMBER('0123'), TO_NUMBER('1234.456') FROM DUAL;

SELECT '100' + '200' FROM DUAL; -- 문자와 문자를 더함 (정수로 변환되서 연산됨)
SELECT CONCAT('100', '200') FROM DUAL; -- 문자와 문자를 연결 (문자로 처리)
SELECT 100 || '200' FROM DUAL; -- 정수와 문자를 연결 (정수가 문자로 변환되서 처리)
SELECT price  FROM buyTBL WHERE price >= '500'; -- 정수 500으로 변환


SELECT ASCII('A'), CHR(65), ASCIISTR('한'), UNISTR('\D55C') FROM DUAL;

SELECT LENGTH('한글'), LENGTH('AB'), LENGTHB('한글'), LENGTHB('AB') FROM DUAL;

SELECT CONCAT('이것이',' Oracle이다'), '이것이' || ' ' || 'Oracle이다'  FROM DUAL;

SELECT INSTR('이것이 Oracle이다. 이것도 오라클이다', '이것') FROM DUAL;
SELECT INSTR('이것이 Oracle이다. 이것도 오라클이다', '이것', 2) FROM DUAL;
SELECT INSTRB('이것이 Oracle이다. 이것도 오라클이다', '이것', 2) FROM DUAL;

SELECT LOWER('abcdEFGH'), UPPER('abcdEFGH'), INITCAP('this is oracle') FROM DUAL;

SELECT REPLACE ('이것이 Oracle이다', '이것이' , 'This is') FROM DUAL;

SELECT TRANSLATE('이것이 Oracle이다', '이것' , 'AB') FROM DUAL;

SELECT SUBSTR('대한민국만세', 3, 2) FROM DUAL;

SELECT REVERSE('Oracle') FROM DUAL;

SELECT LPAD('이것이', 10, '##'), RPAD('이것이', 10, '##') FROM DUAL;

SELECT LTRIM('   이것이'), RTRIM('이것이$$$', '$') FROM DUAL;

SELECT TRIM('   이것이   '), TRIM(BOTH 'ㅋ' FROM 'ㅋㅋㅋ재밌어요.ㅋㅋㅋ') FROM DUAL;

SELECT REGEXP_COUNT('이것이 오라클이다.', '이') FROM DUAL;

SELECT ABS(-100) FROM DUAL;

SELECT CEIL(4.7), FLOOR(4.7), ROUND(4.7) FROM DUAL;

SELECT MOD(157, 10) FROM DUAL;

SELECT POWER(2,3), SQRT(9) FROM DUAL;

SELECT SIGN(100), SIGN(0), SIGN(-100.123) FROM DUAL;

SELECT TRUNC(12345.12345, 2), TRUNC(12345.12345, -2) FROM DUAL;

SELECT ADD_MONTHS('2020-01-01', 5), ADD_MONTHS(SYSDATE, -5)  FROM DUAL;
SELECT TO_DATE('2020-01-01') + 5,  SYSDATE - 5  FROM DUAL;

SELECT CURRENT_DATE, SYSDATE, CURRENT_TIMESTAMP FROM DUAL;

SELECT EXTRACT(YEAR FROM DATE '2020-12-25'), EXTRACT(DAY FROM SYSDATE) FROM DUAL;

SELECT LAST_DAY('2020-02-01') FROM DUAL;

SELECT NEXT_DAY('2020-02-01', '월요일'), NEXT_DAY(SYSDATE, '일요일')  FROM DUAL;

SELECT MONTHS_BETWEEN (SYSDATE, '1988-09-17') FROM DUAL;

SELECT BIN_TO_NUM(1,0), BIN_TO_NUM(1,1,1,1)  FROM DUAL;

SELECT NUMTODSINTERVAL(48, 'HOUR'), NUMTODSINTERVAL(360000, 'SECOND') FROM DUAL;

SELECT NUMTOYMINTERVAL(37, 'MONTH'), NUMTOYMINTERVAL(1.5, 'YEAR') FROM DUAL;

--------------- <실습 2> ---------------------

SELECT ROW_NUMBER( ) OVER(ORDER BY height DESC) "키큰순위", userName, addr, height
   FROM userTBL ;

SELECT ROW_NUMBER( ) OVER(ORDER BY height DESC, userName ASC) "키큰순위", userName, addr, height
   FROM userTbl ;

SELECT addr, ROW_NUMBER( ) OVER(PARTITION BY addr ORDER BY height DESC, userName ASC) "지역별키큰순위", userName, height
   FROM userTbl ;

SELECT DENSE_RANK( ) OVER(ORDER BY height DESC)"키큰순위", userName, addr, height
   FROM userTbl ;

SELECT RANK( ) OVER(ORDER BY height DESC)"키큰순위", userName, addr, height
   FROM userTbl ;

SELECT NTILE(2) OVER(ORDER BY height DESC) "반번호", userName, addr, height
   FROM userTbl;

SELECT NTILE(4) OVER(ORDER BY height DESC) "반번호", userName, addr, height
   FROM userTbl;

--------------- </실습 2> ---------------------

--------------- <실습 3> ---------------------
SELECT  userName, addr, height AS "키",
       height - (LEAD(height, 1, 0) OVER (ORDER BY height DESC)) AS "다음 사람과 키 차이"
   FROM userTbl ;

SELECT addr, userName, height AS "키",
       height - ( FIRST_VALUE(height) OVER (PARTITION BY addr ORDER BY height DESC) ) 
             AS "지역별 최대키와 차이"
   FROM userTbl ;

SELECT  addr, userName, height AS "키",
      (CUME_DIST() OVER (PARTITION BY addr ORDER BY height DESC)) * 100 AS "누적인원 백분율%"
   FROM userTbl ;

SELECT  DISTINCT addr,
	PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY height) OVER (PARTITION BY addr) 
               AS "지역별 키의 중앙값"
   FROM userTbl ;

--------------- </실습 3> ---------------------

--------------- <실습 4> ---------------------
CREATE TABLE pivotTest
   (  uName NCHAR(3),
      season NCHAR(2),
      amount NUMBER(3));

INSERT  INTO  pivotTest VALUES ('김범수' , '겨울',  10) ;
INSERT  INTO  pivotTest VALUES ('윤종신' , '여름',  15) ;
INSERT  INTO  pivotTest VALUES ('김범수' , '가을',  25) ;
INSERT  INTO  pivotTest VALUES ('김범수' , '봄',    3) ;
INSERT  INTO  pivotTest VALUES ('김범수' , '봄',    37) ;
INSERT  INTO  pivotTest VALUES ('윤종신' , '겨울',  40) ;
INSERT  INTO  pivotTest VALUES ('김범수' , '여름',  14) ;
INSERT  INTO  pivotTest VALUES ('김범수' , '겨울',  22) ;
INSERT  INTO  pivotTest VALUES ('윤종신' , '여름',  64) ;
SELECT * FROM pivotTest;

SELECT * FROM pivotTest
   PIVOT ( SUM(amount) 
           FOR season 
           IN ('봄','여름','가을','겨울') )   ;

--------------- </실습 4> ---------------------

--------------- <실습 5> ---------------------
CREATE TABLE movieTBL 
  (movie_id        NUMBER(4),
   movie_title     NVARCHAR2(30),
   movie_director  NVARCHAR2(20),
   movie_star      NVARCHAR2(20),
   movie_script    CLOB,
   movie_film      BLOB
);

/* C:\SQL\Movies\movieRecords.txt 
0001,쉰들러리스트,스필버그,리암 니슨,0001.txt,0001.mp4
0002,쇼생크탈출,프랭크다라본트,팀 로빈스,0002.txt,0002.mp4
0003,라스트모히칸,마이클 만,다니엘 데이 루이스,0003.txt,0003.mp4
*/

/* C:\SQL\Movies\movieLoader.txt 
LOAD DATA
INFILE 'movieRecords.txt'
  INTO TABLE movieTBL
  FIELDS TERMINATED BY ','
  (  movie_id        CHAR(4),
     movie_title      CHAR(30),
     movie_director CHAR(20),
     movie_star      CHAR(20),
     scriptFname    FILLER CHAR(80),
     filmFname      FILLER CHAR(80),
     movie_script   LOBFILE(scriptFname) TERMINATED BY EOF,
     movie_film     LOBFILE(filmFname) TERMINATED BY EOF
)
*/

/* 명령 프롬프트에서 실행 
CD C:\SQL\Movies 
SQLLDR  sqlDB/1234@XE  control=movieLoader.txt
*/

SELECT * FROM movieTBL;

--------------- </실습 5> ---------------------

------------------------------------
-- 7.2. 조인(Join)  
------------------------------------

SELECT * 
   FROM buyTbl
     INNER JOIN userTbl
        ON buyTbl.userID = userTbl.userID
   WHERE buyTbl.userID = 'JYP';

SELECT * 
   FROM buyTbl
     INNER JOIN userTbl
        ON buyTbl.userID = userTbl.userID;

SELECT userID, userName, prodName, addr, mobile1 || mobile2 AS "연락처"
   FROM buyTbl
     INNER JOIN userTbl
        ON buyTbl.userID = userTbl.userID ;

SELECT buyTbl.userID, userName, prodName, addr, mobile1 || mobile2 AS "연락처"
   FROM buyTbl
     INNER JOIN userTbl
        ON buyTbl.userID = userTbl.userID ;

SELECT buyTbl.userID, userName, prodName, addr, mobile1 || mobile2 
   FROM buyTbl, userTbl
   WHERE buyTbl.userID = userTbl.userID ;

SELECT buyTbl.userID, userTbl.userName, buyTbl.prodName, userTbl.addr, 
         userTbl.mobile1 || userTbl.mobile2  AS "연락처"
   FROM buyTbl
     INNER JOIN userTbl
        ON buyTbl.userID = userTbl.userID;

SELECT B.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2  AS "연락처"
   FROM buyTbl B
     INNER JOIN userTbl U
        ON B.userID = U.userID;
        
SELECT B.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2  AS "연락처"
   FROM buyTbl B
     INNER JOIN userTbl U
        ON B.userID = U.userID
   WHERE B.userID = 'JYP';

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2  AS "연락처"
   FROM userTbl U
     INNER JOIN buyTbl B
        ON U.userID = B.userID 
   WHERE B.userID = 'JYP';

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2  AS "연락처"
   FROM userTbl U
     INNER JOIN buyTbl B
        ON U.userID = B.userID 
   ORDER BY U.userID;

SELECT DISTINCT U.userID, U.userName,  U.addr
   FROM userTbl U
     INNER JOIN buyTbl B
        ON U.userID = B.userID 
   ORDER BY U.userID ;

SELECT U.userID, U.userName,  U.addr
   FROM userTbl U
   WHERE EXISTS (
      SELECT * 
      FROM buyTbl B
      WHERE U.userID = B.userID );

--------------- <실습 6> ---------------------

CREATE TABLE stdTBL 
( stdName   NCHAR(5) NOT NULL PRIMARY KEY,
  addr	    NCHAR(2) NOT NULL
);
CREATE TABLE clubTBL 
( clubName    NCHAR(5) NOT NULL PRIMARY KEY,
  roomNo      NCHAR(4) NOT NULL
);
CREATE SEQUENCE stdclubSEQ;
CREATE TABLE stdclubTBL
(  idNum    NUMBER(5) NOT NULL PRIMARY KEY, 
   stdName  NCHAR(5) NOT NULL,
   clubName NCHAR(5) NOT NULL,
FOREIGN KEY(stdName) REFERENCES stdTBL(stdName),
FOREIGN KEY(clubName) REFERENCES clubTBL(clubName)
);
INSERT INTO stdTBL VALUES('김범수','경남');
INSERT INTO stdTBL VALUES('성시경','서울');
INSERT INTO stdTBL VALUES('조용필','경기');
INSERT INTO stdTBL VALUES('은지원','경북');
INSERT INTO stdTBL VALUES('바비킴','서울');
INSERT INTO clubTBL VALUES('수영','101호');
INSERT INTO clubTBL VALUES('바둑','102호');
INSERT INTO clubTBL VALUES('축구','103호');
INSERT INTO clubTBL VALUES('봉사','104호');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL, '김범수','바둑');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL,'김범수','축구');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL,'조용필','축구');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL,'은지원','축구');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL,'은지원','봉사');
INSERT INTO stdclubTBL VALUES(stdclubSEQ.NEXTVAL,'바비킴','봉사');

SELECT S.stdName, S.addr, C.clubName, C.roomNo
   FROM stdTBL S 
      INNER JOIN stdclubTBL SC
           ON S.stdName = SC.stdName
      INNER JOIN clubTBL C
	  ON SC.clubName = C.clubName 
   ORDER BY S.stdName;

SELECT C.clubName, C.roomNo, S.stdName, S.addr
   FROM  stdTBL S
      INNER JOIN stdclubTBL SC
           ON SC.stdName = S.stdName
      INNER JOIN clubTBL C
	 ON SC.clubName = C.clubName
    ORDER BY C.clubName;

--------------- </실습 6> ---------------------

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS "연락처"
   FROM userTbl U
      LEFT OUTER JOIN buyTbl B
         ON U.userID = B.userID 
   ORDER BY U.userID;

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS "연락처"
   FROM buyTbl B 
      RIGHT OUTER JOIN userTbl U
         ON U.userID = B.userID 
   ORDER BY U.userID;

SELECT U.userID, U.userName, B.prodName, U.addr, U.mobile1 || U.mobile2 AS "연락처"
   FROM userTbl U
      LEFT  JOIN buyTbl B
         ON U.userID = B.userID 
   WHERE B.prodName IS NULL
   ORDER BY U.userID;

--------------- <실습 7> ---------------------
SELECT S.stdName, S.addr, C.clubName, C.roomNo
   FROM stdTBL S 
      LEFT OUTER JOIN stdclubTBL SC
          ON S.stdName = SC.stdName
      LEFT OUTER JOIN clubTBL C
          ON SC.clubName = C.clubName
   ORDER BY S.stdName;

SELECT C.clubName, C.roomNo, S.stdName, S.addr
   FROM  stdTBL S
      LEFT OUTER JOIN stdclubTBL SC
          ON SC.stdName = S.stdName
      RIGHT OUTER JOIN clubTBL C
          ON SC.clubName = C.clubName
   ORDER BY C.clubName;

SELECT S.stdName, S.addr, C.clubName, C.roomNo
   FROM stdTBL S 
      LEFT OUTER JOIN stdclubTBL SC
          ON S.stdName = SC.stdName
      LEFT OUTER JOIN clubTBL C
          ON SC.clubName = C.clubName
UNION 
SELECT S.stdName, S.addr, C.clubName, C.roomNo
   FROM  stdTBL S
      LEFT OUTER JOIN stdclubTBL SC
          ON SC.stdName = S.stdName
      RIGHT OUTER JOIN clubTBL C
          ON SC.clubName = C.clubName;

--------------- </실습 7> ---------------------

SELECT * 
   FROM buyTbl 
     CROSS JOIN userTbl;

SELECT * 
   FROM buyTbl , userTbl ;

SELECT  COUNT(*) AS "데이터 개수"
   FROM HR.employees 
     CROSS JOIN HR.countries;

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

SELECT A.emp AS "부하직원" , B.emp AS "직속상관", B.department AS "직속상관부서"
   FROM empTbl A
      INNER JOIN empTbl B
         ON A.manager = B.emp
   WHERE A.emp = '우대리';

SELECT stdName, addr FROM stdTBL
   UNION ALL
SELECT clubName, roomNo FROM clubTBL;

SELECT userName, CONCAT(mobile1, mobile2) AS "전화번호" FROM userTbl
   WHERE userName NOT IN ( SELECT userName FROM userTbl WHERE mobile1 IS NULL);

SELECT userName, CONCAT(mobile1, mobile2) AS "전화번호" FROM userTbl
   WHERE userName IN ( SELECT userName FROM userTbl WHERE mobile1 IS NULL);
   
------------------------------------
-- 7.3. PL/SQL 프로그래밍
------------------------------------

SET SERVEROUTPUT ON; 

DECLARE
    var1 NUMBER(5) ; -- 변수 선언
BEGIN
    var1 := 100; -- 변수에 값 대입
    IF  var1 = 100 THEN  -- 만약 var1이 100이라면
        DBMS_OUTPUT.PUT_LINE('100입니다');
    ELSE
        DBMS_OUTPUT.PUT_LINE('100이 아닙니다');
    END IF;
END ;

DECLARE
    hireDate DATE ; -- 입사일
    curDate DATE ; -- 오늘
    wDays   NUMBER(5) ; -- 근무한 일수
BEGIN
    SELECT hire_date INTO hireDate -- hire_date 열의 결과를 hireDATE에 대입
       FROM HR.employees
       WHERE employee_id = 200;
    curDate := CURRENT_DATE(); -- 현재 날짜
    wDays :=  curDate - hireDate; -- 날짜의 차이(일 단위)
    IF (wDays/365) >= 5 THEN -- 5년이 지났다면
        DBMS_OUTPUT.PUT_LINE('입사한지 ' || wdays || 
                    '일이나 지났습니다. 축하합니다!');
    ELSE
        DBMS_OUTPUT.PUT_LINE('입사한지 ' || wdays || 
                    '일밖에 안되었네요. 열심히 일하세요.');
    END IF;
END ;

DECLARE
    pNumber NUMBER(3) ; -- 점수
    credit CHAR(1) ; -- 학점
BEGIN
    pNumber := 77;
    IF pNumber >= 90 THEN
		credit := 'A';
    ELSIF pNumber >= 80 THEN
		credit := 'B';
    ELSIF pNumber >= 70 THEN
		credit := 'C';
    ELSIF pNumber >= 60 THEN
		credit := 'D';
    ELSE
		credit := 'F';
    END IF;
    DBMS_OUTPUT.PUT_LINE('취득점수==>' || pNumber || ', 학점==>' || credit);
END ;

DECLARE
    pNumber NUMBER(3) ; -- 점수
    credit CHAR(1) ; -- 학점
BEGIN
    pNumber := 77;
    CASE 
		WHEN pNumber >= 90 THEN
			credit := 'A';
		WHEN pNumber >= 80 THEN
			credit := 'B';
		WHEN pNumber >= 70 THEN
			credit := 'C';
		WHEN pNumber >= 60 THEN
			credit := 'D';
		ELSE
			pNumber := 'F';
    END CASE;
    DBMS_OUTPUT.PUT_LINE('취득점수==>' || pNumber || ', 학점==>' || credit);
END ;


--------------- <실습 8> ---------------------
SELECT userID, SUM(price*amount) AS "총구매액"
   FROM buyTbl
   GROUP BY userID
   ORDER BY SUM(price*amount) DESC;

SELECT B.userID, U.userName, SUM(price*amount) AS "총구매액"
   FROM buyTbl B
      INNER JOIN userTbl U
         ON B.userID = U.userID
   GROUP BY B.userID, U.userName
   ORDER BY SUM(price*amount) DESC;

SELECT B.userID, U.userName, SUM(price*amount) AS "총구매액"
   FROM buyTbl B
      RIGHT OUTER JOIN userTbl U
         ON B.userID = U.userID
   GROUP BY B.userID, U.userName
   ORDER BY SUM(price*amount) DESC NULLS LAST;

SELECT U.userID, U.userName, SUM(price*amount) AS "총구매액"
   FROM buyTbl B
      RIGHT OUTER JOIN userTbl U
         ON B.userID = U.userID
   GROUP BY U.userID, U.userName
   ORDER BY SUM(price*amount) DESC NULLS LAST;

SELECT U.userID, U.userName, SUM(price*amount) AS "총구매액",
       CASE  
            WHEN (SUM(price*amount)  >= 1500) THEN  '최우수고객'
            WHEN (SUM(price*amount)  >= 1000) THEN  '우수고객'
            WHEN (SUM(price*amount) >= 1 ) THEN '일반고객'
            ELSE '유령고객'
       END AS "고객등급"
   FROM buyTbl B
      RIGHT OUTER JOIN userTbl U
         ON B.userID = U.userID
   GROUP BY U.userID, U.userName
   ORDER BY SUM(price*amount) DESC NULLS LAST;

--------------- </실습 8> ---------------------

SET SERVEROUTPUT ON; 
DECLARE
    iNum NUMBER(3) ; -- 1에서 100까지 증가할 변수
    hap NUMBER(5) ; -- 더한 값을 누적할 변수
BEGIN
    iNum := 1;
    hap := 0;
    WHILE iNum <= 100 
    LOOP
        hap := hap + iNum; -- hap에 iNum를 누적시킴
        iNum := iNum + 1; -- iNum을 1 증가시킴
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(hap);
END ;

DECLARE
    iNum NUMBER(3) ; -- 1에서 100까지 증가할 변수
    hap NUMBER(5) ; -- 더한 값을 누적할 변수
BEGIN
    hap := 0;
    FOR iNum IN 1 .. 100 
    LOOP
        hap := hap + iNum; -- hap에 iNum를 누적시킴
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(hap);
END ;

DECLARE
    iNum NUMBER(3) ; -- 1에서 100까지 증가할 변수
    hap NUMBER(5) ; -- 더한 값을 누적할 변수
BEGIN
    iNum := 1;
    hap := 0;
    WHILE iNum <= 100 
    LOOP
        IF MOD(iNum, 7) = 0 THEN
            iNum := iNum + 1;
            CONTINUE;
        END IF;
        hap := hap + iNum; -- hap에 iNum를 누적시킴
        IF hap > 1000 THEN
            EXIT;
        END IF;
        iNum := iNum + 1; -- iNum을 1 증가시킴
    END LOOP;
    DBMS_OUTPUT.PUT_LINE(hap);
END ;


DECLARE
    iNum NUMBER(3) ; -- 1에서 100까지 증가할 변수
    hap NUMBER(5) ; -- 더한 값을 누적할 변수
BEGIN
    iNum := 1;
    hap := 0;
    WHILE iNum <= 100 
    LOOP
        IF MOD(iNum, 7) = 0 THEN
            iNum := iNum + 1;
            CONTINUE;
        END IF;
        hap := hap + iNum; -- hap에 iNum를 누적시킴
        IF hap > 1000 THEN
            GOTO  my_goto_location;
        END IF;
        iNum := iNum + 1; -- iNum을 1 증가시킴
    END LOOP;
    << my_goto_location >>
    DBMS_OUTPUT.PUT_LINE(hap);
END ;

BEGIN
    DBMS_LOCK.SLEEP(5); 
    DBMS_OUTPUT.PUT_LINE('5초간 멈춘후 진행되었음');
END ;

DECLARE
    -- 테이블 열의 데이터 타입과 동일하게 변수 타입을 설정
    v_userName userTBL.userName%TYPE; 
BEGIN
    SELECT userName INTO v_userName FROM userTBL 
            WHERE userName LIKE ('김%'); -- 김범수, 김경호 2명
    DBMS_OUTPUT.PUT_LINE ('김씨 고객 이름은 ' ||v_userName|| '입니다.') ;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE ('김씨 고객이 없습니다.') ;
        WHEN TOO_MANY_ROWS THEN
            DBMS_OUTPUT.PUT_LINE ('김씨 고객이 너무 많네요.') ;            
END ;

DECLARE
    v_userName userTBL.userName%TYPE; 
    userException EXCEPTION;
    PRAGMA EXCEPTION_INIT(userException, -1422);
BEGIN
    SELECT userName INTO v_userName FROM userTBL 
            WHERE userName LIKE ('김%'); -- 김범수, 김경호 2명
    DBMS_OUTPUT.PUT_LINE ('김씨 고객 이름은 ' ||v_userName|| '입니다.') ;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE ('김씨 고객이 없습니다.') ;
        WHEN userException THEN
            DBMS_OUTPUT.PUT_LINE ('김씨 고객이 너무 많네요.') ;            
END ;

DECLARE
    v_userName userTBL.userName%TYPE; 
    zeroDelete EXCEPTION;
BEGIN
    v_userName := '무명씨';
    DELETE FROM userTBL WHERE userName=v_userName; 
    IF SQL%NOTFOUND THEN
        RAISE zeroDelete;
    END IF;
    EXCEPTION
        WHEN zeroDelete THEN
            DBMS_OUTPUT.PUT_LINE (v_userName || ' 데이터 없음. 확인 바래요^^') ;            
END ;

DECLARE
    v_userName userTBL.userName%TYPE; 
BEGIN
    v_userName := '무명씨';
    DELETE FROM userTBL WHERE userName=v_userName; 
    IF  SQL%NOTFOUND  THEN
        RAISE_APPLICATION_ERROR(-20001, '데이터 없음 오류 발생!!');
    END IF;
END ;

DECLARE
    v_sql VARCHAR2(100); -- SQL 문장을 저장할 변수
    v_height userTBL.height%TYPE;  -- 반환될 키를 저장할 변수
BEGIN
    v_sql := 'SELECT height FROM userTBL WHERE userid = ''EJW'' ' ; 
    EXECUTE IMMEDIATE v_sql INTO v_height;
    DBMS_OUTPUT.PUT_LINE (v_height) ;
END ;

DECLARE
    v_year CHAR(4);
    v_month CHAR(2);
    v_day  CHAR(2);
    v_sql VARCHAR2(100);
    v_height userTBL.height%TYPE;
BEGIN
     v_year := EXTRACT(YEAR FROM SYSDATE);
     v_month := EXTRACT(MONTH FROM SYSDATE);
     v_day := EXTRACT(DAY FROM SYSDATE);
     v_sql := 'CREATE TABLE myTBL' || v_year || '_' || v_month || '_' || 
            v_day || ' (idNum  NUMBER(5), userName NVARCHAR2(10))';
    EXECUTE IMMEDIATE v_sql;
    DBMS_OUTPUT.PUT_LINE ('테이블 생성됨');
END;

