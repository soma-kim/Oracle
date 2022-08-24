package com.kh.chap03.branch;

public class B_Continue {
	
	/*
	 * * continue문
	 * 반복문 안의 조건문에서 사용하는 구문
	 * continue문 을 만나게 되면 그 뒤에 어떤 구문이 오든간에 실행하지 않고
	 * 가장 가까운 반복문의 증감식으로 올라가라는 뜻이 됨
	 */
	
	public void method1() {
		
		// 1부터 10까지 홀수만을 출력
		// 1 3 5 7 9
		
		// 방법1. i 값을 매번 2씩 증가하는 방법
		/*
		for(int i = 1; i <= 10; i += 2) {
			
			System.out.print(i + " ");
		}
		*/
		
		// 방법2. 반복을 돌 때마다 바로 출력하는 게 아니라 홀수인지 판별 후 홀수일때만 출력하는 방법
		/*
		for(int i = 1; i <= 10; i++) {
			
			if(i % 2 == 1) {
				
				System.out.print(i + " ");
			}
		}
		*/
		
		// 방법3. continue 문을 이용하는 방법
		for(int i = 1; i <= 10; i++) {
			
			if(i % 2 == 0) {
				continue;
			}
			
			System.out.print(i + " ");
		}
	}
	
	public void method2() {
		
		// 1 부터 100 까지의 총 합계
		// 단, 6의 배수값은 건너뛰고 더하기
		
		// continue문 없는 버전
		/* 
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 6 != 0) { // 6의 배수가 아닐경우
				sum += i;
			}
		}
		
		System.out.println("sum : " + sum);
		*/
		
		// continue문이 있는 버전
		int sum = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 6 == 0) { // 6의 배수일경우
				continue;
			}
			
			sum += i;
		}
		
		System.out.println("sum : " + sum);
	}
	
	// 실습문제
	public void method3() {
		
		/*
		 * 2단 ~ 9단 까지 모두 출력하되
		 * 단, 4의 배수단인 4단, 8단은 제외하고 출력하세요
		 */
		
		// continue문이 없는 버전
		/*
		for(int i = 2; i <= 9; i++) {
			
			// 출력을 하긴 하되, 4의 배수가 아닌 단수에서만 출력하기
			if(i % 4 != 0) {
				System.out.printf("----- %d단 ----- \n", i);
				for(int j = 1; j <= 9; j++) {
					
					System.out.printf("%d X %d = %d \n", i, j, (i * j));
				}
			}
		}
		*/
		
		// continue문 있는 버전
		for(int i = 2; i <= 9; i++) {
			
			// i 가 4의 배수일경우는 뒤의 코드를 무시하고 바로 다음 증감식으로 넘어가겠다.
			if(i % 4 == 0) {
				continue;
			}
			
			System.out.printf("----- %d단 ----- \n", i);
			for(int j = 1; j <= 9; j++) {
				
				System.out.printf("%d X %d = %d \n", i, j, (i * j));
			}
		}
	}
	
	
	

}





