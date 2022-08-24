package com.kh.chap06.method.run;

import java.util.Scanner;

import com.kh.chap06.method.controller.MethodTest1;
import com.kh.chap06.method.controller.MethodTest2;

public class MethodRun {

	public static void main(String[] args) {
//		1. MethodTest1 클래스 테스트
		MethodTest1 m1 = new MethodTest1();
		m1.method1();
	
		System.out.println("-----------------");
		
		//int random = m1.method2(); //자료형을 맞춰줘야한다.
		//System.out.println("랜덤값 : " + random);
		System.out.println("랜덤값 : " + m1.method2());
		
		System.out.println("-----------");
		m1.method3(20, 10); 
		// 매개변수가 여러개인 경우에는 
		// 호출시의 전달값의 순서, 갯수 , 자료형이 정확히 일치해야한다.
		
		
		System.out.println("-------------");
		int result = m1.method4(42, 2);
//		System.out.println("두 수의 곱 :" + result);
		
		System.out.println("두 수의 곱 : " + m1.method4(42,2));
		
//		반환값이 있는 경우 : 호출부분에서 반환값을 받아줄 변수를 미리 선언하고 대입하는 구문을 쓰거나
//						출력문 내부에서 호출하는 식으로 활용
//		반환값이 없는 경우 : 연산 결과를 사용자에게 보여주고자 한다면 메소드 내부에서 출력문 활용
		
		
//		2. MethodTest2 클래스 테스트
		MethodTest2.method1();
		System.out.println("-------------");
		System.out.println(MethodTest2.method2());
		
		System.out.println("-------------");
		MethodTest2.method3("홍길동",11);
		
		System.out.println("-------------");
		
		/*
		int result1 = MethodTest2.method4 (5,11,'+');
		int result2 = MethodTest2.method4 (5,11,'-');
		int result3 = MethodTest2.method4 (5,11,'*');
		int result4 = MethodTest2.method4 (5,11,'/');
		int result5 = MethodTest2.method4 (5,11,'%');
		int result6 = MethodTest2.method4 (5,11, '=');
		*/
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두번째 정수 : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("연산하고싶은 연산자 : ");
		char op = sc.nextLine().charAt(0);
		
		if(op != '+' && op != '-' && op != '*' && op != '/' && op != '%') { // 그 이외의 연산자를 입력했을 경우
			
			System.out.println("연산자가 잘못되었습니다.");
		}
		else { // 알맞은 연산자를 입력했을 경우
			int result1 = MethodTest2.method4(num1, num2, op);
			
			System.out.println("연산결과 : " + result1);
		}
		*/
		
		int result1 = MethodTest2.method4(5, 11, '+');
		int result2 = MethodTest2.method4(5, 11, '-');
		int result3 = MethodTest2.method4(5, 11, '*');
		int result4 = MethodTest2.method4(5, 11, '/');
		int result5 = MethodTest2.method4(5, 11, '%');
		int result6 = MethodTest2.method4(5, 11, '=');
		
		System.out.println("두수의 합 :" + result1 + "\n 두수의 차 " + result2 + "\n 두수의 곱 " + result3 + 
				"\n 두수의 나누기 " + result4 + "\n 두수의 나머지 " + result5);
		
	}

}
