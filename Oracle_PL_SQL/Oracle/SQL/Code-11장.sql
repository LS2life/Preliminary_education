/*
   [이것이 Oracle이다] 소스 코드
   11장. 트리거
*/

------------------------------------
-- 11.1 트리거의 개념
------------------------------------


------------------ <실습 1> ------------------
SET SERVEROUTPUT ON; 
CREATE TABLE testTBL (id NUMBER, txt NVARCHAR2(5));
INSERT INTO testTBL VALUES(1, '원더걸스');
INSERT INTO testTBL VALUES(2, '블랙핑크');
INSERT INTO testTBL VALUES(3, '구구단');

CREATE OR REPLACE TRIGGER testTrg  -- 트리거 이름
    AFTER DELETE  OR UPDATE -- 삭제 및 수정 후에 작동하게 지정
    ON  testTBL -- 트리거를 부착할 테이블
    FOR EACH ROW -- 각 행마다 적용됨
BEGIN
    DBMS_OUTPUT.PUT_LINE('트리거가 작동했습니다') ; -- 트리거 실행시 작동되는 코드들
END;

BEGIN
   INSERT INTO testTBL VALUES(4, '나인뮤지스');
   UPDATE testTBL SET txt = '에이핑크' WHERE id = 3;
   DELETE testTBL WHERE id = 4;
END;

------------------ </실습 1> ------------------



------------------------------------
-- 11.2 트리거의 사용법
------------------------------------


------------------ <실습 2> ------------------
DROP TABLE buyTBL; -- 구매테이블은 실습에 필요없으므로 삭제.
CREATE TABLE backup_userTBL
( userID  	CHAR(8) NOT NULL PRIMARY KEY, 
  userName  NVARCHAR2(10) NOT NULL,
  birthYear NUMBER(4) NOT NULL,  
  addr	  	NCHAR(2) NOT NULL, 
  mobile1  CHAR(3), 
  mobile2  CHAR(8), 
  height   NUMBER(3), 
  mDate    DATE,
  modType  NCHAR(2), -- 변경된 타입. '수정' 또는 '삭제'
  modDate  DATE, -- 변경된 날짜
  modUser  NVARCHAR2(256) -- 변경한 사용자
);

CREATE OR REPLACE TRIGGER trg_BackupUserTBL  -- 트리거 이름
   AFTER  UPDATE OR DELETE  -- 삭제,수정 후에 작동하도록 지정
   ON userTBL -- 트리거를 부착할 테이블
   FOR EACH ROW -- 각 행마다 적용됨
DECLARE 
   v_modType NCHAR(2); -- 변경 타입
BEGIN
   IF UPDATING THEN  -- 업데이트 되었다면
      v_modType := '수정';
   ELSIF DELETING  THEN -- 삭제되었다면,
      v_modType := '삭제';
    END IF;
   -- :OLD 테이블의 내용(변경전의 내용)을 백업테이블에 삽입
    INSERT INTO backup_userTBL VALUES( :OLD.userID, :OLD.userName, :OLD.birthYear, 
        :OLD.addr, :OLD.mobile1, :OLD.mobile2, :OLD.height, :OLD.mDate, 
        v_modType, SYSDATE(), USER() );
END trg_BackupUserTBL;

UPDATE userTBL SET addr = '몽고' WHERE userID = 'JKW';
DELETE userTBL WHERE height >= 177;

SELECT * FROM backup_userTBL;

TRUNCATE TABLE userTBL;

SELECT * FROM backup_userTBL;


DROP TRIGGER trg_BackupUserTBL;

SET SERVEROUTPUT ON; 
CREATE OR REPLACE TRIGGER trg_insertUserTBL
   AFTER INSERT  -- 삽입 후에 작동하도록 지정
   ON userTBL 
   FOR EACH ROW 
BEGIN
    DBMS_OUTPUT.PUT_LINE('데이터의 입력을 시도했습니다.');
    DBMS_OUTPUT.PUT_LINE('귀하의 정보가 서버에 기록되었습니다.');
    DBMS_OUTPUT.PUT_LINE('그리고, 입력한 데이터는 적용되지 않았습니다.');
    RAISE_APPLICATION_ERROR(-20999,'입력 시도 발견 !!!');
END;

BEGIN
    INSERT INTO userTBL VALUES('ABC', '에비씨', 1977, '서울', '011', '1111111', 181, '2019-12-25');
END;

DROP TRIGGER trg_insertUserTBL;
------------------ </실습 2> ------------------

------------------ <실습 3> ------------------
CREATE OR REPLACE TRIGGER trg_changeUserTBL
   BEFORE INSERT  -- 삽입 전에 작동하도록 지정
   ON userTBL 
   FOR EACH ROW 
BEGIN
    :NEW.userName := SUBSTR(:NEW.userName, 1, 1) || 'OO';
    :NEW.birthYear := :NEW.birthYear + 2333;
END;

INSERT INTO userTBL VALUES('ABC', '에비씨', 1977, '서울', '011', '1111111', 181, '2019-12-25');
SELECT * FROM  USERTBL;

CREATE OR REPLACE TRIGGER trg_columnChange
   AFTER UPDATE OF userName -- 이름 열에 업데이트가 작동되면
   ON userTBL 
   FOR EACH ROW 
BEGIN
    RAISE_APPLICATION_ERROR(-20888,'이름은 변경이 안됩니다. !!!');
END;

UPDATE userTBL SET addr='우주' WHERE userID = 'ABC';
UPDATE userTBL SET userName='무명씨' WHERE userID = 'ABC';

------------------ </실습 3> ------------------

------------------ <실습 4> ------------------
CREATE VIEW v_deliver -- 배송정보를 위한 뷰
AS
	SELECT b.userid, u.userName, b.prodName, b.price, b.amount, u.addr
	FROM buyTBL b
		INNER JOIN userTBL u
		ON b.userid = u.userid;

SELECT * FROM v_deliver;

INSERT INTO v_deliver VALUES ('SDY', '신동엽', '구두', 50, 1, '인천');


CREATE OR REPLACE TRIGGER trg_viewInsert
   INSTEAD OF INSERT  -- 삽입작업 대신에 작동 작동하도록 지정
   ON v_deliver  -- 뷰에 장착
   FOR EACH ROW 
BEGIN
   INSERT INTO userTBL(userID, userName,birthYear, addr, mDate)
     VALUES (:NEW.userid, :NEW.userName, 0, :NEW.addr, SYSDATE);
   INSERT INTO buyTBL(idNum, userID, prodName, price, amount)
     VALUES (idSEQ.NEXTVAL, :NEW.userID, :NEW.prodName, :NEW.price, :NEW.amount);
END;

INSERT INTO v_deliver VALUES ('SDY', '신동엽', '구두', 50, 1, '인천');

SELECT * FROM userTBL WHERE userid = 'SDY';
SELECT * FROM buyTBL WHERE userid = 'SDY';

SELECT * FROM USER_TRIGGERS;

SELECT * FROM USER_SOURCE WHERE NAME = UPPER('trg_viewInsert');

DROP VIEW v_deliver;

------------------ </실습 4> ------------------


------------------------------------
-- 11.3 기타 트리거에 관한 사항
------------------------------------

------------------ <실습 5> ------------------
CREATE SEQUENCE orderSEQ; -- 구매 일련번호용
CREATE SEQUENCE deliverSEQ; -- 배송 일련번호용
CREATE TABLE orderTBL -- 구매 테이블
	(orderNo NUMBER, -- 구매 일련번호
          userID NVARCHAR2(5), -- 구매한 회원아이디
	 prodName NVARCHAR2(5), -- 구매한 물건
	 orderAmount NUMBER );  -- 구매한 개수
CREATE TABLE prodTBL -- 물품 테이블
	( prodName NVARCHAR2(5), -- 물건 이름
	  account NUMBER ); -- 남은 물건수량
CREATE TABLE deliverTBL -- 배송 테이블
	( deliverNo NUMBER, -- 배송 일련번호
	  prodName NVARCHAR2(5), -- 배송할 물건		  
	  amount NUMBER ); -- 배송할 물건개수

INSERT INTO prodTBL VALUES('사과', 100);
INSERT INTO prodTBL VALUES('배', 100);
INSERT INTO prodTBL VALUES('귤', 100);

-- 물품 테이블에서 개수 감소시키는 트리거
CREATE OR REPLACE TRIGGER trg_order 
   AFTER INSERT 
   ON orderTbl
   FOR EACH ROW 
DECLARE
   v_orderAmount NUMBER;
   v_prodName NVARCHAR2(5);
BEGIN
   DBMS_OUTPUT.PUT_LINE('1. trg_order를 실행합니다.');
   SELECT :NEW.orderAmount INTO v_orderAmount FROM DUAL;
   SELECT :NEW.prodName INTO v_prodName FROM DUAL;
   UPDATE prodTbl SET account = account - v_orderAmount 
       WHERE prodName = v_prodName ;
END;

-- 배송테이블에 새 배송 건을 입력하는 트리거
CREATE OR REPLACE TRIGGER trg_prod 
   AFTER UPDATE 
   ON prodTbl
   FOR EACH ROW 
DECLARE
   v_amount NUMBER;
   v_prodName NVARCHAR2(5);
BEGIN
   DBMS_OUTPUT.PUT_LINE('2. trg_prod를 실행합니다.');
   SELECT :NEW.prodName INTO v_prodName FROM DUAL;
   -- (변경 전의 개수 - 변경 후의 개수) = 주문 개수
  SELECT :OLD.account - :NEW.account INTO v_amount FROM DUAL;

  INSERT INTO deliverTbl(deliverNo, prodName, amount)
        VALUES(deliverSEQ.NEXTVAL, v_prodName, v_amount);
END;

SET SERVEROUTPUT ON; 
BEGIN
    INSERT INTO orderTbl VALUES (orderSEQ.NEXTVAL, 'JOHN', '배',5);
END;

SELECT * FROM orderTbl;
SELECT * FROM prodTbl;
SELECT * FROM deliverTbl;

ALTER TABLE deliverTBL 
    RENAME COLUMN prodName TO productName;

BEGIN
    INSERT INTO orderTbl VALUES (orderSEQ.NEXTVAL, 'DANG', '사과', 9);
END;

ALTER TABLE deliverTBL 
    RENAME COLUMN productName TO prodName;
BEGIN
    INSERT INTO orderTbl VALUES (orderSEQ.NEXTVAL,'DANG', '사과', 9);   
END;

------------------ </실습 5> ------------------

------------------ <실습 6> ------------------
CREATE SEQUENCE aSEQ; -- 간접 재귀용 시퀀스
CREATE SEQUENCE bSEQ; -- 간접 재귀용 시퀀스
CREATE TABLE recuA  (id NUMBER, txt NVARCHAR2(10)); -- 간접 재귀 트리거용 테이블A
CREATE TABLE recuB  (id NUMBER, txt NVARCHAR2(10)); -- 간접 재귀 트리거용 테이블B

CREATE TABLE countTBL (cnt NUMBER); -- 트리거의 단계 숫자가 저장될 테이블
INSERT INTO countTBL VALUES (0); -- 0부터 이 값을 트리거에서 UPDATE 시킴.

CREATE OR REPLACE TRIGGER trg_recuA 
   AFTER  INSERT 
   ON recuA 
DECLARE
   v_count NUMBER; -- 반복 횟수용
BEGIN
   SELECT cnt INTO v_count FROM countTBL;

   v_count := v_count + 1;
   DBMS_OUTPUT.PUT_LINE( v_count || ' --> trg_recuA 를 실행합니다.');
   UPDATE countTBL SET cnt = v_count;    
   INSERT INTO recuB VALUES (bSEQ.NEXTVAL, '간접 재귀 트리거');
END;

CREATE OR REPLACE TRIGGER trg_recuB 
   AFTER  INSERT 
   ON recuB
DECLARE
   v_count NUMBER; -- 반복 횟수용
BEGIN
    SELECT cnt INTO v_count FROM countTBL;

    v_count := v_count + 1;
   DBMS_OUTPUT.PUT_LINE( v_count || ' --> trg_recuB를 실행합니다.');
    UPDATE countTBL SET cnt = v_count;    
   INSERT INTO recuA VALUES (aSEQ.NEXTVAL, '간접 재귀 트리거');
END;

BEGIN
    INSERT INTO recuA VALUES (aSEQ.NEXTVAL, '처음입력값');
END;

SELECT * FROM recuA;
SELECT * FROM recuB;


CREATE OR REPLACE TRIGGER trg_recuA 
   AFTER  INSERT 
   ON recuA 
DECLARE
   v_count NUMBER; -- 반복 횟수용
BEGIN
   SELECT cnt INTO v_count FROM countTBL;
   IF v_count >= 49 THEN
            RETURN;
   END IF;
   v_count := v_count + 1;
   DBMS_OUTPUT.PUT_LINE( v_count || ' --> trg_recuA 를 실행합니다.');
   UPDATE countTBL SET cnt = v_count;    
   INSERT INTO recuB VALUES (bSEQ.NEXTVAL, '간접 재귀 트리거');
END;

CREATE OR REPLACE TRIGGER trg_recuB 
   AFTER  INSERT 
   ON recuB
DECLARE
   v_count NUMBER; -- 반복 횟수용
BEGIN
    SELECT cnt INTO v_count FROM countTBL;
   IF v_count >= 49 THEN
            RETURN;
   END IF;
    v_count := v_count + 1;
   DBMS_OUTPUT.PUT_LINE( v_count || ' --> trg_recuB를 실행합니다.');
    UPDATE countTBL SET cnt = v_count;    
   INSERT INTO recuA VALUES (aSEQ.NEXTVAL, '간접 재귀 트리거');
END;

-- 시퀀스 초기화
DROP SEQUENCE aSEQ;
CREATE SEQUENCE aSEQ;
DROP SEQUENCE bSEQ;
CREATE SEQUENCE bSEQ;
UPDATE countTBL SET cnt = 0;  -- 카운트 테이블 초기화
BEGIN      
    INSERT INTO recuA VALUES (aSEQ.NEXTVAL, '처음입력값');
END;

SELECT * FROM recuA;
SELECT * FROM recuB;

------------------ </실습 6> ------------------

------------------ <실습 7> ------------------

CREATE TABLE autoTable (
    seqNum NUMBER NOT NULL PRIMARY KEY, 
    TXT NVARCHAR2(20));

CREATE SEQUENCE autoSEQ
    START WITH 10000   -- 시작값
    INCREMENT BY 1 ;  -- 증가값

CREATE OR REPLACE TRIGGER trg_autoSEQ 
  BEFORE INSERT 
  ON autoTable 
  FOR EACH ROW 
BEGIN
  IF INSERTING AND :NEW.seqNum IS NULL THEN
    SELECT autoSEQ.NEXTVAL INTO :NEW.seqNum FROM DUAL;
  END IF;
END;

INSERT INTO autoTable VALUES(NULL, '이것이');
INSERT INTO autoTable VALUES(NULL, '오라클');
INSERT INTO autoTable VALUES(NULL, '이다');
SELECT * FROM autoTable;


------------------ </실습 7> ------------------

