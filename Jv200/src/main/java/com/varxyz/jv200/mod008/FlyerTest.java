package com.varxyz.jv200.mod008;

public class FlyerTest {

	public static void main(String[] args) {
		Flyer f1 = new Airplane();
		Flyer f2 = new Bird();
		f1.takeOff(); // 비행기 : 이륙하기
		f2.takeOff(); // 새 : 이륙하기
	}
	
}
