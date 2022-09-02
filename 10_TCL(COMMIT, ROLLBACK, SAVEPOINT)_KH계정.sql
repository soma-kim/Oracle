/*
    <TCL: TRANSACTION CONTROL LANGUAGE>
    트랜잭션을 제어하는 언어
    
    *트랜잭션 (TRANSACTION)
    - 데이터베이스의 논리적 연산 단위 (절대 쿼리문 한 개의 단위가 아님!)
    - 데이터의 변경사항 (DML) 들을 하나의 트랜잭션으로 묶어서 처리
        COMMIT (확정) 하기 전까지의 변경사항들을 하나의 트랜잭션에 담게 됨
    - 트랜잭션의 대상이 되는 SQL: INSERT, UPDATE, DELETE (DML)
    => 실행했을 때 뭔가가 바뀐다면 트랜잭션 대상이라고 생각하면 됨!
    
    *TCL의 종류
    COMMIT, ROLLBACK, SAVEPOINT
    
    [ 표현법] 
    - COMMIT; => 하나의 트랜잭션에 담겨 있는 변경사항들을 실제 DB에 반영하겠다를 의미함
                          실제 DB에 변경된 내용들을 반영시키고 나서 트랜잭션은 비워짐
    - ROLLBACK; => 하나의 트랜잭션에 담겨 있는 변경사항들을 실제 DB에 반영하지 않고
                            트랜잭션을 비워 주는 역할을 해 줌 (단, 마지막 COMMIT 시점까지만 비워 줌)
    - SAVEPOINT 포인트명 => 현재 이 명령어를 실행한 "시점"에서 해당 포인트명에 해당되는
                                         임시 저장점을 정의해 두는 것
    - ROLLBACK TO 포인트명; => 전체 변경사항들을 삭제하는 것이 아니라
                                              해당 포인트 지점까지의 트랜잭션만 롤백함
*/

-- EMP_ID 테이블
SELECT * FROM EMP_01;

-- 사번이 901번인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID = '901'; --> 참고! DELETE문은 조건 생략 가능하지만 WHERE절 안 쓰면 테이블 데이터 전체가 날아감

-- 사번이 900번인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID = '900';

SELECT * FROM EMP_01;

ROLLBACK; --> 사번 900, 901번 사원 데이터가 살아남

------------------------------

-- 사번 200번인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID = 200;

-- 사번 800, 이름 홍길동, 부서는 총무부인 사원 추가
INSERT INTO EMP_01 /* (EMP_ID, EMP_NAME, DEPT_TITLE) */
VALUES (800, '홍길동', '총무부');

SELECT * FROM EMP_01;

COMMIT; -- 이때 커밋을 안 해 주면 실제 DB에 트랜잭션이 반영되지 않았기 때문에 프로그램 껐다가 켜면 200번 삭제와 800번 삽입이 이루어지지 않은 상태일 것임!

------------------------------

-- 사번이 217, 216, 214인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID IN (217, 216, 214);

-- 3개의 행이 삭제된 시점에 SAVEPOINT 지정
SAVEPOINT SP;

-- 사번 801, 이름 고영희, 부서 인사부인 사원 추가
INSERT INTO EMP_01
VALUES (801, '고영희', '인사부');

SELECT * FROM EMP_01;

-- 사번이 218인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID = 218;

-- SP 이전까지만 롤백
ROLLBACK TO SP;

SELECT * FROM EMP_01;

COMMIT;

SELECT * FROM EMP_01;

------------------------------

-- 사번이 900, 901인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID IN (900, 901);

-- 사번이 218인 사원 삭제
DELETE
FROM EMP_01
WHERE EMP_ID = 218;

-- 테이블 생성 (DDL)
CREATE TABLE TEST (
    TID NUMBER
);

SELECT * FROM EMP_01;

ROLLBACK; -- 작업 잘못함 ;; ㄱㅊㄱㅊ 롤백 하면 900, 901, 218번 사원이 살아나겠지? 희희

SELECT * FROM EMP_01; -- 안 살아남 ;;

/*

    DDL 구문 (CREATE, ALTER, DROP)을 실행하는 순간
    기존의 트랜잭션에 있던 모든 변경사항들을 무조건 실제 DB에 반영 (COMMIT) 시킨 후에
    그 이후 DDL이 수행됨
    => 즉, DDL 수행 전 항상 변경사항들이 있었다면 정확히 픽스 (COMMIT, ROLLBACK) 후
         DDL을 실행해야 함

*/

