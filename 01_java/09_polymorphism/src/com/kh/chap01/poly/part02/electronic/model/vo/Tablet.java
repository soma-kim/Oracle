package com.kh.chap01.poly.part02.electronic.model.vo;

public class Tablet extends Electronic {
	private boolean penFlag;
	
	public Tablet() {
		
	}
	public Tablet (String brand, String name, int price, boolean penFlag) {
		super(brand, name, price);
		this.penFlag = penFlag;
	}
	public boolean isPenFlag() {
		return penFlag;
	}
	public void setPenFleg(boolean penFlag) {
		this.penFlag = penFlag;
	}
	
	public String toString () {
		return super.toString() + ", penFlag = " + penFlag + "]";
	}
}
