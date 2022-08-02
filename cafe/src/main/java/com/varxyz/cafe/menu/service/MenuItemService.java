package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.repository.CategoryDao;
import com.varxyz.cafe.menu.repository.MenuItemDao;
import com.varxyz.cafe.menu.web.MenuItemCommand;

@Service("service.menuItemService")
public class MenuItemService {
	
	@Autowired
	CategoryDao cateDao;
	
	@Autowired
	MenuItemDao menuDao;
	
	@Autowired
	CategoryService cateService;
	
	public void addMenuItem(MenuItemCommand command) {
		String cateType = command.getCategory().getCateType();
		String cateName = command.getCategory().getCateName();
		MenuCategory cate = cateDao.findCategoryByTypeAndName(cateType, cateName);
		
		MenuItem menu = new MenuItem();
		menu.setMenuCategory(cate);
		menu.setName(command.getName());
		menu.setPrice(command.getPrice());
//		menu.setImageUrl(null);
		
		menuDao.addMenuItem(menu);
	}
	
	public List<MenuItem> getAllMenuItems() {
		List<MenuItem> list = menuDao.findAllMenuItems();
		for(MenuItem m : list) {
			MenuCategory cate = cateService.getCategoryByCid(m.getMenuCategory().getCid());
			m.setMenuCategory(cate);
		}
		return list;
	}
}
