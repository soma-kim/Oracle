package com.hw1.run;

import java.util.Scanner;

import com.hw1.controller.Controller;
import com.hw1.model.vo.Employee;
import com.hw1.model.vo.Person;
import com.hw1.model.vo.Student;

public class Run {
	public static void main(String[] args) {

//		Student[] arr = new Student[3];
//
//		arr[0] = new Student("ȫ�浿", 20, 178.2, 70.0, 1, "�����ý��۰��а�");
//		arr[1] = new Student("�踻��", 21, 187.3, 80.0, 2, "�濵�а�");
//		arr[2] = new Student("������", 23, 167.0, 45.0, 4, "������Ű��а�");
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i].toString());
//		}
//
//		Scanner sc = new Scanner(System.in);
//		Employee[] arr2 = new Employee[10];
//
//		int count = 0;
//		while (true) {
//			System.out.print("�̸� : ");
//			String name = sc.nextLine();
//
//			System.out.print("���� : ");
//			int age = sc.nextInt();
//			
//			sc.nextLine();
//
//			System.out.print("���� : ");
//			double height = sc.nextDouble();
//
//			System.out.print("������ : ");
//			double weight = sc.nextDouble();
//
//			System.out.print("�޿� : ");
//			int salary = sc.nextInt();
//
//			sc.nextLine();
//
//			System.out.print("�μ� : ");
//			String dept = sc.nextLine();
//
//			arr2[count] = new Employee(name, age, height, weight, salary, dept);
//			count++;
//
//			System.out.print("��� �߰��Ͻðڽ��ϱ�?(y or n)");
//			String str = sc.nextLine();
//
//			if (str.charAt(0) == 'n' || str.charAt(0) == 'N') {
//				break;
//			} else if (str.charAt(0) == 'y' || str.charAt(0) == 'Y') {
//				continue;
//			} else {
//				System.out.println("�߸� �Է��ϼ̽��ϴ�");
//				continue;
//			}
//
//		}

		Controller c = new Controller();
		c.insert(new Student("ȫ�浿", 20, 178.2, 70.0, 1, "�����ý��۰��а�"), 0);
		c.insert(new Student("�踻��", 21, 187.3, 80.0, 2, "�濵�а�"), 1);
		c.insert(new Student("������", 23, 167.0, 45.0, 4, "������Ű��а�"), 2);

		Person[] p = c.select();

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}

		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.print("�̸� : ");
			String name = sc.nextLine();

			System.out.print("���� : ");
			int age = sc.nextInt();

			sc.nextLine();

			System.out.print("���� : ");
			double height = sc.nextDouble();

			sc.nextLine();

			System.out.print("������ : ");
			double weight = sc.nextDouble();

			sc.nextLine();

			System.out.print("�޿� : ");
			int salary = sc.nextInt();

			sc.nextLine();

			System.out.print("�μ� : ");
			String dept = sc.nextLine();

			c.insert2(new Employee(name, age, height, weight, salary, dept), count);
			count++;

			System.out.print("��� �߰��Ͻðڽ��ϱ�? (y / n)"); // c2�� y�ų� Y�϶� ��� �ݺ�, n�̳� N�϶��� ����
			char c2 = sc.nextLine().charAt(0);
			if (c2 == 'y' || c2 == 'Y') {
				continue;
			} else if (c2 == 'n' || c2 == 'N') {
				break;
			} else {
				System.out.print("�߸� �Է��ϼ̽��ϴ�.");
			}

		}

		Person[] p2 = c.select2();
		for (int i = 0; i < p2.length; i++) {
			p2[i].print;
		}

	}
}
