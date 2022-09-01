/*
    <DML: DATA MANIPULATION LANGUAGE>
    ������ ���� ���
    
    ���̺� ���ο� �����͸� ����(INSERT)�ϰų� ������ �����͸� ����(UPDATE)�ϰų�
    ����(DELETE)�ϴ� ����
    
    + ������ ���� ���̺�κ��� �����͸� ��ȸ(SELECT)�ϴ� ������ �з��� �� �ִ�  
*/

/*
    1. INSERT: ���̺� ���ο� "��"�� �߰��ϴ� ����
    
    [ ǥ���� ]
    1) INSERT INTO ���̺�� VALUES (��, ��, ��, ...);
    => �ش� ���̺� ��� �÷��� ���� �߰��ϰ��� �ϴ� ���� ���� ���� �����ؼ�
         �� �� ������ INSERT �ϰ��� �� �� ���
         ������ ��: ���� ������ �� �׻� �÷��� ������ ���Ѽ� VALUES ��ȣ �ȿ� ���� �����ؾ� ��
         - �����ϰ� ���� �����ߴٸ�: NOT ENOUGH VALUE ���� �߻�
         - ���� �� ���� �����ߴٸ�: TOO MANY VALUES ���� �߻�
*/

INSERT INTO EMPLOYEE
VALUES (900
           , '�ڸ���'
           , '990215-2222222'
           , 'park_ms@kh.or.kr'
           , '01044442222'
           , 'D1'
           , 'J7'
           , 'S3'
           , 4000000
           , 0.2
           , 200
           , SYSDATE
           , NULL
           , DEFAULT);
           
SELECT * FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE EMP_ID = 900;

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    2) INSERT INTO ���̺�� (�÷���, �÷���, �÷���, �÷���, ...)
                            VALUES (��, ��, ��, ...);
    => �ش� ���̺� Ư�� �÷����� �����ؼ� �� �÷��� �߰��� ���� �����ϰ��� �� �� ���
    �׷��� �� �� ������ �߰��Ǳ� ������ ������ �� �� �÷��� ���ؼ��� �⺻������ NULL ���� ��
    (��, DEFAULT ������ �Ǿ� �ִ� �÷����� DEFAULT ���� ��)
    ������ ��: NOT NULL ���� ������ �ɷ� �ִ� �÷��� �ݵ�� �����ؼ� ���� �� ������ ��� ��
                  (���� �� �� �÷��� �⺻������ NULL�� ���� ������)
                  ��! �ƹ��� NOT NULL ���������� �ɷ� �ִ� �÷��̶� DEFAULT ������ �ɷ� �ִٸ� ���� �� �ص� ��
                  => �� �ص� DEFAULT �� ���ϱ�
*/

INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , DEPT_CODE
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
                      VALUES (901
                                 , '�踻��'
                                 , '980418-1111111'
                                 , 'D1'
                                 , 'J2'
                                 , 'S1'
                                 , SYSDATE);
                                 
SELECT * FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3) INSERT INTO ���̺�� (); 
    => VALUES�� ���� �����ϴ� �� ��ſ� ���������� ��ȸ�� ��������� ��°�� INSERT�ϴ� ����
    ��, ���� ���� �� ���� INSERT��ų �� ����
*/

-- �׽�Ʈ�� ���ο� ���̺� ���� �����
CREATE TABLE EMP_01 (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);

-- ��ü ������� ���, �̸�, �μ����� ��ȸ�� ����� EMP_01 ���̺� ��°�� �߰�
-- 1) ��ü ������� ���, �̸�, �μ����� ��ȸ�ϴ� �������� �����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+); -- 25���� �� ��ȸ��

-- 2) ���� ���������� ���� EMP_01 ���̺� ��ȸ�� ������� ��°�� �߰�
INSERT INTO EMP_01
(SELECT EMP_ID, EMP_NAME, DEPT_TITLE
 FROM EMPLOYEE, DEPARTMENT
 WHERE DEPT_CODE = DEPT_ID(+)); -- 25���� �� ��ȸ��
 
SELECT * FROM EMP_01;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    2. INSERT ALL
    �� �� �̻��� ���̺� ���� INSERT �� �� ����
    ��, �̶� ���Ǵ� ���������� ������ ��쿩�� ��
*/

-- �׽�Ʈ�� ���ο� ���̺� ���� �����
-- ù ��° ���̺�: �޿��� 300���� �̻��� ������� ���, �����, ���޸� ���� ������ ���̺�
CREATE TABLE EMP_JOB (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    JOB_NAME VARCHAR2(20)
);

-- �� ��° ���̺�: �޿��� 300����� �̻��� ������� ���, �����, �μ��� ���� ������ ���̺�
CREATE TABLE EMP_DEPT (
    EMP_ID NUMBER,
    EMP_NAME VARCHAR2(30),
    DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_JOB;
SELECT * FROM EMP_DEPT;

-- ���������� ���� ��������: EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE ��� ��ȸ
-- EMP_JOB: EMP_ID, EMP_NAME, JOB_NAME
-- EMP_DEPT: EMP_ID, EMP_NAME, DEPT_TITLE
-- �޿��� 300���� �̻��� ������� ���, �̸�, ���޸�, �μ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY >= 3000000; -- �� 9�� ��ȸ

/*
    [ǥ����]
    1) INSERT ALL
       INTO ���̺��1 VALUES (�÷���, �÷���, �÷���, ...)
       INTO ���̺��2 VALUES (�÷���, �÷���, �÷���, ...)
       ...
       INTO ���̺��2 VALUES (�÷���, �÷���, �÷���, ...)
       (��������);
*/

-- EMP_JOB ���̺��� �޿��� 300���� �̻��� ������� EMP_ID, EMP_NAME, JOB_NAME�� ����
-- EMP_DEPT ���̺��� �޿��� 300���� �̻��� ������� EMP_ID, EMP_NAME, DEPT_TITLE�� ����
INSERT ALL
INTO EMP_JOB VALUES (EMP_ID, EMP_NAME, JOB_NAME)
INTO EMP_DEPT VALUES (EMP_ID, EMP_NAME, DEPT_TITLE)
(SELECT EMP_ID, EMP_NAME, JOB_NAME, DEPT_TITLE
 FROM EMPLOYEE
 JOIN JOB USING (JOB_CODE)
 LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
 WHERE SALARY >= 3000000); -- �������������� �� 9���� ���� ��ȸ��
 --> 18�� �� ����
 
SELECT * FROM EMP_JOB;
SELECT * FROM EMP_DEPT;
 
 --------------------------------------------------------------------------------------------------------------------------------------------
 -- INSERT ALL �� ���ǿ� ���󼭵� �ٸ��� ���̺� INSERT ����
 
 -- �׽�Ʈ�� ���� ���̺� ���� ����
 -- ù ��° ���̺�: 2010�⵵ ������ �Ի��� ����鿡 ���� ���, �����, �Ի���, �޿� (EMP_OLD)
CREATE TABLE EMP_OLD
 AS (SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
       FROM EMPLOYEE
       WHERE 1 =0); --> �� ������ �ƴ� �÷��� ������ ���� ���� ����

-- �� ��° ���̺�: 2010�⵵ ���Ŀ� �Ի��� ����鿡 ���� ���, �����, �Ի���, �޿� (EMP_NEW)
CREATE TABLE EMP_NEW
AS (SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
      FROM EMPLOYEE
      WHERE 1 = 0); --> �� ������ �ƴ� �÷��� ������ ���� ���� ����
      
-- �������� �κ�
SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
FROM EMPLOYEE
-- WHERE HIRE_DATE < '2010/01/01'; -- EMP_OLD ���̺� INSERT �ϰ� ���� ���: 9�� ��ȸ
WHERE HIRE_DATE >= '2010/01/01'; -- EMP_NEW ���̺� INSERT �ϰ� ���� ���: 16�� ��ȸ

/*
    2) INSERT ALL
        WHEN ����1 THEN ���̺��1 VALUES (�÷���, �÷���, ...)
        WHEN ����2 THEN ���̺��2 VALUES (�÷���, �÷���, ...)
        (��������);
*/

SELECT * FROM EMP_OLD;
SELECT * FROM EMP_NEW;

INSERT ALL
WHEN HIRE_DATE < '2010/01/01' THEN INTO EMP_OLD VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
WHEN HIRE_DATE >= '2010/01/01' THEN INTO EMP_NEW VALUES (EMP_ID, EMP_NAME, HIRE_DATE, SALARY)
(SELECT EMP_ID, EMP_NAME, HIRE_DATE, SALARY
 FROM EMPLOYEE);
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. UPDATE
    ���̺� ��ϵ� ������ �����͸� �����ϴ� ����
    
    [ǥ����]
    UPDATE ���̺��
    SET �ٲܳ���
    WHERE �������׿���������;
    
    ��,

    UPDATE ���̺��
    SET �÷��� = ������
        , �÷��� = ������
        , ...                     => SET������ ���� ���� �÷����� ���ÿ� �����ؼ� ���� ���� (, �� �����ؾ� ��! AND �ƴ�!)
                                 => ����� �����ڵ� �ƴ�! ���� ��������!
    WHERE �������࿡��������;  => WHERE���� ���� ����
                                            => ��, ���� �� ��ü ��� ���� �����Ͱ� �� ����Ǿ� ����
*/

-- ���纻 ���̺��� ���� �� �۾�
CREATE TABLE DEPT_COPY
AS (SELECT * FROM DEPARTMENT);

SELECT * FROM DEPT_COPY;

-- DEPT_COPY ���̺��� D9 �μ��� �μ����� ������ȹ������ ����
UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��';
-- WHERE ���� ������ ��� ��ü ��� ���� DEPT_TITLE ���� �� ������ȹ������ ����Ǿ� ����

-- ������ ���� ������ �ǵ����� ���� �� ����ϴ� ��ɾ�
ROLLBACK; -- �����ϸ� '�ѹ� �Ϸ�.' �޽��� ��

SELECT * FROM DEPT_COPY;

UPDATE DEPT_COPY
SET DEPT_TITLE = '������ȹ��'
WHERE DEPT_ID = 'D9';

SELECT * FROM DEPT_COPY;

-- ���纻 ���̺�
CREATE TABLE EMP_SALARY
AS (SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS
      FROM EMPLOYEE);
      
SELECT * FROM EMP_SALARY;

-- EMP_SALARY ���̺��� ���ö ����� �޿��� 1000�������� ����
UPDATE EMP_SALARY
SET SALARY = 10000000
WHERE EMP_NAME = '���ö';

SELECT * FROM EMP_SALARY;

-- EMP_SALARY ���̺��� ������ ��� �޿��� 700����, ���ʽ��� 0.2�� ����
UPDATE EMP_SALARY
SET SALARY = 7000000
    , BONUS = 0.2
WHERE EMP_NAME = '������';

SELECT * FROM EMP_SALARY;

-- ��ü ����� �޿��� ���� �޿��� 20% �λ��� �ݾ����� ���� (�⺻�޿� * 1.2)
UPDATE EMP_SALARY
SET SALARY = SALARY * 1.2;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *UPDATE �ÿ� ���������� ���
    ���������� ������ ��������� �����ϰ���
    
    UPDATE ���̺��
    SET �÷��� = (��������)
    WHERE ����; => WHERE���� ���� ����
*/

-- EMP_SALARY ���̺� �踻�� ����� �μ��ڵ带 ������ ����� �μ��ڵ�� ����
-- 1) ���� ������ ����� �μ��ڵ带 �˾Ƴ���
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '������'; -- D9

-- 2) �踻�� ����� �μ��ڵ带 D9�� ����
UPDATE EMP_SALARY
SET DEPT_CODE = (SELECT DEPT_CODE
                            FROM EMPLOYEE
                            WHERE EMP_NAME = '������')
WHERE EMP_NAME = '�踻��';

SELECT * FROM EMP_SALARY;

-- ���� ����� �޿��� ���ʽ��� ����� ����� �޿��� ���ʽ� ������ ����
-- 1) ����� ����� �޿��� ���ʽ� ��ȸ
SELECT SALARY, BONUS
FROM EMP_SALARY
WHERE EMP_NAME = '�����';

-- 2) ���� ����� �޿��� ���ʽ��� 408����, 0.2�� ����
UPDATE EMP_SALARY
SET SALARY = 4080000
    , BONUS = 0.2
WHERE EMP_NAME = '����';
--> �� �ᵵ ������!

UPDATE EMP_SALARY
SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                                    FROM EMP_SALARY
                                    WHERE EMP_NAME = '�����')
WHERE EMP_NAME = '����';
--> �÷� ������ ¦�� ���缭 �̷��� �ᵵ ��!

SELECT * FROM EMP_SALARY;

SELECT * FROM EMPLOYEE;

-- ���߱� ������ ����� 200���� ����
UPDATE EMPLOYEE
SET EMP_ID = 200
WHERE EMP_NAME = '������';
-- ORA-00001: unique constraint (KH.EMPLOYEE_PK) violated
-- => PRIMARY KEY �������ǿ� ����

-- ����� 200���� ����� �̸��� NULL�� ����
UPDATE EMPLOYEE
SET EMP_NAME = NULL
WHERE EMP_ID = 200;
-- ORA-01407: cannot update ("KH"."EMPLOYEE"."EMP_NAME") to NULL
-- => NOT NULL �������ǿ� ����

-- ���� �۾��� ������ Ȯ����Ű�� ��ɾ�
COMMIT;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    4. DELETE
    ���̺� ��ϵ� �����͸� �����ϴ� ����
    
    [ǥ����]
    DELETE
    FROM ���̺��
    WHERE �������࿡��������; => WHERE���� ���� ����
                                           => ��, ���� �� �ش� ���̺��� ��ü �� ��� ����
*/

SELECT * FROM EMPLOYEE;

DELETE
FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;

-- �ǵ�����
--> ���������� COMMIT�ߴ� �������� ���ư�
ROLLBACK;

-- �踻�˰� �ڸ��� ����� �����͸� �����
DELETE
FROM EMPLOYEE
-- WHERE EMP_NAME = '�踻��' OR EMP_NAME = �ڸ���';
WHERE EMP_NAME IN ('�踻��', '�ڸ���');

SELECT * FROM EMPLOYEE;

COMMIT;

-- DEPARTMENT ���̺�κ��� DEPT_ID�� D1�� �μ� ����
DELETE
FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
-- ORA-02292: integrity constraint (KH.SYS_C007114) violated - child record found
--> EMPLOYEE ���̺� D1�� �����ϴ� �ڽ� �����Ͱ� �ֱ� ������ ���� �߻�

-- DEPARTMENT  ���̺�κ��� DEPT_ID�� D3�� �μ� ����
DELETE
FROM DEPARTMENT
WHERE DEPT_ID = 'D3';
-- ������ �� �̷���� (D3�� ������ ���� �ִ� �ڽ� �����Ͱ� ���� ����)

SELECT * FROM DEPARTMENT;

ROLLBACK;

--------------------------------------------------------------------------------------------------------------------------------------------
-- DROP TABLE ���̺��; : ���̺� ��ü�� ���� �����ڴ�
-- DELETE FROM ���̺��; : ���̺��� "���빰" ��ü ���� (��, ���̺��� ������ �״�� ����)

/*
    *TRUNCATE: ���̺��� ��ü ���� ������ �� ����ϴ� ���� (����)
                      ��, �������� ����!
                      
    [ ǥ���� ]
              TRUNCATE TABLE ���̺��;                  |                    DELETE FROM ���̺��;
    -------------------------------------------------------------------------------------------------------------------
                ������ ���� ���� �Ұ�                        |      WHERE ���� ���ٿ� Ư�� ���� ���� ����
               ROLLBACK���� ���� �Ұ�                    |                  ROLLBACK���� ���� ����
       ���� �ӵ��� ����(�ٷ� �����ϱ� ����)            |                       ���� �ӵ��� ����
*/

SELECT * FROM EMP_SALARY; 

DELETE
FROM EMP_SALARY; -- 25�� �� ��(��) �����Ǿ����ϴ�.

ROLLBACK; -- �ѹ� �Ϸ�. (�����͵� ���� �� ���ƿ�)

TRUNCATE TABLE EMP_SALARY; -- Table EMP_SALARY��(��) �߷Ƚ��ϴ�.

ROLLBACK; -- �ѹ� �Ϸ�. 

SELECT * FROM EMP_SALARY; -- �ٵ� �����Ͱ� �� ���ƿ�...



