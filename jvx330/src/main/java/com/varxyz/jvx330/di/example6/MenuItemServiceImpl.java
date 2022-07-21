package com.varxyz.jvx330.di.example6;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.varxyz.jvx330.di.example3.AppConfig;
import com.varxyz.jvx330.di.example3.MemberService;

public class MenuItemServiceImpl implements MenuItemService {
	List<MenuItem> menuList = new ArrayList<>();
	
	@Override
	public void addMenuItem(String name, double price) {
		MenuItem menu = new MenuItem();
		menu.setName(name);
		menu.setPrice(price);
		menuList.add(menu);
	}
	
	@Override
	public List<MenuItem> getAllMenuItems() {
		return menuList;
	}

	@Override
	public String getMenuItemByName(String name) {
		for(MenuItem m : menuList) {
			if(m.getName().equals(name)) {
				return m.getName();
			}
		}
		return "";
	}

}
