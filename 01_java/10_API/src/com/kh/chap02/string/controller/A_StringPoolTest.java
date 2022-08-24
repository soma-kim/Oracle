package com.kh.chap02.string.controller;

//	String의 특성 
public class A_StringPoolTest {
//	1. 생성자를 통해서 String 변수에 문자열 담기
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1 /*.toString() */); //주소값이 아닌 내용물이 출력됨
		System.out.println(str2);
//		=> String 클래스에 toString 메소드가 내용물을 출력 할 수 있도록 오버라이딩 되어있음
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
//		=> String 클래스에 hashCode 메소드가 실제 담긴 내용물을 기반으로 십진수로 변경해서 리턴하는 오버라이딩 되어있음
		
//		정말 주소값에 대해서 알고 싶다면
//		System.out.identityHashCode(객체명);
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
//		str1과 str2의 주소값은 다르다.
		
//		문자열 비교
		System.out.println(str1 == str2); // 주소값 비교 => false
		System.out.println(str1.equals(str2)); // 문자열의 내용물 비교 => true
//		=> 원래 object 클래스에서 제공하는 equals 메소드는 주소값이 일치하는지 비교하는 메소드
//		=> String 클래스의 equals는 내용물을 동등비교 할 수 있게끔 오버라이딩 되어있음
	}
	
//	2. 문자열을 리터럴(값)로 생성
	public void method2() {
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1 == str2); //주소값 true
//		=> 진짜 주소값이 같나..?
		
//		<문자열을 생성할때 >
//		생성자를 통해서 만드는 방법 : 매번 생성되는 내용물이 같더라도 서로 다른 공간에 각각 생성됨 
//		리터럴을 제시해서 만드는 방법 : 매번 생성되는 내용물이 Heap영역 안에 StringPool(상수풀)에 생성됨
//		=> StringPool 공간의 특징 : 동일한 문자열이 존재 불가
	}
	
//	불변클래스(변하지 않는 클래스)
	public void method3() {
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str = "goodbye";
		System.out.println(System.identityHashCode(str));
		
		str += "abc"; // str = str + "abc";
		System.out.println(System.identityHashCode(str));
		
//		String 객체는 한번 생성되면 메모리 공간의 내용물이 변하지 않음
//		=> 불변클래스라고 부름
		
//		기존의 상수풀의 연결이 끊긴 문자열들은 가비지콜렉터가 알아서 정리해줌
//		불변클래스라고해서 내용물이 수정되는게 아니라 매번 새로운 주소값을 참조한다.
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
