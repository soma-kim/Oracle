package com.kh.chap02.abstractAndInterface.part01.basic.model.vo;

//	sports ��ӹޱ�
public class Football extends Sports{
//	�ʵ��
	
//	�����ں�
	public Football() {
		
	}
	public Football(int people) {
		super(people);
	}
	
//	�޼ҵ��
	@Override
	public void rule() {
		System.out.println("���� �ƴ� �ٷ� ���� �����Ѵ�.");
		
	}
}
