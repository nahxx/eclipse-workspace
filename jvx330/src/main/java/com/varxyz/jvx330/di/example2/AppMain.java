package com.varxyz.jvx330.di.example2;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AppMain {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example2/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		Employee emp = context.getBean("employee", Employee.class);
		System.out.println(emp.getDetails());
		context.close();
		
		/*
		 출력결과
		 	Name: 유비
			Dept : 영업부
			Salary : 1000.0
			RegDate : 2022-7-21
		 */
	}
}
