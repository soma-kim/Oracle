package com.kh.chap02.byte_.run;

import com.kh.chap02.byte_.medel.deao.FileByteDao;

public class ByteRun {
	/*
	 * * ����Ʈ ��� ��Ʈ��
	 * ����Ʈ ��Ʈ�� : 1byte �����θ� ����� �� �� �ִ� ���� ��� (xxxInputStream / xxxOutputStream)
	 * ��� ��Ʈ�� : �ܺθ�ü�� ���������� ����Ǵ� ���� ���
	 * 
	 * => �ܺθ�ü�� �����ϰ�� �ܺθ�ü�� ���������� ����Ǵ� 1byte ���� ��θ� ����ڴ�.
	 * XXXInputXtream : XXX ��ü�κ��� �����͸� �Է� �޴� ���
	 * 					(�ܺ� ��ü�κ��� �����͸� ������ ���ڴ�. �о�帮�ڴ�.)
	 * XXXOutputStream : XXX ��ü�κ��� �����͸� ����ϴ� ��� 
	 * 					(�ܺ� ��ü�� �����͸� �������ڴ�. ���ڴ�.)
	 */
	
	public static void main(String[] args) {
		FileByteDao fb = new FileByteDao();
//		fb.fileSave();
		fb.fileRead();
		
		
		
	}

}
