/*
    <VIEW 뷰>
    SELECT (쿼리문)을 저장해 둘 수 있는 객체
    (자주 쓰는 건 SELECT문을 저장해 주면 긴 SELECT문을 매번 다시 기술할 필요가 없음)
    임시 테이블 같은 존재 (실제 데이터가 담겨 있는 것은 아님)
*/
 
----- 실습 문제 -----
-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명, 직급명을 조회하시오
DEPARTMENT DEPT_ID = EMPLOYEE DEPT_ CODE (D1)
JOB JOB_CODE = EMPLOYEE JOB_CODE (J1)
LOCATION LOCAL_CODE = DEPARTMENT LOCATION_ID (L1)
NATIONAL NATIONAL_CODE = LOCATION NATIONAL_CODE  (KO)

-->> 오라클 전용 구문
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND D.LOCATION_ID = L.LOCAL_CODE
    AND L.NATIONAL_CODE = N.NATIONAL_CODE
    AND N.NATIONAL_NAME = '한국';

-->> ANSI 구문
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
    AND N.NATIONAL_NAME = '한국';
    
/*
    1. VIEW 생성 방법
    
    [ 표현법 ]
    CREATE VIEW 뷰명
    AS (서브쿼리);
*/

-- 전체 사원들의 사번, 이름, 부서명, 급여, 근무국가명, 직급명을 담은 뷰
CREATE VIEW VW_EMPLOYEE
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
      FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
      WHERE E.DEPT_CODE = D.DEPT_ID
          AND E.JOB_CODE = J.JOB_CODE
          AND D.LOCATION_ID = L.LOCAL_CODE
          AND L.NATIONAL_CODE = N.NATIONAL_CODE);
-- ORA-01031: insufficient privileges
-->> 현재 KH계정에는 뷰 생성 권한이 없어서 오류 발생

-- 여기부터 잠깐 관리자 계정으로 접속 후 CREATE VIEW 권한 부여하기
GRANT CREATE VIEW TO KH;

-- 이 시점부터 다시 KH 계정으로 접속 후 작업

-- View VW_EMPLOYEE이(가) 생성되었습니다.
-- 권한 부여 후에는 VIEW가 잘 만들어짐!

SELECT * FROM VW_EMPLOYEE;

-- 아래의 쿼리문과 비슷한 맥락
SELECT *
FROM (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
          FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
          WHERE E.DEPT_CODE = D.DEPT_ID
              AND E.JOB_CODE = J.JOB_CODE
              AND D.LOCATION_ID = L.LOCAL_CODE
              AND L.NATIONAL_CODE = N.NATIONAL_CODE);
              
-- '한국'에서 근무하는 사원들의 사번, 사원명, 부서명, 급여, 근무국가명, 직급명을 조회하고 싶다면
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '한국';

-- 위와 같이 복잡한 서브쿼리를 이용하여 그때그때 필요한 데이터들만 조회하는 것보다
-- 한번 서브쿼리로 뷰를 생성한 후 해당 뷰명으로 SELECT문을 이용하면 더 간단하게 조회 가능

-- 러시아에서 근무하는 사원들만 보고 싶다면?
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';

-- 러시아에서 근무하는 사원들의 사번, 이름, 직급, 보너스
SELECT EMP_ID, EMP_NAME, JOB_NAME, BONUS
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';
-- ORA-00904: "BONUS": invalid identifier
-- VW_EMPLOYEE 테이블에 BONUS 컬럼이 없기 때문에 오류 발생

-- 뷰에 보너스 컬럼이 없는 상태에서 보너스도 같이 조회하고 싶다면?
-- 뷰를 다시 생성하기 => CREATE OR REPLACE VIEW 뷰명

/*
    [ 표현법 ]
    CREATE OR REPLACE VIEW 뷰명
    AS (서브쿼리);
    
    => OR REPLACE는 생략 가능함
         뷰 생성 시 기존에 중복된 뷰 이름이 있다면 새롭게 뷰를 생성하는 게 아니라 해당 뷰를 변경(갱신) 하는 옵션
                        기존에 중복된 뷰 이름이 없다면 새롭게 뷰를 생성함
                        즉, 있으면 덮어씌우고 없으면 새로 만듦!
*/

CREATE OR REPLACE VIEW VW_EMPLOYEE
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME, E.BONUS
      FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
      WHERE E.DEPT_CODE = D.DEPT_ID
          AND E.JOB_CODE = J.JOB_CODE
          AND D.LOCATION_ID = L.LOCAL_CODE
          AND L.NATIONAL_CODE = N.NATIONAL_CODE);
--> OR REPLACE를 써서 "있으면 갱신"이라는 옵션을 줬기 때문에 오류 없이 잘 생성되었다고 나옴!

SELECT EMP_ID, EMP_NAME, JOB_NAME, BONUS
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '러시아';
-- 기존의 뷰를 갱신 후 오류 사라짐

-- 뷰를 논리적인 가상테이블 => 실질적으로 데이터를 저장하고 있지는 않음
-- (단순히 쿼리문이 TEXT 문구로 저장되어 있음)
-- 참고) 해당 계정이 가지고 있는 VIEW들에 대해 내용을 조회하고자 한다면
--         USER_VIEWS 데이터 딕셔너리를 조회하면 됨

SELECET * FROM USER_VIEWS;

/*
    *뷰 컬럼에 별칭 부여
    서브쿼리 SELECT절에 함수나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정
*/

-- 사원의 사번, 이름, 직급명, 성별, 근무년수를 조회할 수 있는 SELECT문을 뷰로 정의
CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여')
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
              -- 햇수, 년수로 구할 때는 그냥 하면 되는데 세는 수(만)으로 구하고 싶으면 +1 해 주기!
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE));
-- ORA-00998: must name this expression with a column alias
--=> 함수식, 산술연산식에 별칭을 지정하지 않아 오류 발생

CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') 성별
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) 근무년수
              -- 햇수, 년수로 구할 때는 그냥 하면 되는데 세는 수(만)으로 구하고 싶으면 +1 해 주기!
     FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE));
-- 뷰 생성 성공

SELECT * FROM VW_EMP_JOB;

-- 또 다른 방법으로 별칭 부여 가능(단, 모든 컬럼에 대해 별칭을 모두 다 기술해야 함)
CREATE OR REPLACE VIEW VW_EMP_JOB (사번, 사원명, 직급명, 성별, 근무년수)
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여')
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
     FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE));

SELECT * FROM VW_EMP_JOB;

SELECT 사원명, 근무년수
FROM VW_EMP_JOB;

SELECT 사원명, 직급명
FROM VW_EMP_JOB
WHERE 성별 = '여';

-- 근무년수가 20년 이상인 사원들의 모든 컬럼
SELECT *
FROM VW_EMP_JOB
WHERE 근무년수 >= 20;

-- 뷰를 삭제하고자 한다면
DROP VIEW VW_EMP_JOB;

SELECT * FROM VW_EMP_JOB;
-- ORA-00942: table or view does not exist
--> 뷰가 잘 삭제된 것을 확인 가능

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    *생성된 뷰를 이용해서 DML (INSERT, UPDATE, DELETE) 사용 가능
      단, 뷰를 통해서 변경하게 되면 실제 데이터가 담겨 있는 실질적인 테이블 (베이스테이블)에도 적용됨
*/

-- 테스트용 뷰 생성
CREATE OR REPLACE VIEW VW_JOB
AS (SELECT *
      FROM JOB);

SELECT * FROM VW_JOB; -- 뷰 (복사본)
SELECT * FROM JOB; -- 베이스테이블 (원본)

-- 뷰에 INSERT
INSERT INTO VW_JOB
VALUES ('J8', '인턴'); -- 베이스테이블(JOB)에 값 INSERT

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- 뷰에 UPDATE
-- JOB_CODE가 J8인 JOB_NAME을 알바로 UPDATE
UPDATE VW_JOB
SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8'; -- 베이스테이블 (JOB)에 값 UPDATE

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- 뷰에 DELETE
-- JOB_CODE가 J8인 행을 삭제
DELETE
FROM VW_JOB
WHERE JOB_CODE = 'J8'; -- 베이스테이블 (JOB)에 값 DELETE

SELECT * FROM VW_JOB;
SELECT * FROM JOB;
--> DML문 사용 시 뷰에서 진행하기는 하지만,
--  사실상 '테이블에서 삭제되기 때문에' 뷰에도 삭제된 것처럼 보이는 것임!

--------------------------------------------------------------------------------------------------------------------------------------------

-- 뷰에 DML이 적용 안 되는 경우

-- 테스트용 뷰 생성
CREATE OR REPLACE VIEW VW_JOB
AS (SELECT JOB_CODE
      FROM JOB);
      
SELECT * FROM VW_JOB;

-- 뷰에 INSERT => 불가
INSERT INTO VW_JOB (JOB_CODE, JOB_NAME)
VALUES ('J8', '인턴');
-- ORA-00904: "JOB_NAME": invalid identifier

SELECT * FROM JOB;

-- 뷰에 UPDATE => 불가
UPDATE VW_JOB
SET JOB_NAME = '인턴'
WHERE JOB_CODE = 'J7';
-- ORA-00904: "JOB_NAME": invalid identifier

-- 뷰에 DELETE => 불가
DELETE
FROM VW_JOB
WHERE JOB_NAME = '사원';
-- ORA-00904: "JOB_NAME": invalid identifier

/*
    *하지만 뷰를 가지고 DML이 불가능한 경우가 더 많음
    
    1) 뷰에 정의되어 있지 않은 컬럼을 조작하는 경우
    2) 뷰에 정의되어 있지 않은 컬럼 중 베이스테이블상에 NOT NULL 제약조건이 걸려 있는 경우
    3) 산술연산식 또는 함수를 통해서 정의되어 있는 경우
    4) 서브쿼리 부분에 그룹함수나 GROUP BY절이 포함된 경우
    5) 서브쿼리 부분에 DISTINCT 구문이 포함된 경우
    6) JOIN을 이용해서 여러 테이블을 매칭시켜서 뷰로 정의한 경우
    
    => 이런 이유로 뷰는 조회용으로 많이 씀
    
*/

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *VIEW 옵션
    
    [ 상세표현법 ]
    CREATE OR REPLCAE FORCE/NOFORCE VIEW 뷰명
    AS (서브쿼리)
    WITH CHECK OPTION;
    
    1) OR REPLACE: 해당 뷰명이 이미 존재하면 갱신시켜 줌
                                                  존재하지 않으면 새로이 생성시켜 줌
    2) FORCE / NOFORCE
        - FORCE: 서브쿼리에 기술된 테이블이 존재하지 않더라도 뷰가 생성
        - NOFORCE: 서브쿼리에 기술된 테이블이 반드시 존재해야만 뷰가 생성 (생략 시 기본값)
    3) WITH CHECK OPTION: 서브쿼리의 조건절에 (WHERE절) 기술된 내용에 만족하는 값으로만 DML이 가능
                                       조건에 부합하지 않는 값을 수정하는 경우 오류 발생
    4) WITH READ ONLY: 뷰에 대해서 조회만 가능 (INSERT, UPDATE, DELETE 수행 불가)
*/

-- 2) FORCE/NOFORCE
CREATE OR REPLACE VIEW VW_TEST
AS (SELECT *
      FROM TT);
-- ORA-00942: table or view does not exist
-- => TT라는 테이블이 존재하지 않아서 오류 발생

CREATE OR REPLACE FORCE VIEW VW_TEST
AS (SELECT *
      FROM TT); 
-- 경고: 컴파일 오류와 함께 뷰가 생성되었습니다.
-- => 실행은 되나 경고가 뜸

SELECT * FROM VW_TEST;
-- ORA-04063: view "KH.VW_TEST" has errors
-- 현재 원본 테이블이 없어서 조회 불가할 뿐 뷰는 있음...! 진짜 있음!
-- 왼쪽 접속창의 KH계정 - 뷰에서 확인 가능함

CREATE TABLE TT (
    TCODE NUMBER,
    TNAME VARCHAR2(30),
    TCONNECT VARCHAR2(50)
);

SELECT * FROM VW_TEST;
-- TT 테이블을 뒤늦게 생성 후 다시 한 번  VW_TEST 뷰를 조회하게 되면 오류가 발생하지 않음

-- 3) WITH CHECK OPTION
CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
      FROM EMPLOYEE
      WHERE SALARY >= 3000000)
WITH CHECK OPTION; -- 이때 WHERE절 조건으로 걸었던 걸 고정값으로 가지고 가는 느낌

SELECT * FROM VW_EMP;
-- VW_EMP라는 뷰에서 현재 급여가 300만원 이상인 사원들의 정보만 보여짐

UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;
-- ORA-01402: view WITH CHECK OPTION where-clause violation
-- => 서브쿼리에 기술한 조건에 부합하지 않기 때문에 값을 변경 불가

UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200;
-- 서브쿼리 기술한 조건에 부합하기 때문에 변경 가능

SELECT * FROM VW_EMP;

ROLLBACK;

-- 4) WITH READ ONLY
CREATE OR REPLACE VIEW VW_EMPBONUS
AS (SELECT EMP_ID, EMP_NAME, BONUS
      FROM EMPLOYEE
      WHERE BONUS IS NOT NULL)
WITH READ ONLY;

SELECT * FROM VW_EMPBONUS;

DELETE
FROM VW_EMPBONUS
WHERE EMP_ID = 204;
-- SQL 오류: ORA-42399: cannot perform a DML operation on a read-only view
-- => 읽기 전용 옵션이 붙었기 때문에 수정이 불가
