package com.varxyz.jvx330.lifecycle.example3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.varxyz.jvx330.lifecycle.AppConfig;

public class Horse implements InitializingBean, DisposableBean {
	private static int count;
	
	
	public Horse() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet 확인");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy 확인");
		
	}
	
	public static void main(String[] args) {
		GenericApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		context.getBean("horse", Horse.class);
		System.out.println("horse's final count : " + Horse.getCount());
		context.close();
	}

	
	/*
	 * 출력결과
	 	afterPropertiesSet 호출
		볼트
		initMethod 호출 : Eagle의 날개를 달아줍니다.
	    *** horse's final count : 3 ***
		// AppConfig에서 Horse의 Scope를 prototype으로 지정해주면 3개의 객체가 생긴다.
		destroyMethod 호출 : Eagle의 날개를 회수합니다.
		destroy 호출
	 */
	
	/*
	 * 처음 실행시키는 방법 ( 메인에서 입력안하고 자동으로 lifecycle이 돌아가게끔 )
	1. InitializingBean, DisposableBean 인터페이스를 이용해서 초기화하는 방법

    2. 빈생성 클래스에서 초기화하는방법
   
    3. 클래스내에서 처리하는 방법
       @PostConstruct 붙여서 초기화
       public void initMenuData() {}
    */
}
