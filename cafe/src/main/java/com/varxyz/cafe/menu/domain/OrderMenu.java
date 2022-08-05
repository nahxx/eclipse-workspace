package com.varxyz.cafe.menu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderMenu {
	private long oid;
	private long totalAmount;
	private double totalPrice;
	private Date regDate;
	
	public OrderMenu() {
		
	}
}
