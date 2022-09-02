/*
    <VIEW ��>
    SELECT (������)�� ������ �� �� �ִ� ��ü
    (���� ���� �� SELECT���� ������ �ָ� �� SELECT���� �Ź� �ٽ� ����� �ʿ䰡 ����)
    �ӽ� ���̺� ���� ���� (���� �����Ͱ� ��� �ִ� ���� �ƴ�)
*/

----- �ǽ� ���� -----
-- '�ѱ�'���� �ٹ��ϴ� ������� ���, �̸�, �μ���, �޿�, �ٹ�������, ���޸��� ��ȸ�Ͻÿ�
DEPARTMENT DEPT_ID = EMPLOYEE DEPT_ CODE (D1)
JOB JOB_CODE = EMPLOYEE JOB_CODE (J1)
LOCATION LOCAL_CODE = DEPARTMENT LOCATION_ID (L1)
NATIONAL NATIONAL_CODE = LOCATION NATIONAL_CODE  (KO)

-->> ����Ŭ ���� ����
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
WHERE E.DEPT_CODE = D.DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND D.LOCATION_ID = L.LOCAL_CODE
    AND L.NATIONAL_CODE = N.NATIONAL_CODE
    AND N.NATIONAL_NAME = '�ѱ�';

-->> ANSI ����
SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE)
    AND N.NATIONAL_NAME = '�ѱ�';
    
/*
    1. VIEW ���� ���
    
    [ ǥ���� ]
    CREATE VIEW ���
    AS (��������);
*/

-- ��ü ������� ���, �̸�, �μ���, �޿�, �ٹ�������, ���޸��� ���� ��
CREATE VIEW VW_EMPLOYEE
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
      FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
      WHERE E.DEPT_CODE = D.DEPT_ID
          AND E.JOB_CODE = J.JOB_CODE
          AND D.LOCATION_ID = L.LOCAL_CODE
          AND L.NATIONAL_CODE = N.NATIONAL_CODE);
-- ORA-01031: insufficient privileges
-->> ���� KH�������� �� ���� ������ ��� ���� �߻�

-- ������� ��� ������ �������� ���� �� CREATE VIEW ���� �ο��ϱ�
GRANT CREATE VIEW TO KH;

-- �� �������� �ٽ� KH �������� ���� �� �۾�

-- View VW_EMPLOYEE��(��) �����Ǿ����ϴ�.
-- ���� �ο� �Ŀ��� VIEW�� �� �������!

SELECT * FROM VW_EMPLOYEE;

-- �Ʒ��� �������� ����� �ƶ�
SELECT *
FROM (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME
          FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
          WHERE E.DEPT_CODE = D.DEPT_ID
              AND E.JOB_CODE = J.JOB_CODE
              AND D.LOCATION_ID = L.LOCAL_CODE
              AND L.NATIONAL_CODE = N.NATIONAL_CODE);
              
-- '�ѱ�'���� �ٹ��ϴ� ������� ���, �����, �μ���, �޿�, �ٹ�������, ���޸��� ��ȸ�ϰ� �ʹٸ�
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '�ѱ�';

-- ���� ���� ������ ���������� �̿��Ͽ� �׶��׶� �ʿ��� �����͵鸸 ��ȸ�ϴ� �ͺ���
-- �ѹ� ���������� �並 ������ �� �ش� ������� SELECT���� �̿��ϸ� �� �����ϰ� ��ȸ ����

-- ���þƿ��� �ٹ��ϴ� ����鸸 ���� �ʹٸ�?
SELECT *
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '���þ�';

-- ���þƿ��� �ٹ��ϴ� ������� ���, �̸�, ����, ���ʽ�
SELECT EMP_ID, EMP_NAME, JOB_NAME, BONUS
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '���þ�';
-- ORA-00904: "BONUS": invalid identifier
-- VW_EMPLOYEE ���̺� BONUS �÷��� ���� ������ ���� �߻�

-- �信 ���ʽ� �÷��� ���� ���¿��� ���ʽ��� ���� ��ȸ�ϰ� �ʹٸ�?
-- �並 �ٽ� �����ϱ� => CREATE OR REPLACE VIEW ���

/*
    [ ǥ���� ]
    CREATE OR REPLACE VIEW ���
    AS (��������);
    
    => OR REPLACE�� ���� ������
         �� ���� �� ������ �ߺ��� �� �̸��� �ִٸ� ���Ӱ� �並 �����ϴ� �� �ƴ϶� �ش� �並 ����(����) �ϴ� �ɼ�
                        ������ �ߺ��� �� �̸��� ���ٸ� ���Ӱ� �並 ������
                        ��, ������ ������ ������ ���� ����!
*/

CREATE OR REPLACE VIEW VW_EMPLOYEE
AS (SELECT E.EMP_ID, E.EMP_NAME, D.DEPT_ID, E.SALARY, N.NATIONAL_NAME, J.JOB_NAME, E.BONUS
      FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L, NATIONAL N
      WHERE E.DEPT_CODE = D.DEPT_ID
          AND E.JOB_CODE = J.JOB_CODE
          AND D.LOCATION_ID = L.LOCAL_CODE
          AND L.NATIONAL_CODE = N.NATIONAL_CODE);
--> OR REPLACE�� �Ἥ "������ ����"�̶�� �ɼ��� ��� ������ ���� ���� �� �����Ǿ��ٰ� ����!

SELECT EMP_ID, EMP_NAME, JOB_NAME, BONUS
FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '���þ�';
-- ������ �並 ���� �� ���� �����

-- �並 ������ �������̺� => ���������� �����͸� �����ϰ� ������ ����
-- (�ܼ��� �������� TEXT ������ ����Ǿ� ����)
-- ����) �ش� ������ ������ �ִ� VIEW�鿡 ���� ������ ��ȸ�ϰ��� �Ѵٸ�
--         USER_VIEWS ������ ��ųʸ��� ��ȸ�ϸ� ��

SELECET * FROM USER_VIEWS;

/*
    *�� �÷��� ��Ī �ο�
    �������� SELECT���� �Լ��� ���������� ����Ǿ� ���� ��� �ݵ�� ��Ī ����
*/

-- ����� ���, �̸�, ���޸�, ����, �ٹ������ ��ȸ�� �� �ִ� SELECT���� ��� ����
CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��')
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
              -- �޼�, ����� ���� ���� �׳� �ϸ� �Ǵµ� ���� ��(��)���� ���ϰ� ������ +1 �� �ֱ�!
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE));
-- ORA-00998: must name this expression with a column alias
--=> �Լ���, �������Ŀ� ��Ī�� �������� �ʾ� ���� �߻�

CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��') ����
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) �ٹ����
              -- �޼�, ����� ���� ���� �׳� �ϸ� �Ǵµ� ���� ��(��)���� ���ϰ� ������ +1 �� �ֱ�!
     FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE));
-- �� ���� ����

SELECT * FROM VW_EMP_JOB;

-- �� �ٸ� ������� ��Ī �ο� ����(��, ��� �÷��� ���� ��Ī�� ��� �� ����ؾ� ��)
CREATE OR REPLACE VIEW VW_EMP_JOB (���, �����, ���޸�, ����, �ٹ����)
AS (SELECT EMP_ID
              , EMP_NAME
              , JOB_NAME
              , DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��', '2', '��')
              , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
     FROM EMPLOYEE
     JOIN JOB USING (JOB_CODE));

SELECT * FROM VW_EMP_JOB;

SELECT �����, �ٹ����
FROM VW_EMP_JOB;

SELECT �����, ���޸�
FROM VW_EMP_JOB
WHERE ���� = '��';

-- �ٹ������ 20�� �̻��� ������� ��� �÷�
SELECT *
FROM VW_EMP_JOB
WHERE �ٹ���� >= 20;

-- �並 �����ϰ��� �Ѵٸ�
DROP VIEW VW_EMP_JOB;

SELECT * FROM VW_EMP_JOB;
-- ORA-00942: table or view does not exist
--> �䰡 �� ������ ���� Ȯ�� ����

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    *������ �並 �̿��ؼ� DML (INSERT, UPDATE, DELETE) ��� ����
      ��, �並 ���ؼ� �����ϰ� �Ǹ� ���� �����Ͱ� ��� �ִ� �������� ���̺� (���̽����̺�)���� �����
*/

-- �׽�Ʈ�� �� ����
CREATE OR REPLACE VIEW VW_JOB
AS (SELECT *
      FROM JOB);

SELECT * FROM VW_JOB; -- �� (���纻)
SELECT * FROM JOB; -- ���̽����̺� (����)

-- �信 INSERT
INSERT INTO VW_JOB
VALUES ('J8', '����'); -- ���̽����̺�(JOB)�� �� INSERT

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- �信 UPDATE
-- JOB_CODE�� J8�� JOB_NAME�� �˹ٷ� UPDATE
UPDATE VW_JOB
SET JOB_NAME = '�˹�'
WHERE JOB_CODE = 'J8'; -- ���̽����̺� (JOB)�� �� UPDATE

SELECT * FROM VW_JOB;
SELECT * FROM JOB;

-- �信 DELETE
-- JOB_CODE�� J8�� ���� ����
DELETE
FROM VW_JOB
WHERE JOB_CODE = 'J8'; -- ���̽����̺� (JOB)�� �� DELETE

SELECT * FROM VW_JOB;
SELECT * FROM JOB;
--> DML�� ��� �� �信�� �����ϱ�� ������,
--  ��ǻ� '���̺��� �����Ǳ� ������' �信�� ������ ��ó�� ���̴� ����!

--------------------------------------------------------------------------------------------------------------------------------------------

-- �信 DML�� ���� �� �Ǵ� ���

-- �׽�Ʈ�� �� ����
CREATE OR REPLACE VIEW VW_JOB
AS (SELECT JOB_CODE
      FROM JOB);
      
SELECT * FROM VW_JOB;

-- �信 INSERT => �Ұ�
INSERT INTO VW_JOB (JOB_CODE, JOB_NAME)
VALUES ('J8', '����');
-- ORA-00904: "JOB_NAME": invalid identifier

SELECT * FROM JOB;

-- �信 UPDATE => �Ұ�
UPDATE VW_JOB
SET JOB_NAME = '����'
WHERE JOB_CODE = 'J7';
-- ORA-00904: "JOB_NAME": invalid identifier

-- �信 DELETE => �Ұ�
DELETE
FROM VW_JOB
WHERE JOB_NAME = '���';
-- ORA-00904: "JOB_NAME": invalid identifier

/*
    *������ �並 ������ DML�� �Ұ����� ��찡 �� ����
    
    1) �信 ���ǵǾ� ���� ���� �÷��� �����ϴ� ���
    2) �信 ���ǵǾ� ���� ���� �÷� �� ���̽����̺�� NOT NULL ���������� �ɷ� �ִ� ���
    3) �������� �Ǵ� �Լ��� ���ؼ� ���ǵǾ� �ִ� ���
    4) �������� �κп� �׷��Լ��� GROUP BY���� ���Ե� ���
    5) �������� �κп� DISTINCT ������ ���Ե� ���
    6) JOIN�� �̿��ؼ� ���� ���̺��� ��Ī���Ѽ� ��� ������ ���
    
    => �̷� ������ ��� ��ȸ������ ���� ��
    
*/

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *VIEW �ɼ�
    
    [ ��ǥ���� ]
    CREATE OR REPLCAE FORCE/NOFORCE VIEW ���
    AS (��������)
    WITH CHECK OPTION;
    
    1) OR REPLACE: �ش� ����� �̹� �����ϸ� ���Ž��� ��
                                                  �������� ������ ������ �������� ��
    2) FORCE / NOFORCE
        - FORCE: ���������� ����� ���̺��� �������� �ʴ��� �䰡 ����
        - NOFORCE: ���������� ����� ���̺��� �ݵ�� �����ؾ߸� �䰡 ���� (���� �� �⺻��)
    3) WITH CHECK OPTION: ���������� �������� (WHERE��) ����� ���뿡 �����ϴ� �����θ� DML�� ����
                                       ���ǿ� �������� �ʴ� ���� �����ϴ� ��� ���� �߻�
    4) WITH READ ONLY: �信 ���ؼ� ��ȸ�� ���� (INSERT, UPDATE, DELETE ���� �Ұ�)
*/

-- 2) FORCE/NOFORCE
CREATE OR REPLACE VIEW VW_TEST
AS (SELECT *
      FROM TT);
-- ORA-00942: table or view does not exist
-- => TT��� ���̺��� �������� �ʾƼ� ���� �߻�

CREATE OR REPLACE FORCE VIEW VW_TEST
AS (SELECT *
      FROM TT); 
-- ���: ������ ������ �Բ� �䰡 �����Ǿ����ϴ�.
-- => ������ �ǳ� ��� ��

SELECT * FROM VW_TEST;
-- ORA-04063: view "KH.VW_TEST" has errors
-- ���� ���� ���̺��� ��� ��ȸ �Ұ��� �� ��� ����...! ��¥ ����!
-- ���� ����â�� KH���� - �信�� Ȯ�� ������

CREATE TABLE TT (
    TCODE NUMBER,
    TNAME VARCHAR2(30),
    TCONNECT VARCHAR2(50)
);

SELECT * FROM VW_TEST;
-- TT ���̺��� �ڴʰ� ���� �� �ٽ� �� ��  VW_TEST �並 ��ȸ�ϰ� �Ǹ� ������ �߻����� ����

-- 3) WITH CHECK OPTION
CREATE OR REPLACE VIEW VW_EMP
AS (SELECT *
      FROM EMPLOYEE
      WHERE SALARY >= 3000000)
WITH CHECK OPTION; -- �̶� WHERE�� �������� �ɾ��� �� ���������� ������ ���� ����

SELECT * FROM VW_EMP;
-- VW_EMP��� �信�� ���� �޿��� 300���� �̻��� ������� ������ ������

UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;
-- ORA-01402: view WITH CHECK OPTION where-clause violation
-- => ���������� ����� ���ǿ� �������� �ʱ� ������ ���� ���� �Ұ�

UPDATE VW_EMP
SET SALARY = 4000000
WHERE EMP_ID = 200;
-- �������� ����� ���ǿ� �����ϱ� ������ ���� ����

SELECT * FROM VW_EMP;

ROLLBACK;

-- 4) WITH READ ONLY
CREATE OR REPLACE VIEW VW_EMPBONUS
AS (SELECT EMP_ID, EMP_NAME, BONUS
      FROM EMPLOYEE
      WHERE BONUS IS NOT NULL)
WITH READ ONLY;

SELECT * FROM VW_EMPBONUS;

DELETE
FROM VW_EMPBONUS
WHERE EMP_ID = 204;
-- SQL ����: ORA-42399: cannot perform a DML operation on a read-only view
-- => �б� ���� �ɼ��� �پ��� ������ ������ �Ұ�