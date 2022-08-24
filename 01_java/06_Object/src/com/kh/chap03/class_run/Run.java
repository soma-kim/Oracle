package com.kh.chap03.class_run;

import com.kh.chap03.class_.model.vo.Coffee;
import com.kh.chap03.class_.model.vo.Dog;
import com.kh.chap03.class_.model.vo.Person;
import com.kh.chap03.class_.model.vo.Product;

public class Run {

	public static void main(String[] args) {
//		Person이라는 클래스
//		== 사람의 정보를 담고자 내가 만든 나만의 자료형 
//			(여러개의 자료형, 여러개의 값들을 보관 가능)
//		== 사용자 정의 자료형(커스터 마이징)
		/*
		Person p = new Person(); // 객체 생성 == 인스턴스화 
		
		System.out.println(p);; // 주소값이 나옴 
		System.out.println(p.infomation()); // JVM에 의해 채워진 기본 값들이 출력 
		
//		값 넣기 => setter 메소드들 
		p.setId("user01");
		p.setPwd("pass01");
		p.setName("홍길동");
		
		System.out.println(p.infomation());
		
		p.setAge(25);
		p.setGender('남');
		p.setPhone("010-1111-2222");
		p.setEmail("hong@naver.com");
		
		System.out.println(p.infomation());
		
//		------------------------------------------
//		상품 객체 생성
		
		Product p1 = new Product();
		
//		default 접근제한자의 클래스는
//		다른 패키지에 있을 경우 갖다 쓸 수 없게 제한됨
//		단, 같은 패키지에 있을 경우에만 사용 가능!!
		
		
		p1.setpName("아이폰11pro");
		p1.setPrice(100000);
		p1.setBrand("애플");
		
		
		Product p2 = new Product();
		
		p2.setpName("애플워치7");
		p2.setPrice(50000);
		p2.setBrand("애플");
//		 p2.setBrand("애플");
//		setter 메소드로 굳이 brand명을 정해두지 않아도 된다.
//		단, 해당 필드를 상수로 지정하지 않았기 때문에
//		그 이후에 값을 변경하고자 할때는 언제든지 setter 메소드를 호출해서 값을 변경 가능하다.
		
		p1.setBrand("apple");
		System.out.println(p1.information());
		System.out.println(p2.information());
		*/
		
		Dog d = new Dog();
		d.setName("마요네즈");
		d.setType("mix");
		d.setAge(5);
		d.setColor("white");
		d.setGender('남');
		d.setWeight(15);
		
		System.out.println(d.information());
		
		Coffee c = new Coffee();
		c.setName("카페라떼");
		c.setSize("tall사이즈");
		c.setPrice(5500);
		
		System.out.println(c.infomation());
	}

}
