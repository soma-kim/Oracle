package com.kh.chap02.inherit.run;

import com.kh.chap02.inherit.medel.vo.Airplane;
import com.kh.chap02.inherit.medel.vo.Car;
import com.kh.chap02.inherit.medel.vo.Ship;

public class Run {
	public static void main(String[] atgs) {
//		��ü ����
		Car c = new Car("��Ʋ��", 12.5, "����", 4);
		Ship s = new Ship("�������̹�", 3, "�", 1);
		Airplane a = new Airplane("����774", 0.02, "������", 10, 5);
		
//		���
		System.out.println(c.information()); // Car Ŭ������ �����ǵ� information ȣ��
		System.out.println(s.information()); // Ship Ŭ������ �����ǵ� information ȣ��
		System.out.println(a.information()); // Airplane Ŭ������ ������ �� information ȣ��
//		���࿡ �� �ڽ�Ŭ������ information �޼ҵ带 ���������� �ʾҴٸ� (������ == �������̵�)
//		���� �θ�Ŭ������ Vehicle�� �ִ� information �޼ҵ�� ȣ����� ��!
//		=> �������ϴ� ���� �ڽĸ޼ҵ�� �켱���� �Ѿ�� ȣ��ȴ�!
		
		c.howToMove();
		s.howToMove();
		a.howToMove();
		
		/*
		 * * ����� ����
		 * - ���� ���� ���� �ڵ�� ���ο� Ŭ�������� �ۼ� ����
		 * - �ߺ��� �ڵ带 ���������� �����ϱ� ������ ���ο� �ڵ带 �߰��ϰų� ������ �� ����
		 * => ���α׷��� ���꼺�� ���������� ũ�� �⿩
		 * 
		 * * ����� Ư¡
		 * - �ڽ� Ŭ������ �θ� Ŭ������ �ڵ带 �� ������ �� �� ������
		 * 	  �θ� Ŭ������ �ڽ� Ŭ������ �ڵ带 ������ �� �� ����
		 * - Ŭ�������� ����� ���߻���� �Ұ����ϴ�. (���� ��Ӹ� ����, ���� �ϳ��� ��ħ)
		 *   ���� ���߻�ӽÿ� ���� ���� �ʵ��, �޼ҵ���� ���� �ſ� ����ؼ� ó������ ���Ƶ�
		 * - ��õǾ� ������ ������ ��� Ŭ���� (�ڹٿ��� �̸� ���� �����Ǵ� Ŭ����, ���� ���� Ŭ����)
		 * 	 object (�ڹٿ��� �̸� ���� �����Ǵ� Ŭ����) Ŭ������ �ļ��̴�.
		 * 	 => object Ŭ�������� �̹� ������� �޼ҵ带 ������ �� �� ����
		 * 	 => object Ŭ�������� �̹� ������� �޼ҵ尡 ���� �ȵ��
		 *      �������̵��� ���� �����ǰ� �����ϴ�.
		 */
		
		System.out.println(c.hashCode()); // ������ ������ �ּҰ� ��ȯ
		System.out.println(c.equals(s)); // ����� ��� ��ȯ
//		 => object��� �ֻ��� Ŭ�������� �����ϴ� �޼ҵ��!
		
		
	}

}
