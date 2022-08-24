package com.kh.chap02.string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizerTest {
	public void method() {
//		���ڿ��� �и���Ű�� ���
		String str = "Java,Oracle,JDBC,HTML,Server,Spring";
		
//		�����ڸ� �����ؼ� �ش� ���ڿ��� �и���Ű�� ���
//		���1. �и��� ���ڿ����� String[] �迭�� �������� ��Ƽ� �����ϰ��� �Ҷ�
//			    ���ڿ�.split(String ������) : ��ȯ�� String[]��
		String[] arr = str.split(",");
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
//		���ڿ� �迭�� ��� for���� �̷������ε� �� �� �ִ�. (���� for��, foreach��)
//		for(���� �޾��� �� �ִ� ���� ����)
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("============================");
		
//		���2. �и��� ������ ���ڿ����� "��ū"������ ����ϰ� ���� ��
//			  java.util.StringTokenizer Ŭ������ �̿��ϴ� ���
//			  StringTokenizer stn = new StringTokennizer(�и���Ű���� �ϴ� ���ڿ�, ������);
			
		StringTokenizer stn = new StringTokenizer(str,",");
		System.out.println("�и��� ���ڿ��� ���� : " + stn.countTokens());
		/*
//		���
		System.out.println(stn.nextToken()); // Java
		System.out.println(stn.nextToken()); // Oracle
		System.out.println(stn.nextToken()); // JDBC
		System.out.println(stn.nextToken()); // HTML
		System.out.println(stn.nextToken()); // Sever
		System.out.println(stn.nextToken()); // Spring
		
		System.out.println(stn.nextToken()); // NoSuchElementException : ���̻� ã�� ��Ұ� ����
//		=> ���� �����ִ� stn ��ū ������ ������ ����� �� �߻��ϴ� ����
		
		System.out.println("���� ����ִ� ���ڿ��� ���� : " + stn.countTokens());
		*/
		
//		�ݺ��� Ȱ��
		/*
		for(int i = 0; i <stn.countTokens(); i++) {
			System.out.println(stn.nextToken());
		}
	
		
		// i = 0, ���� 6 => true => ��� => i++
		// i = 1, ���� 5 => true => ��� => i++
		// i = 2, ���� 4�� => true => ��� => i++
		// i = 3, ���� 3�� => false => �ݺ��� ��������
		*/
		
//		�غ����1. ���� Ȱ��
		/*
		int count = stn.countTokens();
		for (int i = 0; i < count; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
//		�ذ���2. while�� ���
//		stn.hasMoretokens() : stn ��ü�� ���̻� ���Ƴ� ��ū�� �ִٸ� true, �ƴ϶�� false ��ȯ
		while(stn.hasMoreTokens()) { //stn������ �����ִ� ��ū�� ���� ���ȸ� �ݺ��� �����ϰڴ�.
			System.out.println(stn.nextToken());
		}
		
		
		
		
	}
}
