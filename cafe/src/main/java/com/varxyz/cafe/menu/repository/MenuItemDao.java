package com.varxyz.cafe.menu.repository;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.menu.domain.MenuItem;

@Repository("menuItemDao")
public class MenuItemDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MenuItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addMenuItem(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (name, price, cid, image) "
				+ "VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, menuItem.getName(), menuItem.getPrice(), 
				menuItem.getMenuCategory().getCid(), menuItem.getImageUrl());
		
		/*
		 * 이미지 포함 쿼리
		String sql = "INSERT INTO MenuItem (name, price, imageUrl, cid) "
				+ "VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, menuItem.getName(), menuItem.getPrice(), 
				menuItem.getImageUrl(), menuItem.getMenuCategory().getCid());
		*/
	}
	
	public List<MenuItem> findAllMenuItems() {
		String sql = "SELECT mid, name, price, imageUrl, cid, regDate FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
}
