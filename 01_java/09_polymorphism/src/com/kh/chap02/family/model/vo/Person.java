package com.kh.chap02.family.model.vo;

public abstract class Person {
//	필드부
	private String name;
	private double weight;
	private int health;

	
	
	public Person() {
	}
	
	public Person(String name, double weight, int health) {
		this.name = name;
		this.weight = weight;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public String toString() {
		return "name : " + name + ", weight : " +  weight + ", health : " + health;
	}
	
//	사람의 행위를 메소드로 표현
//	일반메소드 버전
	/*
	public void eat() {
		System.out.println("밥을 먹는다.");
	}
	public void sleep() {
		System.out.println("잠을 잔다.");
	}
	*/
	
//	추상 메소드 버전(abstract, 몸통부x) => 미완성된 상태 => 상속받는 측에서 완성시켜줘야함 (오버라이딩을 함으로써)
//	public abstract void eat();
//	public abstract void sleep();
//	=> 인터페이스로 빼버림 (강제성 부여)
	
	
}
