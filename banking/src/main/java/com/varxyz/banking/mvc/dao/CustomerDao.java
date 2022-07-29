package com.varxyz.banking.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.varxyz.banking.mvc.domain.Customer;

@Repository("dao/customerDao")
public class CustomerDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (userId, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getUserId(), customer.getPasswd(), 
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public Customer findCustomerByUserId(String userId) {
		String sql = "SELECT cid, userId, passwd, name, ssn, phone, regDate"
				+ " From Customer WHERE userId=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer(rs.getLong("cid"), rs.getString("userId"), 
						rs.getString("passwd"), rs.getString("name"), 
						rs.getString("ssn"), rs.getString("phone"), 
						rs.getTimestamp("regDate"));
				
				return customer;
			}
			
		}, userId);
		
	}
	
	public boolean isValidCustomer(String userId, String passwd) {
		String sql = "SELECT * FROM Customer WHERE userId = ? and passwd = ?";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = null;
				if(rowNum > 0) {
					customer = new Customer();
					customer.setUserId(rs.getString("userId"));
					customer.setPasswd(rs.getString("passwd"));
				}
				return customer;
			}
		}, userId, passwd);
		
		if(list.size() == 0) {
			return false;
		}
		return true;
		
	}
	
	public boolean isValidUserId(String userId) {
		String sql = "SELECT * FROM Customer WHERE userId = ?";
		List<Customer> list = jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = null;
				if(rowNum > 0) {
					customer = new Customer();
					customer.setUserId(rs.getString("userId"));
				}
				return customer;
			}
		}, userId);
		
		if(list.size() == 0) {
			return false;
		}
		return true;
		
	}

}
