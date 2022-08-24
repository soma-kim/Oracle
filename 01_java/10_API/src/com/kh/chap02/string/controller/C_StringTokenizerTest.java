package com.kh.chap02.string.controller;

import java.util.StringTokenizer;

public class C_StringTokenizerTest {
	public void method() {
//		문자열을 분리시키는 방법
		String str = "Java,Oracle,JDBC,HTML,Server,Spring";
		
//		구분자를 제시해서 해당 문자열을 분리시키는 방법
//		방법1. 분리된 문자열들을 String[] 배열에 차곡차곡 담아서 관리하고자 할때
//			    문자열.split(String 구분자) : 반환값 String[]형
		String[] arr = str.split(",");
		/*
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
//		문자열 배열의 경우 for문을 이런식으로도 쓸 수 있다. (향상된 for문, foreach문)
//		for(값을 받아줄 수 있는 변수 선언문)
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("============================");
		
//		방법2. 분리된 각각의 문자열들을 "토큰"단위로 취급하고 싶을 때
//			  java.util.StringTokenizer 클래스를 이용하는 방법
//			  StringTokenizer stn = new StringTokennizer(분리시키고자 하는 문자열, 구분자);
			
		StringTokenizer stn = new StringTokenizer(str,",");
		System.out.println("분리된 문자열의 갯수 : " + stn.countTokens());
		/*
//		출력
		System.out.println(stn.nextToken()); // Java
		System.out.println(stn.nextToken()); // Oracle
		System.out.println(stn.nextToken()); // JDBC
		System.out.println(stn.nextToken()); // HTML
		System.out.println(stn.nextToken()); // Sever
		System.out.println(stn.nextToken()); // Spring
		
		System.out.println(stn.nextToken()); // NoSuchElementException : 더이상 찾을 요소가 없음
//		=> 현재 남아있는 stn 토큰 갯수의 범위를 벗어났을 때 발생하는 오류
		
		System.out.println("현재 담겨있는 문자열의 갯수 : " + stn.countTokens());
		*/
		
//		반복문 활용
		/*
		for(int i = 0; i <stn.countTokens(); i++) {
			System.out.println(stn.nextToken());
		}
	
		
		// i = 0, 갯수 6 => true => 출력 => i++
		// i = 1, 갯수 5 => true => 출력 => i++
		// i = 2, 갯수 4개 => true => 출력 => i++
		// i = 3, 갯수 3개 => false => 반복문 빠져나옴
		*/
		
//		해벼방법1. 변수 활용
		/*
		int count = stn.countTokens();
		for (int i = 0; i < count; i++) {
			System.out.println(stn.nextToken());
		}
		*/
		
//		해결방법2. while문 사용
//		stn.hasMoretokens() : stn 객체에 더이상 봅아낼 토큰이 있다면 true, 아니라면 false 반환
		while(stn.hasMoreTokens()) { //stn공간에 남아있는 토큰이 있을 동안만 반복을 수행하겠다.
			System.out.println(stn.nextToken());
		}
		
		
		
		
	}
}
