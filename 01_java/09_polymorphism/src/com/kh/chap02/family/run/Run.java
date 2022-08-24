package com.kh.chap02.family.run;

import com.kh.chap02.family.model.vo.Baby;
import com.kh.chap02.family.model.vo.Basic;
import com.kh.chap02.family.model.vo.Mother;

public abstract class Run {

	public static void main(String[] args) {
		/*
//		�Ϲ�Ŭ���� : ��ü ������ ����
		Person p = new Person();
//		�Ϲ�Ŭ���� : �������� ���� ����
		Person p1 = new Mother();
		Person p2 = new Baby();
		*/
		
//		�߻�Ŭ���� : ��ü ������ �Ұ���
//		Person p = new Person();
		
//		�߻�Ŭ���� : ������ ���� ����
//		�������̽� ���� ��
		/*
		Person p1 = new Mother("�����", 50, 70, "���");
		Person p2 = new Baby("������", 3.5, 70);
		
		System.out.println(p1); // ���� : ������ 50, �ǰ��� 70
		System.out.println(p2); // �ֱ� : ������ 3.5, �ǰ��� 70
		
		p1.eat(); // ���� : ������+ 10, �ǰ��� - 10
		p2.eat(); // �Ʊ� : ������ + 3, �ǰ��� + 1
		p1.sleep(); // ���� : �ǰ��� +10
		p2.sleep(); // �Ʊ� : �ǰ��� +3
		
		System.out.println("===������===");
		System.out.println(p1);
		System.out.println(p2);
		*/
		
		
//		�������̽� ���� ��
//		Basic b = new Basic(); //�������̽��� ��ü ������ �Ұ���
		
//		�������� ���������� ���� ����
		Basic b1 = new Mother("�����", 50, 70, "���");
		Basic b2 = new Baby("������", 3.5, 70);
		
		System.out.println(b1);
		System.out.println(b2);
		
		b1.eat(); // ���� : ������ + 10, �ǰ��� - 10
		b2.eat(); // �Ʊ� : ������ + 3, �ǰ��� + 1
		b1.sleep(); // ���� : �ǰ��� + 10
		b2.sleep(); // �Ʊ� : �ǰ��� + 3
		
		System.out.println("===������===");
		System.out.println(b1);
		System.out.println(b2);
		
	}

}
