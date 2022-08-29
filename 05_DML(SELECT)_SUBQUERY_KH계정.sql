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
    1. ���� �� (���� ��) �������� (SINGLE ROW SUBQUERY) -- ���� ���̶�� ���� ���� ����
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
                                     
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    2. ���� �� (���� ��) �������� (MULTI LOW SUBQUERY)
    ���������� ��ȸ ��� ���� ���� ���� ��
    
    - �÷��� IN (10, 20, 30, 40) ��������: ���� ���� ����� �߿��� �� ���� ��ġ�ϴ� ���� �ִٸ�
                NOT IN (10, 20, 30) ��������: ���� ���� ����� �߿��� �ϳ��� ��ġ�ϴ� ���� ���ٸ�
                
    - �÷��� > ANY (10, 20, 30) ��������: ���� ���� ����� �߿��� "�ϳ���" Ŭ ���
                                                        ��, ���� ���� ����� �߿��� ���� ���������� Ŭ ���
      �÷��� < ANY (10, 20, 30) ��������: ���� ���� ����� �߿��� "�ϳ���" ���� ���
                                                        ��, ���� ���� ����� �߿��� ���� ū������ ���� ���
    => ANY �迭�� ��ȣ(=)�� ���� ���굵 ������!
    
    - �÷��� > ALL ��������: ���� ���� ������� "���" ������ Ŭ ���
                                        ��, ���� ���� ����� �߿��� ���� ū ������ Ŭ ���
    - �÷��� > ALL ��������: ���� ���� ������� "���" ������ Ŭ ���
                                        ��, ���� ���� ����� �߿��� ���� ���� ������ ���� ���
*/

-- �� �μ��� �ְ� �޿��� �޴� ����� �̸�, �����ڵ�, �޿� ��ȸ
-- 1)  �� �μ��� �ְ� �޿�
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE; --2890000, 3660000, 8000000, 3760000, 3900000, 2490000, 2550000
--> 7�� 1���� �� 7���� ���� ��ȸ��

-- 2) ���� �޿��� �޴� ����� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (2890000, 3660000, 8000000, 3760000, 3900000, 2490000, 2550000);
/*
WHERE SALARY  = 2890000
      OR SALARY  = 3660000
      OR SALARY  = 8000000
      OR ...
      */
      
-- ���� �� ������ ��ġ��
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN (SELECT MAX(SALARY)
                             FROM EMPLOYEE
                             GROUP BY DEPT_CODE);
                             
-- ������ �Ǵ� ����� ����� ���� �μ��� ������� ��ȸ(�����, �μ��ڵ�, �޿�)
-- 1) ������ �Ǵ� ����� ����� �μ��ڵ� ���ϱ�
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('������', '�����'); -- 'D9', 'D6'
-- WHERE EMP_NAME = '������' OR EMP_NAME = '�����';
--> 2�� 1��, �� 2���� ����� ��ȸ

-- 2) ���� �μ��ڵ��� ������� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D9', 'D6');
-- WHERE DEPT_CODE = 'D9' OR DEPT_CODE = 'D6'

-- ���� �� ������ ��ġ��
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IN (SELECT DEPT_CODE
                                  FROM EMPLOYEE
                                  WHERE EMP_NAME IN ('������', '�����')); 
                                  
-- ��� < �븮 < ���� < ���� < ����
-- �븮 ���޿��� �ұ��ϰ� ���� ������ �޿����� �� ���� �޴� ����� ��ȸ (���, �̸�, ���޸�, �޿�)
-- (����Ŭ ���� ���)
-- 1) ���� ������ �޿��� ��ȸ
SELECT SALARY
FROM EMPLOYEE E , JOB J
WHERE E.JOB_CODE = J.JOB_CODE
    AND JOB_NAME = '����'; -- 2200000, 2500000, 3760000
    
-- 2) ���� �޿����� ���� �޿��� �޴� ������ ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- ������� ���� ����
    AND SALARY > ANY (2200000, 2500000, 3760000); -- �߰����� ����

-- 3) �� ������ ��ġ�� + �븮 ���޸� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- ������� ���� ����
    AND SALARY > ANY(SELECT SALARY
                                  FROM EMPLOYEE E , JOB J
                                  WHERE E.JOB_CODE = J.JOB_CODE
                                  AND JOB_NAME = '����')
    AND JOB_NAME = '�븮';
    
-- ���� �����ӿ��� �ұ��ϰ� ��� ���� ������ �޿����ٵ� �� ���� �޴� �������� ��ȸ(���, �̸�, ���޸�, �޿�)
-- (ANSI ���� ���)
-- 1) ���� ���޵��� �޿�
SELECT SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '����'; -- 2800000, 1550000, 2490000, 2480000
--> 4�� 1��, �� 4���� �� ��ȸ

-- 2) ��� ���� �޿����� �� ���� �޿��� �޴� ������ ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY > ALL (2800000, 1550000, 2490000, 2480000);

-- 3) ���� �� ������ ��ġ�� + ���� ���޵鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE SALARY > ALL (SELECT SALARY
                                  FROM EMPLOYEE
                                  JOIN JOB USING (JOB_CODE)
                                  WHERE JOB_NAME = '����')
    AND JOB_NAME = '����';
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. (���� ��) ���� �� �������� (MULTI COLUMN SUBQUERY)
     ��ȸ ������� �� �������� ������ �÷� ���� ���� ���� ��

    (���� ��) = (���� ��) <- �̷� ������ �񱳰� �Ͼ ����
*/ 

-- ������ ����� ���� �μ��ڵ�, ���� ���� �ڵ忡 �ش��ϴ� ����� ��ȸ

-- 1) ������ ����� �μ��ڵ�� �����ڵ� ���� ��ȸ
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '������'; -- 'D5' / 'J5'

-- 2) �μ��ڵ尡 D5�̸鼭 �����ڵ尡 J5�� ����� ��ȸ
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
    AND JOB_CODE = 'J5';
    
--> ���� �������� �������� �������� �ٲ۴ٸ�? (���� �� ���� �� ��������)
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '������')
    AND JOB_CODE =  (SELECT JOB_CODE
                                 FROM EMPLOYEE
                                 WHERE EMP_NAME = '������');
                                 
-->> ���� �� ���� �� �������� �������� ����
SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
FROM EMPLOYEE
-- WHERE(DEPT_CODE, JOB_CODE) = ('D5', 'J5'); -- �ش� ǥ������ ���ͷ��� �������� �� ������ ���� �߻�
WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                                   FROM EMPLOYEE
                                                   WHERE EMP_NAME = '������'); -- ������� 1�� 2��, �� 2���� ��
                                                   
-- �ڳ��� ����� ���� �����ڵ�, ���� ��� ����� ���� ������� ���, �̸�, �����ڵ�, ��������ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE (JOB_CODE, MANAGER_ID) = (SELECT JOB_CODE, MANAGER_ID
                                                     FROM EMPLOYEE
                                                     WHERE EMP_NAME = '�ڳ���'); -- ������� 1�� 2��, �� 2���� ��
                                                     
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    4. ���� �� ���� �� ��������
    �������� ��ȸ ������� ���� �� ���� ���� ���
*/

-- �� ���޺� �ּ� �޿��� �޴� ������� ���, �̸�, �����ڵ�, �޿� ��ȸ
-->> �� ���޺� �ּ� �޿� ��ȸ
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE; -- (J2, 3700000), (J7, 1380000), (J3, 3400000), (J6, 2000000), (J5, 2200000), (J1, 8000000), (J4, 1550000)
--> 7�� 2��, �� 14���� �� => �ະ�� �׷� ������ �� �� 7��Ʈ�� ����

-->> ���� ��ϵ� �߿� ��ġ�ϴ� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (('J2', 3700000)
                                            , ('J7', 1380000)
                                            , ('J3', 3400000)
                                            , ('J6', 2000000)
                                            , ('J5', 2200000)
                                            , ('J1', 8000000)
                                            , ('J4', 1550000)); -- IN �������� ��� ���� �� ��� �񱳰� ����
/* ���ͷ��� ���� ���� ���� ����
WHERE (JOB_CODE, SALARY) = ('J2', 3700000)
      OR (JOB_CODE, SALARY) = ('J7', 1380000)
      OR (JOB_CODE, SALARY) = ('J3', 3400000)
      OR ...
*/ -- ������ ���� �ʴ� ǥ����

--> ���� ������� �ϳ��� ���������� ��ġ��
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                                              FROM EMPLOYEE
                                              GROUP BY JOB_CODE);
                                              
-- �� �μ��� �ְ� �޿��� �޴� ������� ���, �̸�, �μ��ڵ�, �޿� ��ȸ
-- 1) �� �μ��� �ְ� �޿� ���ϱ�
SELECT DEPT_CODE, MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) ���� �μ��ڵ忡 �ش�ǰ� ���� �޿��� �޴� ����� ��ȸ
SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE, '����'), SALARY
FROM EMPLOYEE
WHERE (NVL(DEPT_CODE, '����'), SALARY) IN (('D1', 3660000)
                                              , ('D9', 8000000)
                                              , ('D5', 3760000)
                                              , ('D6', 3900000)
                                              , ('D2', 2490000)
                                              , ('D8', 2550000)
                                              , (NVL(DEPT_CODE, '����'), 2890000)); 

/* �� �Ǵ� ���
WHERE (DEPT_CODE, SALARY)= ('D1', 3660000')
                                        OR ('D9', 8000000)
                                        OR ...
*/ -- ������ ���� �ʴ� ǥ����


/* ���������� �ſ� ��ٰ����� ���
WHERE DEPT_CODE = 'D1' AND SALARY = 3660000
      OR DEPT_CODE = 'D9' AND SALARY = 8000000
      OR ...
*/

-- 3) ���� ���������� �ϳ��� ���������� ��ġ��
SELECT EMP_ID, EMP_NAME, NVL(DEPT_CODE, '����'), SALARY
FROM EMPLOYEE
WHERE (NVL(DEPT_CODE, '����'), SALARY) IN (SELECT NVL(DEPT_CODE, '����'), MAX(SALARY)
                                                                FROM EMPLOYEE
                                                                GROUP BY DEPT_CODE)
ORDER BY SALARY DESC; --> ���ĵ� ������
--> NULL ���� �� ��� ���Ե� ��� ����񱳰� �Ͼ�� �ʱ� ������ NVL ó���� �ʼ�!
--> NULL ���� ����� IS NULL �����ڷθ� ���� �� ����
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    5. �ζ��� �� (INLINE-VIEW)
    FROM���� ���������� �����ϴ� ��
    
    ���������� ������ ��� (RESULT SET)�� ���̺� ��� �����
*/

-- ���ʽ� ���� ������ 3000���� �̻��� ������� ���, �̸�, ���ʽ����Կ���, �μ��ڵ带 ��ȸ
--> �ζ��κ並 ���� �ʴ� ���
SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "���ʽ����Կ���", DEPT_CODE
FROM EMPLOYEE
WHERE (SALARY + (SALARY * NVL(BONUS, 0))) * 12 >= 30000000;

-->> �ζ��κ並 ���� ���
SELECT EMP_ID, EMP_NAME, ���ʽ����Կ���, DEPT_CODE
FROM (SELECT EMP_ID, EMP_NAME, (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "���ʽ����Կ���", DEPT_CODE
          FROM EMPLOYEE)
WHERE ���ʽ����Կ��� >= 30000000;

--> �ζ��κ並 �ַ� ����ϴ� ��
-- TOP-N �м�: �����ͺ��̽��� �ִ� �ڷ� �� �ֻ��� �� ���� �ڷḦ ���� ���� ���Ǵ� �ڷ�

-- �� ���� �� �޿��� ���� ���� ���� 5��
-- *ROWNUM: ����Ŭ���� �����ϴ� �÷�, ��ȸ�� ������� 1���� ������ �ο��� �ִ� �÷�
SELECT ROWNUM, EMP_NAME, SALARY      -- ����������� 3     �������ϴ¼��� 4
FROM EMPLOYEE                                     -- ����������� 1     �������ϴ¼��� 1
WHERE ROWNUM <= 5                           -- ����������� 2     �������ϴ¼��� 3
ORDER BY SALARY DESC;                          -- ����������� 4     �������ϴ¼��� 2
--> �̽�: �޿������� �������� �ϰ� - ��ȣǥ �ٿ� �ְ� - ��ȣǥ ������� �߶� �ֱ� ������� �Ͼ�� �ϴµ�
--           ��ȣǥ ������� �߶� �ְ� - ��ȣǥ �ٿ� �ְ� - �޿������� �������� �ؼ� TOP-N �м��� �̷������ ����

--> ORDER BY�� ������ ���̺��� ������ ��ȸ, ��ȸ �ÿ� ROWNUM ������ �ٿ� �� �� ROWNUM <= 5 ���� ����
SELECT *
FROM EMPLOYEE
ORDER BY SALARY DESC;

SELECT ROWNUM, EMP_NAME, SALARY      -- ���� ���� 3: SELECT
FROM (SELECT *                                       --���� ���� 0: RESULT SET ��ȸ / ���� ���� 1: FROM
           FROM EMPLOYEE
           ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;                           -- ���� ���� 2: WHERE

--> FROM���� �ζ��κ信 ��Ī�� ���� �� ����, ROWNUM �÷��� ���������� ��Ī�� ���� �� ����
-- SELECT�� �ִ�"��� �÷��� ������ �����" *�� �ܵ����θ� ���� �� �ְ�, �ٸ� �÷���� �Բ� ������ ����
-- ��! "��Ī.*"�� ������
SELECT ROWNUM ����, E.* -- �ζ��� �信 ��Ī�� ���̰� E.*�� �ϸ�  �ش� �ζ��κ��� ��� �÷��� ������ �´�.
FROM (SELECT *
           FROM EMPLOYEE
           ORDER BY SALARY DESC) E
WHERE ROWNUM <= 3;

-- �� �μ��� ��� �޿��� ���� 3���� �μ��ڵ�, ��� �޿� ��ȸ
SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY AVG(SALARY) DESC;

SELECT ROWNUM, DEPT_CODE, ROUND(��ձ޿�) "��ձ޿�"
FROM (SELECT DEPT_CODE, AVG(SALARY) "��ձ޿�" -- �ζ��κ� ���ο��� �׷� �Լ��� �̿��� ��쿡�� �ݵ�� ��Ī�� �ٿ��� ��
           FROM EMPLOYEE
           GROUP BY DEPT_CODE
           ORDER BY AVG(SALARY) DESC)
WHERE ROWNUM <= 3;

-- ���� �ֱٿ� �Ի��� ��� 5�� ��ȸ (�����, �޿�, �Ի���)
SELECT ROWNUM, E.*
FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
          FROM EMPLOYEE
          ORDER BY HIRE_DATE DESC) E
WHERE ROWNUM <= 5;

--> TOP-N �м� �� ORDER BY���� ���� ������ ���� ���� �Ͼ�� �ϱ� ������
-- ORDER BY ���� ���� �Ͼ �� �ְԲ� �ζ��κ並 ����ؾ� ��!
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    6. ���� �ű�� �Լ�
    RANK() OVER(���ı���)
    DENSE_RANK() OVER(���ı���)
    
    ���ǻ���: ������ SELECT �������� �ۼ� ����
                  ����Ŭ���� ������ �ű�� �Լ��� ������ �Լ���� �θ�(SELECT�������� �� �� ����)
                  
    �� �Լ��� ������
    - RANK() OVER(���ı���): ���� 1���� 3���̶�� �Ѵٸ� �� ���� ������ 4���� �ϰڴ� (�� ���� ������ ������� + ���)
    - DENSE_RANK() OVER(���ı���): ���� 1���� 3���̶�� �ص� �� ���� ������ ������ 2���� �ϰڴ� (�� ���� ������ ������� + 1)
*/

-- ������� �޿��� ���� ������� �Űܼ� �����, �޿�, ���� ��ȸ: RANK() OVER()
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;
--> ���� 19�� 2��, �� ���� ������ 21��

-- ������� �޿��� ���� ������� �Űܼ� �����, �޿�, ���� ��ȸ: DENSE_RANK() OVER()
SELECT EMP_NAME, SALARY, DENSE_RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE;
--> ���� 19�� 2��, �� ���� ���� 20��

-- 5�������� ��ȸ�ϰڴ�. (TOP-N �м�)
SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
FROM EMPLOYEE
WHERE RANK() OVER(ORDER BY SALARY DESC) <= 5;
--> ����: window  functions are not allowed here
-->> ������ �Լ��� WHERE ���� ��� �Ұ�

-->> �ζ��� �信���� ����
SELECT *
FROM (SELECT EMP_NAME, SALARY, RANK() OVER(ORDER BY SALARY DESC) "����"
           FROM EMPLOYEE)
WHERE ���� <= 5; --> ��Ī ���� ���� ����