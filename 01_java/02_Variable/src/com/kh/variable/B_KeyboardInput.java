package com.kh.variable;

import java.util.Scanner;

// ����ڰ� Ű����� �Է��� ���� ������ ��� ���
public class B_KeyboardInput {
	
	public void inputTest1() {
		
		/*
		 * * �ڹٸ� ���ؼ� ����ڷκ��� ��� ���� "�Է�" ��������
		 *   �ڹٿ��� �����ϴ� java.util.Scanner Ŭ������ �̿��ؾ���
		 *   => Scanner Ŭ�������� �����ϴ� �̹� ������� �޼ҵ���� ȣ���Ͽ��� �Ѵ�!
		 *   
		 * - ���� ���� ���� �ۼ����� Ŭ������ �ٸ� Ŭ������ �ִ� �޼ҵ带 ȣ���ϰ������
		 * 1. ���� ȣ���ϰ����ϴ� �޼ҵ尡 �ִ� Ŭ������ �뺯���̸��� �����̶�°� ������� (new)
		 * 2. ���࿡ �� Ŭ������ ���� �ٸ� ��Ű���� ���� ��쿡�� import ������ �߰��ؾ���
		 * 3. ������� �뺯���̸��� ���ؼ� �ش� �޼ҵ带 ȣ��
		 */
		
		Scanner sc = new Scanner(System.in);
		// System.in : �Է¹��� ������ ����Ʈ ������ �о���̰ڴ� ��� �ǹ�
		
		// ������� ���������� �Է¹޴� ���α׷� (�̸�, ����, Ű)
		
		// �Է¹ް����ϴ� ������ ���� ����� �ؼ� �Է��� ����
		System.out.print("����� �̸��� �����Դϱ�? : ");

		// �̸� : �踻��, ȫ�浿, ��浿, .. => String (���ڿ�)
		// ����ڰ� �Է��� ���� ���ڿ��ν� �޾ƿ��� �޼ҵ� : next(), nextLine()
		
		// sc.next(); // �Է¸� �ް� ��
		// String name = sc.next(); // ���� ����� ���ÿ� Ű����κ��� �Է¹������� �����Ѵ�. 
		
		// next() : ����ڰ� �Է��� �� �߿��� ������ ���� ��� ���� ���������� �Է��� �޴´�.
		// ex) �� ���� => ��
		
		// sc.nextLine(); // �Է¸� �ް� ��
		String name = sc.nextLine();
		
		// nextLine() : ����ڰ� �Է��� �� �߿��� ������ ���� ���  ���鿡 �����ϰ� ���� ������ �Է��� �޴´�.
		// => Ư�� ����ڰ� �Է��� ���� ������ ���Ե� ������ ���� ��� nextLine() �� ����ϴ°� �� ����.
		//    ex) �ּ���
		
		// Scanner ���� �����ϴ� �Է� �޼ҵ���� ��� ���͸� ġ�� ������ ������ �������̴�!
		
		// System.out.println(name);
		
		// ���� : 10, 11, 12, 20, .. => int (����)
		System.out.print("����� ���̴� ����Դϱ�? : ");
		
		// ����ڰ� �Է��� ���� �����ν� �޾ƿ��� �޼ҵ� : nextInt()
		// sc.nextInt(); // �Է¸� �ް� ��
		int age = sc.nextInt(); 
		
		// �� ���������� ����ڰ� ����Ű�� ������ ������ ������
		
		// System.out.println(age);
		
		// Ű : 160.0, 177.2, .. => double (�Ǽ���)
		System.out.print("����� Ű�� �� cm �Դϱ�? : ");
		
		// ����ڰ� �Է��� ���� �Ǽ������� �޾ƿ� �� �ִ� �޼ҵ� : nextDouble()
		// sc.nextDouble(); // �Է¸� �ް� ��
		
		double height = sc.nextDouble();
		
		// ����ڰ� ����Ű�� ���������� ������
		
		// name, age, height �� �̿��Ͽ� �ϳ��� ���ڿ��� �����ؼ� ����ϱ�
		// xxx���� ���̴� xxx���̰�, Ű�� xxxcm �Դϴ�.
		System.out.println(name + "���� ���̴� " + age + "���̰�, Ű�� " + height + "cm �Դϴ�.");
		
	} // inputTest1 �޼ҵ� ���� ��
	
	// Ű����� ���� �Է¹��� �� ���� �߻��Ǵ� ����
	public void inputTest2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		// ���ۿ� ���๮�ڰ� �����ִ� ����
		sc.nextLine(); // �Է¸� �ް� ��
		// ���۰� ����� ����
		
		// nextLine() �޼ҵ�� ���ۿ��� "����" ���������� ��簪�� ������ �� ���۸� ����ִ� ���� (û�Һ�)
		// nextLine() �̿��� �޼ҵ���� ���۸� ������� ����!!
		// => ��� : nextLine() �̿��� �޼ҵ带 ȣ���� ��� nextLine() ���� ���۸� ����ֱ�
		
		System.out.print("�ּ� : ");
		String address = sc.nextLine();
		
		System.out.print("Ű : ");
		double height = sc.nextDouble();
		
		// �̸�, ����, �ּ�, Ű
		// xxx���� xx���̸�, ��� ���� xxxxx�̰�, Ű�� xxxcm �Դϴ�.
		System.out.println(name + "���� " + age + "���̸�, ��� ���� " + address + "�̰�, Ű�� " + height + "cm �Դϴ�.");
		
	} // inputTest2 �޼ҵ� ���� ��
	
	// �� �̿��� �Է� �޼ҵ��
	public void inputTest3() {
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 * * Scanner �� �Է¿� �޼ҵ��
		 * ���ڿ��� �Է¹ް��� �� �� : next(), nextLine()
		 * �������� �Է¹ް��� �� �� : nextInt(), nextByte(), nextShort(), nextLong()
		 * �Ǽ����� �Է¹ް��� �� �� : nextDouble(), nextFloat()
		 * ������ �Է¹ް��� �� �� : nextBoolean()
		 * ���ڰ��� �Է¹ް��� �� �� : �ش� �޼ҵ尡 ����
		 */

		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("����(M/F) : ");
		// char gender = ����Ÿ�������Է¹ް�����;
		
		// index : ����, ����
		// "apple" ���ڿ����� a �� ��ġ�� ã��ʹ�!
		//  01234
		// => a �� ��ġ�� (index) �� 0
		// => e �� ��ġ�� (index) �� 4
		
		// => �켱������ nextLine() �޼ҵ带 �̿��ؼ� ���ڿ� ���·� �Է� �ް�,
		//    �� �Է¹��� ���ڿ��κ��� 0��° �ε����� ���ڰ� �ϳ��� ����
		
		// charAt(��ġ��) : ���ڿ��κ��� �ش� ��ġ���� �ش�Ǵ� ���� �ϳ��� �����ִ� �޼ҵ�
		// [ ǥ���� ] ���ڿ�.charAt(��ġ��);
		
		char gender = sc.nextLine().charAt(0); // ���� ���ڿ��� �Է¹��� �� 0��° ���ڸ� �����Ͽ� gender �� ����
		
		// StringIndexOutOfBoundsException : �����ϰ��� �ϴ� �ε������� ���ڿ��� ���̸� �Ѿ�� �� �߻�
		// => �迭������ ����� ���� �߻� ����
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Ű : ");
		double height = sc.nextDouble();
		
		sc.nextLine();
		
		System.out.println(name + " ���� ��������");
		System.out.println("���� : " + gender);
		System.out.println("���� : " + age);
		System.out.println("Ű : " + height);
		
	} // inputTest3 �޼ҵ� ���� ��
	
	// ���빮��1
	public void inputTest4() {
		
		/*
		 * ���� ���ڿ� ���� Ű����� �Է¹��� ��
		 * �� ���ڿ��κ��� �տ��� ������ ����غ�����.
		 * 
		 * ��¿���
		 * ù��°���� : x
		 * �ι�°���� : x
		 * ����°���� : x
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("3���� �̻��� ���ڿ��� �Է��ϼ��� : ");
		
		// ������ �ϴ� �Ǽ�
		// char ch1 = sc.nextLine().charAt(0);
		// char ch2 = sc.nextLine().charAt(1);
		// => nextLine �� ������ ȣ��Ǵ� ���̱� ������ ������ �Է¹ްԵ�
		
		String str = sc.nextLine(); // �켱������ ���ڿ��� �ѹ� �Է¹޾Ƽ� ������ �����صα�
		
		/*
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		
		System.out.println("ù��° ���� : " + ch1);
		System.out.println("�ι�° ���� : " + ch2);
		System.out.println("����° ���� : " + ch3);
		*/
		
		/*
		System.out.println("ù��° ���� : " + str.charAt(0));
		System.out.println("�ι�° ���� : " + str.charAt(1));
		System.out.println("����° ���� : " + str.charAt(2));
		*/
		
		// Apple �� �Է����� ��� App ���·� ����ϰ� �ʹ�!
		char ch1 = str.charAt(0);
		char ch2 = str.charAt(1);
		char ch3 = str.charAt(2);
		
		// System.out.println(ch1 + ch2 + ch3); // 289
		// char �� int ���̶� ���� ����ȯ�� ������ ����
		
		// �츮�� ���� ��� ������ �ذ��� �� �ִ� ���
		// �ذ���1) �ణ ������ ���
		/*
		System.out.print(ch1);
		System.out.print(ch2);
		System.out.print(ch3);
		*/
		
		// �ذ���2) �ణ ����ġ ���� ��� ������
		System.out.println("" + ch1 + ch2 + ch3);
		
	} // inputTest4 �޼ҵ� ���� ��
	
	// ���빮��2
	public void inputTest5() {
		
		/*
		 * Ű����� ���� �ΰ��� �Է¹޾�
		 * �� ���� ��, ��, ��, �������� ����� ���� ����ϼ���
		 * 
		 * ��Ʈ
		 * ���� : +
		 * ���� : -
		 * ���� : *
		 * ������ : /
		 * 
		 * ��¿���
		 * ���ϱ� ��� : x
		 * ���� ��� : x
		 * ���ϱ� ��� : x
		 * ������ ��� : x
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° ������ �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("�ι�° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		
		sc.nextLine();
		
		/*
		int result1 = num1 + num2;
		
		System.out.println("���ϱ� ��� : " + result1);
		*/
		
		System.out.println("���ϱ� ��� : " + (num1 + num2));
		// ������ �켱���� => �켱������ ���� ��� ���ʿ������� ���������� ������ ������
		
	}
	
	// ����
	public void inputTest6() {
		
		/*
		 * Ű����� ����, ���� ���� �Ǽ������� �Է� �޾Ƽ�
		 * �簢���� ������ �ѷ��� ������ּ���
		 * 
		 * ��Ʈ
		 * �簢���� ���� : ���� * ����
		 * �簢���� �ѷ� : (���� + ����) * 2
		 * 
		 * ���࿹��
		 * ���α��̸� �Է��ϼ��� : 13.5
		 * ���α��̸� �Է��ϼ��� : 41.7
		 * 
		 * ���� : xx
		 * �ѷ� : xx
		 */
		
		
	}
	
	

}









