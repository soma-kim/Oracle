package com.kh.chap04.field.model.vo;

// 필드에서 사용 가능한 접근제한자 종류 4가지
public class FieldTest2 {
	
	/*
	 * (+)public : 어디서든 (같은 패키지, 다른 패키지 모두) 접근 가능하도록 하겠다. 
	 * (#)protected : 같은 패키지 안에서는 무조건 접근 가능하도록 하겠다. 
	 * 				    만약에 다른 패키지에 있는 클래스에서 접근하고 싶다면 
	 * 				    적어도 그 클래스는 가져다 쓰고싶은 클래스와 상속 구조를 이루어야 한다.
	 * 				  (상속은 다음시간에 배울 것)
	 * (~)default : 오로지 같은 패키지 안에서만 접근 가능하도록 하겠다.
	 * (-)private : 오직 해당 클래스 내에서만 접근 가능하도록 하겠다.
	 * 
	 * => 위에서부터 아래로 내려갈수록 접근할 수 있는 제한 범위가 좁아짐.
	 * => +, #, ~, - : 클래스 다이어그램에서의 기호이다.
	 * 
	 */
	
	public String pub = "public";
	protected String pro = "protected";
	String df = "default";
	private String pri = "private";
	
	public static String sta = "FieldTest2의 static";
	
	
	
	
}
