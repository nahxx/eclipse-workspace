package com.varxyz.cafe.menu.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.varxyz.cafe.menu.domain.OrderList;
import com.varxyz.cafe.menu.domain.OrderMenu;
import com.varxyz.cafe.menu.service.CartServiceImpl;
import com.varxyz.cafe.menu.service.CategoryService;
import com.varxyz.cafe.menu.service.MenuItemService;
import com.varxyz.cafe.menu.service.OrderService;

@Controller("menu.web.OrderController")
public class OrderController {
	
	@Autowired
	CategoryService cateService;
	
	@Autowired
	MenuItemService menuService;
	
	@Autowired
	CartServiceImpl cartService;
	
	@Autowired
	OrderService orderService;
	
	String mid = ""; // 메뉴 선택시 메뉴 기본키 담을 변수
	String cid = ""; // 메뉴 선택시 카테고리 기본키 담을 변수
	
	/**
	 * order_service 페이지 접속
	 * @param category
	 * @param model
	 * @return
	 */
	@GetMapping("/order/order_service/{category}")
	public String orderService(@PathVariable("category") String category, Model model, HttpServletRequest request) {
		cid = category;
		List<MenuCategory> cateList = cateService.getAllCategoryTypes();
		model.addAttribute("cateList", cateList);

		List<MenuItem> list = menuService.getMenuItemsByCid(Long.parseLong(category));
		model.addAttribute("list", list);
		model.addAttribute("size", list.size());
		model.addAttribute("cid", category);
		
		Cart cart = cartService.getCart();
		model.addAttribute("cart", cart);
		
		int totalAmount = cartService.totalAmount();
		model.addAttribute("totalAmount", totalAmount);
		
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
		int totalAmount = cartService.totalAmount();
		
		redirectAttributes.addFlashAttribute("cid", cid);
		redirectAttributes.addFlashAttribute("menuItem", menuItem);
		redirectAttributes.addFlashAttribute("cart", cart);
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
		return "redirect:order_service/" + cid;
	}
	
	/**
	 * 장바구니 담기
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/order/add_cart")
	public String putInCart(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {
		MenuItem menuItem = menuService.getMenuItemByMid(Long.parseLong(mid));
		long amount = Long.valueOf(request.getParameter("amount"));
		String hotorice = request.getParameter("hotOrIce");
		LineItem lineItem = new LineItem(menuItem, amount, (menuItem.getPrice() * amount), hotorice);
		
		if(amount < 1) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter writer = response.getWriter();
	        writer.println("<script>alert('수량을 선택해주세요.'); location.href='/cafe/order/order_service/" + cid + "';</script>"); // 경고창 띄우기
	        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
	        return "";
		}
		
		cartService.addLineItem(lineItem);
		
		Cart cart = cartService.getCart();
		int totalAmount = cartService.totalAmount();
		redirectAttributes.addFlashAttribute("cart", cart);
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
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
		int totalAmount = cartService.totalAmount();
		redirectAttributes.addFlashAttribute("cart", cart);
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
		return "redirect:/order/order_service/" + cid;
	}
	
	/**
	 * LineItem 수량 변경
	 * @param name
	 * @param hoi
	 * @param mop
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/order/count_amount/{name}/{hoi}/{mop}")
	public String countAmount(@PathVariable("name") String name, @PathVariable("hoi") String hoi,
			@PathVariable("mop") int mop, RedirectAttributes redirectAttributes) {
		cartService.countAmount(name, hoi, mop);
		
		Cart cart = cartService.getCart();
		int totalAmount = cartService.totalAmount();
		redirectAttributes.addFlashAttribute("cart", cart);
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
		return "redirect:/order/order_service/" + cid;
	}
	
	/**
	 * 장바구니 비우기
	 * @param category
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/order/all_remove/{category}")
	public String allOrdersRemove(@PathVariable("category") String category, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) throws IOException {
		cid = category;
		Cart cart = cartService.getCart();
		
		if(cart.getCartList().size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter writer = response.getWriter();
	        writer.println("<script>alert('현재 주문목록이 비어있습니다.'); location.href='/cafe/order/order_service/" + cid + "';</script>"); // 경고창 띄우기
	        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
	        return "";
		}

		cartService.removeALlLineItems();
		
		int totalAmount = cartService.totalAmount();
		redirectAttributes.addFlashAttribute("cart", cart);
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
		redirectAttributes.addFlashAttribute("cid", cid);
		return "redirect:/order/order_service/" + cid;
	}
	
	@GetMapping("/order/finally-order/{category}")
	public String finallyOrder(@PathVariable("category") String category, RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException {
		cid = category;
		Cart cart = cartService.getCart();
		
		
		if(cart.getCartList().size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter writer = response.getWriter();
	        writer.println("<script>alert('현재 주문목록이 비어있습니다.'); location.href='/cafe/order/order_service/" + cid + "';</script>"); // 경고창 띄우기
	        writer.close(); // close를 해주면 response.reDirect가 안되므로 alert에서 location.href 속성을 사용하여 페이지를 이동시켜준다.
	        return "";
		}
		
		List<LineItem> list = cart.getCartList();
		cart.addTotalPrice(list);
		
		OrderMenu orderMenu = new OrderMenu();
		orderMenu.setTotalAmount(cartService.totalAmount());
		orderMenu.setTotalPrice(cart.getTotalPrice());
		orderService.addOrderMenu(orderMenu);
		
		for(LineItem line : list) {
			OrderList orderList = new OrderList();
			orderList.setMenuName(line.getMenuItem().getName() + '(' + line.getHotOrIce() + ')');
			orderList.setAmount(line.getAmount());
			orderList.setPrice(line.getSumPrice());
			orderService.addOrderList(orderList);
		}
		
		long oid = orderService.getRecentlyOid();
		cartService.removeALlLineItems();
		int totalAmount = cartService.totalAmount();
		
		redirectAttributes.addFlashAttribute("cart", cartService.getCart());
		redirectAttributes.addFlashAttribute("totalAmount", totalAmount);
		redirectAttributes.addFlashAttribute("cid", cid);
		redirectAttributes.addFlashAttribute("oid", oid);
		
		return "redirect:/order/order_service/" + cid;
	}
}
