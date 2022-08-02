package com.varxyz.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.cafe.menu.domain.MenuCategory;


public class CategoryRowMapper implements RowMapper<MenuCategory>{

	@Override
	public MenuCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuCategory category = new  MenuCategory(rs.getLong("cid"), rs.getString("cateType"),
				rs.getString("cateName"), rs.getTimestamp("regDate"));
		
		return category;
	}
	
}
