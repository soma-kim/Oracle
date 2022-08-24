package com.kh.practice1.model.vo;

public abstract class Animal {
//	�ʵ��
	private String name;
	private String kind;

//	�����ں�
	public Animal() {
		
	}
	public Animal(String name, String kind) {
		this.name = name;
		this.kind = kind;
	}
//	�޼ҵ��
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	@Override
	public String toString() {
		return "���� �̸���" + name + "�̰�, ������" + kind + "�Դϴ�";
	}
	
	
	public abstract void speak();
}
