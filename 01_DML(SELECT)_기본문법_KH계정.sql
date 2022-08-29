/*
    < SELECT >
    DQL 또는 DML로 분류될 수 있는 명령어로써
    데이터를 조회하거나 검색할 때 사용하는 명령어
    
    - Result Set: SELECT 구문을 통해 조회된 데이터들의 결과물
                     즉, 조회된 행들의 집합
                     
    [ 표현법 ]
    SELECT 조회하고자하는컬럼명1, 컬럼명2, 컬럼명3,...
    FROM 테이블명;
    -> "어느" 테이블로부터 "무엇을" 조회할 것인지 명시

*/

-- EMPLOYEE 테이블의 전체 사원들의 사번, 이름, 급여 컬럼만을 조회
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- 명령어, 키워드, 테이블명, 컬럼명 등은 대소문자를 가리지 않음 (자바처럼 낙타표기법 불가)
-- 소문자로 써도 무방하지만 대문자로 쓰는 버릇을 들이자!

-- EMPLOYEE 테이블의 전체 사원들의 모든 컬럼을 다 조회
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE
        , SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN
FROM EMPLOYEE;

-- 해당 테이블의 전체 컬럼을 조회하고 싶다면 SELECT절에 SELECT *로 표현함
SELECT *
FROM EMPLOYEE;

-- JOB 테이블의 모든 컬럼 조회
SELECT *
FROM JOB;

-- JOB 테이블의 직급명 컬럼만 조회
SELECT JOB_NAME
FROM JOB;

----- 실습 문제 -----
-- 1. DEPARTMENT 테이블의 모든 컬럼 조회
SELECT *
FROM DEPARTMENT;

-- 2. EMPLOYEE 테이블의 직원명, 이메일, 전화번호, 입사일 컬럼만 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- 3. EMPLOYEE 테이블의 입사일, 직원명, 급여 컬럼만 조회
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

------------------------------------------------------------------------------------

/*
    <컬럼값을 통한 산술연산>
    조회하고자 하는 컬럼들을 나열하는 SELECT절에 산술연산(+, -, /, *)을 기술해서
    연산 결과를 조회할 수 있음
*/

-- EMPLOYEE 테이블로부터 직원명, 월급, 연봉(월급 * 12) 조회
SELECT EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE 테이블로부터 직원명, 월급, 보너스, 보너스가 포함된 연봉(월급 + (보너스*월급) *12) 조회
SELECT EMP_NAME, SALARY, BONUS, (SALARY + (SALARY * BONUS)) * 12
FROM EMPLOYEE;
--> 산술 연산 하는 과정에 NULL값이 존재한다면 그 산술연산 결과도 NULL이 나옴

-- DATE 타입끼리도 연산 가능 (DATE => 년, 월, 일, 시, 분, 초)
-- EMPLOYEE 테이블로부터 직원명, 입사일, 근무일수(오늘날짜 - 입사일) 조회
-- 오늘날짜: SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;
-- 결과값은 일 단위로 출력(지저분하게 소수점이 붙어서 출력됨)
-- 값이 지저분하게 나오는 이유는 DATE타입 안에 포함되어 있는 시, 분, 초에 대한 연산까지 함께 수행하기 때문

------------------------------------------------------------------------------------
/*
    <컬럼명에 별칭 지정하기>
    RESULT SET상에 보여지는 컬럼명이 복잡한 수식 형태거나 알아보기 힘들 경우에는
    별칭을 붙일 수 있음 => 더 깔끔하게 보여지는 효과
    
    [ 표현법 ]
    컬럼명 AS 별칭, 컬럼명 AS "별칭", 컬럼명 별칭, 컬럼명 "별칭"
    => AS는 alias의 약자이며, SELECT절에 4가지 중 아무것이나 사용 가능
    
    단, AS를 붙이든 안 붙이든 별칭 내부에 특수문자나 띄어쓰기가 포함될 경우
    반드시 그 별칭을 ""로 묶어서 표기해야 함
*/

-- EMPLOYEE 테이블로부터 이름, 급여(월), 보너스, 총 소득을 조회
SELECT EMP_NAME AS 이름, SALARY AS "급여(월)", BONUS 보너스, SALARY + (BONUS * SALARY) * 12 "총 소득"
FROM EMPLOYEE;
------------------------------------------------------------------------------------
/*
    <리터럴 == 데이터 값>
    임의로 지정한 리터럴을 SELECT절에 기술하면
    실제 그 테이블에 존재하는 데이터처럼 조회 가능
    
    SELECT절에 제시한 리터럴 값은 조회 결과인 RESULT SET의 모든 행에 반복적으로 출력됨
*/

-- EMPLOYEE 테이블로부터 사번, 사원명, 급여 단위 조회하기
SELECT EMP_ID, EMP_NAME, SALARY, '원' 단위
FROM EMPLOYEE;
--> 오라클에서 문자열 타입의 값은 ' '(홑따옴표)로 감싸서 표현

------------------------------------------------------------------------------------
/*
    <DISTINCT>
    조회하고자 하는 컬럼명 앞에 기술하면
    해당 컬럼 내에 중복된 값들을 단 한 번씩만 출력해 주는 효과를 줌
    
    단, 한 SELECT 절에 DISTINCT 구문은 한 번만 기술 가능
    
    [ 표현법 ]
    SELECT DISTINCT 컬럼명
*/

-- 부서코드를 조회
-- 이 "회사의 모든 부서코드"를 조회하시오
SELECT DEPT_ID
FROM DEPARTMENT;

-- EMPLOYEE 테이블로부터 부서코드를 조회
-- 이 회사의 "사원들이 소속된" 모든 부서 코드를 조회하시오
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- EMPLOYEE 테이블로부터 직급코드를 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- 컬럼이 여러 개일 경우 DISCTINCT를 적용하면 어떻게 될까?
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;
--> DEPT_CODE, JOB_CODE 값을 세트로 묶어서 중복 판별이 일어남
--> DEP_CODE 중복 없이, JOB_CODE 중복 없이 출력이 아닌!!
--> DEPT_CODE가 D6이면서 JOB_CODE가 J3인 1행과 같은 값이 있다면 중복 없도록 1번만 출력함

------------------------------------------------------------------------------------
/*
    <WHERE절>
    조회하고자 하는 테이블에 특정 조건을 제시해서
    그 조건에 만족하는 데이터만을 조회하고자 할 때 기술하는 구문
    
    [ 표현법 ]
    SELECT 조회하고자하는컬럼1, 컬럼명2, 컬럼명3, ...
    FROM 테이블명
    WHERE 조건식;
    
    실행순서: FROM절 -> WHERE절 -> SELECT절
    
    - 조건식에 다양한 연산자들 사용 가능
    
    < 비교 연산자 >
    >, <, >=, <=: 대소 비교 연산
    =: 일치 비교 연산 (자바에서의 동등 비교 연산은 ==이었음)
    !=, ^=, <>: 일치하지 않음을 비교하는 연산
*/

-- EMPLOYEE 테이블로부터 "급여가 400만원 이상인" 사원들만 조회 (모든 컬럼에 대해서 조회)
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE 테이블로부터 부서코드가 D9인 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE 테이블로부터 부서코드가 D9가 아닌 사원들의 사원명, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE <> 'D9';
-- WHERE DEPT_CODE != 'D9';
WHERE DEPT_CODE ^= 'D9';

-- EMPLOYEE 테이블로부터 현재 재직 중인 사원들의 사번, 이름, 입사일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

----- 실습문제 -----
-- 1. EMPLOYEE 테이블로부터 급여가 300만원 이상인 사람들의 이름, 급여, 입사일 조회
SELECT EMP_NAME 사원명, SALARY "급여", HIRE_DATE AS 입사일
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE 테이블로부터 직급코드가 J2인 사원들의 이름, 급여, 보너스 조회
SELECT EMP_NAME AS "사원명", SALARY 급여, BONUS 보너스
FROM EMPLOYEE
WHERE JOB_CODE = 'J2';

-- 3. EMPLOYEE 테이블로부터 연봉(월급 * 12)이 5000만원 이상인 사원들의 이름, 급여, 연봉, 입사일 조회
SELECT EMP_NAME 사원명, SALARY 급여, SALARY * 12 AS 연봉, HIRE_DATE 입사일
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000; -- 2
--> SELECT 절에 부여한 별칭을 WHERE절에서 사용할 수 없음!
--> FROM절 -> WHERE절 -> SELECE절 순서로 진행되기 때문
------------------------------------------------------------------------------------
/*
    <논리연산자>
    여러 개의 조건을 엮을 때 사용
    AND : ~이면서, 그리고 (자바에서는 && 였음)
    OR: ~이거나, 또는 (자바에서는 || 였음)
*/

-- EMPLOYEE 테이블로부터 부서코드가 D9이면서 급여가 500만원 이상인 사원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9') AND (SALARY >= 5000000);

-- EMPLOYEE 테이블로부터 부서코드가 D6이거나 급여가 300만원 이상인 사원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D6') OR (SALARY >= 3000000);

-- EMPLOYEE 테이블로부터 급여가 350만원 이상이고 600만원 이하인 사원들의 이름, 사번, 급여, 직급코드 조회
SELECT EMP_NAME, DEPT_CODE, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE (SALARY >= 3500000) AND (SALARY <= 6000000);

------------------------------------------------------------------------------------
/*
    <BETWEEN AND>
    몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 사용
    
    [ 표현법 ]
    비교대상컬럼명 BETWEEN 하한값 AND 상한값
*/

SELECT EMP_NAME, DEPT_CODE, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE 테이블로부터 급여가 350만원 미만이고 600만원 포과인 사원들의 이름, 사번, 급여, 직급코드 조회
SELECT EMP_NAME, EMP_ID, SALARY, JOB_CODE
FROM EMPLOYEE
-- WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
--> 오라클에서의 NOT은 자바의 논리부정연산자인 ! 와 동일한 의미

-- EMPLOYEE 테이블로부터 입사일이 '90/01/01' ~ '03/01/01' 인 사원들의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEE
-- WHERE '90/01/01' <= HIRE_DATE AND HIRE_DATE <= '03/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '03/01/01';
--> BETWEEN AND 연산자는 DATE 형식간에도 사용 가능하다.

-- EMPLOYEE 테이블로부터 입사일이 '90/01/01'~ '03/01/01' 가 아닌 사원들의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE NOT BETWEEN '90/01/01' AND '03/01/01';
--> NOT의 위치는 비교대상컬럼명의 앞 또는 뒤 어디든 가능함!

------------------------------------------------------------------------------------
/*
    < LIKE '특정패턴' >
    비교하고자 하는 컬럼값이 내가 지정한 특정 패턴에 만족될 경우 조회
    
    [ 표현법 ]
    비교대상컬럼명 LIKE '특정패턴'
    
    - 특정 패턴에 와일드카드인 '%', '_' 를 가지고 제시할 수 있음
    '%' : 0 글자 이상
          비교대상컬럼명 LIKE '문자%' => 컬럼값 중에 '문자'로 시작되는 것을 조회
                    '문자'         -> 조회됨
                    '문자~~~'  -> 조회됨
          비교대상컬럼명 LIKE '%문자' => 컬럼값 중에 '문자'로 끝나는 것을 조회
                    '문자'         -> 조회됨
                    '~~~문자'  -> 조회됨
          비교대상컬럼명 LIKE '%문자%' => 컬럼값 중에 '문자' 가 포함되는 것을 조회 (검색기능 구현 시 많이 쓰임)
                    '문자'         -> 조회됨
                    '문자~~~'  -> 조회됨
                    '~~~문자'  -> 조회됨
    '_' : 1글자
          비교대상컬럼명 LIKE '_문자' => 해당 컬럼값 중에 '문자' 앞에 무조건 1글자가 있을 경우 조회
                    '문자'    -> 조회됨
                    '_문자'  -> 조회됨
          비교대상컬럼명 LIKE '문자_' => 해당 컬럼값 중에 '문자' 뒤에 무조건 1글자가 있을 경우 조회
                    '문자'    -> 조회됨
                    '문자_'  -> 조회됨
          비교대상컬럼명 LIKE '__문자' => 해당 컬럼값 중에 '문자' 앞에 무조건 2글자가 있을 경우 조회
                    '문자'    -> 조회됨
                    '__문자'  -> 조회됨
                    
*/

-- EMPLOYEE 테이블로부터 성이 전씨인 사원들의 이름, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE 테이블로부터 이름 중에 ' 하'가 포함된 사원들의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

-- EMPLOYEE 테이블로부터 전화번호 네번째 자리가 9로 시작하는 사원들의 사번, 사원명, 전화번호, 이메일 조회
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- EMPLOYEE 테이블로부터 이름 가운데 글자가 '지'인 사원들의 모든 컬럼을 조회
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_지_';

-- 그 이외의 사원
SELECT *
FROM EMPLOYEE
-- WHERE NOT EMP_NAME LIKE '_지_';
WHERE EMP_NAME NOT LIKE '_지_';

----- 실습 문제 -----

-- 1. 이름이 '연'으로 끝나는 사원들의 이름, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '__연';

-- 2. 전화번호 처음 3글자가 010이 아닌 사원들의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

-- 3. DEPARTMENT 테이블로부터 해외영업과 관련된 부서들의 모든 컬럼을 조회
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';

------------------------------------------------------------------------------------
/*
    <IS NULL>
    해당 컬럼값이 NULL인지를 판별해 주는 연산자
    
    [ 표현법 ]
    비교대상컬럼명 IS NULL: 컬럼값이 NULL과 일치할 경우만 조회
    비교대상컬럼명 IS NOT NULL: 컬럼값이 NULL과 일치하 않을 경우만 조회
*/

SELECT *
FROM EMPLOYEE;

-- 보너스를 받지 않는 사원들 (BONUS 컬럼값이 NULL일 경우)의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- 보너스를 받는 사원들
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- 사수가 없는 사원들의 사원명, 사수 사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 사수도 없고 부서 배치도 받지 않은 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 부서 배치는 받지 않았지만 보너스는 받는 사원의 이름, 보너스, 부서코드 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUSE IS NOT NULL;

------------------------------------------------------------------------------------
/*
    <IN>
    비교 대상 컬럼 값에 내가 제시한 목록들 중에서 하나라도 일치하는 값이 있으면 조회
    
    [ 표현법 ]
    비교대상컬럼명 IN (값, 값, 값, ...)
*/

-- 부서코드가 D6이거나 또는 D8이거나 또는 D5인 사람들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = '5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');
--> 동등비교 조건이 여러 개 OR 연산으로 붙어 있을 경우 IN 연산자를 이용하여 간략하게 표현 가능

-- 그 이외의 사원들
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D6', 'D8', 'D5');
--> NOT을 쓰고 싶다면 연산자 앞에 NOT

------------------------------------------------------------------------------------

/*
    <연결 연산자 ||>
    여러 컬럼값들을 마치 하나의 컬럼인 것처럼 연결시켜 주는 연산자
    주로 SELECT절에 쓰이며 컬럼과 리터럴 값을 연결시켜 주는 것도 가능
    
    System.out.println("num: " + num);
*/

SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- XX번 XXX님의 월급은 XXXXXX원입니다.
SELECT EMP_ID || '번 ' || EMP_NAME || '님의 월급은 ' || SALARY || '원입니다.' AS "급여정보"
FROM EMPLOYEE;

------------------------------------------------------------------------------------
/*
    <연산자 우선순위>
    0. ()
    1. 산술연산자
    2. 연결연산자
    3. 비교연산자
    4. IS NULL, LIKE, IN
    5. BETWEEN AND
    6. NOT
    7. AND (논리연산자)
    8. OR (논리연산자)
    
    예) DEPT_CODE가 D9이거나 D1이고 SALARY가 300만원 이하인 사원의 전체 컬럼
    SELECT *
    FROM EMPLOYEE
    WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D1') AND SALARY <= 3000000
*/

------------------------------------------------------------------------------------
/*
    <ORDER BY절>
    SELECT문 가장 마지막에 기입하는 구문뿐 아니라 실행 순서 또한 가장 마지막
    다 조회된 내용물을 어느 기준점에 맞춰 정렬해 주는 역할
    
    [ 표현법 ]
    SELECT 조회하고자하는컬럼1, 컬럼2, ...
    FROM 테이블명
    WHERE 조건식 (생략 가능)
    ORDER BY [정렬기준으로삼고자하는컬럼명/별칭/컬럼순번] [ASC/DESC](생략 가능) [NULLS FIRST/NULLS LAST](생략가능);
    
    - ASC: 오름차순 정렬 => 작은 거에서부터 큰 거 순서대로 나열 (생략 시 기본값)
    - DESC: 내림차순 정렬 => 큰 거에서 작은 거 순서대로 나열
    
    - NULLS FIRST: 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당 NULL을 앞으로 배치 (DESC일 경우 기본값)
    - NULLS LAST: 정렬하고자 하는 컬럼값에 NULL이 있을 경우 해당 NULL을 뒤로 배치 (ASC일 경우 기본값)

*/

SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME ASC;

SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS; -- ASC / DESC 생략 시 기본값이 ASC (오름차순)
-- ORDER BY BONUS ASC; -- ASC는 기본적으로 NULLS LAST임을 알 수 있음
-- ORDER BY BONUS ASC NULLS FIRST;
-- ORDER BY BONUS DESC; -- DESC는 기본적으로 NULLS FIRST임을 알 수 있음
-- ORDER BY BONUS DESC NULLS LAST;
ORDER BY BONUS DESC, SALARY ASC;
--> 첫 번째로 제시한 정렬 기준의 컬럼값이 일치할 경우 두 번째 정렬 기준을 가지고 다시 정렬

-- 전체 사원들의 이름, 급여, 연봉을 조회하되 연봉이 "높은 순서대로" 조회하기
SELECT EMP_NAME, SALARY, SALARY * 12 "연봉"
FROM EMPLOYEE
-- ORDER BY SALARY * 12 DESC;
-- ORDER BY  "연봉" DESC; -- 별칭 사용 가능(ORDER BY 진행 순서가 SELECT 다음인 제일 마지막이기 때문)
ORDER BY 3 DESC; -- 순번 사용 가능 (인덱스는 자바와 달리 1부터 셈!)


