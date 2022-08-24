package com.kh.chap03.class_.model.vo;

// 클래스에서 사용 가능한 접근제한자 : public, default(생략가능) 
public class Product {
//	필드부
//	상품명, 상품가격, 브랜드 
	private String pName;
	private int price;
//	public static final String BRAND = "애플"; // 상수필드 => 변경 불가능한 필드값 
	private String brand = "애플"; // 필드 선언과 동시에 초기화 => 변경가능한 필드
	
//	생성자부 
	
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
//	 => 여기까지가 캡슐화! 
	
//	infomation 메소드 
	public String information () {
		return "pName : " + pName + ", price : " + price + ", brand : " + brand;
	}
}










