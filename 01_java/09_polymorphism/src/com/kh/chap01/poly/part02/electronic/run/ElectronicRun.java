package com.kh.chap01.poly.part02.electronic.run;



import com.kh.chap01.poly.part02.electronic.ElectriniController2.ElectronicController2;
import com.kh.chap01.poly.part02.electronic.controller.ElectronicController1;
import com.kh.chap01.poly.part02.electronic.model.vo.Desktop;
import com.kh.chap01.poly.part02.electronic.model.vo.Electronic;
import com.kh.chap01.poly.part02.electronic.model.vo.NoteBook;
import com.kh.chap01.poly.part02.electronic.model.vo.Tablet;

public class ElectronicRun {

	public static void main(String[] args) {
//		1. 다형성을 적용하기 전 (ElectronicControoler1)
		ElectronicController1 ec = new ElectronicController1();
		/*
//		이 시점 기준에서 ec.desk == null, ec.note == null, ec.tab == null
//		=> 우리가게에 빈상자 세개가 생긴 꼴
		
//		ec.desk = new Desktop();
//		=> desk라는 상자는 private라 직접접근 불가 
		
//		Desktop d= new Desktop("삼성", "데탑", 1200000, "Geforce 1070");
//		ec.insert(d);
		ec.insert(new Desktop("삼성", "데탑", 1200000, "Geforce 1070"));
		
		ec.insert(new NoteBook("엘지", "그램", 2000000, 4));
		
		ec.insert(new Tablet("애플", "아이패드", 500000, false));
//		=> 여기까지 물건을 각각 납품 받아서 상자에 담아준 꼴
//		손님에게 제품들을 상자로부터 꺼내서 보여주기
		Desktop d = ec.selectDesktop();
		NoteBook n = ec.selectNoteBook();
		Tablet t = ec.selectTablet();
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t); // 우리가 원하는 내용물로 보일것 (toString을 오버라이딩 했기 때문에)
		*/
		
//		2. 다형성을 적용했을 경우 (ElectornicController2)
		
		ElectronicController2 ec2 = new ElectronicController2();
		ec2.insert(new Desktop("삼성", "데탑", 1200000, "Geforce 1070"), 0);
		ec2.insert(new NoteBook("엘지", "그램", 2000000, 4), 1);
		ec2.insert(new Tablet("애플", "아이패드", 500000, false), 2);
		
//		창고에 담긴 물건들을 하나씩 뽑아보기
		/*
		Desktop d = (Desktop)(ec2.select(0));
		NoteBook n = (NoteBook)(ec2.select(1));
		Tablet t = (Tablet)(ec2.select(2));
		
		System.out.println(d);
		System.out.println(n);
		System.out.println(t);
		*/
		
		//반복문을 활용해서 물건 꺼내오기
		Electronic[] elec = ec2.select();
		
		for (int i = 0; i < elec.length; i++) {
			System.out.println(elec[i] /*toString*/);
		}
		
		
		/*
		 * * 다형성을 사용하는 이유
		 * 1. 부모타입의 객체배열로 다양한 자식객체들을 모아서 담아둘 수 있음
		 * 2. 메소드의 매개변수나 반환형에 다형성을 적용하게 되면 
		 * 	    메소드 갯수가 확 줄어든다.
		 */
	}

}
