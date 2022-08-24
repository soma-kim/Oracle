package com.kh.chap01.oneVsmany.model.vo;

public class Book {
//	�ʵ��
//	������, ���ڸ�, ����, ���ǻ�
	private String title;
	private String author;
	private int price;
	private String publisher;
	
	
//	�����ں�
//	�Ű������� ���� �⺻������ �ʼ�
	public Book() {
		
	}
	
//	��� �ʵ忡 ���ؼ� ������ ���ÿ� �ʱ�ȭ ���� �� �ִ� �Ű����� ������
	public Book(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
	}
	
	
	
//	�޼ҵ��
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
	
	// ��� �ʵ��� ���� �ϳ��� ���ڿ��� ���̾ �������ִ� information
	public String information() {
		return "Title : " + title + ", Author : " + author + ", Price : " + price + ", Publisher : " + publisher ;
				
	}
	
	
	
}
