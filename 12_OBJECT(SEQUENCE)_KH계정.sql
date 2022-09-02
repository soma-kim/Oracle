/*
    <������ SEQUENCE>
    �ڵ����� ��ȣ�� �߻����� �ִ� ������ �ϴ� ��ü
    �������� �ڵ����� ���������� ������ ��
    
    ��) ȸ����ȣ, ���, �Խñ� ��ȣ ��� "ä��"�� �� �ַ� ���� ����
    
    1. ������ ��ü ���� ����
    
    [ ǥ���� ]
    CREATE SEQUENCE ��������
    START WITH ���ۼ���                  => ó�� �߻���ų ���۰� ���� (���� ����)
    INCREMENT BY ������                 => �ѹ��� �� �� ������ų ���� ���� (���� ����)
    MAXVALUE �ִ밪                       => �ִ밪 ���� (���� ����)
    MINVALUE �ּҰ�                       => �ּҰ� ���� (���� ����)
    CYCLE/NOCYCLE                         => ���� ��ȯ ���θ� ���� (���� ����)
    CACHE ����Ʈũ��/NOCACHE       => ĳ�� �޸� ��� ���θ� ���� (���� ����)
                                                        CACHE_SIZE �⺻���� 20BYTE
    
    *ĳ�� �޸�: �̸� �߻��� ������ �����ؼ� ������ �δ� ����
                       �Ź� ȣ���� ������ ������ ��ȣ�� �����ϴ� �ͺ���
                       ĳ�� �޸� ������ �̸� ������ ������ ������ ���� �Ǹ� �ξ� �ӵ��� ����
                       ��, ������ ����� ���� ������ �� ������ �����Ǿ� �ִ� ������ ���ư��� ����
*/

/*
    *���λ�
    - ���̺��: TB_
    - ���: VW_
    - ��������: SEQ_
*/

CREATE SEQUENCE SEQ_TEST;

-- ���� �� ������ ������ �����ϰ� �ִ� �������� ���� ���� ��ȸ�� ������ ��ųʸ�
-- USER_SEQUENCES
SELECT * FROM USER_SEQUENCES;

-- ������ �ɼ��� �ο��ؼ� ����� ä���ϴ� �뵵�� ������ �����ϱ�
CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;
--> �� �������� 300, 305, 310�� ä�� ������ ��

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    2. ������ ��� ����
    
    ��������.CURRVAL: ���� �������� �� (���������� ���������� �߻��� NEXTVAL ��)
                                => ���������� ���������� �߻��� NEXTVAL ���� ��Ƶδ� ������ ���� ���� ����!
    ��������.NEXTVAL: �������� ���� ������Ű�� �� ������ ������ ��
                               ������ ������ ������ INCREMENT BY ����ŭ ������ ��
                               (��������.CURRVAL + INCREMENT BY ��)
                               
    => ��, ������ ���� �� ù NEXTVAL�� START WITH�� ������ ���۰����� �߻�
*/

-- ������ ���� SEQ_EMPNO�� ������ �׽�Ʈ
SELECT SEQ_EMPNO.CURRVAL
FROM DUAL;
-- ORA-08002: sequence SEQ_EMPNO.CURRVAL is not yet defined in this session
-- => NEXTVAL�� �� ���̶� �������� �ʴ� �̻� CURRVAL�� �� �� ����
--      CURRVAL�� �������� ���������� ������ NEXTVAL�� ���� �����ؼ� ���� �ִ� �ӽð��̱� ����

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 300

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 300

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- �ٽ� ��ȸ�ص� ������ 300

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 305

SELECT * FROM USER_SEQUENCES;
-- ������ ��ųʸ� ��ȸ �� SEQ_EMPNO �������� LAST_NUMBER ���� 310���� �����Ǿ� ����
-- LAST_NUMBER: ���� ��Ȳ���� NEXTVAL�� �ѹ� ������ ��� �߻��� "���� ��"

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 310
-- ���������� ���������� �̷���� NEXTVAL
-- LAST_NUMBER: 315

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 310? 315?
-- ORA-08004: sequence SEQ_EMPNO.NEXTVAL exceeds MAXVALUE and cannot be instantiated
-- ������ MAXVALUE �� (310)�� �ʰ��߱� ������ ���� �߻�
-- ������ NEXTVAL

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 310
-- ���������� ���������� �̷���� NEXTVAL�� 310�� ��µ�

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. ������ ����
    
    [ ǥ���� ] 
    ALTER SEQUENCE ��������
    INCREMENT BY ������                    => �� ���� � ������ų ���� ���� (���� ����)
    MAXVALUE �ִ밪                         => �ִ밪 ���� (���� ����)
    MINVALUE �ּҰ�                          => �ּҰ� ���� (���� ����)
    CYCLE/NOCYCLE                            => �� ��ȯ ���� ���� (���� ����)
    CACHE ����Ʈũ��/NOCACHE          => ĳ�� �޸� ��� ���� ���� (���� ����)
    
    *START WITH�� ���� �Ұ� => �� �ٲٰ� �ʹٸ� ������ ���� �� �ٽ� ������ؾ� ��!!
*/

ALTER SEQUENCE SEQ_EMPNO
MAXVALUE 400
INCREMENT BY 10;

SELECT * FROM USER_SEQUENCES;
-- ������ ���� �� LAST_NUMBER = 315 => INCREMENT BY = 5, CURRVAL = 310 (���簪)
-- ������ ���� �� LAST_NUMBER = 320
-- => �ƹ��� �������� �ٲ���� CURRVAL ���� �ٲ��� ����

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL; -- 310

SELECT SEQ_EMPNO.NEXTVAL
FROM DUAL; -- 320

SELECT * FROM USER_SEQUENCES;
-- LAST_NUMBER = 330

-- ����) SEQUENCE�� �����ϰ� �ʹٸ�
DROP SEQUENCE SEQ_EMPNO;

SELECT SEQ_EMPNO.CURRVAL
FROM DUAL;
-- ORA-02289: sequence does not exist
-- => �������� ���µ� ��ȸ�Ϸ��� �ؼ� �߻��ϴ� ����
--------------------------------------------------------------------------------------------------------------------------------------------

-- ������ ��� ����
-- �Ź� ���ο� ����� �߻��Ǵ� �������� ����
CREATE SEQUENCE SEQ_EID
START WITH 300;

-- �Ź� ����� �߰��� ������ ������ INSERT��
INSERT INTO EMPLOYEE (EMP_ID
                                  , EMP_NAME
                                  , EMP_NO
                                  , JOB_CODE
                                  , SAL_LEVEL
                                  , HIRE_DATE)
VALUES (SEQ_EID.NEXTVAL -- 300
           , 'ȫ�浿'
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
           , '�迵��'
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
           , '�ڸ���'
           , '111111-2111111'
           , 'J5'
           , 'S2'
           , SYSDATE);
           
SELECT * FROM EMPLOYEE;

-- ���� �������� PRIMARY KEY�� �ش��ϴ� �ĺ� ��ȣ�� ä���� �� �ַ� �� (INSERT �������� NEXTVAL �������� ��)

-- ����� ���� �߰� "��û" �� ������ SQL��
-- EMP_ID:              ����ڷκ��� ���������� �Է� X, ������
-- EMP_NAME:        ����ڷκ��� ���������� �Է� O
-- EMP_NO:            ����ڷκ��� ���������� �Է� O
-- EMAIL:               ����ڷκ��� ���������� �Է� O (�ʼ� X)
-- PHONE:              ����ڷκ��� ���������� �Է� O (�ʼ� X)
-- DEPT_CODE:       ����ڷκ��� ���������� �Է� X (�ʼ� X)
-- JOB_CODE:         ����ڷκ��� ���������� �Է� O
-- SAL_LEVEL:         ����ڷκ��� ���������� �Է� O
-- SALARY:             ����ڷκ��� ���������� �Է� X (�ʼ� X)
-- BONUS:             ����ڷκ��� ���������� �Է� X (�ʼ� X)
-- MANAGER_ID:    ����ڷκ��� ���������� �Է� X (�ʼ� X)
-- HIRE_DATE:        SYSDATE ����
-- ENT_DATE:         NULL���� ����        
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