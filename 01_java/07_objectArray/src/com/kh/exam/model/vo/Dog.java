package com.kh.exam.model.vo;

public class Dog {
//	�ʵ�� 
	private String name;
	private double weight;
	private double height;

//	�����ں�
	public Dog() {

	}

	public Dog(String name, double weight, double height) {
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

//	�޼ҵ��
	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double Weight) {
		this.weight = weight;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

//	information �޼ҵ�� 
	public String information() {
		return name + "�� �����Դ�" + weight + "kg�̰�, ���� ���̴�" + height + "cm �Դϴ�.";
	}

}
