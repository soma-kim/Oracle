package com.kh.chap06.method.run;

import java.util.Scanner;

import com.kh.chap06.method.controller.MethodTest1;
import com.kh.chap06.method.controller.MethodTest2;

public class MethodRun {

	public static void main(String[] args) {
//		1. MethodTest1 Ŭ���� �׽�Ʈ
		MethodTest1 m1 = new MethodTest1();
		m1.method1();
	
		System.out.println("-----------------");
		
		//int random = m1.method2(); //�ڷ����� ��������Ѵ�.
		//System.out.println("������ : " + random);
		System.out.println("������ : " + m1.method2());
		
		System.out.println("-----------");
		m1.method3(20, 10); 
		// �Ű������� �������� ��쿡�� 
		// ȣ����� ���ް��� ����, ���� , �ڷ����� ��Ȯ�� ��ġ�ؾ��Ѵ�.
		
		
		System.out.println("-------------");
		int result = m1.method4(42, 2);
//		System.out.println("�� ���� �� :" + result);
		
		System.out.println("�� ���� �� : " + m1.method4(42,2));
		
//		��ȯ���� �ִ� ��� : ȣ��κп��� ��ȯ���� �޾��� ������ �̸� �����ϰ� �����ϴ� ������ ���ų�
//						��¹� ���ο��� ȣ���ϴ� ������ Ȱ��
//		��ȯ���� ���� ��� : ���� ����� ����ڿ��� �����ְ��� �Ѵٸ� �޼ҵ� ���ο��� ��¹� Ȱ��
		
		
//		2. MethodTest2 Ŭ���� �׽�Ʈ
		MethodTest2.method1();
		System.out.println("-------------");
		System.out.println(MethodTest2.method2());
		
		System.out.println("-------------");
		MethodTest2.method3("ȫ�浿",11);
		
		System.out.println("-------------");
		
		/*
		int result1 = MethodTest2.method4 (5,11,'+');
		int result2 = MethodTest2.method4 (5,11,'-');
		int result3 = MethodTest2.method4 (5,11,'*');
		int result4 = MethodTest2.method4 (5,11,'/');
		int result5 = MethodTest2.method4 (5,11,'%');
		int result6 = MethodTest2.method4 (5,11, '=');
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�ι�° ���� : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�����ϰ���� ������ : ");
		char op = sc.nextLine().charAt(0);
		
		if(op != '+' && op != '-' && op != '*' && op != '/' && op != '%') { // �� �̿��� �����ڸ� �Է����� ���
			
			System.out.println("�����ڰ� �߸��Ǿ����ϴ�.");
		}
		else { // �˸��� �����ڸ� �Է����� ���
			int result1 = MethodTest2.method4(num1, num2, op);
			
			System.out.println("������ : " + result1);
		}
		*/
		
		int result1 = MethodTest2.method4(5, 11, '+');
		int result2 = MethodTest2.method4(5, 11, '-');
		int result3 = MethodTest2.method4(5, 11, '*');
		int result4 = MethodTest2.method4(5, 11, '/');
		int result5 = MethodTest2.method4(5, 11, '%');
		int result6 = MethodTest2.method4(5, 11, '=');
		
		System.out.println("�μ��� �� :" + result1 + "\n �μ��� �� " + result2 + "\n �μ��� �� " + result3 + 
				"\n �μ��� ������ " + result4 + "\n �μ��� ������ " + result5);
		
	}

}
