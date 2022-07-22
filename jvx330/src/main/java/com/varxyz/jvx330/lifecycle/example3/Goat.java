package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Goat {
	private static int count;
	// 고트 빈을 여러개 만듦
	// 이때 저 count는 1이어야 함
	
	public Goat() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		context.getBean("goat", Goat.class);
		System.out.println("Goat's final count : " + Goat.getCount());
		context.close();
	}
	
	/*
	 * 출력결과
	 	afterPropertiesSet 호출
		볼트
		initMethod 호출 : Eagle의 날개를 달아줍니다.
		Goat's final count : 1 // 여러번 getBean했는데도 1이 출력됨 => 싱글톤
		destroyMethod 호출 : Eagle의 날개를 회수합니다.
		destroy 호출
	 */
}
