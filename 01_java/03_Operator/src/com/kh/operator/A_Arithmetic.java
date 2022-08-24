package com.kh.operator;

import java.util.Scanner;

// ��� ������
public class A_Arithmetic {

	/*
	 * * ��� ������ : ���׿����ڷν� ���� ����� �켱 ������ �Ϲ� ���� ����� ����
	 * 
	 * [ ���� ]
	 *  + : ����
	 *  - : ����
	 *  * : ����
	 *  / : ������ 		   => ���������� ���� ���Ѵ�. 
	 *  % : ��ⷯ (Modular) => ���������� �������� ���Ѵ�.
	 */
	
	public void method1() {
		
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		// ���ڿ��� int �� ���������ִ�  + ��
		// ���ڳ����� ��������� ���ִ�  + �� �켱������ �����ϱ� ������
		// ���ʿ������� ���ʴ�� ������ ����Ǳ� ������ () �� ���� ��������� + �� �켱������ �����ش�.
		
		System.out.println("num1 - num2 = " + (num1 - num2));
		// ���ڿ��� int �� ���������ִ�  + ��
		// ���ڳ����� ��������� ���ִ� - �� �켱������ �����ϱ� ������
		// ���ڿ� - ���� => undefined �� �߻��Ѱ�
		
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
		// ����, ������, ��ⷯ�� ��� ���� ���� �켱������ ���� ������
		// () �� ���� �ʾƵ� ��Ȯ�� ����� ����
		// => �ٸ� �������� ���� ���� �� ��ȣ�� �����ִ°��� �� ����!!
		
		// System.out.println(10 / 0);
		// System.out.println(10 % 0);
		// ArithmeticException : / by zero
		// ���а� ���������� ���α׷��� �󿡼� 0 ���� ������� �Ұ���. ����!!
		
		// �Ǽ��� ���
		double a = 35; // 35.0
		double b = 10; // 10.0
		
		System.out.println("a + b = " + (a + b)); // 45.0
		System.out.println("a - b = " + (a - b)); // 25.0
		System.out.println("a * b = " + (a * b)); // 350.0
		System.out.println("a / b = " + (a / b)); // 3.5
		System.out.println("a % b = " + (a % b)); // 5.0
		
		// �Ǽ������� �������� �Ǽ�
	}
	
	// ���빮��
	public void method2() {
		
		/*
		 * �ο� ���� ������ ������ Ű����κ��� �Է� �ް�
		 * 1�δ� �����ϰ� �������� ������ ������
		 * ���� ������ ������ ����ϼ���
		 * 
		 * ���࿹��
		 * �ο��� : x
		 * �������� : x
		 * 
		 * 1�δ� �������� �������� : x
		 * ���� �������� : x
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο��� : ");
		int person = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("�������� : ");
		int candy = sc.nextInt();
		
		sc.nextLine();
		
		// 1�δ� �������� ������ ������ �������� ��
		// ���� ������ ������ �������� ������
		System.out.println();
		// System.out.println("1�δ� �������� �������� : " + (candy / person));
		// System.out.println("���� �������� : " + (candy % person));
		
		// printf �� �̿�
		System.out.printf("1�δ� �������� �������� : %d \n", (candy / person));
		System.out.printf("���� �������� : %d \n", (candy % person));
	}
	
}