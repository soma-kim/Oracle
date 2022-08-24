package com.kh.chap01.math.run;

//	import java.lang.*;
//	��������, ������ ������ �׻� �̹� import�� �Ǿ��ִ�.

//	java.lang.Math Ŭ���� �׽�Ʈ
public class MathRun {

	public static void main(String[] args) {
//		MathŬ���� (���а� ����)���� �����ϰ� �ִ�
//		������ ��ɵ鿡 ���ؼ� ���캸��
		
//		Math math = new Math();
//		Math Ŭ������ ��� �ʵ尡 ��� �ʵ��̰�, ��� �޼ҵ尡 static �޼ҵ��̱� ������
//		��ü�� �����ؼ� �ҷ��� �ʿ䰡 ���� => �����ڵ� private�� ���� ���� ��ü�� ������� ����!
		
//		1. ���� : ������(3.14...)
//				 MathŬ���� ������ ����ʵ�� ���ǵǾ�����
		System.out.println("���� : " + Math.PI);

		
//		<���־��̴� �޼ҵ��>
//		�޼ҵ��(�Ű�����) : ��ȯ��
//		1. �ø� => Math.ceil(double) : ��ȯ�� double��
		double num1 = 4.349;
		System.out.println("�ø� : " + (int)Math.ceil(num1)); //�������� ������ int�� ��������ȯ�ϸ� ��
		
//		2. �ݿø� => Math.round(double) : ��ȯ�� long��
		System.out.println("�ݿø� : "  + Math.round(num1));
		
//		3. ���� => Math.floor(double) : ��ȯ�� double��
		System.out.println("���� : " + Math.floor(num1));

//		4. ���밪 => Math.abs(int.double/long/float) : ��ȯ�� int/ double/ long/ float �״��
		int num2 = -10;
		System.out.println("���밪 : " + Math.abs(num2));
		
//		5. �ּҰ� => Math.min(int, int) :  ��ȯ�� int��
		System.out.println("�ּҰ� : " + Math.min(10,5));
		
//		6. �ִ밪 => Math.max(int, int) : ��ȯ�� int��
		System.out.println("�ִ밪 : " + Math.max(5, 10));
		
//		7. ������(��Ʈ) => Math.sqrt(double) : ��ȯ�� double��
		System.out.println("4�� ������ : " + Math.sqrt(4));
		
//		8. ���� => Math.pow(double, duoble) : ��ȯ�� double��
		System.out.println("2�� 10���� :" + Math.pow(2, 10));
		
//		9. ���� => Math.random() : ��ȯ�� double��
//								  0.0 ~ 0.9999999 ...
		System.out.println("������ : " + Math.random());
		
		
		/*
		 * java.lang.Math Ŭ������ Ư¡
		 * - ��� �ʵ� : ��� �ʵ�
		 * - ��� �޼ҵ� : static �޼ҵ�
		 * 
		 * ���� �� static�̱� ������ Math.���� ���� ����(��ü������ �ʿ����)
		 * Math Ŭ������ �����ڰ� private�̴�. (���ʿ� ���� �Ұ�)
		 * 
		 * static : ���α׷� ���۰� ���ÿ� �޸� ������ �÷��ΰ� �����ϸ� �����ϴ� ����
		 * 	=> �̱������� 
		 */
		
//		<�ڹ� ������ ����>
//		https://docs.oracle.com/javase/8/docs/api/index.html
		
		
	}

}
