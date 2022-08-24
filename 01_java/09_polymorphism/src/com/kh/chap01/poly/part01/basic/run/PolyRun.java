package com.kh.chap01.poly.part01.basic.run;

import com.kh.chap01.poly.part01.basic.model.vo.Child1;
import com.kh.chap01.poly.part01.basic.model.vo.Child2;
import com.kh.chap01.poly.part01.basic.model.vo.Parent;

public class PolyRun {

	public static void main(String[] args) {
		/*
		 * * ��ü�������α׷��� (Object Oriented Programming, OOP) 3���� 
		 * 		=> ĸ��ȭ, ���, ������
		 * 
		 * * ������ ���� �ڷ����� �������� ��ü�� �����Ͽ� �پ��� ����� ���� ���� 
		 * 			=> "���"���迡���� �̷���� �� �ִ� "����ȯ"�� ����!!
		 */

//		����� ���� : ���Կ�����(=)�� �������� ���ʰ� �������� �ڷ����� ���ƾ��Ѵ�.

//		1. �θ�Ÿ���� ���������� �θ� ��ü�� �ٷ�� ���
		System.out.println("1. �θ�Ÿ���� ���������� �θ� ��ü�� �ٷ�� ���");
		Parent p1 = new Parent();
		p1.printParent();
//		 p1.printChild1();
//		 => p1 ���������� Parent ��ü���� ���� ����

//		2. �ڽ� Ÿ���� ���� ������ �ڽ� ��ü�� �ٷ�� ���
		System.out.println("2. �ڽ� Ÿ���� ���������� �ڽ� ��ü�� �ٷ�� ���");
		Child1 c1 = new Child1();
		c1.printChild1();
		c1.printParent();
//		=> c1 ���������� Child1, Parent �Ѵ� ���� ����

//		3. �θ� Ÿ�� ���������� �ڽ� ��ü�� �ٷ�� ��� (�������� ����� ����)
		System.out.println("3. �θ� Ÿ�� ���������� �ڽ� ��ü�� �ٷ�� ��� (�������� ����� ����)");
		Parent p2 = /* (Parent) */ new Child1();
//		=> ���Կ����� �������� ������ �ڷ����� �ٸ����� �ұ��ϰ� ���� �߻� X
//		=> Child1 Ÿ���� ��ü�� Parent������ "�ڵ�����ȯ"�� �ǰ��ִ�.
//		=> "���" ���������� Ŭ�������� ����ȯ�� �����ϴ�!!

		p2.printParent(); // p2 ���������� Parent���� ���� ����
		((Child1) p2).printChild1(); // ��,Child������ ��������ȯ �� �� Child�� ���� ����

		/*
		 * "���" �������� Ŭ���� ���� "����ȯ"�� �����ϴ� 
		 * 1. UpCasting : �ڽ�Ÿ�� => �θ�Ÿ�� (�ڵ� ����ȯ, ����ȯ������ ���� ����) 
		 * 2. DownCasting : �θ�Ÿ�� => �ڽ�Ÿ�� (���� ����ȯ, ����ȯ�����ڸ� ��������� �ۼ��ؾ���)
		 */

//		�������� ���� ���� : ��ü �迭���� ���Ϸ��� ����

//		Child1 ��ü2��, Child2 ��ü 2���� �ʿ��� ��Ȳ�̶�� ��������
		Child1[] arr1 = new Child1[2];
		arr1[0] = new Child1(1, 2, 4);
		arr1[1] = new Child1(2, 1, 5);

		Child2[] arr2 = new Child2[2];
		arr2[0] = new Child2(5, 7, 2);
		arr2[1] = new Child2(2, 3, 5);

//		��, �������� ����Ǹ� �θ�Ÿ���� ����������
//		�پ��� �ڽİ�ü���� �޾� �� �� ����
		System.out.println("======= �������� ������ ��ü�迭 =======");
		Parent[] arr = new Parent[4];
		arr[0] = new Child1(1, 2, 4);
		arr[1] = new Child2(5, 7, 2);
		arr[2] = new Child1(2, 1, 5);
		arr[3] = new Child2(2, 3, 5);
//		�θ� Ÿ�Կ� ��涧�� �ڽ�Ÿ���� �ڵ�����ȯ �� ��! => UpCasting

//		arr[0].printParent();
		((Child1) arr[0]).printParent();
		((Child2) arr[1]).printchild2();
		((Child1) arr[2]).printChild1();
		((Child2) arr[3]).printchild2();
//		�ڽ�Ÿ�԰�ü�ν� ����ϰ��� �� ��쿡�� ��������ȯ���� ���󺹱� �Ŀ� ��� ����!! => DownCasting

//		((Child1)arr[3]).printChild1();
//		=> Child2 Ÿ���� arr[3]�� Child���� ����ȯ�Ϸ��� �ؼ� ������ �߻���!
//		ClassCastException : Ŭ������ ����ȯ�� �߸��Ǿ��� ��� �߻��ϴ� ����

		System.out.println("====== �ݺ��� �̿��ؼ� �غ��� ======");
		for (int i = 0; i < arr.length; i++) {
			// �� �ε��� ���� ������ �����ϰ� �ִ� �ڽ� Ŭ������ ����ȯ �Ŀ� �޼ҵ� ȣ��
			
			// instanceof ������
			// ���� ���������� ������ � �ڽ�Ŭ������ �����ϰ� �ִ��� Ȯ���Ҷ� ���
			// [ǥ����]
			// ���������� instanceof �˻���Ŭ������

			// �θ�ü�� instanceof �θ�Ŭ������ == true
			// �ڽİ�ü�� instanceof �θ�Ŭ������ == true (����� �޾����� �θ�Բ��� ����)
			// �θ�ü�� instanceof �ڽ�Ŭ������ == false (�θ�ü�� �ڽİ�ü�� ���빰�� ���� �Ұ�)
			// �ڽİ�ü�� instanceof �ڽ� Ŭ������ == true
			
			/*
			if (arr[i] instanceof Child1) {
				((Child1) arr[i]).printChild1();
			} else {
				((Child2) arr[i]).printchild2();
			}
			*/
			
			arr[i].print(); 
			// print �޼ҵ�� "�������̵�"�� ����
			// => �������̵��� "�ڽĸ޼ҵ�"�� �켱���� ���� ȣ��ȴ�!!
			
			// ��, �������̵��� �̿��ϸ� ���� ����ȯ�� ���ص� ��
			// (�˾Ƽ� �ڽİ�ü�� �޼ҵ�� ã�ư��� ȣ��Ǵ� ��)
		}

	}

}
