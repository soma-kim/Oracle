package com.kh.chap02.inherit.run;

import com.kh.chap02.inherit.medel.vo.Airplane;
import com.kh.chap02.inherit.medel.vo.Car;
import com.kh.chap02.inherit.medel.vo.Ship;

public class Run {
	public static void main(String[] atgs) {
//		객체 생성
		Car c = new Car("벤틀리", 12.5, "세단", 4);
		Ship s = new Ship("새우잡이배", 3, "어선", 1);
		Airplane a = new Airplane("보잉774", 0.02, "여객기", 10, 5);
		
//		출력
		System.out.println(c.information()); // Car 클래스에 재정의된 information 호출
		System.out.println(s.information()); // Ship 클래스에 재정의된 information 호출
		System.out.println(a.information()); // Airplane 클래스에 재정의 된 information 호출
//		만약에 각 자식클래스에 information 메소드를 재정의하지 않았다면 (재정의 == 오버라이딩)
//		각각 부모클래스인 Vehicle에 있는 information 메소드로 호출됐을 것!
//		=> 재정의하는 순간 자식메소드로 우선권이 넘어가서 호출된다!
		
		c.howToMove();
		s.howToMove();
		a.howToMove();
		
		/*
		 * * 상속의 장점
		 * - 보다 적은 양의 코드로 새로운 클래스들을 작성 가능
		 * - 중복된 코드를 공통적으로 관리하기 때문에 새로운 코드를 추가하거나 수정할 때 용이
		 * => 프로그램의 생산성과 유지보수에 크게 기여
		 * 
		 * * 상속의 특징
		 * - 자식 클래스는 부모 클래스의 코드를 다 가져다 쓸 수 있지만
		 * 	  부모 클래스는 자식 클래스의 코드를 가져다 쓸 수 없다
		 * - 클래스간의 상속은 다중상속이 불가능하다. (단일 상속만 가능, 엄빠 하나로 퉁침)
		 *   만약 다중상속시에 서로 같은 필드명, 메소드명이 있을 거에 대비해서 처음부터 막아둠
		 * - 명시되어 있지는 않지만 모든 클래스 (자바에서 미리 만들어서 제공되는 클래스, 내가 만든 클래스)
		 * 	 object (자바에서 미리 만들어서 제공되는 클래스) 클래스의 후손이다.
		 * 	 => object 클래스에서 이미 만들어진 메소드를 가져다 쓸 수 있음
		 * 	 => object 클래스에서 이미 만들어진 메소드가 맘에 안들면
		 *      오버라이딩을 통해 재정의가 가능하다.
		 */
		
		System.out.println(c.hashCode()); // 십진수 형태의 주소값 반환
		System.out.println(c.equals(s)); // 동등비교 결과 반환
//		 => object라는 최상위 클래스에서 제공하는 메소드들!
		
		
	}

}
