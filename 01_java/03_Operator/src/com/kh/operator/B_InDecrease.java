package com.kh.operator;

// 증감 연산자
public class B_InDecrease {

	/*
	 * * 증감 연산자 : 단항연산자로써 값을 1씩만 증가시키거나 혹은 감소시키는 연산자
	 * 
	 * [ 종류 ]
	 * ++ : 값을 1씩 증가시키는 연산자
	 * 		++값 (전위연산자)
	 * 		값++ (후위연산자)
	 * 
	 * -- : 값을 1씩 감소시키는 연산자
	 * 		--값 (전위연산자)
	 * 		값-- (후위연산자)
	 * 
	 * (증감 연산자)값 : 전위연산 => 선증감 후처리
	 * 값(증감 연산자) : 후위연산 => 선처리 후증감
	 */
	
	public void method1() {
		
		int num = 10;
		
		System.out.println("num : " + num);
		
		num++; // num 에 1 을 증가시키겠다.
			   // num = num + 1; 와 같은 의미
		
		System.out.println("변경된 num : " + num);
		
		int num2 = 10;
		
		System.out.println("num2 : " + num2);
		
		num2--; // num2 에 1을 감소시키겠다.
				// num2 = num2 - 1; 와 같은 의미
		
		System.out.println("변경된 num2 : " + num2);
	}
	
	public void method2() {
		
		// ++ 기준으로
		// 전위연산 : 선증감 후처리
		int a = 10; // 이 시점에서는 a 의 값이 10
		int b = ++a; // a 의 값이 우선적으로 1 증가 후 b 에 대입된것
		
		System.out.println("a : " + a + ", b : " + b);
		
		// 후위연산 : 선처리 후증감
		int c = 10; // 이 시점에서는 c 의 값이 10
		int d = c++; // 우선적으로 d 에 c 의 값이 대입되고 나서 c 가 1 증가된것
		
		System.out.println("c : " + c + ", d : " + d);
	}
	
	public void method3() {
		
		int num1 = 20;
		int result1 = num1++ * 3;
		
		// result1 : 60
		// num1 : 21
		System.out.println("num1 : " + num1);
		System.out.println("result1 : " + result1);
		
		int num2 = 20;
		int result2 = ++num2 * 3;
		
		// num2 : 21
		// result2 : 63
		System.out.println("num2 : " + num2);
		System.out.println("result2 : " + result2);
		
		// 요령 : 후위연산자 같은 경우는 일단은 없다 생각하고 처리할걸 먼저 처리
	}
	
	// 퀴즈
	public void method4() {
		
		int a = 5;
		int b = 10;
		int c = (++a) + b;
		int d = c / a;
		int e = c % a;
		int f = e++;
		int g = (--b) + (d--);
		int h = 2;
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
	}
	
	
	
	
	
	
}






