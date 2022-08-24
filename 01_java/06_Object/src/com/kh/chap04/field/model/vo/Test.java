package com.kh.chap04.field.model.vo;

public class Test {

	public static void main(String[] args) {
		FieldTest2 f2 = new FieldTest2 ();
		// 애초에 같은 패키지에 있기 때문에 import도 안함 
		
		System.out.println(f2.pub); // public : 직접접근 가능 
		System.out.println(f2.pro); // protected : 같은 패키지에 있는 상황이라 직접 접근이 가능한 상황
		
		System.out.println(f2.df); // default : 같은 패키지에 있는 상황이라 직접 접근이 가능
		
//		is not visinble 발생 
//		System.out.println(f2.pri); // private : 해당 클래스 내에서만 직접 접근이 가능
		
		
		
		
		
	}

}
