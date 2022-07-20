package com.varxyz.jv300.mod010;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	NamingService namingService = NamingService.getInstance();
	DataSource ds = (DataSource) namingService.getAttribute("dataSource");
	
	public void addUser(User user) {
		String sql = "INSERT INTO UserTable (userId, passwd, userName, ssn, email, addr)" +
				" VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getPasswd());;
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getAddr());
				
				pstmt.executeUpdate();
			} finally {
				System.out.println("User INSERTED...");
				ds.close(pstmt, con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> findAllUsers() {
		String sql = "SELECT * FROM UserTable";
		List<User> userList = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
					userList.add(user);
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public User findUser(String userId) {
		String sql = "SELECT * FROM UserTable WHERE userId = ?";
		User user = new User();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, userId);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					user.setUserId(rs.getString("userId"));
					user.setPasswd(rs.getString("passwd"));
					user.setUserName(rs.getString("userName"));
					user.setSsn(rs.getString("ssn"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
				}
			}finally {
				ds.close(rs, pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void updateUserInfo(User user) {
		String sql = "UPDATE UserTable SET userId = ?, passwd = ?, userName = ?, ssn = ?, email = ?, addr = ? WHERE userId = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, user.getUserId());
				pstmt.setString(2, user.getPasswd());
				pstmt.setString(3, user.getUserName());
				pstmt.setString(4, user.getSsn());
				pstmt.setString(5, user.getEmail());
				pstmt.setString(6, user.getAddr());
				pstmt.setString(7, user.getUserId());
				pstmt.executeUpdate();
			}finally {
				ds.close(pstmt, con);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
