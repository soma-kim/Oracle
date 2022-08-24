package com.kh.chap02.inherit.medel.vo;

//	자식 클래스
public class Airplane extends Vehicle {
// 필드부
	private int tire;
	private int wing;

// 생성자부
	public Airplane() {

	}

	public Airplane(String name, double mileage, String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}

// 메소드부
	public int getTire() {
		return tire;
	}

	public void setTire(int tire) {
		this.tire = tire;
	}

	public int getWing() {
		return wing;
	}

	public void setWing(int wing) {
		this.wing = wing;
	}

	@Override
	public String information() {
		return super.information() + ", tire : " + tire + ", wing : " + wing;
	}

	@Override // 어노테이션 : 오버라이딩 된 메소드임을 알려주는 주석의 역할
	public void howToMove() {
		System.out.println("바퀴를 굴려 달리다가 날개를 휘저으며서 움직인다.");
	}

}
