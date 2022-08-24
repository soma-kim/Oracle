package com.kh.exception.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

// 충분히 예측 가능한 오류들
public class A_UncheckedException {
	/*
	 * * RuntimeException
	 * - 프로그램 실행시 발생되는 예외들
	 * 
	 * * RuntimeException의 자식 클래스들
	 * - ArrayIndextOutOfBoundsException : 배열의 부적절한 인덱스로 접근할때 발생하는 예외
	 * - NegativeArraySizeException : 배열의 크기를 음수로 지정할 경우 발생하는 예외
	 * - ClassCastException : 허용할 수 없는 형변환이 진행될 경우 발생하는 예외
	 * - NullPointerException : 참조변수 값이 아직 null임에도 불구하고 접근하려고 할때 발생하는 예외
	 * - ArithmeticException : 나누기 연산 시 0으로 나눌때 발생하는 예외
	 * - ...
	 * 
	 * => 이러한 RuntimeException과 관련된 예외들은 충분히 예측 가능하기 때문에
	 * 	    예외 자체가 애초에 발생이 안되게끔 "조건문"으로 해결 가능하긴함 (선처리, 예방하는 개념)
	 *	    굳이 예외처리 (예외가 발생했을때 실행할 내용을 정의해두는 후처리, 수습의 개념)를 할 필요가 없음.
	 */
	
//	스캐너 객체를 전역변수로 셋팅
//	=> 이 클래스 내부의 모든 메소드에서 가져다 쓸 수 있게끔 해줄것
	Scanner sc = new Scanner(System.in);
	public void method1() {
//		ArithmeticException : 나누기 연산 시 0으로 나눌때 발생하는 예외
		
//		사용자로부터 두개의 정수값을 입력받아 나눗셈 연산을 출력
		System.out.print("첫번째 정수 : ");
		int num1 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("두번째 정수(0 제외) : ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
//		int result = num1 / num2;
//		System.out.println("나눗셈 연산 결과 : " + result);
		
//		해결방법1. 조건문으로 처리 (애초에 예외 자체가 발생하지 않게끔 if문으로 조건검사 후 계산 진행)
//					=> 예외처리가 아님 
		/*
		if(num2 !=0) {
			int result = num1 / num2;
			System.out.println("나눗셈 연산 결과 : " + result);
		}
		else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		System.out.println("프로그램 종료");
		*/
		
//		해결방법2. 예외처리 구문으로 해결
//					=> 예외가 발생했을 경우를 대비해서 실행할 내용을 정의해두는 것
		/*
		 * try ~ catch문
		 * [표현법]
		 * try {
		 * 		실행할 코드 (예외가 발생될 법한 구문이 포함되어있음);
		 * } catch(발생할예외클래스명 변수명) {
		 * 		해당 예외가 발생할 경우 실행할 구문;
		 * }
		 */
		try {
			int result = num1 / num2;
			System.out.println("나눗셈 연산 결과 : " + result);
			
		} catch(ArithmeticException e) {
			// System.out.println("0으로 나눌 수 없습니다.");
			e.printStackTrace(); // 오류를 추적할 수 있다.
			// 현재 예외가 어디에서 발생햇는지 알려줌
		}
		System.out.println("프로그램 종료");
	}
	
	public void method2() {
		System.out.print("정수 입력(0 제외) : ");
		
		try {

			int num = sc.nextInt(); // InputMismatchException이 발생할법한 구문 (정수 이외의 값을 입력할 경우)
			sc.nextLine();
			
			int result = 10 / num;
			System.out.println("나눗셈 결과 : " + result);

		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			
		} catch(InputMismatchException e) {
			System.out.println("정수를 제대로 입력해야합니다.");
			
		} // 다중 catch 블럭 : 예외가 여러개 발생할 가능성이 있을경우 일일이 catch블럭을 추가해서 디테일한 예외처리 가능
		System.out.println("프로그램 종료");
	}
	
	public void method3() {
		// ArrayIndexOutOfBoundsException : 배열의 부적절한 인덱스로 접근할 때 발생하는 예외
		// NegativeArraySizeException : 배열의 크기를 음수로 지정할 경우 발생하는 예외
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		sc.nextLine();
		
//		if문을 이용한 방법
		/*
		if(size >= 101) {
			int[] arr = new int[size]; // NegativeArraySizeException이 발생할법한 구문
			
			System.out.println("100번 인덱스 값 : " + arr[100]); // ArrayIndexOutOfBoundsException이 발생할법한 구문
		}
		*/
		
//		try ~ catch문을 이용한 방법
		/*
		try {
			int[] arr = new int[size];
			System.out.println("100번 인덱스 값 : " + arr[100]);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부적절한 인덱스로 접근했습니다.");
			
		} catch (NegativeArraySizeException e) {
			System.out.println("배열의 크기로는 음수를 제시할 수 없습니다.");
		}
	*/
	
		/*
		try {
			int [] arr = new int [size];
			System.out.println("100번 인덱스값 : " + arr[100]);
			
		} catch(RuntimeException e) { // 다형성을 적용하여 부모 타입의 예외 클래스로도 처리 가능
			System.out.println("예외가 발생하긴했음.. 배열의 크기를 음수로 입력했거나 부족절한 인덱스로 접근했음");
			// 다중 catch블럭은 줄어들지만 정확히 어떤 에러가 발생했는지 파악하기 어려워짐
		} 
		*/
		
		try {
			int [] arr = new int [size];
			System.out.println("100번 인덱스 값 : " + arr[100]);
			
		} catch (NegativeArraySizeException e) {
			System.out.println("배열의 크기로는 음수를 제시할 수 없습니다.");
			
		} catch (RuntimeException e) {
			System.out.println("예외가 발생하긴 했음");
			
		}
//		=> 다형성을 적용해서 부모예외클래스와 자식예외클래스의 catch블럭을 다중으로 작성하려면
//	  	      범위가 작은 자식타입의 예외 클래스를 먼저 기술해야한다. (자식 먼저, 부모 다음)
			System.out.println("프로그램 종료");
		}
	
	
	/*
	 * * RuntimeException 관련된 예외는
	 * - 조건문으로 해결 가능 : 예외 자체가 발생 안되게끔
	 * 					    개발자가 소스코드로 핸들링 가능 (예외처리x) => 예방의 개념
	 * - 예외처리 구문으로 해결 가능 : 예외가 발생햇을때에 대비해서 그때 실행할 내용을 정의해두는것 => 수습의 개념
	 * 
	 * 
	 * 예측이 가능한 상황 : 조건문으로 해결 (더 권장하는 방법)
	 * 예측이 불가능한 상황 : 무조건 예외처리 구문(try ~ catch문)으로 해결할 수밖에 없음 (ex. InputMismatchException)
	 * 
	 * => RuntimeException 계열은 모두 충분히 예측 가능한 상황이기 때문에
	 * 	    조건문으로 해결하는 것을 권장
	 *    즉, 예외처리 구문을 작성하는 것이 필수는 아님 = "Unchecked Exception"
	 * 
	 * 
	 */
}
	
	
	

