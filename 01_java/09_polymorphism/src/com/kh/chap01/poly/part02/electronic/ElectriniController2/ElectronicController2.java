package com.kh.chap01.poly.part02.electronic.ElectriniController2;

import com.kh.chap01.poly.part02.electronic.model.vo.Electronic;

//	�������� �����������
public class ElectronicController2 {
//	������ڻ󰡿� �ٽ� ���Ӱ� ���� ����

//	�ʵ��
//	��������̵��� ���� �� �ִ� 3ĭ¥�� â�� 
	private Electronic[] elec = new Electronic[3];

//	�޼ҵ��
//	â�� ������ �ִ� �޼ҵ� : ���� ��� �������� ?
	public void insert(Electronic any, int index) {
		elec[index] = any;
	}

//	â��κ��� ������ �ϳ� �������� �޼ҵ� : ���κ��� �����ð���?
	public Electronic select(int index) {
		return elec[index];
	}

//	â�� �ִ� ���� ��θ� �� �����ִ� �޼ҵ�
	public Electronic[] select() {
		return elec;
	}

}
