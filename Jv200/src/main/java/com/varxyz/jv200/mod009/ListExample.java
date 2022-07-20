package com.varxyz.jv200.mod009;

import java.util.*;
/*
 * Map 계열 collection

- key-value 값 저장
- key값 중복 불가
- 순서는 상관없음
- (인터페이스는 객체를 생성하지 못하므로) Map을 구현할 기본 객체가 필요 ⇒ HashMap
 */
public class ListExample {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>(); // key값과 value값의 타입을 <>(Generics)로 지정해준다
		map.put(new Integer(1), "유비"); // 9버전 이후로는 사용하지 않을 것을 권장하므로 취소선이 나타남
		map.put(Integer.valueOf(2), "관우"); // 이렇게 바꾸면 취소선이 생기지 않음
		map.put(3, "장비"); // 자바 5.0이후로 기본형을 넣어도 가능하게 바뀜 (Auto Boxing: 내부적으로 Integer객체를 만들어서 자동으로 값을 넣어줌)
		
		System.out.println(map.get(new Integer(1))); // map의 값을 받아올 때는 key값을 이용한다 // 결과 : 유비
		System.out.println(map.get(new Integer(2))); // 관우 (key값을 Integer.valueOf(2)로 지정했지만, new Integer(2)로 불러와도 가능)
		System.out.println(map.get(Integer.valueOf(2))); // 관우
		System.out.println(map.get(3)); // 장비
		
		// key값만 출력하기
		Set<Integer> set = map.keySet();
		for(Integer integer : set) {
			System.out.print(integer + " ");
			System.out.println(map.get(integer));
		}
		/*
		 	1 유비
			2 관우
			3 장비
		 */
	}

}
