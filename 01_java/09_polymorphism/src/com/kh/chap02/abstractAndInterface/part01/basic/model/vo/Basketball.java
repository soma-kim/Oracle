package com.kh.chap02.abstractAndInterface.part01.basic.model.vo;

//	sports ��ӹޱ�
public class Basketball extends Sports {
//	�̿ϼ��� Ŭ������ �߻�Ŭ������ ��ӹް� �Ǹ�
//	�θ�Ŭ������ �ִ� �߻�޼ҵ带 ������ �������̵��� ���� �ϼ����������.

//	�ʵ��
//	�����ں�
	public Basketball() {
		
	}
	public Basketball(int people) {
		super(people);
	}
	
//	�޼ҵ��
	@Override
	public void rule() {
		System.out.println("������ ���� ���� ���� �־���Ѵ�."); 
	}

}
