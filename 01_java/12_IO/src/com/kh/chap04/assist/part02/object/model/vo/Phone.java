package com.kh.chap04.assist.part02.object.model.vo;

import java.io.Serializable;

// ����ȭ ������ ���� ������ ��ü�� ���Ϸ� ������ �� NotSerializableException�� �߻�
// => 1byte¥�� ���� ��η� ū ��ü�� ������ �� ���� ������ ���η� �迭���ִ� ���� : ����ȭ
public class Phone implements Serializable { // ����ȭ ���� 
//	�ʵ��
	private String name;
	private int price;
	
//	�����ں�
	public Phone() {
		
	}
	public Phone(String name, int price) {
		this.name = name;
		this.price = price;
	}

	
//	�޼ҵ��
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
//	toString
	
	@Override
	public String toString() {
		return "Phone [name : " + name + ", price : " + price + "]";
	}
	
	
}
	

