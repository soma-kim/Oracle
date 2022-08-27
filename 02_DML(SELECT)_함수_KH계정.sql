/*
    <�Լ� FUNCTION>
    �ڹٷ� ������ �޼ҵ�� ���� ����
    �Ű������� ���޵� ������ �о ���������� ����� ����� ����
    
    - ������ �Լ�: N���� ���� �о N���� ����� ���� (�� �ึ�� �Լ� ���� �� �� �࿡ ���� ����� ��� ��ȯ)
    - �׷� �Լ�: N���� ���� �о 1���� ����� ����(��� �࿡ ���� �ϳ��� �׷����� ��� �Լ� ���� �� ����� �ϳ��� ��ȯ)
    
    *������ ��: ������ �Լ��� �׷� �Լ��� �Բ� ����� �� ����
                    ���ʿ� ����� �� ������ �ٸ��� ������ ����!
*/

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <������ �Լ�>
    
    <���ڿ��� ���õ� �Լ�>
    LENGTH / LENGTHB
    
    - LENGTH(STR): �ش� ���޵� ���ڿ��� ���� �� ��ȯ
    - LENGTHB(STR): �ش� ���޵� ���ڿ��� ����Ʈ �� ��ȯ
    
    ������� NUMBER Ÿ������ ��ȯ
    STR: '���ڿ�' ���ͷ�/���ڿ� Ÿ���� �÷���
    
    ����Ŭ������ ���� ������
    ����, ����, Ư������: '!', '~', 'A', 'a', '1', ... => �� ���ڴ� 1BYTE�� ���
    �ѱ�: '��', '��', '��', '��', ... => �� ���ڴ� 3BYTE�� ���
*/

SELECT LENGTH('����Ŭ!'), LENGTHB('����Ŭ!')
FROM DUAL; -- DUAL ���̺� == ���� ���̺� == DUMMY TABLE
                   -- ��������̳� ���� �÷� ���� ���� �� �� ���� ����ϰ� ���� �� FROM���� �ۼ��ϴ� ���̺��
                   
SELECT EMAIL
        ,  LENGTH(EMAIL)
         , LENGTHB(EMAIL)
         , EMP_NAME
         , LENGTH(EMP_NAME)
         , LENGTHB(EMP_NAME)
FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <INSTR>
    
    - INSTR(STR): ���ڿ��κ��� Ư�� ������ ��ġ���� ��ȯ
    
    [ ǥ���� ]
    INSTR(STR, 'Ư������', ã����ġ�ǽ��۰�(��������), ����(��������))
    
    ������� NUMBER Ÿ������ ��ȯ
    ã�� ��ġ�� ���۰��� ������ ���� ����
    
    ã�� ��ġ�� ���۰�
     n : �տ��� n��°�������� ã�ڴ� (���� �� �⺻�� 1)
    -n : �ڿ��� n��°�������� ã�ڴ�
    => ex) 3 ���� �� 3��°(����)���� ã��
    => -n�� �����ϴ��� �տ������� ���� ���� �ֱ� ������ �� ������ "ã�� ����"�� ������ ���� �Ŷ�� �����ϸ� ���� ��
    
*/

SELECT INSTR('AABAACAABBAA', 'B')
FROM DUAL; -- 3: ã���� �ϴ� ��ġ, �� ��° �ش� ���ڸ� ã�� �������� ���� ������ ������� �ʾ�������
                   --    �⺻������ �տ������� ù ��° ������ ��ġ�� ã�� �ְ� ����
                   
SELECT INSTR('AABAACAABBAA', 'B', 1)
FROM DUAL; -- 3: �տ������� ù ��°�� ��ġ�ϴ� B�� ��ġ���� �˷� �ְ��� (1���� ���� ������)

SELECT INSTR('AABAACAABBAA', 'B', -1)
FROM DUAL; -- 10: �ڿ������� ù ��°�� ��ġ�ϴ� B�� ��ġ���� �˷� �ְ��� (�տ������� ���� ������)

SELECT INSTR('AABAACAABBAA', 'B', 1, 2)
FROM DUAL; -- 9: �տ������� �� ��°�� ��ġ�ϴ� B�� ��ġ���� �˷� �ְ���

SELECT INSTR('AABAACAABBAA', 'B', -1, 2)
FROM DUAL; -- 9: �ڿ������� �� ��°�� ��ġ�ϴ� B�� ��ġ���� �˷� �ְ���

SELECT INSTR('AABAACAABBAA', 'E', 1, 1)
FROM DUAL; -- 0: ���� ã���� �ϴ� ���� ���� ��� 0�� ��ȯ�� ��

-- ���� ���̺� ������ ����
-- EMAIL���� @�� ��ġ�� ã�ƺ���
SELECT EMAIL, INSTR(EMAIL, '@') AS "@�� ��ġ"
FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <SUBSTR>
    
    - SUBSTR(STR, POSITION, LENGTH): ���ڿ��κ��� Ư�� ���ڿ��� �����ؼ� ��ȯ
                                                      (�ڹٷ� ġ�� ���ڿ�.substring() �޼ҵ�� ����)
                                                      
    ������� CHARACTER Ÿ������ ��ȯ(���ڿ� ����)
    LENGTH�� ���� ����
 
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷���
    - POSITION: ���ڿ��� ������ ���� ��ġ�� (������ ���� ����), POSITION���� ��ġ���� ����
    - LENGTH: ������ ������ ���� (���� �� ������ ����)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7)
FROM DUAL; -- THEMONEY: ���� ��ġ�� 1���� �����ؼ� ��

SELECT SUBSTR('SHOWMETHEMONEY', 5, 2)
FROM DUAL; -- ME

SELECT SUBSTR('SHOWMETHEMONEY', 1, 6)
FROM DUAL; -- SHOWME

SELECT SUBSTR('SHOWMETHEMONEY', -8, 3)
FROM DUAL; -- THE: ���� ��ġ�� ������ ��� �ڿ������� N��° ��ġ�κ��� ���ڸ� �����ϰڴٴ� ��

-- �ֹι�ȣ���� ���� �κ��� �����ؼ� ����(1), ����(2)�� üũ
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "����"
FROM EMPLOYEE;

-- ���� ������� �����, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
-- WHERE SUBSTR(EMP_NO, 8, 1) = '1' OR SUBSTR(EMP_NO, 8, 1) = '3'; 
WHERE SUBSTR(EMP_NO, 8, 1) IN ('1', '3');

-- ���� ����鸸 ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
-- WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');
WHERE SUBSTR(EMP_NO, 8, 1) NOT IN ('1', '3');

-- EMAIL���� ID�κи� �����ؼ� ��ȸ
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@') - 1) "ID"
FROM EMPLOYEE;
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <LPAD / RPAD>
    - LPAD/RPAD(STR, ���������ι�ȯ�ҹ����Ǳ���(����Ʈ), �����̰����ϴ¹���)
    : ������ ���ڿ��� ������ ���ڿ��� ����(LPAD) �Ǵ� ������(RPAD)�� ���ٿ��� ���� N ���̸�ŭ�� ���ڿ��� ��ȯ
    
    ������� CHARACTER Ÿ������ ��ȯ
    �����̰��� �ϴ� ���ڴ� ���� ����
    
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ���� �÷���
*/

SELECT LPAD(EMAIL, 16, ' ') -- �����̰��� �ϴ� ���� ���� �� �⺻���� ����
FROM EMPLOYEE;

SELECT RPAD(EMAIL, 20, '#') -- �����̰��� �ϴ� ���� ���� �� �⺻���� ����
FROM EMPLOYEE; -- bang_ms@kh.or.kr####

-- 850918-2******* �ֹε�Ϲ�ȣ ��ȸ => �� 6�ڸ��� ������� �ʵ��� ����ŷ �� ���� �� ��
-- 1�ܰ�. SUBSTR�� �̿��ؼ� �ֹι�ȣ �� 8�ڸ����� ����
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, 8)
FROM EMPLOYEE;

-- 2�ܰ�. RPAD�� ��ø�Ͽ� �ֹι�ȣ �� 6�ڸ��� *�� ���̱�
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*')
FROM EMPLOYEE;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <LTRIM / RTRIM>
    
    - LTRIM / RTRIM(STR, ���Ž�Ű�����ϴ¹���)
    : ���ڿ��� ���� �Ǵ� �����ʿ��� ���Ž�Ű���� �ϴ� ���ڵ��� ã�Ƽ� ������ ������ ���ڿ��� ��ȯ
    
    ������� CHARACTER Ÿ������ ��ȯ
    ���Ž�Ű���� �ϴ� ���ڴ� ���� ���� (���� �� �⺻���� �������� ������)
    
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷���
*/

SELECT LTRIM('        K      H')
FROM DUAL; -- K      H

SELECT RTRIM('        K      H       ')
FROM DUAL; --         K      H

SELECT LTRIM('0001230456000', '0')
FROM DUAL; --1230456000

SELECT LTRIM('123123KH123', '123')
FROM DUAL; --KH123

SELECT LTRIM('ACABACCKH', 'ABC')
FROM DUAL; --KH
--> ���Ž�Ű���� �ϴ� ���ڿ��� ������ ���� �ִ� �� �ƴ϶� ���� �ϳ��ϳ��� ���ؼ� �����ϸ� �� ���� �ִ� ����
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <TRIM>
    
    - TRIM(BOTH/LEADING/TRAILING '���Ž�Ű�����ϴ¹���' FROM STR)
    : ���ڿ��� ����/����/���ʿ� �ִ� Ư�� ���ڸ� ������ ������ ���ڿ��� ��ȯ
    
    ������� CHARACTER Ÿ������ ��ȯ
    BOTH/LEADING/TRAILING�� ���� ����! ��, ���� �� �⺻�� BOTH
    
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷���
*/

-- ����: TRIM�� ����� �ִ� ���ڴ� ���� ���� (REPLACE Ȱ��)
SELECT TRIM('      K              H       ') -- BOTH ' ' FROM '      K              H       '�� ���� �ǹ�
FROM DUAL; -- K              H

SELECT TRIM('Z' FROM 'ZZZKHZZZ')
FROM DUAL; -- KH

SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ') --- LEADING ���� ����( == LTRIM)
FROM DUAL; -- KHZZZ

SELECT TRIM(TRAILING 'Z' FROM 'ZZZKHZZZ') --- LEADING ���� ����( == LTRIM)
FROM DUAL; -- ZZZKH
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <LOWER / UPPER / INITCAP>
    
    - LOWER(STR): �� �ҹ��ڷ� ����
    - UPPER(STR): �� �빮�ڷ� ����
    - INITCAP(STR): ���� �������� �� �ܾ� �ձ��ڸ� �빮�ڷ� ����
    
    ������� CHARACTER Ÿ������ ����
    
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷���
*/

SELECT LOWER('Welcome To My World!')
FROM DUAL;

SELECT UPPER('Welcome To My World!')
FROM DUAL;

SELECT INITCAP('Welcome To My World!')
FROM DUAL;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <CONCAT>
    
    - CONCAT(STR1, STR2)
    : ���޵� �� ���� ���ڿ��� �ϳ��� ��ģ ����� ��ȯ
    
    ������� CHARACTER Ÿ������ ��ȯ
    
    - STR1, STR2: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷�
*/

SELECT CONCAT('������', 'ABC')
FROM DUAL; -- ������ABC

SELECT '������' || 'ABC'
FROM DUAL; -- ������ABC

SELECT CONCAT('������', 'ABC', '123')
FROM DUAL;
--> ����: CONCAT �Լ��� �� ���� �� ���� ���ڿ��� ��ġ�� ���� ����

SELECT CONCAT(CONCAT('������', 'ABC'), '123')
FROM DUAL; -- ������ABC123
--> ���� ���� ���� ���ڿ��� ��ĥ �� CONCAT�� �̿��ؾ� �Ѵٸ� ��ø�ؼ� ��� ����
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <REPLACE>
    
    - REPLACE(STR, ã������, �ٲܹ���)
    : STR�κ��� ã�� ���ڸ� ã�Ƽ� �ٲ� ���ڷ� �ٲ� ���ڿ��� ��ȯ
    
    ������� CHARACTER Ÿ������ ��ȯ
    
    - STR: '���ڿ�' ���ͷ� / ���ڿ� Ÿ�� �÷�
*/

SELECT REPLACE('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��')
FROM DUAL; -- ����� ������ �Ｚ��

SELECT EMP_NAME, EMAIL, REPLACE(EMAIL, 'kh.or.kr', 'ioi.or.kr')
FROM EMPLOYEE;

-- ����: TRIM�� ����� �ִ� ���ڴ� ���� ���� (REPLACE Ȱ��)
SELECT REPLACE('      K              H       ', ' ', '') 
FROM DUAL; -- KH
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <���ڿ� ���õ� �Լ�>
    
    <ABS>
    
    - ABS(NUMBER): ���밪�� ���� �ִ� �Լ�
*/

SELECT ABS(-10)
FROM DUAL; -- 10

SELECT ABS(-10.9)
FROM DUAL; -- 10.9
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <MOD>
    - MODULER�� ���ڷ� �������� ���� �ִ� �Լ�
    
    - MOD(NUMBER1, NUMBER2): �� ���� ���� ������ ���� ��ȯ�� �ִ� �Լ�
*/

SELECT MOD(10, 3)
FROM DUAL; -- 1

SELECT MOD(-10, 3)
FROM DUAL; -- -1

SELECT MOD(-10.9, 3)
FROM DUAL; -- -1.9
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <ROUND>
    - ROUND(NUMBER, ��ġ��): �ݿø� ó���� �ִ� �Լ�
    
    ��ġ: �Ҽ��� �Ʒ� N��° ������ �ݿø�
    ��ġ���� ���� ����! ��, ��ġ ���� �� �⺻���� 0, ��ġ���� �����ε� ���� ����
*/

SELECT ROUND(123.456)
FROM DUAL; -- 123 

SELECT ROUND(123.456, 1)
FROM DUAL; -- 123.5

SELECT ROUND(123.456, 2)
FROM DUAL; -- 123.46

SELECT ROUND(123.456, 3)
FROM DUAL; -- 123.456, 3��°���� ��Ÿ���� �ϹǷ� ������ �� �״��

SELECT ROUND(123.456, 4)
FROM DUAL; -- 123.456, ������ ��ġ�� �����Ƿ� ������ �� �״��

SELECT ROUND(123.456, -1)
FROM DUAL; -- 120

SELECT ROUND(123.456, -2)
FROM DUAL; -- 100
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <CEIL>
    
    - CEIL(NUMBER): �Ҽ��� �Ʒ��� ���� ������ �ø� ó�� �� �ִ� �Լ�
    
    - ��ġ�� ���� �Ұ�!
*/

SELECT CEIL(123.156)
FROM DUAL; -- 124

SELECT CEIL(249.012)
FROM DUAL; -- 250
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <FLOOR>
    
    - FLOOR(NUMBER): �Ҽ��� �Ʒ��� ���� ������ ���� ó�� �� �ִ� �Լ�
    
    - ��ġ�� ���� �Ұ�!
*/

SELECT FLOOR(123.956)
FROM DUAL; -- 123

SELECT FLOOR(207.68)
FROM DUAL; -- 207

-- �� �������� ����Ϸκ��� ���ñ��� �ٹ��ϼ��� ��ȸ
-- �ٹ��ϼ� = ���ó�¥ - �����
SELECT EMP_NAME, CONCAT(FLOOR(SYSDATE - HIRE_DATE), '��') AS "�ٹ��ϼ�"
FROM EMPLOYEE;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <TRUNC>
    
    - TRUNC(NUMBER, ��ġ��): ��ġ ���� ������ ���� ó���� �� �ִ� �Լ�
    
    ��ġ�� ���� ����! ��, ���� �� �⺻���� 0 (== FLOOR �Լ��� ���� ����)

*/

SELECT TRUNC(123.756)
FROM DUAL; -- 123

SELECT TRUNC(123.756, 1)
FROM DUAL; -- 123.7

SELECT TRUNC(123.756, -1)
FROM DUAL; -- 120
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <��¥ ���� �Լ�>
    
    DATE Ÿ���� �ٷ�� �Լ���
    DATEŸ��: "��, ��, ��, ��, ��, ��"�� �� ������ �ڷ���
*/

-- SYSDATE: ���� �� DB�� ��� �ִ� ��ǻ�� �ý��� �������� ��¥
SELECT SYSDATE
FROM DUAL; -- 22/08/24 �������� ���(��¥�ν�)

SELECT '22/08/24'
FROM DUAL; -- 22/08/24 �������� ���(���ڿ��ν�)

-- MONTHS_BETWEEN(DATE1, DATE2): �� ��¥ ������ ���� ���� ��ȯ�� �ִ� �Լ�
-- �� �������� ����Ϸκ��� ���ñ����� �ٹ� �� ���� �ٹ� ���� ���� ��ȸ
SELECT EMP_NAME
         , FLOOR(SYSDATE - HIRE_DATE) || '��' AS "�ٹ��ϼ�"
         , FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) || '����' AS "�ٹ�������"
FROM EMPLOYEE;
--> �� ��¥ ������ ���� ���� ���� Ÿ������ ��ȯ�� �ֵ�,
--   ù ��° �Ű������� �ش�Ǵ� DATE1 �κ��� �� ������ ��� ������ ����� ����!

-- ADD_MONTHS(DATE, NUMBER): Ư�� ��¥�� �ش� ���ڸ�ŭ�� ���� ���� ���� ��¥�� ��ȯ�� �ִ� �޼ҵ� (DATE Ÿ�� ��ȯ)
-- ���� ��¥�κ��� 5���� ��
SELECT ADD_MONTHS(SYSDATE, 5)
FROM DUAL;

-- ���� ��¥�κ��� 1���� ��(���� ���� ����)
SELECT ADD_MONTHS(SYSDATE, -1)
FROM DUAL;

-- ��ü ������� ������, �Ի���, �Ի� �� 6������ �귶�� ���� ��¥
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 6) AS "�Ի� �� 6����"
FROM EMPLOYEE;

-- NEXT_DAY(DATE, ����(����/����)): Ư�� ��¥���� ���� ����� �ش� ������ ã�Ƽ� �� ��¥�� ��ȯ
SELECT NEXT_DAY(SYSDATE, '�Ͽ���')
FROM DUAL; -- 22/08/28

SELECT NEXT_DAY(SYSDATE, '��')
FROM DUAL; -- 22/08/28

-- 1: �Ͽ���, 2: ������, 3: ȭ����, ... , 6: �ݿ���, 7: �����
SELECT NEXT_DAY(SYSDATE, 1)
FROM DUAL; -- 22/08/28

-- ���� �� �ý��ۿ� ������ �� KOREAN�̱� ������ ������ �߻�
SELECT NEXT_DAY(SYSDATE, 'SUNDAY')
FROM DUAL;

-- ��� ����
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;

SELECT NEXT_DAY(SYSDATE, 'SUNDAY')
FROM DUAL;

SELECT NEXT_DAY(SYSDATE, '��')
FROM DUAL; -- 22/08/28

ALTER SESSION SET NLS_LANGUAGE = KOREAN;

SELECT NEXT_DAY(SYSDATE, '��')
FROM DUAL; -- 22/08/28

-- LAST_DAY(DATE): �ش� Ư�� ��¥ ���� ������ ��¥�� ���ؼ� ��ȯ�� �ִ� �Լ� (DATE Ÿ�� ��ȯ)
SELECT LAST_DAY(SYSDATE)
FROM DUAL;

-- ������, �Ի���, �Ի��� ���� ������ ��¥ ��ȸ
SELECT EMP_NAME, HIRE_DATE, LAST_DAY(HIRE_DATE)
FROM EMPLOYEE;

/*
    EXTRACT: �⵵ �Ǵ� �� �Ǵ� �� ������ �����ؼ� ��ȯ(NUMBER Ÿ�� ��ȯ)
    
    - EXTRACT(YEAR FROM DATE): Ư�� ��¥�κ��� �⵵�� ����
    - EXTRACT(MONTH FROM DATE): Ư�� ��¥�κ��� ���� ����
    - EXTRACT(DAY FROM DATE): Ư�� ��¥�κ��� �ϸ� ����
*/

 SELECT EXTRACT(YEAR FROM SYSDATE) -- ���� ��¥ ���� �⵵ ����
          , EXTRACT(MONTH FROM SYSDATE) -- ���� ��¥ ���� �� ����
          , EXTRACT(DAY FROM SYSDATE) -- ���� ��¥ ���� �� ����
FROM DUAL;

-- �����, �Ի�⵵, �Ի��, �Ի��� ��ȸ
SELECT EMP_NAME
         , EXTRACT(YEAR FROM HIRE_DATE) || '��' AS "�Ի�⵵"
         , EXTRACT(MONTH FROM HIRE_DATE) || '��' AS "�Ի��"        
         , EXTRACT(DAY FROM HIRE_DATE) || '��' AS "�Ի���"
FROM EMPLOYEE
ORDER BY "�Ի�⵵", "�Ի��", "�Ի���";
--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <����ȯ �Լ�>
    
    NUMBER/DATE => CHARACTER
    
    -TO_CHAR(NUMBER/DATE, '����'_
    : ������ �Ǵ� ��¥�� �����͸� ������ Ÿ������ ��ȯ (CHARACTER Ÿ�� ��ȯ)
*/

SELECT TO_CHAR(1234)
FROM DUAL; -- 1234 (����) => '1234' (���ڿ�)

SELECT TO_CHAR(1234, '00000')
FROM DUAL; -- 1234 (����) => '01234' (���ڿ�): ��ĭ�� 0���� ä�� �ִ� ����

SELECT TO_CHAR(1234, '99999')
FROM DUAL; -- 1234 (����) => '1234' (���ڿ�): ��ĭ�� ä���� �ʴ� ����

SELECT TO_CHAR(1234, 'L00000')
FROM DUAL; -- 1234 (����) => \01234 (���ڿ�): ���� ������ ����(LOCAL)�� ȭ�� ������ �ٿ� �ִ� ����

SELECT TO_CHAR(1234, 'L99999')
FROM DUAL; -- 1234 (����) => \1234 (���ڿ�)

-- ���࿡ �޷��� ǥ���ϰ� �ʹٸ�?
SELECT TO_CHAR(1234, '$99999')
FROM DUAL; -- 1234 (����) => $1234 (���ڿ�)

-- �ݾװ� ���� ū ������ ��� 3�ڸ����� ,�� �����ؼ� ���
SELECT TO_CHAR(1234, 'L99,999')
FROM DUAL; -- 1234 (����) => \1,234 (���ڿ�): 3�ڸ����� ,�� ������ �ִ� ����

-- �޿� ������ 3�ڸ����� ,�� �����Ͽ� ���
SELECT EMP_NAME, TO_CHAR(SALARY, 'L999,999,999') "�޿�����"
FROM EMPLOYEE
ORDER BY �޿�����;

-- DATE(����Ͻú���) => CHARACTER
SELECT SYSDATE
FROM DUAL;

SELECT TO_CHAR(SYSDATE)
FROM DUAL; -- '22/08/24' (���ڿ�)

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
FROM DUAL; -- '2022-08-24'

SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') -- AM �Ǵ� PM: ����/���� �Ǻ��ؼ� ����϶�� �ǹ�����, AM�̶�� ����, PM�̶�� ���� ���� ������ �ƴ�!
FROM DUAL; -- '���� 03:39:26'

SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS')
FROM DUAL; -- '15:41:51'

SELECT TO_CHAR(SYSDATE, 'MON DY, YYYY') -- MON: N��, DY: '����'�� �� ������ ����
FROM DUAL; -- '8�� ��, 2022'

-- �⵵�ν� �� �� �ִ� ����
SELECT TO_CHAR(SYSDATE, 'YYYY') -- 2022
         , TO_CHAR(SYSDATE, 'RRRR') -- 2022
         , TO_CHAR(SYSDATE, 'YY') -- 22
         , TO_CHAR(SYSDATE, 'RR') -- 22
         , TO_CHAR(SYSDATE, 'YEAR') -- TWENTY TWENTY-TWO
FROM DUAL;

-- ���ν� �� �� �ִ� ����
SELECT TO_CHAR(SYSDATE, 'MM') -- 08
         , TO_CHAR(SYSDATE, 'MON') -- 8��
         , TO_CHAR(SYSDATE, 'MONTH') -- 8��
         , TO_CHAR(SYSDATE, 'RM') -- VIII, �θ� ���ڷ� ���� ����� �ִ� ����
FROM DUAL;

-- �Ϸν� �� �� �ִ� ����
SELECT TO_CHAR(SYSDATE, 'D') -- 4, 1���� �������� (�Ͽ��Ϻ���) ��ĥ�� �귶���� �˷� �ִ� ����
         , TO_CHAR(SYSDATE, 'DD') -- 24, 1�� �������� (�ش� ���� 1�Ϻ���) ��ĥ�� �귶���� ��ȯ�� �ִ� ����
         , TO_CHAR(SYSDATE, 'DDD') -- 236, 1�� �������� (�ش� �⵵�� 1�� 1�Ϻ���) ��ĥ�� �귶���� ��ȯ�� �ִ� ����
FROM DUAL;

-- ���Ϸν� �� �� �ִ� ����
SELECT TO_CHAR(SYSDATE, 'DY') -- ��, DY���� '����'�� �� �������� ����� �ִ� ����
         , TO_CHAR(SYSDATE, 'DAY') -- ������, DAY�� '����'�� ���� �������� ����� �ִ� ����
FROM DUAL;

-- 2022�� 08�� 24�� (��) �������� �����Ű�� ����
SELECT TO_CHAR(SYSDATE, 'YYYY"��" MM"��" DD"��" "("DY")"')
FROM DUAL; -- ������ �ƴ� �ٸ� ���ڶ� ���� ������ �� ��� ""�� ���� ��

-- �����, �Ի���(���� ���� ����) ��ȸ
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��" "("DY")"') AS "�Ի���"
FROM EMPLOYEE;

-- 2010�� ���Ŀ� �Ի��� ������� �����, �Ի���(���� ���� ����) ��ȸ
SELECT EMP_NAME, TO_CHAR(HIRE_DATE, 'YYYY"��" MM"��" DD"��" "("DY")" ') AS "�Ի���"
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE) >= 2010;
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <NUMBER/CHARACTER => DATE>
    
    - TO_DATE(NUMBER/CHARACTER, '����'): ������ �Ǵ� ������ �����͸� ��¥������ ��ȯ�� �ִ� �Լ� (DATE Ÿ�� ��ȯ)
*/

SELECT TO_DATE(20210101)
FROM DUAL; -- �⺻ ������ YY/MM/DD�� ��ȯ��

SELECT TO_DATE('20210101')
FROM DUAL; -- YY/MM/DD

-- ������ ��: �Ű������� NUMBER Ÿ���� �ѱ� ��� 0���� �����ϴ� �⵵�� �ݵ�� ���ڿ� Ÿ������ �Ѱ� ��� ��
SELECT TO_DATE(000101) -- 000101�� 0���� �����ϴ� ���ڷ� �ν��Ͽ� ���� �߻�
FROM DUAL;

SELECT TO_DATE('000101')
FROM DUAL; -- YY/MM/DD

SELECT TO_DATE('20100101', 'YYYYMMDD')
FROM DUAL; -- YY/MM/DD �������� ���� (�� ���� ��ư ��������)

SELECT TO_DATE('041030 143021', 'YYMMDD HH24MISS')
FROM DUAL; -- YY/MM/DD �������� ����

-- ������ ��: YY�� RR�� ������
SELECT TO_DATE('140630', 'YYMMDD')
FROM DUAL; -- 2014�⵵

SELECT TO_DATE('980630', 'YYMMDD')
FROM DUAL; -- 2098�⵵
-- TO_DATE �Լ��� �̿��ؼ� DATE �������� ��ȯ ��
-- �� �ڸ� �⵵�� ���� YY ������ ������ ��� => ������ ���� ����

SELECT TO_DATE('140630', 'RRMMDD')
FROM DUAL; -- 2014�⵵

SELECT TO_DATE('980630', 'RRMMDD')
FROM DUAL; -- 1998�⵵
-- TO_DATE �Լ��� �̿��ؼ� DATE �������� ��ȯ ��
-- �� �ڸ� �⵵�� ���� RR ������ ������ ��� => 50 �̻��̸� ���� ����, 50 �̸��̸� ���� �����

--------------------------------------------------------------------------------------------------------------------------------------------

/*
    <CHARACTER => NUMBER>
    
    - TO_NUMBER(CHARACTER, '����'): ������ �����͸� ���������� ��ȯ (NUMBER Ÿ�� ��ȯ)
*/

-- �ڵ�����ȯ �Ǵ� ����
SELECT '123' + '123'
FROM DUAL; -- 246: �ڵ�����ȯ �� ���������� ����

-- �ڵ�����ȯ�� �� �Ǵ� ����
SELECT '10,000,000' + '550,000'
FROM DUAL; -- ����(,)�� ���ԵǾ� �ֱ� ������ �ڵ�����ȯ�� �� ��
--> �̷� ��쿡 ����� �� �ִ� �Լ��� TO_NUMBER

-- ���� ���ø� TO_NUMBER �Լ��� �̿��Ͽ� ���� => ��������ȯ
SELECT TO_NUMBER('10,000,000', '99,999,999') + TO_NUMBER('550,000', '999,999')
FROM DUAL; -- 10550000

-- ���� ���� ����� 10,550,000 �̷��� ���� �ʹٸ�?
SELECT TO_CHAR(TO_NUMBER('10,000,000', '99,999,999') + TO_NUMBER('550,000', '999,999'), '99,999,999')
FROM DUAL; -- 10,550,000

-- 0123?
SELECT TO_NUMBER('0123')
FROM DUAL; -- 123
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <NULL ó�� �Լ�>
*/

-- NVL(�÷���, �ش��÷�����NULL�ϰ���ȯ�Ұ����)
--: �ش� �÷����� ������ ��� ������ �÷����� �״�� ��ȯ, �ش� �÷����� NULL�� ��� ���� ������ ������� ��ȯ

-- �����, ���ʽ�, ���ʽ��� ���� ��� 0���� ���
SELECT EMP_NAME, BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

-- ���ʽ� ���� ������ ��ȸ
-- SELECT EMP_NAME, NVL((SALARY + (SALARY  * BONUS)) * 12, SALARY * 12)
SELECT EMP_NAME, (SALARY + (SALARY  * NVL(BONUS, 0))) * 12
FROM EMPLOYEE;

-- �����, �μ��ڵ�(�μ��ڵ尡 ���� ��� '����') ��ȸ
SELECT EMP_NAME, NVL(DEPT_CODE, '����')
FROM EMPLOYEE;

-- NLV2(�÷���, �����1, �����2)
--: �ش� �÷����� ������ ��� �����1�� ��ȯ, �ش� �÷����� NULL�� ��� �����2�� ��ȯ

-- �����, ���ʽ�, ���ʽ��� �ִ� ��� 0.7�� �λ�, ���ʽ��� ���� ��� 0 ���
SELECT EMP_NAME, BONUS, NVL2(BONUS, 0.7, 0)
FROM EMPLOYEE;

-- �����, �μ��ڵ�(�μ��ڵ尡 �ִ� ��� '�μ���ġ�Ϸ�', ���� ��� '�μ���ġ�̿Ϸ�') ��ȸ
SELECT EMP_NAME, DEPT_CODE, NVL2(DEPT_CODE, '�μ���ġ�Ϸ�', '�μ���ġ�̿Ϸ�')
FROM EMPLOYEE;

-- NULLIF(�񱳴��1, �񱳴��2)
--: �� �Ű������� ���� ��ġ�� ��� NULL ��ȯ, �� �Ű������� ���� ��ġ���� ���� ��� �񱳴��1 ��ȯ

SELECT NULLIF('123', '123')
FROM DUAL; -- (NULL)

SELECT NULLIF('123', '456')
FROM DUAL; -- 123
--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <���� �Լ�>
    
    DECODE(�񱳴��(�÷���/�������/�Լ���), ���ǰ�1, �����1, ���ǰ�2, �����2, ..., �����)
    
    - �ڹٿ����� switch���� ���� (����񱳸� �� �ִ� ���ǹ�)
    switch(�񱳴��) {
        case ���ǰ�1 : �����1; break;
        case ���ǰ�2 : �����2; break;
        ...
        default : �����;
    }
*/

-- ���, �����, ����(�ֹε�Ϲ�ȣ�κ��� ���� �ڸ��� ����)
SELECT EMP_ID, EMP_NAME, DECODE(SUBSTR(EMP_NO, 8, 1), '1', '��'
                                                                                    , '2' ,'��'
                                                                                    , '3', '��'
                                                                                    , '4', '��') "����"
FROM EMPLOYEE;

-- �������� �޿��� �λ���Ѽ� ��ȸ
-- �����ڵ尡 'J7'�� ����� �޿��� 10% �λ��ؼ� ��ȸ
-- �����ڵ尡 'J6'�� ����� �޿��� 15% �λ��ؼ� ��ȸ
-- �����ڵ尡 'J5'�� ����� �޿��� 20% �λ��ؼ� ��ȸ
-- �� �̿��� �����ڵ��� ����� �޿��� 5% �λ��ؼ� ��ȸ
SELECT EMP_NAME, JOB_CODE, SALARY, DECODE(JOB_CODE, 'J7', SALARY * 1.1
                                                                                    , 'J6', SALARY * 1.15
                                                                                    , 'J5', SALARY * 1.2
                                                                                    , SALARY * 1.05) "�λ�ȱ޿�"
FROM EMPLOYEE;

/*
    <CASE WHEN THEN ����>
    -- DECODE �����Լ��� ���ϸ� DECODE�� �ش� ���� �˻� �� ����񱳸��� �����Ѵٸ�
        CASE WHEN THEN ������ Ư�� ���� ���� �� �� ������� ���ǽ��� ��� ����
        
        - �ڹٿ����� if-else if�� ���� ����
        if(���ǽ�1) {
            �����ұ���;
        }
        else if(���ǽ�2) {
            �����ұ���;
        } else {
            �����ұ���;
        }
        
        [ ǥ���� ]
        CASE WHEN ���ǽ�1 THEN �����1
                WHEN ���ǽ�2 THEN �����2
                ...
                ELSE �����
        END   
*/

-- ���, �����, �ֹι�ȣ�κ��� ������ ����(DECODE�Լ�)
SELECT EMP_ID
         , EMP_NAME
         , DECODE(SUBSTR(EMP_NO, 8,1), '1', '��'
                                                     , '2', '��'
                                                     , '3', '��'
                                                     , '4', '��') "����"
FROM EMPLOYEE;

-- CASE WHEN THEN ���� ����
SELECT EMP_ID
         , EMP_NAME
         , CASE WHEN SUBSTR(EMP_NO, 8,1) = '1' THEN '��'
                   WHEN SUBSTR(EMP_NO, 8,1) = '2' THEN '��'
                   WHEN SUBSTR(EMP_NO, 8,1) = '3' THEN '��'
                   WHEN SUBSTR(EMP_NO, 8,1) = '4' THEN '��'
            END "����"
FROM EMPLOYEE;

-- ����� ���� �ٿ� ����
SELECT EMP_ID
         , EMP_NAME
         , CASE WHEN SUBSTR(EMP_NO, 8,1) = '1' OR SUBSTR(EMP_NO, 8,1) = '3' THEN '��'
                    WHEN SUBSTR(EMP_NO, 8,1) = '2' OR SUBSTR(EMP_NO, 8,1) = '4' THEN '��'
            END "����"
FROM EMPLOYEE;

-- ����� ���� �ٿ� ���� (IN ����� ����)
SELECT EMP_ID
         , EMP_NAME
         , CASE WHEN SUBSTR(EMP_NO, 8,1) IN ('1', '3') THEN '��'
                   WHEN SUBSTR(EMP_NO, 8,1) IN ('2', '4') THEN '��'
            END "����"
FROM EMPLOYEE;

-- ����� ���� �ٿ� ����
SELECT EMP_ID
         , EMP_NAME
         , CASE WHEN SUBSTR(EMP_NO, 8,1) IN ('1' , '3') THEN '��'
                    ELSE '��'
           END "����"
FROM EMPLOYEE;

-- �����, �޿�, �޿���� (���, �߱�, �ʱ�)
-- SALARY ���� 500���� �ʰ��� ��� '���'
--                   500���� ���� 350���� �ʰ��� ��� '�߱�'
--                   350���� ������ ��� '�ʱ�'

SELECT EMP_NAME
         , SALARY
         , CASE WHEN SALARY > 5000000 THEN '���'
                   WHEN SALARY > 3500000 THEN '�߱�'
                    ELSE '�ʱ�'
         END "�޿����"
FROM EMPLOYEE
WHERE SALARY > 5000000 -- ��޸� ���ڴ�
ORDER BY SALARY DESC; -- ������ ���� ������� ���ڴ�

--------------------------------------------------------------------------------------------------------------------------------------------
/*
    <�׷� �Լ�>
    
    �׷� �Լ�: n���� ���� �о 1���� ����� ��ȯ (�ϳ��� �׷캰�� �Լ� ���� ��� ��ȯ)
*/

-- 1. SUM(����Ÿ���÷���): �ش� �÷������� �� �հ踦 ���ؼ� ��ȯ�� �ִ� �Լ� (NUMBER Ÿ�� ��ȯ)
-- ��ü ������� �� �޿� �հ�
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- �μ� �ڵ尡 'D5'�� ������� �� �޿� �հ�
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- ���� ����� �� �޿� ��
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN('1', '3');

--------------------------------------------------------------------------------------------------------------------------------------------
-- 2. AVG(����Ÿ���÷���): �ش� �÷������� ��հ��� ���ؼ� ��ȯ�� �ִ� �Լ� (NUMBER Ÿ�� ��ȯ)
-- ��ü ������� ��� �޿�
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- ��ü ������� ��� �޿�(�ݿø�)
SELECT ROUND(AVG(SALARY))
FROM EMPLOYEE;

--------------------------------------------------------------------------------------------------------------------------------------------
-- 3. MIN(�ƹ�Ÿ���÷���): �ش� �÷����� �� ���� ���� ���� ��ȯ�� �ִ� �Լ�(�Ű������� Ÿ���� ��ȯ)
-- ��ü ����� �� �����޿�, ���� ���� �̸���, ���� ���� �̸��ϰ�, ���� ������ �Ի��� ��¥ ���ϱ�
SELECT MIN(SALARY) "�����޿�"
         , MIN(EMP_NAME) "���������̸�"
         , MIN(EMAIL) "���������̸���"
         , MIN(HIRE_DATE) "���������Ի���"
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
ORDER BY HIRE_DATE ASC; -- ���忹���Ի��� ~ �����ֱ��Ի��� ������ ��µ�
--> MIN �Լ��� ����: �ش� �÷����� �������� �������� �������� �� ���� ���ʿ� ������ ���� ����

--------------------------------------------------------------------------------------------------------------------------------------------
-- 4. MAX(�ƹ�Ÿ���÷���): �ش� �÷����� �� ���� ū ���� ��ȯ�� �ִ� �Լ�(�Ű������� Ÿ���� ��ȯ)
-- ��ü ����� �� �ְ�޿�, ���� ū �̸���, ���� ū �̸��ϰ�, ���� �ֱ� �Ի��� ���ϱ�
SELECT MAX(SALARY) "�ְ�޿�"
         , MAX(EMP_NAME) "����ū�̸���"
         , MAX(EMAIL) "����ū�̸��ϰ�"
         , MAX(HIRE_DATE) "����ū�Ի���"
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
ORDER BY EMP_NAME DESC;
--> MAX �Լ��� ����: �ش� �÷����� �������� �������� �������� �� ���� ���ʿ� ������ ���� ����

--------------------------------------------------------------------------------------------------------------------------------------------
-- 5. COUNT(*/�÷���/DISTINCT �÷���): ��ȸ�� ���� ������ ��ȯ�� �ִ� �Լ�(NUMBER Ÿ�� ��ȯ)
-- COUNT(*): ��ȸ ����� �ش�Ǵ� ��� �� ������ �� ���� ��ȯ
-- COUNT(�÷���): ������ �ش� �÷����� NULL�� �ƴ� �͸� �� ������ ���� ��ȯ
-- COUNT(DISTINCT �÷���): ������ �ش� �÷����� �ߺ����� ���� ��� �� ���θ� ������ ���� ��ȯ (NULL ���� X)

-- ��ü ��� �� ��ȸ
SELECT COUNT(*)
FROM EMPLOYEE;

-- ���� ��� �� ��ȸ
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN('2', '4');

-- �μ� ��ġ�� �� ���(DEPT_CODE ���� ����) ��
-- ��� 1) ��ü ���� ī��Ʈ�ϰ� NULL ���� ī��Ʈ���� ���� ���
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL;

-- ��� 2) ���ʿ� ī��Ʈ �� NUILL�� ���� ī��Ʈ�ϴ� ���
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;

-- �μ� ��ġ�� �� ���(DEPT_CODE ���� ����) ���� ��� ��
-- ��� 1)
SELECT COUNT(*)
FROM EMPLOYEE
WHERE DEPT_CODE IS NOT NULL
    AND SUBSTR(EMP_NO, 8, 1) IN ('2', '4');
    
-- ��� 2)
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4');

-- ����� �ִ� ��� ��
SELECT COUNT(MANAGER_ID)
FROM EMPLOYEE;

-- ���� ������� ���� �ִ� �μ��� ����
SELECT COUNT(*)
FROM DEPARTMENT; -- 9
--> ������� ���� ���� ���� �μ����� �Բ� ����� // �䱸���� ��Ű�� ������

SELECT COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE; -- 6 (������� �� ���̶� �ִ� �μ��� ����)
