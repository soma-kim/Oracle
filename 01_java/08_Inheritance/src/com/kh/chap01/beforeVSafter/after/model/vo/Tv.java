package com.kh.chap01.beforeVSafter.after.model.vo;

// �ڽ� Ŭ����
public class Tv extends Product {
//	�ʵ��
	private int inch;
	
//	�����ں�
	public Tv() {
	
	}
	public Tv(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}
		
	
//	�޼ҵ��
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	
	public String information () {
		return super.information() + ", inch : " + inch;
	}
}
