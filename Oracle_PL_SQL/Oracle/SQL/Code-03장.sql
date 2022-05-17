/*
   [이것이 Oracle이다] 소스 코드
   3장. Oracle 전체 운영 실습 
*/

------------------------------------
-- 3.2. Oracle을 이용한 스키마 구축 절차
------------------------------------

SELECT * FROM memberTBL;

SELECT memberName, memberAddress FROM memberTBL;

SELECT * FROM memberTBL WHERE memberName = '지운이' ;

CREATE TABLE "my testTBL" (id NUMBER(3));

DROP TABLE "MY TESTTBL";

DROP TABLE "my testTBL";

------------------------------------
-- 3.3 테이블 외의 데이터베이스 개체의 활용
------------------------------------

CREATE TABLE Shop.indexTBL 
AS
    SELECT first_name, last_name, hire_date 
    FROM HR.employees;

SELECT * FROM Shop.indexTBL;

SELECT * FROM indexTBL WHERE first_name = 'Jack';

CREATE INDEX idx_indexTBL_firstname ON indexTBL(first_name);

SELECT * FROM indexTBL WHERE first_name = 'Jack';

CREATE VIEW Shop.memberTBL_view AS
    SELECT memberName, memberAddress FROM Shop.memberTBL ;

SELECT * FROM memberTBL_view ;

SELECT COUNT(*) FROM memberTBL;
SELECT COUNT(*) FROM productTBL ;


CREATE PROCEDURE Shop.myProc AS
 var1 INT;
 var2 INT;
BEGIN
    SELECT COUNT(*) INTO var1 FROM Shop.memberTBL;
    SELECT COUNT(*) INTO var2 FROM Shop.productTBL;
    DBMS_OUTPUT.PUT_LINE(var1+var2);
END ;

-- 결과가 출력되기 위한 설정
SET SERVEROUTPUT ON; 
-- 저장 프로시저 호출
EXECUTE myProc;

DROP PROCEDURE Shop.myProc;

INSERT INTO memberTBL VALUES ('Figure', '연아', '경기도 군포시 당정동');

SELECT * FROM memberTBL ;

UPDATE memberTBL SET memberAddress = '서울 강남구 역삼동' WHERE memberName = '연아';

SELECT * FROM memberTBL ;

DELETE FROM memberTBL WHERE memberName = '연아';

SELECT * FROM memberTBL ;

CREATE TABLE deletedMemberTBL (  
	memberID char(8) ,
	memberName nchar(5) ,
	memberAddress nvarchar2(20),
	deletedDate date  -- 삭제한 날짜
);

CREATE TRIGGER trg_deletedMemberTBL  -- 트리거 이름
    AFTER DELETE -- 삭제 후에 작동하게 지정
    ON memberTBL -- 트리거를 부착할 테이블
    FOR EACH ROW -- 각 행마다 적용됨
BEGIN 
	-- :old 테이블의 내용을 백업테이블에 삽입
	INSERT INTO deletedMemberTBL 
		VALUES (:old.memberID, :old.memberName, :old.memberAddress, SYSDATE() ); 
END ;

SELECT * FROM memberTBL;

DELETE FROM memberTBL WHERE memberName = '당탕이';

SELECT * FROM memberTBL;

SELECT * FROM deletedMemberTBL;

------------------------------------
-- 3.4 데이터의 백업 및 복원
------------------------------------

SELECT * FROM productTBL;

/* 명령 프롬프트에서 진행
exp  userid=SYSTEM/1234@xe  OWNER=Shop  FILE=C:\DB백업\Shop01.dmp
*/

DROP TABLE productTBL;

SELECT * FROM productTBL;

/* 명령 프롬프트에서 진행
imp  userid=SYSTEM/1234@xe  FROMUSER=Shop TOUSER=Shop  FILE=C:\DB백업\Shop01.dmp TABLES=(productTBL)
*/

SELECT * FROM productTBL;














