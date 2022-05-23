--7장 실습 세개의 테이블
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