package com.kh.chap03.map.part01.hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03.map.part01.hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		// 컬렉션의 계층 구조를 봤을 때
		// List나 Set 계열은 Collection을 구현한 클래스들 
		// => add, get, . . . 메소드들이 유사한 형태
		
		// Map계열은 Collection을 구현할 클래스가 아님
		// => 메소드들이 조금씩 다를 예정!! 
		
		// 컬렉션을 이용할 준비 : 컬렉션 객체 생성
		HashMap<String, Snack> hm = new HashMap<>(); // 비어있는 상태
		
		// 1. put(K key, V value) : map 공간에 key + value 세트로 추가해주는 메소드
		hm.put("다이제", new Snack("초코맛", 1500));
		hm.put("칸초", new Snack("단맛", 600));
		hm.put("새우깡", new Snack("짠맛", 500));
		hm.put("포테이토칩", new Snack("짠맛", 500));
		
		System.out.println(hm); // {키 = 밸류, 키=밸류..}
								// 저장 순서 유지 X, value 값이 동일하다고 해도 key 값이 중복되지 않아 잘 저장됨
		
		hm.put("새우깡", new Snack("매운맛", 700));
		System.out.println(hm);
		// 중복된 key 값을 제시하면, 해당 기존의 value 값이 새로운 value 값으로 덮어 씌워짐
		
		// 2. get(Object key) : V => 컬렉션에서 해당 키값의 value 값을 돌려주는 메소드
		System.out.println(hm.get("다이제"));
		
		System.out.println(hm.get("빼빼로")); // 현재 존재하지 않는 key 값을 제시한 경우 null이 반환됨. 오타나도 마찬가지.
		
		// Object snack = hm.get("칸초");
		Snack snack = (Snack)hm.get("칸초"); // 제네릭 설정을 하지 않으면 매번 형변환 해야함!
		
		// 3. size() : 컬렉션의 값이 몇개 담겨있는지 갯수 새는 메소드
		System.out.println("size : " + hm.size());
		// 맵은 마지막 인덱스를 구할 수 가 없음 (인덱스가 없어서)
		
		// 4. replace(k key, V value) : 컬렉션에 해당 key 값을 찾아서 새로 전달된 value로 변경시켜주는 메소드
		hm.replace("포테이토칩", new Snack("겁나짠맛", 1000));
		System.out.println(hm);
		
		// 참고 : put 메소드랑 relace 메소드는 엄연히 다름
		// => put 메소드는 내가 매개변수로 제시한 키값이 이미 있으면 밸류값을 덮어씌워서 수정하지만
		//                               키 값이 없으면 밸류값을 추가해주는 역할 (추가의 역할이 메인)
		// => replace 메소드는 애초에 매개변수로 키 값 제시할 때 이미 있는 키값을 제시해서 할당 밸류 값을 바꿔치기 하는게 메인 역할
		
		// 5. remove(Object key) :  컬렉션에 해당 key 값을 찾아서 key + value 세트로 지워주는 메소드
		hm.remove("포테이토칩");
		System.out.println(hm);
		System.out.println("========================================");
		
		
		// 순차적으로 HashMap에 담겨있는거에 접근하고자 할 때?
		
		// 인덱스 개념이 없기 때문에 일반 for문 사용 불가
		// key + value가 세트로 담겨있는 구조이기 때문에 향상된 for문도 사용 불가
		/*
		for (xxx:hm) {
			
		}
		*/
		
		// List와 Map은 다른 계열이기 때문에 ArrayList로 옮겨담은 후 반복문 사용도 불가
		// ArrayList list = new ArrayList(hm);
		// list.addAll(hm);
		
		// Iterator => .iterator() 메소드를 이용하여 값을 Iterator로 옮기기
		// / .iterator() 메소드는 List나 Set 계열에서만 사용할 수 있는 메소드라 불가능
		// Iterator it = hm.iterator();
		
		// "Map을 Set으로 바꾸는 과정"을 우선적으로 진행하면 
		// => 우리가 아까 배웠던 Set 계열에 반복을 돌리는 3가지 방법 모두 활용 가능해짐
		
		// Map을 Set으로 바꿔주는 메소드 2가지 
		// HashMap => Set 계열 => Iterator
		
		// 1. .keySet() 메소드를 이용하는 방법
		// => Map에 들어있는 키값만 추려내서 Set으로 반환시켜주는 메소드
		
		// 1) hm에 있는 key들만 set에 담아주기
		Set<String> keySet = hm.keySet();
		
		// 2) 1번 과정에서 작업된 keySet을 Iterator에 담기
		Iterator<String> itKey = keySet.iterator();
		
		// 3) 반복자에 담긴 것들을 순차적으로 뽑기 (반복문 사용)
		while(itKey.hasNext()) { // hasnext
			 // System.out.println(itkey.next());
	         String key = /*(String)*/ itKey.next(); 
	         Snack value = /* (Snack) */ hm.get(key); 
	         System.out.println(key + " = " + value);
	      }
		
		System.out.println("========================================");
		
		
		// 2. entrySet() 메소드를 이용하는 방법
		// => Entry라는 집합 형태 꼴로 Key + Value 세트로 묶어서 Set에 담아줌
		
		// 1) hm에 있는 key + value 모두 Entry 형태로 Set에 담기 (Entry:집합형태)
		Set<Entry<String, Snack>> entrySet = hm.entrySet();
		
		// 2) entrySet에 있는 것들을 Iterator에 옮겨담기
		Iterator<Entry<String,Snack>> itEntry = entrySet.iterator();
		
		// 3) 반복문을 이용해서 순차적으로 뽑기
		while(itEntry.hasNext()) {
			// System.out.println(itEntry.next());
			Entry<String, Snack> entry = (Entry)itEntry.next();
			String key2 = /*(String)*/ entry.getKey();
			Snack value2 = /*(Snack)*/ entry.getValue();
			
			System.out.println(key2 + "=" + value2);
		}
	}

}
