package com.kh.chap02.encapsulation.run;

import com.kh.chap02.encapsulation.model.vo.Student;

public class Run {

	/*
	 * 7. ĸ��ȭ �۾��� ���ؼ� �Ϻ��� Ŭ������ ���¸� ���߰� ����.
	 * 
	 * ĸ��ȭ�� ���� ������ : �ܺηκ��� ���������� �����ϱ� ������ �Ժη� ���� ����, ��ȸ�� �� �ִ�.
	 * 				   => �� �̽��� ���� ���� ĸ��ȭ �۾��� �ؾ���!!
	 * 
	 * * ��ü���� �����Ģ �� �ϳ��� "��������" => ĸ��ȭ �۾��� ���� ����
	 * * �������� ���������� ������, ��, ���������� ������ �� �ְԲ��� �������!! 
	 *   => �޼ҵ带 Ȱ���Ͽ� ���������� ������ �� �ְ� ����!!
	 *   
	 *   1) ���� ���� �ܰ� : �ʵ���� ���������ڸ� private���� �����ϱ� 
	 *   				  �ܺηκ��� �ʵ���� ���� ������ �������� �׻� �ʵ���� ���������ڴ� public�� �ƴ�
	 *   				  private�� ����. 
	 *   2) setter / getter �޼ҵ� ����� : ���������γ��� �����ؼ� ���� �����ϰų�(setter),
	 *   							     �� ���� ������ �� �ִ� �޼ҵ带 (getter) ������ �Ѵ�! 
	 *   
	 *   
	 */
	
	public static void main(String[] args) {
		
		Student hong = new Student(); // ��ü�� �����Ѵ�. (== �ν��Ͻ�ȭ(Ŭ������ ��üó�� �����)�Ѵ�.)
		
		/*
		hong.name = "ȫ�浿"; // is not visible ���� �߻� 
		hong.age = 20; 
		hong.height = 168.7;
		*/
		
		/*
		System.out.println(hong.name);
		System.out.println(hong.age);
		System.out.println(hong.height);
		*/
		
//		���� ���� ������ ���������� ���� ��� 
//		�츮�� private���� ���� ������ ���ƹ��ȱ� ������
//		.(�������ٿ�����)�� ���� �ʵ忡 ���� ������ �Ұ�������
//		=> ���������γ��� �޼ҵ带 ���� ������ �����ϵ��� �ؾ��� 
		
		hong.setName("ȫ�浿");
		hong.setAge(20);
		hong.setHeight(168.7);
		
//		���������� ��ȸ�� �� �ְ� �����ִ� getter �޼ҵ�� ȣ��
//		String name = hong.getName();
		
		System.out.println(hong.getName());
		System.out.println(hong.getAge());
		System.out.println(hong.getHeight());
		
//		xxx���� ���̴� xx���̰�, Ű�� xxx cm �Դϴ�.
		System.out.println(hong.getName() + "���� ���̴�" + hong.getAge() + "���̰� , Ű�� " + hong.getHeight() + "cm�Դϴ�.");
		System.out.println(hong.information());
		
		
//		�ǽ� 
//		�迵�� �л��� ��ü�� ���弼��
//		�̸� : �迵��, ����:21, Ű:180.4
		
		
		Student kim = new Student();
		
		kim.setName("�迵��");
		kim.setAge(21);
		kim.setHeight(180.4);
		
		System.out.println(kim.getName() + "���� ���̴�" + kim.getAge() + "���̰�, Ű�� " + kim.getHeight() + "cm�Դϴ�.");
		System.out.println(kim.information());
	}

}
