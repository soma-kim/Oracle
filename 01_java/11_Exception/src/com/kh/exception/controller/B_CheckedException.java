package com.kh.exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ���� �Ұ����� ���ܵ� (IOException�� �ڽĵ�)
public class B_CheckedException {
	/*
	 * * CheckedException�� �ݵ�� ����ó���� �ؾ��ϴ� ���ܵ�
	 *   (��, ���� �Ұ��� ������ �߻��ϱ� ������ �̸� ���� ó�� ������ �ۼ��ؾ���)
	 * => �ַ� ����� �ƴ� �ܺ� ��ü�� � "�����"�� �߻��� �� ���ܰ� ��Ÿ��
	 */
	
	public void method1() throws IOException {
		/*
		try {
			method2();
		} catch(IOException e) {
			System.out.println("���� �߻���");
		}
		*/
		method2();
	}
	
	public void method2() throws IOException {
//		Scanner�� ���� Ű����� ���� �Է¹��� �� �ִ� ��ü (��, ���ڿ��θ� ����)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�ƹ� ���ڿ��̳� �Է��ϼ��� : ");
//		String str = br.readLine();
//		�� �޼ҵ带 ȣ��� IOException�� �߻��Ҽ��� ������ ������ ������ �˷���(���� ����)
		
//		1. try ~ catch��
		/*
		try {
			String str = br.readLine();
			System.out.println("���ڿ��� ���� : " + str.length());
		} catch(IOException e) { //���ܰ� ���� �߻����� ��
			System.out.println("���� �߻���");
		}
		*/
		
//		2. throws : ���ѱ��, �����ϱ�
//					���� ���⼭ ���ܸ� �ٷ� ó������ �ʰ�
//					���� �� �޼ҵ带 ȣ���� ������ ���ѱ�ڴ� ��� ��
		String str = br.readLine();
		System.out.println("���ڿ��� ���� : " + str.length());
		
		
		
	}
	
	
	
}
