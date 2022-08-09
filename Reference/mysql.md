> # mysql

- SQL (structured Query Language)
- DML, DDL, DCL

- ### 명령어를 잘써야된다 Cli가 제일 편함

  - create database
  - grant
  - flush privileges
  - select
  
- ### database 생성 및 접속

  - root로 접속

  ```console
  mysql -uroot -p 
  ```

  - database 생성

  ```mysql
  mysql> create database DB이름;
  ```

  - 새로운 사용자 생성, 권한주기

  ```mysql
  mysql> grant all privileges on db이름.* to 계정이름@'%' identified by ' 암호';
  mysql> grant all privileges on db이름.* to 계정이름@'localhost' identified by ' 암호';
  mysql> flush privileges;
  ```

  - 생성한 DB접속

  ```console
  mysql -h호스트명 -uDB계정명 -p 데이터베이스이름
  ```

- ### 연결끊기

  ```mysql
  mysql> QUIT
  mysql> exit
  bye
  ```

<br>

- ### 버전과 날짜

  - 키워드는 대소문자를 구분하지 않는다
  - 세미콜론으로 끝난다.
  - SQL = query 쿼리 라고 읽는다.

  ```mysql
  mysql> select version(), current_date;
  +------------+--------------+
  | version()  | current_date |
  +------------+--------------+
  | 5.7.21-log | 2022-07-22   |
  +------------+--------------+
  1 row in set (0.01 sec)
  ```

<br>

- ### DB전환

  - 어떤 DB가 있는지 알고 있어야한다.

  ```mysql
  mysql> show databases;
  +--------------------+
  | Database           |
  +--------------------+
  | information_schema |
  | connectdb          |
  +--------------------+
  2 rows in set (0.00 sec)
  
  mysql> use mydb;
  ```

<br>

- ### 테이블을 보자

  ```mysql
  mysql> show table;
  +-----------------------+
  | Tables_in_connectdb   |
  +-----------------------+
  | bonus                 |
  | department            |
  | employee              |
  | project               |
  | project_participation |
  | role                  |
  | salarygrade           |
  +-----------------------+
  7 rows in set (0.00 sec)
  ```

  - 보는김에 employee테이블을 조금 더 자세히 보자.

  ```mysql
  mysql> desc employee;
  +----------+--------------+------+-----+---------+-------+
  | Field    | Type         | Null | Key | Default | Extra |
  +----------+--------------+------+-----+---------+-------+
  | empno    | int(11)      | NO   | PRI | NULL    |       |
  | name     | varchar(10)  | YES  |     | NULL    |       |
  | job      | varchar(9)   | YES  |     | NULL    |       |
  | boss     | int(11)      | YES  | MUL | NULL    |       |
  | hiredate | varchar(12)  | YES  |     | NULL    |       |
  | salary   | decimal(7,2) | YES  |     | NULL    |       |
  | comm     | decimal(7,2) | YES  |     | NULL    |       |
  | deptno   | int(11)      | YES  | MUL | NULL    |       |
  +----------+--------------+------+-----+---------+-------+
  8 rows in set (0.00 sec)
  ```

<br/>

- ## DML

  - Data Manipulation Language, 데이터 조작어
    - select, insert, update, delete
    - 조회 , 수정삽입 ,  수정 , 삭제

  ```mysql
  mysql> select(distinct) 칼럼명(alias) from 테이블명;
  ```

  - select  :  검색하고자 하는 데이터(칼럼)을 나열한다. *로 전체 데이터 검색.
    - 예)  departments 테이블의 모든 데이터를 출력해보세요.

    ```mysql
    mysql> select * from department;
    ```

  - distinct  :  중복행 제거.
  - alias  :  나타날 칼럼에 대한 다른 이름 부여.
  - from  :  선택한 칼럼이 있는 테이블을 명시.
