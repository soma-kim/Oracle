package com.kh.chap02.inherit.medel.vo;

//	자식 클래스
public class Ship extends Vehicle {
// 필드부
	private int propeller; // 프로펠러 갯수

// 생성자부
	public Ship() {

	}

	public Ship(String name, double mileage, String kind, int propeller) {
		super(name, mileage, kind);
		this.propeller = propeller;
	}

// 메소드부
	public int getPropeller() {
		return propeller;
	}

	public void setPropeller(int propeller) {
		this.propeller = propeller;
	}

	public String information() {
		return super.information() + ", propeller : " + propeller;
	}

	@Override
	public void howToMove() {
		System.out.println("프로펠러를 돌려가며 움직인다.");
	}

}
