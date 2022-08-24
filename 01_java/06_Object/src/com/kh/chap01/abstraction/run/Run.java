package com.kh.chap01.abstraction.run;

import com.kh.chap01.abstraction.model.vo.Student;

// 명심해야할 것 : 객체를 어렵게 생각하지말자, 단지 참조형 "변수" 일 뿐이다!!
public class Run {
	
	/*
	 * 1. 객체지향언어 : "객체" 를 "지향" 하는 언어로 "객체중심"으로 돌아간다.
	 * 
	 * 2. 객체란? : 사전적 의미로는 현실세계에 독립적으로 존재하는 (목적이 있고 의미가 있는) 모든 것들을 의미 (무형, 유형, 사물, 개념, ..)
	 * 
	 * 3. 객체지향프로그래밍 : 현실세계의 독립적인 존재들 (객체) 간의 상호작용 (행위) 을 만들어내는것
	 * 					=> 현실세계의 것들을 프로그래밍을 통해 가상세계 (코드)로 구현하는것
	 * 					예) 인터넷 쇼핑몰 구현
	 * 
	 * 4. 구현하고자 하는 프로그램 상의 객체를 만들기 위해서는 (생성하기 위해서는)
	 *    => "클래스" 라는 틀을 먼저 만들어야 한다.
	 * 		 (각 객체들의 속성(정보) 들을 담아낼 수 있는 그릇과도 같은 존재)
	 * 		 어떻게? => 1단계 추상화 + 2단계 캡슐화
	 * 
	 * 5. 추상화 과정
	 *    1) 내가 구현하고자 하는 프로그램에서 필요한 객체들을 생각해볼 것
	 *       예) 학생관리프로그램 => "학생"객체 : 홍길동학생, 김말똥학생, 박말순학생, ...
	 *    2) 그 객체들이 가지고 있는 공통적인 속성, 기능들을 모두 추출할 것
	 *       예) 이름, 나이, 성별, 연락처, 주소, ....
	 *    3) 그렇게 추출한 것들을 가지고 내가 구현할 프로그램의 "실질적인" 목적에 맞게끔 불필요한 속성, 기능들은 제거해서 추려내기
	 *       예) 학생의 "성적" 을 위주로 관리한다면 : 이름, 성적, 출석일수, ..
	 *           학생의 "건강" 을 위주로 관리한다면 : 이름, 나이, 성별, 몸무게, 키, 신발사이즈, 달리기속도, 윗몸일으키기갯수, ..
	 *    4) 최종적으로 추려진 속성들을 가지고 어떤 자료형에 어떤 이름으로 사용할건지 생각해보기
	 *       예) String name; // 이름
	 *           char grade; // 성적
	 *           int count; // 출석일수
	 *    
	 *    -----------------------------
	 *    
	 *    예) 학생관련 프로그램
	 *    1) 학생 관련 객체 (홍길동학생, 김영희학생, 김갑생학생, ...)
	 *    2) 공통적인 속성 및 기능들 뽑아내기 (이름, 나이, 성별, 주소, 전화번호, 키, 달리기속도,
	 *    							학년, 반, 국어점수, 수학점수, 몸무게, 신발사이즈, 머리색, 잠을잔다, 물을마신다,
	 *    							숨을쉰다, 밥을먹는다, ..)
	 *    3) 실질적인 목적에 맞는 속성들만 솎아내기 
	 *       학생 "인적사항" 을 관리하고 싶다면 : 이름, 나이, 성별, 주소, 전화번호, 학년, 반 만 추려낸다.
	 *       학생 "성적" 을 관리하고 싶다면 : 이름, 학년, 반, 국어점수, 수학점수 만 추려낸다.
	 *       학생 "건강" 을 관리하고 싶다면 : 이름, 키, 학년, 반, 몸무게, 잠을잔다, 밥을먹는다, 물을마신다, .. 를 추려낸다.
	 *    => 추려내는 과정이 가장 핵심적인 과정!!
	 *    
	 *    4) 최종적으로 우리가 추려낸게 이름, 나이, 키 라는 가정 하에
	 *       어떤 자료형의 어떤 이름의 변수로 표현할지 생각해보기
	 *       이름 : String name;
	 *    	 나이 : int age;
	 *       키 : double height;
	 *       
	 * 6. 위에서 선정된 것들을 가지고 본격적으로 프로그래밍을 할 것
	 *    1) "변수" 만을 가지고 프로그래밍을 하게된다면..
	 *       변수 : 하나의 자료형인 하나의 값만 보관할 수 있는 개념
	 *       "홍길동" 이라는 객체 하나를 만들기 위해서
	 *       => String name1 = "홍길동"; int age1 = 20; double height1 = 168.9;
	 *       => String name2 = "김영희"; int age2 = 21; double height2 = 157.1;
	 *  	 => String name3 = "박말순"; int age3 = 22; double height3 = 183.3;
	 *  		...
	 *       => 수백명의 학생을 관리하는 프로그램을 구현해야 할 경우
	 *          수천개의 변수가 생겨날 것. 관리하기가 굉장히 힘듬!!
	 *          
	 *    2) "배열" 을 이용해서 프로그래밍을 하게된다면..
	 *       배열 : 하나의 자료형인 여러개의 값들을 보관할 수 있는 개념
	 *       학생들의 이름을 보관할 수 있는 배열
	 *       => String[] names = {"홍길동", "김영희", "박말순", ...};
	 *       
	 *       학생들의 나이를 보관할 수 있는 배열
	 *       => int[] ages = {20, 21, 22, ...};
	 *       
	 *       학생들의 키를 보관할 수 있는 배열
	 *       => double[] heights = {168.9, 157.1, 183.3, ...};
	 *       => 변수만 쓰는것보다는 훨씬 나아 보임
	 *       => 만약에 학생 한명이 전학을 온다면? 배열을 다시만들어서 복사까지 일일이 다 떠줘야 함
	 *       => 만약에 학생 한명이 전학을 간다면? 그 학생의 정보를 지우고 뒤에 있는 모든 정보들을 한칸씩 앞으로 땡겨줘야 함
	 *       							  해당 인덱스의 값을 정확하게 지워줘야지만 정보가 정확하게 보관될 수 있음
	 *       
	 *    3) 그래서 나온 개념이 "구조체" 라는 개념
	 *       구조체 : 한번에 서로 다른 자료형을 여러개 보관할 수 있는 일종의 배열 같은 형태
	 *       		String 값도 보관하고, int 값도 보관하고, double 값도 보관할 수 있는 
	 *       		나만의 배열같은 자료형을 하나 만들자! => 그게 바로 "클래스"
	 *       
	 *       * 클래스 : 각 객체들의 속성 정보들을 담아내는 그릇과도 같은 존재 (틀)
	 *                => 메소드 위주로 이루어진 클래스 : 기능 제공용 클래스 (Controller) => controller 패키지 내에 만듬
	 *                => 정보를 담는 용도로 만들어진 클래스 : VO (Value Object) => model.vo 패키지 내에 만듬
	 */
	
	public static void main(String[] args) {
		
		// 1. 추상화
		// 2. Student 클래스 만들기
		
			// 변수만을 가지고 프로그래밍을 한다면?
			// 홍길동 학생을 표현하고싶다!
			/*
			String name1 = "홍길동";
			int age1 = 20;
			double height1 = 168.7;
			*/
		
		// 3. Student 클래스(그릇, 틀) 를 통해 객체 생성
			// 객체 == 그동안 우리가 "대변할이름" 으로 불렀던 애
			// 객체 생성 구문
			// [ 표현법 ]
			// 클래스명 객체명 = new 클래스명();
		
		// 홍길동 학생의 객체를 만들기
		Student hong = new Student(); // "생성" 먼저 (메모리의 heap 영역의 공간 할당)
		
		// 만들어진 홍길동 학생의 객체에 들어있는
		// 그 필드들에 직접적으로 접근해서 값을 대입
		hong.name = "홍길동";
		hong.age = 20;
		hong.height = 168.7;
		// => 필드에 직접적으로 접근 시 . (직접접근연산자) 을 사용
		
		// 김영희 학생의 객체 만들기
		Student kim = new Student(); // "생성" 먼저
		
		// 직접적으로 접근해서 값 대입
		kim.name = "김영희";
		kim.age = 21;
		kim.height = 172.4;
		
		System.out.println(hong); // 주소값
		System.out.println(kim); // 주소값
		
		// xxx님의 나이는 xx살이고, 키는 xxx.xcm 입니다.
		System.out.printf("%s님의 나이는 %d살이고, 키는 %fcm 입니다. \n", hong.name, hong.age, hong.height);
		System.out.printf("%s님의 나이는 %d살이고, 키는 %fcm 입니다. \n", kim.name, kim.age, kim.height);
		
		// 각 필드에 직접적으로 접근해서 값도 대입하고, 값도 조회하는 꼴
		// 직접적으로 내가 각 필드에 접근해서 값을 대입하거나 조회할 경우 보안 문제가 생길 수 있다.
		// => 객체지향의 설계 원칙 중 하나가 "정보은닉" => 캡슐화 작업을 통해서 진행
	}

}












