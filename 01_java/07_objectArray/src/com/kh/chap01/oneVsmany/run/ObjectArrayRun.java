package com.kh.chap01.oneVsmany.run;

import java.util.Scanner;

import com.kh.chap01.oneVsmany.model.vo.Book;

public class ObjectArrayRun {

	public static void main(String[] args) {
		// �迭 : �ѹ��� ���� �ڷ����� �������� ������ ���ÿ� ����
		// �迭�� ����� ���ÿ� �Ҵ�
		// �ڷ��� [] �迭�� = new �ڷ��� [������];

		// "book Ÿ���� �ּҰ���" ���� �� �ִ� ����
		// �ٸ� Ÿ���� �ּҰ��� ���� �� ���� !!!!! 
		Book[] arr = new Book[3]; // arr[0], arr[1], arr[2]
									// null null null

		Scanner sc = new Scanner(System.in);
//		3���� ��ü ���� ������ �Է� ���� �Ŀ� �� �ε����� �ش� ��ü�� ���� ���ٰ���
		for (int i = 0; i < arr.length; i++) {
			System.out.print("����  : ");
			String title = sc.nextLine();

			System.out.print("���� : ");
			String author = sc.nextLine();

			System.out.print("���� : ");
			int price = sc.nextInt();

			sc.nextLine();

			System.out.print("���ǻ� : ");
			String publisher = sc.nextLine();

			arr[i] = new Book(title, author, price, publisher);

		}
		
//		��ü ���� ���� ����ϱ�
		for (int i =0; i < arr.length; i++) {
//			System.out.println(arr[i]); // book Ÿ���� �ּҰ��� ���
			System.out.println(arr[i].information());
		}
		
//		�˻����
//		����ڿ��� �˻��� ���� ������ �Է¹޾� 
//		�� ��ü �������� ����� ������ ���Ͽ� ��ġ�ϴ� ������ ����
		System.out.print("�˻��� å ���� : ");
		String searchTitle = sc.nextLine();
		
		/*
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].getTitle().equals(searchTitle)) {
				System.out.println(arr[i].getPrice());
			}
		}
		*/
		
//		��������
//		�˻� ��� : ���࿡ ��ġ�ϴ� ������ ã�� ���� ��� "�˻��� ������ �����ϴ�" ���
//		��Ʈ : ������ Ȱ��! Ƚ���� ���� ������ int count = 0;

		
		
		
		
		
	}

}
