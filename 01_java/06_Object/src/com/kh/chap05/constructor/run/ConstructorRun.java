package com.kh.chap05.constructor.run;

import com.kh.chap05.constructor.medel.vo.User;

public class ConstructorRun {

	public static void main(String[] args) {
//		User 클래스의 기본생성자를 이용해서 객체 생성
		User u1 = new User();
		u1.setUserId("user01");
		u1.setUserPwd("pass01");
		u1.setUserName("김말똥");
		u1.setAge(20);
		u1.setGender('남');
		
		System.out.println(u1.information()); // 기본값만 출력 
		
//		User 클래스의 String userId를 초기화해줄수 있는 매개변수 생성자를 이용해서 객체생성 
		User u2 = new User("user02");
	    u2.setUserPwd("pass02");      
	    u2.setUserName("김말이");      
	    u2.setAge(21);      
	    u2.setGender('여');  
		
		System.out.println(u2.information()); // userId만 내가 원하는 값으로 초기화
		
//		User클래스의 userId, userPwd, userName을 초기화해줄 수 있는 매개변수 생성자를 이용해서 객체생성
		
		User u3 = new User("user03", "pass03", "홍길동");
		u3.setAge(22);      
	    u3.setGender('남');   

		
		System.out.println(u3.information());
		
//		User 클래스의 모든 필드에 대해서 객체 생성과 동시에 내가 원하는 값으로 초기화 할 수있는
//		매개변수 생성자를 이요해서 객체 생성
		User u4 = new User("user04", "pass04", "박개순", 40, '여');
		
//		만약에 이 시점에서 비밀번호를 바꾸고 싶다면 setter메소드를 써야만 한다.
//		=> setter 메소드를 써야만 한다!!
		u4.setUserPwd("password04!");
//		매개변수 생성자가 있다 하더라도 setter 메소드는 반드시 필요하다!!
		
		System.out.println(u4.information());
	}

}
