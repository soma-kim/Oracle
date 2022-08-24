package com.kh.operator;

// ���� ������
public class B_InDecrease {

	/*
	 * * ���� ������ : ���׿����ڷν� ���� 1���� ������Ű�ų� Ȥ�� ���ҽ�Ű�� ������
	 * 
	 * [ ���� ]
	 * ++ : ���� 1�� ������Ű�� ������
	 * 		++�� (����������)
	 * 		��++ (����������)
	 * 
	 * -- : ���� 1�� ���ҽ�Ű�� ������
	 * 		--�� (����������)
	 * 		��-- (����������)
	 * 
	 * (���� ������)�� : �������� => ������ ��ó��
	 * ��(���� ������) : �������� => ��ó�� ������
	 */
	
	public void method1() {
		
		int num = 10;
		
		System.out.println("num : " + num);
		
		num++; // num �� 1 �� ������Ű�ڴ�.
			   // num = num + 1; �� ���� �ǹ�
		
		System.out.println("����� num : " + num);
		
		int num2 = 10;
		
		System.out.println("num2 : " + num2);
		
		num2--; // num2 �� 1�� ���ҽ�Ű�ڴ�.
				// num2 = num2 - 1; �� ���� �ǹ�
		
		System.out.println("����� num2 : " + num2);
	}
	
	public void method2() {
		
		// ++ ��������
		// �������� : ������ ��ó��
		int a = 10; // �� ���������� a �� ���� 10
		int b = ++a; // a �� ���� �켱������ 1 ���� �� b �� ���ԵȰ�
		
		System.out.println("a : " + a + ", b : " + b);
		
		// �������� : ��ó�� ������
		int c = 10; // �� ���������� c �� ���� 10
		int d = c++; // �켱������ d �� c �� ���� ���Եǰ� ���� c �� 1 �����Ȱ�
		
		System.out.println("c : " + c + ", d : " + d);
	}
	
	public void method3() {
		
		int num1 = 20;
		int result1 = num1++ * 3;
		
		// result1 : 60
		// num1 : 21
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		int num2 = 20;
		int result2 = ++num2 * 3;
		
		// num2 : 21
		// result2 : 63
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		
		// ��� : ���������� ���� ���� �ϴ��� ���� �����ϰ� ó���Ұ� ���� ó��
	}
	
	// ����
	public void method4() {
		
		int a = 5;
		int b = 10;
		int c = (++a) + b;
		int d = c / a;
		int e = c % a;
		int f = e++;
		int g = (--b) + (d--);
		int h = 2;
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
	}
	
	
	
	
	
	
}






