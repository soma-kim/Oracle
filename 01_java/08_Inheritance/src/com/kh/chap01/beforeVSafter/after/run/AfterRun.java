package com.kh.chap01.beforeVSafter.after.run;

import com.kh.chap01.beforeVSafter.after.model.vo.Desktop;
import com.kh.chap01.beforeVSafter.after.model.vo.SmartPhone;
import com.kh.chap01.beforeVSafter.after.model.vo.Tv;

public class AfterRun {


	public static void main(String[] args) {
//		�⺻�����ڸ� ���� ��ü ���� �� setter �޼ҵ�� �ʵ尪 ����
		/*
		Desktop d = new Desktop();
		d.setbrand("�Ｚ");
		d.setpCode("d-01");
		d.setpName("¯¯����ũž");
		d.setAllInone(true);
		*/
		
//		�Ű����������� �̿�
		Desktop d = new Desktop("�Ｚ", "d-01", "¯¯����ũž", 200000, true);
		
//		brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("����", "s-01", "������", 1300000, "SKT");
		
//		brandm pCodem pName, price, inch
		Tv t = new Tv("����", "t-01", "����޺�����Ƽ��", 4000000, 100);
		
//		���
		System.out.println(d.information());
		System.out.println(s.information());
		System.out.println(t.information());
//		�����ϰ��� �ϴ� �޼ҵ尡 �θ�Ŭ�������� �ְ� �ڽ�Ŭ�������� ����
//		�ڽ�Ŭ���������� �θ�Ŭ������ ���빰�� ������ �� �� ������
//		�θ� Ŭ���������� �ڽ� Ŭ������ ���빰�� ������ �� �� ����!
//		=> �ڽ� Ŭ���� ���忡�� �������� �θ�Ŭ������ �޼ҵ带 �� �Ը���� �������ؼ� �� ���� ����. "�������̵�"
//		=> �������̵��� �ش� �޼ҵ带 ȣ������ �� �������̵��� �ڽĸ޼ҵ尡 �켱������ ȣ���(�������ε�)
		
		/*
		 * * ���ǻ���
		 * �����ε��̶� �򰥸��� �ȵ�!
		 * �����ε� : ��Ӱ��� ���� ���� �޼ҵ���� �����ϰ� ������ ���� �� �ִ� ��Ģ
		 * 			�޼ҵ���� ����, �Ű������� �ڷ����� ����, ����, ������ �ٸ��� �ߺ��� �̸��� ����
		 * 
		 * �������̵� : ��Ӱ� ���� �ִ� �������� "��� ����"����
		 * 			  �θ� �޼ҵ��� ���빰�� �ڽ��� �� �Ը���� �������ؼ� ��� ����
		 * 			  �޼ҵ带 (����������, ��ȯ��, �޼ҵ��, �Ű�����) ����
		 * 
		 * 
		 */
		
		
		
		
	}

}
