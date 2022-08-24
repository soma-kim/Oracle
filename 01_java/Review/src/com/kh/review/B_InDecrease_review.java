package com.kh.review;

public class B_InDecrease_review {

	/* *증감 연산자 : 단항연산자로써 값을 1씩만 증가시키거나 혹은 감소시키는 연산자
	 * ++값 : 전위 연산 => 선증감 후 처리
	 * 값++ : 후위연산 => 선처리 후 증감
	 */
	
	
	public void method1() {
		int num = 10;
		System.out.println("num : " + num);
		
		num++;
		
		System.out.println("변경된 num : " + num);
		
		int num2 = 10;
		num2--;
		
		System.out.println("num2 :" + num2);
	}
	
	public void method2() {
		int num1 = 20;
		int result = num1++ *3;
		
		System.out.println("num1:" + num1);
		System.out.println("result1:" + result);
		
		// result : 60
		// num2 : 21 
		
		
		int num2 = 20;
		int result2 = ++num2 *3;
		
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		// num2 = 20;
		// result2 : 63;
		
		
	}
	
}
