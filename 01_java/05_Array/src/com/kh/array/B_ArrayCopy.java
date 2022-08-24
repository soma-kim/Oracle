package com.kh.array;

import java.util.Arrays;

public class B_ArrayCopy {
	
	/*
	 * * �迭 ����
	 * - ���� ���� : �����ϴ� �ô��� ���°� => �ּҰ��� �����
	 * - ���� ���� : ������ ���ο� �迭�� �ϳ� ������ �����ؼ� ���� ���ΰ����� ����
	 */
	
	// ���� ����
	public void method1() {
		
		// ���� : ������ ������ ����ڴ�.
		// => ���׽�Ʈ�� ���� �迭�� �־������ ����!!
		
		// ���� �迭
		int[] origin = {1, 2, 3, 4, 5};
		
		System.out.println("== ���� �迭 ��� ==");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		// ���纻 �迭 : �������κ��� ���縦 ���� ���� ����
		int[] copy = origin;
		
		System.out.println("\n== ���纻 �迭 ��� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		// ���纻 �迭 �����ϱ�
		copy[2] = 99;
		
		System.out.println("\n== ���纻 �迭 ���� �� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\n== ���纻 �迭�� ���� ���� ���� ==");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		// ���纻 �迭���� ������ ������ �ߴµ� ���� �迭�� ���뵵 ���� ������ �Ȱ� ����.
		// => ���� �迭�� �Բ� ���� ����� ���� �� �� �ִ�.
		// �������� : �迭�� �ּҰ��� ����Ǿ� ������ ���纻�� ���� ����
		System.out.println("\n���� �迭�� �ؽ��ڵ尪 : " + origin.hashCode());
		System.out.println("���纻 �迭�� �ؽ��ڵ尪 : " + copy.hashCode());
	}
	
	// ���� ���� 4���� ���
	public void method2() {
		
		// 1. for���� �̿��ϴ� ���
		// ���ο� �迭�� ���� �� �Ҵ���� ���� ������ (�⺻��)
		// ���� �迭�κ��� ������ �� for���� �̿��ؼ� �Ű� �����ϴ� ���
		
		// ���� �迭
		int[] origin = {1, 2, 3, 4, 5};
		
		// ���纻 �迭
		int[] copy = new int[origin.length]; // �� ���� �⺻���� 0 ���� �ʱ�ȭ�� ����
		
		/*
		copy[0] = origin[0];
		copy[1] = origin[1];
		.. 
		*/
		for(int i = 0; i < copy.length; i++) {
			copy[i] = origin[i];
		}
		
		System.out.println("== ���纻 �迭 ��� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		copy[2] = 99;
		
		System.out.println("\n== ���纻 �迭 ���� �� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\n== ���纻 �迭�� ���� ���� ���� ==");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		
		System.out.println("\n���� �迭�� �ؽ��ڵ尪 : " + origin.hashCode());
		System.out.println("���纻 �迭�� �ؽ��ڵ尪 : " + copy.hashCode()); // ���� �ּҰ��� �ٸ��� ����! ���� ȸ�� x
		
	}
	
	public void method3() {
		
		// 2. ���ο� �迭�� ���� (���� �� �Ҵ�) ��
		//    System Ŭ�������� �����ϴ� arraycopy �޼ҵ带 ȣ���Ͽ� ����
		
		// ���� �迭
		int[] origin = {1, 2, 3, 4, 5};
		
		// ���纻 �迭
		int[] copy = new int[10]; // 0 0 0 0 0 0 0 0 0 0
		
		// System Ŭ������ arraycopy �޼ҵ� ����
		// [ ǥ���� ]
		// System.arraycopy(�����迭��, �����迭�Ǻ��縦�������ε���, ���纻�迭��, ���纻�迭�Ǻ��縦�������ε���, �����Ұ���);
		System.arraycopy(origin, 0, copy, 0, 5); // 1 2 3 4 5 0 0 0 0 0 
		// System.arraycopy(origin, 0, copy, 2, 5); // 0 0 1 2 3 4 5 0 0 0
		// System.arraycopy(origin, 0, copy, 1, 3); // 0 1 2 3 0 0 0 0 0 0
		// System.arraycopy(origin, 2, copy, 1, 3); // 0 3 4 5 0 0 0 0 0 0
		// System.arraycopy(origin, 2, copy, 9, 2); // 0 0 0 0 0 0 0 0 0 3 4 ????
		// ArrayIndexOutOfBoundsException �߻�!! => �����ϴ� �������� �ε��� ������ ����� �߻�
		
		System.out.println("== ���纻 �迭 ��� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\n���� �迭�� �ؽ��ڵ尪 : " + origin.hashCode());
		System.out.println("���纻 �迭�� �ؽ��ڵ尪 : " + copy.hashCode());
		// �ٸ� �ּҰ��� ������ ���� == �ٸ� ���� �����ϰ� ����
		// => �������簡 ����� �̷���� �迭�� ������ �� ���� ������ ���� �ʴ´ٴ°��� ���� ����
	}
	
	public void method4() {
		
		// 3. Arrays Ŭ������ copyOf �޼ҵ带 ȣ���ϴ� ���
		
		// ���� �迭
		int[] origin = {1, 2, 3, 4, 5};
		
		// ���纻 �迭
		// Arrays Ŭ������ copyOf �޼ҵ� ��� ���
		// [ ǥ���� ] ���纻�迭 = Arrays.copyOf(�����迭��, �����Ұ���);
		int[] copy = Arrays.copyOf(origin, 10); // �� ��, copy�迭��ũ�� == �����Ұ���
		
		System.out.println("== ���纻 �迭 ��� ==");
		for(int i = 0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println("\n���� �迭�� �ؽ��ڵ尪 : " + origin.hashCode());
		System.out.println("���纻 �迭�� �ؽ��ڵ尪 : " + copy.hashCode());
		// => �������簡 �� �Ǿ���.
	}
	
	public void method5() {
		
		// 4. clone �޼ҵ带 ȣ���Ͽ� ����
		
		// ���� �迭
		int[] origin = {1, 2, 3, 4, 5};
		
		// ���纻 �迭
		// clone �޼ҵ� ����
		// [ ǥ���� ] ���纻�迭�� = �����迭��.clone();
		int[] copy = origin.clone(); // ������ �ɼ��� �������� ���� => �ս��� ���� ���簡 ����
		
		// ���纻 ����غ���
		// [1, 2, 3, 4, 5] ���·� ����ϰ�ʹ�!
		/*
		System.out.print("[");
		for(int i = 0; i < copy.length; i++) {
			
			// ���빰 ���
			if(i < copy.length - 1) { // ������ �ε��� ������

				System.out.print(copy[i] + ", ");
			}
			else { // ������ �ε����ϰ��
				
				System.out.print(copy[i]);
			}
		}
		System.out.print("]");
		*/
		
		System.out.println(Arrays.toString(copy));
		// Arrays.toString(����ϰ����ϴ¹迭��);
		// => �հ� �ڿ� ���� [, ] , ���빰 ���̿��� ��ǥ�� ���̾����� �Ѱ��� ���ڿ��� �������ִ� �޼ҵ�
		
		System.out.println("���� �迭�� �ؽ��ڵ尪 : " + origin.hashCode());
		System.out.println("���纻 �迭�� �ؽ��ڵ尪 : " + copy.hashCode());
		// => ���� ���簡 �� �̷������.
	}

}
