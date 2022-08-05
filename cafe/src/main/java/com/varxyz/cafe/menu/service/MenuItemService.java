package com.varxyz.cafe.menu.service;

import java.io.IOException;
import java.util.List;

import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.web.MenuItemCommand;

public interface MenuItemService {
	void addMenuItem(MenuItemCommand command) throws IllegalStateException, IOException;
	List<MenuItem> getAllMenuItems();
	List<MenuItem> getMenuItemsByCid(long cid);
	MenuItem getMenuItemByMid(long mid);
}
