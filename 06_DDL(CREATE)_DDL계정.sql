/*
    *DDL (DATA DEFINITION LANGUAGE)
    데이터 정의 언어
    
    오라클에서 제공하는 객체(OBJECT)를 새로이 만들고 (CREATE), 구조를 변경하고(ALTER), 구조 자체를 삭제하는(DROP) 명령문
    
    오라클에서의 객체 (OBJECT): 데이터베이스를 이루는 구조물
                                            테이블(TABLE), 뷰(VIEW), 시퀀스(SEQUENCE), 인덱스(INDEX),
                                            패키지(PACKAGE), 트리거(TRIGGER), 프로시저(PROCEDURE),
                                            함수(FUNCTION), 동의어(SYSNONYM), 사용자(USER)
                                            
    => 즉, 데이터베이스의 구조 자체를 정의하는 언어로
         주로 DB 관리자, 설계자가 사용함
*/
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <CREATE TABLE>
    테이블이란?
    행(ROW), 열(COLUMN)로 구성되는 가장 기본적인 데이터베이스 객체
    모든 데이터는 테이블을 통해서 저장됨(즉, 데이터를 보관하고자 한다면 테이블을 만들어야 함)
    
    [ 기본적인 표현법 ]
    CREATE TABLE 테이블명 (
        컬럼명 자료형,
        컬럼명 자료형,
        컬럼명 자료형,
        ...
    );
    
    <자료형>
    - 문자 (CHAR(크기) / VARCHAR2(크기)): 크기는 BYTE 수이다.
                                                          (숫자, 영문자, 특수문자 => 한 글자당 1BYTE
                                                                                   한글 => 한 글자당 3BYTE)
            CHAR(바이트 수): 최대 2000BYTE까지 지정 가능
                                    고정길이 (아무리 적은 값이 들어와도 공백으로 채워서 처음에 할당한 크기 유지)
                                    주로 들어올 값의 글자 수가 정해져 있을 경우
                                    예) 성별: 남 / 여, M / F
                                         주민등록번호: XXXXXX-XXXXXXX
                                         휴대폰 번호: 010-XXXX-XXXX
                                    
            VARCHAR2(바이트 수): 최대 4000BYTE까지 지정 가능
                                            가변길이 (적은 값이 들어오면 그 담긴 값에 맞춰서 크기가 줄어듦)
                                            주로 값의 길이가 정해지지 않은 경우
                                            예) 집 주소, 아이디, 비밀번호, 게시글, 댓글 내용, ...
            => VAR는 '가변'을 의미하고, 2는 사이즈의 '2배'를 의미함
    
    - 숫자 (NUMBER) : 정수 / 실수 상관없이 NUMBER이다.
    
    - 날짜 (DATE):  년 월 일 시 분 초를 다 포함한 개념
    
*/

-- 회원들의 데이터를 담을 수 있는 테이블을 생성하기
-- 테이블명: MEMBER
-- 담을 데이터들: ID, 비밀번호, 이름, 회원가입일
CREATE TABLE MEMBER ( -- 테이블명이나 컬럼명 등을 작성할 경우 대소문자 구분 X => 낙타표기법 불가, 언더바로 구분
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20),
    MEMBER_NAME VARCHAR2(20),
    MEMBER_DATE DATE
);

SELECT * FROM MEMBER;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    컬럼에 주석 달기 (컬럼에 대한 설명)
    [ 표현법 ]
    COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
*/

COMMENT ON COLUMN MEMBER.MEMBER_ID IS '회원아이디';
COMMENT ON COLUMN MEMBER.MEMBER_PWD IS '회원비밀번호';
COMMENT ON COLUMN MEMBER.MEMBER_NAME IS '회원이름';
COMMENT ON COLUMN MEMBER.MEMBER_DATE IS '회원가입일';
--------------------------------------------------------------------------------------------------------------------------------------------
-- 현재 이 계정에 존재하는 테이블명, 컬럼명을 확인할 수 있는 명령어

-- 데이터 딕셔너리: 오라클의 다양한 객체들의 정보를 저장하고 있는 시스템 테이블
--                        읽기 전용이며 데이터의 수정이 불가능하고, 데이터베이스의 운영을 위해 존재함

-- USER_TABLES: 현재 이 계정이 가지고 있는 테이블들의 전반적인 구조를 확인할 수 있는 데이터 딕셔너리
SELECT * FROM USER_TABLES;

-- USER_TAB_COLUMNS: 현재 이 계정이 가지고 있는 테이블들의 모든 컬럼 정보를 조회할 수 있는 데이터 딕셔너리
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'MEMBER';

SELECT * FROM MEMBER;

-- 참고: 데이터를 추가할 수 있는 구문 (INSERT: 한 행 단위로 추가, 값의 순서를 맞춰서 작성
-- INSERT INTO 테이블명 VALUES(값, 값, 값, ...);
INSERT INTO MEMBER VALUES('user01', 'pass01', '김유저', '2021-02-01');
INSERT INTO MEMBER VALUES('user02', 'pass02', '이사람', '21/02/02');
INSERT INTO MEMBER VALUES('user03', 'pass03', '최고당', SYSDATE);

-- 지금부터 고려해야 할 것
INSERT INTO MEMBER VALUES(NULL, NULL, NULL, SYSDATE);
--> 아이디, 비밀번호, 이름에 NULL값이 존재하면 안 됨
INSERT INTO MEMBER VALUES('user03', 'pass03', '최저당', SYSDATE);
--> 중복된 아이디는 존재해서는 안 됨

-- 위의 NULL값이나 중복된 아이디값은 유효하지 않은 값들
-- 유효한 데이터값을 유지하기 위해서 "제약조건"을 걸어 줘야 함

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <제약조건 CONSTRAINTS>
    - 원하는 데이터값만 유지하기 위해서 (보관하기 위해서) 특정 컬럼마다 설정하는 제약
    - 제약 조건이 부여된 컬럼에 들어올 데이터에 문제가 있는지 없는지 자동으로 검사할 목적
    => 데이터 무결성 보장을 목적으로 씀
    
    - 종류: NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
    
    - 컬럼에 제약조건을 부여하는 방식: 컬럼레벨 / 테이블레벨
*/

/*
    1. NOT NULL 제약 조건
    해당 컬럼에 반드시 값이 존재해야 할 경우 사용
    (즉, NULL 값이 절대 들어와서는 안 되는 컬럼에 부여)
    삽입 또는 수정 시 NULL 값을 허용하지 않겠다.
    
    단, NOT NULL 제약 조건을 부여할 때는 컬럼레벨 방식밖에 안 됨
*/

-- NOT NULL 제약조건만 설정한 테이블 만들기
-- 컬럼레벨 방식: 컬럼명 자료형 제약조건명 => 제약조건을 부여하고자 하는 컬럼 뒤에 곧바로 기술하는 방식

-- 회원들의 정보를 담을 수 있는 테이블 VER.2
-- 테이블명: MEM_NOTNULL
-- 담고자 하는 컬럼: 회원번호, 회원아이디, 회원비밀번호, 회원이름, 성별, 연락처, 이메일

CREATE TABLE MEM_NOTNULL (
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE CHAR(13),
    EMAIL VARCHAR2(30)
);

SELECT * FROM MEM_NOTNULL;

-- 데이터 삽입
INSERT INTO MEM_NOTNULL
VALUES (1
            , 'user01'
            , 'pass01'
            , '김유저'
            , '여'
            , '010-1234-5678'
            , 'aaa@naver.com');

INSERT INTO MEM_NOTNULL
VALUES (2
            , NULL
            , NULL
            , NULL
            , NULL
            , NULL
            , NULL);
-- ORA-01400: cannot insert NULL into ("DDL"."MEM_NOTNULL"."MEM_ID")
-- NOT NULL 제약조건에 위배되어 오류가 발생

INSERT INTO MEM_NOTNULL
VALUES(2
           , 'user02'
           , 'pass02'
           , '최고당'
           , NULL
           , NULL
           , NULL);
           
INSERT INTO MEM_NOTNULL
VALUES(3
           , 'user01'
           , 'pass03'
           , '강아지'
           , '여'
           , NULL
           , NULL);
--> NOT NULL 제약조건이 부여되어 있지 않은 컬럼에는 값이 있든 NULL이든 상관없음
--> NOT NULL 제약조건이 부여되어 있는 컬럼에는 반드시 값이 존재해야 함!