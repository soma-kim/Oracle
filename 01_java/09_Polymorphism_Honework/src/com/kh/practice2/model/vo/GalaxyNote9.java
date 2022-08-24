package com.kh.practice2.model.vo;

public class GalaxyNote9 extends SmartPhone {
//	필드부
//	생성자부
	public GalaxyNote9 () {
		
	}
//	메소드부

	@Override
	public void charge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touch() {
		// TODO Auto-generated method stub
		System.out.println("정전식, 와콤펜지원");
	}

	@Override
	public void printMaker() {
		// TODO Auto-generated method stub
		System.out.println("갤럭시 노트9은 삼성에서 만들어졌다.");
	}

	@Override
	public void makeacall() {
		// TODO Auto-generated method stub
		System.out.println("번호를 누르고 통화버튼을 누름");
	}

	@Override
	public void takeacall() {
		// TODO Auto-generated method stub
		System.out.println("전화받기 버튼을 누름");
	}

	@Override
	public void picture() {
		// TODO Auto-generated method stub
		System.out.println("1300만 듀얼카메라");
	}
	
}
