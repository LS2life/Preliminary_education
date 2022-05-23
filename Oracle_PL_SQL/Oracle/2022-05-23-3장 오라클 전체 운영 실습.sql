create user shop identified by "1234"
default tablespace "USERS"
temporary tablespace "TEMP";

grant "CONNECT" to shop;
grant "RESOURCE" to shop;