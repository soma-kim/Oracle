package com.kh.chap02.objectArray.model.vo;

public class Phone {
	//필드부
	//이름, 시리즈, 브랜드명,가격
	private String name;
	private String series;
	private String brand;
	private int price;
	
	
//	생성자부
//	기본 생성자
	public Phone() {
		
	}
	
//	모든 필드에 대한 매개변수 생성자
	public Phone(String name, String series, String brand, int price) {
		this.name = name;
		this.series = series;
		this.brand = brand;
		this.price = price;
	}
	
//	메소드부
//	 getter 메소드들
	public String getName( ) {
		return name;
	}
	public String getSeries() {
		return series;
	}
	public String getBrand( ) {
		return brand;
	}
	public int getPrice() {
		return price;
	}
	
//	setter 메소드들
	public void setName(String name) {
		this.name = name;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
//	information 메소드
	public String information() {
		return "name : " + name + ", series : " + series 
				+ ", brand : " + brand + ", price : " + price;
	}
	
}
