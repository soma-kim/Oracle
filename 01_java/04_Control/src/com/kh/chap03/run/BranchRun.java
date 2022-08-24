package com.kh.chap03.run;

import com.kh.chap03.branch.A_Break;
import com.kh.chap03.branch.B_Continue;

public class BranchRun {

	/*
	 * * �б⹮
	 * ���ǹ� �Ǵ� �ݺ����� �Բ� ���̸� "����" ���ִ� ����
	 * => ���� �Ǵ� �ݺ� �� �̿��� �帧�� �����ϴ� ����
	 * 
	 * * �б⹮
	 * 1. break�� : �ݺ��� �ȿ��� �ݺ����� ���������� ����
	 * 2. continue�� : �ݺ��� �ȿ��� �� ���� �ڵ�� �����ϰ� �ٷ� ���� ���������� �Ѿ�� ����
	 */
	
	public static void main(String[] args) {
		
		A_Break a = new A_Break();
		
		// a.method1();
		
		// a.method2();
		
		// a.method3();
		
		B_Continue b = new B_Continue();
		
		// b.method1();
		
		// b.method2();
		
		b.method3();
	}
	
}
