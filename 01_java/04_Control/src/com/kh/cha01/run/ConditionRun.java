package com.kh.cha01.run;

import com.kh.cha01.condition.A_If;
import com.kh.cha01.condition.B_Else;
import com.kh.cha01.condition.C_Switch;

public class ConditionRun {

	/*
	 * ���α׷��� �⺻������ ���������� �Ʒ��� ���������� �����
	 * ������ �� �������� �帧�� �ٲٰ��� �� �� "���"�̶�°� ���ؼ� ���� �帧�� ���� ����
	 * 
	 * ���������� �����ϴ� ���ù� => ���ǹ� (if��, if-else��, if-else if��, switch��)
	 * �ݺ������� �����ϴ� ���๮ => �ݺ��� (for��, while��, do-while��)
	 * �� �̿��� �帧�� �����ϴ� ���� => �б⹮ (break��, continue��)
	 * 
	 * * ���ǹ�
	 * "���ǽ�"�� ���� ���̳� �����̳ĸ� �Ǵ��ؼ� �ش� ������ ���ϰ�� �׿� �ش��ϴ� ������ ���� ����
	 * => ���ǽ� ����� true / false��� ������ ���;� ��
	 * => ���ǽĿ����� ���� �񱳿�����, �������� �� �ַ� ����� �������� ������ �����ڸ� ����Ѵ�.
	 * 
	 * [����]
	 * ���ǹ��� ũ�� if�� �迭�� swich������ ������.
	 * 1. if�� �迭
	 * 	- �ܵ� if�� : ǥ���ϰ��� �ϴ� ����� ���� �Ѱ��� ���
	 * 	- if-else�� : ǥ���ϰ��� �ϴ� ����� ���� �ΰ��� ���
	 * 	- if-else if�� : ǥ���ϰ��� �ϴ� ����� ���� ���� �̻��� ���
	 * 
	 * 2. switch�� : ���ǽ� �߿����� "�����"�� ���Ͽ� ���ϰ� ��� �����ϵ��� ��ȵ� ����
	 * 
	 * 
	 * 
	 */
	
	public static void main (String[] args) {
		
		A_If a = new A_If();
		//a.method1();
		//a.method2();
		//a.method3();
		//a.method4();
		
		B_Else b = new B_Else();
		//b.method1();
		//b.method2();
		//b.method3();
		//b.method4();
		
		C_Switch c = new C_Switch();
			//c.method1();
			//c.method2();
			//c.method3();
			//c.method4();
			c.method5();
	}

}
