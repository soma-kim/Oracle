package com.kh.chap01.list.prat02.mvc.controller;

import java.util.ArrayList;

import com.kh.chap01.list.prat02.mvc.model.vo.Music;

// Controller :  사용자의 요청을 받아서 기능적으로 처리해주는 부분
//				 View로부터 요청 시 전달값을 받아 처리 후 View로 처리 결과 반환
public class MusicController {
	
	// 음악을 보관할 수 있는 저장소를 전역변수로 빼두고 두고두고 사용할 목적
	ArrayList<Music> list = new ArrayList<>();
	{
		// 초기화 블록
		list.add(new Music("강남스타일", "싸이"));
		list.add(new Music("테스형!", "나훈아"));
	}
	
	
	// 새로운 곡 추가 요청시 실행될 메소드 
	public int insertMusic(String title, String artist) {
		
		int before = list.size(); // 추가되기 전 ArrayList의 크기를 알아냄
		list.add(new Music(title, artist));
		
		
		// 추가된 데이터의 갯수를 리턴 (성공여부)
		// 추가 된 후의 ArrayList의 크기 - 추가되기전 ArrayList의 크기
		
		return list.size() - before; // 0이라면 추가가 안된것
		
		
		
		
		
	}
	
	// 전체 곡 조회 요청 시 실행될 메소드
	public ArrayList<Music> selectMusicList () {
		return list;
	}
	
	public ArrayList<Music> searchMusic (String keyword) {
		
		// 검색 기능 : 해당 키워드가 포함된 것들은 모두 조회
		
		// 1. 검색된 결과물을 담을 변수를 셋팅 (검색 결과가 0개일수도, 1개일수도, 여러개 일수도 있음)
		ArrayList<Music> searched = new ArrayList<>();
		
		// 2. 반복문을 돌려가며 "포함"된 것이 있나 검사해야 함
		// => 포함된 내용물이라면 검색된 결과물을 담을 수 있는 변수에 담아두기
		for (int i = 0; i < list.size(); i++) {
				// 문자열의 일치 관계를 검사할 수 있는 메소드 : 문자열.equals(비교할 문자열) => true / false
				// 문자열의 포함관계를 검사할 수 있는 메소드 : 문자열.contains(검사할 문자열)
				//									=> 문자열 안에 검사할 문자열이 포함되어 있다면 true
				//	 												  	      포함되어있지 않다면 false
			if (list.get(i).getTilte().contains(keyword)) { // 포함되어있을 경우 
				searched.add(list.get(i));
			}
		}
		
		// 3. 검색된 결과를 View 단으로 리턴하기
		return searched;
	}
	
	// 특정 곡 삭제 요청 시 실행될 메소드
	public int deleteMusic(String title) {
		
		int result = 0; // 삭제가 진행된 갯수를 나타내는 변수 
		
		// 반복문을 통해 곡 제목이 일치하는지 검사
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTilte().equals(title)) { //곡 제목이 일치한다면
				
				list.remove(i--); // 앞으로 한칸씩 땡겨올 것에 대비하여 후위 연산 추가 
				result++;
			}
		}
		
		// result 리턴
		return result; // 0일수도있고 (삭제된게 없을경우), 양수값일수도 있음(삭제된게 있을경우)
		
	}
	
	
	// 특정 곡 수정 요청시 실행할 메소드
	public int updateMusic (String Title, String upTitle, String upArtist) {
		// 1. 수정된 곡 갯수를 받을 변수 셋팅
		int result = 0;
		
		
		// 2. 반복문을 통해 제목이 일치하는지 검사 후 일치한다면 곡 정보를 수정
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getTilte().equals(Title)) { // 제목이 일치한다면
					
				// 수정하는 방법 2가지
				// 1. 비교적 효율적인 방법
				// list.get(i).setTilte(upTitle);
				// list.get(i).setArtist(upArtist);
				
				// 2. 비교적 효율적인 방법은 아니지만 오늘 배운 내용을 활용할 수 있는 방법
				// => 메모리 영역에 할당이 한번 더 이루어지긴 함 
				list.set(i, new Music(upTitle, upArtist));
				
				result++;
				
				}
			}
		
			// 3. 수정된 곡 갯수를 받을 변수 리턴 (결과 반환)
			return result; // 0일수도 있고, 양수일 수도 있음
		
		}
		
		
		
	}

