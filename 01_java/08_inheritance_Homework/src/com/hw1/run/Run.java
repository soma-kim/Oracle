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
//		arr[0] = new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과");
//		arr[1] = new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과");
//		arr[2] = new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과");
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
//			System.out.print("이름 : ");
//			String name = sc.nextLine();
//
//			System.out.print("나이 : ");
//			int age = sc.nextInt();
//			
//			sc.nextLine();
//
//			System.out.print("신장 : ");
//			double height = sc.nextDouble();
//
//			System.out.print("몸무게 : ");
//			double weight = sc.nextDouble();
//
//			System.out.print("급여 : ");
//			int salary = sc.nextInt();
//
//			sc.nextLine();
//
//			System.out.print("부서 : ");
//			String dept = sc.nextLine();
//
//			arr2[count] = new Employee(name, age, height, weight, salary, dept);
//			count++;
//
//			System.out.print("계속 추가하시겠습니까?(y or n)");
//			String str = sc.nextLine();
//
//			if (str.charAt(0) == 'n' || str.charAt(0) == 'N') {
//				break;
//			} else if (str.charAt(0) == 'y' || str.charAt(0) == 'Y') {
//				continue;
//			} else {
//				System.out.println("잘못 입력하셨습니다");
//				continue;
//			}
//
//		}

		Controller c = new Controller();
		c.insert(new Student("홍길동", 20, 178.2, 70.0, 1, "정보시스템공학과"), 0);
		c.insert(new Student("김말똥", 21, 187.3, 80.0, 2, "경영학과"), 1);
		c.insert(new Student("강개순", 23, 167.0, 45.0, 4, "정보통신공학과"), 2);

		Person[] p = c.select();

		for (int i = 0; i < p.length; i++) {
			System.out.println(p[i]);
		}

		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			System.out.print("이름 : ");
			String name = sc.nextLine();

			System.out.print("나이 : ");
			int age = sc.nextInt();

			sc.nextLine();

			System.out.print("신장 : ");
			double height = sc.nextDouble();

			sc.nextLine();

			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();

			sc.nextLine();

			System.out.print("급여 : ");
			int salary = sc.nextInt();

			sc.nextLine();

			System.out.print("부서 : ");
			String dept = sc.nextLine();

			c.insert2(new Employee(name, age, height, weight, salary, dept), count);
			count++;

			System.out.print("계속 추가하시겠습니까? (y / n)"); // c2가 y거나 Y일때 계속 반복, n이나 N일때는 종료
			char c2 = sc.nextLine().charAt(0);
			if (c2 == 'y' || c2 == 'Y') {
				continue;
			} else if (c2 == 'n' || c2 == 'N') {
				break;
			} else {
				System.out.print("잘못 입력하셨습니다.");
			}

		}

		Person[] p2 = c.select2();
		for (int i = 0; i < p2.length; i++) {
			p2[i].print;
		}

	}
}
