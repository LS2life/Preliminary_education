/*
   [이것이 Oracle이다] 소스 코드
   10장. 저장 프로시저와 함수
*/

------------------------------------
-- 10.1 저장 프로시저
------------------------------------
CREATE OR REPLACE PROCEDURE userProc AS
  v_bYear NUMBER; -- 변수 선언
BEGIN
    SELECT birthYear INTO v_bYear FROM userTbl
         WHERE userID = 'SSK';  -- 쿼리 결과를 변수에 대입
    v_byear := v_bYear + 1;  -- 변수에 1 증가
    DBMS_OUTPUT.PUT_LINE (v_byear); -- 변수 값 출력
END userProc ;

SET SERVEROUTPUT ON; 
EXECUTE userProc();

---------------- <실습 1> --------------------
CREATE OR REPLACE PROCEDURE userProc1 (
  pi_userID IN USERTBL.USERID%TYPE
) AS
  v_uName VARCHAR(10);
BEGIN
    SELECT userName INTO v_uName FROM userTbl 
         WHERE userID = pi_userID;
    DBMS_OUTPUT.PUT_LINE (v_uName);
END ;

SET SERVEROUTPUT ON; 
EXECUTE userProc1('JKW');

CREATE OR REPLACE PROCEDURE userProc2 (
  pi_bYear IN USERTBL.BIRTHYEAR%TYPE,
  pi_height IN USERTBL.HEIGHT%TYPE
) AS
  v_uName VARCHAR(10);
BEGIN
    SELECT userName INTO v_uName FROM userTbl 
         WHERE birthYear = pi_bYear AND height = pi_height;
    DBMS_OUTPUT.PUT_LINE (v_uName);
END ;

EXECUTE userProc2(1971, 177);

CREATE SEQUENCE userSEQ;
CREATE TABLE testTbl (userId INT, txt NCHAR(10)); 

CREATE OR REPLACE PROCEDURE userProc3 (
  pi_txtValue IN NCHAR,
  po_outValue OUT NUMBER
) AS
    v_count VARCHAR(10);
BEGIN
  INSERT INTO testTBL VALUES(userSEQ.NEXTVAL, pi_txtValue);
  SELECT MAX(userID) INTO po_outValue FROM testTBL; 
END ;

DECLARE
    outData NUMBER;
BEGIN
    userProc3('테스트값 1', outData);
    DBMS_OUTPUT.PUT_LINE (outData);
END;

CREATE OR REPLACE PROCEDURE ifElseProc (
  pi_userName IN USERTBL.USERNAME%TYPE 
) AS
    v_bYear NUMBER; -- 출생년도를 저장할 변수
BEGIN
    SELECT birthYear INTO v_bYear FROM userTbl
        WHERE userName = pi_userName;
    IF v_bYear >= 1980 THEN
        DBMS_OUTPUT.PUT_LINE ('아직 젊군요..');
    ELSE
        DBMS_OUTPUT.PUT_LINE ('나이가 지긋하시네요..');
    END IF;
END ;    

EXECUTE ifelseProc ('조용필');

CREATE OR REPLACE PROCEDURE caseProc (
  pi_userName IN USERTBL.USERNAME%TYPE 
) AS
    v_bYear NUMBER; 
    v_mod NUMBER; -- 나머지 값
    v_tti NCHAR(3);   -- 띠
BEGIN
    SELECT birthYear INTO v_bYear FROM userTbl
        WHERE userName = pi_userName;
    v_mod := MOD(v_bYear, 12) ;
    CASE 
        WHEN (v_mod = 0) THEN    v_tti := '원숭이';
        WHEN (v_mod = 1) THEN    v_tti := '닭';
        WHEN (v_mod = 2) THEN    v_tti := '개';
        WHEN (v_mod = 3) THEN    v_tti := '돼지';
        WHEN (v_mod = 4) THEN    v_tti := '쥐';
        WHEN (v_mod = 5) THEN    v_tti := '소';
        WHEN (v_mod = 6) THEN    v_tti := '호랑이';
        WHEN (v_mod = 7) THEN    v_tti := '토끼';
        WHEN (v_mod = 8) THEN    v_tti := '용';
        WHEN (v_mod = 9) THEN   v_tti := '뱀';
        WHEN (v_mod = 10) THEN   v_tti := '말';
        ELSE v_tti := '양';
    END CASE;
    DBMS_OUTPUT.PUT_LINE (pi_userName || '의 띠 ==>' || v_tti);
END ;

EXECUTE caseProc ('김범수');


CREATE TABLE guguTBL (txt VARCHAR(100)); -- 구구단 저장용 테이블

CREATE OR REPLACE PROCEDURE whileProc AS
    v_str VARCHAR(100); -- 출생년도를 저장할 변수
    v_i NUMBER; -- 구구단 앞자리
    v_k NUMBER; -- 구구단 뒷자리
BEGIN
    v_i := 2;  -- 2단부터 처리
    WHILE (v_i < 10) LOOP  -- 바깥 반복문. 2단~9단까지.
        v_str := ''; -- 각 단의 결과를 저장할 문자열 초기화
        v_k := 1; -- 구구단 뒷자리는 항상 1부터 9까지.
        WHILE (v_k < 10) LOOP
            v_str := v_str || '  ' || v_i || 'x' || v_k || '=' || v_i*v_k; -- 문자열 만들기
            v_k := v_k + 1; -- 뒷자리 증가
        END LOOP;
        v_i := v_i + 1; -- 앞자리 증가
        INSERT INTO guguTBL VALUES(v_str); -- 각 단의 결과를 테이블에 입력.
    END LOOP;
END ;    

EXECUTE whileProc();
SELECT * FROM guguTBL;

CREATE OR REPLACE PROCEDURE returnProc (
  pi_userName IN USERTBL.USERNAME%TYPE,
  po_retValue OUT NVARCHAR2
) AS
    v_userID VARCHAR(10);
BEGIN
   SELECT userID INTO v_userID FROM userTbl 
          WHERE userName = pi_userName;
   IF v_userID = NULL THEN
      po_retValue := '그런 사람 없어요 ㅠㅠ';  -- 실패일 경우
   ELSE
      po_retValue := '회원 입니다'; -- 성공일 경우
    END IF;
END ;

DECLARE
    retData NVARCHAR2(30);
BEGIN
    returnProc('은지원', retData);
    DBMS_OUTPUT.PUT_LINE (retData);
END;

DECLARE
    retData NVARCHAR2(30);
BEGIN
    returnProc('나몰라', retData);
    DBMS_OUTPUT.PUT_LINE (retData);
END;

CREATE OR REPLACE PROCEDURE errorProc (
  pi_userName IN USERTBL.USERNAME%TYPE,
  po_retValue OUT NVARCHAR2
) AS
    v_userID VARCHAR(10);
BEGIN
   SELECT userID INTO v_userID FROM userTbl 
          WHERE userName = pi_userName;
   po_retValue := '회원 입니다'; -- 성공일 경우
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
         po_retValue := '그런 사람 없어요 ㅠㅠ' ;
END ;

DECLARE
    retData NVARCHAR2(30);
BEGIN
    errorProc('나몰라', retData);
    DBMS_OUTPUT.PUT_LINE (retData);
END;

CREATE OR REPLACE PROCEDURE errorProc2 (
  pio_userName IN OUT NVARCHAR2
) AS
    v_userID VARCHAR(10);
BEGIN
   SELECT userID INTO v_userID FROM userTbl 
          WHERE userName = pio_userName;
   pio_userName := '회원 입니다'; -- 성공일 경우
   EXCEPTION
      WHEN NO_DATA_FOUND THEN
         pio_userName := '그런 사람 없어요 ㅠㅠ' ;
END ;

DECLARE
    retData NVARCHAR2(30) := '나몰라';
BEGIN
    errorProc2(retData);
    DBMS_OUTPUT.PUT_LINE (retData);
END;

SELECT * FROM USER_OBJECTS
    WHERE OBJECT_TYPE = 'PROCEDURE';

SELECT * FROM USER_SOURCE WHERE NAME='USERPROC1';

CREATE OR REPLACE PROCEDURE encryptProc (
    pi_userID IN USERTBL.USERID%TYPE) 
AS
    v_userName USERTBL.USERNAME%TYPE;
    v_birthYear USERTBL.BIRTHYEAR%TYPE;
BEGIN  
    SELECT SUBSTR(userName,1,1) || 'OO', birthYear 
            INTO v_userName, v_birthYear
       FROM  userTbl WHERE userID = pi_userID;
     DBMS_OUTPUT.put_line(pi_userID || '-->' || v_userName || '(' || v_birthYear || ')');  
END;

EXECUTE encryptProc('JYP');

DROP PROCEDURE encryptProc;
DECLARE
  v_source  VARCHAR2(32767);
BEGIN
  v_source := 
    'CREATE OR REPLACE PROCEDURE encryptProc (' ||
    '    pi_userID IN USERTBL.USERID%TYPE) ' ||    
    'AS' ||
    '    v_userName USERTBL.USERNAME%TYPE;' ||
    '    v_birthYear USERTBL.BIRTHYEAR%TYPE;' ||
    'BEGIN  ' ||
    '    SELECT SUBSTR(userName,1,1) || ''OO'', birthYear ' ||
    '            INTO v_userName, v_birthYear' ||
    '       FROM  userTbl WHERE userID = pi_userID;' ||
    '     DBMS_OUTPUT.put_line(pi_userID || ''-->'' || v_userName || ''('' || v_birthYear || '')'');' ||
    'END;'  ;
  EXECUTE IMMEDIATE DBMS_DDL.WRAP(DDL => v_source);
END;

EXECUTE encryptProc('BBK');


SELECT * FROM USER_SOURCE WHERE NAME='ENCRYPTPROC';

CREATE OR REPLACE PROCEDURE tableProc (
  pi_tableName IN VARCHAR2 )
AS
  v_count NUMBER;
BEGIN
    SELECT COUNT(*) INTO v_count FROM pi_tableName;
    DBMS_OUTPUT.PUT_LINE (v_count);
END ;

CREATE OR REPLACE PROCEDURE tableProc (
  pi_tableName IN VARCHAR2 )
AS
  v_count NUMBER;
  v_sql VARCHAR2(200);
BEGIN
    v_sql := 'SELECT COUNT(*) FROM ' || pi_tableName;
    EXECUTE IMMEDIATE v_sql INTO v_count;
    DBMS_OUTPUT.PUT_LINE (pi_tableName || ' 행 개수--> ' || v_count);
END ;

EXEC tableProc('BUYTBL');


CREATE OR REPLACE PROCEDURE rowtypeProc (
  pi_userid IN USERTBL.USERID%TYPE
) AS
  v_constant CONSTANT NCHAR(3) := '-->';
  v_userData usertbl%ROWTYPE;
BEGIN
    SELECT userName, addr,  height 
        INTO  v_userData.userName, v_userData.addr, v_userData.height
    FROM userTBL WHERE userID = pi_userid;
    DBMS_OUTPUT.PUT_LINE (pi_userid || v_constant ||  v_userData.userName 
      || '  '  || v_userData.addr || '  ' || v_userData.height);
END ;

EXECUTE rowtypeProc('SSK');

CREATE OR REPLACE PROCEDURE recordProc (
  pi_userid IN USERTBL.USERID%TYPE
) AS
  v_constant CONSTANT NCHAR(3) := '-->';
  TYPE myRecordType IS RECORD (r_userName NVARCHAR2(20), r_addr NCHAR(2), r_height NUMBER(3));
  v_record myRecordType;
BEGIN
    SELECT userName, addr,  height 
        INTO  v_record.r_userName, v_record.r_addr, v_record.r_height
    FROM userTBL WHERE userID = pi_userid;
    DBMS_OUTPUT.PUT_LINE (pi_userid || v_constant ||  v_record.r_userName 
      || '  '  || v_record.r_addr || '  ' || v_record.r_height);
END ;

EXECUTE recordProc('LSG');

CREATE OR REPLACE PROCEDURE collectionProc AS
  TYPE myVarrayType IS VARRAY(3) OF NUMBER(10);
  TYPE myNestType IS TABLE OF NVARCHAR2(10);
  TYPE myAssocType IS TABLE OF NUMBER(5) INDEX BY STRING(10);
  v_varray myVarrayType;
  v_nest myNestType;
  v_assoc myAssocType;  
  v_idx VARCHAR2(10);
BEGIN
    v_varray := myVarrayType(10, 20, 30);
    v_nest := myNestType('이것이', '오라클', '학습 중');
    v_assoc('짜장') := 4500;
    v_assoc('피자') := 12000;
    v_assoc('치킨') := 19000;
    FOR i IN 1 .. 3 LOOP
        DBMS_OUTPUT.PUT_LINE (v_varray(i) || '  ' || v_nest(i));
    END LOOP;
    v_idx := v_assoc.FIRST;
    WHILE v_idx IS NOT NULL LOOP
        DBMS_OUTPUT.PUT_LINE (v_idx || '-->' || v_assoc(v_idx));
        v_idx := v_assoc.NEXT(v_idx);
    END LOOP;    
END ;

EXECUTE collectionProc();

---------------- </실습 1> --------------------


------------------------------------
-- 10.2 함수
------------------------------------

CREATE OR REPLACE FUNCTION userFunc(value1 INT, value2 INT)
    RETURN NUMBER
AS    
BEGIN
    RETURN value1 + value2;
END;

SELECT userFunc(100, 200) FROM DUAL;

VAR retValue NUMBER;
EXECUTE :retValue := userFunc(100, 200);
PRINT retValue;

---------------- <실습 2> --------------------

CREATE OR REPLACE FUNCTION getAgeFunc(bYear NUMBER)
    RETURN NUMBER
AS    
    v_age NUMBER;
BEGIN
    v_age := EXTRACT(YEAR FROM SYSDATE) - bYear;
    RETURN  v_age;
END getAgeFunc;

SELECT getAgeFunc(1979) FROM DUAL;

VAR retValue NUMBER;
EXECUTE :retValue := getAgeFunc(1979);
PRINT retValue;

SELECT userID, userName, getAgeFunc(birthYear) AS "만 나이" FROM userTbl;

CREATE OR REPLACE FUNCTION blindFunc(uString NCHAR)
    RETURN NCHAR
AS    
    v_string NCHAR(20) := '';
BEGIN
    IF uString = '-' THEN -- '-'는 전화번호가 없는 사용자.
        RETURN  v_string;
    END IF;
    
    IF SUBSTR(uString, 1, 1) = '0' THEN  -- 제일 앞이 0이면 전화번호
        v_string := CONCAT( SUBSTR(uString, 1, 8), '-xxxx');
    ELSE    
        v_string := CONCAT( SUBSTR(uString, 1, 1), 'OO');
    END IF;
    RETURN  v_string;
END blindFunc;

SELECT blindFunc(userName) AS "회원", 
    blindFunc(mobile1 || '-' || mobile2) AS "연락처" FROM userTBL;

---------------- </실습 2> --------------------


---------------- <실습 3> --------------------

CREATE OR REPLACE TYPE tableRowType AS OBJECT
( uName NCHAR(5), bYear NUMBER);


CREATE OR REPLACE TYPE tableType AS TABLE OF tableRowType;

CREATE OR REPLACE FUNCTION tableReturnFunc(nameString NVARCHAR2, birthString NVARCHAR2)
    RETURN tableType
    PIPELINED
AS    
    v_nameString NVARCHAR2(500) := nameString;
    v_birthString NVARCHAR2(500) := birthString;
    v_rowType tableRowType; -- 1개 행 (이름, 생년)
    v_nameIdx NUMBER;  -- 이름 문자열에서 추출할 이름의 현재 위치
    v_birthIndex NUMBER; -- 생년 문자열에서 추출할 생년의 현재 위치
    v_name NCHAR(5); -- 추출한 1개의 이름 문자열
    v_birth NUMBER;  -- 추출한 1개의 생년 숫자
BEGIN
    LOOP
        v_nameIdx := INSTR(v_nameString, ',');
        v_birthIndex := INSTR(v_birthString, ',');
        IF v_nameIdx > 0 AND v_birthIndex > 0 THEN
            v_name := SUBSTR(v_nameString, 1, v_nameIdx-1);
            v_birth := TO_NUMBER(SUBSTR(v_birthString, 1, v_birthIndex-1));
            v_rowType := tableRowType(v_name, v_birth);
            PIPE ROW(v_rowType);
            v_nameString := SUBSTR(v_nameString, v_nameIdx+1);
            v_birthString := SUBSTR(v_birthString, v_birthIndex+1);
        ELSE
            v_rowType := tableRowType(v_nameString, v_birthString); -- 나머지 값 대입
            PIPE ROW(v_rowType);
            EXIT;
        END IF;
    END LOOP;
    RETURN;
END tableReturnFunc;

SELECT * FROM TABLE(tableReturnFunc('토마스,제임스,고든,에밀리','1990, 1995, 1993,1999'));

---------------- </실습 3> --------------------

------------------------------------
-- 10.3 커서
------------------------------------

---------------- <실습 4> --------------------

CREATE OR REPLACE PROCEDURE cursorProc AS
  v_height NUMBER; -- 회원의 키
  v_cnt  NUMBER := 0 ; -- 회원의 인원수 (= 읽은 행의 수)
  v_total NUMBER := 0 ; -- 회원 키의 합계
  -- (1) 커서 선언
  CURSOR userCursor IS  
        SELECT height FROM userTbl;
BEGIN
    -- (2) 커서 열기
    OPEN userCursor;
    -- (3) 커서에서 데이터 가져오기 및 (4) 데이터 처리
    LOOP 
        FETCH  userCursor INTO v_height;
        EXIT WHEN userCursor%NOTFOUND; -- 데이터가 없으면 LOOP 종료
        v_total := v_total + v_height;
        v_cnt := v_cnt + 1;    
    END LOOP;
    -- (5) 커서 닫기
    CLOSE userCursor;
    DBMS_OUTPUT.PUT_LINE('회원 키의 평균 ==>' || (v_total/v_cnt));
END ;

SET SERVEROUTPUT ON;
EXECUTE cursorProc();

ALTER TABLE userTbl ADD grade NVARCHAR2(5);  -- 회원 등급 열 추가

CREATE OR REPLACE PROCEDURE gradeProc AS
  v_id CHAR(8); -- 회원 아이디
  v_total NUMBER(5) := 0 ; -- 총 구매액
  v_grade NVARCHAR2(5); -- 회원 등급
  -- (1) 커서 선언
  CURSOR userCursor IS  
    SELECT U.userid, SUM(price*amount)
        FROM buyTbl B
            RIGHT OUTER JOIN userTbl U
            ON B.userid = U.userid
        GROUP BY U.userid, U.userName ;
BEGIN
    -- (2) 커서 열기
    OPEN userCursor;
    -- (3) 커서에서 데이터 가져오기 및 (4) 데이터 처리
    LOOP 
        FETCH  userCursor INTO v_id, v_total;
        EXIT WHEN userCursor%NOTFOUND; -- 데이터가 없으면 LOOP 종료
        CASE  
            WHEN (v_total >= 1500) THEN  v_grade := '최우수회원';
            WHEN (v_total  >= 1000) THEN v_grade :='우수회원';
            WHEN (v_total >= 1) THEN  v_grade :='일반회원';
            ELSE  v_grade :='유령회원';
         END CASE;
         UPDATE userTbl SET grade = v_grade WHERE userID = v_id;
    END LOOP;
    -- (5) 커서 닫기
    CLOSE userCursor;
END ;


EXEC gradeProc();
SELECT userId, userName, grade FROM userTBL;

---------------- </실습 4> --------------------


------------------------------------
-- 10.4 패키지
------------------------------------

SELECT * FROM ALL_OBJECTS  WHERE  OBJECT_TYPE ='PACKAGE';

SELECT * FROM ALL_PROCEDURES  WHERE OBJECT_NAME = 'DBMS_OUTPUT';

SELECT TEXT FROM ALL_SOURCE WHERE NAME = 'DBMS_OUTPUT';

---------------- <실습 5> --------------------

CREATE OR REPLACE PACKAGE totalPackage AS
    v_age NUMBER;
    v_bYear NUMBER;
    PROCEDURE sampleProc(pi_userName IN NCHAR);
    FUNCTION sampleFunc(bYear NCHAR) RETURN NUMBER;
END totalPackage;


CREATE OR REPLACE PACKAGE BODY totalPackage AS
    PROCEDURE sampleProc(pi_userName IN NCHAR) AS
    BEGIN
        SELECT birthYear INTO v_bYear FROM userTbl 
            WHERE userName = pi_userName;
        DBMS_OUTPUT.PUT_LINE ('나이 --> ' || sampleFunc(v_bYear));
    END sampleProc;
    
    FUNCTION sampleFunc(bYear NCHAR) 
        RETURN NUMBER    AS    
    BEGIN
        v_age := EXTRACT(YEAR FROM SYSDATE) - bYear;
        RETURN  v_age;
    END sampleFunc;
END totalPackage;

EXECUTE totalPackage.sampleProc('이승기');
SELECT totalPackage.sampleFunc(birthYear) FROM userTBL 
    WHERE userName = '이승기';

---------------- </실습 5> --------------------









