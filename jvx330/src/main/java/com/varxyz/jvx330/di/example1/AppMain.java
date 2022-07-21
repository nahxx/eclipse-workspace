package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Foo foo = context.getBean("foo", Foo.class); // 싱글톤과 같은 개념
		System.out.println(foo);
		
		Foo foo2 = context.getBean("foo", Foo.class); // 해시코드가 위의 foo와 같음 => 즉, foo와 foo2는 같은 객체
		System.out.println(foo2);
		context.close();
		
		/*
		 출력값
		 Foo(bar) constructor is called
		 [Foo : 875313400]
		*/
		/*
		  과거 방식
		  Bar bar = new Bar();
		  Foo foo = new Foo(bar);
		 */
		
		/*
		 beans.xml에 foo2 추가 후 출력 결과
		 	Foo(bar) constructor is called
			Foo() constructor is called
			setBar() is called
			[Foo : 1420232606]
			[Foo : 1420232606]

		 */
	}
}
