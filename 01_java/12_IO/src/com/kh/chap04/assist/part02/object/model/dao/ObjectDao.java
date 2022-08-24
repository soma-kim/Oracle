package com.kh.chap04.assist.part02.object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.chap04.assist.part02.object.model.vo.Phone;

public class ObjectDao {
	
	// 프로그램 ---> 외부 매체 (파일)
	// 출력 (내보내기, 파일로 저장하겠다)
	public void fileSave() {
		
		// FileOutputStream : 파일에 데이터를 1byte 단위로 출력 할 수 있는 기반 스트림
		// +
		// ObjectOutputStream : 객체 단위로 출력 할 수 있는 보조 스트림
		
		// 테스트용 객체 생성
			Phone ph = new Phone ("아이폰", 1300000);
		
		// 0. 스트림 변수 선언 및 null로 초기화
			ObjectOutputStream oos = null;
			
		// 1. try구문 안으로 들어와 스트림 객체 생성 ( == 연결통로를 만들겠다)
			try {
				oos = new ObjectOutputStream (new FileOutputStream("phone.txt"));

		// 2. 출력
			oos.writeObject(ph);
				
		// 3. 자원 반납( == 연결 통로를 끊겠다) => 반드시 finally 블럭 안에 작성
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} finally {
				// 3. 자원반납 (반드시)
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	// 프로그램 <--- 외부매체 (파일)
	// 입력
	public void fileRead() {
		/*
		// FileInputStream : 파일로부터 데이터를 1byte 단위로 읽어들이기 위해 사용되는 기반 스트림
		// +
		// ObjectInputStream : 객체 단위로 입력받기 위해 사용되는 보조 스트림
		
		// 0. 스트림 변수 선언 및 null로 초기화
		ObjectInputStream ois = null;
		
		// 1. 스트림 객체 생성 ( == 연결 통로를 만들겠다)
		try {
			ois = new ObjectInputStream (new FileInputStream("phone.txt"));
		
		
		// 2. 입력 : ObjectInputStream 객체에서 제공하는 readObject() 메소드 사용
		// Object obj = ois.readObject()
		Phone ph = (Phone) ois.readObject(); // 다형성에 의해 DownCasting 
		System.out.println(ph);
		
		// 3. 연결 통로 끊기 (자원 반납) => finally 블럭에 작성
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 3. 자원 반납
			try {
				ois.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} */
		
		// try ~ with ~ resource 구문 버전
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phone.txt"))) {
		
			Phone ph =  (Phone)ois.readObject();
			System.out.println(ph);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
