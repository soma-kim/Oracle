package com.kh.chap01.beforeVSafter.before.run;

import com.kh.chap01.beforeVSafter.before.model.vo.Desktop;
import com.kh.chap01.beforeVSafter.before.model.vo.SmartPhone;
import com.kh.chap01.beforeVSafter.before.model.vo.Tv;

public class BeforeRun {

	public static void main(String[] args) {
//		 Desktop 객체
//		 기본생성자로 객체 생성 후 setter 메소드를 통해 필드값 대입
		Desktop d = new Desktop();
		d.setBrand("삼성");
		d.setpCode("d-01");
		d.setpName("짱짱데스크탑");
		d.setPrice(2000000);
		d.setallnOne(true);
		
//		SmartPhone 객체
//		매개변수생성자로 한번에 객체 생성과 동시에 초기화
//		brand, pCode, pName, price, mobileAgency
		SmartPhone s = new SmartPhone("애플, ", "s-01", "아이폰", 1300000, "SKT");
		
//		Tv객체
//		매개변수 생성자로 하넌에 객체 생성과 동시에 초기화
//		brand, pCode, pName, price, inch
		Tv t = new Tv("엘지", "t-01", "고오급벽걸이티비", 4000000, 100);
		
//		출력
		/*
		System.out.println(d);
		System.out.println(s);
		System.out.println(t);
//		=> 각각의 주소값이 출력 (객체는 참조자료형 변수이기 때문에)
		 */
 
		System.out.println(d.information());
		System.out.println(s.information());
		System.out.println(t.information());
//		=> information이라는 메소드를 호출해서 각 필드에 담긴 값들을 문자열로 연이어서 출력
		
		/*
		 * *매 클래스마다 중복된 코드들을 일일이 기술하면
		 *  수정과 같은 유지보수시 매번 일일이 찾아서 수정해야한다는 번거로움이 생김
		 *  
		 *  => "상속"이라는 개념을 적용시켜서
		 *  	매 클래스마다 중복된 필드, 중복된 메소드들을 단 한번 또 하나의 클래스로 정의해둔 후 
		 *  	해당 클래스를 가져다 쓰는 방식으로 진행
		 *  
		 *  * 상속
		 *  다른 클래스가 가지고 있는 필드, 메소드들을 새로 작성할 클래스에서 직접 만들지 않고 
		 *  이미 만들어진 클래스에서 "상속"받음으로써 자신의 필드, 자신의 메소드처럼 사용 가능한 개념
		 *  => 즉, 코드를 물려받겠다.
		 *  
		 *  코드를 물려받는 측   -------->  코드를 물려주는 측
		 *  	자식 						   부모
		 *  	후손						   조상
		 *  	하위					           상위
		 */
	
	}

}
