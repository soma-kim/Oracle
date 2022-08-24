package com.kh.chap02.string.controller;

import java.util.Arrays;
import java.util.Scanner;

public class B_StringMethodTest {
	public void method() {
		String str1 = "Hell World";
		
//		�޼ҵ��(�Ű�����) : ��ȯ��
//		1. ���ڿ�.charAt(int index) : ��ȯ�� char��
//		=> ���ڿ����� ���޹��� index ��ġ�� ���� �ϳ��� �̾Ƽ� ����
		char ch = str1.charAt(3);
		System.out.println("ch : " + ch);
		
//		2. ���ڿ�.concat(String str) : ��ȯ�� String��
//		=> ���ڿ��� ���޵� �� �ٸ� ���ڿ��� �ϳ��� ���̾ ����
		String str2 = str1.concat("!!!"); // String str2 = str1 + "!!!";
		System.out.println("str2 : "+ str2);
		
//		3. ���ڿ�.length() : ��ȯ�� int��
//		=> ���ڿ��� ���� ��ȯ
		System.out.println("str1�� ���� : " + str1.length());
		
//		4_1. ���ڿ�.substring(int beginIndex) : ��ȯ�� String��
//		=> ���ڿ��� beginIndex ��ġ�������� �������� ���ڿ��� �����ؼ� ����
		System.out.println(str1.substring(6));
		
//		4_2. ���ڿ�.substring(int beginIndex, int endIndex) : ��ȯ�� String��
//		=> ���ڿ��� beginIndex ��ġ�������� endIndex -1 ��ġ���� �����ؼ� ����
		System.out.println(str1.substring(0, 6));
		
//		5. ���ڿ�.replace(char old, char new) : ��ȯ�� String��
//		=> ���ڿ��κ��� old ���ڸ� new ���ڷ� ��ȯ�� ���ڿ��� ����
		String str3 = str1.replace('l', 'c');
		System.out.println("str3 : " + str3);
		
		
//		6. ���ڿ�.trim() : ��ȯ�� String��
//		=> ���ڿ��� ��, �� ������ ��� ������ ���ڿ��� ����
		String str4 = "      JA    VA     ";
		System.out.println("trim() : " + str4.trim());
		
		
//		����) �߰��� �ִ� ������ ���ְ� �ʹٸ�?
//		replace �޼ҵ� Ȱ��
		System.out.println("replace�� Ȱ���ؼ� ��� ���鵵 ���ֱ� : " + str4.replace(" ", ""));
		
//		7_1. ���ڿ�.toUpperCase() : ��ȯ�� String��
//		=> ���ڿ��� ��� �� �빮�ڷ� ���� �� ���ڿ� ����
		System.out.println("upper : " + str1.toUpperCase());
		
//		7_2. ���ڿ�.toLoerCase() : ��ȯ�� String��
//		=> ���ڿ��� ��� �� �ҹ��ڷ� ���� �� ���ڿ� ����
		System.out.println("lower : " + str1.toLowerCase());
		
//		 Ȱ�� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("�����Ͻðڽ��ϱ�? (y/n) : ");
//		char answer = sc.nextLine().charAt(0); // Y, y, N, n
		char answer = sc.nextLine().toUpperCase().charAt(0); // Y, N
//		=> �޼ҵ带 ���̾ ȣ��(�޼ҵ�ü�̴�)
		
		if(answer == 'Y') {
			System.out.println("���α׷��� �����մϴ�.");
		}
		else {
			System.out.println("���α׷��� �������� �ʽ��ϴ�.");
		}
		
		
		// ���ڿ� -> char[]
//      char[] arr = new char[str1.length()];
//
//      for (int i = 0; i < arr.length; i++) {
//         arr[i] = str1.charAt(i);
//      }

//      8. ���ڿ�.toCharArray() : ����� char[] ��
//      -> ���ڿ��� �� ���ڵ��� char[] �迭�� �Ű� ���� �� �� �迭�� ����
      char[] arr = str1.toCharArray();
      System.out.println(Arrays.toString(arr));
      
      // char[] -> ���ڿ�
      char[] arr2 = {'a','p','p','l','e'};
      
//      9. static valueOf(char[] data) : ��ȯ�� String��
//      => ���޵� char[] �迭�� ��� ���ڵ��� �ϳ��� ���ڿ��� ���̾ ����
      	System.out.println(String.copyValueOf(arr2));
   }
	
	//�ǽ�����
	public void method2() {
		/* �弳 ���͸� ���α׷�
		 * 
		 * ex) �̷� �Ź߲����� ������ ȣ�����!! 
		 * => �̷� ***���� *** ****�� !!! 
		 */
		
		// ����ڿ��� ������ �ϳ� �Է¹޽��ϴ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ��� : ");
		String str = sc.nextLine(); // sc.next�� ������������ �ν���
		
//		���� ���õǴ� �ܾ �ش��� ��� *���� ��ü�ؼ� ����ϵ��� �����غ�����.
//		- ��**, ��**, ��**, ȣ����, �ú�����, �����, ��ī, �ֹֽ�, ���ڼ�, �Ļ�
		// ���͸��� �迭
		String[] filter = {"�Ź߲�", "������", "���ھ�", "ȣ����", "�ú�����", "�����", "��ī", "�ֹֽ�", "���ڼ�", "�Ļ�"};
		
		// ���͸� �۾�
		for(int i = 0; i < filter.length; i++) {
			// �� �ε����� ���� ���͸��� ���ڿ� �������� ġȯ�� ���ڿ� ���� ����
			int size = filter[i].length(); // �ش� ������ ���ڼ��� ����
			String star = "" + filter[i].charAt(0);
			for (int j = 0; j < size-1; j++) {
				star += "*";
			}
			// filter[i] ���ڸ� star�� ��ü => replace �޼ҵ�
				str = str.replace(filter[i], star);
		}
				System.out.println(str);
			
		}
		
		
		
		
		
		
}
	
	
	
	

		
		