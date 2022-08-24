package com.kh.chap06.method.controller;

public class MethodTest1 {
	/*
	 * * �޼ҵ� : �ϳ��� ��� ���� �Է��� ������ � ���� ������ ������ ������� ������� �� ���θ޼ҵ�� �Ϲݸ޼ҵ�� ������.
	 * 
	 * �׵��� ��� ���� �⺻���� �޼ҵ��� ǥ���� public void �޼ҵ��() { ������ �ڵ�; }
	 * 
	 * [ǥ����] ���������� �����(��������) ��ȯ�Ұ����ڷ��� �޼ҵ��(�Ű�����=> ��������) { �������ڵ�; return ��ȯ�Ұ�; (��������
	 * : ��ȯ�� ���� �ڷ����� void�� ��쿡��) } => �޼ҵ带 ������ �Ŀ� �׻� �󸶵��� ȣ���ؼ� �� �� �ִ�.
	 *
	 */

//	1. �Ű������� ���� ��ȯ���� ���� �޼ҵ�(�Է�x , ��� x)
	public void method1() {
		System.out.println("�Ű������� ��ȯ���� �� �� ���� �޼ҵ��Դϴ�.");

//		1���� 10���� �հ踦 ���ؼ� ����ϴ� ���
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}

		System.out.println("�� �հ� : " + sum);
//		return; => void �޼ҵ��� ��� �˰Ը𸣰� return; ������ �����Ǿ��ִ�.
//				   JVM�� �ڵ����� �������ִ� �����̴�.
	}

//	2. �Ű������� ���� ��ȯ���� �ִ� �޼ҵ�
	public int method2() {
		System.out.println("�Ű������� ���� ��ȯ���� �ִ� �޼ҵ��Դϴ�.");

//		1�������� 100������ �������� �߻����Ѽ� �����ִ� ��� �߰�
//		int random = (int)(Math.random() * 100) + 1;
//		return random;

		return (int) (Math.random() * 100) + 1;

	}

//	3. �Ű������� �ְ� ��ȯ���� ���� �޼ҵ�
	public void method3(int num1, int num2) {
		System.out.println("�Ű������� �ְ� ��ȯ���� ���� �޼ҵ��Դϴ�.");
//		num1�� num2�� ���� ���Ͽ� ����� ������ִ� ��� �߰�
//		�ּҰ� : xx
//		�ִ밪 : xx
		
		int min = 0; // �� ���� ���� ���� ������ �뵵
		int max = 0; // �� ���� ū ���� ������ �뵵
		
		if(num1 > num2) {
			max = num1;
			min = num2;
		}
		else if (num1<num2) {
			max = num2;
			min = num1;
		}
		else {
			System.out.println("�� ������ �����ϴ�.");
			return;
		}
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
		
//		return; �����Ǿ��ִ°���
	}


//	4. �Ű������� �ְ� ��ȯ���� �ִ� �޼ҵ�
	public int method4(int a, int b) {
		System.out.println("�Ű������� �ְ� ��ȯ���� �ִ� �޼ҵ��Դϴ�");
		
//		�� �Ű������� ���� ������� ����
		return a * b;
		
	}
	
	
	
}
