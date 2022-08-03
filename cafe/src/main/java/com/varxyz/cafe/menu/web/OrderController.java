package com.varxyz.cafe.menu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.service.CategoryService;
import com.varxyz.cafe.menu.service.MenuItemService;

@Controller("menu.web.OrderController")
public class OrderController {
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	MenuItemService menuService;
	
	// order_service 페이지 접속
	@GetMapping("/order/order_service/{category}")
	public String orderService(@PathVariable("category") String category, Model model) {
		List<MenuCategory> cateList = cateService.getAllCategoryTypes();
		model.addAttribute("cateList", cateList);
		
		if(category.equals("1001")) {
			List<MenuItem> list = menuService.getMenuItemsByCid(Long.parseLong(category));
			model.addAttribute("list", list);
			model.addAttribute("size", list.size());
		} else {
			List<MenuItem> list = menuService.getMenuItemsByCid(Long.parseLong(category));
			model.addAttribute("list", list);
		}
		return "order/order_service";
	}
}
