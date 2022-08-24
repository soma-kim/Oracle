package com.kh.chap01.beforeVSafter.after.model.vo;

//	�ڽ� Ŭ���� : �θ�Ŭ�����κ��� �ߺ��� �ڵ带 �����޾� ����ϴ� Ŭ����
//	=> �ڽ� Ŭ������ �켱������ �ؾ� �� �� : �����κ��� �ڵ带 ������������ ��� ���� �ؾ���!
			// �ڽ�	 ------>  �θ�
			// �ļ�	 ------>  ����
			// ���� 	 ------>  ����
			// ����	 ------>  ����
public class Desktop extends Product {
//	�ʵ��
	private boolean allInOne;
	
//	�����ں�
	public Desktop() {
		
	}
	public Desktop (String brand, String pCode, String pName, int price, boolean allInone) {
//		��Ӱ��迡�� �� �θ�Ŭ������ �ʵ尪�� �����ϰ��� �� ��쿡�� super.�θ��ʵ��
//		=> super.�� �ش� �θ��ּҸ� ����ִ�. (��, super.���� �θ� ���� ����)
//	   	      ��, �����ϰ��� �ϴ°� private�� ��쿡�� ���� �Ƶ� �ܺο��� ���� ������ �Ұ���
		
//		�ذ���1. �θ�Ŭ������ �ڽı����� ���� �����ϵ��� 
//				 private -> protected�� ���������ڸ� �����ϴ� ���
//				 "��������"�� �� �� ����.
		/*
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		*/
		
//		�ذ���2. �θ� Ŭ������ �ִ� public ���� �������� setter �޼ҵ� Ȱ���ϱ�
//			  	  ��Ӱ��迡�� �θ� Ŭ������ �ִ� �޼ҵ忡 ���� �����ϰ��� �� ��� super.�޼ҵ��();
		/*
		super.setbrand(brand);
		super.setpCode(pCode);
		super.setpName(pName);
		super.setPrice(price);
		*/
		
//		�ذ���3. �θ�Ŭ������ �ִ� �Ű����� �����ڸ� ȣ���ϱ�
//		��Ӱ��迡�� �θ�Ŭ������ �ִ� �����ڸ� ȣ���ϰ��� �� ��� super ������ ȣ�� (�ݵ�� ù�ٿ� ���)
//		=> �� �ȿ��ִ� �����ڸ� ȣ���� ��� this �����ڸ� ȣ���߾���! (�ݵ�� ù�ٿ� ���)
		super(brand, pCode, pName, price);
		this.allInOne = allInOne;
	}
	
//	�޼ҵ��
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInone(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
//	�������̵� �۾� (information �޼ҵ�) : �θ�Ŭ������ �޼ҵ带 �� �Ը���� �������ϴ°�
	public String information() {
		/*
		return "brand : " + super.getBrand() + ", pCode : " + super.getpCode() + 
				", pName" + super.getpName() + ", price : " + super.getprice() +
				", allInone" + allInOne;
		*/
		return super.information() + " , allInOne : " + allInOne;
		
		
	}
	
	
	
}
