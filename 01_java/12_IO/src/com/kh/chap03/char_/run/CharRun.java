package com.kh.chap03.char_.run;

import com.kh.chap03.char_.model.dao.FileCharDao;

public class CharRun {
		/*
		 * * 문자 기반 스트림
		 * 문자 스트림 : 한번에 2byte 짜리의 데이터가 이동할 수 있는 넓은 통로 (XXXReader / XXXwriter)
		 * 기반 스트림 : 외부매체와 직접적으로 연결되는 main 통로
		 * 
		 * => 외부 매체를 지정하고 그 외부매체와 직접적으로 연결되는 2byte 짜리 넓은 통로를 만들겠다.
		 * 
		 */
	
	public static void main(String[] args) {
		
		FileCharDao fc = new FileCharDao();
//		fc.fileSave();
		
		fc.fileRead();
	}

}
