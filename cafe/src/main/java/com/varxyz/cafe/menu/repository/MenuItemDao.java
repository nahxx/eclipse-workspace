package com.varxyz.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		String sql = "INSERT INTO MenuItem (name, price, cid, imageUrl) "
				+ "VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, menuItem.getName(), menuItem.getPrice(), 
				menuItem.getMenuCategory().getCid(), menuItem.getImageUrl());
	}
	
	public List<MenuItem> findAllMenuItems() {
		String sql = "SELECT mid, name, price, imageUrl, cid, regDate FROM MenuItem";
		return jdbcTemplate.query(sql, new MenuItemRowMapper());
	}
	
	public List<MenuItem> findMenuItemsByCid(long cid) {
		String sql = "SELECT mid, name, price, imageUrl, cid, regDate FROM MenuItem WHERE cid = ?";
		return jdbcTemplate.query(sql, new MenuItemRowMapper(), cid);
	}
	
	public MenuItem findMenuItemByMid(long mid) {
		String sql = "SELECT mid, name, price, imageUrl, cid, regDate FROM MenuItem WHERE mid = ?";
		return jdbcTemplate.queryForObject(sql, new MenuItemRowMapper(), mid);
	}
	
}
