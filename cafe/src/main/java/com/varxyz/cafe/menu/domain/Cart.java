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
	
	public void addTotalPrice(List<LineItem> list) {
		double total = 0.0;
		for(LineItem l : list) {
			total += l.getSumPrice();
		}
		setTotalPrice(total);
	}
}

/*
// 선생님이 작성해주신 코드 => 수정해볼 것
public class Cart {
	private List<LineItem> cartList;
	private double totalPrice;
	
	private Cart() {
		cartList = new ArrayList<LineItem>();
	}
	
	public double calcTotalPrice(List<LineItem> list) {
		double total = 0.0;
		for(LineItem l : list) {
			total += l.getSumPrice();
		}
		 return total;
	}
	
	public double getTotalPrice() {
		if(totalPrice == 0){
			return calcTotalPrice(cartList);
		}
		return this.totalPrice;
	}
}
*/