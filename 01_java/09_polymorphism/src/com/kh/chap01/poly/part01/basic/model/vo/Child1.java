package com.kh.chap01.poly.part01.basic.model.vo;

public class Child1 extends Parent {
	// �ʵ��
	private int z;

	// �����ں�
	public Child1() {
	}

	public Child1(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	// �޼ҵ��
	public void setZ(int z) {
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void printChild1() {
		System.out.println("�� ù��° �ڽ��̾�");
	}
	
	@Override
	public void print() {
		System.out.println("�� ù��° �ڽ��̾�");
	}

}