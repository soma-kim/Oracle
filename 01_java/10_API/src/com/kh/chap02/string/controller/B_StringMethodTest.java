package com.kh.chap02.string.controller;

import java.util.Arrays;
import java.util.Scanner;

public class B_StringMethodTest {
	public void method() {
		String str1 = "Hell World";
		
//		메소드명(매개변수) : 반환형
//		1. 문자열.charAt(int index) : 반환값 char형
//		=> 문자열에서 전달받은 index 위치의 문자 하나만 뽑아서 리턴
		char ch = str1.charAt(3);
		System.out.println("ch : " + ch);
		
//		2. 문자열.concat(String str) : 반환값 String형
//		=> 문자열과 전달된 또 다른 문자열을 하나로 연이어서 리턴
		String str2 = str1.concat("!!!"); // String str2 = str1 + "!!!";
		System.out.println("str2 : "+ str2);
		
//		3. 문자열.length() : 반환값 int형
//		=> 문자열의 길이 반환
		System.out.println("str1의 길이 : " + str1.length());
		
//		4_1. 문자열.substring(int beginIndex) : 반환값 String형
//		=> 문자열의 beginIndex 위치에서부터 끝까지의 문자열을 추출해서 리턴
		System.out.println(str1.substring(6));
		
//		4_2. 문자열.substring(int beginIndex, int endIndex) : 반환값 String형
//		=> 문자열의 beginIndex 위치에서부터 endIndex -1 위치까지 추출해서 리턴
		System.out.println(str1.substring(0, 6));
		
//		5. 문자열.replace(char old, char new) : 반환값 String형
//		=> 문자열로부터 old 문자를 new 문자로 변환한 문자열을 리턴
		String str3 = str1.replace('l', 'c');
		System.out.println("str3 : " + str3);
		
		
//		6. 문자열.trim() : 반환값 String형
//		=> 문자열의 앞, 뒤 공백을 모두 제거한 문자열을 리턴
		String str4 = "      JA    VA     ";
		System.out.println("trim() : " + str4.trim());
		
		
//		참고) 중간에 있는 공백을 없애고 싶다면?
//		replace 메소드 활용
		System.out.println("replace를 활용해서 가운데 공백도 없애기 : " + str4.replace(" ", ""));
		
//		7_1. 문자열.toUpperCase() : 반환값 String형
//		=> 문자열을 모두 다 대문자로 변경 후 문자열 리턴
		System.out.println("upper : " + str1.toUpperCase());
		
//		7_2. 문자열.toLoerCase() : 반환값 String형
//		=> 문자열을 모두 다 소문자로 변경 후 문자열 리턴
		System.out.println("lower : " + str1.toLowerCase());
		
//		 활용 예시
		Scanner sc = new Scanner(System.in);
		System.out.println("종료하시겠습니까? (y/n) : ");
//		char answer = sc.nextLine().charAt(0); // Y, y, N, n
		char answer = sc.nextLine().toUpperCase().charAt(0); // Y, N
//		=> 메소드를 연이어서 호출(메소드체이닝)
		
		if(answer == 'Y') {
			System.out.println("프로그램을 종료합니다.");
		}
		else {
			System.out.println("프로그램을 종료하지 않습니다.");
		}
		
		
		// 문자열 -> char[]
//      char[] arr = new char[str1.length()];
//
//      for (int i = 0; i < arr.length; i++) {
//         arr[i] = str1.charAt(i);
//      }

//      8. 문자열.toCharArray() : 결과값 char[] 형
//      -> 문자열의 각 문자들을 char[] 배열로 옮겨 담은 후 그 배열을 리턴
      char[] arr = str1.toCharArray();
      System.out.println(Arrays.toString(arr));
      
      // char[] -> 문자열
      char[] arr2 = {'a','p','p','l','e'};
      
//      9. static valueOf(char[] data) : 반환값 String형
//      => 전달된 char[] 배열에 담긴 문자들을 하나의 문자열로 연이어서 리턴
      	System.out.println(String.copyValueOf(arr2));
   }
	
	//실습문제
	public void method2() {
		/* 욕설 필터링 프로그램
		 * 
		 * ex) 이런 신발끈같은 개나리 호루라기야!! 
		 * => 이런 ***같은 *** ****야 !!! 
		 */
		
		// 사용자에게 문장을 하나 입력받습니다.
		Scanner sc = new Scanner(System.in);
		System.out.print("문장을 입력하세요 : ");
		String str = sc.nextLine(); // sc.next는 공백전까지만 인식함
		
//		다음 제시되는 단어에 해당할 경우 *으로 대체해서 출력하도록 구현해보세요.
//		- 신**, 개**, 수**, 호루라기, 시베리아, 십장생, 조카, 쌍쌍바, 십자수, 식빵
		// 필터링용 배열
		String[] filter = {"신발끈", "개나리", "수박씨", "호루라기", "시베리아", "십장생", "조카", "쌍쌍바", "십자수", "식빵"};
		
		// 필터링 작업
		for(int i = 0; i < filter.length; i++) {
			// 각 인덱스에 들은 필터링할 문자열 기준으로 치환할 문자열 새로 생성
			int size = filter[i].length(); // 해당 글자의 글자수를 추출
			String star = "" + filter[i].charAt(0);
			for (int j = 0; j < size-1; j++) {
				star += "*";
			}
			// filter[i] 글자를 star로 대체 => replace 메소드
				str = str.replace(filter[i], star);
		}
				System.out.println(str);
			
		}
		
		
		
		
		
		
}
	
	
	
	

		
		