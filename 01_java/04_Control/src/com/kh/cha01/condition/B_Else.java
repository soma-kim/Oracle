package com.kh.cha01.condition;

import java.util.Scanner;

public class B_Else {
	
	/*
	 * *if-else�� : ǥ���ϰ��� �ϴ� ����� ���� �ΰ��ϰ�� ����ϴ� ���ǹ�
	 * [ǥ����]
	 * if (���ǽ�) { 
	 * 		�ش� ���ǽ��� true�� ��� �����ϰ����ϴ� �ڵ�;
	 * }
	 * else {
	 * 		���� ���ǽ��� false�� ��� �����ϰ����ϴ� �ڵ�;
	 * }
	 * 
	 * => ���ǽ��� ����� true�� ��� if �� ���� �����ϰ� if-else�� ��ü�� ��������
	 * => ���ǽ��� ����� false�� ��� else �� ���� �����ϰ� if-else�� ��ü�� ��������
	 */
	
	public void method1() {
		// ����ڿ��� �������� �Է¹��� �Ŀ� ¦��, Ȧ�� �Ǻ� �� ��� ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.hasNextLine();
		
		// ����� ��츸 �Ǻ� �����ϰԲ� ��ø if�� ���
		if (num > 0) {
			
			// ¦���� ��� �Ǵ� Ȧ�� �� ���
			if(num % 2 == 0) { //¦���� ���
				System.out.println("¦���Դϴ�.");
			}
			else { //¦���� �ƴҰ��
				System.out.println("Ȧ���Դϴ�.");
			} 
			// else �������� ������ ������ ������ �ʿ䰡 ����!!
			// ���ǽ� ����� true�̸� else ���� �ǳ� �ٱ� ������
			// �ܵ� if�� �ΰ��� ǥ���ϴ� �� ���ٴ� ȿ�����̴�.
		}
		
		else { // ����� �ƴҰ��
			System.out.println("����� �Է��ؾ� �մϴ�.");
		}
	}
	
	/*
	 * * if-else if�� : ������ �񱳴���� ������ 3�� �̻��� ������ �����صΰ��� �Ҷ� ���Ǵ� ���ǹ�
	 * 
	 * [ǥ����]
	 * if(���ǽ�) {
	 * 		���ǽ�1�� true�� ��� �����ϴ� �ڵ�;
	 * }
	 * else if(���ǽ�2){ 
	 * 		���ǽ�2�� true�� ��� ������ �ڵ�;
	 * }
	 * else if(���ǽ�3) {
	 * 		���ǽ�3�� true�� ��� ������ �ڵ�;
	 * }
	 * else {
	 * 		�տ��� ������ ��� ���ǽĵ��� ��� false�� ��� ������ �ڵ�;
	 * }
	 * 
	 */
	
	public void method2() {
		// ����ڷκ��� ���� �Է� �� ��� , 0, ���� �Ǻ� �� ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		
		int num = sc.nextInt();
		
		if(num>0) { // ����� ��� 
			System.out.println("����Դϴ�.");
		}
		else if (num == 0) { // 0�ϰ��
			System.out.println("0�Դϴ�");
		}
		else { // ����� �ƴϰ� 0�� �ƴҰ�� == �����ϰ��
			System.out.println("�����Դϴ�");
		}
	}
	
	//�ǽ�����
	public void method3() {
		
		/*
		 * ����ڷκ��� ���̸� �Է¹ް�
		 * 13�� ���ϱ��� ���, 14~18������ û�ҳ�, 19�� �̻���ʹ� ����
		 * �Ǻ� �� ��� 
		 * 
		 * ����� ��
		 * �켱������ ����ؾ��� �� : ���̴� 0����� ��ȿ�ϰԲ� (0���� ���� ��� �Ǻ�x)
		 * 					    ���̰� 0����Ͷ�� �Ǻ�
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		if (age < 0) {
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
		else {
			if (age <= 13) { // ���̰� 13 ���϶��
			System.out.println("��� �Դϴ�");
			}
			else if ((age > 13) && (age <= 18)) {
				System.out.println("û�ҳ� �Դϴ�");
			}
			else {
				System.out.println("���� �Դϴ�.");
			}
		}
	
	}


	// ����
	public void method4() {
		
		/*
		 * ����ڿ��� ������ �Է¹޾�
		 * 90�� �̻��� ��� "A���"
		 * 90�� �̸� 80�� �̻��� ��� "B���"
		 * 80�� �̸� 70�� �̻��� ��� "c���"
		 * 70�� �̸��� ��� "D���"
		 * 
		 * "����� ������ xx���̰�, ����� xxx�Դϴ�." (printf ���)
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// 0~100�� ���� => ��ȿ�� ������ ó�� (��� �Ǻ��� ����)
		// �ƴҰ�� => �߸��Է��߽��ϴ�
		
		
		
		if(num >=0 && num <=100) {
			System.out.printf("����� ������ %d �̰�, ����� %s �Դϴ�", num, "A");
		}
		
		else {
			if ((num < 90) && (num <= 80)) {
			System.out.printf("����� ������ %d �̰�, ����� %s �Դϴ�", num, "B");
			}
			else if ((num < 80) && (num >= 70)) {
				System.out.printf("����� ������ %d �̰�, ����� %s �Դϴ�", num, "C");
			}
			else if ((num < 70)) {
				System.out.printf("����� ������ %d �̰�, ����� %s �Դϴ�", num, "D");
			}
			else {
				System.out.println("�߸��Է��߽��ϴ�.");
			}
		}
		
		
		
		
		
	}
}












