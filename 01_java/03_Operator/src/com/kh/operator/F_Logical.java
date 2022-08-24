package com.kh.operator;

import java.util.Scanner;

// 논리 연산자
public class F_Logical {
	
	/*
	 * * 논리 연산자 : 이항연산자로써 두 개의 논리값을 연산하는 연산자
	 * 				즉, 논리값끼리 연산이 이루어지고 그 연산결과도 논리값
	 * 
	 * [ 종류 ]
	 *  AND 연산자 : 논리값 && 논리값
	 *  		      왼쪽, 오른쪽 둘 다 논리값이 true 여야지만 최종 결과가 true
	 *  			~ 이고, 그리고, ~ 이면서, .. => 둘 다의 느낌
	 *  
	 *  OR 연산자 : 논리값 || 논리값
	 * 			    왼쪽, 오른쪽 중에 하나라도 값이 true 라면 최종 결과가 true
	 * 			   ~ 또는, ~ 혹은, ~ 이거나, .. => 둘중에 하나 느낌
	 */
	
	public void method1() {
		
		// 사용자가 입력한 정수값이 양수 "이면서" 짝수인지 판별하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 한개 입력 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		boolean result = (num > 0) && (num % 2 == 0);
		// && 의 의미 : ~ 이면서, ~ 그리고, ~ 이고
		
		System.out.println("사용자가 입력한 값이 양수이면서 짝수입니까? : " + result);
	}
	
	public void method2() {
		
		// 사용자가 입력한 정수값이 1 이상 100 이하의 수인지 확인하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수값 한개 입력 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// 이상, 이하 => 해당 범위도 포함하는 개념 (<=, >=)
		// 미만, 초과 => 해당 범위를 포함하지 않는 개념 (<, >)
		
		// num 에 담긴 수가 1 이상 100 이하
		// 1 <= num <= 100 수학처럼 묶어서 표현 불가
		// 1 <= num 한개, num <= 100 한개 쪼개서 표현해야 함
		
		// num 에 담긴 수가 1 보다 크거나 같습니까? 
		// 그리고
		// num 에 담긴 수가 100 보다 작거나 같습니까?
		boolean result = (1 <= num) && (num <= 100);
		
		System.out.println("사용자가 입력한 값이 1 이상 100 이하입니까? : " + result);
		
	}
	
	public void method3() {
		
		// 사용자가 입력한 값이 y "이거나" Y 인지 확인하기
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계속하시려면 y 또는 Y 를 입력하세요 : ");
		char ch = sc.nextLine().charAt(0);
		
		boolean result = (ch == 'y') || (ch == 'Y');
		// || : 또는, ~ 이거나
		
		System.out.println("사용자가 입력한 값이 y 또는 Y 입니까? : " + result);
	}
	
	public void method4() {
		
		/*
		 * * 논리 연산자의 경우의수
		 *  && : 두 개의 조건이 모두 true 여야 결과값이 true (AND 의 의미)
		 *  	 true && true == true
		 *   	 true && false == false
		 *   	 false && true == false
		 *   	 false && false == false
		 *  || : 두 개의 조건 중 하나라도 true 일 경우 결과값이 true (OR 의 의미)
		 *   	 true || true == true
		 *   	 true || false == true
		 *   	 false || true == true
		 *   	 false || false == false
		 */
		
		int num1 = 10;
		
		boolean result1 = false && (num1 > 0); // false
		// 뒤의 비교연산 구문이 Dead code 라고 뜬다.
		// 경고 : 실행시 오류는 나지 않지만 추후에 오류가 생길 여지가 있는 상태
		// => false && 까지만 연산을 해버려도 어차피 결과는 false 이기 때문에
		//    뒤의 코드를 굳이 왜 작성했는지 알려주는 경고 (Dead code)
		
		System.out.println("result1 : " + result1);
		
		boolean result2 = true || (num1 > 0); // true
		// => true || 까지만 연산을 해버려도 어차피 결과는 true 이기 때문에 Dead code 발생
		
		System.out.println("result2 : " + result2);
	}

}





