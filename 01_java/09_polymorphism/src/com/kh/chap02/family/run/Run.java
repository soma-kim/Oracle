package com.kh.chap02.family.run;

import com.kh.chap02.family.model.vo.Baby;
import com.kh.chap02.family.model.vo.Basic;
import com.kh.chap02.family.model.vo.Mother;

public abstract class Run {

	public static void main(String[] args) {
		/*
//		일반클래스 : 객체 생성이 가능
		Person p = new Person();
//		일반클래스 : 다형성이 적용 가능
		Person p1 = new Mother();
		Person p2 = new Baby();
		*/
		
//		추상클래스 : 객체 생성이 불가능
//		Person p = new Person();
		
//		추상클래스 : 다형성 적용 가능
//		인터페이스 적용 전
		/*
		Person p1 = new Mother("김엄마", 50, 70, "출산");
		Person p2 = new Baby("박응애", 3.5, 70);
		
		System.out.println(p1); // 엄마 : 몸무게 50, 건강도 70
		System.out.println(p2); // 애기 : 몸무게 3.5, 건강도 70
		
		p1.eat(); // 엄마 : 몸무게+ 10, 건강도 - 10
		p2.eat(); // 아기 : 몸무게 + 3, 건강도 + 1
		p1.sleep(); // 엄마 : 건강도 +10
		p2.sleep(); // 아기 : 건강도 +3
		
		System.out.println("===다음날===");
		System.out.println(p1);
		System.out.println(p2);
		*/
		
		
//		인터페이스 적용 후
//		Basic b = new Basic(); //인터페이스는 객체 생성이 불가능
		
//		다형성도 마찬가지로 적용 가능
		Basic b1 = new Mother("김엄마", 50, 70, "출산");
		Basic b2 = new Baby("박응애", 3.5, 70);
		
		System.out.println(b1);
		System.out.println(b2);
		
		b1.eat(); // 엄마 : 몸무게 + 10, 건강도 - 10
		b2.eat(); // 아기 : 몸무게 + 3, 건강도 + 1
		b1.sleep(); // 엄마 : 건강도 + 10
		b2.sleep(); // 아기 : 건강도 + 3
		
		System.out.println("===다음날===");
		System.out.println(b1);
		System.out.println(b2);
		
	}

}
