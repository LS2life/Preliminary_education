select * from tab;

select * from userTBL;
select * from buytbl;

select * from usertbl where username='이승기';

--1970년 이후에 출생 신장이 182이상 아이디와 이름 조회
select userid,username 
from usertbl 
where birthyear >=1970
and height>=182;

-- 1970년도 이후 출생했거나 신장이 182이상 아이디와 이름
select userid,username from usertbl 
where birthyear>=1970 or height>=182;

-- 키가 180~183인 사람
select * from usertbl where height>=180 and height<=183;
-- between
select * from usertbl where height between 180 and 183;
-- in('문자열','문자열')
-- 경남,전남,경북 addr='경남' or addr='전남'
select * from usertbl where addr in('경남','전남','경북');

-- like 1.i like java 2. you looks like tired ~와 비슷하다
-- 김씨를 찾는다
--%->뭐든지 와도 된다
-- _->뭐든지 오는데 한글자만
-- 선우, 독고
select * from usertbl where username like '김%';
--종신 이름을 찾는다
select * from usertbl where username like '_종신';



















