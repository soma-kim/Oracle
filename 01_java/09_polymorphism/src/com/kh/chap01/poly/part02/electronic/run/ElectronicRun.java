package com.kh.chap01.poly.part02.electronic.run;



import com.kh.chap01.poly.part02.electronic.ElectriniController2.ElectronicController2;
import com.kh.chap01.poly.part02.electronic.controller.ElectronicController1;
import com.kh.chap01.poly.part02.electronic.model.vo.Desktop;
import com.kh.chap01.poly.part02.electronic.model.vo.Electronic;
import com.kh.chap01.poly.part02.electronic.model.vo.NoteBook;
import com.kh.chap01.poly.part02.electronic.model.vo.Tablet;

public class ElectronicRun {

	public static void main(String[] args) {
//		1. �������� �����ϱ� �� (ElectronicControoler1)
		ElectronicController1 ec = new ElectronicController1();
		/*
//		�� ���� ���ؿ��� ec.desk == null, ec.note == null, ec.tab == null
//		=> �츮���Կ� ����� ������ ���� ��
		
//		ec.desk = new Desktop();
//		=> desk��� ���ڴ� private�� �������� �Ұ� 
		
//		Desktop d= new Desktop("�Ｚ", "��ž", 1200000, "Geforce 1070");
//		ec.insert(d);
		ec.insert(new Desktop("�Ｚ", "��ž", 1200000, "Geforce 1070"));
		
		ec.insert(new NoteBook("����", "�׷�", 2000000, 4));
		
		ec.insert(new Tablet("����", "�����е�", 500000, false));
//		=> ������� ������ ���� ��ǰ �޾Ƽ� ���ڿ� ����� ��
//		�մԿ��� ��ǰ���� ���ڷκ��� ������ �����ֱ�
		Desktop d = ec.selectDesktop();
		NoteBook n = ec.selectNoteBook();
		Tablet t = ec.selectTablet();
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t); // �츮�� ���ϴ� ���빰�� ���ϰ� (toString�� �������̵� �߱� ������)
		*/
		
//		2. �������� �������� ��� (ElectornicController2)
		
		ElectronicController2 ec2 = new ElectronicController2();
		ec2.insert(new Desktop("�Ｚ", "��ž", 1200000, "Geforce 1070"), 0);
		ec2.insert(new NoteBook("����", "�׷�", 2000000, 4), 1);
		ec2.insert(new Tablet("����", "�����е�", 500000, false), 2);
		
//		â�� ��� ���ǵ��� �ϳ��� �̾ƺ���
		/*
		Desktop d = (Desktop)(ec2.select(0));
		NoteBook n = (NoteBook)(ec2.select(1));
		Tablet t = (Tablet)(ec2.select(2));
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t);
		*/
		
		//�ݺ����� Ȱ���ؼ� ���� ��������
		Electronic[] elec = ec2.select();
		
		for (int i = 0; i < elec.length; i++) {
			System.out.println(elec[i] /*toString*/);
		}
		
		
		/*
		 * * �������� ����ϴ� ����
		 * 1. �θ�Ÿ���� ��ü�迭�� �پ��� �ڽİ�ü���� ��Ƽ� ��Ƶ� �� ����
		 * 2. �޼ҵ��� �Ű������� ��ȯ���� �������� �����ϰ� �Ǹ� 
		 * 	    �޼ҵ� ������ Ȯ �پ���.
		 */
	}

}
