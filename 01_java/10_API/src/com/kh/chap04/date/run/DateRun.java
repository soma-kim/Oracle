package com.kh.chap04.date.run;

import java.text.SimpleDateFormat;
import java.util.Date;

// 날짜 관련 클래스들
public class DateRun {
	public static void main(String[] args) {
		// java.util.Date 클래스
		// : 날짜와 시간에 대한 정보를 담을 수 있는 클래스
		//   자바 개발 초창기에 만들어진 클래스
		
		// 기본 생성자를 통해 Data 객체 생성
		Date today = new Date(); // 현재 날짜 및 시간을 가지고옴
		System.out.println("기본생성자 : " + today);
		
		// 내가 원하는 날짜 (2020년 6월 19일)
		// 1. 매개변수 생성자를 이용하는 방법
		// Date date2 = new Date(2020, 6 , 19); // deprecated : 권장하지는 않음
		// 년도 + 1900, 월 + 1
		Date date2 = new Date(2020 -1900, 6 -1, 19);
		System.out.println("매개변수 생성자 : " + date2);
		//2. 기본생성자로 생성 후 Setter메소드를 이용하는 방법
	      Date date3 = new Date(); //현재 시간 및 날짜
	      
	      date3.setYear(2021-1900);
	      date3.setMonth(7-1);
	      date3.setDate(30);
	      date3.setHours(15);
	      date3.setMinutes(42);
	      date3.setSeconds(18);
	      
	      System.out.println("Setter메소드 : " + date3);
	      
	      System.out.println("----------------------------------------------------");
	      
	      //java.text.SimpleDateFormat 클래스
	      // : 사용자가 원하는대로 날짜 형식을 지정한 문자열을 제공하는 클래스
	      
	      //사용방법
	      //1. 형식을 지정하면서 SimpleDateFormat 객체를 생성 => 매개변수 생성자
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
	      
	      /*
	       * * SimpleDateFormat 형식
	       * -년도 :yyyy
	       * - 월 : MM
	       * - 일 : ㅇㅇ
	       * - 시 : hh
	       * - 분 : mm
	       * - 초 : ss
	       */
	      
	      //2. SimpleDateFormat(sdf)객체에서 제공하는 format() 메소드 호출 시 Date 객체 전달(매개변수로)
	      // => sdf포맷이 지정된 날짜가 String타입으로 반환된다.
	      // 객체명.format(Date객체) : 반환값 String형
	      String formatDate = sdf.format(today);
	      System.out.println(formatDate);
	   }

	}