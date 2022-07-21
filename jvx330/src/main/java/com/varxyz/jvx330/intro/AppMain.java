package com.varxyz.jvx330.intro;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/intro/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Hello hello = context.getBean("helloBean", Hello.class); /* HelloBeanKo를 Hello 타입으로 캐스팅해서 가져옴, 싱글톤 개념과 비슷 */
		System.out.println(hello.sayHello("Spring"));
		// HelloBeanEn인지 HelloBeanKo인지는 외부파일에서 변경하므로 여기서는 무엇인지 알수 없음
		context.close();
		
		
		
		Hello hello2 = new HelloBeanEn();
		System.out.println(hello2.sayHello("Spring"));
		
		/* 안녕하세요. Spring 으로 출력하려면 HelloBeanEn을 HelloBeanKo로 바꾸고
		다시 컴파일 하고 배포해야 함.
		=> 번거로움
		=> 1) 우리가 아는 기술로 바꿀 수 있음
		Class.forName();
			: ()안의 문자열 이름을 가진 클래스 반환함(이때 클래스이름은 풀로 가져옴)
			  즉, 클래스 풀네임을 외부파일에 저장해두고 위의 메소드로 가져와서 인스턴스 생성
		=> 2) 스프링 또한 외부 파일을 사용함
		
		*/
	}
}
