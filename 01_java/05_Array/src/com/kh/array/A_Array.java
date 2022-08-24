package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {

	/*
	 * * ���� : "�ڷ����� �´� �� �ϳ���" �� ���� �� �ִ� ���� ��) int a = 10; a = 20;
	 * 
	 * * �迭 : "�ڷ����� �´� �� ������" �� ���� �� �ִ� ���� ��) int[] b = new int[3]; // int ���� ���� ��
	 * �� �ִ� ���� 3�� ����ڴ�. // �� [0], [1], [2] ȣ���� ������� // �ε����� �׻� 0�������� �����Ѵ�. // ���ڿ���
	 * ũ�� = 5, ������ �ε��� = 4 // �迭�� ũ�� = 3, ������ �ε��� = 2 // �迭�� ũ�� = 7, ������ �ε��� = 6 //
	 * �׻� ũ�� = n , ������ �ε��� = n - 1 // => for ������ �ݺ� Ƚ���� �����ϴ� ���� �⺻���� ��� // int i =
	 * 0; i < Ƚ��; i++
	 * 
	 * b[0] = 5; b[1] = 10; b[2] = 15;
	 */

	public void method1() {

		// �迭�� �� ��� �ұ�?
		// �������� �̿��ؼ� ���α׷����� �ϰԵǸ�..

		// 0, 1, 2, 3, 4 �� ����ؾ���
		/*
		 * int num1 = 0; int num2 = 1; int num3 = 2; int num4 = 3; int num5 = 4;
		 * 
		 * // ����Ҷ���? => ������ ����ؾ� �Ѵ�. �ݺ��� ��� �Ұ� System.out.println(num1);
		 * System.out.println(num2); System.out.println(num3); System.out.println(num4);
		 * System.out.println(num5);
		 * 
		 * for(int i = 1; i <= 5; i++) {
		 * 
		 * // System.out.println(numi); // System.out.println("num" + i); }
		 * 
		 * // ���հ豸�Ҷ���? => ������ ������� �Ѵ�. �ݺ��� ��� �Ұ� int sum = num1 + num2 + num3 + num4 +
		 * num5;
		 */

		// ���� ����ؾ��ϴ� ������ 100, 1000, 10000 ���� �þ�ٸ�?

		// �迭�� ������ ���α׷����ϱ�

		// 0, 1, 2, 3, 4 �� ����ؾ���

		/*
		 * 1. �迭 ���� [ ǥ���� ] => �ΰ��� ǥ������ �ִ�. �ڷ��� �迭��[]; �ڷ���[] �迭��;
		 */

		// int a; // ������ ����
		// int arr[]; // �迭�� ����
		// int[] arr;

		/*
		 * 2. �迭 �Ҵ� �� �迭�� ���ݺ��� ��� ������ ��� �����Ұ��� �迭�� ũ�⸦ �������ִ� ���� ������ �� ������ŭ ���� �� ����
		 * �������
		 * 
		 * [ ǥ���� ] �迭�� = new �ڷ���[�迭ũ��];
		 */
		// arr = new int[5];

		// ���� ���� �� �ʱ�ȭ
		int a = 1;

		// �迭 ���� �� �Ҵ�
		int[] arr = new int[5];

		// => �� �������� ��ġ�� �ʴ´ٸ� ����� �迭�� ����� �� ����!!

		/*
		 * 3. �迭�� �� �ε��� �� �ڸ��� �� ���� [ ǥ���� ] �迭��[�ε���] = ��;
		 */
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;

		// �迭�� ��� => �ݺ��� Ȱ���� ����!!
		/*
		 * System.out.println(arr[0]); System.out.println(arr[1]);
		 * System.out.println(arr[2]); System.out.println(arr[3]);
		 * System.out.println(arr[4]);
		 */

		for (int i = 0; i < 5; i++) {

			System.out.println(arr[i]);
		}

		// ���հ� ���ϱ� => �ݺ����� Ȱ���� �� �ִ�.
		int sum = 0;
		for (int i = 0; i < 5; i++) {

			sum += arr[i];
		}

		System.out.println("sum : " + sum);

		System.out.println(arr[0]); // 0 �̶�� ���� �� ������ �� ����
		System.out.println(arr); // [I@6d06d69c �� ���� �� �� ���� ���� ���´� => �ּҰ�!!
	}

	public void method2() {

		int i = 10;

		int[] iArr = new int[5];

		System.out.println("i : " + i);
		System.out.println("iArr : " + iArr);
		System.out.println("iArr �� �ؽ��ڵ尪 : " + iArr.hashCode());
		// �ؽ��ڵ� : �ּҰ��� �������� ���·� �����ִ� ����

		double[] dArr = new double[3];
		System.out.println("dArr : " + dArr);
		System.out.println("dArr �� �ؽ��ڵ尪 : " + dArr.hashCode());

		/*
		 * �⺻�ڷ��� : boolean, char, byte, short, int, long, float, double => stack ������ ����
		 * ���� �ٷ� ���� �� �ִ� ���� => �Ϲ� ����
		 * 
		 * �� �̿��� �ڷ��� : String, int[], double[], short[], byte[], Scanner, A_Array, ...
		 * => stack ������ �ּҰ��� ��� �ִ� ���� (�������� heap ������ �������) => ���� ���� (���۷��� ����)
		 */
	}

	public void method3() {

		// �迭�� ����� ���ÿ� �Ҵ�
		// �ڷ���[] �迭�� = new �ڷ���[������];

		int[] iArr = new int[3]; // [0], [1], [2]
		double[] dArr = new double[3]; // [0], [1], [2]

		// System.out.println(iArr[0]);

		// �迭�� ����� �� �ݺ����� ���� �� �����ϴ�.
		// 0�� �ε����������� ������ �ε������� ���������� ����� �� �ִ�.
		// �������ε��� == �迭��ũ�� - 1

		// �迭�� ũ�⸦ �ƴ� ���
		// [ ǥ���� ] �迭��.length
		// => �������� : ���⼭�� length �� �޼ҵ尡 �ƴ�!!
		System.out.println("iArr �迭�� ũ�� : " + iArr.length);
		System.out.println("dArr �迭�� ũ�� : " + dArr.length);

		/*
		 * for(int i = 0; i < 3; i++) {
		 * 
		 * System.out.println(iArr[i]); }
		 */

		for (int i = 0; i < iArr.length; i++) {

			System.out.println(iArr[i]);
		}

		for (int i = 0; i < dArr.length; i++) {

			System.out.println(dArr[i]);
		}

		/*
		 * ������ �ε����� ���� �������� �ʾƵ� ���� �������! int �� �迭���� 0, double �� �迭���� 0.0 �� �������
		 * 
		 * => �޸��� heap �������� ����� �� �������� ������ �� ���� �迭�� ��������� ���ÿ� JVM �� ���ؼ� �⺻������ �ʱ�ȭ�� �����
		 */
	}

	public void method4() {

		int[] arr = new int[5]; // [0], [1], [2], [3], [4]
								// 0 0 0 0 0
		/*
		 * arr[0] = 1; arr[1] = 2; arr[2] = 3; arr[3] = 4; arr[4] = 5;
		 * 
		 * arr[10] = 10;
		 */
		// ArrayIndexOutOfBoundsException : 10
		// �迭�� �ε��� ������ ���
		// 10 �� �ε������� ������ �߻�

		// => ���� �ѹ� �迭�� ��������� �� ������ ������ ��� ���� �̿��� �� ����.
		// ���ѵ� ���� �ȿ����� �̿� �����ϴ�.

		// �� ������ ���� for��
		for (int i = 0; i < arr.length; i++) {

			arr[i] = i + 1;
		}

		// �� ��°� ���ÿ� ���� ������ ���ִ� for��
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);
			sum += arr[i];
		}

		System.out.println("�� �հ� : " + sum);

		System.out.println("arr : " + arr); // �ش� �迭�� �ּҰ�
		System.out.println("arr�� �ؽ��ڵ尪 : " + arr.hashCode()); // �ؽ��ڵ� : �ּҰ��� 10��������
	}

	public void method5() {

		// �迭�� �� ������ ���� ����

		int[] arr = new int[10]; // [0], [1], [2], .., [9]

		// 0 �� �ε����������� ������ 9 �� �ε������� 51 ~ 100 ������ ������ (�� 50��)
		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) (Math.random() * 50) + 51;
		}

		// �� ����ֳ� ��¿� �ݺ���
		// arr[x] : xx ���� ���
		for (int i = 0; i < arr.length; i++) {

			System.out.printf("arr[%d] : %d \n", i, arr[i]);
		}

		// ������ ���� (1 ~ 45) �� �ߺ� ���� 6���� ���� �� �ִ� ���α׷�? => �ζ�
	}

	public void method6() {

		int[] arr = new int[5];

		System.out.println(arr);
		System.out.println("arr �� �ؽ��ڵ尪 : " + arr.hashCode());

		/*
		 * arr[0] = 2; arr[1] = 4; arr[2] = 6; arr[3] = 8; arr[4] = 10;
		 */

		// ����
		int value = 2; // �� ���Կ� ������ �ʱ��
		for (int i = 0; i < arr.length; i++) {

			// arr[i] = (i + 1) * 2; // 2 4 6 8 10
			arr[i] = value;
			value += 2;
		}

		// ���
		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + " ");
		}

		// arr[5] = 12;
		// arr[6] = 14;

		/*
		 * �迭�� ���� ū ���� �ѹ� ������ �迭�� ũ�⿡ ���� ���������� ���� �ѹ� ������ �迭�� ũ�⸦ ���� �Ұ� => �迭�� ũ�⸦ �����ϰ���
		 * �Ѵٸ� ��¿������ ���ο� �迭�� �������� (���Ҵ�)
		 */

		arr = new int[7]; // �Ҵ縸 �ٽ����ز�

		System.out.println();

		System.out.println("=== arr ���� �� ===");
		System.out.println(arr);
		System.out.println("arr �� �ؽ��ڵ尪 : " + arr.hashCode());

		/*
		 * �޸� ������ �׻� ������ �ּҰ��� ����������, �Ҵ�� ������ �ο��Ǿ��� �ּҰ��� ���� ��ġ�� �ʴ´�! ���Ӱ� �迭�� �Ҵ縸 �ٽ� �Ѵٸ�
		 * ������ �����ϰ��ִ� ������ �������� ���ο� ���� �����ϰԵ� ������ ������ ������ �迭�� heap ������ �ϴ� ���� ���ٴ� ���� �ð���
		 * ������ "������ �÷���" �� ���� ������ => ������ �÷��� (�ڵ� �޸� ����)
		 */

		// ����) ���� ����Ǿ��ִ� ���� ������ �Ѵٸ�?
		arr = null; // null : "����" �� �ǹ��ϴ� ��

		System.out.println(arr); // null ���
		// arr[0] = 10;
		// NullPointerException : �ּҰ� ���µ� ��� �����ؼ� �����ҷ�?
		// ��� �˷��ִ� ����
		// System.out.println(arr.hashCode());

		/*
		 * �⺻ �ڷ����� �⺻���� ������ ����. ������ : 0 �Ǽ��� : 0.0 ������ : ' ' ���� : false
		 * 
		 * ���� �ڷ����� �⺻���� ������ ���� null : "����" �� ��Ÿ���� �� => "�ּҰ��� ����"
		 */
	}

	// �ǽ�����
	public void method7() {

		// 3���� ����ڿ��� �Ź� Ű�� ������ �Է¹ް� �迭�� ��Ƶΰ�
		// 3���� Ű ������ �ݺ����� �̿��Ͽ� ���
		// 3���� Ű ������ �հ�, ��� (�� �հ� / ����)

		Scanner sc = new Scanner(System.in);

		double[] heights = new double[3]; // [0], [1], [2]
											// 0.0 0.0 0.0

		for (int i = 0; i < heights.length; i++) {

			System.out.print("Ű �Է� (cm) : ");
			heights[i] = sc.nextDouble();

			sc.nextLine();
		}

		// 3 ���� Ű ������ ���, �հ赵 ���̱��ϱ�
		double sum = 0.0;
		for (int i = 0; i < heights.length; i++) {

			System.out.println(heights[i]);
			sum += heights[i];
		}

		// 3���� Ű�� �� �հ� ���, ��� ���
		System.out.println("3���� Ű�� �� �հ� : " + sum);
		// System.out.println("3���� Ű�� ��� : " + (sum / heights.length));
		System.out.printf("3���� Ű�� ��� : %.2f \n", (sum / heights.length));
	}

	// �ǽ�����
	public void method8() {

		// ����ڿ��� ���ڿ��� �ϳ� �Է¹��� ��
		// ������ ���ڵ��� char �迭�� �Űܴ��

		Scanner sc = new Scanner(System.in);

		System.out.print("���ڿ��� �Է��ϼ��� : ");
		String str = sc.nextLine();

		// ���ڿ� ���̸�ŭ�� ���� ���� char �迭 �����
		// (�迭 ũ�� == ���ڿ��� ����)
		int length = str.length();
		char[] arr = new char[length]; // [0], [1], [2], ..., [length - 1]

		// ���ڿ��κ��� �� �ε��� �ڸ��� ���ڸ� �����ؼ� �� �迭�� �濡 ���
		/*
		 * arr[0] = str.charAt(0); arr[1] = str.charAt(1); arr[2] = str.charAt(2);
		 */
		for (int i = 0; i < length; i++) {

			arr[i] = str.charAt(i);
		}

		// char �迭�� �� �ε����� �����ؼ� ���� �� ����ִ��� ���
		for (int i = 0; i < length; i++) {

			System.out.println(arr[i]);
		}
	}

	public void method9() {

		// �迭 ����
		int[] arr1;

		// �迭 �Ҵ�
		arr1 = new int[5];

		// �迭�� ����� �Ҵ�
		int[] arr = new int[4];

		// �迭�� �� �ε����� �� ����
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;

		// �迭 ����� �Ҵ��� �ϴ� ���ÿ� ���� �ʱ�ȭ(����) ���� �ѹ��� ������ ��� 2����
		// ���1.
		int[] arr2 = new int[] { 1, 2, 3, 4 };

		// ���2.
		int[] arr3 = { 1, 2, 3, 4 };

		// �迭 ��
		System.out.println(arr == arr2); // false
		System.out.println(arr2 == arr3); // false
		System.out.println(arr3 == arr); // false
		// �ּҰ� ���� ������̱� ������ false �� ����!!
		// (String �� ��������)
	}

	// �ǽ� ���� => ����
	public void method10() {

		/*
		 * �����ϴ� ������ ������ �Է¹޾� �׸�ŭ �ݺ��� �����鼭 ���ϸ��� �Է¹ޱ� => �Է¹��������� ���ڿ� �迭�� ���
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("�����ϴ� ������ ������ �Է��ϼ��� : ");
		int num = sc.nextInt();

		sc.nextLine();

		String[] fruits = new String[num];

		for (int i = 0; i < fruits.length; i++) {
			System.out.print("���ϸ� �Է� : ");
			fruits[i] = sc.nextLine();
		}

		System.out.println("[�����ϴ� ���� ���]");
		System.out.println(Arrays.toString(fruits));

	}

	public void method11() {

		int[] arr = new int[6];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		// Array.sort(); => �������� �����ϰ� ���� ��
	}

}
