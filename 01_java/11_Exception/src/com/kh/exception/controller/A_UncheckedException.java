package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

// ����� ���� ������ ������
public class A_UncheckedException {
	/*
	 * * RuntimeException
	 * - ���α׷� ����� �߻��Ǵ� ���ܵ�
	 * 
	 * * RuntimeException�� �ڽ� Ŭ������
	 * - ArrayIndextOutOfBoundsException : �迭�� �������� �ε����� �����Ҷ� �߻��ϴ� ����
	 * - NegativeArraySizeException : �迭�� ũ�⸦ ������ ������ ��� �߻��ϴ� ����
	 * - ClassCastException : ����� �� ���� ����ȯ�� ����� ��� �߻��ϴ� ����
	 * - NullPointerException : �������� ���� ���� null�ӿ��� �ұ��ϰ� �����Ϸ��� �Ҷ� �߻��ϴ� ����
	 * - ArithmeticException : ������ ���� �� 0���� ������ �߻��ϴ� ����
	 * - ...
	 * 
	 * => �̷��� RuntimeException�� ���õ� ���ܵ��� ����� ���� �����ϱ� ������
	 * 	    ���� ��ü�� ���ʿ� �߻��� �ȵǰԲ� "���ǹ�"���� �ذ� �����ϱ��� (��ó��, �����ϴ� ����)
	 *	    ���� ����ó�� (���ܰ� �߻������� ������ ������ �����صδ� ��ó��, ������ ����)�� �� �ʿ䰡 ����.
	 */
	
//	��ĳ�� ��ü�� ���������� ����
//	=> �� Ŭ���� ������ ��� �޼ҵ忡�� ������ �� �� �ְԲ� ���ٰ�
	Scanner sc = new Scanner(System.in);
	public void method1() {
//		ArithmeticException : ������ ���� �� 0���� ������ �߻��ϴ� ����
		
//		����ڷκ��� �ΰ��� �������� �Է¹޾� ������ ������ ���
		System.out.print("ù��° ���� : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("�ι�° ����(0 ����) : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
//		int result = num1 / num2;
//		System.out.println("������ ���� ��� : " + result);
		
//		�ذ���1. ���ǹ����� ó�� (���ʿ� ���� ��ü�� �߻����� �ʰԲ� if������ ���ǰ˻� �� ��� ����)
//					=> ����ó���� �ƴ� 
		/*
		if(num2 !=0) {
			int result = num1 / num2;
			System.out.println("������ ���� ��� : " + result);
		}
		else {
			System.out.println("0���� ���� �� �����ϴ�.");
		}
		System.out.println("���α׷� ����");
		*/
		
//		�ذ���2. ����ó�� �������� �ذ�
//					=> ���ܰ� �߻����� ��츦 ����ؼ� ������ ������ �����صδ� ��
		/*
		 * try ~ catch��
		 * [ǥ����]
		 * try {
		 * 		������ �ڵ� (���ܰ� �߻��� ���� ������ ���ԵǾ�����);
		 * } catch(�߻��ҿ���Ŭ������ ������) {
		 * 		�ش� ���ܰ� �߻��� ��� ������ ����;
		 * }
		 */
		try {
			int result = num1 / num2;
			System.out.println("������ ���� ��� : " + result);
			
		} catch(ArithmeticException e) {
			// System.out.println("0���� ���� �� �����ϴ�.");
			e.printStackTrace(); // ������ ������ �� �ִ�.
			// ���� ���ܰ� ��𿡼� �߻��޴��� �˷���
		}
		System.out.println("���α׷� ����");
	}
	
	public void method2() {
		System.out.print("���� �Է�(0 ����) : ");
		
		try {

			int num = sc.nextInt(); // InputMismatchException�� �߻��ҹ��� ���� (���� �̿��� ���� �Է��� ���)
			sc.nextLine();
			
			int result = 10 / num;
			System.out.println("������ ��� : " + result);

		} catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
			
		} catch(InputMismatchException e) {
			System.out.println("������ ����� �Է��ؾ��մϴ�.");
			
		} // ���� catch �� : ���ܰ� ������ �߻��� ���ɼ��� ������� ������ catch���� �߰��ؼ� �������� ����ó�� ����
		System.out.println("���α׷� ����");
	}
	
	public void method3() {
		// ArrayIndexOutOfBoundsException : �迭�� �������� �ε����� ������ �� �߻��ϴ� ����
		// NegativeArraySizeException : �迭�� ũ�⸦ ������ ������ ��� �߻��ϴ� ����
		
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt();
		sc.nextLine();
		
//		if���� �̿��� ���
		/*
		if(size >= 101) {
			int[] arr = new int[size]; // NegativeArraySizeException�� �߻��ҹ��� ����
			
			System.out.println("100�� �ε��� �� : " + arr[100]); // ArrayIndexOutOfBoundsException�� �߻��ҹ��� ����
		}
		*/
		
//		try ~ catch���� �̿��� ���
		/*
		try {
			int[] arr = new int[size];
			System.out.println("100�� �ε��� �� : " + arr[100]);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�������� �ε����� �����߽��ϴ�.");
			
		} catch (NegativeArraySizeException e) {
			System.out.println("�迭�� ũ��δ� ������ ������ �� �����ϴ�.");
		}
	*/
	
		/*
		try {
			int [] arr = new int [size];
			System.out.println("100�� �ε����� : " + arr[100]);
			
		} catch(RuntimeException e) { // �������� �����Ͽ� �θ� Ÿ���� ���� Ŭ�����ε� ó�� ����
			System.out.println("���ܰ� �߻��ϱ�����.. �迭�� ũ�⸦ ������ �Է��߰ų� �������� �ε����� ��������");
			// ���� catch���� �پ������ ��Ȯ�� � ������ �߻��ߴ��� �ľ��ϱ� �������
		} 
		*/
		
		try {
			int [] arr = new int [size];
			System.out.println("100�� �ε��� �� : " + arr[100]);
			
		} catch (NegativeArraySizeException e) {
			System.out.println("�迭�� ũ��δ� ������ ������ �� �����ϴ�.");
			
		} catch (RuntimeException e) {
			System.out.println("���ܰ� �߻��ϱ� ����");
			
		}
//		=> �������� �����ؼ� �θ𿹿�Ŭ������ �ڽĿ���Ŭ������ catch���� �������� �ۼ��Ϸ���
//	  	      ������ ���� �ڽ�Ÿ���� ���� Ŭ������ ���� ����ؾ��Ѵ�. (�ڽ� ����, �θ� ����)
			System.out.println("���α׷� ����");
		}
	
	
	/*
	 * * RuntimeException ���õ� ���ܴ�
	 * - ���ǹ����� �ذ� ���� : ���� ��ü�� �߻� �ȵǰԲ�
	 * 					    �����ڰ� �ҽ��ڵ�� �ڵ鸵 ���� (����ó��x) => ������ ����
	 * - ����ó�� �������� �ذ� ���� : ���ܰ� �߻��������� ����ؼ� �׶� ������ ������ �����صδ°� => ������ ����
	 * 
	 * 
	 * ������ ������ ��Ȳ : ���ǹ����� �ذ� (�� �����ϴ� ���)
	 * ������ �Ұ����� ��Ȳ : ������ ����ó�� ����(try ~ catch��)���� �ذ��� ���ۿ� ���� (ex. InputMismatchException)
	 * 
	 * => RuntimeException �迭�� ��� ����� ���� ������ ��Ȳ�̱� ������
	 * 	    ���ǹ����� �ذ��ϴ� ���� ����
	 *    ��, ����ó�� ������ �ۼ��ϴ� ���� �ʼ��� �ƴ� = "Unchecked Exception"
	 * 
	 * 
	 */
}
	
	
	

