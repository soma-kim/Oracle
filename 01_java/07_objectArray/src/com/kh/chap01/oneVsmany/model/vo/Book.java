package com.kh.chap01.oneVsmany.model.vo;

public class Book {
//	필드부
//	도서명, 저자명, 가격, 출판사
	private String title;
	private String author;
	private int price;
	private String publisher;
	
	
//	생성자부
//	매개변수가 없는 기본생성자 필수
	public Book() {
		
	}
	
//	모든 필드에 대해서 생성과 동시에 초기화 해줄 수 있는 매개변수 생성자
	public Book(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	
	
	
//	메소드부
//	getter / setter
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getPublisher() {
		return publisher;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor (String author) {
		this.author = author;
	}
	public void setPrice (int price) {
		this.price = price;
	}
	public void setPublisher (String publisher) {
		this.publisher = publisher;
	}
	
	// 모든 필드의 값을 하나의 문자열로 연이어서 리턴해주는 information
	public String information() {
		return "Title : " + title + ", Author : " + author + ", Price : " + price + ", Publisher : " + publisher ;
				
	}
	
	
	
}
