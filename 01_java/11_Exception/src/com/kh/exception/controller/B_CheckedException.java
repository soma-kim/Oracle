package com.kh.exception.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 예측 불가능한 예외들 (IOException의 자식들)
public class B_CheckedException {
	/*
	 * * CheckedException은 반드시 예외처리를 해야하는 예외들
	 *   (즉, 예측 불가한 곳에서 발생하기 때문에 미리 예외 처리 구문을 작성해야함)
	 * => 주로 사람이 아닌 외부 매체와 어떤 "입출력"이 발생할 때 예외가 나타남
	 */
	
	public void method1() throws IOException {
		/*
		try {
			method2();
		} catch(IOException e) {
			System.out.println("예외 발생됨");
		}
		*/
		method2();
	}
	
	public void method2() throws IOException {
//		Scanner와 같이 키보드로 값을 입력받을 수 있는 객체 (단, 문자열로만 가능)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아무 문자열이나 입력하세요 : ");
//		String str = br.readLine();
//		이 메소드를 호출시 IOException이 발생할수도 있음을 컴파일 에러로 알려줌(빨간 밑줄)
		
//		1. try ~ catch문
		/*
		try {
			String str = br.readLine();
			System.out.println("문자열의 길이 : " + str.length());
		} catch(IOException e) { //예외가 언제 발생될지 모름
			System.out.println("예외 발생됨");
		}
		*/
		
//		2. throws : 떠넘기기, 위임하기
//					지금 여기서 예외를 바로 처리하지 않고
//					현재 이 메소드를 호출한 곳으로 떠넘기겠다 라는 뜻
		String str = br.readLine();
		System.out.println("문자열의 길이 : " + str.length());
		
		
		
	}
	
	
	
}
