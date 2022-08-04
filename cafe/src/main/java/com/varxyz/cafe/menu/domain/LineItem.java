package com.varxyz.cafe.menu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LineItem {
	private MenuItem menuItem;
	private long amount;
	private double sumPrice;
	private String hotOrIce;
	
	public LineItem() {
		
	}
}
