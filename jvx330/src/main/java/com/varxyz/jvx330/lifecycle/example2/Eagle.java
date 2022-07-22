package com.varxyz.jvx330.lifecycle.example2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;
import com.varxyz.jvx330.lifecycle.example1.Dog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Eagle {
	private String name;
	
	public void attachWings() {
		System.out.println("initMethod 호출 : Eagle의 날개를 달아줍니다.");
	}
	
	public void detachWings() {
		System.out.println("destroyMethod 호출 : Eagle의 날개를 회수합니다.");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Eagle eagle = context.getBean("eagle", Eagle.class);
		System.out.println("Eagle's final name : " + eagle.getName()); 
		// Eagle's final name : 에디
		context.close();
	}
	/*
	 * 출력결과
	 	afterPropertiesSet 호출
		볼트
		initMethod 호출 : Eagle의 날개를 달아줍니다.
		Eagle's final name : 에디
		destroyMethod 호출 : Eagle의 날개를 회수합니다.
		destroy 호출
		
		// afterPropertiesSet 메소드가 먼저 호출된 다음 initMethod이 호출되고
		// destroyMethod가 먼저 호출된 다음 destroy 메소드가 호출됨
	 */
}
