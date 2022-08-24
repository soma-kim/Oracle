package com.kh.chap02.loop;

import java.util.Scanner;

public class A_For {
	
	/*
	 * * for문
	 * 반복하고자 하는 횟수를 알고있을 때 사용하는 반복문
	 * 괄호 안에 반복을 지정하는 부분이 초기식, 조건식, 증감식 으로 이루어져있음
	 * 각 초기식, 조건식, 증감식에 의해서 반복할 횟수가 정해짐
	 * 
	 * [ 표현법 ]
	 * for(초기식;   조건식;    증감식) {
	 * 
	 * 
	 * 		반복적으로 실행하고자 하는 코드;
	 * }
	 * 
	 * - 초기식 : 반복문이 시작 될 때 "초기에 단 한번만 실행" 되는 구문
	 * 			(반복문에서 횟수를 지정할때 쓰고자 하는 변수를 선언 및 초기화 하는 구문)
	 * 			ex) int i = 1;
	 * - 조건식 : "반복문이 수행될 조건" 을 작성하는 구문
	 * 			 조건식이 true 일경우 반복문 실행
	 * 			 조건식이 false 가 되는 순간 반복문이 멈춤
	 * 			 (보통 초기식에 제시된 변수를 가지고 조건식을 작성)
	 * 			 ex) i < 10;
	 * - 증감식 : 반복문을 제어하는 변수 값을 증감 시키는 구문
	 * 			(보통 초기식에 제시된 변수를 가지고 증감식을 작성)
	 * 			 ex) i++;
	 * 
	 * * for문의 흐름
	 * for문을 만나는 순간
	 * 초기식 -> 조건식 (조건검사) -> true 일경우  -> 실행하고자하는 코드 실행 -> 증감식
	 * 		-> 조건식 (조건검사) -> true 일경우 -> 실행하고자하는 코드 실행 -> 증감식
	 * 		-> 조건식 (조건검사) -> true 일경우 -> 실행하고자하는 코드 실행 -> 증감식
	 * 		...
	 * 		-> 조건식 (조건검사) -> false 일경우 -> 실행하고자하는 코드 실행X -> 반복문을 빠져나옴
	 * 
	 * => 매번 조건식의 조건검사를 통해 조건이 true 일 경우만 반복해서 실행한다.
	 * 
	 * * 조건식부분에 대놓고 true 라는 값이 들어가면? 무한반복
	 * for(초기식; true; 증감식) 또는 for(;;)
	 */
	
	public void method1() {
		
		// "안녕하세요" 를 5번 반복해서 출력하고 싶다.
		/*
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		*/
		
		// 적은 횟수일 경우에는 복사 붙여넣기가 가능하지만
		// 100 번 반복하고 싶을 경우? 1000 번 반복하고 싶을 경우? => 실수할 여지가 있음
		
		// i 변수 값이 1 에서부터 5 보다 작거나 같을때까지 1씩 증가할동안 반복 수행
		// 1, 2, 3, 4, 5 (총 5회)
		for(int i = 1; i <= 5; i++) {
			
			System.out.println("안녕하세요");
		}
		
		// 5번 반복 돌리기 => 초기식, 조건식, 증감식은 항상 같을 필요가 없다!!
		
		// i 변수값이 0 에서부터 4 보다 작거나 같을때까지 1씩 증가할동안 반복 수행
		// 0, 1, 2, 3, 4
		for(int i = 0; i <= 4; i++) {
			
			System.out.println("저리가세요");
		}
	}
	
	public void method2() {
		
		// i 변수값이 1 에서부터 6보다 작을때까지 1씩 증가할동안 반복 수행
		// 1, 2, 3, 4, 5
		for(int i = 1; i < 6; i++) {
			
			System.out.println("반갑습니다");
		}
		
		// int i = 0;
		
		// i 변수값이 11 에서부터 16 보다 작을때까지 1씩 증가할동안 반복 수행
		// 11, 12, 13, 14, 15
		for(int i = 11; i < 16; i++) {
			
			System.out.println("다시만나요");
		}
		
		// int i = 0;
		
		// 참고로 초기식의 변수는 해당 for문 안에서만 사용할 수 있는 변수
		// 해당 for문 밖에 같은 이름의 변수를 또 쓰더라도 중복으로 처리되지 않음!!
	}
	
	public void method3() {
		
		// i 변수값이 1 에서부터 10까지 매번 2씩 증가할동안 반복 수행
		// 1, 3, 5, 7, 9
		for(int i = 1; i < 10; i += 2) {
			
			System.out.println("하이");
		}
	}
	
	public void method4() {
		
		// i 변수 값이 10 에서부터 6 보다 크거나 같을때까지 매번 1씩 감소할동안 반복 수행
		// 10, 9, 8, 7, 6
		for(int i = 10; i >= 6; i--) {
			
			System.out.println("헬로우");
		}
		
		// 참고
		// 제일 단순하게 반복되는 횟수를 지정하는 방법
		// int i = 0; i < 반복시키고자하는횟수; i++
		
		// 예시
		// int i = 0; i < 5; i++ => 0, 1, 2, 3, 4 (5회)
		// int i = 0; i < 7; i++ => 0, 1, 2, 3, 4, 5, 6 (7회)
		
	}
	
	public void method5() {
		
		// 반복이 돌때마다 매번 고정적인 문자열 말고 매번 달라지는 출력 결과를 보자
		
		// i 변수의 값이 1에서부터 10보다 작거나 같을때까지 1씩 증가시키면서 반복 수행
		// 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 (10회)
		/*
		for(int i = 1; i < 11; i++) { // i <= 10 와 같은 조건
			
			System.out.println("i : " + i);
		}
		*/
		
		// i 변수의 값이 0 에서부터 10보다 작을때까지 1씩 증가시키면서 매번 반복 수행
		// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 (10회)
		for(int i = 0; i < 10; i++) {
			
			// System.out.println("i : " + i);
			
			// 1부터 시작하고 싶다면?
			System.out.println("i : " + (i + 1));
		}
		
	}
	
	public void method6() {
		
		// 1 부터 10까지의 숫자를 한줄로 연이어서 출력
		// 1 2 3 4 5 6 7 8 9 10
		
		for(int i = 1; i <= 10; i++) {
			
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 1 부터 10 까지의 숫자들 중에서 홀수만을 출력
		// 1 3 5 7 9
		for(int i = 1; i <= 10; i += 2) { // 반복 총 5회, 홀수일경우만 반복 진행
			
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 다른 풀이
		for(int i = 1; i <= 10; i++) { // 반복 총 10회, 홀수, 짝수 모두 반복 진행
			
			// 하고싶은거 : 홀수일경우만 출력 (해당 값을 2로 나눴을 때의 나머지가 1인 경우)
			if(i % 2 == 1) { // i 가 홀수인 상태
				System.out.print(i + " ");
			}
		}
	}
	
	public void method7() {
		
		// 1 에서부터 10 까지의 숫자들의 총 합계
		
		// 방법1. int sum = 1 + 2 + 3 + ... + 10;
		
		// 방법2. 
		/*
		 * int sum = 0;
		 * 
		 * sum = sum + 1; => sum += 1;
		 * sum = sum + 2; => sum += 2;
		 * sum = sum + 3; => sum += 3;
		 * ...
		 * sum = sum + 10; => sum += 10;
		 * 
		 * 규칙을 찾자!
		 * => sum 이라는 변수에 매번 규칙적으로 더해지는 수는
		 *    1에서부터 10까지 매번 1씩 증가하면서 더해짐!!
		 */
		
		// 누적하여 더할 값을 담는 변수 선언 및 "0으로 초기화" (덧셈의 정확한 값을 얻기 위해서)
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			sum += i; // sum = sum + i;
		}
		
		System.out.println("sum : " + sum); // 55
	}
	
	// 실습문제
	public void method8() {
		
		// 1 에서부터 사용자가 키보드로 입력받은 수까지 모두 더해서 출력해보기
		
		// 고려해야할 사항 : 양수를 입력했을 경우에만 덧셈
		// 				  양수가 아닐경우에는 "잘못입력했습니다." 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("양수 입력 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		if(num > 0) { // 입력받은 수가 양수일 경우
			
			// 1 에서부터 해당 num 까지의 모든 수를 합산
			int sum = 0;
			
			for(int i = 1; i <= num; i++) {
				
				sum += i; // sum = sum + i;
			}
			
			System.out.println("sum : " + sum);
		}
		else { // 입력받은 수가 양수가 아닐 경우 => 잘못 입력한 경우
			
			System.out.println("잘못 입력했습니다.");
		}
	}
	
	public void method9() {
		
		// 1 에서부터 매번 달라지는 랜덤값(1 ~ 10 사이의 랜덤한 정수) 까지의 총 합계
		
		/*
		 * * 랜덤값 뽑기
		 * Math 클래스에 정의되어있는 random() 메소드를 호출하여
		 * 매번 다른 랜덤값을 얻어올 수 있음
		 * 
		 * [ 표현법 ] Math.random()
		 * => 0.0 ~ 0.9999999999.. 사이의 랜덤값이 발생
		 * => 0.0 <= 랜덤값 <= 0.999999999999..
		 */
		
		// int random = Math.random(); // double 형이라서 오류
		
		// int random = (int)Math.random();
		// 0.0 ~ 0.999999... => 0 ~ 0
		
		int random = (int)(Math.random() * 10) + 1;
		// 0.0 ~ 0.999999... => 0.0 ~ 9.999999... => 0 ~ 9 + 1 => 1 ~ 10
		
		// * Math.random() 메소드를 이용해서 내가 원하는 범위의 정수값을 뽑아내고자 할 때
		// (int)(Math.random() * 몇개의랜덤값) + 시작수
		
		// 예시) 로또 번호 추출 (1 ~ 45 까지의 랜덤값)
		// => (int)(Math.random() * 45) + 1
		
		System.out.println("현재 발생한 랜덤값 : " + random);
		
		int sum = 0;
		
		for(int i = 1; i <= random; i++) {
			
			sum += i;
		}
		
		System.out.printf("1부터 %d까지의 총 합은 %d입니다. \n", random, sum);
	}
	
	public void method10() {
		
		// 구구단 출력
		
		// 2단 출력
		// 2 X 1 = 2
		// 2 X 2 = 4
		// 2 X 3 = 6
		// 2 X 4 = 8
		// 2 X 5 = 10
		// 2 X 6 = 12
		// 2 X 7 = 14
		// 2 X 8 = 16
		// 2 X 9 = 18
		
		System.out.println("---- 2단 -----");
		
		for(int i = 1; i <= 9; i++) {
			
			System.out.printf("2 X %d = %d \n", i, (2 * i));
		}
	}
	
	// 실습문제
	public void method11() {
		
		// 사용자로부터 2 ~ 9 사이의 정수를 입력받아서 해당 구구단을 출력
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("2 ~ 9 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		if((2 <= num) && (num <= 9)) { // 2 ~ 9 사이의 정수가 맞다면
			
			System.out.printf("----- %d단 ----- \n", num);
			
			for(int i = 1; i <= 9; i++) {
				
				System.out.printf("%d X %d = %d \n", num, i, (num * i));
			}
		} 
		else { // 아니라면
			
			System.out.println("2 ~ 9 사이의 정수가 아닙니다.");
		}
	}
	
	// 중첩 for문
	public void method12() {
		
		// 1 2 3 4 5 
		// 1 2 3 4 5 
		// 1 2 3 4 5 
		
		// 3번 반복 => 기본적인 표현법 0 부터 반복하고자하는수보다작을때까지
		for(int i = 0; i < 3; i++) { // 0, 1, 2 (3회 반복)
			
			for(int j = 1; j <= 5; j++) {
				
				System.out.print(j + " ");
			} // 1 2 3 4 5 한줄 완성
			
			System.out.println();
		}
	}
	
	public void method13() {
		
		// ***** 1행 1열 ~ 5열
		// ***** 2행 1열 ~ 5열
		// ***** 3행 1열 ~ 5열
		// ***** 4행 1열 ~ 5열
		// ***** 5행 1열 ~ 5열
		
		// 5번 반복
		/*
		for(int i = 1; i <= 5; i++) { // 바깥쪽 for문 (5번)
			
			for(int j = 1; j <= 5; j++) { // 안쪽 for문 (5번)
				
				System.out.print("*");
			} // ***** 완성
			
			System.out.println();
		}
		*/
		
		// 총 반복횟수는? 
		// 안쪽 for문에서 5 번씩 총 5번
		// => total 25 번
		// => 안쪽 for문 반복횟수 * 바깥쪽 for문 반복횟수
		
		// 총 25 번의 반복을 반복문 한개로 처리하기
		for(int i = 1; i <= 25; i++) {
			
			System.out.print("*"); 
			
			// 별이 5개 찍힐때마다 enter 추가
			// => i 가 5의 배수일때마다 별을 찍고 개행을 추가하고자 함
			if(i % 5 == 0) {
				System.out.println();
			}
		}
	}
	
	public void method14() {
		
		// 1*** => 1행 1열일때
		// *2** => 2행 2열일때
		// **3* => 3행 3열일때
		// ***4 => 4행 4열일때
		
		for(int i = 1; i <= 4; i++) { // 4번 반복
			
			for(int j = 1; j <= 4; j++) { // 4번 반복
				
				if(j == i) { // 경우 1
					System.out.print(j); // 숫자 출력
				}
				else {
					System.out.print("*"); // 별 출력
				}
			} // 1*** 한줄 완성
			
			System.out.println();
		}
	}
	
	public void method15() {
		
		// *
		// **
		// ***
		// ****
		// *****
		
		for(int i = 1; i <= 5; i++) { // 5번
			
			for(int j = 1; j <= i; j++) { // 1트 : 1번, 2트 : 2번, 3트 : 3번, ..
				
				System.out.print("*");
			} // * 한줄 완성
			
			System.out.println();
		}
	}
	
	public void method16() {
		
		// 2 ~ 9 단까지 모두 출력
		for(int i = 2; i <= 9; i++) { // 8 번
			
			System.out.printf("----- %d 단 ----- \n", i);
			
			for(int j = 1; j <= 9; j++) { // 9 번
				
				System.out.printf("%d X %d = %d \n", i, j, (i * j));
			}
		}
		
		// 총 72 번의 연산이 이루어짐
	}
	
	// 숙제 : 풀이예정
	public void method17() {
		
		/*
		 * 사용자로부터 두개의 정수를 입력받아 그 사이의 모든 수를 오름차순 순서대로 출력하세요
		 * 단, 두 정수가 일치할경우는 "정수1과 정수2의 값이 같습니다." 출력
		 * 
		 * 실행예시1
		 * 정수1 입력 : 3
		 * 정수2 입력 : 7
		 * 
		 * 3 4 5 6 7
		 * 
		 * 실행예시2
		 * 정수1 입력 : 7
		 * 정수2 입력 : 3
		 * 
		 * 3 4 5 6 7
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수1 입력 : ");
		int num1 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("정수2 입력 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		if(num1 < num2) { // 시작점 : num1 ~ 끝점 : num2
			
			// i 변수의 값이 num1 에서부터 num2 보다 작거나 같을때까지 1씩 증가시키면서 반복 수행
			for(int i = num1; i <= num2; i++) {
				
				System.out.print(i + " ");
			}
		}
		else if(num1 > num2) { // 시작점 : num2 ~ 끝점 : num1
			
			// i 변수의 값이 num2 에서부터 num1 보다 작거나 같을때까지 1씩 증가시키면서 반복 수행
			for(int i = num2; i <= num1; i++) {
				
				System.out.print(i + " ");
			}
		}
		else {
		
			System.out.println("정수1과 정수2의 값이 같습니다.");
		}
	}
	
	// 실습문제
	public void method18() {
		
		/*
		 * 사용자로부터 영문 문자열을 입력받아
		 * 첫글자부터 마지막 글자까지 하나씩 모두 출력해보세요
		 * 
		 * 실행예시
		 * 영문 문자열을 입력하세요 : apple
		 * 
		 * 0번째 글자 : a
		 * 1번째 글자 : p
		 * 2번째 글자 : p
		 * 3번째 글자 : l
		 * 4번째 글자 : e
		 */
		
		// 문자열의 길이를 알아내는 메소드 : 총 몇개의 문자로 이루어진 문자열인지 알려줌
		// [ 표현법 ] 문자열.length()
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영문 문자열을 입력하세요 : ");
		String str = sc.nextLine();
		
		// 문자열을 이루는 문자의 갯수만큼 반복을 돌려가면서 각 자리의 문자들을 출력
		for(int i = 0; i < str.length(); i++) {
			
			System.out.println(i + "번째 글자 : " + str.charAt(i));
		}
	}
	
}








