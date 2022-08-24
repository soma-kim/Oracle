package com.kh.variable;

import java.util.Scanner;

// 사용자가 키보드로 입력한 값을 변수에 담는 방법
public class B_KeyboardInput {
	
	public void inputTest1() {
		
		/*
		 * * 자바를 통해서 사용자로부터 어떠한 값을 "입력" 받으려면
		 *   자바에서 제공하는 java.util.Scanner 클래스를 이용해야함
		 *   => Scanner 클래스에서 제공하는 이미 만들어진 메소드들을 호출하여야 한다!
		 *   
		 * - 만약 지금 내가 작성중인 클래스랑 다른 클래스에 있는 메소드를 호출하고싶을때
		 * 1. 내가 호출하고자하는 메소드가 있는 클래스를 대변할이름을 생성이라는걸 해줘야함 (new)
		 * 2. 만약에 그 클래스가 나랑 다른 패키지에 있을 경우에는 import 구문도 추가해야함
		 * 3. 만들어진 대변할이름을 통해서 해당 메소드를 호출
		 */
		
		Scanner sc = new Scanner(System.in);
		// System.in : 입력받은 값들을 바이트 단위로 읽어들이겠다 라는 의미
		
		// 사용자의 인적사항을 입력받는 프로그램 (이름, 나이, 키)
		
		// 입력받고자하는 내용을 먼저 출력을 해서 입력을 유도
		System.out.print("당신의 이름은 무엇입니까? : ");

		// 이름 : 김말똥, 홍길동, 고길동, .. => String (문자열)
		// 사용자가 입력한 값을 문자열로써 받아오는 메소드 : next(), nextLine()
		
		// sc.next(); // 입력만 받고 끝
		// String name = sc.next(); // 변수 선언과 동시에 키보드로부터 입력받은값을 대입한다. 
		
		// next() : 사용자가 입력한 값 중에서 공백이 있을 경우 공백 이전까지만 입력을 받는다.
		// ex) 김 가현 => 김
		
		// sc.nextLine(); // 입력만 받고 끝
		String name = sc.nextLine();
		
		// nextLine() : 사용자가 입력한 값 중에서 개행이 있을 경우  공백에 무관하게 한줄 단위로 입력을 받는다.
		// => 특히 사용자가 입력한 값에 공백이 포함될 여지가 있을 경우 nextLine() 을 사용하는게 더 좋다.
		//    ex) 주소지
		
		// Scanner 에서 제공하는 입력 메소드들은 모두 엔터를 치기 전까지 무작정 대기상태이다!
		
		// System.out.println(name);
		
		// 나이 : 10, 11, 12, 20, .. => int (정수)
		System.out.print("당신의 나이는 몇살입니까? : ");
		
		// 사용자가 입력한 값을 정수로써 받아오는 메소드 : nextInt()
		// sc.nextInt(); // 입력만 받고 끝
		int age = sc.nextInt(); 
		
		// 이 시점에서는 사용자가 엔터키를 누르기 전까지 대기상태
		
		// System.out.println(age);
		
		// 키 : 160.0, 177.2, .. => double (실수형)
		System.out.print("당신의 키는 몇 cm 입니까? : ");
		
		// 사용자가 입력한 값을 실수형으로 받아올 수 있는 메소드 : nextDouble()
		// sc.nextDouble(); // 입력만 받고 끝
		
		double height = sc.nextDouble();
		
		// 사용자가 엔터키를 누를때까지 대기상태
		
		// name, age, height 를 이용하여 하나의 문자열로 가공해서 출력하기
		// xxx님의 나이는 xxx살이고, 키는 xxxcm 입니다.
		System.out.println(name + "님의 나이는 " + age + "살이고, 키는 " + height + "cm 입니다.");
		
	} // inputTest1 메소드 영역 끝
	
	// 키보드로 값을 입력받을 때 종종 발생되는 문제
	public void inputTest2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		// 버퍼에 개행문자가 남아있는 상태
		sc.nextLine(); // 입력만 받고 끝
		// 버퍼가 비워진 상태
		
		// nextLine() 메소드는 버퍼에서 "엔터" 이전까지의 모든값을 가져온 후 버퍼를 비워주는 역할 (청소부)
		// nextLine() 이외의 메소드들은 버퍼를 비워주지 않음!!
		// => 결론 : nextLine() 이외의 메소드를 호출할 경우 nextLine() 으로 버퍼를 비워주기
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		// 이름, 나이, 주소, 키
		// xxx님은 xx살이며, 사는 곳은 xxxxx이고, 키는 xxxcm 입니다.
		System.out.println(name + "님은 " + age + "살이며, 사는 곳은 " + address + "이고, 키는 " + height + "cm 입니다.");
		
	} // inputTest2 메소드 영역 끝
	
	// 그 이외의 입력 메소드들
	public void inputTest3() {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * * Scanner 의 입력용 메소드들
		 * 문자열을 입력받고자 할 때 : next(), nextLine()
		 * 정수값을 입력받고자 할 때 : nextInt(), nextByte(), nextShort(), nextLong()
		 * 실수값을 입력받고자 할 때 : nextDouble(), nextFloat()
		 * 논리값을 입력받고자 할 때 : nextBoolean()
		 * 문자값을 입력받고자 할 때 : 해당 메소드가 없음
		 */

		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		// char gender = 문자타입으로입력받고자함;
		
		// index : 색인, 순번
		// "apple" 문자열에서 a 의 위치를 찾고싶다!
		//  01234
		// => a 의 위치값 (index) 은 0
		// => e 의 위치값 (index) 은 4
		
		// => 우선적으로 nextLine() 메소드를 이용해서 문자열 형태로 입력 받고,
		//    그 입력받은 문자열로부터 0번째 인덱스의 문자값 하나만 추출
		
		// charAt(위치값) : 문자열로부터 해당 위치값에 해당되는 문자 하나만 돌려주는 메소드
		// [ 표현법 ] 문자열.charAt(위치값);
		
		char gender = sc.nextLine().charAt(0); // 먼저 문자열을 입력받은 후 0번째 글자를 추출하여 gender 에 대입
		
		// StringIndexOutOfBoundsException : 추출하고자 하는 인덱스값이 문자열의 길이를 넘어섰을 때 발생
		// => 배열에서도 비슷한 오류 발생 예정
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		
		sc.nextLine();
		
		System.out.println(name + " 님의 개인정보");
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		
	} // inputTest3 메소드 영역 끝
	
	// 응용문제1
	public void inputTest4() {
		
		/*
		 * 영어 문자열 값을 키보드로 입력받은 후
		 * 그 문자열로부터 앞에서 세개를 출력해보세요.
		 * 
		 * 출력예시
		 * 첫번째문자 : x
		 * 두번째문자 : x
		 * 세번째문자 : x
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("3글자 이상의 문자열을 입력하세요 : ");
		
		// 흔히들 하는 실수
		// char ch1 = sc.nextLine().charAt(0);
		// char ch2 = sc.nextLine().charAt(1);
		// => nextLine 이 여러번 호출되는 꼴이기 때문에 여러번 입력받게됨
		
		String str = sc.nextLine(); // 우선적으로 문자열을 한번 입력받아서 변수에 보관해두기
		
		/*
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		
		System.out.println("첫번째 문자 : " + ch1);
		System.out.println("두번째 문자 : " + ch2);
		System.out.println("세번째 문자 : " + ch3);
		*/
		
		/*
		System.out.println("첫번째 문자 : " + str.charAt(0));
		System.out.println("두번째 문자 : " + str.charAt(1));
		System.out.println("세번째 문자 : " + str.charAt(2));
		*/
		
		// Apple 을 입력했을 경우 App 형태로 출력하고 싶다!
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		
		// System.out.println(ch1 + ch2 + ch3); // 289
		// char 는 int 형이랑 서로 형변환이 가능한 관계
		
		// 우리가 여태 배운 선에서 해결할 수 있는 방법
		// 해결방법1) 약간 무식한 방법
		/*
		System.out.print(ch1);
		System.out.print(ch2);
		System.out.print(ch3);
		*/
		
		// 해결방법2) 약간 예상치 못한 방법 ㄴㅇㄱ
		System.out.println("" + ch1 + ch2 + ch3);
		
	} // inputTest4 메소드 영역 끝
	
	// 응용문제2
	public void inputTest5() {
		
		/*
		 * 키보드로 정수 두개를 입력받아
		 * 두 수의 합, 차, 곱, 나누기한 결과를 각각 출력하세요
		 * 
		 * 힌트
		 * 덧셈 : +
		 * 뺄셈 : -
		 * 곱셈 : *
		 * 나누기 : /
		 * 
		 * 출력예시
		 * 더하기 결과 : x
		 * 빼기 결과 : x
		 * 곱하기 결과 : x
		 * 나누기 결과 : x
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		/*
		int result1 = num1 + num2;
		
		System.out.println("더하기 결과 : " + result1);
		*/
		
		System.out.println("더하기 결과 : " + (num1 + num2));
		// 연산의 우선순위 => 우선순위가 같을 경우 왼쪽에서부터 순차적으로 연산이 행해짐
		
	}
	
	// 숙제
	public void inputTest6() {
		
		/*
		 * 키보드로 가로, 세로 값을 실수형으로 입력 받아서
		 * 사각형의 면적과 둘레를 출력해주세요
		 * 
		 * 힌트
		 * 사각형의 면적 : 가로 * 세로
		 * 사각형의 둘레 : (가로 + 세로) * 2
		 * 
		 * 실행예시
		 * 가로길이를 입력하세요 : 13.5
		 * 세로길이를 입력하세요 : 41.7
		 * 
		 * 면적 : xx
		 * 둘레 : xx
		 */
		
		
	}
	
	

}









