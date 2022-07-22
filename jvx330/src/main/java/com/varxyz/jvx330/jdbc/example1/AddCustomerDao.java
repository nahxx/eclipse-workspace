package com.varxyz.jvx330.jdbc.example1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.varxyz.jvx330.jdbc.Customer;
import com.varxyz.jvx330.jdbc.DataSourceConfig;

public class AddCustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	public AddCustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// autowire로 연결해도 되고 위코드를 입력해서 연결해도 됨.
	// 위코드처럼 하는 이유는 jdbcTemplate에 메타데이터가 있을 수 있기 때문.
	
	public void addCustomer(Customer customer) { // 방법1
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			// 익명 클래스(annonymous class) 
			// PreparedStatementCreator는 인터페이스.
			// implements되었다는 가정하에 인터페이스를 new로 부른다음
			// 메서드를 여기서 재정의하여 사용하겠다는 의미
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, customer.getEmail());
				pstmt.setString(2, customer.getPasswd());
				pstmt.setString(3, customer.getName());
				pstmt.setString(4, customer.getSsn());
				pstmt.setString(5, customer.getPhone());
				
				return pstmt;
			}
		});
	}
	
	public void addCustomer2(Customer customer) { // 방법2. 진짜 간단하네...
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, customer.getEmail(), customer.getPasswd(), 
				customer.getName(), customer.getSsn(), customer.getPhone());
	}
	
	public long addCustomer3(Customer customer) {
		String sql = "INSERT INTO Customer (email, passwd, name, ssn, phone)"
				+ " VALUES (?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"cid"});
			pstmt.setString(1, customer.getEmail());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setString(4, customer.getSsn());
			pstmt.setString(5, customer.getPhone());
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DataSourceConfig.class);
		
		AddCustomerDao dao = context.getBean("addCustomerDao", AddCustomerDao.class);
		Customer c = new Customer();
		c.setEmail("jangbi@java.com");
		c.setPasswd("2222");
		c.setName("장비");
		c.setSsn("820111-1234567");
		c.setPhone("010-6699-2285");
//		dao.addCustomer(c);
//		System.out.println("-inserted-");
		
		Customer c2 = new Customer();
		c2.setEmail("gwanwoo@java.com");
		c2.setPasswd("3333");
		c2.setName("관우");
		c2.setSsn("830111-1234567");
		c2.setPhone("010-7799-2285");
//		dao.addCustomer(c2);
//		System.out.println("-inserted-");
		context.close();
		
		long key = dao.addCustomer3(c);
		System.out.println("key " + key);
		System.out.println("INSERTED");
		
	}
}
