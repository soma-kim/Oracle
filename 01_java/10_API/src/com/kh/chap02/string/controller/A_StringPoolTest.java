package com.kh.chap02.string.controller;

//	String�� Ư�� 
public class A_StringPoolTest {
//	1. �����ڸ� ���ؼ� String ������ ���ڿ� ���
	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1 /*.toString() */); //�ּҰ��� �ƴ� ���빰�� ��µ�
		System.out.println(str2);
//		=> String Ŭ������ toString �޼ҵ尡 ���빰�� ��� �� �� �ֵ��� �������̵� �Ǿ�����
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
//		=> String Ŭ������ hashCode �޼ҵ尡 ���� ��� ���빰�� ������� �������� �����ؼ� �����ϴ� �������̵� �Ǿ�����
		
//		���� �ּҰ��� ���ؼ� �˰� �ʹٸ�
//		System.out.identityHashCode(��ü��);
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
//		str1�� str2�� �ּҰ��� �ٸ���.
		
//		���ڿ� ��
		System.out.println(str1 == str2); // �ּҰ� �� => false
		System.out.println(str1.equals(str2)); // ���ڿ��� ���빰 �� => true
//		=> ���� object Ŭ�������� �����ϴ� equals �޼ҵ�� �ּҰ��� ��ġ�ϴ��� ���ϴ� �޼ҵ�
//		=> String Ŭ������ equals�� ���빰�� ����� �� �� �ְԲ� �������̵� �Ǿ�����
	}
	
//	2. ���ڿ��� ���ͷ�(��)�� ����
	public void method2() {
		String str1 = "hello";
		String str2 = "hello";
		
		System.out.println(str1);
		System.out.println(str2);
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(str1 == str2); //�ּҰ� true
//		=> ��¥ �ּҰ��� ����..?
		
//		<���ڿ��� �����Ҷ� >
//		�����ڸ� ���ؼ� ����� ��� : �Ź� �����Ǵ� ���빰�� ������ ���� �ٸ� ������ ���� ������ 
//		���ͷ��� �����ؼ� ����� ��� : �Ź� �����Ǵ� ���빰�� Heap���� �ȿ� StringPool(���Ǯ)�� ������
//		=> StringPool ������ Ư¡ : ������ ���ڿ��� ���� �Ұ�
	}
	
//	�Һ�Ŭ����(������ �ʴ� Ŭ����)
	public void method3() {
		String str = "hello";
		System.out.println(System.identityHashCode(str));
		
		str = "goodbye";
		System.out.println(System.identityHashCode(str));
		
		str += "abc"; // str = str + "abc";
		System.out.println(System.identityHashCode(str));
		
//		String ��ü�� �ѹ� �����Ǹ� �޸� ������ ���빰�� ������ ����
//		=> �Һ�Ŭ������� �θ�
		
//		������ ���Ǯ�� ������ ���� ���ڿ����� �������ݷ��Ͱ� �˾Ƽ� ��������
//		�Һ�Ŭ��������ؼ� ���빰�� �����Ǵ°� �ƴ϶� �Ź� ���ο� �ּҰ��� �����Ѵ�.
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
