create or replace view v_userbuytbl
as
select u.userid as "사용자아이디",
u.username as "이름",
b.prodname as "제품 이름",
u.addr as "주소"
from usertbl u
inner join buytbl b
on u.userid=b.userid;