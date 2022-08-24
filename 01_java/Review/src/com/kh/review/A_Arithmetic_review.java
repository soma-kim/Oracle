package com.kh.review;
import java.util.Scanner;

public class A_Arithmetic_review {
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		
		System.out.println("num1 * num2 =" + (num1 * num2));
		// 곱셈, 나눗셈, 모듈러는 덧셈보다 우선순위가 높아서 ()로 묶지 않아도 되지만 
		// 가독성을 위해서 묶어줌
		
		double a = 35;
		double b = 10;
		
		System.out.println("a+b = " + (a+b));
		// 실수끼리의 실행결과는 실수
	}
	
	public void method2() {
		Scanner sc = new Scanner (System.in);
		System.out.print("인원수 : ");
		int person = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("사탕 갯수 : ");
		int candy = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("1인당 나눠가진 사탕의 갯수 : " + (person/candy));
		System.out.println("남는 사탕의 갯수 : " + (person%candy));
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
