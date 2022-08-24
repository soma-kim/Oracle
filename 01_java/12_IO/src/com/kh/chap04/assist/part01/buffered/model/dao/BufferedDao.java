package com.kh.chap04.assist.part01.buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {
	// BufferedWriter (출력용) / BufferedReader (입력용)
	// 프로그램 ----> 외부매체 (파일)
	
	public void fileSave() {
		// FileWriter : 2byte 단위로 파일로 데이터를 내보내는 기반 스트림
		// +
		// BufferdWriter : 버퍼라는 공간을 제공해주는 보조 스트림 (속도 향상)
		// 기반 스트림이랑 보조스트림이랑 크기도 같이 맞춰줘야함 (2byte -> 2byte)
		
		// 0. 변수 선언 및 null 로 초기화
		// FileWriter fw = null;
		// BufferedWriter bw = null;
				
		// 코드 한줄로 줄여서 표현
		BufferedWriter bw = null;

		try {
			// 1. 기반스트림 객체 생성 (메인 연결 통로를 만들겠다)
			// fw = new FileWriter("c_buffer.txt");

			// 2. 보조스트림 객체 생성 (매개변수로 기반스트림 객체를 제시)
			// bw = new BufferedWriter(fw);
		
			// 코드 한줄로 줄여서 표현
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			
			
			// 3. 출력 : BufferedWriter 객체에서 제공하는 write() 메소드 사용
			// fw.writer(); => FileWriter 객체에서 제공하는 write() 메소드를 사용하면 성능 향상 기대할수 X
			bw.write ("안녕하세요.");
			bw.newLine(); // 개행을 넣어주는 메소드 
			bw.write("반갑습니다. \n");
			bw.write("저리 가세요.");
			

		// 4. 자원 반납(반드시) => finally 블럭 안에 작성
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			// 4. 자원 반납 (반드시)
			//    => 주의할 점 : 반납해야할 지원이 2개 (fw,bw)
			//    => 반납하는 순서 : 객체가 생성된 순서의 "역순"으로 반납
			try {
				bw.close();
			//	fw.close(); // 코드를 한줄로 줄이면 이 구문도 생략 가능!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 프로그램 <--- 외부 매체 (파일)
	public void fileRead() {
		// FileReader : 파일과 직접적으로 연결해서 한번에 2byte 단위로 데이터를 입력할 수 있는 기반 스트림
		// +
		// BufferedReader : 버퍼라는 공간을 제공해주는 보조 스트림 (속도 향상)
		
		/*
		// 0. 변수 선언 및 null 값으로 초기화
		BufferedReader br = null;
		
		// 1. 객체 생성 == 통로를 만들겠다.
		try {
			br = new BufferedReader(new FileReader("c_buffer.txt"));
			
		// 2. 입력 : BufferedReader 클래스에서 제공하는 메소드로 읽어들이기
			/*
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			*/
		/*	
			// 반복문 활용
			String value = null;
			while(br.readLine() != null) {
				System.out.println(br.readLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally { // 3. 자원 반납 == 연결 통로를 끊겠다.
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
//      try - with - resource 구문 (jdk7 버전 이상부터만 가능)
	      
//      [ 표현법 ]
//      try(반납해야하는 필요한 객체 생성 구문) {
//         		예외가 발생할 법한 구문;
//      } catch(예외클래스명 e){
//            	해당 예외 발생시 실행할 구문;
//      }
      
//      -> 스트림 객체 생성 구문을 try(여기)에 작성하게 되면
//         스트림 객체 생성 후 해당 try 블럭 내용이 실행된 후
//         알아서 자원 반납이 된다. . . 자원반납 안해도 됨
		 
		   try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){

				// 반복문 활용
				String value = null;
				while((value = br.readLine()) != null) {
					System.out.println(value);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} // close 굳이 할 필요 없다 알아서 반납 해준다
			
		}
	}

		


