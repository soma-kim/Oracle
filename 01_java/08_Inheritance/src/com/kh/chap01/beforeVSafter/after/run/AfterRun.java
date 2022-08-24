package com.kh.chap01.beforeVSafter.after.run;

import com.kh.chap01.beforeVSafter.after.model.vo.Desktop;
import com.kh.chap01.beforeVSafter.after.model.vo.SmartPhone;
import com.kh.chap01.beforeVSafter.after.model.vo.Tv;

public class AfterRun {


	public static void main(String[] args) {
//		기본생성자를 통해 객체 생성 후 setter 메소드로 필드값 대입
		/*
		Desktop d = new Desktop();
		d.setbrand("삼성");
		d.setpCode("d-01");
		d.setpName("짱짱데스크탑");
		d.setAllInone(true);
		*/
		
//		매개변수생성자 이용
		Desktop d = new Desktop("삼성", "d-01", "짱짱데스크탑", 200000, true);
		
//		brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("애플", "s-01", "아이폰", 1300000, "SKT");
		
//		brandm pCodem pName, price, inch
		Tv t = new Tv("엘지", "t-01", "고오급벽걸이티비", 4000000, 100);
		
//		출력
		System.out.println(d.information());
		System.out.println(s.information());
		System.out.println(t.information());
//		실행하고자 하는 메소드가 부모클래스에만 있고 자식클래스에는 없음
//		자식클래스에서는 부모클래스의 내용물을 가져다 쓸 수 있지만
//		부모 클래스에서는 자식 클래스의 내용물을 가져다 쓸 수 없다!
//		=> 자식 클래스 입장에서 물려받은 부모클래스의 메소드를 내 입맛대로 재정의해서 쓸 수가 있음. "오버라이딩"
//		=> 오버라이딩시 해당 메소드를 호출했을 때 오버라이딩된 자식메소드가 우선적으로 호출됨(동적바인딩)
		
		/*
		 * * 주의사항
		 * 오버로딩이랑 헷갈리면 안됨!
		 * 오버로딩 : 상속과는 관련 없이 메소드명을 동일하게 여러개 만들 수 있는 규칙
		 * 			메소드명은 동일, 매개변수의 자료형의 종류, 순서, 갯수가 다르면 중복된 이름이 가능
		 * 
		 * 오버라이딩 : 상속과 관련 있는 개념으로 "상속 관계"에서
		 * 			  부모 메소드의 내용물을 자식이 내 입맛대로 재정의해서 사용 가능
		 * 			  메소드를 (접근제한자, 반환형, 메소드명, 매개변수) 동일
		 * 
		 * 
		 */
		
		
		
		
	}

}
