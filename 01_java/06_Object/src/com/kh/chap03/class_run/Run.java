package com.kh.chap03.class_run;

import com.kh.chap03.class_.model.vo.Coffee;
import com.kh.chap03.class_.model.vo.Dog;
import com.kh.chap03.class_.model.vo.Person;
import com.kh.chap03.class_.model.vo.Product;

public class Run {

	public static void main(String[] args) {
//		Person�̶�� Ŭ����
//		== ����� ������ ����� ���� ���� ������ �ڷ��� 
//			(�������� �ڷ���, �������� ������ ���� ����)
//		== ����� ���� �ڷ���(Ŀ���� ����¡)
		/*
		Person p = new Person(); // ��ü ���� == �ν��Ͻ�ȭ 
		
		System.out.println(p);; // �ּҰ��� ���� 
		System.out.println(p.infomation()); // JVM�� ���� ä���� �⺻ ������ ��� 
		
//		�� �ֱ� => setter �޼ҵ�� 
		p.setId("user01");
		p.setPwd("pass01");
		p.setName("ȫ�浿");
		
		System.out.println(p.infomation());
		
		p.setAge(25);
		p.setGender('��');
		p.setPhone("010-1111-2222");
		p.setEmail("hong@naver.com");
		
		System.out.println(p.infomation());
		
//		------------------------------------------
//		��ǰ ��ü ����
		
		Product p1 = new Product();
		
//		default ������������ Ŭ������
//		�ٸ� ��Ű���� ���� ��� ���� �� �� ���� ���ѵ�
//		��, ���� ��Ű���� ���� ��쿡�� ��� ����!!
		
		
		p1.setpName("������11pro");
		p1.setPrice(100000);
		p1.setBrand("����");
		
		
		Product p2 = new Product();
		
		p2.setpName("���ÿ�ġ7");
		p2.setPrice(50000);
		p2.setBrand("����");
//		 p2.setBrand("����");
//		setter �޼ҵ�� ���� brand���� ���ص��� �ʾƵ� �ȴ�.
//		��, �ش� �ʵ带 ����� �������� �ʾұ� ������
//		�� ���Ŀ� ���� �����ϰ��� �Ҷ��� �������� setter �޼ҵ带 ȣ���ؼ� ���� ���� �����ϴ�.
		
		p1.setBrand("apple");
		System.out.println(p1.information());
		System.out.println(p2.information());
		*/
		
		Dog d = new Dog();
		d.setName("�������");
		d.setType("mix");
		d.setAge(5);
		d.setColor("white");
		d.setGender('��');
		d.setWeight(15);
		
		System.out.println(d.information());
		
		Coffee c = new Coffee();
		c.setName("ī���");
		c.setSize("tall������");
		c.setPrice(5500);
		
		System.out.println(c.infomation());
	}

}
