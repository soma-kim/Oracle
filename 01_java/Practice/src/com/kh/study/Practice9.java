package com.kh.study;

import java.util.Scanner;

public class Practice9 {
	public void Practice9() {
//		�߰����, �⸻���, ��������, �⼮ȸ���� �Է��ϰ� Pass �Ǵ� Fail�� ����ϼ���.
//		�� �� 100�� �� �������δ� ������ ����.
//		�߰���� (20%), �⸻��� (30%), ���� (30%), �⼮ (20%)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰���� ���� : ");
		int Mid = sc.nextInt();
		
		System.out.print("�⸻��� ���� : ");
		int Final = sc.nextInt();
		
		System.out.println("���� ���� : ");
		int Project = sc.nextInt();
		
//		�� ��, �⼮ ȸ���� �� ���� ȸ�� 20ȸ �߿��� �⼮�� ���� �Է�
		System.out.println("�⼮ Ƚ�� : ");
		int Att = sc.nextInt();
		while (true) {
			
		}
		
//		������ 70�� �̻��̸鼭 ��ü ������ 70%�̻� �⼮�� ���� ��� Pass,
//		�ƴϸ� Fail�� ����ϼ���
		
		int sum = Mid + Final + Project + Att;
		if (sum >= 70 && Att / 20 >= 0.7) {
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
		
		
		
	}
}
