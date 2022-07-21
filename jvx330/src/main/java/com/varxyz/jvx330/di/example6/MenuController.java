package com.varxyz.jvx330.di.example6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MenuController {
	
	@Autowired
	private MenuItemService service;
	
	public MenuController() {
		System.out.println("MenuController 생성");
	}
	
	public void addMenuItem(String name, double price) { // main에서 직접 값을 지정해주려고 만든 메소드
		service.addMenuItem(name, price);
	}
	
	public void getAllMenuItem() {
		for(MenuItem m : service.getAllMenuItems()) {
			System.out.println(m.getName());
		}
	}
	
	public void findMenuItemByName(String name) {
		if(service.getMenuItemByName(name) == "") {
			System.out.println("찾으시는 제품 \"" + name + "\" 이(가) 없습니다.");
		} else {
			System.out.println("찾으시는 제품 \"" + service.getMenuItemByName(name) + "\" 이(가) 메뉴에 있습니다.");
		}
	}
}
