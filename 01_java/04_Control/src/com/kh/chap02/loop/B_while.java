package com.kh.chap02.loop;

import java.util.Scanner;

public class B_While {

	/*
	 * * while��
	 * ���� �ݺ��ϰ����ϴ� Ƚ���� �˰����� �� �ᵵ �ǰ�, �� ���� �� �� �ִ� �ݺ���
	 * => ������ ǥ������ �ʱ�İ� �������� ���ԵǾ����� �ʱ� ����
	 * 
	 * [ ǥ���� ]
	 * �ʱ��; // 1. while���� ���� �ݺ��� �Ͼ�� ���� �� �ѹ� ����Ǵ� ���� (�ʼ��� �ƴ�)
	 * while(���ǽ�) { // 2. ���ǽĿ� ���� ���ǰ˻� : ������ true ��� �߰�ȣ ���� �ڵ尡 ���� (�ʼ�)
	 * 		���ǽ� ����� true �ϰ�� �ݺ������� ������ �ڵ�; // 3. true �ϰ�� ������ �Ʒ��� ���� (�ʼ�)
	 * 		������; // 4. �ʱ�Ŀ��� ������ ������ ������ ���� �Ǵ� ���Ұ� �̷���� (�ʼ��� �ƴ�)
	 * }
	 * 
	 * * ���� ���ǽ� ���빰�� ����� true ���? ���ѹݺ�
	 *   ���� ���ǽ� ���빰�� ����� false ���? �ݺ��� �ѹ��� ���Ͼ
	 */
	
	public void method1() {
		
		// "�ȳ��ϼ���" �� 5�� ����ϱ�
		// for�� ����
		/*
		for(int i = 0; i < 5; i++) { // 0, 1, 2, 3, 4
			
			System.out.println("�ȳ��ϼ���");
		}
		*/
		
		// while�� ����
		int i = 0; // �ʱ��
		while(i < 5) { // ���ǽ�
			
			System.out.println("�ȳ��ϼ���"); // �������ڵ�
			
			i++; // ������
		}
		
		System.out.println("i : " + i); // i = 5
		
		while(i >= 1) {
			
			System.out.print(i-- + " "); // 5 4 3 2 1 ���
										 // --i �� ���� 4 3 2 1 0 ���� ��µȴ�.
			
			// i--;
		}
	}
	
	public void method2() {
		
		// 1 �������� 10 ������ �� �հ�
		
		int sum = 0;
		
		// for�� ����
		/*
		for(int i = 1; i <= 10; i++) {
			
			sum += i;
		}
		*/
		
		// while�� ����
		int i = 1; // �ʱ��
		while(i <= 10) { // ���ǽ�
			
			sum += i; // ������ �ڵ�
			
			i++; // ������
		}
		
		System.out.println("sum : " + sum);
	}
	
	public void method3() {
		
		// 1 ���� ������ (1 ~ 100 ������ ������) ������ �� �հ�
		
		int random = (int)(Math.random() * 100) + 1;
		
		System.out.println("random : " + random);
		
		int sum = 0;
		
		// for�� ����
		/*
		for(int i = 1; i <= random; i++) {
			
			sum += i;
		}
		*/
		
		// while�� ���� (�ʱ�İ� �������� ���Ե� ����)
		/*
		int i = 1; // �ʱ��
		while(i <= random) { // ���ǽ�
			
			sum += i; // ������ �ڵ�
			
			i++; // ������
		}
		*/
		
		// while�� ���� (�ʱ�İ� �������� ���� ����)
		while(random > 0) {
			
			sum += random--;
		}
		
		System.out.println("sum : " + sum);
	}
	
	public void method4() {
		
		// ���Ѵ�� �ƹ� ���ڿ��̳� �Ź� �Է¹ް�
		// "exit" ���ڿ��� �ԷµǴ� ���� ���α׷��� �ƿ� �����Ű��
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		while(i == 0) { // i �� ���ٸ� ������ �Ͼ�� �ʴ� �� ��� true
			
			System.out.print("�ƹ� ���ڿ��̳� �Է��ϼ��� : ");
			String str = sc.nextLine();
			
			if(str.equals("exit")) { // ���ڿ� ���빰�� "exit" �� ��쿡��
				
				return;
			}
		}
	}
	
	/*
	 * * do-while��
	 * ������ true �� �ƴϴ��� �ϴ��� �ѹ� �����ϰ��� �����غ��� ����
	 * 
	 * [ ǥ���� ]
	 * do {
	 * 
	 * 		������ �ڵ�;
	 * } while(���ǽ�);
	 * 
	 * => ������ ���� �˻� ���� ������ �ѹ� ����
	 * => �ѹ� ���� �� �������� ���ǽĿ� ���� ���ǰ˻簡 �̷����
	 * => ���ǽ��� ����� true �� ��� �ٽ� �� ������ �ڵ尡 ����
	 * => ���ǽ��� ����� false �� ��� �ݺ����� ��������
	 * 
	 * * while���� do-while���� ��������
	 * ������ false ���� do-while���� ��� �ѹ� ����ȴ�.
	 */
	
	public void method5() {
		
		int num = 1;
		
		while(num == 0) {
			
			System.out.println("�ȳ�!");
		} // ����� 0�� �̷����
		
		do {
			
			System.out.println("�߰�!");
		} while(num == 0); // ����� 1�� �̷����
		
	}
	
	
}
