package com.varxyz.cafe.menu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItem {
	private long mid; // 기본키
	private MenuCategory menuCategory; // 카테고리
	private String name; // 메뉴 이름
	private Double price; // 메뉴 가격
	private String imageUrl; // 메뉴이미지 경로
	private Date regDate;
	
	public MenuItem() {
		
	}
}
