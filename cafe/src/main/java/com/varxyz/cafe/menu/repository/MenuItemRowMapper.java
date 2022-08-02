package com.varxyz.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.cafe.menu.domain.MenuCategory;
import com.varxyz.cafe.menu.domain.MenuItem;

public class MenuItemRowMapper implements RowMapper<MenuItem>{
	
	@Override
	public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {

		MenuItem menuItem = new MenuItem(rs.getLong("mid"), new MenuCategory(rs.getLong("cid")), rs.getString("name"),
				rs.getDouble("price"), rs.getString("imageUrl"), rs.getTimestamp("regDate"));
		
		return menuItem;
	}

}
