/*
    <DDL: DATA DEFINITION LANGUAGE>
    ������ ���� ���
    
    ��ü���� ������ ����(CREATE), ����(ALTER), ����(DROP)�ϴ� ����
    
    1. ALTER ����
    ��ü ������ �����ϴ� ����
    
    <���̺� ����>
    ALTER TABLE ���̺�� �����ҳ���;
    
    - �����ҳ���
    1) �÷� �߰� / ���� / ����
    2) �������� �߰� / ���� => ������ �Ұ� (�����ϰ��� �Ѵٸ� ���� �� ������ �߰�)
    3) ���̺�� / �÷��� / �������Ǹ� ����
*/

-- 1) �÷� �߰� / ���� / ����
-- 1_1) �÷� �߰�(ADD): ADD �߰����÷��� ������Ÿ�� DEFAULT �⺻��
--                              => DEFAULT �⺻���� ���� ����

SELECT * FROM DEPT_COPY;

-- CNAME �÷� �߰�
ALTER TABLE DEPT_COPY ADD CNAME VARCHAR2(20);
-- ���ο� �÷��� ��������� �⺻������ NULL ������ ä����

--LNAME �÷� �߰� (DEFAULT �����ؼ�)
ALTER TABLE DEPT_COPY ADD LNAME VARCHAR2(20) DEFAULT '�ѱ�';
-- ���ο� �÷��� ��������� NULL�� �ƴ� DEFAULT ������ ä����

SELECT * FROM DEPT_COPY;

-- 1_2) �÷� ���� (MODIFY)
-- ������Ÿ�� ����:  MODIFY �������÷��� �ٲٰ����ϴµ�����Ÿ��
-- DEFAULT�� ����:  MODIFY �������÷��� DEFAULT �ٲٰ����ϴ±⺻��

-- DEPT_ID �÷��� ������Ÿ���� CHAR(3)���� ����
ALTER TABLE DEPT_COPY MODIFY DEPT_ID CHAR(3);

-- ���ǻ���
-- ���� �����ϰ��� �ϴ� �÷��� �̹� ��� �ִ� ���� ������ �ٸ� Ÿ�����δ� ���� �Ұ�
-- ��) ���� -> ���� (X) / ���ڿ� ������ ��� (X) / ���ڿ� ������ Ȯ�� (O)

ALTER TABLE DEPT_COPY MODIFY DEPT_ID NUMBER;
-- ORA-01439: column to be modified must be empty to change datatype
-- �̹� ������ ���� ��� �����Ƿ� ���� �ڷ������� �ٲ� �� ����

ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(10);
-- ORA-01441: cannot decrease column length because some value is too big
-- �̹� 10BYTE �̻��� ���ڰ��� ��� �����Ƿ� ���� ���� 10BYTE�� ��ҽ�ų �� ����

-- DEPT_TITLE �÷��� ������Ÿ���� VARCHAR2(40)����
--LOCATION_ID �÷��� ������Ÿ���� VARCHAR2(2)��
-- LNAME �÷��� �⺻���� '�̱�'����
ALTER TABLE DEPT_COPY MODIFY DEPT_TITLE VARCHAR2(40);
ALTER TABLE DEPT_COPY MODIFY LOCATION_ID VARCHAR2(40);
--> �̷��� ���� ����ص� ������ ������

ALTER TABLE DEPT_COPY
MODIFY DEPT_TITLE VARCHAR2(40)
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY LNAME DEFAULT '�̱�';

-- �׽�Ʈ�� ���̺� ����
CREATE TABLE DEPT_COPY2
AS (SELECT *
     FROM DEPT_COPY);
     
SELECT * FROM DEPT_COPY2;

-- 1_3) �÷� ����(DROP COLUMN): DROP COLUMN �����ϰ��� �ϴ� �÷���
SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2�κ��� DEPT_ID �÷� �����
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_ID;

ROLLBACK;
-- DDL ������ ���� �Ұ���: DDL ���� ������ ���ʿ� COMMIT�� ���Ե� ����

SELECT * FROM DEPT_COPY2; -- ���� �� ��

-- ��� �÷��� ���� ����
ALTER TABLE DEPT_COPY2 DROP COLUMN DEPT_TITLE;
ALTER TABLE DEPT_COPY2 DROP COLUMN LOCATION_ID;
ALTER TABLE DEPT_COPY2 DROP COLUMN CNAME;
ALTER TABLE DEPT_COPY2 DROP COLUMN LNAME;
-- ORA-12983: cannot drop all columns in a table
--> ���̺� �ּ� 1���� �÷��� �����ؾ� �� (������ �÷� ������ ����)

-- 2) �������� �߰�/����

/*
    2_1) �������� �߰�
    
    - PRIMARY KEY: ADD CONSTRAINT �������Ǹ� PRIMARY KEY (�÷���);
    - FOREIGN KEY: ADD FOREIGN KEY (�÷���) REFERENCES ���������̺�� (�������÷���);
                          => �������÷����� ���� ����
    - UNIQUE: ADD UNIQUE (�÷���);
    - CHECK: ADD CHECK(�÷�����������);
    - NOT NULL: MODIFY �÷��� NOT NULL;
    
    ������ �������Ǹ���� �ο��ϰ��� �Ѵٸ� CONSTRAINT �������Ǹ� �������� �� ����
    "CONSTRAINT �������Ǹ�" �κ��� ���� ���� (���� �� �������Ǹ��� SYS_C~~~�� ����)
    * ���ǻ���: ���� ���� ���� ������ ������ �������Ǹ��� �ο��ؾ� ��
*/

-- DEPT_COPY ���̺�
-- DEPT_ID �÷��� PRIMARY �������� �߰�
-- DEPT_TITLE �÷��� UNIQUE �������� �߰�
-- LNAME �÷��� NOT NULL �������� �߰�
ALTER TABLE DEPT_COPY
ADD CONSTRAINT DCOPY_PK PRIMARY KEY (DEPT_ID)
ADD CONSTRAINT DCOPY_UQ UNIQUE (DEPT_TITLE)
MODIFY LNAME CONSTRAINT DCOPY_NN NOT NULL;

-- ���ǻ���: �̹� ��� �ִ� ���� ���缭 ���������� �ο��ؾ� �� 

/*
    2_2) �������� ����
    - PRIMARY KEY, FOREIGN KEY, UNIQUE, CHECK: DROP CONSTRAINT �������Ǹ�
    - NOT NULL: MODIFY �÷��� NULL
*/

-- DCOPY_PK �������� �����
ALTER TABLE DEPT_COPY DROP CONSTRAINT DCOPY_PK;

-- DCOPY_UQ, LNAME �÷��� NOT NULL �������� �����
ALTER TABLE DEPT_COPY
DROP CONSTRAINT DCOPY_UQ
MODIFY LNAME NULL;

-- 3) �÷��� / �������Ǹ� / ���̺�� ���� (RENAME)

-- 3_1) �÷��� ����: RENAME COLUMN �����÷��� TO �ٲ��÷���
ALTER TABLE DEPT_COPY RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

-- 3_2) �������Ǹ� ����: RENAME CONSTRAINT �����������Ǹ� TO �ٲ��������Ǹ�
ALTER TABLE DEPT_COPY RENAME CONSTRAINT SYS_C007131 TO DCOPY_LID_NN;

-- 3_3) ���̺�� ����: RENAME TO �ٲ����̺��
--                            => �������̺���� �̹� ALTER TABLE ���̺���� �̹� ����Ǿ��� ������ ������ ���� ���� ��
ALTER TABLE DEPT_COPY RENAME TO DEPT_TEST;

SELECT * FROM DEPT_COPY;
-- ORA-00942: table or view does not exist
-- => ���� �� �̻� DEPT_COPY��� �̸��� ���̺��� �������� ����

SELECT * FROM DEPT_TEST;

-->> ���ʿ� CREATE TABLE �������� �����ؼ� ���̺��� ����� ������
--     �Ĳ��� ���踦 �ؼ� ���̺��� �� ���������, �����Ͱ� �� �� ���Ŀ� �ǵ����̸� ALTER ������ ���� ���� �����ؾ� ��
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    2. DROP
    ��ü�� �����ϴ� ����
    
    ���� ���� ��: DROP USER ������;
    ���̺� ���� ��: DROP TABLE ���̺��;
*/

-- DEPT_TEST ���̺� ����
DROP TABLE DEPT_TEST;

-- DEPARTMENT ���̺� ���� �õ�
DROP TABLE DEPARTMENT;
-- ORA-02449: unique/primary keys in table referenced by foreign keys
-- => ���̺� ���� ��, ��򰡿��� �����ǰ� �ִ� �θ� ���̺���� �������� ����

-- ���࿡ �θ� ���̺��� �����ϰ� �ʹٸ�?
-- 1) �ڽ� ���̺��� ���� ���� �� �θ� ���̺��� �����ϴ� ���
DROP TABLE �ڽ����̺��; -- ���� ���� ��
DROP TABLE �θ����̺��; -- �ۼ��ϸ� ��!

-- 2) �θ����̺� �����ϴµ� �¹��� �ִ� �ܷ�Ű ���������� �Բ� �����ϴ� ���
DROP TABLE �θ����̺�� CASCADE CONSTRAINT;

--> DROP ������ ���������� � �ÿ� ���δٱ⺸��
--   CREATE ���� ���� �ߺ��� �̸��� ��ü�� �̹� ���� �Ϳ� ����ؼ� �����ϴ� �� �ַ�  ����
