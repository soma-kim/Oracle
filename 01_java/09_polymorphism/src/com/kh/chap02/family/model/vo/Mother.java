package com.kh.chap02.family.model.vo;

public class Mother extends Person implements Basic {
//	�ʵ��
	private String babyBirth; // �Ʊ��� ź�� ���� : ���, �Ծ�, ����
	
//	�����ں�
	public Mother() {
		super();
	}
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	
//	�޼ҵ��
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
	
//	���� �ڴ� ����, ���� �Դ� ����
	@Override
	public void eat() { //������ ���� ������?
//		�����԰� ������ �����Կ� 10 ����
		super.setWeight(super.getWeight() + 10);
//		������ ������ == ���� ������ + 10
		
//		�ǰ����� ������ �ǰ����� 10 ����
		super.setHealth(super.getHealth() - 10);
//		������ �ǰ��� == ������ �ǰ��� - 10
	}
	
	@Override
	public void sleep() { // ������ ���� �ܴٸ�?
		super.setHealth(super.getHealth() + 10);
	}
	
}
