package com.kh.chap06.method.controller;

public class MethodTest2 {
//	static 메소드
//	=> 호출할때 객체를 생성할 필요가 없음!
	
	public static void method1() {
		System.out.println("-------------");
		System.out.println("매개변수와 반환값이 없는 static 메소드");
		
	}
	
	public static String method2() {
		return "매개변수는 없지만 반환값은 있는 static 메소드";
	}
	
	public static void method3(String name, int age) {
//		xx살의 xx님 환영합니다.
		System.out.println(age + "살의 " + name + "님 환영합니다.");
	}
	
	public static int method4(int num1, int num2, char op) {
//		op : 연산자 
//		=> 연산자 종류(+, -, * , / , %)에 따른 연산결과를 return
//		return; // 반환 자료형이랑 리턴되는 값의 자료형을 항상 맞춰줘야한다!
		
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
		default : System.out.println("연산자의 종류가 아닙니다");
					return 0;
		}

		return result; 
		
	}
	
	
}
