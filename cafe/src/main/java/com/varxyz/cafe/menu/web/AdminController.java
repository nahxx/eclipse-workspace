package com.varxyz.cafe.menu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.service.CategoryService;
import com.varxyz.cafe.menu.service.MenuItemService;

@Controller("menu.web.AdminController")
public class AdminController {
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	MenuItemService menuService;
	
	// 로그인 GetMapping 후 admin_service 페이지 접속
	
	// admin_service 페이지 접속
	@GetMapping("/admin/admin_service")
	public String adminService() {
		return "admin/admin_service";
	}
	
	// 카테고리 관리 페이지 접속
	@GetMapping("/admin/category_service")
	public String cateService() {
		return "admin/category_service";
	}
	
	// 카테고리 추가 페이지 접속
	@GetMapping("/admin/add_category")
	public String addCategoryForm(Model model) {
		model.addAttribute("category", new CategoryCommand());
		List<MenuCategory> list = cateService.getAllCategorys();
		model.addAttribute("list", list);
		return "admin/add_category";
	}
	
	// 카테고리 추가하기
	@PostMapping("/admin/add_category")
	public String addCategory(@ModelAttribute("category") CategoryCommand category, Model model, 
						HttpServletResponse response) throws IOException {
		cateService.addCategory(category);
		List<MenuCategory> list = cateService.getAllCategorys();
		model.addAttribute("list", list);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script>alert('카테고리가 추가되었습니다.'); location.href='add_category';</script>"); // 경고창 띄우기
        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
        return "";
	}
	
	// 카테고리 삭제 페이지 접속
	@GetMapping("/admin/remove_category")
	public String removeCategoryForm(Model model) {
		List<MenuCategory> list = cateService.getAllCategorys();
		model.addAttribute("list", list);
		
		return "admin/remove_category";
	}
	
	// 카테고리 및 카테고리의 메뉴 삭제
	@PostMapping("/admin/cateCheckDelete")
	public String removeCategory(RemoveCategoryCommand command, HttpServletRequest request) {
		List<Long> deleteList = command.getDeleteList();
		for(int i = 0; i < deleteList.size(); i++) {
			menuService.deleteMenuItemByCid(deleteList.get(i));
			cateService.removeCategoryByCid(deleteList.get(i));
		}
		
		return "redirect:/admin/remove_category";
	}
	
	// 메뉴 관리 페이지 접속
	@GetMapping("/admin/menu_service")
	public String menuService() {
		return "admin/menu_service";
	}
	
	// 메뉴 추가 페이지 접속
	@GetMapping("/admin/add_menu")
	public ModelAndView addMenuFrom() {
		List<MenuItem> menuList = menuService.getAllMenuItems();
		List<MenuCategory> cateList = cateService.getAllCategoryTypes();
		ModelAndView mav = new ModelAndView();
		mav.addObject("cateList", cateList);
		mav.addObject("list", menuList);
		mav.setViewName("admin/add_menu");
		
		return mav;
	}
	
	// 중분류 option 조회 (ajax 활용)
	@RequestMapping(value="/admin/getCateName")
	public String getCateName(@RequestBody String cateType, HttpServletRequest request) {
		List<String> cateNames = cateService.getCateNamesByCateType(cateType);
		request.setAttribute("cateNames", cateNames);
		
		return "/admin/cateNameAjax";
	}
	
	// 카테고리 대분류 셀렉트 박스
	@ModelAttribute("cateTypeProviderList")
	public List<String> getCateTypeProviderList() {
		List<MenuCategory> cateList = cateService.getAllCategorys();
		List<String> typeList = new ArrayList<String>();
		for(MenuCategory c : cateList) {
			typeList.add(c.getCateType());
		}
		return typeList;
	}
	
	// 카테고리 중분류 셀렉트 박스
	@ModelAttribute("cateNameProviderList")
	public List<String> getCateNameProviderList() {
		List<MenuCategory> cateList = cateService.getAllCategorys();
		List<String> nameList = new ArrayList<String>();
		for(MenuCategory c : cateList) {
			nameList.add(c.getCateName());
		}
		return nameList;
	}
	
	/*
	// 카테고리 소분류 셀렉트 박스(일단 킵)
	@ModelAttribute("cateNameProviderList")
	public List<String> getCateNameProviderList() {
		List<MenuCategory> cateList = cateService.getAllCategorys();
		List<String> typeList = new ArrayList<String>();
		for(MenuCategory c : cateList) {
			typeList.add(c.getCateType());
		}
		return typeList;
	}
	*/
	
	// 메뉴 추가하기
	@PostMapping("/admin/add_menu")
	public String addCategory(HttpServletRequest request, HttpServletResponse response, 
			@RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		
		
		CategoryCommand cate = new CategoryCommand();
		cate.setCateType(request.getParameter("cateType"));
		cate.setCateName(request.getParameter("cateName"));
		MenuItemCommand command = new MenuItemCommand(cate,
				(String)request.getParameter("name"), Double.parseDouble(request.getParameter("price")), imageFile);
		menuService.addMenuItem(command);
		
		List<MenuItem> list = menuService.getAllMenuItems();
		request.setAttribute("list", list);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script>alert('메뉴가 추가되었습니다.'); location.href='add_menu';</script>"); // 경고창 띄우기
        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
        return "admin/add_menu";
	}
	
	// 메뉴 삭제하기 페이지 접속
	@GetMapping("/admin/remove_menu")
	public String removeMenuForm(HttpServletRequest request) {
		List<MenuItem> list = menuService.getAllMenuItems();
		request.setAttribute("list", list);
		
		return "admin/remove_menu";
	}
	
	// 메뉴 삭제
	@PostMapping("/admin/menuCheckDelete")
	public String removeMenuItem(RemoveMenuCommand command, HttpServletRequest request) {
		List<Long> deleteList = command.getDeleteList();
		for(int i = 0; i < deleteList.size(); i++) {
			menuService.deleteMenuItemByMid(deleteList.get(i));
		}
		
		return "redirect:/admin/remove_menu";
	}
	
	// 메뉴 수정하기 페이지 접속
	@GetMapping("/admin/modify_menu")
	public String modifyMenuForm(HttpServletRequest request) {
		List<MenuItem> list = menuService.getAllMenuItems();
		request.setAttribute("list", list);
		
		return "admin/modify_menu";
	}
	
	// modify-box 전달
	Long mid;
	@RequestMapping(value="/admin/getModifyBox")
	public String getModifyBox(HttpServletRequest request) {
		mid = Long.valueOf(request.getParameter("mid"));
		MenuItem menu = menuService.getMenuItemByMid(mid);
		MenuCategory cate = cateService.getCategoryByCid(menu.getMenuCategory().getCid());
		menu.setMenuCategory(cate);
		List<MenuCategory> cateList = cateService.getAllCategoryTypes();
		request.setAttribute("menu", menu);
		request.setAttribute("cateList", cateList);
		
		return "/admin/modifyBoxAjax";
	}
	
	// 메뉴 수정
	@PostMapping("/admin/modify_menu")
	public String modifyMenu(HttpServletRequest request, HttpServletResponse response, @RequestParam("imageFile") MultipartFile imageFile) throws IOException {
		CategoryCommand cate = new CategoryCommand();
		cate.setCateType(request.getParameter("cateType"));
		cate.setCateName(request.getParameter("cateName"));
		
		MenuItemCommand command = new MenuItemCommand();
		if(imageFile != null) {
			command = new MenuItemCommand(cate,
					(String)request.getParameter("name"), Double.parseDouble(request.getParameter("price")), imageFile);
		} else {
			command = new MenuItemCommand(cate,
					(String)request.getParameter("name"), Double.parseDouble(request.getParameter("price")), null);
		}
		
		menuService.modifyMenuItem(command, mid);
		
		List<MenuItem> list = menuService.getAllMenuItems();
		request.setAttribute("list", list);
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<script>alert('메뉴가 수정되었습니다.'); location.href='modify_menu';</script>"); // 경고창 띄우기
        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
        return "admin/modify_menu";
	}
}
