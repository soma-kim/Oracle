package com.kh.chap03.branch;

import java.util.Scanner;

public class A_Break {

	/*
	 * * break��
	 * �ݺ��� �ȿ��� break���� ������ ���� "���� ����� ���� ���Ե� �ݺ���" �� �㸸 ���������� ����
	 * ��, �ش� break���� �����ִ� �ݺ��� ���� ���������� ����
	 * 
	 * * �������� : switch�� ���� break �ʹ� �ٸ� ����
	 * 			  switch�� ���� break�� �ش� switch �߰�ȣ ������ ���������� ����
	 * 			    �ݺ��� ���� break�� �ش� �ݺ��� �߰�ȣ ������ ���������� ����
	 */
	
	public void method1() {
		
		// �Ź� ������ �ݺ������� �߻��Ǵ� ������ (1 ~ 100 ������ ����) ���
		// ��, �� �������� Ȧ���� ���� �ݺ����� ���������Բ�
		
		while(true) {
			
			int random = (int)(Math.random() * 100) + 1;
			
			if(random % 2 == 1) { // random ���� Ȧ���� ��� => �ݺ�����  ��������
				
				break;
			}
			else { // random ���� ¦���� ��� => ���
				
				System.out.println("random : " + random);
			}
		}
		
		System.out.println("�ݺ����� ����������");
	}
	
	public void method2() {
		
		// �Ź� ����ڿ��� ���ڿ��� �Է¹ް� �ش� ���ڿ��� ���̸� ���
		// ��, ����ڰ� "exit" ��� ���ڿ��� �Է��ϴ� ���� �ݺ����� ���������Բ�
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			System.out.print("���ڿ� �Է� : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")) { // ���� str �� ����ִ� ���ڿ��� ���빰�� "exit" ��� �ݺ����� ��������
				
				// return;
				break;
			}
			
			System.out.println(str + " �� ���ڼ� ���� : " + str.length());
		}
		
		System.out.println("���α׷��� ����˴ϴ�.");
		// Unreachable code : ������ �� ���� �ڵ�
	}
	
	public void method3() {
		
		// �Ź� �ݺ������� ����ڷκ��� ����� �Է¹޾� 1 ~ �ش� �� ������ ���
		// ��, ���������� ����� �Է����� ��쿡�� ���
		// ���࿡, �߸� �Է����� ��� "�ٽ� �Է����ּ���"
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {

			System.out.print("��� �Է� : ");
			int num = sc.nextInt();
			
			sc.nextLine();
			
			// �켱������ ������� �ƴ��� ���� �Ǻ�
			if(num > 0) { // ����ϰ��
				
				// 1 �������� num ���� ���������� ���ٿ� ���̾ ���
				for(int i = 1; i <= num; i++) {
					
					System.out.print(i + " ");
				} // 1 2 3 4 ... num ���� �ϼ�
				
				break; // ���� ���� ���Ե� while(true) �� ���������� ����
			}
			else { // ����� �ƴҰ��
				
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
		
	}
	
}