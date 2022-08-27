/*
    < SELECT >
    DQL �Ǵ� DML�� �з��� �� �ִ� ��ɾ�ν�
    �����͸� ��ȸ�ϰų� �˻��� �� ����ϴ� ��ɾ�
    
    - Result Set: SELECT ������ ���� ��ȸ�� �����͵��� �����
                     ��, ��ȸ�� ����� ����
                     
    [ ǥ���� ]
    SELECT ��ȸ�ϰ����ϴ��÷���1, �÷���2, �÷���3,...
    FROM ���̺��;
    -> "���" ���̺�κ��� "������" ��ȸ�� ������ ���

*/

-- EMPLOYEE ���̺��� ��ü ������� ���, �̸�, �޿� �÷����� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE;

-- ��ɾ�, Ű����, ���̺��, �÷��� ���� ��ҹ��ڸ� ������ ���� (�ڹ�ó�� ��Ÿǥ��� �Ұ�)
-- �ҹ��ڷ� �ᵵ ���������� �빮�ڷ� ���� ������ ������!

-- EMPLOYEE ���̺��� ��ü ������� ��� �÷��� �� ��ȸ
SELECT EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE
        , SAL_LEVEL, SALARY, BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN
FROM EMPLOYEE;

-- �ش� ���̺��� ��ü �÷��� ��ȸ�ϰ� �ʹٸ� SELECT���� SELECT *�� ǥ����
SELECT *
FROM EMPLOYEE;

-- JOB ���̺��� ��� �÷� ��ȸ
SELECT *
FROM JOB;

-- JOB ���̺��� ���޸� �÷��� ��ȸ
SELECT JOB_NAME
FROM JOB;

----- �ǽ� ���� -----
-- 1. DEPARTMENT ���̺��� ��� �÷� ��ȸ
SELECT *
FROM DEPARTMENT;

-- 2. EMPLOYEE ���̺��� ������, �̸���, ��ȭ��ȣ, �Ի��� �÷��� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;

-- 3. EMPLOYEE ���̺��� �Ի���, ������, �޿� �÷��� ��ȸ
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

------------------------------------------------------------------------------------

/*
    <�÷����� ���� �������>
    ��ȸ�ϰ��� �ϴ� �÷����� �����ϴ� SELECT���� �������(+, -, /, *)�� ����ؼ�
    ���� ����� ��ȸ�� �� ����
*/

-- EMPLOYEE ���̺�κ��� ������, ����, ����(���� * 12) ��ȸ
SELECT EMP_NAME, SALARY, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE ���̺�κ��� ������, ����, ���ʽ�, ���ʽ��� ���Ե� ����(���� + (���ʽ�*����) *12) ��ȸ
SELECT EMP_NAME, SALARY, BONUS, (SALARY + (SALARY * BONUS)) * 12
FROM EMPLOYEE;
--> ��� ���� �ϴ� ������ NULL���� �����Ѵٸ� �� ������� ����� NULL�� ����

-- DATE Ÿ�Գ����� ���� ���� (DATE => ��, ��, ��, ��, ��, ��)
-- EMPLOYEE ���̺�κ��� ������, �Ի���, �ٹ��ϼ�(���ó�¥ - �Ի���) ��ȸ
-- ���ó�¥: SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;
-- ������� �� ������ ���(�������ϰ� �Ҽ����� �پ ��µ�)
-- ���� �������ϰ� ������ ������ DATEŸ�� �ȿ� ���ԵǾ� �ִ� ��, ��, �ʿ� ���� ������� �Բ� �����ϱ� ����

------------------------------------------------------------------------------------
/*
    <�÷��� ��Ī �����ϱ�>
    RESULT SET�� �������� �÷����� ������ ���� ���°ų� �˾ƺ��� ���� ��쿡��
    ��Ī�� ���� �� ���� => �� ����ϰ� �������� ȿ��
    
    [ ǥ���� ]
    �÷��� AS ��Ī, �÷��� AS "��Ī", �÷��� ��Ī, �÷��� "��Ī"
    => AS�� alias�� �����̸�, SELECT���� 4���� �� �ƹ����̳� ��� ����
    
    ��, AS�� ���̵� �� ���̵� ��Ī ���ο� Ư�����ڰ� ���Ⱑ ���Ե� ���
    �ݵ�� �� ��Ī�� ""�� ��� ǥ���ؾ� ��
*/

-- EMPLOYEE ���̺�κ��� �̸�, �޿�(��), ���ʽ�, �� �ҵ��� ��ȸ
SELECT EMP_NAME AS �̸�, SALARY AS "�޿�(��)", BONUS ���ʽ�, SALARY + (BONUS * SALARY) * 12 "�� �ҵ�"
FROM EMPLOYEE;
------------------------------------------------------------------------------------
/*
    <���ͷ� == ������ ��>
    ���Ƿ� ������ ���ͷ��� SELECT���� ����ϸ�
    ���� �� ���̺� �����ϴ� ������ó�� ��ȸ ����
    
    SELECT���� ������ ���ͷ� ���� ��ȸ ����� RESULT SET�� ��� �࿡ �ݺ������� ��µ�
*/

-- EMPLOYEE ���̺�κ��� ���, �����, �޿� ���� ��ȸ�ϱ�
SELECT EMP_ID, EMP_NAME, SALARY, '��' ����
FROM EMPLOYEE;
--> ����Ŭ���� ���ڿ� Ÿ���� ���� ' '(Ȭ����ǥ)�� ���μ� ǥ��

------------------------------------------------------------------------------------
/*
    <DISTINCT>
    ��ȸ�ϰ��� �ϴ� �÷��� �տ� ����ϸ�
    �ش� �÷� ���� �ߺ��� ������ �� �� ������ ����� �ִ� ȿ���� ��
    
    ��, �� SELECT ���� DISTINCT ������ �� ���� ��� ����
    
    [ ǥ���� ]
    SELECT DISTINCT �÷���
*/

-- �μ��ڵ带 ��ȸ
-- �� "ȸ���� ��� �μ��ڵ�"�� ��ȸ�Ͻÿ�
SELECT DEPT_ID
FROM DEPARTMENT;

-- EMPLOYEE ���̺�κ��� �μ��ڵ带 ��ȸ
-- �� ȸ���� "������� �Ҽӵ�" ��� �μ� �ڵ带 ��ȸ�Ͻÿ�
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- EMPLOYEE ���̺�κ��� �����ڵ带 ��ȸ
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- �÷��� ���� ���� ��� DISCTINCT�� �����ϸ� ��� �ɱ�?
SELECT DISTINCT DEPT_CODE, JOB_CODE
FROM EMPLOYEE;
--> DEPT_CODE, JOB_CODE ���� ��Ʈ�� ��� �ߺ� �Ǻ��� �Ͼ
--> DEP_CODE �ߺ� ����, JOB_CODE �ߺ� ���� ����� �ƴ�!!
--> DEPT_CODE�� D6�̸鼭 JOB_CODE�� J3�� 1��� ���� ���� �ִٸ� �ߺ� ������ 1���� �����

------------------------------------------------------------------------------------
/*
    <WHERE��>
    ��ȸ�ϰ��� �ϴ� ���̺� Ư�� ������ �����ؼ�
    �� ���ǿ� �����ϴ� �����͸��� ��ȸ�ϰ��� �� �� ����ϴ� ����
    
    [ ǥ���� ]
    SELECT ��ȸ�ϰ����ϴ��÷�1, �÷���2, �÷���3, ...
    FROM ���̺��
    WHERE ���ǽ�;
    
    �������: FROM�� -> WHERE�� -> SELECT��
    
    - ���ǽĿ� �پ��� �����ڵ� ��� ����
    
    < �� ������ >
    >, <, >=, <=: ��� �� ����
    =: ��ġ �� ���� (�ڹٿ����� ���� �� ������ ==�̾���)
    !=, ^=, <>: ��ġ���� ������ ���ϴ� ����
*/

-- EMPLOYEE ���̺�κ��� "�޿��� 400���� �̻���" ����鸸 ��ȸ (��� �÷��� ���ؼ� ��ȸ)
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-- EMPLOYEE ���̺�κ��� �μ��ڵ尡 D9�� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE ���̺�κ��� �μ��ڵ尡 D9�� �ƴ� ������� �����, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE <> 'D9';
-- WHERE DEPT_CODE != 'D9';
WHERE DEPT_CODE ^= 'D9';

-- EMPLOYEE ���̺�κ��� ���� ���� ���� ������� ���, �̸�, �Ի��� ��ȸ
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE ENT_YN = 'N';

----- �ǽ����� -----
-- 1. EMPLOYEE ���̺�κ��� �޿��� 300���� �̻��� ������� �̸�, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME �����, SALARY "�޿�", HIRE_DATE AS �Ի���
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. EMPLOYEE ���̺�κ��� �����ڵ尡 J2�� ������� �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_NAME AS "�����", SALARY �޿�, BONUS ���ʽ�
FROM EMPLOYEE
WHERE JOB_CODE = 'J2';

-- 3. EMPLOYEE ���̺�κ��� ����(���� * 12)�� 5000���� �̻��� ������� �̸�, �޿�, ����, �Ի��� ��ȸ
SELECT EMP_NAME �����, SALARY �޿�, SALARY * 12 AS ����, HIRE_DATE �Ի���
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000; -- 2
--> SELECT ���� �ο��� ��Ī�� WHERE������ ����� �� ����!
--> FROM�� -> WHERE�� -> SELECE�� ������ ����Ǳ� ����
------------------------------------------------------------------------------------
/*
    <��������>
    ���� ���� ������ ���� �� ���
    AND : ~�̸鼭, �׸��� (�ڹٿ����� && ����)
    OR: ~�̰ų�, �Ǵ� (�ڹٿ����� || ����)
*/

-- EMPLOYEE ���̺�κ��� �μ��ڵ尡 D9�̸鼭 �޿��� 500���� �̻��� ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9') AND (SALARY >= 5000000);

-- EMPLOYEE ���̺�κ��� �μ��ڵ尡 D6�̰ų� �޿��� 300���� �̻��� ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D6') OR (SALARY >= 3000000);

-- EMPLOYEE ���̺�κ��� �޿��� 350���� �̻��̰� 600���� ������ ������� �̸�, ���, �޿�, �����ڵ� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE (SALARY >= 3500000) AND (SALARY <= 6000000);

------------------------------------------------------------------------------------
/*
    <BETWEEN AND>
    �� �̻� �� ������ ������ ���� ������ ������ �� ���
    
    [ ǥ���� ]
    �񱳴���÷��� BETWEEN ���Ѱ� AND ���Ѱ�
*/

SELECT EMP_NAME, DEPT_CODE, SALARY, JOB_CODE
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE ���̺�κ��� �޿��� 350���� �̸��̰� 600���� ������ ������� �̸�, ���, �޿�, �����ڵ� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY, JOB_CODE
FROM EMPLOYEE
-- WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
--> ����Ŭ������ NOT�� �ڹ��� �������������� ! �� ������ �ǹ�

-- EMPLOYEE ���̺�κ��� �Ի����� '90/01/01' ~ '03/01/01' �� ������� ��� �÷��� ��ȸ
SELECT *
FROM EMPLOYEE
-- WHERE '90/01/01' <= HIRE_DATE AND HIRE_DATE <= '03/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '03/01/01';
--> BETWEEN AND �����ڴ� DATE ���İ����� ��� �����ϴ�.

-- EMPLOYEE ���̺�κ��� �Ի����� '90/01/01'~ '03/01/01' �� �ƴ� ������� ��� �÷��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE HIRE_DATE NOT BETWEEN '90/01/01' AND '03/01/01';
--> NOT�� ��ġ�� �񱳴���÷����� �� �Ǵ� �� ���� ������!

------------------------------------------------------------------------------------
/*
    < LIKE 'Ư������' >
    ���ϰ��� �ϴ� �÷����� ���� ������ Ư�� ���Ͽ� ������ ��� ��ȸ
    
    [ ǥ���� ]
    �񱳴���÷��� LIKE 'Ư������'
    
    - Ư�� ���Ͽ� ���ϵ�ī���� '%', '_' �� ������ ������ �� ����
    '%' : 0 ���� �̻�
          �񱳴���÷��� LIKE '����%' => �÷��� �߿� '����'�� ���۵Ǵ� ���� ��ȸ
                    '����'         -> ��ȸ��
                    '����~~~'  -> ��ȸ��
          �񱳴���÷��� LIKE '%����' => �÷��� �߿� '����'�� ������ ���� ��ȸ
                    '����'         -> ��ȸ��
                    '~~~����'  -> ��ȸ��
          �񱳴���÷��� LIKE '%����%' => �÷��� �߿� '����' �� ���ԵǴ� ���� ��ȸ (�˻���� ���� �� ���� ����)
                    '����'         -> ��ȸ��
                    '����~~~'  -> ��ȸ��
                    '~~~����'  -> ��ȸ��
    '_' : 1����
          �񱳴���÷��� LIKE '_����' => �ش� �÷��� �߿� '����' �տ� ������ 1���ڰ� ���� ��� ��ȸ
                    '����'    -> ��ȸ��
                    '_����'  -> ��ȸ��
          �񱳴���÷��� LIKE '����_' => �ش� �÷��� �߿� '����' �ڿ� ������ 1���ڰ� ���� ��� ��ȸ
                    '����'    -> ��ȸ��
                    '����_'  -> ��ȸ��
          �񱳴���÷��� LIKE '__����' => �ش� �÷��� �߿� '����' �տ� ������ 2���ڰ� ���� ��� ��ȸ
                    '����'    -> ��ȸ��
                    '__����'  -> ��ȸ��
                    
*/

-- EMPLOYEE ���̺�κ��� ���� ������ ������� �̸�, �޿�, �Ի��� ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '��%';

-- EMPLOYEE ���̺�κ��� �̸� �߿� ' ��'�� ���Ե� ������� �̸�, �ֹι�ȣ, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%';

-- EMPLOYEE ���̺�κ��� ��ȭ��ȣ �׹�° �ڸ��� 9�� �����ϴ� ������� ���, �����, ��ȭ��ȣ, �̸��� ��ȸ
SELECT EMP_ID, EMP_NAME, PHONE, EMAIL
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';

-- EMPLOYEE ���̺�κ��� �̸� ��� ���ڰ� '��'�� ������� ��� �÷��� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_��_';

-- �� �̿��� ���
SELECT *
FROM EMPLOYEE
-- WHERE NOT EMP_NAME LIKE '_��_';
WHERE EMP_NAME NOT LIKE '_��_';

----- �ǽ� ���� -----

-- 1. �̸��� '��'���� ������ ������� �̸�, �Ի��� ��ȸ
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '__��';

-- 2. ��ȭ��ȣ ó�� 3���ڰ� 010�� �ƴ� ������� �̸�, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

-- 3. DEPARTMENT ���̺�κ��� �ؿܿ����� ���õ� �μ����� ��� �÷��� ��ȸ
SELECT *
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';

------------------------------------------------------------------------------------
/*
    <IS NULL>
    �ش� �÷����� NULL������ �Ǻ��� �ִ� ������
    
    [ ǥ���� ]
    �񱳴���÷��� IS NULL: �÷����� NULL�� ��ġ�� ��츸 ��ȸ
    �񱳴���÷��� IS NOT NULL: �÷����� NULL�� ��ġ�� ��츸 ��ȸ
*/

SELECT *
FROM EMPLOYEE;

-- ���ʽ��� ���� �ʴ� ����� (BONUS �÷����� NULL�� ���)�� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;

-- ���ʽ��� �޴� �����
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;

-- ����� ���� ������� �����, ��� ���, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- ����� ���� �μ� ��ġ�� ���� ���� ������� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- �μ� ��ġ�� ���� �ʾ����� ���ʽ��� �޴� ����� �̸�, ���ʽ�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUSE IS NOT NULL;

------------------------------------------------------------------------------------
/*
    <IN>
    �� ��� �÷� ���� ���� ������ ��ϵ� �߿��� �ϳ��� ��ġ�ϴ� ���� ������ ��ȸ
    
    [ ǥ���� ]
    �񱳴���÷��� IN (��, ��, ��, ...)
*/

-- �μ��ڵ尡 D6�̰ų� �Ǵ� D8�̰ų� �Ǵ� D5�� ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = '5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');
--> ����� ������ ���� �� OR �������� �پ� ���� ��� IN �����ڸ� �̿��Ͽ� �����ϰ� ǥ�� ����

-- �� �̿��� �����
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE NOT IN ('D6', 'D8', 'D5');
--> NOT�� ���� �ʹٸ� ������ �տ� NOT

------------------------------------------------------------------------------------

/*
    <���� ������ ||>
    ���� �÷������� ��ġ �ϳ��� �÷��� ��ó�� ������� �ִ� ������
    �ַ� SELECT���� ���̸� �÷��� ���ͷ� ���� ������� �ִ� �͵� ����
    
    System.out.println("num: " + num);
*/

SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

-- XX�� XXX���� ������ XXXXXX���Դϴ�.
SELECT EMP_ID || '�� ' || EMP_NAME || '���� ������ ' || SALARY || '���Դϴ�.' AS "�޿�����"
FROM EMPLOYEE;

------------------------------------------------------------------------------------
/*
    <������ �켱����>
    0. ()
    1. ���������
    2. ���Ῥ����
    3. �񱳿�����
    4. IS NULL, LIKE, IN
    5. BETWEEN AND
    6. NOT
    7. AND (��������)
    8. OR (��������)
    
    ��) DEPT_CODE�� D9�̰ų� D1�̰� SALARY�� 300���� ������ ����� ��ü �÷�
    SELECT *
    FROM EMPLOYEE
    WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D1') AND SALARY <= 3000000
*/

------------------------------------------------------------------------------------
/*
    <ORDER BY��>
    SELECT�� ���� �������� �����ϴ� ������ �ƴ϶� ���� ���� ���� ���� ������
    �� ��ȸ�� ���빰�� ��� �������� ���� ������ �ִ� ����
    
    [ ǥ���� ]
    SELECT ��ȸ�ϰ����ϴ��÷�1, �÷�2, ...
    FROM ���̺��
    WHERE ���ǽ� (���� ����)
    ORDER BY [���ı������λ�����ϴ��÷���/��Ī/�÷�����] [ASC/DESC](���� ����) [NULLS FIRSR/NULLS LAST](��������);
    
    - ASC: �������� ���� => ���� �ſ������� ū �� ������� ���� (���� �� �⺻��)
    - DESC: �������� ���� => ū �ſ��� ���� �� ������� ����
    
    - NULLS FIRST: �����ϰ��� �ϴ� �÷����� NULL�� ���� ��� �ش� NULL�� ������ ��ġ (DESC�� ��� �⺻��)
    - NULLS LAST: �����ϰ��� �ϴ� �÷����� NULL�� ���� ��� �ش� NULL�� �ڷ� ��ġ (ASC�� ��� �⺻��)

*/

SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME ASC;

SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS; -- ASC / DESC ���� �� �⺻���� ASC (��������)
-- ORDER BY BONUS ASC; -- ASC�� �⺻������ NULLS LAST���� �� �� ����
-- ORDER BY BONUS ASC NULLS FIRST;
-- ORDER BY BONUS DESC; -- DESC�� �⺻������ NULLS FIRST���� �� �� ����
-- ORDER BY BONUS DESC NULLS LAST;
ORDER BY BONUS DESC, SALARY ASC;
--> ù ��°�� ������ ���� ������ �÷����� ��ġ�� ��� �� ��° ���� ������ ������ �ٽ� ����

-- ��ü ������� �̸�, �޿�, ������ ��ȸ�ϵ� ������ "���� �������" ��ȸ�ϱ�
SELECT EMP_NAME, SALARY, SALARY * 12 "����"
FROM EMPLOYEE
-- ORDER BY SALARY * 12 DESC;
-- ORDER BY  "����" DESC; -- ��Ī ��� ����(ORDER BY ���� ������ SELECT ������ ���� �������̱� ����)
ORDER BY 3 DESC; -- ���� ��� ���� (�ε����� �ڹٿ� �޸� 1���� ��!)


