package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.repository.CategoryDao;
import com.varxyz.cafe.menu.web.CategoryCommand;

@Service("service.categoryService")
public class CategoryService {
	
	@Autowired
	CategoryDao cateDao;
	
	public void addCategory(CategoryCommand command) {
		MenuCategory category = new MenuCategory();
		category.setCateType(command.getCateType());
		category.setCateName(command.getCateName());
		
		cateDao.addCategory(category);
	}
	
	public List<MenuCategory> getAllCategorys() {
		return cateDao.findAllCategorys();
	}
	
	public List<String> getCateNamesByCateType(String cateType) {
		return cateDao.findCateNamesByCateType(cateType);
	}
	
	public MenuCategory getCategoryByCid(long cid) {
		return cateDao.findCategoryByCid(cid);
	}
}
