package com.varxyz.cafe.menu.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class Cart {
	private List<LineItem> cartList;
	private double totalPrice;
	
	private Cart() {
		cartList = new ArrayList<LineItem>();
	}
}
