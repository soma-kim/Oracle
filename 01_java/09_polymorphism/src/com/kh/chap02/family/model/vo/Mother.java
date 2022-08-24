package com.kh.chap02.family.model.vo;

public class Mother extends Person implements Basic {
//	필드부
	private String babyBirth; // 아기의 탄생 여부 : 출산, 입양, 없음
	
//	생성자부
	public Mother() {
		super();
	}
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	
//	메소드부
	public String getBabyBirth() {
		return babyBirth;
	}
	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", babyBirth : " + babyBirth;
	}
	
//	잠을 자는 행위, 밥을 먹는 행위
	@Override
	public void eat() { //엄마가 밥을 먹으면?
//		몸무게가 기존의 몸무게에 10 증가
		super.setWeight(super.getWeight() + 10);
//		수정할 몸무게 == 기존 몸무게 + 10
		
//		건강도는 기존의 건강도에 10 감소
		super.setHealth(super.getHealth() - 10);
//		수정할 건강도 == 기존의 건강도 - 10
	}
	
	@Override
	public void sleep() { // 엄마가 잠을 잔다면?
		super.setHealth(super.getHealth() + 10);
	}
	
}
