package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.exception.InsufficientBalanceException;

public class CustomerDao {
	
	public CustomerDao() {

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
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					c.setUserId(rs.getString("userID"));
					customerList.add(c);
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
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
	public Customer findCustomerBySsn(String ssn){
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DataSourceManager.getConnection();
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
					c.setUserId(rs.getString("userID"));
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
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
		String sql = "INSERT INTO Customer (name, ssn, phone, userId, passwd) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection con =  DataSourceManager.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getSsn());
			pstmt.setString(3, customer.getPhone());
			pstmt.setString(4, customer.getUserId());
			pstmt.setString(5, customer.getPasswd());
			pstmt.executeUpdate();
			
			System.out.println("INSERTED.....");
			DataSourceManager.close(pstmt, con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
