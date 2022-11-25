package com.varxyz.cafe.menu.service;

import java.util.List;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.web.CategoryCommand;

public interface CategoryService {
	void addCategory(CategoryCommand command);
	List<MenuCategory> getAllCategorys();
	List<String> getCateNamesByCateType(String cateType);
	MenuCategory getCategoryByCid(long cid);
	List<MenuCategory> getAllCategoryTypes();
	void removeCategoryByCid(long cid);
	List<MenuCategory> getAllCategorysNotDupl();
}
