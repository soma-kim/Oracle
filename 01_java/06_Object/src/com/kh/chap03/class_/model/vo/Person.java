package com.kh.chap03.class_.model.vo;

// 캡슐화 과정을 거친 Person 클래스
public class Person {
//	필드부
//	필드 == 멤버변수 == 인스턴스 변수
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String phone;
	private String email;

	
//	생성자부
	
//	메소드부
//	각 필드에 대입시키고자 하는 값을 전달 받아서 해당 필드에 대입 시켜주는 setter 메소드 7개 
//	setter 메소드명 : setxxx (낙타표기법)
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setPhone (String phone) {
		this.phone = phone;
	}
	public void setEmail (String email) {
		this.email = email;
	}

	
//	각 필드값을 돌려주는 getter 메소드 7개
//	getter 메소드명 : getxxx (낙타표기법)
	/*
	 * public 해당필드의자료형 getxxx() {
	 * 		return 해당필드명;
	 * }
	 */
	
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
//	 => 캡슐화 작업 끝! 
	
//	모든 필드값을 하나의 문자열로 연이어서 반환해주는 information 메소드
//	id : xxx, pwd: xxx, name:xxx, ...
	
	public String infomation() {
		return "id : " + id + ", pwd : " + pwd + ", name : " + name + ", age : " + age +
				", gender : " + gender + ", phone : " + phone + ", email : " + email; 
	}
	
	
	
	
	
}
