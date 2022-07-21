package com.varxyz.jvx330.di.example7;

import java.util.List;

public interface MenuItemService {
	
	/**
	 * 신규 메뉴 아이템
	 * @param item
	 */
	void addMenuItem(MenuItem item);
	
	List<MenuItem> getAllMenuItemList();
	
	MenuItem getMenuItem(String name);
}
