package com.kh.chap06.method.controller;

public class MethodTest2 {
//	static �޼ҵ�
//	=> ȣ���Ҷ� ��ü�� ������ �ʿ䰡 ����!
	
	public static void method1() {
		System.out.println("-------------");
		System.out.println("�Ű������� ��ȯ���� ���� static �޼ҵ�");
		
	}
	
	public static String method2() {
		return "�Ű������� ������ ��ȯ���� �ִ� static �޼ҵ�";
	}
	
	public static void method3(String name, int age) {
//		xx���� xx�� ȯ���մϴ�.
		System.out.println(age + "���� " + name + "�� ȯ���մϴ�.");
	}
	
	public static int method4(int num1, int num2, char op) {
//		op : ������ 
//		=> ������ ����(+, -, * , / , %)�� ���� �������� return
//		return; // ��ȯ �ڷ����̶� ���ϵǴ� ���� �ڷ����� �׻� ��������Ѵ�!
		
		int result = 0; 
		
		switch(op) {
		case '+' : result = num1 + num2; 
					break;
		case '-' : result = num1 - num2;
					break;
		case '*' : result = num1 * num2;
					break;
		case '/' : result = num1 / num2;
					break;
		case '%' : result = num1 % num2;
					break;
		default : System.out.println("�������� ������ �ƴմϴ�");
					return 0;
		}

		return result; 
		
	}
	
	
}
