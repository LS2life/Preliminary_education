create database connectdb;
grant all privileges on connectdb.* to connectuser@'localhost' identified by 'connect123!@#';
flush privileges;
show databases;