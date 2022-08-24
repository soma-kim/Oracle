package com.kh.chap04.field.model.vo;

// �ʵ忡�� ��� ������ ���������� ���� 4����
public class FieldTest2 {
	
	/*
	 * (+)public : ��𼭵� (���� ��Ű��, �ٸ� ��Ű�� ���) ���� �����ϵ��� �ϰڴ�. 
	 * (#)protected : ���� ��Ű�� �ȿ����� ������ ���� �����ϵ��� �ϰڴ�. 
	 * 				    ���࿡ �ٸ� ��Ű���� �ִ� Ŭ�������� �����ϰ� �ʹٸ� 
	 * 				    ��� �� Ŭ������ ������ ������� Ŭ������ ��� ������ �̷��� �Ѵ�.
	 * 				  (����� �����ð��� ��� ��)
	 * (~)default : ������ ���� ��Ű�� �ȿ����� ���� �����ϵ��� �ϰڴ�.
	 * (-)private : ���� �ش� Ŭ���� �������� ���� �����ϵ��� �ϰڴ�.
	 * 
	 * => ���������� �Ʒ��� ���������� ������ �� �ִ� ���� ������ ������.
	 * => +, #, ~, - : Ŭ���� ���̾�׷������� ��ȣ�̴�.
	 * 
	 */
	
	public String pub = "public";
	protected String pro = "protected";
	String df = "default";
	private String pri = "private";
	
	public static String sta = "FieldTest2�� static";
	
	
	
	
}
