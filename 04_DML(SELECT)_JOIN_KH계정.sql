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
-- 동일한 컬럼명 하나만 잘 적어 주면 알아서 매칭시켜 줌
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
WHERE E.JOB_CODE = J.JOB_CODE -- 연결고리에 대한 조건
    AND JOB_NAME = '대리'; -- 추가적인 조건
-- 협업 시 가독성을 높이기 위해 보통 조건은 한 줄씩 띄어쓰기, 들여쓰기 해서 쓴다.

-->> ANSI구문
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
-- JOIN JOB USING (JOB_CODE);
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
    WHERE JOB_NAME = '대리';

----- 실습문제 -----
-- 1. 부서가 '인사관리부'인 사원들의 사번, 사원명, 보너스를 조회

-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID
    AND DEPT_TITLE = '인사관리부';

-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE DEPT_TITLE = '인사관리부';

-- 2. 부서가 '총무부'가 아닌 사원들의 사원명, 급여, 입사일을 조회

-->> 오라클 전용 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
    AND DEPT_TITLE != '총무부';

-->> ANSI 구문
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE DEPT_TITLE != '총무부';

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회

-->> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, BONUS, D.DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID
 AND BONUS IS NOT NULL;

-->> ANSI 구문
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE BONUS IS NOT NULL;

-- 4. 아래의 두 테이블을 참고하여 부서코드, 부서명, 지역코드, 지역명 (LOCAL_NAME) 조회
SELECT * FROM DEPARTMENT -- LOCATION_ID
SELECT * FROM LOCATION -- LOCAL_CODE

-->> 오라클 전용 구문
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

-->> ANSI 구문
SELECT DEPT_ID, DEPT_TITLE, D.LOCATION_ID, L.LOCAL_NAME
FROM DEPARTMENT D
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE);
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    2. 포괄조인 / 왼쪽, 오른쪽, 전체 외부조인(OUTER JOIN)
    테이블간의 JOIN 시 일치하지 않은 행도 포함시켜서 조회 가능
    단, 반드시 LEFT/RIGHT 중 기준 테이블을 지정해야 함
    
    => 일단 일치하는 것들 조회 + 기준 테이블에서 누락됐던 것들 조회
*/

-- "전체" 사원들의 사원명, 급여, 부서명 조회
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- DEPT_CODE가 NULL인 두 명의 사원 정보가 조회되지 않음
-- 부서에 배정된 사원이 없는 부서(D3, D4, D7) 에 대한 부서명(마케팅부, 국내영업부, 해외영업3부)도 조회되지 않음
-- => 기본적으로 등가조인 / 내부조인에서는 일치하는 것들만 조회를 하기 때문에 위의 두 항목들이 조회되지 않음

-- 1) LEFT OUTER JOIN: 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
--                              즉, 뭐가 되었든 간에 왼편에 기술된 테이블의 데이터는 무조건 한 번씩은 조회하게 됨
--                              (일치하는 것을 찾지 못하더라도)

-->> ANSI 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE -- "기준점이 될 왼편 테이블" 기술
LEFT /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- INNER JOIN 했을 때는 부서가 NULL값인 2명의 정보는 나오지 않았지만
-- OUTER JOIN으로 연결하니까 NULL값이 채워져서 2명이 추가로 나옴!
--> EMPLOYEE 테이블을 기준으로 조회했기 때문에 EMPLOYEE에 존재하는 데이터는 뭐가 되었든 간에 조회되게끔 하겠음

--> 오라클 전용 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);
--> 내가 기준으로 삼을 테이블의 컬럼명이 아닌 반대 테이블의 컬럼명에 (+) 기호를 붙여 줌

-- 2) RIGHT OUTER JOIN: 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
--                                 즉, 뭐가 되었든 간에 오른편에 기술된 테이블의 데이터는 무조건 한 번씩 조회하게 됨
--                                  (일치하는 것을 찾지 못하더라도)

--> ANSI구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE 
RIGHT /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- LEFT와 RIGHT는 "방향 차이"이므로 위, 아래의 OUTER JOIN은 완벽하게 똑같음!

SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM DEPARTMENT
LEFT JOIN EMPLOYEE ON (DEPT_CODE = DEPT_ID);

--> 오라클 전용 구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- LEFT / RIGHT OUTER JOIN의 결과는 일단 등가조인의 결과로 공통적인 것들을 한 번씩 다 조회한 후
-- 기준이 되는 테이블에서 누락된 정보가 추가적으로 조회되는 개념

-- 3) FULL OUTER JOIN: 두 테이블이 가진 모든 행을 조회할 수 있도록 JOIN
--                               (단, 오라클 전용 구문에서는 불가)
-->> ANSI구문
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
FULL /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> 일치하는 내용물들 조회 + 왼쪽 테이블에서 누락된 것 조회 + 오른쪽 테이블에서 누락된 것 조회

--> 오라클 전용 구문 (에러: only one outer-joined table)
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+);

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. 카테시안 곱 (CATESIAN PRODUCT) / 교차조인 (CROSS JOIN)
    모든 테이블의 각 행들이 서로서로 맵핑된 결과가 조회됨(곱집합)
    두 테이블의 행들이 모두 곱해진 행들의 조합이 모두 다 출력됨 => 방대한 데이터 출력 => 과부하의 위험
    
    => 조인 조건이 잘못되었거나 누락됐을 경우 발생하기 때문에 주의해야 함
    
    예) 각각 N개, M개 행을 가진 테이블의 카테시안 곱 결과물은 N * M 개의 행이 나옴
*/

-- 사원명, 부서명 조회
--> 오라클 전용 구문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT; --> 23행 * 9행 => 207개 행 조회

--> ANSI구문
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
CROSS JOIN DEPARTMENT;
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    4. 비등가 조인(NON EQUAL JOIN)
    '=' (동등비교연산자) 를 사용하지 않는 조인문
    지정한 컬럼값이 일치하는 경우가 아닌 "범위"에 포함되는 경우 매칭시켜서 조회하겠다는 뜻
*/

-- 사원명, 급여, 급여등급(EMPLOYEE)
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE;

-- EMPLOYEE 테이블에 SAL_LEVEL이 없다는 가정하에 SAL_GRADE 테이블에서 가져온다고 해 보자!

-- SAL_GRADE 조회
SELECT *
FROM SAL_GRADE;

-- 사원명, 급여, 급여등급(SAL_GRADE)
--> 오라클 전용 구문
SELECT EMP_NAME, SALARY, S.SAL_LEVEL
FROM EMPLOYEE E, SAL_GRADE S
-- WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL; -- 연결고리에 대한 조건
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL; -- 연결고리에 대한 조건

--> ANSI 구문
SELECT EMP_NAME, SALARY, S.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);
--> 등가조인일 경우 INNER가 기본 타입
--> 조건을 걸면 자동으로 비등가조인 됨

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    5. 자체 조인(SELF JOIN)
    
    같은 테이블을 다시 한번 조인하는 경우
    즉, 자기 자신의 테이블과 다시 조인을 맺는 경우
*/

-- 사원의 사번, 사원명, 사원 급여, 사수의 사번
SELECT EMP_ID "사원의 사번"
         , EMP_NAME "사원명"
         , SALARY "사원 급여"
         , MANAGE_ID "사수의 사번"
FROM EMPLOYEE;

-- 사원의 사번, 사원명, 사원의 부서코드, 사원의 급여
-- 사원의 사번, 사원명, 사수의 부서코드, 사수의 급여

-- 사원정보, 사수정보를 각각 도출해 낼 테이블의 별칭
SELECT * FROM EMPLOYEE E; -- 사원에 대한 정보 도출용 테이블: E => 연결고리 컬럼: MANAGER_ID
SELECT * FROM EMPLOYEE M; -- 사수에 대한 정보 도출용 테이블: M => 연결고리 컬럼: EMP_ID

--> 오라클 전용 구문
SELECT E.EMP_ID "사원의 사번", E.EMP_NAME "사원명", E.DEPT_CODE "사원의 부서코드", E.SALARY "사원의 급여"
         ,  M.EMP_ID"사수의 사번", M.EMP_NAME "사수명", M.DEPT_CODE "사수의 부서코드", M.SALARY"사수의 급여"
FROM EMPLOYEE E, EMPLOYEE M
-- WHERE E.MANAGER_ID = M.EMP_ID; -- 일치하는 등가조인에 대한 조건을 제시했을 때: 사수가 있는 경우 (NULL이 아닐 경우)만 조회
WHERE E.MANAGER_ID = M.EMP_ID(+); -- 사수가 없는 사원도 모두 조회하고 싶을 때
-- 기준을 사원으로 잡고 기준이 아닌 곳에 (+)를 걸어 주면 사수가 NULL값인 값도 모두 조회됨

--> ANSI 구문
SELECT E.EMP_ID "사원의 사번", E.EMP_NAME "사원명", E.DEPT_CODE "사원의 부서코드", E.SALARY "사원의 급여"
         ,  M.EMP_ID"사수의 사번", M.EMP_NAME "사수명", M.DEPT_CODE "사수의 부서코드", M.SALARY"사수의 급여"
FROM EMPLOYEE E
-- JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID); -- 내부조인 구문으로 작성했을 경우: 사수가 있는 경우만 조회
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID); -- 외부조인 구문으로 작성했을 경우: 사수가 없는 경우도 포함해서 조회
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <다중 JOIN>
    3개 이상의 테이블을 조인하는 것
*/

-- 사번, 사원명, 부서명, 직급명
SELECT * FROM EMPLOYEE;        --    DEPT_CODE     JOB_CODE
SELECT * FROM DEPARTMENT;   --     DEPT_ID
SELECT * FROM JOB;                 --                          JOB_CODE

--> 오라클 전용 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J
-- WHERE DEPT_CODE = DEPT_ID -- 등가조인 조건을 부여할 경우: 부서 배치가 안 된 사원들은 조회 안 됨
WHERE DEPT_CODE = DEPT_ID(+) -- 포괄조인 조건을 부여할 경우: 부서 배치가 안 된 사원들을 포함해서 조회
    AND E.JOB_CODE = J.JOB_CODE;

--> ANSI 구문
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
-- JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- DEPARTMENT 테이블을 내부 조인 한 경우: 부서 배치가 안 된 사원들은 조회 안 됨
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- EMPLOYEE 기준 LEFT OUTER JOIN 된 상태
                                                                            -- DEPARTMENT 테이블을 LEFT OUTER JOINT 한 경우: 부서배치가 안 된 사원들을 포함해서 조회
       JOIN JOB USING (JOB_CODE); -- EMPLOYEE 기준 INNER JOIN 된 상태
-- 컬럼명 일치할 때
-- ON 구문: 별칭 필수, USING 구문: 별칭 필수 아님

-- 사번, 사원명, 부서명, 직급명, 근무지역명 (LOCAL_NAME)
SELECT * FROM EMPLOYEE;     --  DEPT_CODE      JOB_CODE
SELECT * FROM DEPARTMENT --  DEPT_ID                                    LOCATION_ID
SELECT * FROM JOB;              --                        JOB_CODE
SELECT * FROM LOCATION;    --                                                  LOCAL_CODE 

--> 오라클 전용 구문
SELECT EMP_ID "사번"
         , EMP_NAME "사원명"
         , DEPT_TITLE "부서명"
         , JOB_NAME "직급명"
         , LOCAL_NAME "근무지역명"
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION
WHERE DEPT_CODE = DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND LOCATION_ID = LOCAL_CODE;
    
--> ANSI 구문
SELECT EMP_ID "사번"
         , EMP_NAME "사원명"
         , DEPT_TITLE "부서명"
         , JOB_NAME "직급명"
         , LOCAL_NAME "근무지역명"
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE); -- 사실상 DEPARTMENT 테이블에 JOIN하는 개념)
-- 주의사항! 다중 JOIN 시, ANSI 구문을 이용할 경우 테이블명을 기술하는 순서가 중요!
-- LOCATION 테이블이 DEPARTMENT 테이블보다 먼저 조인되면 EMPLOYEE 테이블에 조인되는 꼴이기 때문에
-- EMPLOYEE 테이블에 LOCATION_ID 컬럼이 없어서 오류 발생

-- 사원명, 부서명, 직급명, 근무지역명, 근무국가명, 급여등급(SAL_GRADE)
SELECT * FROM EMPLOYEE;      -- DEPT_CODE     JOB_CODE           SALARY
SELECT * FROM DEPARTMENT; --   DEPT_ID                                                            LOCATION_ID
SELECT * FROM LOCATION;     --                                                                          LOCAL_CODE        NATIONAL_CODE
SELECT * FROM JOB;               --                      JOB_CODE
SELECT * FROM SAL_GRADE;    --                                          MIN_SAL, MAX_SAL
SELECT * FROM NATIONAL;     --                                                                                                    NATIONAL_CODE

--->> 오라클 전용 구문
SELECT EMP_NAME "사원명"
         , DEPT_TITLE "부서명"
         , JOB_NAME "직급명"
         , LOCAL_NAME "근무지역명"
         , NATIONAL_NAME "근무국가명"
         , S.SAL_LEVEL "급여등급"
FROM EMPLOYEE E, DEPARTMENT , JOB J, SAL_GRADE S, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE
  AND SALARY BETWEEN MIN_SAL AND MAX_SAL
  AND LOCATION_ID = LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE;                                                                                                                                                                                                                                                                                                                    
    --> 주의사항: 다중 조인 할 테이블이 많아질 경우 최대한 헷갈리지 않게 그냥 별칭 붙이자!
    
--> ANSI 구문
SELECT EMP_NAME "사원명"
     , DEPT_TITLE "부서명"
     , JOB_NAME "직급명"
     , LOCAL_NAME "근무지역명"
     , NATIONAL_NAME "근무국가명"
     , S.SAL_LEVEL "급여등급"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE); -- USING도 가능

-- 사원 사번, 사원명, 사원의 부서명, 사원 급여
-- 사수 사번, 사수명, 사수의 부서명, 사수 급여
SELECT * FROM EMPLOYEE E; -- 사원 테이블로부터 MANAGER_ID 컬럼        DEPT_CODE
SELECT * FROM EMPLOYEE M; -- 사수 테이블로부터 EMP_ID 컬럼               DEPT_CODE
SELECT * FROM DEPARTMENT; --                                                           DEPT_ID

--> 오라클 전용 구문
SELECT E.EMP_ID "사원의 사번"
         , E.EMP_NAME "사원의 이름"
         , D1.DEPT_TITLE "사원의 부서명" -- E.DEPT_CODE "사원 부서코드"
         , E.SALARY "사원의 급여"
         , M.EMP_ID "사수의 사번"
         , M.EMP_NAME "사수의 이름"
         , D2.DEPT_TITLE "사수의 부서명" -- M.DEPT_CODE "사수 부서코드"
         , M.SALARY "사수의 급여"
FROM EMPLOYEE E, EMPLOYEE M, DEPARTMENT D1, DEPARTMENT D2
WHERE (E.MANAGER_ID = M.EMP_ID)
  AND (E.DEPT_CODE = D1.DEPT_ID)
  AND (M.DEPT_CODE = D2.DEPT_ID);

--> ANSI 구문
SELECT E.EMP_ID "사원의 사번"
         , E.EMP_NAME "사원의 이름"
         , D1.DEPT_TITLE "사원의 부서명" -- E.DEPT_CODE "사원 부서코드"
         , E.SALARY "사원의 급여"
         , M.EMP_ID "사수의 사번"
         , M.EMP_NAME "사수의 이름"
         , D2.DEPT_TITLE "사수의 부서명" -- M.DEPT_CODE "사수 부서코드"
         , M.SALARY "사수의 급여"
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID)
JOIN DEPARTMENT D1 ON (E.DEPT_CODE = D1.DEPT_ID)
JOIN DEPARTMENT D2 ON (M.DEPT_CODE = D2.DEPT_ID);

----- JOIN 종합 실습문제 -----
-- 1. 직급이 대리이면서 ASIA 지역에 근무하는 직원들의 사번, 사원명, 직급명, 부서명, 근무지역명, 급여를 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_ID "사번"
         , E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명"
         , D.DEPT_TITLE "부서명"
         , L.LOCAL_NAME "근무지역명"
         , E.SALARY "급여"
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L
WHERE E.JOB_CODE = J.JOB_CODE
    AND E.DEPT_CODE = D.DEPT_ID
    AND D.LOCATION_ID = L.LOCAL_CODE
    AND J.JOB_NAME = '대리'
    AND L.LOCAL_NAME LIKE 'ASIA%';
    
-->> ANSI 구문
SELECT E.EMP_ID "사번"
         , E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명"
         , D.DEPT_TITLE "부서명"
         , L.LOCAL_NAME "근무지역명"
         , E.SALARY "급여"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
    WHERE J.JOB_NAME = '대리'
    AND L.LOCAL_NAME LIKE 'ASIA%';

-- 2. 70년대생이면서 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_NAME "사원명"
         , E.EMP_NO "주민번호"
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , J.JOB_CODE "직급명" -- E.JOB_CODE = J.JOB_CODE
FROM EMPLOYEE E, DEPARTMENT D, JOB J
WHERE E.DEPT_CODE =D.DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND TO_NUMBER(SUBSTR(E.EMP_NO, 1, 2), 99) BETWEEN 70 AND 79
    AND SUBSTR(E.EMP_NO, 8, 1) IN ('2', '4')
    AND E.EMP_NAME LIKE '전%';
    
-->> ANSI 구문
SELECT E.EMP_NAME "사원명"
         , E.EMP_NO "주민번호"
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , J.JOB_CODE "직급명" -- E.JOB_CODE = J.JOB_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
WHERE TO_NUMBER(SUBSTR(E.EMP_NO, 1, 2), 99) BETWEEN 70 AND 79
    AND SUBSTR(E.EMP_NO, 8, 1) IN ('2', '4')
    AND E.EMP_NAME LIKE '전%';

-- 3. 이름에 '형'자가 들어있는 직원들의 사번, 사원명, 직급명을 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_ID "사번"
         , E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
FROM EMPLOYEE E, JOB J
WHERE J.JOB_CODE = E.JOB_CODE
    AND E.EMP_NAME LIKE '%형%';

-->> ANSI 구문
SELECT E.EMP_ID "사번"
         , E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
    WHERE E.EMP_NAME LIKE '%형%';

-- 4. 해외영업팀에 근무하는 직원들의 사원명, 직급명, 부서코드, 부서명을 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명"
         , D.DEPT_ID "부서코드"
         , D.DEPT_TITLE "부서명" -- J.JOB_CODE = E.JOB_CODE / D.DEPT_ID = E.DEPT_CODE
FROM EMPLOYEE E, JOB J, DEPARTMENT D
WHERE J.JOB_CODE = E.JOB_CODE
    AND D.DEPT_ID = E.DEPT_CODE
    AND D.DEPT_TITLE LIKE '해외영업%'
-->> ANSI 구문
SELECT E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명"
         , D.DEPT_ID "부서코드"
         , D.DEPT_TITLE "부서명" -- J.JOB_CODE = E.JOB_CODE / D.DEPT_ID = E.DEPT_CODE
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
    WHERE D.DEPT_TITLE LIKE '해외영업%'

-- 5. 보너스를 받는 직원들의 사원명, 보너스, 연봉, 부서명, 근무지역명을 조회하시오
-->> 오라클 전용 구문
 SELECT E.EMP_NAME "사원명"
          , E.BONUS "보너스"
          , E.SALARY * 12 "연봉"
          , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
          , L.LOCAL_NAME "근무지역명" -- L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L
WHERE D.DEPT_ID(+) = E.DEPT_CODE
-- (+): 붙이는 곳은 기준 반대! = 기준 테이블의 null 값도 포함해서 계산해 주라
    AND L.LOCAL_CODE(+) = D.LOCATION_ID
    AND E.BONUS IS NOT NULL;
-->> ANSI 구문
 SELECT E.EMP_NAME "사원명"
          , E.BONUS "보너스"
          , E.SALARY * 12 "연봉"
          , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
          , L.LOCAL_NAME "근무지역명" -- L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE =D.DEPT_ID)
LEFT JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
WHERE E.BONUS IS NOT NULL;


-- 6. 부서가 있는 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "근무지역명" --  L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
WHERE J.JOB_CODE = E.JOB_CODE
    AND D.DEPT_ID = E.DEPT_CODE
    AND L.LOCAL_CODE = D.LOCATION_ID
    AND E.DEPT_CODE IS NOT NULL;
         -->> ANSI 구문
SELECT E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "근무지역명" --  L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
    WHERE E.DEPT_CODE IS NOT NULL;

-- 7. '한국' 과 '일본' 에 근무하는 직원들의 사원명, 부서명, 근무지역명, 근무국가명을 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_NAME "사원명"
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "근무지역명" -- L.LOCAL_CODE = D.LOCATION_ID
         , N.NATIONAL_NAME "근무국가명" -- N.NATIONAL_CODE = L.NATIONAL_CODE
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE D.DEPT_ID = E.DEPT_CODE
    AND L.LOCAL_CODE = D.LOCATION_ID
    AND N.NATIONAL_CODE = L.NATIONAL_CODE
    AND N.NATIONAL_NAME IN ('한국', '일본');
-->> ANSI 구문
SELECT E.EMP_NAME "사원명"
         , D.DEPT_TITLE "부서명" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "근무지역명" -- L.LOCAL_CODE = D.LOCATION_ID
         , N.NATIONAL_NAME "근무국가명" -- N.NATIONAL_CODE = L.NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
JOIN NATIONAL N ON (N.NATIONAL_CODE = L.NATIONAL_CODE)
    WHERE N.NATIONAL_NAME IN ('한국', '일본');

-- 8. 보너스를 받지 않는 직원들 중 직급코드가 J4 또는 J7 인 직원들의 사원명, 직급명, 급여를 조회하시오
-->> 오라클 전용 구문
SELECT E.EMP_NAME "사원명"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , E.SALARY "급여"
FROM EMPLOYEE E, JOB J
WHERE J.JOB_CODE = E.JOB_CODE
    AND BONUS IS NULL
    AND E.JOB_CODE IN ('J4', 'J7');
-->> ANSI 구문
SELECT EMP_NAME "사원명"
         , JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , SALARY "급여"
FROM EMPLOYEE E
JOIN JOB USING (JOB_CODE)
    WHERE BONUS IS NULL
        AND JOB_CODE IN ('J4', 'J7');

-- 9. 사번, 사원명, 직급명, 급여등급 (SAL_GRADE), 구분을 조회하는데
-- 이 때, 구분에 해당하는 값은
-- 급여등급이 S1, S2 인 경우 '고급'
-- 급여등급이 S3, S4 인 경우 '중급'
-- 급여등급이 S5, S6 인 경우 '초급' 으로 조회되게 하시오
-->> 오라클 전용 구문
SELECT E.EMP_ID "사번"
         , J.JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , DECODE(S.SAL_LEVEL, 'S1', '고급', 'S2', '고급', 'S3', '중급', 'S4', '중급', 'S5', '초급',  '초급') -- S.SAL_LEVEL = E.SAL_LEVEL
FROM EMPLOYEE E, JOB J, SAL_GRADE S
WHERE J.JOB_CODE = E.JOB_CODE
    AND S.SAL_LEVEL = E.SAL_LEVEL;
-->> ANSI 구문
SELECT EMP_ID "사번"
         , JOB_NAME "직급명" -- J.JOB_CODE = E.JOB_CODE
         , DECODE(SAL_LEVEL, 'S1', '고급', 'S2', '고급', 'S3', '중급', 'S4', '중급', 'S5', '초급',  '초급') -- S.SAL_LEVEL = E.SAL_LEVEL
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN SAL_GRADE USING (SAL_LEVEL)

-- 10. 각 부서별 총 급여합을 조회하되 이 때, 총 급여합이 1000만원 이상인 부서명, 급여합을 조회하시오
-->> 오라클 전용 구문
SELECT D.DEPT_TITLE "부서명"
        , SUM(E.SALARY) "급여합"
FROM EMPLOYEE E, DEPARTMENT D
WHERE D.DEPT_ID = E.DEPT_CODE
GROUP BY D.DEPT_TITLE
    HAVING SUM(E.SALARY) >= 10000000;
-->> ANSI 구문
SELECT D.DEPT_TITLE "부서명"
        , SUM(E.SALARY) "급여합"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
GROUP BY D.DEPT_TITLE
    HAVING SUM(E.SALARY) >= 10000000;

-- 11. 각 부서별 평균급여를 조회하여 부서명, 평균급여 (정수처리) 로 조회하시오 단, 부서배치가 안된 사원들의 평균도 같이 나오게끔 하시오
-->> 오라클 전용 구문
SELECT DEPT_TITLE "부서명"
         , ROUND(AVG(SALARY),0) "평균급여"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+)
GROUP BY DEPT_CODE, DEPT_TITLE(+);

-->> ANSI 구문
SELECT DEPT_TITLE "부서명"
         , ROUND(AVG(SALARY),0) "평균급여"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE =DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE;