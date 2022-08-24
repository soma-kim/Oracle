package com.kh.chap02.encapsulation.model.vo;

// ĸ��ȭ ������ ��ģ student Ŭ���� 
public class Student {
	// �ʵ��
	/*
	 * �ʵ� : Ŭ���� �ȿ� �ٷ� �����صδ� ���� (== ������� == �ν��Ͻ� ����)
	 * 
	 * [ǥ����] ���������� �ڷ��� �ʵ��;
	 */

	private String name;
	private int age;
	private double height;

//	 �����ں�
//	 �޼ҵ�� 
	/*
	 * �� ���(�޼ҵ�)�� �����ϴ� �κ�
	 * 
	 * [ǥ����] ���������� ��ȯ�� �޼ҵ��(�Ű�����) { ��� ���� �ڵ� �ۼ�
	 * 
	 * ��ȯ���� �ִٸ� return �����ٰ�; }
	 */

//	 setter �޼ҵ� : �����͸� ��� �� �����ϴ� �뵵�� �޼ҵ�
//	 getter �޼ҵ� : �����͸� ��ȯ���ִ� ����� �޼ҵ�
//	 => setter / getter �޼ҵ�� �׻� ���� �����ؾ��ϱ� ������ public���� ����� 
//	 => �ʵ� �Ѱ��� setter / getter 1���� �� ���������� 

//	 setter �޼ҵ�� : �ַ� ������ �Ͼ 
//	 ���� String name, int age, double height �� ���Ͽ� �����
//	 �̸� ���� ��� �� ������ �� �ִ� �޼ҵ� (name�ʵ忡 �����ϴ� �뵵)
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * [setter �޼ҵ� ǥ����] public void set�ʵ��(�ش� �ʵ��� �ڷ��� �ش��ʵ��������ѸŰ�������) {
	 * 
	 * this.�ʵ�� = �Ű�������; }
	 * 
	 * => �ʵ�� �տ��� �׻� this.(���� �ּҰ��� ��Ī)�� �ٿ������ => �޼ҵ� ���� �ȿ����� �̸��� ������ �Ű����� (������ ��������
	 * ����)�� �� �켱������ ���� ��Ī�� �Ǳ� ������ ���� �뵵�� �ʵ�� �տ��� this.�� �ٿ����Ѵ� �ݵ��!!
	 */

//	���̰��� ��� �� ������ �� �ִ� �޼ҵ�(age �ʵ忡 �����ϴ� �뵵)
	public void setAge(int age) {
		this.age = age;
	}

//	Ű���� ��� �� ������ �� �ִ� �޼ҵ�(height �ʵ忡 �����ϴ� �뵵) 
	public void setHeight(double height) {
		this.height = height;
	}



//	getter �޼ҵ�� : �ʵ忡 ���� ���� �ܺη� �����Ű�� �뵵(������ �����ڴ�)
//					�ַ� �ʵ尪�� ��ȯ��Ű�� ������ �ۼ���
//	String name, int age, double height�� ���Ͽ� �ۼ�

//	name �ʵ忡 ����ִ� ���� �����ִ� �뵵�� �޼ҵ�
	public String getName() {
		return name;
	}
	
	/*
	 * [getter �޼ҵ� ǥ����]
	 * public �ش��ʵ����ڷ��� get�ʵ��() {
	 * 		return �ʵ��;
	 * }
	 * 
	 * => getter �޼ҵ忡���� �ʵ�� �տ� this.�� ������ ����
	 * 	  ���� �̸��� ������ �Ű������� ���� ����
	 */
	
//	age �ʵ忡 ���� ���� �����ִ� �뵵�� �޼ҵ�
	public int getAge() {
		return age;
	}
	

//	height �ʵ忡 ���� ���� �����ִ� �뵵�� �޼ҵ�
	public double getHeight() {
		return height;
	}


//	=> setter �޼ҵ�� getter �޼ҵ带 ������ִ� �������� ĸ��ȭ�̴�! 
	
//	��� �ʵ尪���� �ϳ��� ���ڿ��� ���̾ �����ִ� �뵵�� �޼ҵ�
//	=> ĸ��ȭ ������ �ƴϱ� ������ �ʼ��� �ƴ�, ������ ���ϴϱ� �� ������
	public String information() {
//		return name, age, height; => �ѹ��� �Ѱ��� ���� ���� �����ϴ�.
		return name + "���� ���̴�" + age + "���̰�,Ű�� " + height + "cm�Դϴ�.";
		
	}
	
}
