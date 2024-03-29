package com.eteam.study.$11_dao_class.dao;

import java.sql.*;
import java.util.*;

import com.eteam.study.$11_dao_class.domain.Customer;
import com.eteam.study.$11_dao_class.exception.InsufficientBalanceException;

public class CustomerDao {
	private static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	private static final String JDBC_USER = "jv250";
	private static final String JDBC_PASSWD = "jv250";
	
	public CustomerDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("LOADED DRIVER ----->" + JDBC_DRIVER);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Customer> findAllCustomers(){	
		String sql = "SELECT * FROM Customer";
		List<Customer> customerList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Customer c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					c.setPhone(rs.getString("phone"));
					//c.setUserId(rs.getString('userID'));
					c.setPasswd(rs.getString("passwd"));
					customerList.add(c);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public Customer findCustomerBySsn(String ssn) throws InsufficientBalanceException {
		String sql = "SELECT * FROM Customer WHERE ssn = ?";
		Customer c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,ssn);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					//c.setUserId(rs.getString('userId'));
					c.setPhone(rs.getString("phone"));
				}
				else {
					throw new InsufficientBalanceException("에러"); //그냥 예외클래스 넣어놓음 
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public Customer findCustomerByCid(Long cid) throws InsufficientBalanceException {
		String sql = "SELECT * FROM Customer WHERE cid = ?";
		Customer c = null;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1,cid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					c = new Customer();
					c.setCid(rs.getLong("cid"));
					c.setName(rs.getString("name"));
					c.setSsn(rs.getString("ssn"));
					//c.setUserId(rs.getString('userId'));
					c.setPhone(rs.getString("phone"));
				}
				else {
					throw new InsufficientBalanceException("에러"); //그냥 예외클래스 넣어놓음 
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	/**
	 * 신규 고객 등록
	 * @param customer		등록할 고객정보
	 */
	
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO Customer(name, ssn, phone, userid, passwd) VAlUES (?, ?, ?, ?, ?)";

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,customer.getName());
				pstmt.setString(2,customer.getSsn());
				pstmt.setString(3,customer.getPhone());
				pstmt.setString(4,customer.getUserId());
				pstmt.setString(5,customer.getPasswd());
				pstmt.executeUpdate();
			}finally {
				pstmt.close();
				con.close();
				System.out.println("INSERTED....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
