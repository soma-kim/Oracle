package com.kh.study;

import java.util.Scanner;

public class Practice9 {
	public void Practice9() {
//		중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요.
//		총 점 100점 중 배점으로는 다음과 같다.
//		중간고사 (20%), 기말고사 (30%), 과제 (30%), 출석 (20%)
		
		Scanner sc = new Scanner(System.in);
		System.out.print("중간고사 점수 : ");
		int Mid = sc.nextInt();
		
		System.out.print("기말고사 점수 : ");
		int Final = sc.nextInt();
		
		System.out.println("과제 점수 : ");
		int Project = sc.nextInt();
		
//		이 때, 출석 회수는 총 강의 회수 20회 중에서 출석한 날만 입력
		System.out.println("출석 횟수 : ");
		int Att = sc.nextInt();
		while (true) {
			
		}
		
//		총점이 70점 이상이면서 전체 강의의 70%이상 출석을 했을 경우 Pass,
//		아니면 Fail을 출력하세요
		
		int sum = Mid + Final + Project + Att;
		if (sum >= 70 && Att / 20 >= 0.7) {
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
		
		
		
	}
}
