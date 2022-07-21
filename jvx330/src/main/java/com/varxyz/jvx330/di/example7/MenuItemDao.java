package com.varxyz.jvx330.di.example7;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

@Component("menuItemDao")
// menuItemDao라는 이름을 가진 Bean이라는 의미
public class MenuItemDao {
	private static final List<MenuItem> MENU = new ArrayList<>();
	
	public void save(MenuItem item) {
		if(!MENU.contains(item)) {
			MENU.add(item);
		}
	}
	
	public List<MenuItem> findAllMenuItemList() {
		return MENU;
	}
	
	public MenuItem findByName(String name) {
		for(MenuItem item : MENU) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		throw new RuntimeException(name + " menu does not exist");
	}
}
