package com.kh.chap02.abstractAndInterface.part01.basic.model.vo;

//	추상클래스 (abstract 키워드) == 미완성된 클래스
public abstract class Sports {
//	 필드부
	private int people; // 스포츠에 참여하는 선수 명 수

//	 생성자부
	public Sports() {

	}

	public Sports(int people) {
		this.people = people;
	}

//	 메소드부
//	 getter / setter, toString() 오버라이딩
	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "people = " + people;
	}

//	규칙을 출력하는 void rule() 메소드
	public abstract void rule();
	
//	몸통부가 존재하지 않는 미완성된 메소드 == 추상메소드
//	단, 추상메소드를 정의하고자 한다면 표현법상 abstract라는 예약어를 추가해줘야한다.
	
//	미완성된 추상 메소드가 하나라도 포함되는 순간
//	해당 클래스 또한 미완성된 클래스(추상클래스)가 되어버린다.
	
//	추상 클래스 또한 예약어로 abstract를 붙이면 됨
	
}
