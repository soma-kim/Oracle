package com.kh.exam.model.vo;

public class Cat {
public static final String store = "가현가게";
	private String name;
	
//	생성자부
	public Cat() {
		
	}
	public Cat(String name) {
		this.name = name;
	}
	
//	메소드부 
//	setter 메소드들
	public void setName(String name) {
		this.name = name;
	}
//	getter 메소드들 
	public String getName() {
		return name;
	}
	
//	information 메소드들
	public String information() {
		return store + "에 살고 있는 " + name + "이 있습니다.";
	}
	
	
}
