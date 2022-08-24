package com.kh.second.run;

import com.kh.second.MethodTest; // 해당 패키지에 있는 클래스를  이 클래스 영역 안에서 가져다 쓰겠다. (import)
import com.kh.first.HelloEveryone;

// com.kh.second.run.Run
public class Run {
	
	// 들여쓰기 : 키보드의 tab 키

	// 이 클래스에서 할 일 : 실행을 위한 main 메소드 만들기
	public static void main(String[] args) {
		
		
		System.out.println("프로그램 시작"); // 출력문도 일종의 메소드
		
		// 다른 메소드를 호출해보자
		
		/*
		 * * 메소드 호출 방법
		 * 1. 나랑 같은 클래스 안에 존재하는 메소드를 호출할 경우
		 * => 호출하고자하는메소드명();
		 * 
		 * 2. 나랑 다른 클래스 안에 존재하는 메소드를 호출할 경우
		 */
		
		// testPrintA();
		
		// 1) 내가 호출할 메소드가 존재하는 클래스를 생성 (new) 이라는걸 해야한다.
		// [ 표현법 ] 클래스명 대변할이름 = new 클래스명();
		// MethodTest mt = new MethodTest();
		
		// => 기본적으로 현재 같은 패키지 내에 해당 이름을 가진 클래스를 찾음
		//    다른 패키지에 존재하는 클래스이기 때문에 MethodTest 를 찾지 못함
		
		// 해결방법1) 해당 클래스가 정확히 어느 패키지에 있는 클래스인지 풀 클래스명을 명시하는 방법
		// com.kh.second.MethodTest mt = new com.kh.second.MethodTest();
		
		// 해결방법2) 그냥 클래스명을 가지고 생성 구문을 작성하되, 
		//			이 클래스가 어떤 패키지에 속해있는지 선언문을 추가하는 방법 => 주로 쓰이는 방법
		MethodTest mt = new MethodTest();
		
		// 2) 대변할이름을 생성 후 이제 해당 클래스에 있는 메소드를 호출
		// [ 표현법 ] 대변할이름.호출하고자하는메소드명();
		/*
		mt.testPrintA();
		mt.testPrintB();
		mt.testPrintC();
		*/
		// System.out.println("메인 메소드 끝");
		
		// testPrintA 메소드 하나만 호출해서 A, B, C 모두 출력하는 결과를 얻기
		mt.testPrintA();
		
		// 여태까지는 일반 메소드들만 호출해봤음
		// main 메소드도 호출해보자
		// HelloEveryone 클래스의 main 메소드를 호출할 예정
		// => 우선적으로 대변할이름을 만들어 줘야한다.
		// => main 메소드는 static 이라는 키워드가 붙었기 때문에 대변할이름을 만들지 않아도 바로 호출 가능
		// [ 표현법 ] 클래스명.메소드명();
		HelloEveryone.main(null); 
		// null : "없음" 을 나타내는 값
		
		/*
		 * 질문
		 * 1. } 를 닫았는데 오류 발생 => insert "}" => 중괄호 짝이 안맞았을 때 발생하는 오류
		 * 									  => 들여쓰기를 습관화 하자!
		 * 2. 메소드를 정의하는 순서와, 메소드가 실행되는 순서는 다름!!
		 */
	}
}





