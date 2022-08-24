package com.kh.chap02.abstractAndInterface.part01.basic.model.vo;

//	�߻�Ŭ���� (abstract Ű����) == �̿ϼ��� Ŭ����
public abstract class Sports {
//	 �ʵ��
	private int people; // �������� �����ϴ� ���� �� ��

//	 �����ں�
	public Sports() {

	}

	public Sports(int people) {
		this.people = people;
	}

//	 �޼ҵ��
//	 getter / setter, toString() �������̵�
	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "people = " + people;
	}

//	��Ģ�� ����ϴ� void rule() �޼ҵ�
	public abstract void rule();
	
//	����ΰ� �������� �ʴ� �̿ϼ��� �޼ҵ� == �߻�޼ҵ�
//	��, �߻�޼ҵ带 �����ϰ��� �Ѵٸ� ǥ������ abstract��� ���� �߰�������Ѵ�.
	
//	�̿ϼ��� �߻� �޼ҵ尡 �ϳ��� ���ԵǴ� ����
//	�ش� Ŭ���� ���� �̿ϼ��� Ŭ����(�߻�Ŭ����)�� �Ǿ������.
	
//	�߻� Ŭ���� ���� ������ abstract�� ���̸� ��
	
}
