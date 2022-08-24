package com.kh.third.run;

import com.kh.third.MyName; // 2. import 하기

public class Run {
	
	public static void main (String[] args) {
		
		// 1. MyName 이라는 클래스를 대변할 이름 만들기 (생성)
		MyName myName = new MyName();
		
		// 3. 대변할이름을 통해서 메소드 호출하기
		myName.callMyName();
	}
}
