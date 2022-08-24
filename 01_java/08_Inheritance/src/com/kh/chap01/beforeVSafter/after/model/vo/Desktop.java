package com.kh.chap01.beforeVSafter.after.model.vo;

//	자식 클래스 : 부모클래스로부터 중복된 코드를 물려받아 사용하는 클래스
//	=> 자식 클래스에 우선적으로 해야 할 것 : 누구로부터 코드를 물려받을건지 언급 먼저 해야함!
			// 자식	 ------>  부모
			// 후손	 ------>  조상
			// 하위 	 ------>  상위
			// 서브	 ------>  슈퍼
public class Desktop extends Product {
//	필드부
	private boolean allInOne;
	
//	생성자부
	public Desktop() {
		
	}
	public Desktop (String brand, String pCode, String pName, int price, boolean allInone) {
//		상속관계에서 내 부모클래스의 필드값에 접근하고자 할 경우에는 super.부모필드명
//		=> super.은 해당 부모주소를 담고있다. (즉, super.으로 부모에 접근 가능)
//	   	      단, 접근하고자 하는게 private일 경우에는 뭐가 됐든 외부에서 직접 접근이 불가능
		
//		해결방법1. 부모클래스의 자식까지는 접근 가능하도록 
//				 private -> protected로 접근제한자를 수정하는 방법
//				 "정보은닉"을 할 수 없다.
		/*
		super.brand = brand;
		super.pCode = pCode;
		super.pName = pName;
		super.price = price;
		*/
		
//		해결방법2. 부모 클래스에 있는 public 접근 제한자인 setter 메소드 활용하기
//			  	  상속관계에서 부모 클래스에 있는 메소드에 직접 접근하고자 할 경우 super.메소드명();
		/*
		super.setbrand(brand);
		super.setpCode(pCode);
		super.setpName(pName);
		super.setPrice(price);
		*/
		
//		해결방법3. 부모클래스에 있는 매개변수 생성자를 호출하기
//		상속관계에서 부모클래스에 있는 생성자를 호출하고자 할 경우 super 생성자 호출 (반드시 첫줄에 기술)
//		=> 내 안에있던 생성자를 호출할 경우 this 생성자를 호출했었음! (반드시 첫줄에 기술)
		super(brand, pCode, pName, price);
		this.allInOne = allInOne;
	}
	
//	메소드부
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInone(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
//	오버라이딩 작업 (information 메소드) : 부모클래스의 메소드를 내 입맛대로 재정의하는것
	public String information() {
		/*
		return "brand : " + super.getBrand() + ", pCode : " + super.getpCode() + 
				", pName" + super.getpName() + ", price : " + super.getprice() +
				", allInone" + allInOne;
		*/
		return super.information() + " , allInOne : " + allInOne;
		
		
	}
	
	
	
}
