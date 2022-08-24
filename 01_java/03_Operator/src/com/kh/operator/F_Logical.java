package com.kh.operator;

import java.util.Scanner;

// �� ������
public class F_Logical {
	
	/*
	 * * �� ������ : ���׿����ڷν� �� ���� ������ �����ϴ� ������
	 * 				��, �������� ������ �̷������ �� �������� ����
	 * 
	 * [ ���� ]
	 *  AND ������ : ���� && ����
	 *  		      ����, ������ �� �� ������ true �������� ���� ����� true
	 *  			~ �̰�, �׸���, ~ �̸鼭, .. => �� ���� ����
	 *  
	 *  OR ������ : ���� || ����
	 * 			    ����, ������ �߿� �ϳ��� ���� true ��� ���� ����� true
	 * 			   ~ �Ǵ�, ~ Ȥ��, ~ �̰ų�, .. => ���߿� �ϳ� ����
	 */
	
	public void method1() {
		
		// ����ڰ� �Է��� �������� ��� "�̸鼭" ¦������ �Ǻ��ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Ѱ� �Է� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		boolean result = (num > 0) && (num % 2 == 0);
		// && �� �ǹ� : ~ �̸鼭, ~ �׸���, ~ �̰�
		
		System.out.println("����ڰ� �Է��� ���� ����̸鼭 ¦���Դϱ�? : " + result);
	}
	
	public void method2() {
		
		// ����ڰ� �Է��� �������� 1 �̻� 100 ������ ������ Ȯ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Ѱ� �Է� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// �̻�, ���� => �ش� ������ �����ϴ� ���� (<=, >=)
		// �̸�, �ʰ� => �ش� ������ �������� �ʴ� ���� (<, >)
		
		// num �� ��� ���� 1 �̻� 100 ����
		// 1 <= num <= 100 ����ó�� ��� ǥ�� �Ұ�
		// 1 <= num �Ѱ�, num <= 100 �Ѱ� �ɰ��� ǥ���ؾ� ��
		
		// num �� ��� ���� 1 ���� ũ�ų� �����ϱ�? 
		// �׸���
		// num �� ��� ���� 100 ���� �۰ų� �����ϱ�?
		boolean result = (1 <= num) && (num <= 100);
		
		System.out.println("����ڰ� �Է��� ���� 1 �̻� 100 �����Դϱ�? : " + result);
		
	}
	
	public void method3() {
		
		// ����ڰ� �Է��� ���� y "�̰ų�" Y ���� Ȯ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����Ͻ÷��� y �Ǵ� Y �� �Է��ϼ��� : ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = (ch == 'y') || (ch == 'Y');
		// || : �Ǵ�, ~ �̰ų�
		
		System.out.println("����ڰ� �Է��� ���� y �Ǵ� Y �Դϱ�? : " + result);
	}
	
	public void method4() {
		
		/*
		 * * �� �������� ����Ǽ�
		 *  && : �� ���� ������ ��� true ���� ������� true (AND �� �ǹ�)
		 *  	 true && true == true
		 *   	 true && false == false
		 *   	 false && true == false
		 *   	 false && false == false
		 *  || : �� ���� ���� �� �ϳ��� true �� ��� ������� true (OR �� �ǹ�)
		 *   	 true || true == true
		 *   	 true || false == true
		 *   	 false || true == true
		 *   	 false || false == false
		 */
		
		int num1 = 10;
		
		boolean result1 = false && (num1 > 0); // false
		// ���� �񱳿��� ������ Dead code ��� ���.
		// ��� : ����� ������ ���� ������ ���Ŀ� ������ ���� ������ �ִ� ����
		// => false && ������ ������ �ع����� ������ ����� false �̱� ������
		//    ���� �ڵ带 ���� �� �ۼ��ߴ��� �˷��ִ� ��� (Dead code)
		
		System.out.println("result1 : " + result1);
		
		boolean result2 = true || (num1 > 0); // true
		// => true || ������ ������ �ع����� ������ ����� true �̱� ������ Dead code �߻�
		
		System.out.println("result2 : " + result2);
	}

}





