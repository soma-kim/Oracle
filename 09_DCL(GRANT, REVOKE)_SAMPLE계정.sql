-- CREATE TABLE 권한 부여받기 전
CREATE TABLE TEST (
    TEST_ID NUMBER
);
 
-- 3_1. SAMPLE 계정에 테이블을 생성할 수 있는 권한이 없기 때문에 오류 발생
-- ORA-01031: insufficient privileges
--> 불충분한 권한들

-- CREATE TABLE 권한 부여받은 후
CREATE TABLE TEST (
    TEST_ID NUMBER
);
-- 3_2. TABLE SPACE(테이블들이 모여 있는 공간)가 할당되지 않음
-- ORA-01950: no privileges on tablespace 'SYSTEM'
--> 테이블스페이스가 아직 사용 불가인 상태

-- TEST SPACE 할당받은 후
CREATE TABLE TEST (
    TEST_ID NUMBER
);
-- 테이블 생성 완료

-- 위의 테이블 생성 권한(CREATE TABLE)을 부여받게 되면
-- 기본적으로는 해당 계정이 소유하고 있는 테이블들을 조작하는 것도 가능해짐
SELECT * FROM TEST;
INSERT INTO TEST VALUES(1);

-- 뷰 만들어 보기
CREATE VIEW V_TEST
AS (SELECT *
      FROM TEST);
-- ORA-01031: insufficient privileges

-- 4. 뷰 객체를 생성할 수 있는 CREATE VIEW 권한이 없기 때문에 오류 발생

-- CREATE VIEW 권한 부여받은 후
CREATE VIEW V_TEST
AS (SELECT * 
      FROM TEST);
-- 뷰 생성 완료

SELECT * FROM V_TEST;

--------------------------------------------------------------------------------------------------------------------------------------------

-- SAMPLE 계정에서 KH 계정의 테이블에 접근해서 조회해 보기
SELECT *
FROM KH.EMPLOYEE;

-- 5. KH 계정의 테이블에 접근해서 조회할 수 있는 권한이 없기 때문에 오류 발생
-- ORA-00942: table or view does not exist

-- SELECT ON 권한 부여받은 후
SELECT *
FROM KH.EMPLOYEE;
-- EMPLOYEE 테이블 조회 성공

SELECT *
FROM KH.DEPARTMENT;
-- KH 계정의 DEPARTMETN 테이블에 접근할 수있는 권한이 없기 때문에 오류 발생

-- SAMPLE 계정에서 KH 계정의 테이블에 접근해서 행 삽입해 보기
INSERT INTO KH.DEPARTMENT
VALUES('D0', '회계부', 'L2');

-- 6. KH계정의 테이블에 접근해서 삽입할 수 있는 권한이 없기 때문에 오류 발생
-- SQL 오류: ORA-00942: table or view does not exist

-- INSERT ON 권한 부여받은 후
INSERT INTO KH.DEPARTMENT
VALUES ('D0', '회계부', 'L2');
-- KH.DEPARTMENT 테이블에 행 INSERT 성공

SELECT * FROM KH.DEPARTMENT;
-- INSERT 권한만 주었을 뿐 SELECT 권한은 주지 않았기 때문에 조회는 불가함!


-- 아직까지는 SAMPLE 계정에서 추가한 값이 반영되지 않음!
-- INSERT 후 COMMIT까지 해야 KH 계정의 DEPARTMENT 테이블에 반영됨!
-- SAMPLE계정에서 진행했으니 SAMPLE 계정에서 커밋 해 줘야 함!
COMMIT;
-- 커밋 후에는 삽입이 반영됨

-- 테이블 만들어 보기
CREATE TABLE TEST2 (
    TEST_ID NUMBER,
    TEST_TITLE VARCHAR2(50)
);

-- 7. SAMPLE 계정에서 테이블을 생성할 수 없도록 권한을 회수했기 때문에 오류 발생
-- ORA-01031: insufficient privileges

CREATE VIEW V_TEST2
AS (SELECT *
     FROM TEST
     WHERE 1 = 0);
-- 테이블을 만드는 권한을 회수했을 뿐 뷰를 만드는 권한은 회수하지 않았기 때문에
-- 뷰는 잘 만들어짐
