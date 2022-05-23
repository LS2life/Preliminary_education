-- 뷰(view) 보는 용도로 주로 쓰는 테이블 같은 형태
select * from usertbl;

create view v_usertbl
as select userid,username,addr from usertbl;

select * from v_usertbl;
-- view 장점 보안성이 좋다
-- 복잡한 쿼리를 단순화 시킬수 있다
select u.userid,u.username,b.prodname,u.addr,u.mobile1||u.mobile2,
b.price,b.amount
from usertbl u
inner join buytbl b
on u.userid=b.userid;

create or replace view v_userbuytbl
as select u.userid,u.username,b.prodname,u.addr,
u.mobile1||u.mobile2 as "연락처",
b.price,b.amount
from usertbl u
inner join buytbl b
on u.userid=b.userid;
select * from v_userbuytbl;
select * from v_userbuytbl
where username='김범수';
select username,prodname from v_userbuytbl;

create or replace view v_userbuytbl
as
select u.userid as "사용자아이디",
u.username as "이름,
b.prodname as "제품 이름",
u.addr as "주소"
from usertbl u
inner join buytbl b
on u.userid=b.userid;






