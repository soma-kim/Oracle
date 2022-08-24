package com.kh.operator;

// 논리부정 연산자
public class D_LogicalNegation {

	/*
	 * * 논리부정 연산자 : 단항연산자로써 논리값 (true / false) 를 반대로 바꿔주는 연산자
	 * 
	 * [ 표현법 ]
	 * !논리값
	 */
	
	public void method() {
		
		System.out.println("true 의 부정 : " + !true);
		System.out.println("false 의 부정 : " + !false);
		
		boolean b = true;
		boolean b2 = !b;
		
		// b2 에는 false 가 들어있을거임
		
		System.out.println("b : " + b); // true
		System.out.println("b2 : " + b2);
		
		// 논리부정 연산자는 연산 결과를 다시 자기자신한테 대입하지 않음!!
		
		System.out.println(!(3 + 5 < 1));
	}
}

