package com.kh.practice1.model.vo;

public class Dog extends Animal {
//	�ʵ��
	public static final String PLACE = "�ְ�ī��";
	private int weight;
	
//	�����ں�
	public Dog() {
		
	}
	public Dog(String name, String kind, int weight) {
		super(name, kind);
		this.weight = weight;
	}
	
//	�޼ҵ��
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override 
	public void speak() {
		System.out.println (super.toString() + "�����Դ�" + weight + "kg�Դϴ�.");
	}
	
	
}
	
