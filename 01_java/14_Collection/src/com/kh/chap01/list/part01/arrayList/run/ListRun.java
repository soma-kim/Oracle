package com.kh.chap01.list.part01.arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01.list.part01.arrayList.model.vo.Music;

public class ListRun {
		/*
		 * <컬렉션 (Collection)>
		 * 자료 구조가 내장되어 있는 클래스로 자바에서 제공하는 "자료구조"를 담당하는 "프레임 워크"다.
		 * => 자료구조 : 방대한 데이터들을 효율적 (구조적)으로 다룰때 필요한 개념
		 * => 프레임 워크 : 효율적인 기능들이 이미 정의되어 있는 틀
		 * 
		 * 정리해보면,
		 * 데이터들이 새로이 추가되거나, 삭제가 되거나, 수정이 되는 기능 (알고리즘) 들이
		 * 이미 정의 되어 있는 틀이 있다. == 이게 컬렉션
		 * => 다량의 데이터들을 관리하고자 할 때 배열을 가지고 충분히 사용은 가능하나
		 * 	    그 배열의 단점들을 보완한 것이 "컬렉션"
		 * 
		 * <배열과 컬렉션의 차이점>
		 * - 배열의 단점
		 * 1. 배열을 쓰고자 할때 먼저 크기를 지정해야함
		 * 	  => 한번 지정된 크기는 변경이 불가능
		 * 		  새로운 값을 추가하고자 할 때 크기가 오버될 경우 새로운 크기의 배열을 새로 만들고,
		 *       기존의 내용물들을 복사해주는 코드(깊은 복사)를 직접 짜야함, 너무 불편
		 * 2. 배열 중간 위치에 새로운 데이터를 추가하거나 삭제하는 경우
		 * 	    삭제시 기존의 값들을 앞으로 땡겨주거나, 추가 시 뒤로 한칸 씩 밀어주는 코드를 직접 짜야 함.. 귀찮음
		 * 3. 한 타입의 데이터들만 저장 가능함
		 * 
		 * - 컬렉션의 장점
		 * 1. 크기의 제약이 없다
		 * 	  => 애초에 크기 지정을 해줄 필요가 X, 만약에 크기 지정을 하더라도 알아서 크기가 늘어나면서 새로운 데이터들이 추가됨
		 * 		  이미 메소드로 해당 기능들이 다 만들어져 있음! (생성, 호출만 잘하면 됨)
		 * 2. 중간에 값을 추가하거나 삭제하는 경우 값을 앞 또는 뒤로 땡겨주는 코드들이 이미 메소드에 다 정의 되어있음 
		 * 	  (잘 호출만 하면 됨)
		 * 3. 기본적으로 여러 타입의 데이터들을 저장할 수 있음
		 *    => 단 객체 형식으로만 저장 가능 (Wrapper 클래스 형태로 AutoBoxing해서 쓰면 됨)
		 *    => 또한 "제네릭" 설정을 통해 한 타입의 데이터들만 담는 것도 가능
		 *    
		 * 단지 방대한 데이터들을 담아만 두고 조회만 할 목적이면 => 배열만 써도 무방
		 * 방대한 데이터들이 빈번하게 추가, 삭제, 수정 될 것 같으면 => 컬렉션 사용이 더 이득
		 * 
		 * <컬렉션의 3가지 분류>
		 * - List 계열 : 담고자 하는 값(Value)만 저장 / 값 저장 시 순서 유지 (index 개념 있음) / 중복 값 허용
		 * 				예) ArrayList, Vector, LinkedList => ArrayList가 가장많이 쓰임
		 * - Set 계열 : 담고자 하는 값 (Value)만 저장 / 값 저장 시 순서 유지 X (index 개념 없음) / 중복 값 허용 X
		 * 			   예) HashSet, TreeSet
		 * - Map 계열 : 키(key) + 담고자 하는 값 (Value) 세트로 저장 / 값 저장 시 순서 유지 X (index 개념 없음) / Key의 중복값 허용 X, Value는 중복값 허용
		 * 			   예) HashMap, Properties
		 * 
		 * 
		 * 
		 */
	
		public static void main(String[] args) {
			// 기존의 배열을 쓸 경우 => 배열을 쓸 준비 (배열 선언 후 할당)
			// 컬렉션을 쓸 경우 => 컬렉션을 쓸 준비(컬렉션 객체 생성)
			
			// ArrayList 클래스의 객체 생성
			// ArrayList list = new ArrayList(); // 기본생성자로 생성할 경우 내부적으로 크기 10짜리인 배열이 만들어짐
			
			ArrayList list = new ArrayList(3); // 매개변수 생성자로 생성할 경우 내부적으로 크기 3짜리인 배열이 만들어짐
			// 크기는 지정하지않아도, 지정하더라도 상관은 없음
			
			System.out.println(list); // [] : list 안에 아무것도 없는 상태(비어있음)
			
			// 배열에 값을 담기
			
			// E ---> Element : 제네릭 (E == object)
			// 1. add(E e) : 해당 리스트의 끝에 전달된 e를 추가 시켜주는 메소드
			list.add(new Music("강남스타일", "싸이")); // add를 통해 담고싶은 값을 넣은거임
			// arr[0] = new Music();와 같은 꼴의 코드
			
			list.add(new Music("테스형!", "나훈아"));
			// arr[1] = new Music(); 와 같은 꼴
			
			list.add(new Music("밥이 달다..", "김가현"));
			// arr[2] = new Music(); 와 같은꼴
			
			list.add("끝");
			// String 객체도 문제없이 담길 수 있음
			// arr[3] = "끝";와 같은 꼴 => 배열에서는 불가능했던 일
			
			System.out.println(list);
			// 순서가 유지되면서 값 추가 (각 index에 들어있는 꼴)
			// 크기에 제약이 없음
			// 다양한 타입의 값을 추가 가능 
			
			
			// 2. add(int index, E e) : 리스트에 전달되는 index 자리에 전달되는 e를 추가시켜주는 메소드
			// 							해당 인덱스 다음값들을 알아서 뒤로 한칸씩 밀어주는 역할 또한 알아서 해줌
			list.add(1, new Music("토요일 좋아", "박불금"));
			
			System.out.println(list);
			
			
			// 3. set(int index, E e) : 리스트에 해당 index의 값을 전달되는 e로 변경시켜주는 메소드
			list.set(0, new Music("강북멋쟁이", "정형돈")); // arr[0] = new Music(새로운 음악);과 같은 꼴, 덮어쓰기한 꼴
			
			System.out.println(list);
			
			
			// 4. remove(int index) : 리스트에 해당 index 자리의 값을 삭제시켜주는 메소드 
			//						    삭제 후 기존의 값들을 앞으로 한칸씩 땡겨주는 역할도 같이 해줌 
			list.remove(1);
			
			System.out.println(list);
			
			
			// 5. size() : 리스트에 담겨있는 데이터의 수를 반환하는 메소드
			System.out.println("리스트에 담긴 데이터 수 : " + list.size());
			System.out.println("리스트의 마지막 인덱스 : " + (list.size() - 1)); // 리스트의 마지막 인덱스 값 구하기 
			
			
			// 6. get(int index) : E (== Object) => 리스트의 해당 인덱스 위치의 데이터를 반환
			// Object obj = list.get(0);
			// Music m = (Music)list.get(0); // 다형성에 의한 DownCasting
			// System.out.println(m);
			
			System.out.println(list.get(0)); // toString 오버라이딩을 이용하면 형변환이 필요가 없음. 동적바인딩땜에 바로 자식메소드 Music을 불러줌
			System.out.println(((Music)(list.get(0))).getTilte());
			System.out.println("==========================================");
			
			// 0번 ~ 마지막 인덱스까지의 데이터를 출력
			// for문
			for(int i = 0; i <list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			System.out.println("==========================================");
			
			// 향상된 for문 : for each문 => 배열뿐만 아니라 컬렉션에도 활용 가능함!
			// for(값을 받아줄변수선언문 : 배열명또는컬렉션명)
			for(Object o : list) {
				System.out.println(o);
			}
			
			System.out.println("==========================================");
			
			
			// 7. subList(int beginIndex, int endIndex) : 해당 리스트의 beginIndex 자리에서부터 endIndex -1자리까지 값을
			// 										  	    새로운 리스트로 부분적으로 뽑아서 반환 (List 타입 반환)
			List sub = list.subList(0, 2); // 0 <= 추출할 인덱스 범위 < 2
			// => List<object>
			System.out.println(sub);
			
			
			System.out.println("==========================================");
			
			
			// 8. addAll(Collection c) : 해당 리스트에 다른 컬렉션에 있는 데이터들을 통째로 추가시켜주는 메소드 (합체)
			list.addAll(sub);
			System.out.println(list);
			
			
			System.out.println("==========================================");
			
			
			// 9. isEmpty() : 해당 리스트가 비어있으면 (size() == 0) true,
			//							비어있지 않다면 (size() != 0) false를 반환해주는 메소드
			System.out.println("해당 리스트가 비어있습니까? : " + list.isEmpty());
			
			
			// 10. clear() : 해당 리스트를 싹 비워주는 메소드
			list.clear();
			System.out.println(list);
			System.out.println("해당 리스트가 비어있습니까? : " + list.isEmpty());
		}
	}


