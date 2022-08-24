package com.kh.operator;

// ���մ��� ������
public class C_Compound {

	/*
	 * * ���մ��� ������ : ��� �����ڿ� ���� �����ڸ� �Բ� ����ϴ� ������
	 * 
	 * [ ���� ]
	 *  += 
	 *  -= 
	 *  *= 
	 *  /= 
	 *  %= 
	 *  => �ش� ������� ���� �� �ڱ� �ڽ����� �����ϰڴ�.
	 *  
	 *  ex) a = a + 3;
	 *      a += 3; // ������ a �����ٰ� 3 �� ���� �Ŀ� �ٽ� a �� �����ڴ�.
	 */
	
	public void method() {
		
		int num = 12;
		
		System.out.println("���� num : " + num);
		
		// num �� 3 ������Ű��
		num = num + 3;
		System.out.println("3 ������Ų num : " + num);
		
		// num �� 3 ������Ű��
		num += 3; // num = num + 3; �� ���� ����
		System.out.println("�� 3 ������Ų num : " + num);
		
		// num �� 5 ���ҽ�Ű��
		num -= 5; // num = num - 5;
		System.out.println("5 ���ҽ�Ų num : " + num);
		
		// num �� 6�� ������Ű�� (* 6 �� �ϰڴ�)
		num *= 6; // num = num * 6;
		System.out.println("6�� ������Ų num : " + num);
		
		// num �� 2�� ���ҽ�Ű�� (/ 2 �� �ϰڴ�)
		num /= 2; // num = num / 2;
		System.out.println("2�� ���ҽ�Ų num : " + num);
		
		// num �� 4�� ���������� �������� num �� �����ϱ�
		num %= 4; // num = num % 4;
		System.out.println("���� num : " + num);
		
		// + : ���ڳ��� �����ϸ� ����, ���ڿ��� �ٸ�Ÿ�Գ��� �����ϸ� ����(�Ѱ��� ���ڿ��� ���̾���)
		// += : ���ڿ����� ���� ����
		
		String str = "Hello";
		
		str += "World"; // str = str + "World";
		System.out.println(str);
	}
	
}







