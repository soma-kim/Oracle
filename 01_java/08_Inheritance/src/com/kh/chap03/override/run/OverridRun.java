package com.kh.chap03.override.run;

import com.kh.chap03.override.model.vo.Book;

public class OverridRun {

	public static void main(String[] args) {
//		��� Ŭ������ object Ŭ������ �ļ��̴�.
//		��, �ֻ��� Ŭ������ �׻� object
//		=> object�� �ִ� �޼ҵ���� �� ������ �� �� ����
//		=> object�� �ִ� �޼ҵ���� �� �Ը���� �������̵� �� �� ����
		
		Book bk = new Book("������ ���� ", "������" , 10000);
		System.out.println(bk /* .toSTring */); // �ּҰ�
		System.out.println(bk.hashCode()); // �ּҰ� ����������
//		object���� �����ϴ� ������ �޼ҵ�� ��ӹ޾Ƽ� ��� ����
//		���߿� �ϳ��� ���ĸ�..
//		toString() �޼ҵ�
		System.out.println(bk.toString()); // �ּҰ� ������ bk�� ������������ �����ϰ� ���
		
		/*
		 * * toStirng()�޼ҵ�
		 * �ش� ����Ÿ���� ǮŬ������ + @ + �ش� ��ü�� �ּҰ��� 16������ �����ִ� �޼ҵ�
		 * �˰Ը𸣰� ��ü�� �������� ��� ���������� toString() �޼ҵ尡 ȣ��� ��(JVM�� ����)
		 * 
		 * ��¹� �ȿ��� ������ ������ �����ؼ� �ش� ������ ����ϰ��� �� ��
		 * toString() �޼ҵ尡 ���������� �˾Ƽ� ȣ��ȴٶ�� ���� �̿��ؼ� 
		 * toString() �޼ҵ带 �������̵��ؼ� �� �ʵ��� ���� �Ѱ��� ���ڿ��� �������ְԲ� �������ؼ� ��!
		 * => ������ information �޼ҵ��� ������ toString�� �ϰԲ� �������̵� �ϰڴ�.
		 * 
		 */
		
		// �������̵� �� : com.kh.chap03.override.model.vo.Book@6d06d69c
		// �������̵� �� : title : ������ ���� , author : ������, price : 10000
		
		
		/*
		 * �� ���� 
		 * Ŭ���� ����
		 * public class Ŭ������ {
		 * 		//�ʵ�� 
		 * 		//�����ں� : �⺻������, ��� �ʵ忡 ���� �Ű����� ������
		 * 		//�޼ҵ�� : getter, setter �޼ҵ� + toString() �������̵�
		 * 
		 */
		
		
		
		
		
	}

}
