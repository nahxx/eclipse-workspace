package com.varxyz.cafe.menu.repository;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.cafe.menu.domain.MenuCategory;

@Repository("categoryDao")
public class CategoryDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CategoryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCategory(MenuCategory category) {
		String sql = "INSERT INTO Category (cateName, cateType) VALUES (?, ?)";
		jdbcTemplate.update(sql, category.getCateName(), category.getCateType());
	}
}
