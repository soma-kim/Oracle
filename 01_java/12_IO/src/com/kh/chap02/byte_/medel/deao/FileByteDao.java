package com.kh.chap02.byte_.medel.deao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (data Access Object)
// 데이터가 보관되어 있는 공간과 직접 접근해서 데이터를 입출력하는 용도의 클래스
public class FileByteDao {
//	프로그램 ---> 외부매체 (파일)
//	출력 : 프로그램 내의 데이터를 파일로 내보내기 (즉, 파일에 기록하겠다, 파일로 저장하겠다.)
	
	public void fileSave() {
		// FileOutputStream : "파일"로 데이터를 1byte 단위로 출력하는 스트림
		// 0단계. FileOutputStream fout 변수 선언 및 null로 초기화
		FileOutputStream fout = null; // 변수 선언 및 null로 초기화

		try {
			// 1. FileOutputStream 객체 생성 (== 연결통로 만들기)
			//	  => 해당 파일과 직접 연결되는 통로를 만들겠다. (파일명을 매개변수로 생성자 호출)
			// 	          해당 파일이 존재하지 않는다면 해당 파일이 생성되면서 연결통로가 지어짐
			// 			           존재하는 파일이면 연결 통로만 바로 지어짐
			
			fout = new FileOutputStream("a_byte.txt" /* , false */); // false가 기본값
			// => 기존에 해당 파일이 있을 경우 덮어 씌워짐
			
			// fout = new FileOutputStream("a_byte.txt", true);
			// => 이어쓰고 싶을 경우에는? 매개변수로 true를 같이 넘겨주면 됨
			
			// 2. 연결 통로로 데이터를 출력 : write() 메소드 사용
			// 	  => 1byte 범위만 전송 가능 : -128 ~ 127까지의 숫자, 음수는 불가 ! 
			// 	     (단, 파일에 기록되기를 해당 숫자의 고유한 문자가 기록됨 : 아스키코드)
		
			fout.write(97); // 'a'가 기록
			fout.write('b'); // 'b'가 기록
			// fout.write('김'); // => 한글은 무조건 2byte이기 때문에 깨져서 저장됨
							    // (바이트 스트림으로는 제한적)
			
			byte[] bArr = {99, 100, 101};
			fout.write(bArr); // 'c','d','e'가 기록 
			
			fout.write(bArr, 1, 2); // 'd', 'e'가 기록
			
			
			// 3. 스트림을 다 이용 했으면 자원을 반납하기 (반드시)
			//    => 즉, 연결 통로를 끊겠다.
			// fout.close(); => 위에서 혹시 예외가 발생했을 경우 실행이 안될수도 있음! => finally 블록으로 
			

		} catch(FileNotFoundException e) { // 존재하지 않는 경로를 제시했을 때
			e.printStackTrace();
			
		} catch (IOException e) { // 입출력 상황에서 어느 오류든지 발생했을 때
			e.printStackTrace();
		} finally { // 어떤 예외가 발생하던지 간에, 예외가 발생안하던지간에 반드시 실행할 구문을 작성하는 블럭
			// 3. 스트림을 다 이용했으면 자원 반납하기 (반드시)
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 프로그램 <-- 외부매체(파일)
	// 입력 : 파일로부터 데이터를 가지고 오겠다. (즉, 읽어들이겠다.)
	public void fileRead() {
		// FileInputStream : 파일로부터 데이터를 1byte 단위로 입력받는 스트림
		
		// 0. 변수 선언 후 null로 초기화 (지역변수 때문에 트라이 밖으로)
		FileInputStream fin = null;

		
		try {
			// 1. 스트림 객체 생성하기 == 연결통로 만들기 
			fin = new FileInputStream("a_byte.txt"); 
			// => 파일 경로 제시, 입력 받을 때에는 반드시 존재하는 파일명으로 제시 !
		
			// 2. 읽어들이기 == 입력받기 : read() 메소드 사용
			// => 단, 1byte 단위로 하나씩 읽어옴
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			// 파일 끝을 만나는 순간 fin.read() => -1 반환
			System.out.println(fin.read());
			System.out.println(fin.read());
			*/
			
			// 반복문 활용하기
			// 퐁당퐁당 출력됨
			/*
			while (fin.read() != -1) {
				System.out.println(fin.read());
			}
			*/
			
			// 해결방법1. 무한반복으로 매번 조건검사 하기
			/*
			while(true) {
				
				int value = fin. read();
				
				if (value == -1) {
					break;
				}
				System.out.println(fin.read());
			}
			*/
			
			// 해결방법2. 조건식 내부에 변수 대입구문을 활용하는 방법(권장)
			int value = 0;
			while((value = fin.read()) != -1) {
				System.out.println(value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally { // 3. 연결통로 끊기 == 자원 반납하기 (무조건) => finally 블럭에 작성
			
			// 3. 다 쓴 스트림 객체 반납
			try {
				fin.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
