package com.varxyz.jvx330.jdbc.example4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.jvx330.jdbc.Customer;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public CustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Customer> findAllCustomers() {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate FROM Customer";
		return jdbcTemplate.query(sql, new CustomerRowMapper());
	}
	
	public List<Customer> findCustomerByRegDate(Date regDate) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate"
				+ " From Customer WHERE DATE(regDate)=?";
		return jdbcTemplate.query(sql, new CustomerRowMapper(), regDate); // 첫번째 매개변수 : sql, 두번째 매개변수 : 익명 클래스, 세번째 매개변수 : regDate
	}
	
	public Customer findCustomerByEmail(String email) {
		String sql = "SELECT cid, email, passwd, name, ssn, phone, regDate"
				+ " From Customer WHERE email=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Customer>(Customer.class), email); // 결과가 하나만 나오는 건 queryForObject 사용
	} // BeanPropertyRowMapper를 사용하면 example3에서처럼 따로 CustomerRowMapper 같은 class를 만들지 않아도 됨
	
	public long countCustomers() {
		String sql = "SELECT count(*) FROM Customer";
		return jdbcTemplate.queryForObject(sql, long.class);
	}
	
}
