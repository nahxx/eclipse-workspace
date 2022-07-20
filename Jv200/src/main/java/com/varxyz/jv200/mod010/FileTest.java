package com.varxyz.jv200.mod010;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR = "C://temp";
	
	public static void main(String[] args) {
		File saveDir = new File(SAVE_DIR);
		System.out.println(saveDir.getPath());  // C:\temp
		System.out.println("window : " + File.separator); // window : \
		// 경로를 쓸 때 \(역슬래시)를 사용한다.
		// getPath()메서드를 사용하면 슬래시가 역슬래시로 바뀜
		// File.separator 메서드 사용하면 현 운영체제의 구분자 출력 가능(윈도우는 역슬래시)
		// 역슬래시 사용할 때는 자바에서 이스케이프문자를 쓸때 사용되므로 역슬래시를 두번 사용한다.
	}
}
