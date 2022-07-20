package com.varxyz.jv200.mod009;

import java.util.*;

/*
 * collection
- 자바는 interface(객체 생성 불가)로 collection을 지정
- collection의 공통 부분을 추상메서드로 지정 (add(), remove(), get()…)
- 메서드 인자에 뭘 담을지 모르니 Object를 담도록 지정
- 자바는 이 collection을 크게 set과 list 두 그룹으로 나눔 ( map도 있음)

 * Set 계열 collection
- 우리말로 집합
- A = {1, 2, 3, 1} (X) ⇒ 중복 값 허용하지 않음
- A = {2, 3, 1} (O) ⇒ 순서는 상관없음
- (인터페이스는 객체를 생성하지 못하므로) set을 구현할 기본 객체가 필요 ⇒ HashSet
- 다형성으로 생성
- 객체가 달라도 add메서드가 가지는 hashcode의 값과 equals메서드의 return값이 같기 때문에 중복으로 판단(값자체가 중요)
 */
public class SetExample {

	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second"); // duplicate, not added(equals메서드랑 같은 원리)
		// 객체가 달라도 add메서드가 가지는 hashcode의 값과 equals메서드의 return값이 같기 때문에 중복으로 판단(값자체가 중요)
		set.add(new Integer(4)); // duplicate, not added
		System.out.println(set);
		
		/* 실행결과
		[5.0, 4, 3rd, one, second]
		*/
	}

}
