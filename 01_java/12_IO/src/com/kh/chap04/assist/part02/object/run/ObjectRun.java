package com.kh.chap04.assist.part02.object.run;

import com.kh.chap04.assist.part02.object.model.dao.ObjectDao;
import com.kh.chap04.assist.part02.object.model.dao.ObjectsDao;

public class ObjectRun {

	public static void main(String[] args) {
		/*
		 * ���� ��Ʈ��
		 * ��� ��Ʈ�� ������ ������ ����� �߰����ִ� ���� ������ ��Ʈ��
		 * ���� �ܵ����� ��ü ���� �Ұ�!
		 * 
		 * ��ü ������ ����� �� �� �ִ� ����� �����ϴ� ���� ��Ʈ��
		 * => ObjectInpitStream(1byte �Է¿� ����) / ObjectOutputStream (1byte ��¿� ����)
		 */
		ObjectDao od = new ObjectDao(); 
//		od.fileSave();
//		od.fileRead();
		
		ObjectsDao ods = new ObjectsDao();
//		ods.fileSave();
		ods.fileRead();
	}

}
