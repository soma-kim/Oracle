/*
    <JOIN>
    
    �� �� �̻��� ���̺��� �����͸� ���� ��ȸ�ϰ��� �� �� ���Ǵ� ����
    ��ȸ ����� �ϳ��� �����(RESULT SET)�� ����
    
    ������ �����ͺ��̽������� �ּ����� �����ͷ� ������ ���̺� �����͸� �����ϰ� ����
    (�ߺ��� �ּ�ȭ�ϱ� ���ؼ� �ִ��� �ɰ��� ������)
    => ��, JOIN ������ �̿��� ���� ���� ���̺��� ���踦 �ξ� ���� ��ȸ�ؾ� ��
    => ��, ������ JOIN ������ �ۼ��ؼ� ��ȸ�� �ϴ� �� �ƴ϶�
         ���̺��� "�����"�� �ش��ϴ� �÷� (== �ܷ�Ű)�� ��Ī���Ѽ� JOIN �� ��� ��
         
         JOIN�� ũ�� "����Ŭ ���뱸��"�� "ANSI(�̱�����ǥ����ȸ) ����" ���� ����
         
                      ����Ŭ ���뱸��                       |                           ANSI ����
     ===================================================================                   
                           �����                            |         ��������(INNER JOIN) -> JOIN USING / ON
                       (EQUAL JOIN)                         |        �ܺ�����(OUTER JOIN) -> ������ �̷��� ������ �ʰ� �������� ����
                   
             => ����� �÷��� �ش��ϴ� ������ "���� �͵鸸" ������ ���ڴ� (�����, "����"����)
             => ����� �÷��� �ش��ϴ� ������ "��ġ���� �ʾƵ�" ������ ���ڴ� (�����, "�ܺ�"����)
     ----------------------------------------------------------------------------------------------------------------------------
                           ��������                           |         
                        (LEFT OUTER)                        |         ���� �ܺ�����(LEFT OUTER JOIN)
                       (RIGHT OUTER)                      |        ������ �ܺ�����(RIGHT OUTER JOIN)
                                                                  |         ��ü �ܺ�����(FULL OUTER JOIN) -> ����Ŭ������ �Ұ�
     ----------------------------------------------------------------------------------------------------------------------------
           ī�׽þ� ��(CARTESIAN PRODUCT)       |                         ��������(CROSS JOIN)
             => ��� ����� ���� ���� ��� ���ϰڴ�         
     ----------------------------------------------------------------------------------------------------------------------------
                ��ü����(SELF JOIN)                      |
                ������(NON EQUAL JOIN)        |
     ----------------------------------------------------------------------------------------------------------------------------
*/

-- ��ü ������� ���, �����, �μ��ڵ�, �μ������ �˾Ƴ����� �Ѵٸ�?
SELECT EMP_ID, EMP_NAME, DEPT_CODE -- �μ����� �� �� ����
FROM EMPLOYEE; -- EMPLOYEE ���̺��� DEPT_CODE �÷��� �μ� ������ ��� ����

SELECT DEPT_ID, DEPT_TITLE -- ���, ������� �� �� ����
FROM DEPARTMENT; -- DEPARTMENT ���̺��� DEPT_ID �÷�

-- ��ü ������� ���, �����, �����ڵ�, ���޸���� �˾Ƴ����� �Ѵٸ�?
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE; -- EMPLOYEE ���̺��� JOB_CODE  �÷�

SELECT JOB_CODE, JOB_NAME
FROM JOB; -- JOB ���̺��� JOB_CODE �÷�

--> ������ ���ؼ� ������� �ش��ϴ� �÷��� ����� ��Ī��Ų�ٸ� ��ġ �ϳ��� ������� ��ȸ ����

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    1. �����(EQUAL JOIN) / ��������(INNER JOIN)
    �����Ű���� �÷��� ������ ��ġ�ϴ� ��鸸 ���εż� ��ȸ
    (== ��ġ���� �ʴ� ������ ��ȸ���� ���ܵ�)

*/

-->> ����Ŭ ���� ����
-- FROM���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸�(,)�� ����
-- WHERE���� ��Ī��ų �÷���(�����)�� ���� ������ ������

-- ��ü ������� ���, �����, �μ��ڵ�, �μ��� ���� ��ȸ
-- 1) ������ �� �÷����� �ٸ� ��� (EMPLOYEE ���̺��� DEPT_CODE / DEPARTMENT ���̺��� DEPT_ID)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
--> ��ġ���� �ʴ� ���� ��ȸ���� ���ܵ� �� Ȯ�� ����
-- (DEPT_CODE�� NULL�̾��� 2���� �����ʹ� ��ȸ�� �� ��, DEPARTMENT ���̺��� DEPT_ID �÷����� NULL�� �������� ����)
-- (DEPT_ID�� D3, D4, D7�� �μ��� �μ����� ��ȸ�� �� ��! EMPLOYEE ���̺��� DEPT_CODE �÷����� D3, D4, D7�� �������� ����)

-- ��ü ������� ���, �����, �����ڵ�, ���޸� ���� ��ȸ
-- 2) ������ �� �÷����� ���� ��� (EMPLOYEE ���̺��� JOB_CODE / JOB ���̺��� JOB_CODE)
/*
SELECT EMP_ID, EMP_NAME, 
FROM EMPLOYEE, JOB
WHERE JOB_CODE = JOB_CODE;
*/
--- ���� (AMBIGUOUSLY: �ָ��ϴ�, ��ȣ�ϴ� => Ȯ���� � ���̺��� ��� �÷������� ����ؾ� ��)

-- �ذ��� 1) ���̺���� ���� ����Ͽ� �̿��ϴ� ��� (���̺��.�÷���)
SELECT EMP_ID, EMP_NAME, EMPLOYEE.JOB_CODE, JOB.JOB_CODE, JOB_NAME
FROM EMPLOYEE, JOB
WHERE EMPLOYEE.JOB_CODE = JOB.JOB_CODE;

-- �ذ��� 2) ���̺� ��Ī�� �ٿ��� ��Ī�� �̿��ϴ� ��� (��Ī.�÷���) -> �� ���̺��� ��Ī �ο� ����
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, J.JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;

-->> ANSI ����
-- FROM���� ������ �� ���̺�� �ϳ��� ����� ��
-- �� �ڿ� JOIN������ ���� ��ȸ�ϰ��� �ϴ� ���̺���� ���! ���� ��Ī��ų �÷��� ���� ���ǵ� ���� ��� (USING / ON ����)

-- ���, �����, �μ��ڵ�, �μ��� ��ȸ
-- 1) ������ �� �÷����� �ٸ� ��� (EMPLOYEE ���̺��� DEPT_CODE / DEPARTMENT ���̺��� DEPT_ID)
-- => ������ ON ������ ������ (USING ������ �Ұ���)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
/* INNER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> INNER�� ���� ����

-- ���, �����, �����ڵ�, ���޸� ��ȸ
-- 2) ������ �� �÷����� ���� ���(EMPLOYEE ���̺��� JOB_CODE / JOB���̺��� JOB_CODE)
-- => ON ����, USING ���� �� �� ��� ����
-- 2_1) ON ���� �̿�: AMBIGIFUOUSLY ������ �߻��� �� �ֱ� ������ Ȯ���� ����ؾ� ��(���̺��, ��Ī)
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON (E. JOB_CODE = J.JOB_CODE);

-- 2_2) USING ���� �̿�: AMBIGUOUSLY ���� �߻� X
-- ������ �÷��� �ϳ��� �� ���� �ָ� �˾Ƽ� ��Ī���� ��
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE);

-- [����] ���� ���ô� NATURAL JOIN (��������)���ε� ����
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
NATURAL JOIN JOB;
-- �� ���� ���̺� ������ ����,
-- ��ħ �� ���Ե� �� ���� ���̺� ��ġ�ϴ� �÷��� �����ϰ� �� ���� ����(JOB_CODE)
-- => �˾Ƽ� ��Ī�Ǿ� ��ȸ��

-- �߰����� ���ǵ� ���� ����
-- ������ �븮�� ������� ���� ��ȸ (���, �����, �޿�, ���޸�)

-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE -- ������� ���� ����
    AND JOB_NAME = '�븮'; -- �߰����� ����
-- ���� �� �������� ���̱� ���� ���� ������ �� �پ� ����, �鿩���� �ؼ� ����.

-->> ANSI����
SELECT EMP_ID, EMP_NAME, SALARY, JOB_NAME
FROM EMPLOYEE E
-- JOIN JOB USING (JOB_CODE);
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
    WHERE JOB_NAME = '�븮';

----- �ǽ����� -----
-- 1. �μ��� '�λ������'�� ������� ���, �����, ���ʽ��� ��ȸ

-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID
    AND DEPT_TITLE = '�λ������';

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE DEPT_TITLE = '�λ������';

-- 2. �μ��� '�ѹ���'�� �ƴ� ������� �����, �޿�, �Ի����� ��ȸ

-->> ����Ŭ ���� ����
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID
    AND DEPT_TITLE != '�ѹ���';

-->> ANSI ����
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE DEPT_TITLE != '�ѹ���';

-- 3. ���ʽ��� �޴� ������� ���, �����, ���ʽ�, �μ��� ��ȸ

-->> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, BONUS, D.DEPT_TITLE
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DEPT_CODE = D.DEPT_ID
 AND BONUS IS NOT NULL;

-->> ANSI ����
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE BONUS IS NOT NULL;

-- 4. �Ʒ��� �� ���̺��� �����Ͽ� �μ��ڵ�, �μ���, �����ڵ�, ������ (LOCAL_NAME) ��ȸ
SELECT * FROM DEPARTMENT -- LOCATION_ID
SELECT * FROM LOCATION -- LOCAL_CODE

-->> ����Ŭ ���� ����
SELECT DEPT_ID, DEPT_TITLE, LOCATION_ID, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

-->> ANSI ����
SELECT DEPT_ID, DEPT_TITLE, D.LOCATION_ID, L.LOCAL_NAME
FROM DEPARTMENT D
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE);
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    2. �������� / ����, ������, ��ü �ܺ�����(OUTER JOIN)
    ���̺��� JOIN �� ��ġ���� ���� �൵ ���Խ��Ѽ� ��ȸ ����
    ��, �ݵ�� LEFT/RIGHT �� ���� ���̺��� �����ؾ� ��
    
    => �ϴ� ��ġ�ϴ� �͵� ��ȸ + ���� ���̺��� �����ƴ� �͵� ��ȸ
*/

-- "��ü" ������� �����, �޿�, �μ��� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- DEPT_CODE�� NULL�� �� ���� ��� ������ ��ȸ���� ����
-- �μ��� ������ ����� ���� �μ�(D3, D4, D7) �� ���� �μ���(�����ú�, ����������, �ؿܿ���3��)�� ��ȸ���� ����
-- => �⺻������ ����� / �������ο����� ��ġ�ϴ� �͵鸸 ��ȸ�� �ϱ� ������ ���� �� �׸���� ��ȸ���� ����

-- 1) LEFT OUTER JOIN: �� ���̺� �� ���� ����� ���̺��� �������� JOIN
--                              ��, ���� �Ǿ��� ���� ���� ����� ���̺��� �����ʹ� ������ �� ������ ��ȸ�ϰ� ��
--                              (��ġ�ϴ� ���� ã�� ���ϴ���)

-->> ANSI ����
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE -- "�������� �� ���� ���̺�" ���
LEFT /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- INNER JOIN ���� ���� �μ��� NULL���� 2���� ������ ������ �ʾ�����
-- OUTER JOIN���� �����ϴϱ� NULL���� ä������ 2���� �߰��� ����!
--> EMPLOYEE ���̺��� �������� ��ȸ�߱� ������ EMPLOYEE�� �����ϴ� �����ʹ� ���� �Ǿ��� ���� ��ȸ�ǰԲ� �ϰ���

--> ����Ŭ ���� ����
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);
--> ���� �������� ���� ���̺��� �÷����� �ƴ� �ݴ� ���̺��� �÷��� (+) ��ȣ�� �ٿ� ��

-- 2) RIGHT OUTER JOIN: �� ���̺� �� ������ ����� ���̺��� �������� JOIN
--                                 ��, ���� �Ǿ��� ���� ������ ����� ���̺��� �����ʹ� ������ �� ���� ��ȸ�ϰ� ��
--                                  (��ġ�ϴ� ���� ã�� ���ϴ���)

--> ANSI����
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE 
RIGHT /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);

-- LEFT�� RIGHT�� "���� ����"�̹Ƿ� ��, �Ʒ��� OUTER JOIN�� �Ϻ��ϰ� �Ȱ���!

SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM DEPARTMENT
LEFT JOIN EMPLOYEE ON (DEPT_CODE = DEPT_ID);

--> ����Ŭ ���� ����
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

-- LEFT / RIGHT OUTER JOIN�� ����� �ϴ� ������� ����� �������� �͵��� �� ���� �� ��ȸ�� ��
-- ������ �Ǵ� ���̺��� ������ ������ �߰������� ��ȸ�Ǵ� ����

-- 3) FULL OUTER JOIN: �� ���̺��� ���� ��� ���� ��ȸ�� �� �ֵ��� JOIN
--                               (��, ����Ŭ ���� ���������� �Ұ�)
-->> ANSI����
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
FULL /* OUTER */ JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
--> ��ġ�ϴ� ���빰�� ��ȸ + ���� ���̺��� ������ �� ��ȸ + ������ ���̺��� ������ �� ��ȸ

--> ����Ŭ ���� ���� (����: only one outer-joined table)
SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID(+);

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    3. ī�׽þ� �� (CATESIAN PRODUCT) / �������� (CROSS JOIN)
    ��� ���̺��� �� ����� ���μ��� ���ε� ����� ��ȸ��(������)
    �� ���̺��� ����� ��� ������ ����� ������ ��� �� ��µ� => ����� ������ ��� => �������� ����
    
    => ���� ������ �߸��Ǿ��ų� �������� ��� �߻��ϱ� ������ �����ؾ� ��
    
    ��) ���� N��, M�� ���� ���� ���̺��� ī�׽þ� �� ������� N * M ���� ���� ����
*/

-- �����, �μ��� ��ȸ
--> ����Ŭ ���� ����
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT; --> 23�� * 9�� => 207�� �� ��ȸ

--> ANSI����
SELECT EMP_NAME, DEPT_TITLE
FROM EMPLOYEE
CROSS JOIN DEPARTMENT;
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    4. �� ����(NON EQUAL JOIN)
    '=' (����񱳿�����) �� ������� �ʴ� ���ι�
    ������ �÷����� ��ġ�ϴ� ��찡 �ƴ� "����"�� ���ԵǴ� ��� ��Ī���Ѽ� ��ȸ�ϰڴٴ� ��
*/

-- �����, �޿�, �޿����(EMPLOYEE)
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE;

-- EMPLOYEE ���̺� SAL_LEVEL�� ���ٴ� �����Ͽ� SAL_GRADE ���̺��� �����´ٰ� �� ����!

-- SAL_GRADE ��ȸ
SELECT *
FROM SAL_GRADE;

-- �����, �޿�, �޿����(SAL_GRADE)
--> ����Ŭ ���� ����
SELECT EMP_NAME, SALARY, S.SAL_LEVEL
FROM EMPLOYEE E, SAL_GRADE S
-- WHERE SALARY >= MIN_SAL AND SALARY <= MAX_SAL; -- ������� ���� ����
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL; -- ������� ���� ����

--> ANSI ����
SELECT EMP_NAME, SALARY, S.SAL_LEVEL
FROM EMPLOYEE E
JOIN SAL_GRADE S ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);
--> ������� ��� INNER�� �⺻ Ÿ��
--> ������ �ɸ� �ڵ����� ������ ��

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    5. ��ü ����(SELF JOIN)
    
    ���� ���̺��� �ٽ� �ѹ� �����ϴ� ���
    ��, �ڱ� �ڽ��� ���̺�� �ٽ� ������ �δ� ���
*/

-- ����� ���, �����, ��� �޿�, ����� ���
SELECT EMP_ID "����� ���"
         , EMP_NAME "�����"
         , SALARY "��� �޿�"
         , MANAGE_ID "����� ���"
FROM EMPLOYEE;

-- ����� ���, �����, ����� �μ��ڵ�, ����� �޿�
-- ����� ���, �����, ����� �μ��ڵ�, ����� �޿�

-- �������, ��������� ���� ������ �� ���̺��� ��Ī
SELECT * FROM EMPLOYEE E; -- ����� ���� ���� ����� ���̺�: E => ����� �÷�: MANAGER_ID
SELECT * FROM EMPLOYEE M; -- ����� ���� ���� ����� ���̺�: M => ����� �÷�: EMP_ID

--> ����Ŭ ���� ����
SELECT E.EMP_ID "����� ���", E.EMP_NAME "�����", E.DEPT_CODE "����� �μ��ڵ�", E.SALARY "����� �޿�"
         ,  M.EMP_ID"����� ���", M.EMP_NAME "�����", M.DEPT_CODE "����� �μ��ڵ�", M.SALARY"����� �޿�"
FROM EMPLOYEE E, EMPLOYEE M
-- WHERE E.MANAGER_ID = M.EMP_ID; -- ��ġ�ϴ� ����ο� ���� ������ �������� ��: ����� �ִ� ��� (NULL�� �ƴ� ���)�� ��ȸ
WHERE E.MANAGER_ID = M.EMP_ID(+); -- ����� ���� ����� ��� ��ȸ�ϰ� ���� ��
-- ������ ������� ��� ������ �ƴ� ���� (+)�� �ɾ� �ָ� ����� NULL���� ���� ��� ��ȸ��

--> ANSI ����
SELECT E.EMP_ID "����� ���", E.EMP_NAME "�����", E.DEPT_CODE "����� �μ��ڵ�", E.SALARY "����� �޿�"
         ,  M.EMP_ID"����� ���", M.EMP_NAME "�����", M.DEPT_CODE "����� �μ��ڵ�", M.SALARY"����� �޿�"
FROM EMPLOYEE E
-- JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID); -- �������� �������� �ۼ����� ���: ����� �ִ� ��츸 ��ȸ
LEFT JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID); -- �ܺ����� �������� �ۼ����� ���: ����� ���� ��쵵 �����ؼ� ��ȸ
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <���� JOIN>
    3�� �̻��� ���̺��� �����ϴ� ��
*/

-- ���, �����, �μ���, ���޸�
SELECT * FROM EMPLOYEE;        --    DEPT_CODE     JOB_CODE
SELECT * FROM DEPARTMENT;   --     DEPT_ID
SELECT * FROM JOB;                 --                          JOB_CODE

--> ����Ŭ ���� ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J
-- WHERE DEPT_CODE = DEPT_ID -- ����� ������ �ο��� ���: �μ� ��ġ�� �� �� ������� ��ȸ �� ��
WHERE DEPT_CODE = DEPT_ID(+) -- �������� ������ �ο��� ���: �μ� ��ġ�� �� �� ������� �����ؼ� ��ȸ
    AND E.JOB_CODE = J.JOB_CODE;

--> ANSI ����
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
-- JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- DEPARTMENT ���̺��� ���� ���� �� ���: �μ� ��ġ�� �� �� ������� ��ȸ �� ��
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID) -- EMPLOYEE ���� LEFT OUTER JOIN �� ����
                                                                            -- DEPARTMENT ���̺��� LEFT OUTER JOINT �� ���: �μ���ġ�� �� �� ������� �����ؼ� ��ȸ
       JOIN JOB USING (JOB_CODE); -- EMPLOYEE ���� INNER JOIN �� ����
-- �÷��� ��ġ�� ��
-- ON ����: ��Ī �ʼ�, USING ����: ��Ī �ʼ� �ƴ�

-- ���, �����, �μ���, ���޸�, �ٹ������� (LOCAL_NAME)
SELECT * FROM EMPLOYEE;     --  DEPT_CODE      JOB_CODE
SELECT * FROM DEPARTMENT --  DEPT_ID                                    LOCATION_ID
SELECT * FROM JOB;              --                        JOB_CODE
SELECT * FROM LOCATION;    --                                                  LOCAL_CODE 

--> ����Ŭ ���� ����
SELECT EMP_ID "���"
         , EMP_NAME "�����"
         , DEPT_TITLE "�μ���"
         , JOB_NAME "���޸�"
         , LOCAL_NAME "�ٹ�������"
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION
WHERE DEPT_CODE = DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND LOCATION_ID = LOCAL_CODE;
    
--> ANSI ����
SELECT EMP_ID "���"
         , EMP_NAME "�����"
         , DEPT_TITLE "�μ���"
         , JOB_NAME "���޸�"
         , LOCAL_NAME "�ٹ�������"
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE); -- ��ǻ� DEPARTMENT ���̺� JOIN�ϴ� ����)
-- ���ǻ���! ���� JOIN ��, ANSI ������ �̿��� ��� ���̺���� ����ϴ� ������ �߿�!
-- LOCATION ���̺��� DEPARTMENT ���̺��� ���� ���εǸ� EMPLOYEE ���̺� ���εǴ� ���̱� ������
-- EMPLOYEE ���̺� LOCATION_ID �÷��� ��� ���� �߻�

-- �����, �μ���, ���޸�, �ٹ�������, �ٹ�������, �޿����(SAL_GRADE)
SELECT * FROM EMPLOYEE;      -- DEPT_CODE     JOB_CODE           SALARY
SELECT * FROM DEPARTMENT; --   DEPT_ID                                                            LOCATION_ID
SELECT * FROM LOCATION;     --                                                                          LOCAL_CODE        NATIONAL_CODE
SELECT * FROM JOB;               --                      JOB_CODE
SELECT * FROM SAL_GRADE;    --                                          MIN_SAL, MAX_SAL
SELECT * FROM NATIONAL;     --                                                                                                    NATIONAL_CODE

--->> ����Ŭ ���� ����
SELECT EMP_NAME "�����"
         , DEPT_TITLE "�μ���"
         , JOB_NAME "���޸�"
         , LOCAL_NAME "�ٹ�������"
         , NATIONAL_NAME "�ٹ�������"
         , S.SAL_LEVEL "�޿����"
FROM EMPLOYEE E, DEPARTMENT , JOB J, SAL_GRADE S, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
  AND E.JOB_CODE = J.JOB_CODE
  AND SALARY BETWEEN MIN_SAL AND MAX_SAL
  AND LOCATION_ID = LOCAL_CODE
  AND L.NATIONAL_CODE = N.NATIONAL_CODE;                                                                                                                                                                                                                                                                                                                    
    --> ���ǻ���: ���� ���� �� ���̺��� ������ ��� �ִ��� �򰥸��� �ʰ� �׳� ��Ī ������!
    
--> ANSI ����
SELECT EMP_NAME "�����"
     , DEPT_TITLE "�μ���"
     , JOB_NAME "���޸�"
     , LOCAL_NAME "�ٹ�������"
     , NATIONAL_NAME "�ٹ�������"
     , S.SAL_LEVEL "�޿����"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J USING (JOB_CODE)
JOIN SAL_GRADE S ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
JOIN NATIONAL N ON (L.NATIONAL_CODE = N.NATIONAL_CODE); -- USING�� ����

-- ��� ���, �����, ����� �μ���, ��� �޿�
-- ��� ���, �����, ����� �μ���, ��� �޿�
SELECT * FROM EMPLOYEE E; -- ��� ���̺�κ��� MANAGER_ID �÷�        DEPT_CODE
SELECT * FROM EMPLOYEE M; -- ��� ���̺�κ��� EMP_ID �÷�               DEPT_CODE
SELECT * FROM DEPARTMENT; --                                                           DEPT_ID

--> ����Ŭ ���� ����
SELECT E.EMP_ID "����� ���"
         , E.EMP_NAME "����� �̸�"
         , D1.DEPT_TITLE "����� �μ���" -- E.DEPT_CODE "��� �μ��ڵ�"
         , E.SALARY "����� �޿�"
         , M.EMP_ID "����� ���"
         , M.EMP_NAME "����� �̸�"
         , D2.DEPT_TITLE "����� �μ���" -- M.DEPT_CODE "��� �μ��ڵ�"
         , M.SALARY "����� �޿�"
FROM EMPLOYEE E, EMPLOYEE M, DEPARTMENT D1, DEPARTMENT D2
WHERE (E.MANAGER_ID = M.EMP_ID)
  AND (E.DEPT_CODE = D1.DEPT_ID)
  AND (M.DEPT_CODE = D2.DEPT_ID);

--> ANSI ����
SELECT E.EMP_ID "����� ���"
         , E.EMP_NAME "����� �̸�"
         , D1.DEPT_TITLE "����� �μ���" -- E.DEPT_CODE "��� �μ��ڵ�"
         , E.SALARY "����� �޿�"
         , M.EMP_ID "����� ���"
         , M.EMP_NAME "����� �̸�"
         , D2.DEPT_TITLE "����� �μ���" -- M.DEPT_CODE "��� �μ��ڵ�"
         , M.SALARY "����� �޿�"
FROM EMPLOYEE E
JOIN EMPLOYEE M ON (E.MANAGER_ID = M.EMP_ID)
JOIN DEPARTMENT D1 ON (E.DEPT_CODE = D1.DEPT_ID)
JOIN DEPARTMENT D2 ON (M.DEPT_CODE = D2.DEPT_ID);

----- JOIN ���� �ǽ����� -----
-- 1. ������ �븮�̸鼭 ASIA ������ �ٹ��ϴ� �������� ���, �����, ���޸�, �μ���, �ٹ�������, �޿��� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_ID "���"
         , E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�"
         , D.DEPT_TITLE "�μ���"
         , L.LOCAL_NAME "�ٹ�������"
         , E.SALARY "�޿�"
FROM EMPLOYEE E, DEPARTMENT D, JOB J, LOCATION L
WHERE E.JOB_CODE = J.JOB_CODE
    AND E.DEPT_CODE = D.DEPT_ID
    AND D.LOCATION_ID = L.LOCAL_CODE
    AND J.JOB_NAME = '�븮'
    AND L.LOCAL_NAME LIKE 'ASIA%';
    
-->> ANSI ����
SELECT E.EMP_ID "���"
         , E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�"
         , D.DEPT_TITLE "�μ���"
         , L.LOCAL_NAME "�ٹ�������"
         , E.SALARY "�޿�"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (E.DEPT_CODE = D.DEPT_ID)
JOIN JOB J ON (E.JOB_CODE = J.JOB_CODE)
JOIN LOCATION L ON (D.LOCATION_ID = L.LOCAL_CODE)
    WHERE J.JOB_NAME = '�븮'
    AND L.LOCAL_NAME LIKE 'ASIA%';

-- 2. 70�����̸鼭 �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_NAME "�����"
         , E.EMP_NO "�ֹι�ȣ"
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , J.JOB_CODE "���޸�" -- E.JOB_CODE = J.JOB_CODE
FROM EMPLOYEE E, DEPARTMENT D, JOB J
WHERE E.DEPT_CODE =D.DEPT_ID
    AND E.JOB_CODE = J.JOB_CODE
    AND TO_NUMBER(SUBSTR(E.EMP_NO, 1, 2), 99) BETWEEN 70 AND 79
    AND SUBSTR(E.EMP_NO, 8, 1) IN ('2', '4')
    AND E.EMP_NAME LIKE '��%';
    
-->> ANSI ����
SELECT E.EMP_NAME "�����"
         , E.EMP_NO "�ֹι�ȣ"
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , J.JOB_CODE "���޸�" -- E.JOB_CODE = J.JOB_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
WHERE TO_NUMBER(SUBSTR(E.EMP_NO, 1, 2), 99) BETWEEN 70 AND 79
    AND SUBSTR(E.EMP_NO, 8, 1) IN ('2', '4')
    AND E.EMP_NAME LIKE '��%';

-- 3. �̸��� '��'�ڰ� ����ִ� �������� ���, �����, ���޸��� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_ID "���"
         , E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
FROM EMPLOYEE E, JOB J
WHERE J.JOB_CODE = E.JOB_CODE
    AND E.EMP_NAME LIKE '%��%';

-->> ANSI ����
SELECT E.EMP_ID "���"
         , E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
    WHERE E.EMP_NAME LIKE '%��%';

-- 4. �ؿܿ������� �ٹ��ϴ� �������� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�"
         , D.DEPT_ID "�μ��ڵ�"
         , D.DEPT_TITLE "�μ���" -- J.JOB_CODE = E.JOB_CODE / D.DEPT_ID = E.DEPT_CODE
FROM EMPLOYEE E, JOB J, DEPARTMENT D
WHERE J.JOB_CODE = E.JOB_CODE
    AND D.DEPT_ID = E.DEPT_CODE
    AND D.DEPT_TITLE LIKE '�ؿܿ���%'
-->> ANSI ����
SELECT E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�"
         , D.DEPT_ID "�μ��ڵ�"
         , D.DEPT_TITLE "�μ���" -- J.JOB_CODE = E.JOB_CODE / D.DEPT_ID = E.DEPT_CODE
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
    WHERE D.DEPT_TITLE LIKE '�ؿܿ���%'

-- 5. ���ʽ��� �޴� �������� �����, ���ʽ�, ����, �μ���, �ٹ��������� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
 SELECT E.EMP_NAME "�����"
          , E.BONUS "���ʽ�"
          , E.SALARY * 12 "����"
          , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
          , L.LOCAL_NAME "�ٹ�������" -- L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L
WHERE D.DEPT_ID(+) = E.DEPT_CODE
-- (+): ���̴� ���� ���� �ݴ�! = ���� ���̺��� null ���� �����ؼ� ����� �ֶ�
    AND L.LOCAL_CODE(+) = D.LOCATION_ID
    AND E.BONUS IS NOT NULL;
-->> ANSI ����
 SELECT E.EMP_NAME "�����"
          , E.BONUS "���ʽ�"
          , E.SALARY * 12 "����"
          , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
          , L.LOCAL_NAME "�ٹ�������" -- L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E
LEFT JOIN DEPARTMENT D ON (E.DEPT_CODE =D.DEPT_ID)
LEFT JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
WHERE E.BONUS IS NOT NULL;


-- 6. �μ��� �ִ� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "�ٹ�������" --  L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E, JOB J, DEPARTMENT D, LOCATION L
WHERE J.JOB_CODE = E.JOB_CODE
    AND D.DEPT_ID = E.DEPT_CODE
    AND L.LOCAL_CODE = D.LOCATION_ID
    AND E.DEPT_CODE IS NOT NULL;
         -->> ANSI ����
SELECT E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "�ٹ�������" --  L.LOCAL_CODE = D.LOCATION_ID
FROM EMPLOYEE E
JOIN JOB J ON (J.JOB_CODE = E.JOB_CODE)
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
    WHERE E.DEPT_CODE IS NOT NULL;

-- 7. '�ѱ�' �� '�Ϻ�' �� �ٹ��ϴ� �������� �����, �μ���, �ٹ�������, �ٹ��������� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_NAME "�����"
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "�ٹ�������" -- L.LOCAL_CODE = D.LOCATION_ID
         , N.NATIONAL_NAME "�ٹ�������" -- N.NATIONAL_CODE = L.NATIONAL_CODE
FROM EMPLOYEE E, DEPARTMENT D, LOCATION L, NATIONAL N
WHERE D.DEPT_ID = E.DEPT_CODE
    AND L.LOCAL_CODE = D.LOCATION_ID
    AND N.NATIONAL_CODE = L.NATIONAL_CODE
    AND N.NATIONAL_NAME IN ('�ѱ�', '�Ϻ�');
-->> ANSI ����
SELECT E.EMP_NAME "�����"
         , D.DEPT_TITLE "�μ���" -- D.DEPT_ID = E.DEPT_CODE
         , L.LOCAL_NAME "�ٹ�������" -- L.LOCAL_CODE = D.LOCATION_ID
         , N.NATIONAL_NAME "�ٹ�������" -- N.NATIONAL_CODE = L.NATIONAL_CODE
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
JOIN LOCATION L ON (L.LOCAL_CODE = D.LOCATION_ID)
JOIN NATIONAL N ON (N.NATIONAL_CODE = L.NATIONAL_CODE)
    WHERE N.NATIONAL_NAME IN ('�ѱ�', '�Ϻ�');

-- 8. ���ʽ��� ���� �ʴ� ������ �� �����ڵ尡 J4 �Ǵ� J7 �� �������� �����, ���޸�, �޿��� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_NAME "�����"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , E.SALARY "�޿�"
FROM EMPLOYEE E, JOB J
WHERE J.JOB_CODE = E.JOB_CODE
    AND BONUS IS NULL
    AND E.JOB_CODE IN ('J4', 'J7');
-->> ANSI ����
SELECT EMP_NAME "�����"
         , JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , SALARY "�޿�"
FROM EMPLOYEE E
JOIN JOB USING (JOB_CODE)
    WHERE BONUS IS NULL
        AND JOB_CODE IN ('J4', 'J7');

-- 9. ���, �����, ���޸�, �޿���� (SAL_GRADE), ������ ��ȸ�ϴµ�
-- �� ��, ���п� �ش��ϴ� ����
-- �޿������ S1, S2 �� ��� '���'
-- �޿������ S3, S4 �� ��� '�߱�'
-- �޿������ S5, S6 �� ��� '�ʱ�' ���� ��ȸ�ǰ� �Ͻÿ�
-->> ����Ŭ ���� ����
SELECT E.EMP_ID "���"
         , J.JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , DECODE(S.SAL_LEVEL, 'S1', '���', 'S2', '���', 'S3', '�߱�', 'S4', '�߱�', 'S5', '�ʱ�',  '�ʱ�') -- S.SAL_LEVEL = E.SAL_LEVEL
FROM EMPLOYEE E, JOB J, SAL_GRADE S
WHERE J.JOB_CODE = E.JOB_CODE
    AND S.SAL_LEVEL = E.SAL_LEVEL;
-->> ANSI ����
SELECT EMP_ID "���"
         , JOB_NAME "���޸�" -- J.JOB_CODE = E.JOB_CODE
         , DECODE(SAL_LEVEL, 'S1', '���', 'S2', '���', 'S3', '�߱�', 'S4', '�߱�', 'S5', '�ʱ�',  '�ʱ�') -- S.SAL_LEVEL = E.SAL_LEVEL
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
JOIN SAL_GRADE USING (SAL_LEVEL)

-- 10. �� �μ��� �� �޿����� ��ȸ�ϵ� �� ��, �� �޿����� 1000���� �̻��� �μ���, �޿����� ��ȸ�Ͻÿ�
-->> ����Ŭ ���� ����
SELECT D.DEPT_TITLE "�μ���"
        , SUM(E.SALARY) "�޿���"
FROM EMPLOYEE E, DEPARTMENT D
WHERE D.DEPT_ID = E.DEPT_CODE
GROUP BY D.DEPT_TITLE
    HAVING SUM(E.SALARY) >= 10000000;
-->> ANSI ����
SELECT D.DEPT_TITLE "�μ���"
        , SUM(E.SALARY) "�޿���"
FROM EMPLOYEE E
JOIN DEPARTMENT D ON (D.DEPT_ID = E.DEPT_CODE)
GROUP BY D.DEPT_TITLE
    HAVING SUM(E.SALARY) >= 10000000;

-- 11. �� �μ��� ��ձ޿��� ��ȸ�Ͽ� �μ���, ��ձ޿� (����ó��) �� ��ȸ�Ͻÿ� ��, �μ���ġ�� �ȵ� ������� ��յ� ���� �����Բ� �Ͻÿ�
-->> ����Ŭ ���� ����
SELECT DEPT_TITLE "�μ���"
         , ROUND(AVG(SALARY),0) "��ձ޿�"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+)
GROUP BY DEPT_CODE, DEPT_TITLE(+);

-->> ANSI ����
SELECT DEPT_TITLE "�μ���"
         , ROUND(AVG(SALARY),0) "��ձ޿�"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE =DEPT_ID)
GROUP BY DEPT_CODE, DEPT_TITLE;