package com.kh.chap02.abstractAndInterface.part01.basic.run;

import com.kh.chap02.abstractAndInterface.part01.basic.model.vo.Basketball;
import com.kh.chap02.abstractAndInterface.part01.basic.model.vo.Football;
import com.kh.chap02.abstractAndInterface.part01.basic.model.vo.Sports;

public class BasicRun {

	public static void main(String[] args) {
//		Sports s = new Sports();
//		추상클래스로 절대 객체 생성이 불가
//		=> 미완성된 클래스이기 때문
		
//		Sports s; // 단, 객체 생성만 안될뿐, 참조 자료형 변수로는 활용 가능 (변수로써 선언은 가능)
//		s = new Football();
//		아무리 추상클래스 타입이여도 "다형성"에 의해 자식타입의 객체를 생성 후 담을 수 있음
		
		Sports s = /*(Sports)*/ new Football(); // 자동형변환 된거임 스포츠로
		
//		객체배열
		Sports[] arr = new Sports[2];
		arr[0] = new Basketball();
		arr[1] = new Football();
		
		for(int i = 0; i <arr.length; i++) {
			arr[i].rule();
		}
			
		/*
		 * * 추상 클래스 (미완성된 클래스) => abstract class
		 * - 해당 클래스 내부에 추상메소드가 하나라도 존재하는 순간 반드시 추상클래스로 정의해야함
		 * - 단, 추상메소드가 굳이 없어도 abstract class로 정의하면 추상클래스로 정의됨
		 * 	 (일반 필드 + 일반 메소드 + 추상메소드(생략가능))
		 * 	  => 클래스가 아직 구체적이지 않은 덜 완성된 상태인 것 같을때 (개념적인 이유)
		 * 	  => 이 클래스를 객체 생성이 불가능하게 막고 싶을때 (기술적인 이유)
		 * - 객체 생성이 불가, 다형성을 적용하여 참조변수로는 활용 가능
		 * 
		 * * 추상메소드(미완성된 메소드) => abstract 반환형
		 * - 미완성된 메소드로 몸통부 { }가 구현되어있지 않은 메소드
		 * - 자식 클래스에서 오버라이딩을 통해 완성됨 (즉, 강제로 오버라이딩을 해야함)
		 * 	 => 오버라이딩 하지 않을 경우 에러 발생
		 * 	 => 메소드 사용의 통일성을 확보하기위한 목적으로 사용함
		 *   => 표준화된 틀을 제공할 목적으로 사용함
		 */
		
		
	}
	

}
