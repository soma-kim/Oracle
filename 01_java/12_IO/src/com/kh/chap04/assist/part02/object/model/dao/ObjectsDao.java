package com.kh.chap04.assist.part02.object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.chap04.assist.part02.object.model.vo.Phone;

public class ObjectsDao {
	// 프로그램 ---> 외부매체 (파일)
	// 출력
	public void fileSave() {
		// FileOutputStream + ObjectOutputStream (1byte 짜리 좁은 통로)
		/*
		// 테스트용 객체 배열 생성
		Phone [] arr = new Phone[3];
		
		// 테스트용 데이터 담기
		arr[0] = new Phone("아이폰", 1300000);
		arr[1] = new Phone("갤럭시", 1500000);
		arr[2] = new Phone("플립폰", 2000000);
		*/
		
		
		// Phone 객체만 들어갈 수 있는 ArrayList 생성
		ArrayList<Phone> phoneList = new ArrayList<>();
		phoneList.add(new Phone("아이폰", 1300000)); // 0번 인덱스
		phoneList.add(new Phone("갤럭시", 1500000)); // 1번 인덱스
		phoneList.add(new Phone("플립폰", 2000000)); // 2번 인덱스
		
		
		
		
		
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phones.txt"))) {
			
			// 출력 : ObjectOutputStream 객체에서 제공하는 WriteObject() 메소드 사용
//			oos.writeObject(arr[0]);
//			oos.writeObject(arr[1]);
//			oos.writeObject(arr[2]);
			
			/* 객체 배열이었을때 구문
			// 반복문 이용해서 파일로 내보내기 
			for(int i = 0; i < arr.length; i++) {
				oos.writeObject(arr[i]);
			}
			*/
			
			// ArrayList일때의 구문
			for (int i = 0; i < phoneList.size(); i++) {
				
				oos.writeObject(phoneList.get(i));
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		}
		
	// 프로그램 <--- 외부매체 (파일)
	// 입력 
	public void fileRead() {
		// FileInputStream + ObjectInputStream (1byte짜리 통로)
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phones.txt"))){
			
			// toString() 메소드를 오버라이딩 했기 때문에 굳이 형변환안하고 바로 출력 가능 
			
			// System.out.println(ois.readObject( /* .toString() */ ));
			// System.out.println(ois.readObject());
			// System.out.println(ois.readObject());
			// System.out.println(ois.readObject());
			// 파일의 끝을 만났을때 EOFException이 발생됨
			// => End Of File 의 약자 , IOExceprion의 자식
			
			// EOFException이 발생될때 까지만 반복문 돌리기
			// => 예측 불가능한 오류이기 때문에 정확한 조건을 세울 수 없음
			while(true) { // 그래서 일단은 무한반복
				System.out.println(ois.readObject());
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}  catch (EOFException e) { // 무한반복되다가 언젠가 EOFException이 발생하는 순간 이쪽으로 돌아옴
		   System.out.println("파일을 다 읽었습니다.");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} 
	
		System.out.println("프로그램 종료");
	}
}
