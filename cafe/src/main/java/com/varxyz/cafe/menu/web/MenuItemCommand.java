package com.varxyz.cafe.menu.web;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItemCommand {
	private CategoryCommand category;
	private String name;
	private Double price;
	private MultipartFile imageFile;
	
	public MenuItemCommand() {
		
	}
}
