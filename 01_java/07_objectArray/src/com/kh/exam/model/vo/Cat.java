package com.kh.exam.model.vo;

public class Cat {
public static final String store = "��������";
	private String name;
	
//	�����ں�
	public Cat() {
		
	}
	public Cat(String name) {
		this.name = name;
	}
	
//	�޼ҵ�� 
//	setter �޼ҵ��
	public void setName(String name) {
		this.name = name;
	}
//	getter �޼ҵ�� 
	public String getName() {
		return name;
	}
	
//	information �޼ҵ��
	public String information() {
		return store + "�� ��� �ִ� " + name + "�� �ֽ��ϴ�.";
	}
	
	
}
