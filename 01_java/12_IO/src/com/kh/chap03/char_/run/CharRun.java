package com.kh.chap03.char_.run;

import com.kh.chap03.char_.model.dao.FileCharDao;

public class CharRun {
		/*
		 * * ���� ��� ��Ʈ��
		 * ���� ��Ʈ�� : �ѹ��� 2byte ¥���� �����Ͱ� �̵��� �� �ִ� ���� ��� (XXXReader / XXXwriter)
		 * ��� ��Ʈ�� : �ܺθ�ü�� ���������� ����Ǵ� main ���
		 * 
		 * => �ܺ� ��ü�� �����ϰ� �� �ܺθ�ü�� ���������� ����Ǵ� 2byte ¥�� ���� ��θ� ����ڴ�.
		 * 
		 */
	
	public static void main(String[] args) {
		
		FileCharDao fc = new FileCharDao();
//		fc.fileSave();
		
		fc.fileRead();
	}

}
