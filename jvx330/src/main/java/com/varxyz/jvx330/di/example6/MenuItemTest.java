package com.varxyz.jvx330.di.example6;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MenuItemTest {
	public static void main(String[] args) {
		String config = "com/varxyz/jvx330/di/example6/beans.xml";
		GenericApplicationContext context = new GenericXmlApplicationContext(config);
		MenuController controller = context.getBean("menuController", MenuController.class);
	
		controller.addMenuItem("아메리칸쿠키", 2500.0);
		controller.addMenuItem("스모어쿠키", 2500.0);		
		controller.getAllMenuItem();
		controller.findMenuItemByName("스모어쿠키");
		context.close();
	}
}
