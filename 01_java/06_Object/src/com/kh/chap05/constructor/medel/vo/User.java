package com.kh.chap05.constructor.medel.vo;

public class User {
//	 필드부
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;

//	 메소드부
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	
	
//	생성자부
	/*
	 * *생성자
	 * 메소드명이 클래스명과 동일하고 리턴 자료형이 없는 public 메소드
	 * 객체가 생성될 때 (new 문을 쓸때) 호출되는 메소드이다.
	 * 
	 * [표현법]
	 * public 클래스명(매개변수 => 생략가능) {
	 * 		객체가 생성될 때 내가 실행하고자 하는 코드;
	 * 		(내가 원하는 값으로 필드를 초기화 하는 코드를 주로 쓴다)
	 * }
	 * 
	 * 생성자를 작성하는 목적
	 * 1. 객체를 생성해주기 위한 목적
	 * 2. 객체 생성 뿐 아니라 매개변수로 전달된 값을 곧바로 필드에 초기화할 목적
	 * 
	 * 생성자 작성 시 주의사항
	 * 1. 반드시 클래스명과 이름이 동일해야함 (대소문자 구분)
	 * 2. 반환형이 존재하지 않는다. (메소드와 유사하게 생겨서 헷갈릴 수가 있으므로)
	 * 3. 여러개 작성이 가능하지만 매개변수가 중복되면 안된다. (이름은 중복가능하나, 매개변수를 다르게 적어준다 => 오버로딩)
	 * 4. 매개변수가 없는 기본생성자는 작성하지 않는다면 JVM에 의해 자동으로 만들어짐
	 *    단, 다른 생성자들이랑 같이 작성할 경우에는 매개변수가 없는 기본생성자를 꼭 명시해줘야함!
	 * 
	 * 
	 */
	
//	가장 기본적인 형태의 생성자 : 기본생성자
//	=> 매개변수가 없는 상태
//	=> 작성하지 않는다면 JVM에 의해서 자동으로 생성됨
	
	
	public User() {
//		기본생성자 == 매개변수가 없는 생성자
//		단지 객체를 생성 (공간을 확보) 만을 목적으로 할 때 사용
//		=> 그래서 보통의 경우는 아무 코드도 작성하지는 않음
//		기본 생성자를 생략하는 경우 => 오류도 나지 않고, 객체를  생성하는데 문제도 없었음
//						    => 그동안 알게모르게 JVM이 자동으로 만들어 줬기 때문에 가능
// 		단, JVM이 매번 기본 생성자를 만들어주는 것은 아니고
//		매개변수가 있는 다른 생성자를 내가 직접적으로 작성했을 때에는 JVM에 기본 생성자를 만들어주지 않음 
//		=> 즉, 어찌됐던 간에 기본생성자는 항상 작성하는 습관을 들이자!!
		
//		System.out.println("잘 출력이 되나?");
	}
	
	
//	매개변수가 있는 생성자 : 필드값을 "내가 원하는 값으로" 초기화하고자 할때 주로  쓰임
	public User(String userId) { // 객체 생성과 동시에 userId필드에만 값을 내가 원하는 형태로 초기화할 목적
		this.userId = userId;
	}
	
//	객체 생성과 동시에 userId, userPwd, userName 필드만 초기화해주는 생성자
	public User(String UserId, String userPwd, String userName) {
//		관례상 매개변수 생성자의 매개변수 명도 동일하게 필드명과 일치 시켜주게끔 작성한다.
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
//	객체 생성과 동시에 모든 필드에 대해서 내가 원하는 값으로 한번에 초기화까지 해줄 수 있는 생성자
	public User(String userId, String userPwd, String userName, int age, char gender) {
//		필수는 아니지만 있으면 편하므로 꼭 만들기!! 
		
		/*
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		*/
		
//		위와 같이 중복되는 동일한 초기화하는 구문이 있을 경우
//		해당 코드를 대체할 수 있는 생성자를 호출 가능함
//		=> this 생성자를 호출하면 됨
//		주의사항 : this 생성자 호출시에는 반드시 생성자 내부 첫줄에 기술해야함
		this(userId, userPwd, userName);
		
		this.age = age;
		this.gender = gender;
	}
		
	
//	메소드부
	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public String information() {
		return  "UserId : " + userId + " / userPwd : " + userPwd + " / userName : "
	+ userName + " / age : " + age + " / gender : " + gender;
	}

}
