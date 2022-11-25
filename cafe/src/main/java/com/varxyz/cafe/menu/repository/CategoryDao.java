package com.varxyz.cafe.menu.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcTransactionManager;
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
		String sql = "INSERT INTO Category (cateType, cateName) VALUES (?, ?)";
		jdbcTemplate.update(sql, category.getCateType(), category.getCateName());
	}
	
	public List<MenuCategory> findAllCategorys() {
		String sql = "SELECT cid, cateType, cateName, regDate FROM Category";
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}
	
	public List<String> findCateNamesByCateType(String cateType) {
		String sql = "SELECT cateName FROM Category WHERE cateType=?";
		return jdbcTemplate.query(sql, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				String cateName = rs.getString("cateName");
				return cateName;
			}
			
		}, cateType);
	}
	
	public MenuCategory findCategoryByTypeAndName(String cateType, String cateName) {
		String sql = "SELECT cid, cateType, cateName, regDate FROM Category WHERE cateType=? AND cateName=?";
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), cateType, cateName);
	}
	
	public MenuCategory findCategoryByCid(long cid) {
		String sql = "SELECT cid, cateType, cateName, regDate FROM Category WHERE cid=?";
		return jdbcTemplate.queryForObject(sql, new CategoryRowMapper(), cid);
	}
	
	public List<MenuCategory> findAllCategoryTypes() {
		String sql = "SELECT cateType, cid FROM Category GROUP BY cateType";
		return jdbcTemplate.query(sql, new RowMapper<MenuCategory>() {

			@Override
			public MenuCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuCategory category = new MenuCategory();
				category.setCateType(rs.getString("cateType"));
				category.setCid(rs.getLong("cid"));
				
				return category;
			}
		});
	}
	
	public void removeCategoryByCid(long cid) {
		String sql = "DELETE FROM Category WHERE cid = ?";
		jdbcTemplate.update(sql, cid);
	}
	
	public List<MenuCategory> findAllCategorysNotDupl() {
		String sql = "SELECT DISTINCT cid, cateType, cateName, regDate FROM Category";
		return jdbcTemplate.query(sql, new CategoryRowMapper());
	}
}
