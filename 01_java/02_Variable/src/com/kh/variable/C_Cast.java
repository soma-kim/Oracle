package com.kh.variable;

// 형변환과 관련된 개념
public class C_Cast {

	/*
	 * * 형변환 : 값의 자료형을 바꾸는 개념
	 * 
	 * * 컴퓨터 상에서의 값 처리 규칙
	 * 1. 대입연산자 (=) 를 기준으로 왼쪽과 오른쪽은 같은 자료형이여야함
	 *    => 즉, 같은 자료형에 해당되는 값만 대입이 가능하다.
	 *    => 다른 자료형의 값을 대입하고자 한다면 "형변환" 이 먼저 이루어져야함 (필수)
	 * [ 표현법 ] 자료형 변수명 = (바꿀자료형)값;
	 * 
	 * 2. 같은 자료형끼리만 연산이 가능함
	 *    => 즉, 다른자료형끼리 연산을 수행하고 싶으면 적어도 둘중에 하나는 "형변환" 을 먼저 한 후 자료형을 맞춰줘야 함 (필수)
	 * [ 표현법 ] 값 + (바꿀자료형)값;
	 * 
	 * 3. 1, 2 번 규칙을 합쳐서
	 *    같은 자료형끼리 연산이 이루어진 경우 그 연산결과는 동일한 자료형으로 나온다.
	 *    => 즉, 같은 자료형끼리 연산이 이루어진 그 결과는 그 동일한 자료형의 변수에만 대입이 가능하다.
	 *       ex) int result = int형숫자 + int형숫자;
	 * 
	 * * 형변환의 종류
	 * 1. 자동형변환 : 자동으로 형변환이 진행되기 때문에 내가 직접 형변환을 할 필요가 없음
	 * 				작은 바이트의 자료형 => 큰 바이트의 자료형
	 * 2. 강제형변환 (명시적형변환) : 자동형변환이 되지 않아 직접 내가 강제로 형변환 해야 하는 경우
	 * 							 큰 바이트의 자료형 => 작은 바이트의 자료형
	 * 							[ 표현법 ] (바꿀자료형)값;
	 * 
	 * * (바꿀자료형) : 형변환 연산자 == Cast 연산자
	 */
	
	// 자동형변환 : 작은 바이트 => 큰 바이트 로 자동으로 형변환 되는 경우
	public void autoCasting() {
		
		// 1. int (4byte) -> double (8byte)
		int i1 = 10;
		double d1 = /* (double) */ i1; 
		// 자동으로 형변환이 되었다.
		// 10 -> 10.0
		
		System.out.println("d1 : " + d1);
		
		int i2 = 12;
		double d2 = 3.3;
		
		double result2 = /* (double) */ i2 + d2; // 12.0 + 3.3 = 15.3
		
		System.out.println("result2 : " + result2);
		
		// 2. int (4byte) -> long (8byte)
		int i3 = 1000;
		long l3 = /* (long) */ i3; // 1000
		
		System.out.println("l3 : " + l3);
		
		long l4 = 2000; // L 을 붙이지 않아도 문제가 없는 이유 : 자동형변환이 되기 때문
		
		// 특이케이스 3. long (8byte) -> float (4byte)
		// 정수가 실수로 담길 때에는 큰 사이즈의 정수가 작은 사이즈의 실수에 대입 가능
		// 4byte float 은 사실 long 형보다 담을 수 있는 값의 범위가 더 크기 때문
		long l5 = 1000;
		float f5 = /* (float) */ l5; // 1000.0
		
		System.out.println("f5 : " + f5);
		
		// 특이케이스 4. char (2byte) <-> int (4byte) 양방향 형변환 가능
		// char 의 범위 : 0 ~ 65535 
		// 			      각 문자마다 고유의 정수값이 정해져 있다.
		// => 해당 정수값들을 각 문자로 매칭시켜주는 아스키코드표 
		//	  (0 ~ 127, 128가지의 문자를 나타낼 수 있음, 영문자 대소문자 알파벳, 숫자, 특수문자)
		// => 아스키코드표의 확장된 개념으로 유니코드표 
		//	  (0 ~ 65535, 65536가지의 문자를 나타낼 수 있음, 영어, 숫자, 특수문자, 한글, 그 이외의 언어)
		char ch = /* (char) */ 65; // 'A'
		System.out.println("ch : " + ch);
		
		int num = /* (int) */ 'A'; // 65
		System.out.println("num : " + num);
		
		System.out.println('김');
		System.out.println((int)'김'); // 44608
		
		int sum = 'A' + 10; // 유추 : 산술적인 연산 결과로는 75 
							// 		 문자로써 연산 결과로는 'K'
		
		System.out.println("sum : " + sum);
		System.out.println("sum : " + (char)sum);
		
		System.out.println("A 가 a 보다 큽니까? : " + ('A' > 'a'));
		// 문자 끼리 숫자만 가능한 연산도 가능하다!!
		
		// 특이케이스 5. byte 끼리의 연산, short 끼리의 연산
		byte b1 = 1;
		byte b2 = 10;
		
		byte result = (byte)(b1 + b2);
		// byte 나 short 로 연산 시 무조건 연산결과는 int 로 취급됨
		// => 강제로 형변환을 하면 저장 가능
	}
	
	// 강제형변환 (명시적형변환) : 큰 크기의 자료형을 작은 크기의 자료형으로 형변환 할 경우
	public void forceCasting() {
		
		// 1. double (8byte) -> float (4byte)
		float f1 = 4.0f; // 반드시 f 를 붙여줘야 함!
		
		double d2 = 8.0;
		float f2 = (float)d2;
		
		// 2. double (8byte) -> int (4byte)
		double d3 = 10.89;
		int i3 = (int)d3; // 10.89 -> 10
		
		System.out.println("i3 : " + i3);
		// 10 소숫점 아래 내용이 절삭됨 (즉, 데이터가 손실, 신중히 해야한다)
		
		int iNum = 10;
		double dNum = 5.89;
		
		// int iSum = iNum + dNum;
		// iNum 이 double 형으로 자동형변환이 되고 (10 -> 10.0)
		// iNum 과 dNum 이 더해지면서 15.89 가 됨
		// => double 형태인 결과인 15.89 값이 int 형 상자인 iSum 에 담길려고 해서 오류
		
		// 해결방법 1. 연산결과를 int 형에 맞춰서 강제형변환
		int iSum = (int)(iNum + dNum);
		System.out.println("iSum : " + iSum); // 15
		
		// 해결방법 2. 덧셈 연산 전에 dNum 을 int 형으로 강제형변환 후에
		//			그 다음에 덧셈 진행
		int iSum2 = iNum + (int)dNum;
		System.out.println("iSum2 : " + iSum2); // 15
		
		// 해결방법 1 과 해결방법 2의 순서 차이
		// 해결방법 1
		// 1단계 : iNum 이 double 로 자동형변환
		// 2 단계 : iNum 과 dNum 이 더해지고
		// 3 단계 : 더해진 결과가 int 형으로 강제형변환
		
		// 해결방법 2
		// 1단계 : dNum 이 int 로 강제형변환
		// 2단계 : iNum 과 dNum 이 더해지고
		
		// 해결방법 3. 애초에 결과값을 담을 변수를 double 형으로 지정
		double dSum = iNum + dNum;
		// 이 경우, 데이터 손실이 없어 정확한 값이 담김
		
		System.out.println("dSum : " + dSum); // 15.89
	}
	
	/*
	 * (바꾸고자하는자료형)값;
	 * 
	 * 작은사이즈 -> 큰사이즈 
	 * 큰사이즈 -> 작은사이즈
	 */
}
