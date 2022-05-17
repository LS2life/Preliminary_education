-- [로컬-SYSTEM]에서 연결한 후 실행
DROP USER sqlDB CASCADE; -- 기존 사용자 삭제
CREATE USER sqlDB IDENTIFIED BY 1234 -- 사용자 이름: sqlDB, 비밀번호 : 1234
    DEFAULT TABLESPACE USERS
    TEMPORARY TABLESPACE TEMP;
GRANT connect, resource, dba TO sqlDB; -- 권한 부여
