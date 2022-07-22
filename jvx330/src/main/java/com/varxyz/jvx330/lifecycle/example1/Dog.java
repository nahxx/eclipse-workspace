package com.varxyz.jvx330.lifecycle.example1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Dog implements InitializingBean, DisposableBean{
	private String name;
	
	public Dog(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 여기에 적은 코드는 프라퍼티 적용(set)이 다 끝난다음 진행됨
		System.out.println("afterPropertiesSet 호출");
		if(name == null) {
			System.out.println("Property name must be set");
		} else {
			System.out.println(name);
		}
	}
	
	@Override
	public void destroy() throws Exception {
		// Bean이 사라질 때 코드 진행
		System.out.println("destroy 호출");
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Dog dog = context.getBean("dog", Dog.class);
		System.out.println("Dog's final name : " + dog.getName()); 
		// Dog's final name : 볼트
		context.close();
	}
	
	/*
	 출력 결과
	 	afterPropertiesSet 호출
		볼트
		Dog's final name : 볼트
		destroy 호출
	 */

}
