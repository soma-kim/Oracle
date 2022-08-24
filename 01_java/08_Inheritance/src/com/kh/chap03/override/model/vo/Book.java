package com.kh.chap03.override.model.vo;

//	모든 클래스는 object 클래스의 후손이다!
public class Book /* extends object */ {
//	필드부
	private String title; // 제목
	private String author; // 저자명
	private int price; // 가격

//	생성자부
	public Book() {
		super();
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	// 메소드부
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	
	/*
	 * *오버라이딩
	 * - 상속받고 있는 부모클래스의 메소드를 자식 클래스에서 재정의(재작성)하는 것
	 * - 부모가 제공하고 있는 메소드를 자식이 일부 고쳐서 사용
	 * - 오버라이딩시 해당 메소드를 호출하면 자식 메소드가 우선권을 가짐
	 * 
	 * * 오버라이딩 성립 조건
	 * - 부모 메소드명과 메소드명이 동일
	 * - 매개변수의 자료형, 갯수, 순서가 동일(단, 매개변수 명과는 무관)
	 * - 반환형 동일
	 * - 부모메소드의 접근 제한자보다 같거나 공유범위가 더 커야함
	 * => 규약의 개념이 들어가있음 (재정의 하려면 이정도의 규칙은 지켜야함)
	 * 
	 * *오버로딩
	 *  - 메소드명을 중복해서 정의할 수 있는 규칙
	 *  - 상속이랑 관련이 없은 개념!! 
	 *  - 성립 조건 
	 *   1. 메소드명은 일치
	 *   2. 매개변수의 자료형,순서,갯수가 달라야한다.
	 *   3. 반환형, 매개변수명, 접근제한자는 영향을 주지 않음
	 * 
	 * 
	 * * @Override 어노테이션
	 *  - 생략 가능 (명시를 안해도 부모메소드와 형태가 같다면 오버라이딩이 잘 된것)
	 *  - 어노테이션을 붙이는 이유 ? (생략은 가능하지만 붙이는걸 권장)
	 *   > 잘못 기술했을 경우 오류를 알려주기 때문에 다시 검토할 수 있게 유도한다.
	 *   > 혹시라도 부모 메소드가 후에 수정되었을 경우 오류로 알려주기 때문에 검토 할 수 있게 유도한다.
	 *   > 이 메소드가 오버라이딩 된 메소드라른걸 알리기 위한 목적으로 사용
	 * 
	 */
	
	/*
	@Override // 어노테이션 (생략가능) 
	public String toString() {
		return "title : " + title + ", author : " + author + ", price : " + price;
	}
	*/
	
//	생성자들 , getter / setter 자동완성
//	toString도 마찬가지로 자동완성을 제공 
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
