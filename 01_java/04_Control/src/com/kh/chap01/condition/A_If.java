package com.kh.chap01.condition;

import java.util.Scanner; // import ������ �߰��� �� �ִ� ����Ű : Ctrl + Shift + o

public class A_If {
	
	/*
	 * * �ܵ� if�� : ǥ���ϰ��� �ϴ� ����Ǽ��� �Ѱ��϶� ���
	 * 
	 * [ ǥ���� ]
	 * if(���ǽ�) {
	 * 		���ǽ��� true �� ��� �����ϰ��� �ϴ� �ڵ�;
	 * }
	 * 
	 * => ���ǽ��� ����� true �� ��� �߰�ȣ ��� ���� �ڵ� ����
	 * => ���ǽ��� ����� false �� ��� �߰�ȣ ��� ���� �ڵ带 �ǳ� �ٰ� ����
	 */
	
	// ���� �����ڸ� ���ǹ����� �ٲ㺸��
	public void method1() {
		
		// ����ڷκ��� �������� �Է¹��� �� ���, 0, ������ ���� ��� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// ���׿����� ����
		// String result = (num > 0) ? "����Դϴ�." : ((num == 0) ? "0�Դϴ�." : "�����Դϴ�.");
		
		// �ܵ� if�� ����
		if(num > 0) { // num �� ����ϰ��
			
			System.out.println("����Դϴ�.");
		}
		
		if(num == 0) { // num �� 0�ϰ��
			
			System.out.println("0�Դϴ�.");
		}
		
		if(num < 0) { // num �� �����ϰ��
			
			System.out.println("�����Դϴ�.");
		}
		
		System.out.println("�޼ҵ� ���� ����");
	}
	
	public void method2() {
		
		// ����ڰ� �Է��� �������� ¦������ Ȧ������ �Ǻ��Ͽ� ����� ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// ���׿����� ����
		// String result = (num % 2 == 0) ? "¦���Դϴ�." : "Ȧ���Դϴ�.";
		
		// �ܵ� if�� ����
		/*
		if((num % 2 == 0) && (num > 0)) { // ¦���̸鼭 ����ϰ��
			
			System.out.println("¦���Դϴ�.");
		}
		
		// � ���簣�� 2�� ������ ���� �������� 0 �Ǵ� 1�� ����
		if((num % 2 != 0) && (num > 0)) { // Ȧ���̸鼭 ����ΰ��
			
			System.out.println("Ȧ���Դϴ�.");
		}
		*/
		
		// ��ø if��
		if(num > 0) { // ����ϰ��
			
			// �ѹ� �� �˻�
			if(num % 2 == 0) { // ¦���ϰ��
				
				System.out.println("¦���Դϴ�.");
			}
			
			if(num % 2 != 0) { // Ȧ���ϰ��
				
				System.out.println("Ȧ���Դϴ�.");
			}
		}
	}
	
	public void method3() {
		
		// ����ڷκ��� ���̸� �Է¹ް� �Է��� ���̰��� ������ ���, û�ҳ�, ���� ���
		// ��� (13�� ����), û�ҳ� (19�� �̸�), ���� (19�� �̻�)
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		if(age <= 13) { // ����ϰ��
			
			System.out.println("����Դϴ�.");
		}
		
		if((13 < age) && (age < 19)) { // û�ҳ��ϰ�� (13�� �ʰ��� ������ �߰��ؾ���)
			
			System.out.println("û�ҳ��Դϴ�.");
		}
		
		if(age >= 19) { // �����ϰ��
			
			System.out.println("�����Դϴ�.");
		}
	}
	
	// ���̵� up
	public void method4() {
		
		// ����ڷκ��� �ֹε�Ϲ�ȣ�� �Է¹��� ��
		// ����, ���� �Ǻ� �� ��� ���
		
		// ���� : �ֹι�ȣ ���� (xxxxxx-*xxxxxx) => ���ڿ�
		
		// 1�ܰ� : �ֹι�ȣ �Է¹޾Ƽ� ������ ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ֹι�ȣ�� �Է��ϼ��� (-����) : ");
		String personId = sc.nextLine();
		
		// 2�ܰ� : �Է¹��� �ֹι�ȣ�κ��� ������ �ش�Ǵ� �ڸ��� �����ؼ� ������ ���
		char gender = personId.charAt(7);
		
		// 3�ܰ� : ���� ���� ���� ���� �ٸ� ����� ��� => ���ǹ� �̿�
		// �����ϰ�� '1', '3'
		// �����ϰ�� '2', '4'
		if((gender == '1') || (gender == '3')) { // �����ϰ��
			
			System.out.println("�����Դϴ�.");
		}
		
		if((gender == '2') || (gender == '4')) { // �����ϰ��
			
			System.out.println("�����Դϴ�.");
		}
		
		if((gender != '1') && (gender != '2') 
				&& (gender != '3') && (gender != '4')) { // ��ȣ�� �߸��Է��Ѱ��
			
			System.out.println("�߸��� �ֹι�ȣ�� �Է��߽��ϴ�.");
		}
	}
	
	
	

}




