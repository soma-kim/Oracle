-- CREATE TABLE ���� �ο��ޱ� ��
CREATE TABLE TEST (
    TEST_ID NUMBER
);

-- 3_1. SAMPLE ������ ���̺��� ������ �� �ִ� ������ ���� ������ ���� �߻�
-- ORA-01031: insufficient privileges
--> ������� ���ѵ�

-- CREATE TABLE ���� �ο����� ��
CREATE TABLE TEST (
    TEST_ID NUMBER
);
-- 3_2. TABLE SPACE(���̺���� �� �ִ� ����)�� �Ҵ���� ����
-- ORA-01950: no privileges on tablespace 'SYSTEM'
--> ���̺����̽��� ���� ��� �Ұ��� ����

-- TEST SPACE �Ҵ���� ��
CREATE TABLE TEST (
    TEST_ID NUMBER
);
-- ���̺� ���� �Ϸ�

-- ���� ���̺� ���� ����(CREATE TABLE)�� �ο��ް� �Ǹ�
-- �⺻�����δ� �ش� ������ �����ϰ� �ִ� ���̺���� �����ϴ� �͵� ��������
SELECT * FROM TEST;
INSERT INTO TEST VALUES(1);

-- �� ����� ����
CREATE VIEW V_TEST
AS (SELECT *
      FROM TEST);
-- ORA-01031: insufficient privileges

-- 4. �� ��ü�� ������ �� �ִ� CREATE VIEW ������ ���� ������ ���� �߻�

-- CREATE VIEW ���� �ο����� ��
CREATE VIEW V_TEST
AS (SELECT * 
      FROM TEST);
-- �� ���� �Ϸ�

SELECT * FROM V_TEST;

--------------------------------------------------------------------------------------------------------------------------------------------

-- SAMPLE �������� KH ������ ���̺� �����ؼ� ��ȸ�� ����
SELECT *
FROM KH.EMPLOYEE;

-- 5. KH ������ ���̺� �����ؼ� ��ȸ�� �� �ִ� ������ ���� ������ ���� �߻�
-- ORA-00942: table or view does not exist

-- SELECT ON ���� �ο����� ��
SELECT *
FROM KH.EMPLOYEE;
-- EMPLOYEE ���̺� ��ȸ ����

SELECT *
FROM KH.DEPARTMENT;
-- KH ������ DEPARTMETN ���̺� ������ ���ִ� ������ ���� ������ ���� �߻�

-- SAMPLE �������� KH ������ ���̺� �����ؼ� �� ������ ����
INSERT INTO KH.DEPARTMENT
VALUES('D0', 'ȸ���', 'L2');

-- 6. KH������ ���̺� �����ؼ� ������ �� �ִ� ������ ���� ������ ���� �߻�
-- SQL ����: ORA-00942: table or view does not exist

-- INSERT ON ���� �ο����� ��
INSERT INTO KH.DEPARTMENT
VALUES ('D0', 'ȸ���', 'L2');
-- KH.DEPARTMENT ���̺� �� INSERT ����

SELECT * FROM KH.DEPARTMENT;
-- INSERT ���Ѹ� �־��� �� SELECT ������ ���� �ʾұ� ������ ��ȸ�� �Ұ���!


-- ���������� SAMPLE �������� �߰��� ���� �ݿ����� ����!
-- INSERT �� COMMIT���� �ؾ� KH ������ DEPARTMENT ���̺� �ݿ���!
-- SAMPLE�������� ���������� SAMPLE �������� Ŀ�� �� ��� ��!
COMMIT;
-- Ŀ�� �Ŀ��� ������ �ݿ���

-- ���̺� ����� ����
CREATE TABLE TEST2 (
    TEST_ID NUMBER,
    TEST_TITLE VARCHAR2(50)
);

-- 7. SAMPLE �������� ���̺��� ������ �� ������ ������ ȸ���߱� ������ ���� �߻�
-- ORA-01031: insufficient privileges

CREATE VIEW V_TEST2
AS (SELECT *
     FROM TEST
     WHERE 1 = 0);
-- ���̺��� ����� ������ ȸ������ �� �並 ����� ������ ȸ������ �ʾұ� ������
-- ��� �� �������