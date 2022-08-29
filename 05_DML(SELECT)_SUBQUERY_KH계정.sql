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
    1. 단일 행 (단일 열) 서브쿼리 (SINGLE ROW SUBQUERY) -- 단일 열이라는 워딩 생략 가능
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
                                     
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    2. 다중 행 (단일 열) 서브쿼리 (MULTI LOW SUBQUERY)
    서브쿼리의 조회 결과 값이 여러 행일 때
    
    - 컬럼명 IN (10, 20, 30, 40) 서브쿼리: 여러 개의 결과값 중에서 한 개라도 일치하는 값이 있다면
                NOT IN (10, 20, 30) 서브쿼리: 여러 개의 결과값 중에서 하나도 일치하는 값이 없다면
                
    - 컬럼명 > ANY (10, 20, 30) 서브쿼리: 여러 개의 결과값 중에서 "하나라도" 클 경우
                                                        즉, 여러 개의 결과값 중에서 가장 작은값보다 클 경우
      컬럼명 < ANY (10, 20, 30) 서브쿼리: 여러 개의 결과값 중에서 "하나라도" 작을 경우
                                                        즉, 여러 개의 결과값 중에서 가장 큰값보다 작을 경우
    => ANY 계열에 등호(=)를 붙인 연산도 가능함!
    
    - 컬럼명 > ALL 서브쿼리: 여러 개의 결과값의 "모든" 값보다 클 경우
                                        즉, 여러 개의 결과값 중에서 가장 큰 값보다 클 경우
    - 컬럼명 > ALL 서브쿼리: 여러 개의 결과값의 "모든" 값보다 클 경우
                                        즉, 여러 개의 결과값 중에서 가장 작은 값보다 작을 경우
*/

-- 각 부서별 최고 급여를 받는 사원의 이름, 직급코드, 급여 조회
-- 1)  각 부서별 최고 급여
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE; --2890000, 3660000, 8000000, 3760000, 3900000, 2490000, 2550000
--> 7행 1열로 총 7개의 값이 조회됨

-- 2) 위의 급여를 받는 사원들 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2890000, 3660000, 8000000, 3760000, 3900000, 2490000, 2550000);
/*
WHERE SALARY  = 2890000
      OR SALARY  = 3660000
      OR SALARY  = 8000000
      OR ...
      */
      
-- 위의 두 쿼리를 합치기
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                             FROM EMPLOYEE
                             GROUP BY DEPT_CODE);
                             
-- 선동일 또는 유재식 사원과 같은 부서인 사원들을 조회(사원명, 부서코드, 급여)
-- 1) 선동일 또는 유재식 사원의 부서코드 구하기
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('선동일', '유재식'); -- 'D9', 'D6'
-- WHERE EMP_NAME = '선동일' OR EMP_NAME = '유재식';
--> 2행 1열, 총 2개의 결과가 조회

-- 2) 위의 부서코드인 사원들을 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D9', 'D6');
-- WHERE DEPT_CODE = 'D9' OR DEPT_CODE = 'D6'

-- 위의 두 쿼리를 합치기
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_CODE
                                  FROM EMPLOYEE
                                  WHERE EMP_NAME IN ('선동일', '유재식')); 
                                  
-- 사원 < 대리 < 과장 < 차장 < 부장
-- 대리 직급에도 불구하고 과장 직급의 급여보다 더 많이 받는 사원들 조회 (사번, 이름, 직급명, 급여)
-- (오라클 구문 사용)
-- 1) 과장 직급의 급여들 조회
SELECT SALARY
FROM EMPLOYEE E , JOB J
WHERE E.JOB_CODE = J.JOB_CODE
    AND JOB_NAME = '과장'; -- 2200000, 2500000, 3760000
    
-- 2) 위의 급여보다 높은 급여를 받는 직원들 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- 연결고리에 대한 조건
    AND SALARY > ANY (2200000, 2500000, 3760000); -- 추가적인 조건

-- 3) 두 쿼리를 합치기 + 대리 직급만 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- 연결고리에 대한 조건
    AND SALARY > ANY(SELECT SALARY
                                  FROM EMPLOYEE E , JOB J
                                  WHERE E.JOB_CODE = J.JOB_CODE
                                  AND JOB_NAME = '과장')
    AND JOB_NAME = '대리';
    
-- 과장 직급임에도 불구하고 모든 차장 직급의 급여보다도 더 많이 받는 직원들을 조회(사번, 이름, 직급명, 급여)
-- (ANSI 구문 사용)
-- 1) 차장 직급들의 급여
SELECT SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '차장'; -- 2800000, 1550000, 2490000, 2480000
--> 4행 1열, 총 4개의 값 조회

-- 2) 모든 위의 급여보다 더 많은 급여를 받는 직원들 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY > ALL (2800000, 1550000, 2490000, 2480000);

-- 3) 위의 두 쿼리를 합치기 + 과장 직급들만 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY > ALL (SELECT SALARY
                                  FROM EMPLOYEE
                                  JOIN JOB USING (JOB_CODE)
                                  WHERE JOB_NAME = '차장')
    AND JOB_NAME = '과장';
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. (단일 행) 다중 열 서브쿼리 (MULTI COLUMN SUBQUERY)
     조회 결과값은 한 행이지만 나열된 컬럼 수가 여러 개일 때

    (여러 개) = (여러 개) <- 이런 식으로 비교가 일어날 예정
*/ 

-- 하이유 사원과 같은 부서코드, 같은 직급 코드에 해당하는 사원들 조회

-- 1) 하이유 사원의 부서코드와 직급코드 먼저 조회
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '하이유'; -- 'D5' / 'J5'

-- 2) 부서코드가 D5이면서 직급코드가 J5인 사원들 조회
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
    AND JOB_CODE = 'J5';
    
--> 위의 쿼리문을 서브쿼리 버전으로 바꾼다면? (단일 행 단일 열 서브쿼리)
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '하이유')
    AND JOB_CODE =  (SELECT JOB_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '하이유');
                                 
-->> 단일 행 다중 열 서브쿼리 버전으로 변경
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
-- WHERE(DEPT_CODE, JOB_CODE) = ('D5', 'J5'); -- 해당 표현법은 리터럴을 제시했을 때 문법상 오류 발생
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                                   FROM EMPLOYEE
                                                   WHERE EMP_NAME = '하이유'); -- 결과값이 1행 2열, 총 2개의 값
                                                   
-- 박나라 사원과 같은 직급코드, 같은 사수 사번을 가진 사원들의 사번, 이름, 직급코드, 사수사번조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                                     FROM EMPLOYEE
                                                     WHERE EMP_NAME = '박나라'); -- 결과값이 1행 2열, 총 2개의 값
                                                     
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    4. 다중 행 다중 열 서브쿼리
    서브쿼리 조회 결과값이 여러 행 여러 열일 경우
*/

-- 각 직급별 최소 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
-->> 각 직급별 최소 급여 조회
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE; -- (J2, 3700000), (J7, 1380000), (J3, 3400000), (J6, 2000000), (J5, 2200000), (J1, 8000000), (J4, 1550000)
--> 7행 2열, 총 14개의 값 => 행별로 그룹 지었을 때 총 7세트가 나옴

-->> 위의 목록들 중에 일치하는 사원들 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (('J2', 3700000)
                                            , ('J7', 1380000)
                                            , ('J3', 3400000)
                                            , ('J6', 2000000)
                                            , ('J5', 2200000)
                                            , ('J1', 8000000)
                                            , ('J4', 1550000)); -- IN 연산자의 경우 여러 개 묶어서 비교가 가능
/* 리터럴로 직접 넣을 수는 없음
WHERE (JOB_CODE, SALARY) = ('J2', 3700000)
      OR (JOB_CODE, SALARY) = ('J7', 1380000)
      OR (JOB_CODE, SALARY) = ('J3', 3400000)
      OR ...
*/ -- 문법에 맞지 않는 표현법

--> 위의 내용들을 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                                              FROM EMPLOYEE
                                              GROUP BY JOB_CODE);
                                              
-- 각 부서별 최고 급여를 받는 사원들의 사번, 이름, 부서코드, 급여 조회
-- 1) 각 부서별 최고 급여 구하기
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) 위의 부서코드에 해당되고 위의 급여를 받는 사원들 조회
SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE, '없음'), SALARY
FROM EMPLOYEE
WHERE (NVL(DEPT_CODE, '없음'), SALARY) IN (('D1', 3660000)
                                              , ('D9', 8000000)
                                              , ('D5', 3760000)
                                              , ('D6', 3900000)
                                              , ('D2', 2490000)
                                              , ('D8', 2550000)
                                              , (NVL(DEPT_CODE, '없음'), 2890000)); 

/* 안 되는 방법
WHERE (DEPT_CODE, SALARY)= ('D1', 3660000')
                                        OR ('D9', 8000000)
                                        OR ...
*/ -- 문법에 맞지 않는 표현법


/* 가능하지만 매우 노다가적인 방법
WHERE DEPT_CODE = 'D1' AND SALARY = 3660000
      OR DEPT_CODE = 'D9' AND SALARY = 8000000
      OR ...
*/

-- 3) 위의 쿼리문들을 하나의 쿼리문으로 합치기
SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE, '없음'), SALARY
FROM EMPLOYEE
WHERE (NVL(DEPT_CODE, '없음'), SALARY) IN (SELECT NVL(DEPT_CODE, '없음'), MAX(SALARY)
                                                                FROM EMPLOYEE
                                                                GROUP BY DEPT_CODE)
ORDER BY SALARY DESC; --> 정렬도 가능함
--> NULL 값이 비교 대상에 포함될 경우 동등비교가 일어나지 않기 때문에 NVL 처리가 필수!
--> NULL 값은 참고로 IS NULL 연산자로만 동등 비교 가능
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    5. 인라인 뷰 (INLINE-VIEW)
    FROM절에 서브쿼리를 제시하는 것
    
    서브쿼리를 수행한 결과 (RESULT SET)을 테이블 대신 사용함
*/

-- 보너스 포함 연봉이 3000만원 이상인 사원들의 사번, 이름, 보너스포함연봉, 부서코드를 조회
--> 인라인뷰를 쓰지 않는 경우
SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "보너스포함연봉", DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY + (SALARY * NVL(BONUS, 0))) * 12 >= 30000000;

-->> 인라인뷰를 쓰는 경우
SELECT EMP_ID, EMP_NAME, 보너스포함연봉, DEPT_CODE
FROM (SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "보너스포함연봉", DEPT_CODE
          FROM EMPLOYEE)
WHERE 보너스포함연봉 >= 30000000;

--> 인라인뷰를 주로 사용하는 애
-- TOP-N 분석: 데이터베이스상에 있는 자료 중 최상위 몇 개의 자료를 보기 위해 사용되는 자료

-- 전 직원 중 급여가 가장 높은 상위 5명
-- *ROWNUM: 오라클에서 제공하는 컬럼, 조회된 순서대로 1부터 순번을 부여해 주는 컬럼
SELECT ROWNUM, EMP_NAME, SALARY      -- 실제실행순서 3     내가원하는순서 4
FROM EMPLOYEE                                     -- 실제실행순서 1     내가원하는순서 1
WHERE ROWNUM <= 5                           -- 실제실행순서 2     내가원하는순서 3
ORDER BY SALARY DESC;                          -- 실제실행순서 4     내가원하는순서 2
--> 이슈: 급여순으로 내림차순 하고 - 번호표 붙여 주고 - 번호표 순서대로 잘라 주기 순서대로 일어나야 하는데
--           번호표 순서대로 잘라 주고 - 번호표 붙여 주고 - 급여순으로 내림차순 해서 TOP-N 분석이 이루어지지 않음

--> ORDER BY로 정렬한 테이블을 가지고 조회, 조회 시에 ROWNUM 순번을 붙여 준 후 ROWNUM <= 5 조건 적용
SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

SELECT ROWNUM, EMP_NAME, SALARY      -- 실행 순서 3: SELECT
FROM (SELECT *                                       --실행 순서 0: RESULT SET 조회 / 실행 순서 1: FROM
           FROM EMPLOYEE
           ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;                           -- 실행 순서 2: WHERE

--> FROM절의 인라인뷰에 별칭을 붙일 수 있음, ROWNUM 컬럼도 마찬가지로 별칭을 붙일 수 있음
-- SELECT에 넣는"모든 컬럼을 가지고 오라는" *은 단독으로만 쓰일 수 있고, 다른 컬럼명과 함께 쓰지는 못함
-- 단! "별칭.*"은 가능함
SELECT ROWNUM 순위, E.* -- 인라인 뷰에 별칭을 붙이고 E.*을 하면  해당 인라인뷰의 모든 컬럼을 가지고 온다.
FROM (SELECT *
           FROM EMPLOYEE
           ORDER BY SALARY DESC) E
WHERE ROWNUM <= 3;

-- 각 부서별 평균 급여가 높은 3개의 부서코드, 평균 급여 조회
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG(SALARY) DESC;

SELECT ROWNUM, DEPT_CODE, ROUND(평균급여) "평균급여"
FROM (SELECT DEPT_CODE, AVG(SALARY) "평균급여" -- 인라인뷰 내부에서 그룹 함수를 이용할 경우에는 반드시 별칭을 붙여야 함
           FROM EMPLOYEE
           GROUP BY DEPT_CODE
           ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <= 3;

-- 가장 최근에 입사한 사원 5명 조회 (사원명, 급여, 입사일)
SELECT ROWNUM, E.*
FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
          FROM EMPLOYEE
          ORDER BY HIRE_DATE DESC) E
WHERE ROWNUM <= 5;

--> TOP-N 분석 시 ORDER BY절에 의한 정렬이 가장 먼저 일어나야 하기 때문에
-- ORDER BY 절이 먼저 일어날 수 있게끔 인라인뷰를 사용해야 함!
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    6. 순위 매기는 함수
    RANK() OVER(정렬기준)
    DENSE_RANK() OVER(정렬기준)
    
    주의사항: 오로지 SELECT 절에서만 작성 가능
                  오라클에서 순위를 매기는 함수를 윈도우 함수라고 부름(SELECT절에서만 쓸 수 있음)
                  
    두 함수의 차이점
    - RANK() OVER(정렬기준): 공동 1위가 3명이라고 한다면 그 다음 순위를 4위로 하겠다 (그 다음 순위는 현재순위 + 명수)
    - DENSE_RANK() OVER(정렬기준): 공동 1위가 3명이라고 해도 그 다음 순위는 무조건 2위로 하겠다 (그 다음 순위는 현재순위 + 1)
*/

-- 사원들의 급여가 높은 순서대로 매겨서 사원명, 급여, 순위 조회: RANK() OVER()
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;
--> 공동 19위 2명, 그 뒤의 순위는 21위

-- 사원들의 급여가 높은 순서대로 매겨서 사원명, 급여, 순위 조회: DENSE_RANK() OVER()
SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE;
--> 공동 19위 2명, 그 뒤의 순위 20위

-- 5위까지만 조회하겠다. (TOP-N 분석)
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
FROM EMPLOYEE
WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5;
--> 오류: window  functions are not allowed here
-->> 윈도우 함수는 WHERE 절에 기술 불가

-->> 인라인 뷰에서는 가능
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "순위"
           FROM EMPLOYEE)
WHERE 순위 <= 5; --> 별칭 기준 조건 제시