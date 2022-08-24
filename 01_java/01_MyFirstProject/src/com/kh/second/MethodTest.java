package com.kh.second;

// com.kh.second.MethodTest
public class MethodTest {
	
	/*
	 * 한 클래스 내에 여러개의 메소드를 정의해 둘 수 있음
	 * 무조건 메인 메소드를 포함할 필요도 없음
	 */
	
	// 일반 메소드들 작성
	public void testPrintA() {
		
		// 이 메소드가 호출되는 순간 실행할 내용 작성
		System.out.println("testPrintA 메소드 실행");
		
		// testPrintB 메소드 호출
		testPrintB(); // 나랑 같은 클래스 내에 위치하므로 메소드명만 호출한다.
		
		// testPrintC(); // testPrintC 메소드를 이 시점에서 호출
	}
	
	public void testPrintB() {
		
		System.out.println("testPrintB 메소드 실행");
		
		testPrintC(); // 이 시점에서 호출해도 같은 결과를 얻음
	}
	
	public void testPrintC() {
		
		System.out.println("testPrintC 메소드 실행");
		
		// testPrintA();
		// 만약 이 시점에서 testPrintA 메소드를 호출했을 경우?
		// => 무한 반복으로 A, B, C 가 호출되었음
		// => 이 경우 무한반복으로 결과가 실행되다가 StackOverflowError 가 발생
		// (메모리가 더이상 견디지 못하고 프로그램을 종료시킴)
		
		/*
		 * 배경지식
		 * 1. 코드 작성 => 하드디스크 (HDD) 에 저장 (정적인 형태 == "프로그램")
		 * 2. 컴파일러에 의해서 기계어로 번역
		 * 3. JVM 에 의해서 실행 => 메모리영역 (RAM) 으로 로딩됨과 동시에 실행 (동적인 형태 == "프로세스")
		 * 
		 * Stack : 메모리 공간의 유형 중 하나, Stack 의 크기를 벗어난 경우 StackOverflowError 발생
		 */
	}
	

}









