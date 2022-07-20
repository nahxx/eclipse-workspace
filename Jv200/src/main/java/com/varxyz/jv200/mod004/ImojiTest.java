package com.varxyz.jv200.mod004;

public class ImojiTest {

	public static void main(String[] args) {
		// 같은 패키지의 다른 클래스 메인에서 클래스 메서드 사용하기
		CreateImoji cr = new CreateImoji();
		System.out.println(cr.testImoji());
	}

}
