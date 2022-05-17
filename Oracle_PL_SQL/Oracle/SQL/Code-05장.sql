/*
   [이것이 Oracle이다] 소스 코드
   5장. Oracle 유틸리티 사용법  
*/

------------------------------------
-- 5.1. SQL Developer 
------------------------------------

/* 다음은 명령 프롬프트에서 SQL*Plus에 접속해서 수행

sqlplus Shop/1234@XE -- 명령 프롬프트

CREATE TABLE carTable(id INT, data VARCHAR2(20)) ;
INSERT INTO carTable VALUES( 1000, 'SM6');
INSERT INTO carTable VALUES( 1000, 'K5');
INSERT INTO carTable VALUES( 1000, 'SONATA');
SELECT * FROM carTable;

HELP INDEX 

HELP RUN
HELP SELECT

DESCRIBE carTable 
LIST 
RUN 

APPEND ORDER BY data
LIST 
RUN 
DEL
LIST

SHOW USER 
CONNECT HR/1234@XE 
SHOW USER

SELECT  first_name, last_name, email, phone_number  FROM  employees;

COLUMN FIRST_NAME HEADING "이름" FORMAT A15
COLUMN LAST_NAME HEADING "성" FORMAT A20
COLUMN EMAIL HEADING "이메일" FORMAT A20
COLUMN PHONE_NUMBER HEADING "휴대폰" FORMAT A20

SAVE C:/temp/sqlfile
HOST
DIR C:\Temp\*.sql 
TYPE C:\Temp\sqlfile.sql
EXIT
START C:\Temp\sqlfile.sql 

SPOOL C:\Temp\myQuery 
SELECT * FROM REGIONS;
SELECT COUNT(*) FROM LOCATIONS;
SPOOL OFF 
HOST
NOTEPAD C:\Temp\myQuery.lst
EXIT

EXIT
*/

------------------------------------
-- 5.2. 외부 Oracle 서버 관리하기
------------------------------------

/* 다음은 Linux 및 명령 프롬프트에서 수행

ip addr

ping 192.168.111.135

*/

SELECT * FROM dba_users; 

CREATE  USER  myDB  IDENTIFIED  BY  "1234" 
    DEFAULT  TABLESPACE  "USERS" ;
    
GRANT  CONNECT, RESOURCE  TO  myDB;

CREATE TABLE myTBL (tvName NCHAR(10));
INSERT INTO myTBL VALUES ('미스터몽크');
SELECT * FROM myTBL;

/* 다음은 Linux에서 수행

sqlplus myDB/1234 

INSERT INTO myTBL VALUES ('Mr. Monk');
COMMIT;
SELECT * FROM myTBL;;

exit
shutdown -h now

*/


------------------------------------
-- 5.3. 사용자 관리하기
------------------------------------

/* 다음은 사용자 생성 창에서 추가

-- SYSTEM PRIVILEGES
GRANT ALL ON Shop.memberTBL TO staff ;
GRANT ALL ON Shop.productTBL TO staff ;

GRANT SELECT ON HR.COUNTRIES TO staff ;
GRANT SELECT ON HR.DEPARTMENTS TO staff ;
GRANT SELECT ON HR.EMPLOYEES TO staff ;
GRANT SELECT ON HR.JOBS TO staff ;
GRANT SELECT ON HR.JOB_HISTORY TO staff ;
GRANT SELECT ON HR.LOCATIONS TO staff ;
GRANT SELECT ON HR.REGIONS TO staff ;
*/

/* 다음은 SQL*Plus 에서 실행 

sqlplus director/director@XE 

SHOW USER
CREATE USER sampleUser IDENTIFIED BY 1234 ;
DROP USER sampleUser ;

CONNECT ceo/ceo@XE 

SELECT memberID FROM Shop.memberTBL;
SELECT * FROM HR.REGIONS;

DELETE FROM Shop.memberTBL; 

CONNECT staff/staff@XE 

SELECT memberID FROM Shop.memberTBL;
DELETE FROM Shop.memberTBL WHERE memberID = 'Sang';

DROP TABLE Shop.memberTBL;

SELECT * FROM HR.REGIONS;
DELETE FROM HR.REGIONS;

EXIT
*/