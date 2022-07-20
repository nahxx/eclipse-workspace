package com.varxyz.jv250.banking;

import java.sql.*;
import java.util.*;

public class CustomerDao {
	protected static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	protected static final String JDBC_USER = "jv250";
	protected static final String JDBC_PASSWORD = "jv250";
	
	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Loaded Driver ---> " + JDBC_DRIVER);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB에서 전체 고객 찾기
	 * @return List<Customer>
	 */
	public List<Customer> findAllCustomers() {
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//				con = Dao.getCon();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("customerID"));
					customerList.add(c);
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	/**
	 * DB에서 주민번호로 고객 찾기
	 * @param ssn
	 * @return Customer
	 * @throws InsufficientBalanceException
	 */
	public Customer findCustomerBySsn(String ssn) throws InsufficientBalanceException {
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
//				con = Dao.getCon();
				con =  DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				
				// ssn은 유니크키이므로 ssn을 가지는 고객이 있거나 없거나이므로 if문으로 조건 걸기
				if(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setCustomerId(rs.getString("customerID"));
				} else {
					throw new InsufficientBalanceException("해당 주민번호를 가진 고객이 존재하지 않습니다.");
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * DB에 고객 추가 메서드
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (name, ssn, phone, customerId, passwd) VALUES (?, ?, ?, ?, ?)";
		
		try {
//			Connection con = Dao.getCon();
			Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getCustomerId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			
			System.out.println("INSERTED.....");
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
