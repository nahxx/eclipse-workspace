package com.varxyz.cafe.menu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderList {
	private long olid;
	private OrderMenu orderMenu;
	private String menuName;
	private long amount;
	private double price;
	private Date regDate;
	
	public OrderList() {
		
	}
}
