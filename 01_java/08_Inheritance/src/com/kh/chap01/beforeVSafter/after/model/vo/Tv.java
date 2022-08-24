package com.kh.chap01.beforeVSafter.after.model.vo;

// 자식 클래스
public class Tv extends Product {
//	필드부
	private int inch;
	
//	생성자부
	public Tv() {
	
	}
	public Tv(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}
		
	
//	메소드부
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
