/*
    <GROUP BY절>
    그룹을 묶어 줄 기준을 제시할 수 있는 구문
    => 해당 제시된 기준별로 그룹을 묶을 수 있음
    
    여러 개의 값들을 하나의 그룹으로 묶어서 처리할 목적으로 사용 (통계)
*/

-- 전체 사원의 총 급여 합
SELECT SUM(SALARY)
FROM EMPLOYEE; --> 현재 조회된 전체 사원들을 하나의 그룹으로 묶어서 총합을 구한 결과

-- 각 부서별 총 급여 합
SELECT DEPT_CODE, SUM(SALARY) -- 단일행 함수와 그룹 함수를 함께 쓸 수 없음
FROM EMPLOYEE
GROUP BY DEPT_CODE; -- DEPT_CODE 기준으로 실행하라고 제시해 주면 오류 없이 사용 가능!

-- 전체 사원 수
SELECT COUNT(*)
FROM EMPLOYEE;

 -- 각 부서별 사원 수
 SELECT DEPT_CODE, COUNT(*)
 FROM EMPLOYEE
 GROUP BY DEPT_CODE;
 
 -- 각 부서별 총 급여 합을 부서코드를 오름차순 정렬해서 조회
 SELECT DEPT_CODE, SUM(SALARY) -- 순서3. SELECT절
 FROM EMPLOYEE -- 순서1: FROM절
 GROUP BY DEPT_CODE -- 순서2: GROUP BY절
 ORDER BY DEPT_CODE ASC; -- 순서4: ORDER BY절
 
 -- 각 직급별 직급코드, 총 급여의 합, 사원 수, 보너스를 받는 사원 수, 평균 급여, 최소 급여
 SELECT JOB_CODE "직급코드"
          , SUM(SALARY) "총급여합"
          , COUNT(*) "사원수"
          , COUNT(BONUS) "보너스받는사원수"
          , AVG(SALARY) "평균급여"
          , MIN(SALARY) "최소급여"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE ASC;

-- 각 부서별 부서코드, 사원 수, 보너스를 받는 사원 수, 사수가 있는 사원 수, 평균 급여
SELECT DEPT_CODE "부서코드"
         , COUNT(*) "사원수"
         , COUNT(BONUS) "보너스받는사원수"
         , COUNT(MANAGER_ID) "사수가있는사원수"
         , AVG(SALARY) "평균급여"
FROM EMPLOYEE
GROUP BY DEPT_CODE -- GROUP BY 절에는 별칭 사용 불가 (실행순서)
ORDER BY DEPT_CODE ASC;

-- 성별 수 사원 수
SELECT SUBSTR(EMP_NO, 8, 1) 성별, COUNT(*) 사원수
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- DECODE 함수 적용
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남자', '2', '여자') 성별, COUNT(*) 사원수
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- 입사년도별 인원 수 조회,  단! 2015년도부터 조회, 년도는 오름차순해서 조회
SELECT EXTRACT(YEAR FROM HIRE_DATE) || '년' "입사년도", COUNT(*) || '명' "입사인원"
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2015
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
ORDER BY 입사년도 ASC;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <HAVING절>
    그룹에 대한 조건을 제시할 때 사용되는 구문
    (그룹함수가 포함된 조건식을 제시할 경우 무조건 HAVING절에 작성해야 함!)
    => WHERE절에 그룹 함수에 대한 조건을 제시할 시 바로 오류 남!
*/

-- 각 부서별 평균 급여가 300 만원 이상인 부서들만 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE AVG(SALARY) >= 3000000 -- 오류! WHERE절에는 그룹 함수 식을 사용할 수 없음
GROUP BY DEPT_CODE;

-- HAVING절에 조건 작성해야 함
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- 각 직급별 총 급여 합이 1000만원 이상인 직급 코드, 급여 합을 조회
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- 각 부서별 보너스를 받는 사원이 없는 부서만을 조회
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-- 보너스를 받는 사원 수: COUNT(BONUS)
-- COUNT(BONUS) > 0 => 한 명이라도 보너스를 받는 사원이 있다
-- COUNT(BONUS) = 0 => 보너스를 받는 사원이 한 명도 없다
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <실행 순서>
   5.  SELECT * / 조회하고자하는컬럼명 / 리터럴 / 산술연산식 / 함수식 AS "별칭"
   1.  FROM 조회하고자하는테이블명  / DUAL(가상테이블명)
   2.  WHERE 조건식(그룹함수는 안됨)
   3.  GROUP BY 그룹기준에해당하는컬럼명 / 함수식
   4.  HAVING 그룹함수식에대한조건식
   6.  ORDER BY [정렬기준에해당하는컬럼명 / 별칭 / 컬럼순번] [ASC/DESC] [NULLS FIRST/NULLS LAST]
*/

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <집합 연산자 SET OPERATOR>
    여러 개의 쿼리문을 가지고 하나의 쿼리문으로 만드는 연산자
    
    - UNION: 합집합(두 쿼리문을 수행한 결과값을 더한 후 중복되는 부분은 한 번 뺀 것) => OR의 개념
    - INTERSECT: 교집합 (두 쿼리문을 수행한 결과값의 중복된 결과값 부분) => AND의 개념
    - UNION ALL: 합집합 결과에 교집합이 한 번 더해진 개념
                        (두 쿼리문을 수행한 결과값을 무조건 더함! 즉, 합집합에서 중복 제거를 하지 않은 상태)
    - MINUS: 차집합(선행 쿼리문 결과값 빼기 후행 쿼리문 결과값)
*/

-- 1. UNION (합집합 - 두 쿼리문을 수행한 결과값을 더하지만 중복되는 결과는 한 번만 조회)
-- 부서코드가 D5이거나 또는 급여가 300만원 초과인 사원들 조회 (사번, 사원명, 부서코드, 급여)

-- 부서코드가 D5인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; --> 6명 조회(박나라, 하이유, 김해술, 심봉선, 윤은해, 대북혼)

-- 급여가 300만원 초과인 사원들만 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; --> 8명 조회(선동일, 송중기, 노옹철, 유재석, 정중하, 심봉선, 대북혼, 전지연)

-- 부서코드 D5이거나 또는 급여가 300만원 초과인 사원들 조회(사번, 이름, 부서코드, 급여) => UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 12명 조회(박나라, 하이유, 김해술, 심봉선, 윤은해, 대북혼, 선동일, 송종기, 노옹철, 유재식, 정중하, 전지연)
--> 6명 + 8명 - 2명(중복 제거) = 12명

-- 주의사항: 집합 연산 시 항상 두 쿼리의 SELECT절이 완전히 일치해야 함

-- 위의 UNION구문을 하나의 SELECT문으로 표현하기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;
--> OR 연산자로 두 개의 조건을 엮어서 조회하면 결과는 동일

-- 각 부서별 급여합 조회 (부서코드, 부서별 급여합)
-- UNION 이용해서
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
UNION
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D2'
UNION
-- ... 각 부서별로 WHERE절을 이용해서 일일이 UNION으로 합치는 방법도 가능하긴 함

-- GROUP BY 버전
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2. UNION ALL: 여러 개의 쿼리 결과를 무조건 더하는 연산자 (중복값 있을 수 있음)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6명
UNION ALL ------------------------------------ 14명
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8명
--> 14명 조회(박나라, 하이유, 김해술, "심봉선", 윤은해, "대북혼", 선동일, 송종기, 노옹철, 유재식, 정중하, "심봉선, 대북혼", 전지연)
--> 6명 + 8명 = 14명

-- 3. INTERSECT (교집합 - 여러 쿼리 결과의 중복된 결과만 조회)
-- 부서 코드가 D5이면서 뿐만 아니라 급여까지도 300만원 초과인 사원들 (사번, 사원명, 부서코드, 급여)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 2명 조회 (심봉선, 대북혼)
--> 중복된 결과만 조회 / 두 쿼리문 모두 해당되는 결과

-- 아래처럼도 가능
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 4. MINUS (차집합 - 선행쿼리 결과에 후행쿼리 결과를 뺀 나머지)
--> 어디에서 뭘 빼냐에 따라 결과가 다르게 나오기 때문에 순서가 중요!
-- 부서 코드가 D5인 사원들 중 급여가 300만원 초과인 사원들을 제외하고 조회

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 4명 조회(박나라, 하이유, 김해술, 윤은해)
--> 6명 - 겹치는 2명 = 4명

-- 순서를 바꾼다면?
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';
--> 6명 (선동일, 송종기, 노옹철, 유재식, 정중하, 전지연)
--> 8명 - 겹치는 3명 = 6명

-- 아래처럼도 가능
-- 부서코드가 D5인 사원들 중 급여가 300만원 초과인 사원들을 제외하고 조회
-- 부서코드가 D5인 사원들 중 급여가 300만원 이하인 사원들만 제외
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'AND SALARY <= 3000000;

--------------------------------------------------------------------------------------------------------------------------------------------
----- KH 계정 SELECT 기본 연습문제 -----
-- 1. EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회
SELECT HIRE_DATE "고용일", EMP_NAME "사원 이름", SALARY "월급"
FROM EMPLOYEE;

-- 2. EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회
SELECT EMP_NAME "사원 이름", SALARY "월급", HIRE_DATE "고용일", PHONE "연락처"
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- 3. EMPLOYEE테이블에서 이름, 연봉, 총 수령액(보너스 포함), 실수령액(총수령액 - (연봉 * 세금 3%)) 조회
SELECT EMP_NAME "이름"
         , SALARY * 12 "연봉"
         , (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "총 수령액" 
         , ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - (SALARY * 0.03) "실수령액"
FROM EMPLOYEE;

-- 4. EMPLOYEE테이블에서 실수령액(3번 참고)이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
SELECT EMP_NAME "이름"
         , SALARY "월급"
         , ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) * 0.03 "실수령액"
         , HIRE_DATE "고용일"
FROM  EMPLOYEE
WHERE  ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) * 0.03 >= 50000000;

-- 5. EMPLOYEE테이블에서 사원명과 직원의 주민번호를 이용하여 생년, 생월, 생일 조회
SELECT EMP_NAME "사원명"
         , 19 || SUBSTR(EMP_NO, 1, 2) || '년' "생년"
         , SUBSTR(EMP_NO, 3, 2) || '월'"생월"
         , SUBSTR(EMP_NO, 5, 2) || '일' "생일"
FROM EMPLOYEE;

-- 6. EMPLOYEE테이블에서 직원명, 부서코드, 생년월일, 나이(만) 조회
-- 단, 생년월일은 주민번호에서 추출해서 00년 00월 00일로 출력되게 하며,
-- 나이는 주민번호에서 날짜 데이터로 변경 후 계산
SELECT EMP_NAME "직원명"
         , DEPT_CODE "부서코드"
         , 19 || SUBSTR(EMP_NO, 1, 2) || '년' || SUBSTR(EMP_NO, 3, 2) || '월' || SUBSTR(EMP_NO, 5, 2) || '일' "생년월일"
--         , REPLACE(SUBSTR(EMP_NO, 1, 2), SUBSTR(EMP_NO, 1, 2), SUBSTR(EMP_NO, 1, 2) 나이 어케 구하지 ;;;;
         , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) || '세' "나이(만)"
FROM EMPLOYEE;

-- 7. EMPLOYEE테이블에서 근무 년수가 20년 이상인 직원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20
ORDER BY HIRE_DATE ASC;

-- 8. EMPLOYEE테이블에서 부서코드가 D5, D6, D9인 사원만 조회하되 D5면 총무부, D6면 기획부, D9면 영업부로 처리
SELECT EMP_ID
     , EMP_NAME
     , EMP_NO
     , EMAIL
     , PHONE
     , DECODE(DEPT_CODE, 'D5', '총무부', 'D6', '기획부', 'D9', '영업부') "부서명"
     , JOB_CODE
     , SAL_LEVEL
     , SALARY
     , BONUS
     , MANAGER_ID
     , HIRE_DATE
     , ENT_DATE
     , ENT_YN
-- 정보 다 출력하면서 DEPT_CODE만 어떻게 바꾸지,,,? *, DECODE~ 안 됨
--> 강사님 답안 참고하니 그렇게 하는 방법은 없나 봄... 그냥 다 적어야 되나 봐
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6' ,'D9');

-- 9. EMPLOYEE테이블에서 사번이 홀수인 직원들의 정보 모두 조회
SELECT *
FROM EMPLOYEE
-- WHERE TO_NUMBER(EMP_ID, '999') / 2 = 1; 안됨 ;;
-- WHERE (EMP_ID * 1) / 2 = 1; 안됨;;;;;;
WHERE MOD(EMP_ID, 2) = 1;
