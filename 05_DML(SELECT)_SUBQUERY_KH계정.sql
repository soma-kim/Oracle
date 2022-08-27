/*
    <SUBQUERY 서브쿼리>
    하나의 주된 SQL문 (SELECT, INSERT, CREATE, ...) 안에서 포함된 또 하나의 SELECT문
    메인 SQL문을 위해 보조 역할을 하는 쿼리문
*/

-- 간단한 서브쿼리 예시1
-- 노옹철 사원과 같은 부서인 사람들
-- 1)  먼저 노옹철 사원의 부서코드 조회
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철'; -- 노옹철 사원의 부서코드는 D9인 것을 알아냄

-- 2) 부서코드가 D9인 사원들을 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; -- 선동일, 송중기, 노옹철과 같은 부서인 것을 알아냄

-- 위의 두 단계를 하나의 쿼리문으로 합치기
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '노옹철');
                                 
-- 간단한 서브쿼리 예시 2
-- 전체 사원의 평균 급여보다 더 많은 급여를 받고 있는 사원들의 사번, 이름, 직급코드 조회
-- 1) 먼저 전체 사원의 평균 급여 구하기
SELECT AVG(SALARY)
FROM EMPLOYEE; -- 평균 금액 3047662원

-- 2) 급여가 3,047,662원 이상인 사원들 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3047662; -- 선동일, 송종기, 노옹철, 유재식, 정중하, 심봉선, 대북혼, 전지연

-- 위의 두 단계를 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY)
                             FROM EMPLOYEE);
                             
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *서브쿼리 구분
    분류 기준: 서브쿼리를 수행한 결과값 (RESULT SET)이 몇 행 몇 열짜리냐에 따라 분류됨
    
    - 단일 행 (단일 열) 서브쿼리: 서브쿼리를 수행한 결과값이 오로지 1개일 때 (1행 1열일 때)
    - 다중 행 (단일 열) 서브쿼리: 서브쿼리를 수행한 결과값이 여러 행 한 열일 때 (N행 1열일 때) - 속성 1개에 많은 값
    - 단일 행 다중 열 서브쿼리: 서브쿼리를 수행한 결과값이 한 행 여러 열일 때 (1행 N열일 때)
    - 다중 행 다중 열 서브쿼리: 서브쿼리를 수행한 결과값이 여러 행 여러 열일 때 (N행 N열일 때)
    => 서브쿼리를 수행한 결과가 몇 행 몇 열이냐에 따라서 사용 가능한 연산자도 다 달라짐
    
    참고) 서브쿼리가 FROM절에 들어간 경우: 인라인 뷰
    
 */   
--------------------------------------------------------------------------------------------------------------------------------------------    
/*
    1. 단일 행 (단일 열) 서브쿼리 (SINGLE ROW SUBQUERY)
    서브쿼리의 조회 결과값이 오로지 1개일 때
    
    일반 연산자 사용 가능(=, !=, <=, >, <, >=, ...)
*/

-- 전 직원의 평균 급여보다 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
-- 1) 먼저 평균 급여 구하기
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- 2) 3,047,662원 미만으로 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < 3047662

-- 위의 두 단계를 하나의 쿼리문으로 합치기
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) --> 결과값 1행 1열, 오로지 1개의 값
                           FROM EMPLOYEE);

-- 최저 급여를 받는 사원의 사번, 사원명, 직급코드, 급여, 입사일 조회
-- 1) 먼저 최저 급여 조회
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- 2) 급여가 1,380,000원인 사원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = 1380000;

-- 위의 두 쿼리문을 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) --> 결과값 1행 1열, 오로지 1개의 값
                           FROM EMPLOYEE);

-- 노옹철 사원의 급여보다 더 많이 받는 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DPET_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '노옹철');
                             
-- 노옹철 사원의 급여보다 더 많이 받는 사원들의 사번, 이름, 부서명, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = DEPT_ID -- 연결고리에 대한 조건
    AND SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '노옹철') -- 추가 조건
--> 조인도 함께 가능

-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '노옹철');
                             
-- 전지연 사원과 같은 부서인 사원들의 사번, 사원명, 휴대폰번호, 직급명
-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- 연결고리에 대한 조건
    AND DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '전지연')
    AND EMP_NAME != '전지연'; -- 추가적인 조건
    
--> ANSI 구문
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '전지연')
    AND EMP_NAME != '전지연';

-- 부서별 급여 합이 가장 큰 부서 하나만을 조회
-- 부서코드, 부서명, 급여합 조회
-- 1) 부서별 급여 합 구하기
SELECT SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) 부서별 급여 합들 중 가장 큰 값을 구하기
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 3) 부서코드, 부서명, 급여 합
-->> 오라클 구문
SELECT DEPT_CODE, DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID -- 연결고리에 대한 조건
GROUP BY DEPT_CODE, DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                     FROM EMPLOYEE
                                     GROUP BY DEPT_CODE);
                                     
-->> ANSI 구문
SELECT DEPT_CODE, DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                     FROM EMPLOYEE
                                     GROUP BY DEPT_CODE);
