package com.kh.chap03.char_.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
	// 프로그램 ---> 외부매체 (파일)
	// 출력
	
	public void fileSave() {
		
		// FileWriter : 파일로 데이터를 2byte 단위로 출력하는 스트림
		// 0. 변수 선언 및 null로 초기화 
		FileWriter fw = null;
		
		// 1. 스트림 객체 생성 == 연결통로를 만들겠다. (파일명 제시)
		try {
			fw = new FileWriter("b_char.txt");
			// 출력일 경우 없는 파일명을 제시하더라도 파일 생성 후 연결통로가 지어짐
			
			
			// 2. 출력 == 데이터 내보내기 : write() 메소드 사용
			fw.write("와! IO 재밌다..ㅎ"); // 내부적으로 문자 한개씩 끊어서 이동함
			fw.write('A');
			fw.write(97);
			fw.write("\n");
			
			char[] cArr = {'k', 'i', 'w', 'i'};
			fw.write(cArr);
			
			
			// 3. 연결 통로 끊기 == 자원 반납 (반드시) => finally 블록에 작성
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. 다쓴 자원 반납하기 (반드시)
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// 프로그램 <--- 외부매체(파일)
	// 입력
	public void fileRead() {
		// FileReader : 파일로부터 데이터를 2byte 단위로 입력받는 스트림
		// 0. 변수 선언 및 null로 초기화
		FileReader fr = null;
		
		try {
			// 1. 스트림 객체 생성 == 연결 통로를 만들겠다. (파일명 제시)
			fr = new FileReader("b_char.txt");
			// 입력통로이기 때문에 무조건 존재하는 경로로 제시해야함
			
			// 2. 입력받기 : read() 메소드 사용 
			// => 단, 한번에 2byte씩만 가져옴
			/*
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			*/
			// => 문자 기반 스트림도 마찬가지로 문서의 끝을 만났을때 read 메소드의 반환값이 -1임
			
			// 반복문을 활용
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.print((char)value);
			}
			
			
		// 3. 연결통로 끊기 == 자원 반납 (반드시) => finally 블럭에 작성
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// 3. 자원 반납 (반드시)
			try {
				fr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
