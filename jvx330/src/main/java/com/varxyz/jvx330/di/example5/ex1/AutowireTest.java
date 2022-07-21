package com.varxyz.jvx330.di.example5.ex1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowireTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example5/ex1/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		
		MemberController controller = context.getBean("memberController", MemberController.class);
		controller.processRequest();
		context.close();
		
		/*
		 * 출력결과
		 	빈 생성 : com.varxyz.jvx330.di.example5.ex1.MemberController@26d9b808
			빈 생성 : com.varxyz.jvx330.di.example5.ex1.MemberServiceImpl@1750fbeb
			New member inserted : java/1111
		 */
	}
}
