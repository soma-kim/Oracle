package com.kh.chap03.class_.model.vo;

// Ŭ�������� ��� ������ ���������� : public, default(��������) 
public class Product {
//	�ʵ��
//	��ǰ��, ��ǰ����, �귣�� 
	private String pName;
	private int price;
//	public static final String BRAND = "����"; // ����ʵ� => ���� �Ұ����� �ʵ尪 
	private String brand = "����"; // �ʵ� ����� ���ÿ� �ʱ�ȭ => ���氡���� �ʵ�
	
//	�����ں� 
	
//	setter
	public void setpName (String pName) {
		this.pName = pName;
	}
	public void setPrice (int price) {
		this.price = price;
	}
	public void setBrand (String brand) {
		this.brand = brand;
	}
	
//	getter 
	public String getpName() {
		return pName;
	}
	public int getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
//	 => ��������� ĸ��ȭ! 
	
//	infomation �޼ҵ� 
	public String information () {
		return "pName : " + pName + ", price : " + price + ", brand : " + brand;
	}
}










