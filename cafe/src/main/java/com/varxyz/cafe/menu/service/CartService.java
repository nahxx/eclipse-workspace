package com.varxyz.cafe.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.cafe.menu.domain.Cart;
import com.varxyz.cafe.menu.domain.LineItem;

@Service
public class CartService {
	
	@Autowired
	Cart cart;
	
	/**
	 * LineItem 추가
	 * @param lineItem
	 */
	public void addLineItem(LineItem lineItem) {
		List<LineItem> list = cart.getCartList();
		
		if(!isValidLineItem(lineItem.getMenuItem().getName(), lineItem.getHotOrIce())) {
			list.add(lineItem);
		} else {
			for(LineItem line : list) {
				if(lineItem.getMenuItem().getName().equals(line.getMenuItem().getName())
						&& lineItem.getHotOrIce().equals(line.getHotOrIce())) {
					line.setAmount(line.getAmount() + lineItem.getAmount());
					line.setSumPrice(line.getSumPrice() + lineItem.getSumPrice());
				}
			}
		}
		
		double total = 0.0;
		for(LineItem l : list) {
			total += l.getSumPrice();
		}
		cart.setTotalPrice(total);
	}
	
	/**
	 * 카트 가져오기
	 * @return
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * LineItem 존재여부 확인
	 * @param name
	 * @param hoi
	 * @return
	 */
	public boolean isValidLineItem(String name, String hoi) {
		List<LineItem> list = cart.getCartList();
		
		for(LineItem line : list) {
			if(line.getMenuItem().getName().equals(name) &&
					line.getHotOrIce().equals(hoi)) {
				return true;
			}
		}
		return false;
	}
	
	public LineItem getLineItem(String name, String hoi) {
		List<LineItem> list = cart.getCartList();
				
		for(LineItem line : list) {
			if(line.getMenuItem().getName().equals(name) &&
					line.getHotOrIce().equals(hoi)) {
				return line;
			}
		}
		return null;
	}
	
	/**
	 * LineItem 삭제
	 * @param lineItem
	 */
	public void removeLineItem(String name, String hoi) {
		List<LineItem> list = cart.getCartList();
		if(isValidLineItem(name, hoi)) {
			LineItem lineItem = getLineItem(name, hoi);
			list.remove(lineItem);
		}
	}
	
	public void countAmount(String name, String hoi, int mop) {
		List<LineItem> list = cart.getCartList();
		for(LineItem line : list) {
			if(line.getMenuItem().getName().equals(name) &&
					line.getHotOrIce().equals(hoi)) {
				double onePrice = line.getSumPrice() / line.getAmount();
				if(mop == 0) { // 마이너스
					line.setAmount(line.getAmount() - 1);
					line.setSumPrice(line.getSumPrice() - onePrice);
				} else { // 플러스
					line.setAmount(line.getAmount() + 1);
					line.setSumPrice(line.getSumPrice() + onePrice);
				}
			}
		}
	}
}
