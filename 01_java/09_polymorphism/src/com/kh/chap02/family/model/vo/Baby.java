package com.kh.chap02.family.model.vo;

public class Baby extends Person implements Basic  {
//	�ʵ��
//	�����ں�
	public Baby() {
		
	}
	public Baby(String name, double weight, int health) {
		super(name, weight, health);
	}
//	�޼ҵ��
	public String toString ( ) {
		return super.toString();
	}
	
//	eat, sleep �޼ҵ� �������̵�
	@Override
	public void eat() { // �ֱⰡ ���� ������?
//		������ 3 ����
		super.setWeight(super.getWeight() + 3);
		super.setHealth(super.getHealth() + 1);
	}
	
	@Override
	public void sleep() {
//		�ǰ��� 3 ����
		super.setHealth(super.getHealth() + 3);
	}


		
		
}


