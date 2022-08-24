package com.kh.cha01.condition;

import java.util.Scanner;

public class B_Else {
	
	/*
	 * *if-else문 : 표현하고자 하는 경우의 수가 두개일경우 사용하는 조건문
	 * [표현법]
	 * if (조건식) { 
	 * 		해당 조건식이 true일 경우 실행하고자하는 코드;
	 * }
	 * else {
	 * 		위의 조건식이 false일 경우 실행하고자하는 코드;
	 * }
	 * 
	 * => 조건식의 결과가 true일 경우 if 블럭 안을 실행하고 if-else문 자체를 빠져나감
	 * => 조건식의 결과가 false일 경우 else 블럭 안을 실행하고 if-else문 자체를 빠져나감
	 */
	
	public void method1() {
		// 사용자에게 정수값을 입력받은 후에 짝수, 홀수 판별 후 결과 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		sc.hasNextLine();
		
		// 양수일 경우만 판별 가능하게끔 중첩 if문 사용
		if (num > 0) {
			
			// 짝수일 경우 또는 홀수 일 경우
			if(num % 2 == 0) { //짝수일 경우
				System.out.println("짝수입니다.");
			}
			else { //짝수가 아닐경우
				System.out.println("홀수입니다.");
			} 
			// else 블럭에서는 별도의 조건을 내세울 필요가 없음!!
			// 조건식 결과가 true이면 else 블럭을 건너 뛰기 때문에
			// 단독 if문 두개로 표현하는 것 보다는 효율적이다.
		}
		
		else { // 양수가 아닐경우
			System.out.println("양수를 입력해야 합니다.");
		}
	}
	
	/*
	 * * if-else if문 : 동일한 비교대상을 가지고 3개 이상의 조건을 제시해두고자 할때 사용되는 조건문
	 * 
	 * [표현법]
	 * if(조건식) {
	 * 		조건식1이 true일 경우 실행하는 코드;
	 * }
	 * else if(조건식2){ 
	 * 		조건식2가 true일 경우 실행할 코드;
	 * }
	 * else if(조건식3) {
	 * 		조건식3이 true일 경우 실행할 코드;
	 * }
	 * else {
	 * 		앞에서 제시한 모든 조건식들이 모두 false일 경우 실행할 코드;
	 * }
	 * 
	 */
	
	public void method2() {
		// 사용자로부터 정수 입력 후 양수 , 0, 음수 판별 후 출력
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		
		int num = sc.nextInt();
		
		if(num>0) { // 양수일 경우 
			System.out.println("양수입니다.");
		}
		else if (num == 0) { // 0일경우
			System.out.println("0입니다");
		}
		else { // 양수도 아니고 0도 아닐경우 == 음수일경우
			System.out.println("음수입니다");
		}
	}
	
	//실습문제
	public void method3() {
		
		/*
		 * 사용자로부터 나이를 입력받고
		 * 13세 이하까지 어린이, 14~18세까지 청소년, 19세 이상부터는 성인
		 * 판별 후 출력 
		 * 
		 * 경우의 수
		 * 우선적으로 고려해야할 것 : 나이는 0살부터 유효하게끔 (0보다 작을 경우 판별x)
		 * 					    나이가 0살부터라면 판별
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		if (age < 0) {
			System.out.println("잘못 입력했습니다.");
		}
		else {
			if (age <= 13) { // 나이가 13 이하라면
			System.out.println("어린이 입니다");
			}
			else if ((age > 13) && (age <= 18)) {
				System.out.println("청소년 입니다");
			}
			else {
				System.out.println("성인 입니다.");
			}
		}
	
	}


	// 숙제
	public void method4() {
		
		/*
		 * 사용자에게 점수를 입력받아
		 * 90점 이상일 경우 "A등급"
		 * 90점 미만 80점 이상일 경우 "B등급"
		 * 80점 미만 70점 이상일 경우 "c등급"
		 * 70점 미만일 경우 "D등급"
		 * 
		 * "당신의 점수는 xx점이고, 등급은 xxx입니다." (printf 출력)
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int num = sc.nextInt();
		
		sc.nextLine();
		
		// 0~100점 사이 => 유효한 점수로 처리 (등급 판별이 가능)
		// 아닐경우 => 잘못입력했습니다
		
		
		
		if(num >=0 && num <=100) {
			System.out.printf("당신의 점수는 %d 이고, 등급은 %s 입니다", num, "A");
		}
		
		else {
			if ((num < 90) && (num <= 80)) {
			System.out.printf("당신의 점수는 %d 이고, 등급은 %s 입니다", num, "B");
			}
			else if ((num < 80) && (num >= 70)) {
				System.out.printf("당신의 점수는 %d 이고, 등급은 %s 입니다", num, "C");
			}
			else if ((num < 70)) {
				System.out.printf("당신의 점수는 %d 이고, 등급은 %s 입니다", num, "D");
			}
			else {
				System.out.println("잘못입력했습니다.");
			}
		}
		
		
		
		
		
	}
}












