package com.kh.chap02.inherit.medel.vo;

//	�ڽ� Ŭ����
public class Airplane extends Vehicle {
// �ʵ��
	private int tire;
	private int wing;

// �����ں�
	public Airplane() {

	}

	public Airplane(String name, double mileage, String kind, int tire, int wing) {
		super(name, mileage, kind);
		this.tire = tire;
		this.wing = wing;
	}

// �޼ҵ��
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

	@Override // ������̼� : �������̵� �� �޼ҵ����� �˷��ִ� �ּ��� ����
	public void howToMove() {
		System.out.println("������ ���� �޸��ٰ� ������ �������缭 �����δ�.");
	}

}
