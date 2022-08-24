package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {

	/*
	 * * 변수 : "자료형에 맞는 값 하나만" 을 담을 수 있는 개념 예) int a = 10; a = 20;
	 * 
	 * * 배열 : "자료형에 맞는 값 여러개" 를 담을 수 있는 개념 예) int[] b = new int[3]; // int 형의 값이 들어갈
	 * 수 있는 방을 3개 만들겠다. // 방 [0], [1], [2] 호실이 만들어짐 // 인덱스는 항상 0에서부터 시작한다. // 문자열의
	 * 크기 = 5, 마지막 인덱스 = 4 // 배열의 크기 = 3, 마지막 인덱스 = 2 // 배열의 크기 = 7, 마지막 인덱스 = 6 //
	 * 항상 크기 = n , 마지막 인덱스 = n - 1 // => for 문에서 반복 횟수를 지정하는 가장 기본적인 방법 // int i =
	 * 0; i < 횟수; i++
	 * 
	 * b[0] = 5; b[1] = 10; b[2] = 15;
	 */

	public void method1() {

		// 배열을 왜 써야 할까?
		// 변수만을 이용해서 프로그래밍을 하게되면..

		// 0, 1, 2, 3, 4 를 기록해야함
		/*
		 * int num1 = 0; int num2 = 1; int num3 = 2; int num4 = 3; int num5 = 4;
		 * 
		 * // 출력할때는? => 일일이 출력해야 한다. 반복문 사용 불가 System.out.println(num1);
		 * System.out.println(num2); System.out.println(num3); System.out.println(num4);
		 * System.out.println(num5);
		 * 
		 * for(int i = 1; i <= 5; i++) {
		 * 
		 * // System.out.println(numi); // System.out.println("num" + i); }
		 * 
		 * // 총합계구할때는? => 일일이 더해줘야 한다. 반복문 사용 불가 int sum = num1 + num2 + num3 + num4 +
		 * num5;
		 */

		// 만약 기록해야하는 변수가 100, 1000, 10000 개로 늘어난다면?

		// 배열을 가지고 프로그래밍하기

		// 0, 1, 2, 3, 4 을 기록해야함

		/*
		 * 1. 배열 선언 [ 표현법 ] => 두가지 표현법이 있다. 자료형 배열명[]; 자료형[] 배열명;
		 */

		// int a; // 변수를 선언
		// int arr[]; // 배열을 선언
		// int[] arr;

		/*
		 * 2. 배열 할당 이 배열에 지금부터 몇개의 값들을 묶어서 보관할건지 배열의 크기를 지정해주는 과정 지정한 이 갯수만큼 값이 들어갈 방이
		 * 만들어짐
		 * 
		 * [ 표현법 ] 배열명 = new 자료형[배열크기];
		 */
		// arr = new int[5];

		// 변수 선언 및 초기화
		int a = 1;

		// 배열 선언 및 할당
		int[] arr = new int[5];

		// => 이 과정까지 거치지 않는다면 절대로 배열을 사용할 수 없음!!

		/*
		 * 3. 배열의 각 인덱스 방 자리에 값 대입 [ 표현법 ] 배열명[인덱스] = 값;
		 */
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;

		// 배열의 출력 => 반복문 활용이 가능!!
		/*
		 * System.out.println(arr[0]); System.out.println(arr[1]);
		 * System.out.println(arr[2]); System.out.println(arr[3]);
		 * System.out.println(arr[4]);
		 */

		for (int i = 0; i < 5; i++) {

			System.out.println(arr[i]);
		}

		// 총합계 구하기 => 반복문을 활용할 수 있다.
		int sum = 0;
		for (int i = 0; i < 5; i++) {

			sum += arr[i];
		}

		System.out.println("sum : " + sum);

		System.out.println(arr[0]); // 0 이라는 값이 잘 찍히는 거 가능
		System.out.println(arr); // [I@6d06d69c 와 같은 알 수 없는 값이 나온다 => 주소값!!
	}

	public void method2() {

		int i = 10;

		int[] iArr = new int[5];

		System.out.println("i : " + i);
		System.out.println("iArr : " + iArr);
		System.out.println("iArr 의 해시코드값 : " + iArr.hashCode());
		// 해시코드 : 주소값을 십진수의 형태로 보여주는 개념

		double[] dArr = new double[3];
		System.out.println("dArr : " + dArr);
		System.out.println("dArr 의 해시코드값 : " + dArr.hashCode());

		/*
		 * 기본자료형 : boolean, char, byte, short, int, long, float, double => stack 영역에 실제
		 * 값을 바로 담을 수 있는 변수 => 일반 변수
		 * 
		 * 그 이외의 자료형 : String, int[], double[], short[], byte[], Scanner, A_Array, ...
		 * => stack 영역에 주소값을 담고 있는 변수 (실제값은 heap 영역에 담겨있음) => 참조 변수 (레퍼런스 변수)
		 */
	}

	public void method3() {

		// 배열의 선언과 동시에 할당
		// 자료형[] 배열명 = new 자료형[사이즈];

		int[] iArr = new int[3]; // [0], [1], [2]
		double[] dArr = new double[3]; // [0], [1], [2]

		// System.out.println(iArr[0]);

		// 배열을 출력할 때 반복문을 쓰면 더 유리하다.
		// 0번 인덱스에서부터 마지막 인덱스까지 순차적으로 출력할 수 있다.
		// 마지막인덱스 == 배열의크기 - 1

		// 배열의 크기를 아는 방법
		// [ 표현법 ] 배열명.length
		// => 주의할점 : 여기서의 length 는 메소드가 아님!!
		System.out.println("iArr 배열의 크기 : " + iArr.length);
		System.out.println("dArr 배열의 크기 : " + dArr.length);

		/*
		 * for(int i = 0; i < 3; i++) {
		 * 
		 * System.out.println(iArr[i]); }
		 */

		for (int i = 0; i < iArr.length; i++) {

			System.out.println(iArr[i]);
		}

		for (int i = 0; i < dArr.length; i++) {

			System.out.println(dArr[i]);
		}

		/*
		 * 각각의 인덱스에 값을 대입하지 않아도 뭔가 담겨있음! int 형 배열에는 0, double 형 배열에는 0.0 이 담겨있음
		 * 
		 * => 메모리의 heap 영역에는 절대로 빈 공간으로 존재할 수 없음 배열이 만들어짐과 동시에 JVM 에 의해서 기본값으로 초기화가 진행됨
		 */
	}

	public void method4() {

		int[] arr = new int[5]; // [0], [1], [2], [3], [4]
								// 0 0 0 0 0
		/*
		 * arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 4; arr[4] = 5;
		 * 
		 * arr[10] = 10;
		 */
		// ArrayIndexOutOfBoundsException : 10
		// 배열의 인덱스 범위를 벗어남
		// 10 번 인덱스에서 오류가 발생

		// => 내가 한번 배열을 만들었으면 그 사이즈 범위를 벗어난 곳은 이용할 수 없다.
		// 제한된 범위 안에서만 이용 가능하다.

		// 값 대입을 위한 for문
		for (int i = 0; i < arr.length; i++) {

			arr[i] = i + 1;
		}

		// 값 출력과 동시에 누적 덧셈을 해주는 for문
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
			sum += arr[i];
		}

		System.out.println("총 합계 : " + sum);

		System.out.println("arr : " + arr); // 해당 배열의 주소값
		System.out.println("arr의 해시코드값 : " + arr.hashCode()); // 해시코드 : 주소값의 10진수형태
	}

	public void method5() {

		// 배열에 각 랜덤한 수를 대입

		int[] arr = new int[10]; // [0], [1], [2], .., [9]

		// 0 번 인덱스에서부터 마지막 9 번 인덱스까지 51 ~ 100 사이의 랜덤값 (총 50개)
		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) (Math.random() * 50) + 51;
		}

		// 잘 담겨있나 출력용 반복문
		// arr[x] : xx 형식 출력
		for (int i = 0; i < arr.length; i++) {

			System.out.printf("arr[%d] : %d \n", i, arr[i]);
		}

		// 랜덤한 숫자 (1 ~ 45) 를 중복 없이 6개를 뽑을 수 있는 프로그램? => 로또
	}

	public void method6() {

		int[] arr = new int[5];

		System.out.println(arr);
		System.out.println("arr 의 해시코드값 : " + arr.hashCode());

		/*
		 * arr[0] = 2; arr[1] = 4; arr[2] = 6; arr[3] = 8; arr[4] = 10;
		 */

		// 대입
		int value = 2; // 값 대입용 일종의 초기식
		for (int i = 0; i < arr.length; i++) {

			// arr[i] = (i + 1) * 2; // 2 4 6 8 10
			arr[i] = value;
			value += 2;
		}

		// 출력
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}

		// arr[5] = 12;
		// arr[6] = 14;

		/*
		 * 배열의 가장 큰 단점 한번 지정한 배열의 크기에 따라 제한적으로 사용됨 한번 지정한 배열의 크기를 변경 불가 => 배열의 크기를 변경하고자
		 * 한다면 어쩔수없이 새로운 배열을 만들어야함 (재할당)
		 */

		arr = new int[7]; // 할당만 다시해준꼴

		System.out.println();

		System.out.println("=== arr 변경 후 ===");
		System.out.println(arr);
		System.out.println("arr 의 해시코드값 : " + arr.hashCode());

		/*
		 * 메모리 영역은 항상 고유한 주소값을 가지고있음, 할당시 기존에 부여되었던 주소값과 절대 겹치지 않는다! 새롭게 배열을 할당만 다시 한다면
		 * 기존에 참조하고있던 연결이 끊어지고 새로운 곳을 참조하게됨 연결이 끊어진 기존의 배열은 heap 영역에 일단 동동 떠다님 일정 시간이
		 * 지나면 "가비지 컬렉터" 에 의해 정리됨 => 가비지 컬렉션 (자동 메모리 관리)
		 */

		// 참고) 현재 연결되어있는 고리만 끊고자 한다면?
		arr = null; // null : "없음" 을 의미하는 값

		System.out.println(arr); // null 출력
		// arr[0] = 10;
		// NullPointerException : 주소가 없는데 어떻게 접근해서 연산할래?
		// 라고 알려주는 오류
		// System.out.println(arr.hashCode());

		/*
		 * 기본 자료형의 기본값은 다음과 같다. 정수형 : 0 실수형 : 0.0 문자형 : ' ' 논리형 : false
		 * 
		 * 참조 자료형의 기본값은 다음과 같다 null : "없음" 을 나타내는 값 => "주소값이 없다"
		 */
	}

	// 실습문제
	public void method7() {

		// 3명의 사용자에게 매번 키의 정보를 입력받고 배열에 담아두고
		// 3명의 키 정보를 반복문을 이용하여 출력
		// 3명의 키 정보의 합계, 평균 (총 합계 / 갯수)

		Scanner sc = new Scanner(System.in);

		double[] heights = new double[3]; // [0], [1], [2]
											// 0.0 0.0 0.0

		for (int i = 0; i < heights.length; i++) {

			System.out.print("키 입력 (cm) : ");
			heights[i] = sc.nextDouble();

			sc.nextLine();
		}

		// 3 명의 키 정보를 출력, 합계도 같이구하기
		double sum = 0.0;
		for (int i = 0; i < heights.length; i++) {

			System.out.println(heights[i]);
			sum += heights[i];
		}

		// 3명의 키의 총 합계 출력, 평균 출력
		System.out.println("3명의 키의 총 합계 : " + sum);
		// System.out.println("3명의 키의 평균 : " + (sum / heights.length));
		System.out.printf("3명의 키의 평균 : %.2f \n", (sum / heights.length));
	}

	// 실습문제
	public void method8() {

		// 사용자에게 문자열을 하나 입력받은 후
		// 각각의 문자들을 char 배열에 옮겨담기

		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine();

		// 문자열 길이만큼의 방을 갖는 char 배열 만들기
		// (배열 크기 == 문자열의 길이)
		int length = str.length();
		char[] arr = new char[length]; // [0], [1], [2], ..., [length - 1]

		// 문자열로부터 각 인덱스 자리의 문자를 추출해서 각 배열의 방에 담기
		/*
		 * arr[0] = str.charAt(0); arr[1] = str.charAt(1); arr[2] = str.charAt(2);
		 */
		for (int i = 0; i < length; i++) {

			arr[i] = str.charAt(i);
		}

		// char 배열의 각 인덱스에 접근해서 값이 잘 담겨있는지 출력
		for (int i = 0; i < length; i++) {

			System.out.println(arr[i]);
		}
	}

	public void method9() {

		// 배열 선언
		int[] arr1;

		// 배열 할당
		arr1 = new int[5];

		// 배열의 선언과 할당
		int[] arr = new int[4];

		// 배열의 각 인덱스에 값 대입
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;

		// 배열 선언과 할당을 하는 동시에 값을 초기화(대입) 까지 한번에 끝내는 방법 2가지
		// 방법1.
		int[] arr2 = new int[] { 1, 2, 3, 4 };

		// 방법2.
		int[] arr3 = { 1, 2, 3, 4 };

		// 배열 비교
		System.out.println(arr == arr2); // false
		System.out.println(arr2 == arr3); // false
		System.out.println(arr3 == arr); // false
		// 주소값 간의 동등비교이기 때문에 false 가 나옴!!
		// (String 과 마찬가지)
	}

	// 실습 문제 => 숙제
	public void method10() {

		/*
		 * 좋아하는 과일의 갯수를 입력받아 그만큼 반복을 돌리면서 과일명을 입력받기 => 입력받을때마다 문자열 배열에 담기
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("좋아하는 과일의 갯수를 입력하세요 : ");
		int num = sc.nextInt();

		sc.nextLine();

		String[] fruits = new String[num];

		for (int i = 0; i < fruits.length; i++) {
			System.out.print("과일명 입력 : ");
			fruits[i] = sc.nextLine();
		}

		System.out.println("[좋아하는 과일 목록]");
		System.out.println(Arrays.toString(fruits));

	}

	public void method11() {

		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		// Array.sort(); => 오름차순 정렬하고 싶을 때
	}

}
