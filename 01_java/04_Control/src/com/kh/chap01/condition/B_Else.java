package com.kh.chap01.condition;

import java.util.Scanner;

public class B_Else {

	/*
	 * * if-else�� : ǥ���ϰ��� �ϴ� ����Ǽ��� �ΰ��ϰ�� ����ϴ� ���ǹ�
	 * 
	 * [ ǥ���� ]
	 * if(���ǽ�) {
	 * 		�ش� ���ǽ��� true �ϰ�� �����ϰ��� �ϴ� �ڵ�;	
	 * } 
	 * else {
	 * 		�ش� ���ǽ��� false �ϰ�� �����ϰ��� �ϴ� �ڵ�;
	 * }
	 * 
	 * => ���ǽ��� ����� true �� ��� if �� ���� �����ϰ� if-else�� ��ü�� ��������
	 * => ���ǽ��� ����� false �� ��� else �� ���� �����ϰ� if-else�� ��ü�� ��������
	 */
	
	public void method1() {
		
		// ����ڿ��� �������� �Է¹��� �� ¦��, Ȧ�� �Ǻ��� ��� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// ����� ��츸 �Ǻ� �����ϰԲ� ��ø if�� ���
		if(num > 0) { // ����ϰ��
			
			// ¦���� ��� �Ǵ� Ȧ���� ��� 
			if(num % 2 == 0) { // ¦���ϰ��
				
				System.out.println("¦���Դϴ�.");
			}
			else { // ¦���� �ƴҰ��
				
				System.out.println("Ȧ���Դϴ�.");
			} 
			// else �������� ������ ������ ������ �ʿ䰡 ����!!
			// ���ǽ� ����� true �̸� else ���� �ǳ� �ٱ� ������
			// �ܵ� if�� �ΰ��� ǥ���ϴ� �� ���ٴ� ȿ�����̴�.
		}
		else { // ����� �ƴҰ��
			
			System.out.println("����� �Է��ؾ� �մϴ�.");
		}
	}
	
	/*
	 * * if-else if�� : ������ �񱳴���� ������ 3�� �̻��� ������ ������ �ΰ��� �� �� ���Ǵ� ���ǹ�
	 * 
	 * [ ǥ���� ]
	 * if(���ǽ�1) {
	 * 		���ǽ�1 �� true �� ��� ������ �ڵ�;
	 * } 
	 * else if(���ǽ�2) {
	 * 		���ǽ�2 �� true �� ��� ������ �ڵ�;
	 * }
	 * else if(���ǽ�3) {
	 * 		���ǽ�3 �� true �� ��� ������ �ڵ�;
	 * }
	 * else {
	 * 		�տ��� ������ ��� ���ǽĵ��� ��� false �� ��� ������ �ڵ�;
	 * }
	 */
	
	public void method2() {
		
		// ����ڷκ��� ���� �Է� �� ���, 0, ���� �Ǻ� �� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		if(num > 0) { // ����ϰ��
			
			System.out.println("����Դϴ�.");
		}
		else if(num == 0) { // 0�ϰ��
			
			System.out.println("0�Դϴ�.");
		}
		else { // ����� �ƴϰ� 0�� �ƴҰ�� == �����ϰ��
			
			System.out.println("�����Դϴ�.");
		}
	}
	
	// �ǽ�����
	public void method3() {
		
		/*
		 * ����ڷκ��� ���̸� �Է¹ް�
		 * 13�� ���ϱ��� ���, 14������ 18������ û�ҳ�, 19�� �̻���ʹ� ����
		 * �Ǻ� �� ���
		 * 
		 * ����� ��
		 * �켱������ ����ؾ��� �� : ���̴� 0����� ��ȿ�ϰԲ�
		 * 					    ���̰� 0����Ͷ�� �Ǻ�
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		if(age < 0) { // ���̸� ������ �Է����� ��� 
			
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
		else {
			
			if(age <= 13) { // ���̰� 13 ���϶�� (+ ���̰� 0�� �̻��̶��)
				
				System.out.println("����Դϴ�.");
			}
			else if(age < 19) { // ���̰� 19 �̸��̶�� (+ age > 13 �� ������ �˰Ը𸣰� ������ ��)
				
				System.out.println("û�ҳ��Դϴ�.");
			}
			else {
				
				System.out.println("�����Դϴ�.");
			}
		}
	}
	
	// ����
	public void method4() {
		
		/*
		 * ����ڿ��� ���� �Է¹޾�
		 * 90�� �̻��� ��� "A���"
		 * 90�� �̸� 80�� �̻��� ��� "B���"
		 * 80�� �̸� 70�� �̻��� ��� "C���"
		 * 70�� �̸��� ��� "D���"
		 * 
		 * "����� ������ xx���̰�, ����� xxx �Դϴ�." ��� (printf)
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int score = sc.nextInt();
		
		sc.nextLine();
		
		// ����� ���� �� �ִ� ���� ���� (char)
		char grade = ' '; // char �ڷ����� ��� �Ϲ������� �������� �ʱ�ȭ
		
		if(score >= 0 && score <= 100) {
			// 0 ~ 100 �� ���� => ��ȿ�� ������ ó�� (����Ǻ��� ����)
			if(score >= 90) { // 90 �� �̻��ϰ��
				grade = 'A';
			}
			else if(score >= 80) { // 80 �� �̻��ϰ��
				grade = 'B';
			}
			else if(score >= 70) { // 70 �� �̻��ϰ��
				grade = 'C';
			}
			else { // �� �̿��� �����ϰ��
				grade = 'D';
			}
			
			// �� �������� ���
			// System.out.printf("����� ������ %d���̰�, ����� %c��� �Դϴ�.", score, grade);
		}
		else {
			// �ƴҰ�� => �߸� �Է��߽��ϴ�. (����Ǻ��� �Ұ���)
			System.out.println("�߸� �Է��߽��ϴ�.");
			
			return; // ���� ȣ���ߴ� �޼ҵ�� ���ư� (��, �޼ҵ尡 �� �������� �����)
		}
		
		// �� �������� ���
		System.out.printf("����� ������ %d���̰�, ����� %c��� �Դϴ�.", score, grade);
	}
	
	// ����
	public void method5() {
		
		/*
		 * ����ڷκ��� �̸��� Ű����� �Է� �޾� ���ΰ� ��ġ�� ��� "�����Դϴ�. �������.",
		 * ��ġ���� ���� ��� "������ �ƴմϴ�. ���ư� �ּ���." �� ���
		 */
		
	}
	
}





