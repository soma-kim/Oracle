package com.kh.review;

public class B_InDecrease_review {

	/* *���� ������ : ���׿����ڷν� ���� 1���� ������Ű�ų� Ȥ�� ���ҽ�Ű�� ������
	 * ++�� : ���� ���� => ������ �� ó��
	 * ��++ : �������� => ��ó�� �� ����
	 */
	
	
	public void method1() {
		int num = 10;
		System.out.println("num : " + num);
		
		num++;
		
		System.out.println("����� num : " + num);
		
		int num2 = 10;
		num2--;
		
		System.out.println("num2 :" + num2);
	}
	
	public void method2() {
		int num1 = 20;
		int result = num1++ *3;
		
		System.out.println("num1:" + num1);
		System.out.println("result1:" + result);
		
		// result : 60
		// num2 : 21 
		
		
		int num2 = 20;
		int result2 = ++num2 *3;
		
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		// num2 = 20;
		// result2 : 63;
		
		
	}
	
}
