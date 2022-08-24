package com.kh.chap01.file.run;

import java.io.File;
import java.io.IOException;

// 자바 코드로 간단하게 파일 만드는 과정 (java.io.File 클래스)
public class FileRun {

	public static void main(String[] args) {
//		헷갈리지 말 것 : File 객체를 만든다고해서 바로 파일이 컴퓨터에 만들어지지는 않음 ("test.txt")
		
		try {
//			1. 별도의 경로 지정을 하지않고 오로지 파일명만 제시해서 생성해보기
//				=> 현재 이 프로젝트 폴더 내에 파일 생성 (상대경로)
			File file1 = new File("test.txt"); // test.txt라는 파일을 만들겠다라고 파일명을 제시
			file1.createNewFile(); //createNewFile 메소드를 호출해서 실행되는 시점에 파일이 만들어짐
			
//			2. 경로 지정을 한 파일명을 제시해서 생성해보기 ("C:\aaa\test.txt")
//				=> 항상 존재하는 경로로 지정해야함 (절대 경로)
//				   C:/aaa라는 폴더가 이미 존재해야 하지만 test.txt파일이 생성 될 수 있다.
//						\n : 개행문자, \t : tab키, \ : 이스케이프 문자( 단독 사용 x)
//						\ 사용을 위해선 \\ 두번치면 \ 한번으로 간주
			File file2 = new File("C:\\aaa\\test.txt");
//			file2.createNewFile(); => createNewFile(); : file 생성 메소드
		
//			3. 폴더를 생성하고 나서 그 안에 파일을 생성해보기
			File bbbFolder = new File("C:\\bbb");
			bbbFolder.mkdir(); // mk => make, 폴더 생성 메소드
			
			File file3 = new File("C:\\bbb\\tset.txt");
			file3.createNewFile(); // file 생성 메소드
			
//			4. 별도의 경로 지정 없이 폴더 생성 후 파일을 생성해보기
//				=> 별도의 경로 지정 없이 폴더를 생성하더라도 현재 내가 작업중인 이 프로젝트 폴더 내부에 바로 생성됨
			File folder = new File("test");
			folder.mkdir();
			
			File file = new File("test\\Person.txt");
			file.createNewFile();
			
			/*
			 * - "명확한 시작점을 잡은 경로"를 제시했을때 : 절대 경로
			 * 	 c드라이브, d드라이브, .. => 루트 디렉토리(컴퓨터의 최상위 폴더)
			 * 
			 * - "명확한 시작점이 없는 경로"를 제시했을때 : 상대경로
			 *    현재 내가 작업중인 위치를 시작점으로 잡혀서 경로가 만들어짐
			 */

//		<file 클래스에서 제공하는 유용한 메소드들>
		System.out.println(folder.isFile()); // file인지 아닌지 판별해주는 메소드, 폴더이므로 flase 반환
		System.out.println(file.isFile());	// 파일이므로 true반환
			
		System.out.println("파일명 : " + file.getName()); // 파일명, 확장자명만 추출해주는 메소드
		System.out.println("상위폴더 : " + file.getParent()); // 부모폴더를 추출해주는 메소드
		System.out.println("파일 용량 : " + file.length()); // 파일의 용량을 추출해주는 메소드
		System.out.println("절대 경로 : " + file.getAbsolutePath()); // 절대 경로를 알려주는 메소드
		
//		<파일 삭제 메소드>
		file.delete();
		
		
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		System.out.println("프로그램 종료");
	}
	
	/*
	 * 프로그램 상의 데이터를 외부매체(모니터, 스피커, "파일"등)로 출력하거나
	 * 입력장치(키보드, 마우스 등)로 입력받는 과정을 진행하고자 한다면
	 * 반드시 프로그램과 외부매체와의 "연결통로"를 만들어야한다. => "스트림(강물이라는 뜻, 고지대에서 저지대로 한쪽방향으로만 흐름)"
	 * 
	 * <스트림의 특징>
	 * - 단방향 : 입력이면 입력, 출력이면 출력
	 * 			입력, 출력용 스트림이 각각 따로 따로 존재함
	 * 			즉, 동시에 입출력하고자 한다면 적어도 2개의 스트림이 필요 (하나의 스트림으로는 절대 안됨)
	 * - 선입선출 (FIFO, First In First Out) : 먼저 전달한 값이 먼저 나오게 됨
	 * 										 Queue라는 구조를 가지고 있음 !
	 * 										  참고) Stack이라는 구조  (LIFO, Last In Last Out)
	 * - 데이터 전송시 시간지연 문제(timeout, delay)가 발생할 수 있다.
	 * 
	 * 
	 * <스트림의 구분>
	 * - 통로의 사이즈
	 *		바이트 스트림 : 한번에 1byte 짜리만 이동할 수 있는 정도의 좁은 통로 => 입력 (xxxInputStream) / 출력 (xxxOutputStream)
	 *		문자 스트림 : 한번에 2byte 짜리가 이동할 수 있는 정도의 넓은 통로 => 입력(xxxReader) / 출력(xxxWriter)
	 *					(ex. fileReader : 파일로부터 읽겠다...)
	 * 
	 * - 외부매체와의 직접적인 연결 여부
	 * 		기반 스트림 : 외부매체와 직접적으로 연결되는 통로
	 * 		보조 스트림 : 기반스트림만으로 부족한 성능을 향상시켜주는 용도의 스트림 (외부매체와 직접적으로 연결 X), (필수는 아님 메인은 아니라서)
	 * 				   ex) 속도 향상, 자료형에 맞춰 형변환, 객체 단위로 입출력하게 도와준다거나, ....     
	 * 				      즉, 단독 사용 불가 (단독 객체 생성 불가)
	 * 				      단, 보조스트림은 단독으로 사용 불가, 반드시 기반스트림이 필수 !!
	 */
	
	
}
	
