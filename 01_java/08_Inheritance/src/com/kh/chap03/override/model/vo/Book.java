package com.kh.chap03.override.model.vo;

//	��� Ŭ������ object Ŭ������ �ļ��̴�!
public class Book /* extends object */ {
//	�ʵ��
	private String title; // ����
	private String author; // ���ڸ�
	private int price; // ����

//	�����ں�
	public Book() {
		super();
	}

	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	// �޼ҵ��
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
	 * *�������̵�
	 * - ��ӹް� �ִ� �θ�Ŭ������ �޼ҵ带 �ڽ� Ŭ�������� ������(���ۼ�)�ϴ� ��
	 * - �θ� �����ϰ� �ִ� �޼ҵ带 �ڽ��� �Ϻ� ���ļ� ���
	 * - �������̵��� �ش� �޼ҵ带 ȣ���ϸ� �ڽ� �޼ҵ尡 �켱���� ����
	 * 
	 * * �������̵� ���� ����
	 * - �θ� �޼ҵ��� �޼ҵ���� ����
	 * - �Ű������� �ڷ���, ����, ������ ����(��, �Ű����� ����� ����)
	 * - ��ȯ�� ����
	 * - �θ�޼ҵ��� ���� �����ں��� ���ų� ���������� �� Ŀ����
	 * => �Ծ��� ������ ������ (������ �Ϸ��� �������� ��Ģ�� ���Ѿ���)
	 * 
	 * *�����ε�
	 *  - �޼ҵ���� �ߺ��ؼ� ������ �� �ִ� ��Ģ
	 *  - ����̶� ������ ���� ����!! 
	 *  - ���� ���� 
	 *   1. �޼ҵ���� ��ġ
	 *   2. �Ű������� �ڷ���,����,������ �޶���Ѵ�.
	 *   3. ��ȯ��, �Ű�������, ���������ڴ� ������ ���� ����
	 * 
	 * 
	 * * @Override ������̼�
	 *  - ���� ���� (��ø� ���ص� �θ�޼ҵ�� ���°� ���ٸ� �������̵��� �� �Ȱ�)
	 *  - ������̼��� ���̴� ���� ? (������ ���������� ���̴°� ����)
	 *   > �߸� ������� ��� ������ �˷��ֱ� ������ �ٽ� ������ �� �ְ� �����Ѵ�.
	 *   > Ȥ�ö� �θ� �޼ҵ尡 �Ŀ� �����Ǿ��� ��� ������ �˷��ֱ� ������ ���� �� �� �ְ� �����Ѵ�.
	 *   > �� �޼ҵ尡 �������̵� �� �޼ҵ�󸥰� �˸��� ���� �������� ���
	 * 
	 */
	
	/*
	@Override // ������̼� (��������) 
	public String toString() {
		return "title : " + title + ", author : " + author + ", price : " + price;
	}
	*/
	
//	�����ڵ� , getter / setter �ڵ��ϼ�
//	toString�� ���������� �ڵ��ϼ��� ���� 
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}

}
