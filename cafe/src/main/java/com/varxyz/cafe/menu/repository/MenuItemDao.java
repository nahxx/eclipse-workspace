package com.varxyz.cafe.menu.repository;

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
		String sql = "INSERT INTO MenuItem (name, price, imageUrl, cateId) "
				+ "VALUES (?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, menuItem.getName(), menuItem.getPrice(), 
				menuItem.getImageUrl(), menuItem.getCateId());
	}
	
	
}
