package com.varxyz.jvx330.di.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		/*
		 * xml을 사용하는 방식
		String config = "com/varxyz/jvx330/di/example3/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		MemberService ms = context.getBean("memberService", MemberService.class);
		
		System.out.println(ms.getAllMembers());
		
		Member m = context.getBean("member", Member.class);
		System.out.println(m.toString());
		context.close();
		*/
		
		// @Configuration 이용해서 class 호출해서 사용하는 방법
		GenericApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberService ms = context.getBean("memberService", MemberService.class);
		System.out.println(ms.getAllMembers());
		
		// 람다식
		ms.getAllMembers().forEach(member -> System.out.println(member));
		/*
		 * 위의 람다식 코드를 풀어쓰면 아래 코드
		 list<Member> list = ms.getAllMembers();
		 for(Member member : list) {
		 	System.out.pringln(member);
		 }
		 */
		
		/*
		 * 출력결과
		 	[Member[userId=java, name=유비], Member[userId=spring, name=관우]]
			Member[userId=java, name=유비]
			Member[userId=spring, name=관우]
		 */
	}
}
