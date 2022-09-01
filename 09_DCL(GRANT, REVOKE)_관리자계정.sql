/*
    <DCL: DATA CONTROL LANGUAGE>
    ������ ���� ���
    
    �������� �ý��� ���� �Ǵ� ��ü ���� ������ �ο�(GRANT) �ϰų� ȸ��(REVOKE) �ϴ� ���
    
    *���� �ο�(GRANT)
    - �ý��� ����: Ư�� DB�� �����ϴ� ����, ��ü���� ������ �� �ִ� ����
    - ��ü ���� ����: Ư�� ��ü�鿡 �����ؼ� ������ �� �ִ� ����
    
    1. �ý��� ����
    Ư�� DB�� �����ϴ� ����, ��ü���� ������ �� �ִ� ����
    
    [ ǥ���� ]
    GRANT ����1, ����2, ..., TO ������;
    
    - �ý��� ������ ����
    CREATE SESSION: ������ ������ �� �ִ� ����
    CREATE TABLE: ���̺��� ������ �� �ִ� ����
    CREATE VIEW: �並 ������ �� �ִ� ����
    CREATE SEQUENCE: �������� ������ �� �ִ� ����
    CREATE USER: ������ ������ �� �ִ� ����
    ...
*/

-- 1. SAMPLE ���� ����
CREATE USER SAMPLE IDENTIFIED BY SAMPLE;

-- 2. SAMPLE ������ �����ϱ� ���� CREATE SESSION ���Ѹ� �ο�
GRANT CREATE SESSION TO SAMPLE;

-- 3_1. SAMPLE ������ ���̺��� ������ �� �ִ� CREATE TABLE ���� �ο�
GRANT CREATE TABLE TO SAMPLE;

-- 3_2. SAMPLE ������ ���̺����̽��� �Ҵ��� �ֱ� (ALTER ��������)
ALTER USER SAMPLE QUOTA 2M ON SYSTEM;
-- QUOTA: ��, �Ҵ��ϴ�
-- 2M: 2 MEGA BATE
-- SYSTEM: ����Ŭ���� �����ϴ� �⺻ ���̺����̽���

-- 4. SAMPLE ������ �並 ������ �� �ִ� CREATE VIEW ���� �ο�
GRANT CREATE VIEW TO SAMPLE;

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *��ü ���� ���� (��ü ����)
    Ư�� ��ü���� ����(SELECT, INSERT, UPDATE, DALETE) �� �� �ִ� ����
    
    [ ǥ���� ]
    GRANT �������� ON Ư����ü TO ������;
    
              ���� ����                      |                         Ư�� ��ü
 ------------------------------------------------------------------------------------------------
               SELECT                        |    TABLE, VIEW, SEQUENCE
               INSERT                        |    TABLE, VIEW
              UPDATE                        |    TABLE, VIEW(�� �Ǵ°�찡 �� ������ �Ǳ�� ��)
               DELETE                        |    TABLE, VIEW(�� �Ǵ°�찡 �� ������ �Ǳ�� ��)
*/

-- 5. SAMPLE ������ KH.EMPLOYEE ���̺��� ��ȸ�� �� �ִ� ���� �ο�
GRANT SELECT ON KH.EMPLOYEE TO SAMPLE;

-- 6. SAMPLE ������ KH.DEPARTMENT ���̺� ���� ������ �� �ִ� ���� �ο�
GRANT INSERT ON KH.DEPARTMENT TO SAMPLE;

--------------------------------------------------------------------------------------------------------------------------------------------
-- �ּ����� ������ �ο��ϰ��� �� �� CONNECT, RESOURCE�� �ο�
-- GRANT CONNECT, RESOURCE TO ������;

/*
    <�� ROLE>
    Ư�� ���ѵ��� �ϳ��� �������� ���� ���� ��
    
    CONNECT: CREATE SESSION (�����ͺ��̽��� ������ �� �ִ� ����)
    RESOURCE: CREATE TABLE, CREATE SEQUENCE, ... (Ư�� ��ü���� ���� �� ������ �� �ִ� ����)
*/

-- ������ ��ųʸ��� �̿��Ͽ�
-- CONNECT, RESOURCE��� �ѿ� � ���ѵ��� ���� �ִ��� Ȯ���� ����
SELECT *
FROM ROLE_SYS_PRIVS
-- WHERE ROLE = 'CONNECT' OR ROLE = 'RESOURCE';
WHERE ROLE IN ('CONNECT', 'RESOURCE');

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    *���� ȸ�� (REVOKE)
    ������ ȸ���� �� ����ϴ� ��ɾ�
    
    [ ǥ���� ]
    REVOKE ����1, ����2, ����3, ... FROM ������;
*/

-- 7. SAMPLE �������� ���̺��� ������ �� ������ ���� ȸ��
REVOKE CREATE TABLE FROM SAMPLE;

----- �ǽ� ���� -----
-- ����� ����: MYTEST / MYTEST
CREATE USER MYTEST IDENTIFIED BY MYTEST;

-- ����ڿ��� �ο��� ����: CONNECT, RESOURCE, CREATE VIEW
GRANT CONNECT, RESOURCE, CREATE VIEW TO MYTEST;

-- �� �� ����(����, ���̺� ����, �� ����)

-- ����ڷκ��� ������ ��� ȸ��
REVOKE CONNECT, RESOURCE, CREATE VIEW FROM MYTEST;

-- ����� ���� ����
DROP USER MYTEST CASCADE;
-- ������ �ڷᰡ �ֱ� ������ �׳� ������ �� ��! CASCADE�� ���ӵ� ��� ���� �����ϰڴٰ� �� ��� ��!