package com.kh.chap01.poly.part01.basic.model.vo;

public class Child2 extends Parent {
//	�ʵ��
	private int n;
	
//	�����ں�
	public Child2() {
		
	}
	public Child2(int x, int y, int n) {
		super(x,y);
		this.n = n;
	}
	
//	�޼ҵ��
	public int getN() {
		return n;
	}
	public void setN (int n) {
		this.n = n;
	}
	
	public void printchild2() {
		System.out.println("�� �ι�° �ڽ��̾�");
	}
	
	@Override
	public void print() {
		System.out.println("�� �ι�° �ڽ��̾�");
	}
}
