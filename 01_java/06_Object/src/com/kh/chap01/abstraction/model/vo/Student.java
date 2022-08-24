package com.kh.chap01.abstraction.model.vo;

/*
 * 클래스의 구조
 * 
 * public class 클래스명 {
 * 		
 * 		// 필드부
 * 		
 * 		// 생성자부
 * 		
 * 		// 메소드부
 * }
 */

// 학생들을 추상화해서 만든 클래스
public class Student {
	
	// [ 필드부 ]
	// 접근제한자 자료형 필드명(변수명);
	
	// 필드 : 클래스 안에 바로 선언하는 변수
	// 접근제한자 : 이 필드에 접근할 수 있는 범위를 제한할 수 있음
	//			(public > protected > default > private) => 퍼블릭으로 갈수록 공개된 범위, 프라이빗으로 갈수록 접근제한 강도 높음 
	//			클래스 영역 안에서 필드를 선언할 때 반드시 접근제한자를 붙여줘야 함
	public String name;
	public int age;
	public double height;
	
	// [ 생성자부 ]
	
	// [ 메소드부 ]

}









