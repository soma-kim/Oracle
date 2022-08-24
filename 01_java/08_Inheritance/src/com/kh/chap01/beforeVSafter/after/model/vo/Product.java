package com.kh.chap01.beforeVSafter.after.model.vo;

//	�θ� Ŭ���� : �� Ŭ���� ��� ���������� ����ߴ� ��ҵ鸸 �����ؼ� �� �ѹ� �����ص� Ŭ����
public class Product {
//	�ʵ��
	private String brand;
	private String pCode;
	private String pName;
	private int price;
	
	/*
	protected String brand;
	protected String pCode;
	protected String pName;
	protected int price;
	*/
	
//	�����ں�
	public Product () {
	
	}
	public Product(String brand, String pCode, String pName, int price) {
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
	}
	
	
//	�޼ҵ��
	public String getBrand() {
		return brand;
	}
	public void setbrand (String brand) {
		this.brand = brand;
	}
	
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public int getprice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

	public String information() {
		return "brand : " + brand + ", pCode : " + pCode + ", pName : " + pName
				+ ", price : " + price;
		
	}
}
