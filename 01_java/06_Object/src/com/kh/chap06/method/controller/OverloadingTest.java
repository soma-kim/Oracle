package com.kh.chap06.method.controller;

public class OverloadingTest {
//	메소드 오버로딩 (Overloading)
//		- 한 클래스 내에 같은 메소드명으로 정의할 수 있는 방법
//		- 매개변수의 자료형의 갯수, 순서가 다르게 작성되어 있어야한다.
//		- 단, 매개변수의 이름, 접근제한자, 반환형은 메소드 오버로딩에 영향을 주지 않는다.

	public void test() {
		// 메소드 오버로딩이 아주 잘 되어있는 예시
		System.out.println(); // 매개변수가 없는 상태
		System.out.println(1); // 매개변수가 int 타입의 값 하나
		System.out.println(true); // 매개변수가 boolean 타입의 값 하나
		System.out.println("안녕하세요"); // 매개변수가 String 타입의 값 하나
		System.out.printf("%d", 1); //매개변수의 갯수가 2개
		System.out.printf("%d %d", 1, 2); // 매개변수의 갯수가 3개 (String, int, int)
		System.out.printf("%d %c", 1, 'a'); // 매개변수의 갯수가 3개 (String, int , char)
		
	}

	public void test(int a) {

	}

	public void test(int a, String s) {

	}

	public void test(String s, int a) {

	}

	public void test(int a, int b) {

	}
//	 	=> 에러가 발생
//		=> 매개변수 명과는 상관 없이 자료형의 갯수와 순서가 같기 때문에 동일한 메소드로 판별됨 (중복오류)
//		=> 즉, 매개변수의 자료형의 갯수와 순서를 다르게 작성해야한다.
	/*
	 * public void test(int c, int d) {
	 * 
	 * }
	 */

	public void test(int a, int b, String s) {
		
	}
// 		=> 에러가 발생
//		=> 반환형이 다르다고 오버로딩이 적용되지는 않는다.
//		=> 메소드를 호출하는 시점에서 매개변수가 동일하기 때문에 에러가 발생한다.
//		=> 즉, 반환형과 상관없이 매개변수의 자료형의 갯수와 순서가 다르게 작성되어야 한다.
	/*
	public int test(int a, int b, String s) {
		return a + b;
	}
	*/
	
//		=> 에러가 발생
//		=> 접근제한자가 다르다고해서 오버로딩이 적용되지 않는다.
//		=> 즉, 접근제한자와 상관없이 매개변수의 자료형의 갯수와 순서가 다르게 작성되어야한다.
	/*
	private void test(int a, int b, String s) {
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
}
