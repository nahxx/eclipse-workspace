package com.varxyz.cafe.menu.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.varxyz.cafe.menu.domain.Cart;
import com.varxyz.cafe.menu.domain.LineItem;
import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;
import com.varxyz.cafe.menu.service.CartService;
import com.varxyz.cafe.menu.service.CategoryService;
import com.varxyz.cafe.menu.service.MenuItemService;

@Controller("menu.web.OrderController")
public class OrderController {
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	MenuItemService menuService;
	
	@Autowired
	CartService cartService;
	
	String mid = ""; // 메뉴 선택시 메뉴 기본키 담을 변수
	String cid = ""; // 메뉴 선택시 카테고리 기본키 담을 변수
	
	/**
	 * order_service 페이지 접속
	 * @param category
	 * @param model
	 * @return
	 */
	@GetMapping("/order/order_service/{category}")
	public String orderService(@PathVariable("category") String category, Model model) {
		List<MenuCategory> cateList = cateService.getAllCategoryTypes();
		model.addAttribute("cateList", cateList);

		List<MenuItem> list = menuService.getMenuItemsByCid(Long.parseLong(category));
		model.addAttribute("list", list);
		model.addAttribute("size", list.size());
		model.addAttribute("cid", category);
		
		Cart cart = cartService.getCart();
		model.addAttribute("cart", cart);
		
		return "order/order_service";
	}
	
	/**
	 * 메뉴 선택
	 * @param request
	 * @return
	 */
	@PostMapping("/order/select_menu")
	public String selectMenuForm(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		mid = request.getParameter("mid"); // 메뉴 기본키
		cid = request.getParameter("cid"); // 카테고리 기본키
		
		MenuItem menuItem = menuService.getMenuItemByMid(Long.parseLong(mid));
		Cart cart = cartService.getCart();
		redirectAttributes.addFlashAttribute("cid", cid);
		redirectAttributes.addFlashAttribute("menuItem", menuItem);
		redirectAttributes.addFlashAttribute("cart", cart);
		return "redirect:order_service/" + cid;
	}
	
	/**
	 * 장바구니 담기
	 * @return
	 */
	@PostMapping("/order/add_cart")
	public String putInCart(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		MenuItem menuItem = menuService.getMenuItemByMid(Long.parseLong(mid));
		long amount = Long.valueOf(request.getParameter("amount"));
		String hotorice = request.getParameter("hotOrIce");
		LineItem lineItem = new LineItem(menuItem, amount, (menuItem.getPrice() * amount), hotorice);
		
		cartService.addLineItem(lineItem);
		
		Cart cart = cartService.getCart();
		redirectAttributes.addFlashAttribute("cart", cart);
		return "redirect:order_service/" + cid;
	}
	
	/**
	 * 장바구니 LineItem 삭제
	 * @param name
	 * @param hoi
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/order/remove_item/{name}/{hoi}")
	public String removeItem(@PathVariable("name") String name, @PathVariable("hoi") String hoi,
			RedirectAttributes redirectAttributes) {
		cartService.removeLineItem(name, hoi);
		
		Cart cart = cartService.getCart();
		redirectAttributes.addFlashAttribute("cart", cart);
		return "redirect:/order/order_service/" + cid;
	}
	
	@GetMapping("/order/count_amount/{name}/{hoi}/{mop}")
	public String countAmount(@PathVariable("name") String name, @PathVariable("hoi") String hoi,
			@PathVariable("mop") int mop, RedirectAttributes redirectAttributes) {
		cartService.countAmount(name, hoi, mop);
		
		Cart cart = cartService.getCart();
		redirectAttributes.addFlashAttribute("cart", cart);
		return "redirect:/order/order_service/" + cid;
	}
}
