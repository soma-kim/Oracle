package com.kh.chap06.method.controller;

public class OverloadingTest {
//	�޼ҵ� �����ε� (Overloading)
//		- �� Ŭ���� ���� ���� �޼ҵ������ ������ �� �ִ� ���
//		- �Ű������� �ڷ����� ����, ������ �ٸ��� �ۼ��Ǿ� �־���Ѵ�.
//		- ��, �Ű������� �̸�, ����������, ��ȯ���� �޼ҵ� �����ε��� ������ ���� �ʴ´�.

	public void test() {
		// �޼ҵ� �����ε��� ���� �� �Ǿ��ִ� ����
		System.out.println(); // �Ű������� ���� ����
		System.out.println(1); // �Ű������� int Ÿ���� �� �ϳ�
		System.out.println(true); // �Ű������� boolean Ÿ���� �� �ϳ�
		System.out.println("�ȳ��ϼ���"); // �Ű������� String Ÿ���� �� �ϳ�
		System.out.printf("%d", 1); //�Ű������� ������ 2��
		System.out.printf("%d %d", 1, 2); // �Ű������� ������ 3�� (String, int, int)
		System.out.printf("%d %c", 1, 'a'); // �Ű������� ������ 3�� (String, int , char)
		
	}

	public void test(int a) {

	}

	public void test(int a, String s) {

	}

	public void test(String s, int a) {

	}

	public void test(int a, int b) {

	}
//	 	=> ������ �߻�
//		=> �Ű����� ����� ��� ���� �ڷ����� ������ ������ ���� ������ ������ �޼ҵ�� �Ǻ��� (�ߺ�����)
//		=> ��, �Ű������� �ڷ����� ������ ������ �ٸ��� �ۼ��ؾ��Ѵ�.
	/*
	 * public void test(int c, int d) {
	 * 
	 * }
	 */

	public void test(int a, int b, String s) {
		
	}
// 		=> ������ �߻�
//		=> ��ȯ���� �ٸ��ٰ� �����ε��� ��������� �ʴ´�.
//		=> �޼ҵ带 ȣ���ϴ� �������� �Ű������� �����ϱ� ������ ������ �߻��Ѵ�.
//		=> ��, ��ȯ���� ������� �Ű������� �ڷ����� ������ ������ �ٸ��� �ۼ��Ǿ�� �Ѵ�.
	/*
	public int test(int a, int b, String s) {
		return a + b;
	}
	*/
	
//		=> ������ �߻�
//		=> ���������ڰ� �ٸ��ٰ��ؼ� �����ε��� ������� �ʴ´�.
//		=> ��, ���������ڿ� ������� �Ű������� �ڷ����� ������ ������ �ٸ��� �ۼ��Ǿ���Ѵ�.
	/*
	private void test(int a, int b, String s) {
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
}
