package com.kh.chap01.oneVsmany.run;

import java.util.Scanner;

import com.kh.chap01.oneVsmany.model.vo.Book;

public class ObjectRun {

	public static void main(String[] args) {
//		1. �⺻ �����ڷ� ��ü ���� �� setter �޼ҵ带 ���� �� �ʵ忡 �� ����
		/*
		 * Book bk1 = new Book(); // JVM�� ���� �⺻���� ���� bk1.setTitle("�ڹ��� ����");
		 * bk1.setAuthor("���ڹ�"); bk1.setPrice(20000); bk1.setPublisher("kh���ǻ�");
		 * 
		 * // 2. �Ű����� �����ڸ� �̿��Ͽ� ��ü ������ ���ÿ� �� �ʵ忡 �� ���� Book bk2 = new Book("���� ����å",
		 * "ȫ�浿", 15000, "�������ǻ�");
		 * 
		 * System.out.println(bk1.information()); System.out.println(bk2.information());
		 */

		/*
		 * // 3. ����ڰ� �Է��� ����� ��ü�� ���� Scanner sc = new Scanner (System.in);
		 * 
		 * // ����, ���ڸ�, ����, ���ǻ���� �Է¹޾� ���� ������ ��� System.out.print("���� : "); String title
		 * = sc.nextLine();
		 * 
		 * System.out.print("���ڸ� : "); String author = sc.nextLine();
		 * 
		 * System.out.print("���� : "); int price = sc.nextInt();
		 * 
		 * sc.nextLine();
		 * 
		 * System.out.print("���ǻ� : "); String publisher = sc.nextLine();
		 * 
		 * // Book ��ü ����� Book bk3 = new Book(title, author, price, publisher);
		 * System.out.println(bk3.information());
		 */

//		3���� Book ��ü�� �ʿ��ϴٴ� �����Ͽ� 
//		�� Book ��ü�� ���� ���� ����
//		��, ����ڿ��� �Է¹��� ������ �������� ��ü�� ���� ��
		Book bk1 = null;
		Book bk2 = null;
		Book bk3 = null;

		Scanner sc = new Scanner(System.in);
//		3���� ��ü ���� ������ �Է¹��� �� �� ��ü�� �ʱ�ȭ => ���� �߰� ���
		for (int i = 0; i < 3; i++) { // i : 0,1,2
			System.out.print("���� : ");
			String title = sc.nextLine();

			System.out.print("���ڸ� : ");
			String author = sc.nextLine();

			System.out.print("���� : ");
			int price = sc.nextInt();
			
			sc.nextLine();

			System.out.print("���ǻ� : ");
			String publisher = sc.nextLine();

			if (i == 0) {
				bk1 = new Book(title, author, price, publisher);
			} else if (i == 1) {
				bk2 = new Book(title, author, price, publisher);
			} else {
				bk3 = new Book(title, author, price, publisher);
			}
		}

//		��ü ���� ������ ����ϱ�(��ü ��ȸ ���)
		System.out.println(bk1.information());
		System.out.println(bk2.information());
		System.out.println(bk3.information());
		
//		����ڿ��� �˻��� ���� ������ �Է¹޾�
//		�� ��ü �������� ����� ������ ���Ͽ� ��ġ�ϴ� ������ ������ �˷��ִ� ���
//		=> ���� ��ȸ ���
		
		System.out.print("�˻��� å ���� : ");
		String searchTitle = sc.nextLine();
		
		if(bk1.getTitle().equals(searchTitle)) {
			System.out.println(bk1.getPrice());
		}
		if (bk2.getTitle().equals(searchTitle)) {
			System.out.println(bk2.getPrice());
		}
		if(bk3.getTitle().equals(searchTitle)) {
			System.out.println(bk3.getPrice());
		}
		
		
	}

}
