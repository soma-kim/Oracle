package com.kh.chap01.poly.part02.electronic.ElectriniController2;

import com.kh.chap01.poly.part02.electronic.model.vo.Electronic;

//	다형성을 적용시켰을때
public class ElectronicController2 {
//	용산전자상가에 다시 새롭게 차린 가게

//	필드부
//	어느물건이든지 넣을 수 있는 3칸짜리 창고 
	private Electronic[] elec = new Electronic[3];

//	메소드부
//	창고에 물건을 넣는 메소드 : 뭐를 어디에 넣을건지 ?
	public void insert(Electronic any, int index) {
		elec[index] = any;
	}

//	창고로부터 물건을 하나 꺼내오는 메소드 : 어디로부터 가져올건지?
	public Electronic select(int index) {
		return elec[index];
	}

//	창고에 있는 물건 모두를 다 보여주는 메소드
	public Electronic[] select() {
		return elec;
	}

}
