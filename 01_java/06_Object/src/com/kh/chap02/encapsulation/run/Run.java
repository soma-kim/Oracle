package com.kh.chap02.encapsulation.run;

import com.kh.chap02.encapsulation.model.vo.Student;

public class Run {

	/*
	 * 7. 캡슐화 작업을 통해서 완벽한 클래스의 형태를 갖추게 하자.
	 * 
	 * 캡슐화를 하지 않으면 : 외부로부터 직접접근이 가능하기 때문에 함부로 값이 변경, 조회될 수 있다.
	 * 				   => 이 이슈를 막기 위해 캡슐화 작업을 해야함!!
	 * 
	 * * 객체지향 설계원칙 중 하나가 "정보은닉" => 캡슐화 작업을 통해 진행
	 * * 데이터의 직접접근을 막을것, 단, 간접적으로 접근할 수 있게끔은 해줘야함!! 
	 *   => 메소드를 활용하여 간접적으로 접근할 수 있게 하자!!
	 *   
	 *   1) 정보 은닉 단계 : 필드들의 접근제한자를 private으로 변경하기 
	 *   				  외부로부터 필드들의 직접 접근을 막기위해 항상 필드들의 접근제한자는 public이 아닌
	 *   				  private을 쓴다. 
	 *   2) setter / getter 메소드 만들기 : 간접적으로나마 접근해서 값을 대입하거나(setter),
	 *   							     그 값을 가져올 수 있는 메소드를 (getter) 만들어야 한다! 
	 *   
	 *   
	 */
	
	public static void main(String[] args) {
		
		Student hong = new Student(); // 객체를 생성한다. (== 인스턴스화(클래스를 객체처럼 만든다)한다.)
		
		/*
		hong.name = "홍길동"; // is not visible 오류 발생 
		hong.age = 20; 
		hong.height = 168.7;
		*/
		
		/*
		System.out.println(hong.name);
		System.out.println(hong.age);
		System.out.println(hong.height);
		*/
		
//		위와 같이 대입을 직접적으로 했을 경우 
//		우리가 private으로 접근 제한을 막아버렸기 때문에
//		.(직접접근연산자)를 통해 필드에 직접 접근이 불가능해짐
//		=> 간접적으로나마 메소드를 통해 접근이 가능하도록 해야함 
		
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setHeight(168.7);
		
//		간접적으로 조회할 수 있게 도와주는 getter 메소드들 호출
//		String name = hong.getName();
		
		System.out.println(hong.getName());
		System.out.println(hong.getAge());
		System.out.println(hong.getHeight());
		
//		xxx님의 나이는 xx살이고, 키는 xxx cm 입니다.
		System.out.println(hong.getName() + "님의 나이는" + hong.getAge() + "살이고 , 키는 " + hong.getHeight() + "cm입니다.");
		System.out.println(hong.information());
		
		
//		실습 
//		김영희 학생의 객체를 만드세요
//		이름 : 김영희, 나이:21, 키:180.4
		
		
		Student kim = new Student();
		
		kim.setName("김영희");
		kim.setAge(21);
		kim.setHeight(180.4);
		
		System.out.println(kim.getName() + "님의 나이는" + kim.getAge() + "살이고, 키는 " + kim.getHeight() + "cm입니다.");
		System.out.println(kim.information());
	}

}
