package com.varxyz.cafe.menu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuCategory {
	private long cid;
	private String cateType; // 대분류 ex) 커피, 차, 에이드, 주스, 프라푸치노
	private String cateName; // 중분류 ex) 디카페인, 케이크, 빵...
	private Date regDate;
	
	public MenuCategory() {
		
	}
	
	public MenuCategory(long cid) {
		this.cid = cid;
	}
}
