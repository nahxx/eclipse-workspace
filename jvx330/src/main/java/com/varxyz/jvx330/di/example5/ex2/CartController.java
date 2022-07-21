package com.varxyz.jvx330.di.example5.ex2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartController {
	
	@Autowired
	// CartService에 대해서 자동으로 wired하라는 의미의 어노테이션
	@Qualifier("sessionCartService")
	// CartService가 두가지가 있으니 그 중 sessionCartService을 사용하겠다는 의미
	private CartService service;
	
	@Autowired
	@Qualifier("cookieCartService")
	private CartService service2;
	// 두가지를 같이 적용해서 사용할 수도 있음
	
	public CartController() {
		System.out.println("CartController 생성");
	}
	
	public void processRequest() {
		service.addItem();
		service2.addItem();
	}
}
