package com.kh.chap04.field.model.vo;

public class Test {

	public static void main(String[] args) {
		FieldTest2 f2 = new FieldTest2 ();
		// ���ʿ� ���� ��Ű���� �ֱ� ������ import�� ���� 
		
		System.out.println(f2.pub); // public : �������� ���� 
		System.out.println(f2.pro); // protected : ���� ��Ű���� �ִ� ��Ȳ�̶� ���� ������ ������ ��Ȳ
		
		System.out.println(f2.df); // default : ���� ��Ű���� �ִ� ��Ȳ�̶� ���� ������ ����
		
//		is not visinble �߻� 
//		System.out.println(f2.pri); // private : �ش� Ŭ���� �������� ���� ������ ����
		
		
		
		
		
	}

}
