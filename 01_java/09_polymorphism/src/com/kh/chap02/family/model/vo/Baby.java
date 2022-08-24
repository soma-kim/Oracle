package com.kh.chap02.family.model.vo;

public class Baby extends Person implements Basic  {
//	필드부
//	생성자부
	public Baby() {
		
	}
	public Baby(String name, double weight, int health) {
		super(name, weight, health);
	}
//	메소드부
	public String toString ( ) {
		return super.toString();
	}
	
//	eat, sleep 메소드 오버라이딩
	@Override
	public void eat() { // 애기가 밥을 먹으면?
//		몸무게 3 증가
		super.setWeight(super.getWeight() + 3);
		super.setHealth(super.getHealth() + 1);
	}
	
	@Override
	public void sleep() {
//		건강도 3 증가
		super.setHealth(super.getHealth() + 3);
	}


		
		
}


