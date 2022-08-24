package com.kh.chap03.branch;

public class B_Continue {
	
	/*
	 * * continue��
	 * �ݺ��� ���� ���ǹ����� ����ϴ� ����
	 * continue�� �� ������ �Ǹ� �� �ڿ� � ������ ���簣�� �������� �ʰ�
	 * ���� ����� �ݺ����� ���������� �ö󰡶�� ���� ��
	 */
	
	public void method1() {
		
		// 1���� 10���� Ȧ������ ���
		// 1 3 5 7 9
		
		// ���1. i ���� �Ź� 2�� �����ϴ� ���
		/*
		for(int i = 1; i <= 10; i += 2) {
			
			System.out.print(i + " ");
		}
		*/
		
		// ���2. �ݺ��� �� ������ �ٷ� ����ϴ� �� �ƴ϶� Ȧ������ �Ǻ� �� Ȧ���϶��� ����ϴ� ���
		/*
		for(int i = 1; i <= 10; i++) {
			
			if(i % 2 == 1) {
				
				System.out.print(i + " ");
			}
		}
		*/
		
		// ���3. continue ���� �̿��ϴ� ���
		for(int i = 1; i <= 10; i++) {
			
			if(i % 2 == 0) {
				continue;
			}
			
			System.out.print(i + " ");
		}
	}
	
	public void method2() {
		
		// 1 ���� 100 ������ �� �հ�
		// ��, 6�� ������� �ǳʶٰ� ���ϱ�
		
		// continue�� ���� ����
		/* 
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 6 != 0) { // 6�� ����� �ƴҰ��
				sum += i;
			}
		}
		
		System.out.println("sum : " + sum);
		*/
		
		// continue���� �ִ� ����
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 6 == 0) { // 6�� ����ϰ��
				continue;
			}
			
			sum += i;
		}
		
		System.out.println("sum : " + sum);
	}
	
	// �ǽ�����
	public void method3() {
		
		/*
		 * 2�� ~ 9�� ���� ��� ����ϵ�
		 * ��, 4�� ������� 4��, 8���� �����ϰ� ����ϼ���
		 */
		
		// continue���� ���� ����
		/*
		for(int i = 2; i <= 9; i++) {
			
			// ����� �ϱ� �ϵ�, 4�� ����� �ƴ� �ܼ������� ����ϱ�
			if(i % 4 != 0) {
				System.out.printf("----- %d�� ----- \n", i);
				for(int j = 1; j <= 9; j++) {
					
					System.out.printf("%d X %d = %d \n", i, j, (i * j));
				}
			}
		}
		*/
		
		// continue�� �ִ� ����
		for(int i = 2; i <= 9; i++) {
			
			// i �� 4�� ����ϰ��� ���� �ڵ带 �����ϰ� �ٷ� ���� ���������� �Ѿ�ڴ�.
			if(i % 4 == 0) {
				continue;
			}
			
			System.out.printf("----- %d�� ----- \n", i);
			for(int j = 1; j <= 9; j++) {
				
				System.out.printf("%d X %d = %d \n", i, j, (i * j));
			}
		}
	}
	
	
	

}





