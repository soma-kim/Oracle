DROP TABLE TB_PUBLISHER;
DROP TABLE TB_BOOK;
DROP TABLE TB_MEMBER;
DROP TABLE TB_RENT;

-- 실습 문제 --
-- 도서관리 프로그램을 만들기 위한 테이블들 만들기 --
-- 이때, 제약조건에 이름을 부여할것
-- 각 컬럼에 주석 달기
-- 단, 상단에 DROP TABLE 테이블명; 구문도 같이 적을 것

-- 1. 출판사들에 대한 데이터를 담기 위한 출판사 테이블 (TB_PUBLISHER)
-- 컬럼 : PUB_NO (출판사번호) -- 기본키 (PUBLISHER_PK)
--        PUB_NAME (출판사명) -- NOT NULL (PUBLISHER_NN)
--        PHONE (출판사전화번호) -- 제약조건 없음

CREATE TABLE TB_PUBLISHER (
    PUB_NO NUMBER CONSTRAINT PUBLISHER_PK PRIMARY KEY,
    PUB_NAME VARCHAR2(20) CONSTRAINT PULIBSHER_NN NOT NULL,
    PHONE VARCHAR2(20)
);
    
-- 3개 정도의 샘플 데이터 추가하기
INSERT INTO TB_PUBLISHER
VALUES (1
            , '민음사'
            , '02-246-4567');
            
INSERT INTO TB_PUBLISHER
VALUES (2
            , '길벗'
            , '051-403-1111');
            
INSERT INTO TB_PUBLISHER
VALUES (3
            , '문학사'
            , '010-1234-5678');
            
SELECT * FROM TB_PUBLISHER;

-- 2. 도서들에 대한 데이터를 담기 위한 도서 테이블 (TB_BOOK)
-- 컬럼 : BK_NO (도서번호) -- 기본키 (BOOK_PK)
--        BK_TITLE (도서명) -- NOT NULL (BOOK_NN_TITLE)
--        BK_AUTHOR (저자명) -- NOT NULL (BOOK_NN_AUTHOR)
--        BK_PRICE (가격)
--        BK_PUB_NO (출판사번호) -- 외래키(BOOK_FK) (TB_PUBLISHER 테이블을 참조하도록)
--                                 이 때, 참조하고 있는 부모데이터 삭제 시 자식 데이터도 삭제 되도록 한다.

CREATE TABLE TB_BOOK (
    BK_NO NUMBER CONSTRAINT BOOK_PK PRIMARY KEY,
    BK_TITLE VARCHAR2(30) CONSTRAINT BOOK_NN_TITLE NOT NULL,
    BK_AUTHOR VARCHAR2(30) CONSTRAINT BOOK_NN_AUTHOR NOT NULL,
    BK_PRICE NUMBER,
    BK_PUB_NO NUMBER CONSTRAINT BOOK_FK REFERENCES TB_PUBLISHER (PUB_NO) ON DELETE CASCADE
);

SELECT * FROM TB_BOOK;

-- 5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_BOOK
VALUES (1
            , 'ㄱ'
            , 'ㄱ'
            , 100
            , 1
);

INSERT INTO TB_BOOK
VALUES (2
            , 'ㄴ'
            , 'ㄴ'
            , 200
            , 2
);

INSERT INTO TB_BOOK
VALUES (3
            , 'ㄷ'
            , 'ㄷ'
            , 300
            , 3
);

INSERT INTO TB_BOOK
VALUES (4
            , 'ㄹ'
            , 'ㄹ'
            , 400
            , 1
);

INSERT INTO TB_BOOK
VALUES (5
            , 'ㅁ'
            , 'ㅁ'
            , 600
            , 1
);

SELECT * FROM TB_BOOK;

-- 3. 회원에 대한 데이터를 담기 위한 회원 테이블 (TB_MEMBER)
-- 컬럼명 : MEMBER_NO (회원번호) -- 기본키 (MEMBER_PK)
--         MEMBER_ID (아이디) -- 중복금지 (MEMBER_UQ)
--         MEMBER_PWD (비밀번호) -- NOT NULL (MEMBER_NN_PWD)
--         MEMBER_NAME (회원명) -- NOT NULL (MEMBER_NN_NAME)
--         GENDER (성별) -- 'M' 또는 'F' 로 입력되도록 제한 (MEMBER_CK_GEN)
--         ADDRESS (주소)
--         PHONE (연락처)
--         STATUS (탈퇴여부) -- 기본값으로 'N' 으로 지정, 그리고 'Y' 혹은 'N' 으로만 입력되도록 제약조건 (MEMBER_CK_ST)
--         ENROLL_DATE (가입일) -- 기본값으로 SYSDATE, NOT NULL 제약조건 (MEMBER_NN_EN)

CREATE TABLE TB_MEMBER (
    MEMBER_NO NUMBER CONSTRAINT MEMBER_PK PRIMARY KEY,
    MEMBER_ID VARCHAR2(20),
    MEMBER_PWD VARCHAR2(20) CONSTRAINT MEMNER_NN_PWD NOT NULL,
    MEMBER_NAME VARCHAR2(20) CONSTRAINT MEMBER_NN_NAME NOT NULL,
    GENDER CHAR(1) CONSTRAINT MEMBER_CK_GEN CHECK (GENDER IN ('M', 'F')),
    ADDRESS VARCHAR2(100),
    PHONE CHAR(13),
    STATUS CHAR(1) DEFAULT 'N' CONSTRAINT MEMBER_CK_ST CHECK (STATUS IN ('Y', 'N')),
    ENROLL_DATE DATE DEFAULT SYSDATE CONSTRAINT MEMBER_NN_EN NOT NULL,
    CONSTRAINT MEMBER_UQ UNIQUE (MEMBER_ID)
);

-- 5개 정도의 샘플 데이터 추가하기
INSERT INTO TB_MEMBER
VALUES (1
            , 'user01'
            , 'pass01'
            , '김일일'
            , 'F'
            , '서울시 영등포구'
            , '010-1111-2222'
            , NULL
            , SYSDATE);
            
SELECT * FROM TB_MEMBER;

INSERT INTO TB_MEMBER
VALUES (2
            , 'user02'
            , 'pass02'
            , '김이이'
            , 'M'
            , '부산시 영도구'
            , '010-2222-3333'
            , DEFAULT
            , DEFAULT);
            
INSERT INTO TB_MEMBER
VALUES (3
            , 'user03'
            , 'pass03'
            , '김삼삼'
            , 'F'
            , '부산시 사하구'
            , '010-1234-5678'
            , 'Y'
            , SYSDATE);
            
INSERT INTO TB_MEMBER
VALUES (4
            , 'user04'
            , 'pass04'
            , '박사사'
            , 'M'
            , '대전시 유성구'
            , NULL
            , 'N'
            , DEFAULT);
            
INSERT INTO TB_MEMBER
VALUES (5
            , 'user05'
            , 'pass05'
            , '오오오'
            , 'F'
            , '부산시 영도구'
            , '010-9999-7777'
            , DEFAULT
            , DEFAULT);
            
INSERT INTO TB_MEMBER
VALUES (6
            , 'user06'
            , 'pass06'
            , '최육'
            , 'M'
            , '서울시 강서구'
            , '010-1234-7774'
            , DEFAULT
            , SYSDATE);
            
INSERT INTO TB_MEMBER
VALUES (7
            , 'user07'
            , 'pass07'
            , '허칠칠'
            , 'M'
            , '부산시 영도구'
            , NULL
            , 'Y'
            , '22/8/20');
            
INSERT INTO TB_MEMBER
VALUES (8
            , 'user08'
            , 'pass08'
            , '왕팔팔'
            , 'F'
            , '부산시 중구'
            , '010-8888-1111'
            , 'N'
            , DEFAULT);
            
INSERT INTO TB_MEMBER
VALUES (9
            , 'user09'
            , 'pass09'
            , '비구구'
            , 'M'
            , '부산시 영도구'
            , NULL
            , DEFAULT
            , DEFAULT);
            
INSERT INTO TB_MEMBER
VALUES (10
            , 'user10'
            , 'pass10'
            , '십열'
            , 'F'
            , '부산시 서구'
            , '010-4822-3333'
            , DEFAULT
            , DEFAULT);


-- 4. 어떤 회원이 어떤 도서를 대여했는지에 대한 대여목록 테이블 (TB_RENT)
-- 컬럼 : RENT_NO (대여번호) -- 기본키 (RENT_PK)
--        RENT_MEM_NO (대여회원번호) -- 외래키 (RENT_FK_MEM) TB_MEMBER 와 참조하도록
--                                    이 때, 부모 데이터 삭제 시 자식 데이터 값이 NULL 이 되도록 옵션 설정
--        RENT_BOOK_NO (대여도서번호) -- 외래키 (RENT_FK_BOOK) TB_BOOK 와 참조하도록
--                                     이 때, 부모 데이터 삭제 시 자식 데이터 값이 NULL 값이 되도록 옵션 설정
--        RENT_DATE (대여일) -- 기본값 SYSDATE

CREATE TABLE TB_RENT (
    RENT_NO NUMBER CONSTRAINT RENT_PK PRIMARY KEY,
    RENT_MEM_NO NUMBER CONSTRAINT RENT_FK_MEM REFERENCES TB_MEMBER (MEMBER_NO) ON DELETE SET NULL, -- 회원 번호 1~10 (회원 10명 생성)
    RENT_BOOK_NO NUMBER, -- 책 번호 1~5  (책 5개 생성)
    RENT_DATE DATE DEFAULT SYSDATE,
    FOREIGN KEY (RENT_BOOK_NO) REFERENCES TB_BOOK (BK_NO) ON DELETE SET NULL
);

SELECT * FROM TB_RENT;

-- 3개 정도의 샘플 데이터 추가하기
INSERT INTO TB_RENT
VALUES (1
            , 2
            , 5
            , SYSDATE);
            
INSERT INTO TB_RENT
VALUES (2
            , 6
            , 4
            , '22/08/22');
            
INSERT INTO TB_RENT
VALUES (3
            , 10
            , 2
            , DEFAULT);
