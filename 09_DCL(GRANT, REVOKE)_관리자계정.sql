/*
    <DCL: DATA CONTROL LANGUAGE>
    데이터 제어 언어
    
    계정에게 시스템 권한 또는 객체 접근 권한을 부여(GRANT) 하거나 회수(REVOKE) 하는 언어
     
    *권한 부여(GRANT)
    - 시스템 권한: 특정 DB에 접근하는 권한, 객체들을 생성할 수 있는 권한
    - 객체 접근 권한: 특정 객체들에 접근해서 조작할 수 있는 권한
    
    1. 시스템 권한
    특정 DB에 접근하는 권한, 객체들을 생성할 수 있는 권한
    
    [ 표현법 ]
    GRANT 권한1, 권한2, ..., TO 계정명;
    
    - 시스템 권한의 종류
    CREATE SESSION: 계정에 접속할 수 있는 권한
    CREATE TABLE: 테이블을 생성할 수 있는 권한
    CREATE VIEW: 뷰를 생성할 수 있는 권한
    CREATE SEQUENCE: 시퀀스를 생성할 수 있는 권한
    CREATE USER: 계정을 생성할 수 있는 권한
    ...
*/

-- 1. SAMPLE 계정 생성
CREATE USER SAMPLE IDENTIFIED BY SAMPLE;

-- 2. SAMPLE 계정에 접속하기 위한 CREATE SESSION 권한만 부여
GRANT CREATE SESSION TO SAMPLE;

-- 3_1. SAMPLE 계정에 테이블을 생성할 수 있는 CREATE TABLE 권한 부여
GRANT CREATE TABLE TO SAMPLE;

-- 3_2. SAMPLE 계정에 테이블스페이스를 할당해 주기 (ALTER 구문으로)
ALTER USER SAMPLE QUOTA 2M ON SYSTEM;
-- QUOTA: 몫, 할당하다
-- 2M: 2 MEGA BATE
-- SYSTEM: 오라클에서 제공하는 기본 테이블스페이스명

-- 4. SAMPLE 계정에 뷰를 생성할 수 있는 CREATE VIEW 권한 부여
GRANT CREATE VIEW TO SAMPLE;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *객체 접근 권한 (객체 권한)
    특정 객체들을 조작(SELECT, INSERT, UPDATE, DALETE) 할 수 있는 권한
    
    [ 표현법 ]
    GRANT 권한종류 ON 특정객체 TO 계정명;
    
              권한 종류                      |                         특정 객체
 ------------------------------------------------------------------------------------------------
               SELECT                        |    TABLE, VIEW, SEQUENCE
               INSERT                        |    TABLE, VIEW
              UPDATE                        |    TABLE, VIEW(안 되는경우가 더 많지만 되기는 됨)
               DELETE                        |    TABLE, VIEW(안 되는경우가 더 많지만 되기는 됨)
*/

-- 5. SAMPLE 계정에 KH.EMPLOYEE 테이블을 조회할 수 있는 권한 부여
GRANT SELECT ON KH.EMPLOYEE TO SAMPLE;

-- 6. SAMPLE 계정에 KH.DEPARTMENT 테이블에 행을 삽입할 수 있는 권한 부여
GRANT INSERT ON KH.DEPARTMENT TO SAMPLE;

--------------------------------------------------------------------------------------------------------------------------------------------
-- 최소한의 권한을 부여하고자 할 때 CONNECT, RESOURCE만 부여
-- GRANT CONNECT, RESOURCE TO 계정명;

/*
    <롤 ROLE>
    특정 권한들을 하나의 집합으로 묶어 놓은 것
    
    CONNECT: CREATE SESSION (데이터베이스에 접속할 수 있는 권한)
    RESOURCE: CREATE TABLE, CREATE SEQUENCE, ... (특정 객체들을 생성 및 관리할 수 있는 권한)
*/

-- 데이터 딕셔너리를 이용하여
-- CONNECT, RESOURCE라는 롤에 어떤 권한들이 묶여 있는지 확인해 보기
SELECT *
FROM ROLE_SYS_PRIVS
-- WHERE ROLE = 'CONNECT' OR ROLE = 'RESOURCE';
WHERE ROLE IN ('CONNECT', 'RESOURCE');

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    *권한 회수 (REVOKE)
    권한을 회수할 때 사용하는 명령어
    
    [ 표현법 ]
    REVOKE 권한1, 권한2, 권한3, ... FROM 계정명;
*/

-- 7. SAMPLE 계정에서 테이블을 생성할 수 없도록 권한 회수
REVOKE CREATE TABLE FROM SAMPLE;

----- 실습 문제 -----
-- 사용자 계정: MYTEST / MYTEST
CREATE USER MYTEST IDENTIFIED BY MYTEST;

-- 사용자에게 부여할 권한: CONNECT, RESOURCE, CREATE VIEW
GRANT CONNECT, RESOURCE, CREATE VIEW TO MYTEST;

-- 볼 일 보고(접속, 테이블 생성, 뷰 생성)

-- 사용자로부터 권한을 모두 회수
REVOKE CONNECT, RESOURCE, CREATE VIEW FROM MYTEST;

-- 사용자 계정 삭제
DROP USER MYTEST CASCADE;
-- 계정에 자료가 있기 때문에 그냥 삭제가 안 됨! CASCADE로 종속된 모든 것을 삭제하겠다고 해 줘야 함!
