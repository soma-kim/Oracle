package com.kh.review;
import java.util.Scanner;

public class A_Arithmetic_review {
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		
		System.out.println("num1 * num2 =" + (num1 * num2));
		// ����, ������, ��ⷯ�� �������� �켱������ ���Ƽ� ()�� ���� �ʾƵ� ������ 
		// �������� ���ؼ� ������
		
		double a = 35;
		double b = 10;
		
		System.out.println("a+b = " + (a+b));
		// �Ǽ������� �������� �Ǽ�
	}
	
	public void method2() {
		Scanner sc = new Scanner (System.in);
		System.out.print("�ο��� : ");
		int person = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("���� ���� : ");
		int candy = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("1�δ� �������� ������ ���� : " + (person/candy));
		System.out.println("���� ������ ���� : " + (person%candy));
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
