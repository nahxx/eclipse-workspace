package com.varxyz.jvx330.di.example1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(foo);
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
	}
}
