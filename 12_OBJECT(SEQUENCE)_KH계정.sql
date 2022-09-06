/*
    <시퀀스 SEQUENCE>
    자동으로 번호를 발생시켜 주는 역할을 하는 객체
    정수값을 자동으로 순차적으로 생성해 줌
    
    예) 회원번호, 사번, 게시글 번호 등등 "채번"할 때 주로 쓰일 예정
     
    1. 시퀀스 객체 생성 구문
    
    [ 표현법 ]
    CREATE SEQUENCE 시퀀스명
    START WITH 시작숫자                  => 처음 발생시킬 시작값 지정 (생략 가능)
    INCREMENT BY 증가값                 => 한번에 몇 씩 증가시킬 건지 지정 (생략 가능)
    MAXVALUE 최대값                       => 최대값 지정 (생략 가능)
    MINVALUE 최소값                       => 최소값 지정 (생략 가능)
    CYCLE/NOCYCLE                         => 값의 순환 여부를 지정 (생략 가능)
    CACHE 바이트크기/NOCACHE       => 캐시 메모리 사용 여부를 지정 (생략 가능)
                                                        CACHE_SIZE 기본값은 20BYTE
    
    *캐시 메모리: 미리 발생될 값들을 생성해서 저장해 두는 공간
                       매번 호출할 때마다 새로이 번호를 생성하는 것보다
                       캐시 메모리 공간에 미리 생성된 값들을 가져다 쓰게 되면 훨씬 속도가 빠름
                       단, 접속이 끊기고 나서 재접속 후 기존에 생성되어 있던 값들이 날아가고 없음
*/

/*
    *접두사
    - 테이블명: TB_
    - 뷰명: VW_
    - 시퀀스명: SEQ_
*/

CREATE SEQUENCE SEQ_TEST;

-- 현재 이 접속한 계정이 소유하고 있는 시퀀스에 대한 정보 조회용 데이터 딕셔너리
-- USER_SEQUENCES
SELECT * FROM USER_SEQUENCES;

-- 간단한 옵션을 부여해서 사번을 채번하는 용도의 시퀀스 생성하기
CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;
--> 이 시퀀스는 300, 305, 310만 채번 가능할 것

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    2. 시퀀스 사용 구문
    
    시퀀스명.CURRVAL: 현재 시퀀스의 값 (마지막으로 성공적으로 발생된 NEXTVAL 값)
                                => 마지막으로 성공적으로 발생된 NEXTVAL 값을 담아두는 일종의 변수 같은 개념!
    시퀀스명.NEXTVAL: 시퀀스의 값을 증가시키고 그 증가된 시퀀스 값
                               기존의 시퀀스 값에서 INCREMENT BY 값만큼 증가된 값
                               (시퀀스명.CURRVAL + INCREMENT BY 값)
                               
    => 단, 시퀀스 생성 후 첫 NEXTVAL은 START WITH로 지정된 시작값으로 발생
*/

-- 위에서 만든 SEQ_EMPNO을 가지고 테스트
SELECT SEQ_EMPNO.CURRVAL
FROM DUAL;
-- ORA-08002: sequence SEQ_EMPNO.CURRVAL is not yet defined in this session
-- => NEXTVAL을 한 번이라도 수행하지 않는 이상 CURRVAL을 쓸 수 없음
--      CURRVAL은 마지막에 성공적으로 수행한 NEXTVAL의 값을 저장해서 보여 주는 임시값이기 때문

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 300

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 300

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 다시 조회해도 여전히 300

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 305

SELECT * FROM USER_SEQUENCES;
-- 데이터 딕셔너리 조회 시 SEQ_EMPNO 시퀀스의 LAST_NUMBER 값이 310으로 지정되어 있음
-- LAST_NUMBER: 현재 상황에서 NEXTVAL을 한번 실행할 경우 발생될 "예정 값"

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 310
-- 마지막으로 성공적으로 이루어진 NEXTVAL
-- LAST_NUMBER: 315

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 310? 315?
-- ORA-08004: sequence SEQ_EMPNO.NEXTVAL exceeds MAXVALUE and cannot be instantiated
-- 지정한 MAXVALUE 값 (310)을 초과했기 때문에 오류 발생
-- 실패한 NEXTVAL

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 310
-- 마지막으로 성공적으로 이루어진 NEXTVAL인 310이 출력됨

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. 시퀀스 변경
    
    [ 표현법 ] 
    ALTER SEQUENCE 시퀀스명
    INCREMENT BY 증가값                    => 한 번에 몇씩 증가시킬 건지 지정 (생략 가능)
    MAXVALUE 최대값                         => 최대값 지정 (생략 가능)
    MINVALUE 최소값                          => 최소값 지정 (생략 가능)
    CYCLE/NOCYCLE                            => 값 순환 여부 지정 (생략 가능)
    CACHE 바이트크기/NOCACHE          => 캐시 메모리 사용 여부 지정 (생략 가능)
    
    *START WITH는 변경 불가 => 정 바꾸고 싶다면 시퀀스 삭제 후 다시 재생성해야 함!!
*/

ALTER SEQUENCE SEQ_EMPNO
MAXVALUE 400
INCREMENT BY 10;

SELECT * FROM USER_SEQUENCES;
-- 시퀀스 변경 전 LAST_NUMBER = 315 => INCREMENT BY = 5, CURRVAL = 310 (현재값)
-- 시퀀스 변경 후 LAST_NUMBER = 320
-- => 아무리 시퀀스가 바뀌더라도 CURRVAL 값은 바뀌지 않음

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 310

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 320

SELECT * FROM USER_SEQUENCES;
-- LAST_NUMBER = 330

-- 참고) SEQUENCE를 삭제하고 싶다면
DROP SEQUENCE SEQ_EMPNO;

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL;
-- ORA-02289: sequence does not exist
-- => 시퀀스가 없는데 조회하려고 해서 발생하는 오류
--------------------------------------------------------------------------------------------------------------------------------------------

-- 시퀀스 사용 예시
-- 매번 새로운 사번이 발생되는 시퀀스를 생성
CREATE SEQUENCE SEQ_EID
START WITH 300;

-- 매번 사원이 추가될 때마다 실행할 INSERT문
INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL -- 300
           , '홍길동'
           , '111111-1111111'
           , 'J2'
           , 'S3'
           , SYSDATE);
           
INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL -- 301
           , '김영희'
           , '222222-2222222'
           , 'J3'
           , 'S4'
           , SYSDATE);
           
SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL -- 302
           , '박말똥'
           , '111111-2111111'
           , 'J5'
           , 'S2'
           , SYSDATE);
           
SELECT * FROM EMPLOYEE;

-- 보통 시퀀스는 PRIMARY KEY에 해당하는 식별 번호를 채번할 때 주로 씀 (INSERT 구문에서 NEXTVAL 형식으로 씀)

-- 사원에 대해 추가 "요청" 시 실행할 SQL문
-- EMP_ID:              사용자로부터 직접적으로 입력 X, 시퀀스
-- EMP_NAME:        사용자로부터 직접적으로 입력 O
-- EMP_NO:            사용자로부터 직접적으로 입력 O
-- EMAIL:               사용자로부터 직접적으로 입력 O (필수 X)
-- PHONE:              사용자로부터 직접적으로 입력 O (필수 X)
-- DEPT_CODE:       사용자로부터 직접적으로 입력 X (필수 X)
-- JOB_CODE:         사용자로부터 직접적으로 입력 O
-- SAL_LEVEL:         사용자로부터 직접적으로 입력 O
-- SALARY:             사용자로부터 직접적으로 입력 X (필수 X)
-- BONUS:             사용자로부터 직접적으로 입력 X (필수 X)
-- MANAGER_ID:    사용자로부터 직접적으로 입력 X (필수 X)
-- HIRE_DATE:        SYSDATE 기준
-- ENT_DATE:         NULL으로 고정        
-- ENT_YN:            DEFAULT 'N'
INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , EMAIL
                                  , PHONE
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
                      VALUES  (SEQ_EID.NEXTVAL
                                  , ?
                                  , ?
                                  , ?
                                  , ?
                                  , ?
                                  , ?
                                  , SYSDATE);
