package com.kh.chap01.beforeVSafter.before.model.vo;

public class Desktop {
//	�ʵ��
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	private boolean allnOne; //��ü������ �ƴ��� ����

//	�����ں�
	public Desktop() {

	}

	public Desktop(String brand, String pCode, String pName, int price, boolean allnOne) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.allnOne = allnOne;
	}

//	�޼ҵ��
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setallnOne(boolean allnOne) {
		this.allnOne = allnOne;
	}

	public String getBrand() {
		return brand;
	}

	public String getpCode() {
		return pCode;
	}

	public String getpName() {
		return pCode;
	}

	public int getPrice() {
		return price;
	}

	public boolean isallnOne() { //boolean Ÿ�� �ʵ忡 ���� getter �޼ҵ���� ���ʻ� isxxx()���� ���´�.
		return allnOne;
	}
	
	public String information() {
		return "Brand : " + brand + ", pCode : " + pCode + ", pName" + pName + ", Price : " + price 
				+ ", allnOne :" + allnOne;
	}
}
