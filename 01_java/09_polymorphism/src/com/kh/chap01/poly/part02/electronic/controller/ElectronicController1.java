package com.kh.chap01.poly.part02.electronic.controller;

import com.kh.chap01.poly.part02.electronic.model.vo.Desktop;
import com.kh.chap01.poly.part02.electronic.model.vo.NoteBook;
import com.kh.chap01.poly.part02.electronic.model.vo.Tablet;

// 다형성을 적용시키기 전
public class ElectronicController1 {
	
//	용산전자상가에 새로 차린 가게
//	필드부 : 전자제품을 진열할 수 있는 빈 상자 종류별로 한개씩 선언
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	
//	메소드부 : 해당 상자에 물건을 넣는 용도의 메소드들, 상자에 담긴 물건을 꺼내서 보여주는 메소드들 
//	물건을 넣는 (필드에 값을 대입하는) 용도의 메소드들
	
//	Desktop을 넣는 메소드
	public void insert(Desktop d) {
//		Desktop d = new Desktop("삼성", "데스크탑", 1200000, "Geforce 1070");
		desk = d;
	}
	
//	NoteBook을 넣는 메소드 : 오버로딩 적용
	public void insert(NoteBook n) {
		note = n;
	}
	
//	tablet을 넣는 메소드
	public void insert(Tablet t) {
		tab = t;
	}
	
	
//	상자에 담긴 물건을 꺼내서 보여주는(필드에 담긴 값을 리턴) 용도의 메소드
//	Desktop 객체를 꺼내서 보여주는 메소드
	public Desktop selectDesktop() { 
		return desk;
	}
	
//	NoteBook 객체를 꺼내서 보여주는 메소드 : 이번 경우에는 오버로딩 적용 불가
	public NoteBook selectNoteBook() {
		return note;
	}
	
//	Tablet 객체를 꺼내서 보여주는 메소드
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
}
