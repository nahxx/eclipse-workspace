package com.varxyz.jv200.mod008;

/**
 * -. abstract 메소드의 집합, 상수(public)
 * -. 인스턴스 생성 불가
 * -. 다중 상속 지원
 * @author Administrator
 *
 */
public interface Flyer {
	public void fly(); // 인터페이스는 기본적으로 public, abstract이 생략되어 있으므로 키워드 작성하지 않아도 된다. 따라서 이코드의 접근제한자는 default가 아닌 public이다.
	public void takeOff();
	public void land();
}
