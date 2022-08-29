/*
    <GROUP BY��>
    �׷��� ���� �� ������ ������ �� �ִ� ����
    => �ش� ���õ� ���غ��� �׷��� ���� �� ����
    
    ���� ���� ������ �ϳ��� �׷����� ��� ó���� �������� ��� (���)
*/

-- ��ü ����� �� �޿� ��
SELECT SUM(SALARY)
FROM EMPLOYEE; --> ���� ��ȸ�� ��ü ������� �ϳ��� �׷����� ��� ������ ���� ���

-- �� �μ��� �� �޿� ��
SELECT DEPT_CODE, SUM(SALARY) -- ������ �Լ��� �׷� �Լ��� �Բ� �� �� ����
FROM EMPLOYEE
GROUP BY DEPT_CODE; -- DEPT_CODE �������� �����϶�� ������ �ָ� ���� ���� ��� ����!

-- ��ü ��� ��
SELECT COUNT(*)
FROM EMPLOYEE;

 -- �� �μ��� ��� ��
 SELECT DEPT_CODE, COUNT(*)
 FROM EMPLOYEE
 GROUP BY DEPT_CODE;
 
 -- �� �μ��� �� �޿� ���� �μ��ڵ带 �������� �����ؼ� ��ȸ
 SELECT DEPT_CODE, SUM(SALARY) -- ����3. SELECT��
 FROM EMPLOYEE -- ����1: FROM��
 GROUP BY DEPT_CODE -- ����2: GROUP BY��
 ORDER BY DEPT_CODE ASC; -- ����4: ORDER BY��
 
 -- �� ���޺� �����ڵ�, �� �޿��� ��, ��� ��, ���ʽ��� �޴� ��� ��, ��� �޿�, �ּ� �޿�
 SELECT JOB_CODE "�����ڵ�"
          , SUM(SALARY) "�ѱ޿���"
          , COUNT(*) "�����"
          , COUNT(BONUS) "���ʽ��޴»����"
          , AVG(SALARY) "��ձ޿�"
          , MIN(SALARY) "�ּұ޿�"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE ASC;

-- �� �μ��� �μ��ڵ�, ��� ��, ���ʽ��� �޴� ��� ��, ����� �ִ� ��� ��, ��� �޿�
SELECT DEPT_CODE "�μ��ڵ�"
         , COUNT(*) "�����"
         , COUNT(BONUS) "���ʽ��޴»����"
         , COUNT(MANAGER_ID) "������ִ»����"
         , AVG(SALARY) "��ձ޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE -- GROUP BY ������ ��Ī ��� �Ұ� (�������)
ORDER BY DEPT_CODE ASC;

-- ���� �� ��� ��
SELECT SUBSTR(EMP_NO, 8, 1) ����, COUNT(*) �����
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- DECODE �Լ� ����
SELECT DECODE(SUBSTR(EMP_NO, 8, 1), '1', '����', '2', '����') ����, COUNT(*) �����
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);

-- �Ի�⵵�� �ο� �� ��ȸ,  ��! 2015�⵵���� ��ȸ, �⵵�� ���������ؼ� ��ȸ
SELECT EXTRACT(YEAR FROM HIRE_DATE) || '��' "�Ի�⵵", COUNT(*) || '��' "�Ի��ο�"
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2015
GROUP BY EXTRACT(YEAR FROM HIRE_DATE)
ORDER BY �Ի�⵵ ASC;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <HAVING��>
    �׷쿡 ���� ������ ������ �� ���Ǵ� ����
    (�׷��Լ��� ���Ե� ���ǽ��� ������ ��� ������ HAVING���� �ۼ��ؾ� ��!)
    => WHERE���� �׷� �Լ��� ���� ������ ������ �� �ٷ� ���� ��!
*/

-- �� �μ��� ��� �޿��� 300 ���� �̻��� �μ��鸸 ��ȸ
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
WHERE AVG(SALARY) >= 3000000 -- ����! WHERE������ �׷� �Լ� ���� ����� �� ����
GROUP BY DEPT_CODE;

-- HAVING���� ���� �ۼ��ؾ� ��
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

-- �� ���޺� �� �޿� ���� 1000���� �̻��� ���� �ڵ�, �޿� ���� ��ȸ
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000;

-- �� �μ��� ���ʽ��� �޴� ����� ���� �μ����� ��ȸ
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0;

-- ���ʽ��� �޴� ��� ��: COUNT(BONUS)
-- COUNT(BONUS) > 0 => �� ���̶� ���ʽ��� �޴� ����� �ִ�
-- COUNT(BONUS) = 0 => ���ʽ��� �޴� ����� �� �� ����
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <���� ����>
   5.  SELECT * / ��ȸ�ϰ����ϴ��÷��� / ���ͷ� / �������� / �Լ��� AS "��Ī"
   1.  FROM ��ȸ�ϰ����ϴ����̺��  / DUAL(�������̺��)
   2.  WHERE ���ǽ�(�׷��Լ��� �ȵ�)
   3.  GROUP BY �׷���ؿ��ش��ϴ��÷��� / �Լ���
   4.  HAVING �׷��Լ��Ŀ��������ǽ�
   6.  ORDER BY [���ı��ؿ��ش��ϴ��÷��� / ��Ī / �÷�����] [ASC/DESC] [NULLS FIRST/NULLS LAST]
*/

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <���� ������ SET OPERATOR>
    ���� ���� �������� ������ �ϳ��� ���������� ����� ������
    
    - UNION: ������(�� �������� ������ ������� ���� �� �ߺ��Ǵ� �κ��� �� �� �� ��) => OR�� ����
    - INTERSECT: ������ (�� �������� ������ ������� �ߺ��� ����� �κ�) => AND�� ����
    - UNION ALL: ������ ����� �������� �� �� ������ ����
                        (�� �������� ������ ������� ������ ����! ��, �����տ��� �ߺ� ���Ÿ� ���� ���� ����)
    - MINUS: ������(���� ������ ����� ���� ���� ������ �����)
*/

-- 1. UNION (������ - �� �������� ������ ������� �������� �ߺ��Ǵ� ����� �� ���� ��ȸ)
-- �μ��ڵ尡 D5�̰ų� �Ǵ� �޿��� 300���� �ʰ��� ����� ��ȸ (���, �����, �μ��ڵ�, �޿�)

-- �μ��ڵ尡 D5�� ����鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'; --> 6�� ��ȸ(�ڳ���, ������, ���ؼ�, �ɺ���, ������, ���ȥ)

-- �޿��� 300���� �ʰ��� ����鸸 ��ȸ
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; --> 8�� ��ȸ(������, ���߱�, ���ö, ���缮, ������, �ɺ���, ���ȥ, ������)

-- �μ��ڵ� D5�̰ų� �Ǵ� �޿��� 300���� �ʰ��� ����� ��ȸ(���, �̸�, �μ��ڵ�, �޿�) => UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 12�� ��ȸ(�ڳ���, ������, ���ؼ�, �ɺ���, ������, ���ȥ, ������, ������, ���ö, �����, ������, ������)
--> 6�� + 8�� - 2��(�ߺ� ����) = 12��

-- ���ǻ���: ���� ���� �� �׻� �� ������ SELECT���� ������ ��ġ�ؾ� ��

-- ���� UNION������ �ϳ��� SELECT������ ǥ���ϱ�
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;
--> OR �����ڷ� �� ���� ������ ��� ��ȸ�ϸ� ����� ����

-- �� �μ��� �޿��� ��ȸ (�μ��ڵ�, �μ��� �޿���)
-- UNION �̿��ؼ�
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1'
UNION
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D2'
UNION
-- ... �� �μ����� WHERE���� �̿��ؼ� ������ UNION���� ��ġ�� ����� �����ϱ� ��

-- GROUP BY ����
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2. UNION ALL: ���� ���� ���� ����� ������ ���ϴ� ������ (�ߺ��� ���� �� ����)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' -- 6��
UNION ALL ------------------------------------ 14��
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000; -- 8��
--> 14�� ��ȸ(�ڳ���, ������, ���ؼ�, "�ɺ���", ������, "���ȥ", ������, ������, ���ö, �����, ������, "�ɺ���, ���ȥ", ������)
--> 6�� + 8�� = 14��

-- 3. INTERSECT (������ - ���� ���� ����� �ߺ��� ����� ��ȸ)
-- �μ� �ڵ尡 D5�̸鼭 �Ӹ� �ƴ϶� �޿������� 300���� �ʰ��� ����� (���, �����, �μ��ڵ�, �޿�)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 2�� ��ȸ (�ɺ���, ���ȥ)
--> �ߺ��� ����� ��ȸ / �� ������ ��� �ش�Ǵ� ���

-- �Ʒ�ó���� ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

-- 4. MINUS (������ - �������� ����� �������� ����� �� ������)
--> ��𿡼� �� ���Ŀ� ���� ����� �ٸ��� ������ ������ ������ �߿�!
-- �μ� �ڵ尡 D5�� ����� �� �޿��� 300���� �ʰ��� ������� �����ϰ� ��ȸ

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;
--> 4�� ��ȸ(�ڳ���, ������, ���ؼ�, ������)
--> 6�� - ��ġ�� 2�� = 4��

-- ������ �ٲ۴ٸ�?
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';
--> 6�� (������, ������, ���ö, �����, ������, ������)
--> 8�� - ��ġ�� 3�� = 6��

-- �Ʒ�ó���� ����
-- �μ��ڵ尡 D5�� ����� �� �޿��� 300���� �ʰ��� ������� �����ϰ� ��ȸ
-- �μ��ڵ尡 D5�� ����� �� �޿��� 300���� ������ ����鸸 ����
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'AND SALARY <= 3000000;

--------------------------------------------------------------------------------------------------------------------------------------------
----- KH ���� SELECT �⺻ �������� -----
-- 1. EMPLOYEE���̺��� �����, ��� �̸�, ���� ��ȸ
SELECT HIRE_DATE "�����", EMP_NAME "��� �̸�", SALARY "����"
FROM EMPLOYEE;

-- 2. EMPLOYEE���̺��� SAL_LEVEL�� S1�� ����� �̸�, ����, �����, ����ó ��ȸ
SELECT EMP_NAME "��� �̸�", SALARY "����", HIRE_DATE "�����", PHONE "����ó"
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';

-- 3. EMPLOYEE���̺��� �̸�, ����, �� ���ɾ�(���ʽ� ����), �Ǽ��ɾ�(�Ѽ��ɾ� - (���� * ���� 3%)) ��ȸ
SELECT EMP_NAME "�̸�"
         , SALARY * 12 "����"
         , (SALARY + (SALARY * NVL(BONUS, 0))) * 12 "�� ���ɾ�" 
         , ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - (SALARY * 0.03) "�Ǽ��ɾ�"
FROM EMPLOYEE;

-- 4. EMPLOYEE���̺��� �Ǽ��ɾ�(3�� ����)�� 5õ���� �̻��� ����� �̸�, ����, �Ǽ��ɾ�, ����� ��ȸ
SELECT EMP_NAME "�̸�"
         , SALARY "����"
         , ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) * 0.03 "�Ǽ��ɾ�"
         , HIRE_DATE "�����"
FROM  EMPLOYEE
WHERE  ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) - ((SALARY + (SALARY * NVL(BONUS, 0))) * 12 ) * 0.03 >= 50000000;

-- 5. EMPLOYEE���̺��� ������ ������ �ֹι�ȣ�� �̿��Ͽ� ����, ����, ���� ��ȸ
SELECT EMP_NAME "�����"
         , 19 || SUBSTR(EMP_NO, 1, 2) || '��' "����"
         , SUBSTR(EMP_NO, 3, 2) || '��'"����"
         , SUBSTR(EMP_NO, 5, 2) || '��' "����"
FROM EMPLOYEE;

-- 6. EMPLOYEE���̺��� ������, �μ��ڵ�, �������, ����(��) ��ȸ
-- ��, ��������� �ֹι�ȣ���� �����ؼ� 00�� 00�� 00�Ϸ� ��µǰ� �ϸ�,
-- ���̴� �ֹι�ȣ���� ��¥ �����ͷ� ���� �� ���
SELECT EMP_NAME "������"
         , DEPT_CODE "�μ��ڵ�"
         , 19 || SUBSTR(EMP_NO, 1, 2) || '��' || SUBSTR(EMP_NO, 3, 2) || '��' || SUBSTR(EMP_NO, 5, 2) || '��' "�������"
--         , REPLACE(SUBSTR(EMP_NO, 1, 2), SUBSTR(EMP_NO, 1, 2), SUBSTR(EMP_NO, 1, 2) ���� ���� ������ ;;;;
         , EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 2), 'RR')) || '��' "����(��)"
FROM EMPLOYEE;

-- 7. EMPLOYEE���̺��� �ٹ� ����� 20�� �̻��� ���� ���� ��ȸ
SELECT *
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) >= 20
ORDER BY HIRE_DATE ASC;

-- 8. EMPLOYEE���̺��� �μ��ڵ尡 D5, D6, D9�� ����� ��ȸ�ϵ� D5�� �ѹ���, D6�� ��ȹ��, D9�� �����η� ó��
SELECT EMP_ID
     , EMP_NAME
     , EMP_NO
     , EMAIL
     , PHONE
     , DECODE(DEPT_CODE, 'D5', '�ѹ���', 'D6', '��ȹ��', 'D9', '������') "�μ���"
     , JOB_CODE
     , SAL_LEVEL
     , SALARY
     , BONUS
     , MANAGER_ID
     , HIRE_DATE
     , ENT_DATE
     , ENT_YN
-- ���� �� ����ϸ鼭 DEPT_CODE�� ��� �ٲ���,,,? *, DECODE~ �� ��
--> ����� ��� �����ϴ� �׷��� �ϴ� ����� ���� ��... �׳� �� ����� �ǳ� ��
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6' ,'D9');

-- 9. EMPLOYEE���̺��� ����� Ȧ���� �������� ���� ��� ��ȸ
SELECT *
FROM EMPLOYEE
-- WHERE TO_NUMBER(EMP_ID, '999') / 2 = 1; �ȵ� ;;
-- WHERE (EMP_ID * 1) / 2 = 1; �ȵ�;;;;;;
WHERE MOD(EMP_ID, 2) = 1;
