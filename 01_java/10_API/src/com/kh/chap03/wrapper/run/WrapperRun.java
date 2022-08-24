package com.kh.chap03.wrapper.run;

// ����Ŭ����
public class WrapperRun {

	public static void main(String[] args) {
		/*
		 * *Wrapper Ŭ����
		 * => �⺻�ڷ����� ��ü Ÿ������ �������ִ� Ŭ�������� ���� Ŭ������� ��
		 * 
		 * 	�⺻ �ڷ���  <----> Wrapper Ŭ����
		 * 	 boolean	     Boolean
		 *   char            Character
		 *   byte            Byte
		 *   short           short
		 *   int             Integer
		 *   long            Long
		 *   float           Float
		 *   double          Double
		 * 
		 * => �⺻ �ڷ����� ��ü�� ����ؾ� �ϴ� ���
		 * - �޼ҵ� ȣ���ؾ��Ҷ�
		 * - �޼ҵ��� �Ű������� �⺻�ڷ����� �ƴ� ��üŸ�Ը� �䱸�ɶ�
		 * - �������� �����ϰ��� �Ҷ� 
		 * 
		 * 
		 */
		
		int num1 = 10;
		int num2 = 15;
		
//		����񱳸� �ϰ��� �Ҷ� 
//		System.out.println(num1 == num2);
//		System.out.println(num1.equals(num2));
		
//		�Ϲ� �⺻�ڷ������� ��ü �ڷ����� �޼ҵ带 ȣ���ϰ��� �Ҷ� Wrapper Ŭ������ ��ȭ�ؼ� �ַ� ���
//		�⺻ �ڷ��� => Wrapper �ڷ��� (Boxing)
//		1. ��ü ���� ������ �̿��� ��� (������ ȣ��)
		Integer i1 = new Integer (num1); // num1 => i1
		Integer i2 = new Integer (num2); // num2 => i2
		
		System.out.println(i1 /*.toString() */);
		System.out.println(i2);
		
		System.out.println(i1 == i2); //�ּҰ� �� false
		System.out.println(i1.equals(i2)); // ����� false
		System.out.println(i1.hashCode());
		System.out.println(i1.compareTo(i2));
//		a.compareTo(b) : a�� b���� ũ�� 1, b�� �� ũ�� -1, �����ϸ� 0 ����
//		=> ��ü�� �ٲٰ� �Ǹ� �޼ҵ���� �����Ӱ� �̿� ����
		
//		2. ��ü�� �������� �ʰ� ��ٷ� �����ϴ� ���(AutoBoxing)
		Integer i3 = 10;
		System.out.println(i3);
		
//		Ư�����̽�. ��ü ���������� ���ؼ� �ݵ�� ��ȯ�ؾ� �ϴ� ��� => ���ڿ��� Integer�� �ٲٴ� ���
//		Integer i4 = "123";
		Integer i4 = new Integer("123"); // "123" => 123
		System.out.println(i4);
		
//		Wrapper �ڷ��� => �⺻�ڷ��� (Unboxing)
//		1. �ش� �� Wrapper Ŭ�������� �����ϴ� xxxValue() �޼ҵ带 Ȱ���ϴ� ���
		int num3 = i3.intValue(); // i3 => num3
		int num4 = i4.intValue(); // i4 => num4
		
		System.out.println( num3 > num4 );
		
//		2. �޼ҵ� ���� ������� �ʰ� �ٷ� �����ϴ� ��� (Auto Unboxing)
		int num5 = i1; // 10
		int num6 = i2; // 15
		
		System.out.println(i1 == i2);
		
		System.out.println("======================");
		
//		�⺻�ڷ����� <---> String 
		String str1 = "10";
		String str2 = "15.3";
		
		System.out.println(str1 + str2); // "1015.3"
		
//		1.String --> �⺻ �ڷ��� : �Ľ��Ѵ�.
//							       �ش� WrapperŬ������.parsexxx(��ȯ�ҹ��ڿ�);
		int i = Integer.parseInt(str1);
		double d = Double.parseDouble(str2);
		
		System.out.println(i+d);
		
//		2. �⺻�ڷ��� ---> String 
//		String.valueOf(��ȯ�� �⺻ �ڷ��� ��) : String��
		String strI = String.valueOf(i);
		String strD = String.valueOf(d);
		
		System.out.println
		
		
		
	}

}
