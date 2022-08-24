package com.kh.chap01.math.run;

//	import java.lang.*;
//	생략가능, 보이진 않지만 항상 이미 import가 되어있다.

//	java.lang.Math 클래스 테스트
public class MathRun {

	public static void main(String[] args) {
//		Math클래스 (수학과 관련)에서 제공하고 있는
//		유용한 기능들에 대해서 살펴보자
		
//		Math math = new Math();
//		Math 클래스는 모든 필드가 상수 필드이고, 모든 메소드가 static 메소드이기 때문에
//		객체를 생성해서 불러올 필요가 없음 => 생성자도 private라 생성 구문 자체를 사용하지 않음!
		
//		1. 파이 : 원주율(3.14...)
//				 Math클래스 내에서 상수필드로 정의되어있음
		System.out.println("파이 : " + Math.PI);

		
//		<자주쓰이는 메소드들>
//		메소드명(매개변수) : 반환형
//		1. 올림 => Math.ceil(double) : 반환값 double형
		double num1 = 4.349;
		System.out.println("올림 : " + (int)Math.ceil(num1)); //더블형이 싫으면 int로 강제형변환하면 됨
		
//		2. 반올림 => Math.round(double) : 반환값 long형
		System.out.println("반올림 : "  + Math.round(num1));
		
//		3. 버림 => Math.floor(double) : 반환값 double형
		System.out.println("버림 : " + Math.floor(num1));

//		4. 절대값 => Math.abs(int.double/long/float) : 반환값 int/ double/ long/ float 그대로
		int num2 = -10;
		System.out.println("절대값 : " + Math.abs(num2));
		
//		5. 최소값 => Math.min(int, int) :  반환값 int형
		System.out.println("최소값 : " + Math.min(10,5));
		
//		6. 최대값 => Math.max(int, int) : 반환값 int형
		System.out.println("최대값 : " + Math.max(5, 10));
		
//		7. 제곱근(루트) => Math.sqrt(double) : 반환값 double형
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		
//		8. 제곱 => Math.pow(double, duoble) : 반환값 double형
		System.out.println("2의 10제곱 :" + Math.pow(2, 10));
		
//		9. 랜덤 => Math.random() : 반환값 double형
//								  0.0 ~ 0.9999999 ...
		System.out.println("랜덤수 : " + Math.random());
		
		
		/*
		 * java.lang.Math 클래스의 특징
		 * - 모든 필드 : 상수 필드
		 * - 모든 메소드 : static 메소드
		 * 
		 * 모든게 다 static이기 때문에 Math.으로 접근 가능(객체생성이 필요없음)
		 * Math 클래스의 생성자가 private이다. (애초에 생성 불가)
		 * 
		 * static : 프로그램 시작과 동시에 메모리 영역에 올려두고 공유하며 재사용하는 개념
		 * 	=> 싱글톤패턴 
		 */
		
//		<자바 개발자 문서>
//		https://docs.oracle.com/javase/8/docs/api/index.html
		
		
	}

}
