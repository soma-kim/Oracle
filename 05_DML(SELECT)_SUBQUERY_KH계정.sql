/*
    <SUBQUERY ��������>
    �ϳ��� �ֵ� SQL�� (SELECT, INSERT, CREATE, ...) �ȿ��� ���Ե� �� �ϳ��� SELECT��
    ���� SQL���� ���� ���� ������ �ϴ� ������
*/

-- ������ �������� ����1
-- ���ö ����� ���� �μ��� �����
-- 1)  ���� ���ö ����� �μ��ڵ� ��ȸ
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '���ö'; -- ���ö ����� �μ��ڵ�� D9�� ���� �˾Ƴ�

-- 2) �μ��ڵ尡 D9�� ������� ��ȸ
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9'; -- ������, ���߱�, ���ö�� ���� �μ��� ���� �˾Ƴ�

-- ���� �� �ܰ踦 �ϳ��� ���������� ��ġ��
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '���ö');
                                 
-- ������ �������� ���� 2
-- ��ü ����� ��� �޿����� �� ���� �޿��� �ް� �ִ� ������� ���, �̸�, �����ڵ� ��ȸ
-- 1) ���� ��ü ����� ��� �޿� ���ϱ�
SELECT AVG(SALARY)
FROM EMPLOYEE; -- ��� �ݾ� 3047662��

-- 2) �޿��� 3,047,662�� �̻��� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3047662; -- ������, ������, ���ö, �����, ������, �ɺ���, ���ȥ, ������

-- ���� �� �ܰ踦 �ϳ��� ���������� ��ġ��
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= (SELECT AVG(SALARY)
                             FROM EMPLOYEE);
                             
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    *�������� ����
    �з� ����: ���������� ������ ����� (RESULT SET)�� �� �� �� ��¥���Ŀ� ���� �з���
    
    - ���� �� (���� ��) ��������: ���������� ������ ������� ������ 1���� �� (1�� 1���� ��)
    - ���� �� (���� ��) ��������: ���������� ������ ������� ���� �� �� ���� �� (N�� 1���� ��) - �Ӽ� 1���� ���� ��
    - ���� �� ���� �� ��������: ���������� ������ ������� �� �� ���� ���� �� (1�� N���� ��)
    - ���� �� ���� �� ��������: ���������� ������ ������� ���� �� ���� ���� �� (N�� N���� ��)
    => ���������� ������ ����� �� �� �� ���̳Ŀ� ���� ��� ������ �����ڵ� �� �޶���
    
    ����) ���������� FROM���� �� ���: �ζ��� ��
    
 */   
--------------------------------------------------------------------------------------------------------------------------------------------    
/*
    1. ���� �� (���� ��) �������� (SINGLE ROW SUBQUERY)
    ���������� ��ȸ ������� ������ 1���� ��
    
    �Ϲ� ������ ��� ����(=, !=, <=, >, <, >=, ...)
*/

-- �� ������ ��� �޿����� �� ���� �޴� ������� �����, �����ڵ�, �޿� ��ȸ
-- 1) ���� ��� �޿� ���ϱ�
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- 2) 3,047,662�� �̸����� �޴� ������� �����, �����ڵ�, �޿� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < 3047662

-- ���� �� �ܰ踦 �ϳ��� ���������� ��ġ��
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) --> ����� 1�� 1��, ������ 1���� ��
                           FROM EMPLOYEE);

-- ���� �޿��� �޴� ����� ���, �����, �����ڵ�, �޿�, �Ի��� ��ȸ
-- 1) ���� ���� �޿� ��ȸ
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- 2) �޿��� 1,380,000���� ��� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = 1380000;

-- ���� �� �������� �ϳ��� ���������� ��ġ��
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) --> ����� 1�� 1��, ������ 1���� ��
                           FROM EMPLOYEE);

-- ���ö ����� �޿����� �� ���� �޴� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DPET_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '���ö');
                             
-- ���ö ����� �޿����� �� ���� �޴� ������� ���, �̸�, �μ���, �޿� ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = DEPT_ID -- ������� ���� ����
    AND SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '���ö') -- �߰� ����
--> ���ε� �Բ� ����

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY >= (SELECT SALARY
                             FROM EMPLOYEE
                             WHERE EMP_NAME = '���ö');
                             
-- ������ ����� ���� �μ��� ������� ���, �����, �޴�����ȣ, ���޸�
-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- ������� ���� ����
    AND DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '������')
    AND EMP_NAME != '������'; -- �߰����� ����
    
--> ANSI ����
SELECT EMP_ID, EMP_NAME, PHONE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '������')
    AND EMP_NAME != '������';

-- �μ��� �޿� ���� ���� ū �μ� �ϳ����� ��ȸ
-- �μ��ڵ�, �μ���, �޿��� ��ȸ
-- 1) �μ��� �޿� �� ���ϱ�
SELECT SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) �μ��� �޿� �յ� �� ���� ū ���� ���ϱ�
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 3) �μ��ڵ�, �μ���, �޿� ��
-->> ����Ŭ ����
SELECT DEPT_CODE, DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID -- ������� ���� ����
GROUP BY DEPT_CODE, DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                     FROM EMPLOYEE
                                     GROUP BY DEPT_CODE);
                                     
-->> ANSI ����
SELECT DEPT_CODE, DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                                     FROM EMPLOYEE
                                     GROUP BY DEPT_CODE);
