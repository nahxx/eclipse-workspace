package com.varxyz.cafe.menu.service;

import com.varxyz.cafe.menu.domain.Cart;
import com.varxyz.cafe.menu.domain.LineItem;

public interface CartService {
	void addLineItem(LineItem lineItem);
	boolean isValidLineItem(String name, String hoi);
	LineItem getLineItem(String name, String hoi);
	void removeLineItem(String name, String hoi);
	void countAmount(String name, String hoi, int mop);
	int totalAmount();
	void removeALlLineItems();
}
