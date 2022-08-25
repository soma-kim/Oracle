/*
    <JOIN>
    
    두 개 이상의 테이블에서 데이터를 같이 조회하고자 할 때 사용되는 구문
    조회 결과는 하나의 결과물(RESULT SET)로 나옴
    
    관계형 데이터베이스에서는 최소한의 데이터로 각각의 테이블에 데이터를 보관하고 있음
    (중복을 최소화하기 위해서 최대한 쪼개서 관리함)
    => 즉, JOIN 구문을 이용해 여러 개의 테이블가의 관계를 맺어 같이 조회해야 함
    => 단, 무작정 JOIN 구문을 작성해서 조회를 하는 게 아니라
         테이블간의 "연결고리"에 해당하는 컬럼 (== 외래키)를 매칭시켜서 JOIN 해 줘야 함
         
         JOIN은 크게 "오라클 전용구문"과 "ANSI(미국국립표준협회) 구문" 으로 나뉨
         
                      오라클 전용구문                       |                           ANSI 구문
     ===================================================================                   
                           등가조인                            |         내부조인(INNER JOIN) -> JOIN USING / ON
                       (EQUAL JOIN)                         |        외부조인(OUTER JOIN) -> 실제로 이렇게 쓰지는 않고 개념적인 내용
                   
             => 연결고리 컬럼에 해당하는 값들이 "같은 것들만" 가지고 오겠다 (등가조인, "내부"조인)
             => 연결고리 컬럼에 해당하는 값들이 "일치하지 않아도" 가지고 오겠다 (등가조인, "외부"조인)
     ----------------------------------------------------------------------------------------------------------------------------
                           포괄조인                           |         
                        (LEFT OUTER)                        |         왼쪽 외부조인(LEFT OUTER JOIN)
                       (RIGHT OUTER)                      |        오른쪽 외부조인(RIGHT OUTER JOIN)
                                                                  |         전체 외부조인(FULL OUTER JOIN) -> 오라클에서는 불가
     ----------------------------------------------------------------------------------------------------------------------------
           카테시안 곱(CARTESIAN PRODUCT)       |                         교차조인(CROSS JOIN)
             => 모든 경우의 수에 대해 모두 곱하겠다         
     ----------------------------------------------------------------------------------------------------------------------------
                자체조인(SELF JOIN)                      |
                비등가조인(NON EQUAL JOIN)        |
     ----------------------------------------------------------------------------------------------------------------------------
*/

-- 전체 사원들의 사번, 사원명, 부서코드, 부서명까지 알아내고자 한다면?
SELECT EMP_ID, EMP_NAME, DEPT_CODE -- 부서명을 알 수 없음
FROM EMPLOYEE; -- EMPLOYEE 테이블의 DEPT_CODE 컬럼이 부서 정보를 담고 있음

SELECT DEPT_ID, DEPT_TITLE -- 사번, 사원명을 알 수 없음
FROM DEPARTMENT; -- DEPARTMENT 테이블의 DEPT_ID 컬럼

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명까지 알아내고자 한다면?
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE; -- EMPLOYEE 테이블의 JOB_CODE  컬럼

SELECT JOB_CODE, JOB_NAME
FROM JOB; -- JOB 테이블의 JOB_CODE 컬럼

--> 조인을 통해서 연결고리에 해당하는 컬럼만 제대로 매칭시킨다면 마치 하나의 결과물로 조회 가능

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    1. 등가조인(EQUAL JOIN) / 내부조인(INNER JOIN)
    연결시키려는 컬럼의 값들이 일치하는 행들만 조인돼서 조회
    (== 일치하지 않는 값들은 조회에서 제외됨)

*/

-->> 오라클 전용 구문
-- FROM절에 조회하고자 하는 테이블들을 콤마(,)로 나열
-- WHERE절에 매칭시킬 컬럼명(연결고리)에 대한 조건을 제시함

-- 전체 사원들의 사번, 사원명, 부서코드, 부서명 같이 조회
-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE 테이블의 DEPT_CODE / DEPARTMENT 테이블의 DEPT_ID)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
--> 일치하지 않는 값은 조회에서 제외된 것 확인 가능
-- (DEPT_CODE가 NULL이었던 2명의 데이터는 조회가 안 됨, DEPARTMENT 테이블의 DEPT_ID 컬럼에는 NULL이 존재하지 않음)
-- (DEPT_ID가 D3, D4, D7인 부서의 부서명이 조회가 안 됨! EMPLOYEE 테이블의 DEPT_CODE 컬럼에는 D3, D4, D7이 존재하지 않음)

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명 같이 조회
-- 2) 연결할 두 컬럼명이 같은 경우 (EMPLOYEE 테이블의 JOB_CODE / JOB 테이블의 JOB_CODE)
/*
SELECT EMP_ID, EMP_NAME, 
FROM EMPLOYEE, JOB
WHERE JOB_CODE = JOB_CODE;
*/
--- 에러 (AMBIGUOUSLY: 애매하다, 모호하다 => 확실히 어떤 테이블의 어느 컬럼인지를 명시해야 함)

-- 해결방법 1) 테이블명을 직접 명시하여 이용하는 방법 (테이블명.컬럼명)
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- 해결방법 2) 테이블에 별칭을 붙여서 별칭을 이용하는 방법 (별칭.컬럼명) -> 각 테이블마다 별칭 부여 가능
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, J.JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-->> ANSI 구문
-- FROM절에 기준이 될 테이블명 하나만 명시한 뒤
-- 그 뒤에 JOIN절에서 같이 조회하고자 하는 테이블명을 기술! 또한 매칭시킬 컬럼에 대한 조건도 같이 기술 (USING / ON 구문)

-- 사번, 사원명, 부서코드, 부서명 조회
-- 1) 연결할 두 컬럼명이 다른 경우 (EMPLOYEE 테이블의 DEPT_CODE / DEPARTMENT 테이블의 DEPT_ID)
-- => 무조건 ON 구문만 가능함 (USING 구문은 불가능)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
/* INNER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> INNER는 생략 가능

-- 사번, 사원명, 직급코드, 직급명 조회
-- 2) 연결할 두 컬럼명이 같은 경우(EMPLOYEE 테이블의 JOB_CODE / JOB테이블의 JOB_CODE)
-- => ON 구문, USING 구문 둘 다 사용 가능
-- 2_1) ON 구문 이용: AMBIGIFUOUSLY 오류가 발생할 수 있기 때문에 확실히 명시해야 함(테이블명, 별칭)
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON (E. JOB_CODE = J.JOB_CODE);

-- 2_2) USING 구문 이용: AMBIGUOUSLY 오류 발생 X
-- 동일한 컬럼명 하나만 잘 적어 주면알아서 매칭시켜 줌
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);

-- [참고] 위의 예시는 NATURAL JOIN (지연조인)으로도 가능
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
NATURAL JOIN JOB;
-- 두 개의 테이블만 제시한 상태,
-- 마침 운 좋게도 두 개의 테이블에 일치하는 컬럼이 유일하게 한 개씩 존재(JOB_CODE)
-- => 알아서 매칭되어 조회됨

-- 추가적인 조건도 제시 가능
-- 직급이 대리인 사원들의 정보 조회 (사번, 사원명, 급여, 직급명)

-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE; -- 연결고리에 대한 조건
    AND JOB_NAME = '대리' -- 추가적인 조건
-- 협업 시 가독성을 높이기 위해 보통 조건은 한 줄씩 띄어쓰기, 들여쓰기 해서 쓴다.

-->> ANSI구문