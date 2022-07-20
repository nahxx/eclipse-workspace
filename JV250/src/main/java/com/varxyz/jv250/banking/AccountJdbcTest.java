package com.varxyz.jv250.banking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountJdbcTest {
	public static void main(String[] args) {
		// DB 부르기(원격이든 로컬이든 상관X)
		// 초기 설정
		String driver = "com.mysql.cj.jdbc.Driver"; // 어떤 DB의 드라이버를 쓰느냐에 따라 이름이 달라짐(지금은 mysql의 드라이버 사용)
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // 마찬가지로 DB에 따라 달라짐(인터넷 찾으면 나옴) 주소 다음 jv250은 접근할 db이름
		String id = "jv250";
		String passwd = "jv250";
		
		// DB 연결
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER --->" + driver);
			
			Connection con = DriverManager.getConnection(url, id, passwd); // static 메서드 사용하기 위해서는 driver먼저 올려야함
			System.out.println("CONNECTED TO ---> " + url);
			
			select(con);
			insert(con);
			delete(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void select(Connection con) {
		String sql = "SELECT * FROM Account";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum"); // customerId 칼럼의 데이터를 String타입으로 받아서 customerId에 넣어주겠다는 의미(여기서부터 자바로 넘어감)
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				char accountType = rs.getString("accountType").charAt(0);
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println("---------------------");
			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert(Connection con) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "456-78-9123");
			pstmt.setDouble(2, 3000.0);
			pstmt.setDouble(3, 0.03);
			pstmt.setDouble(4, 0.0);
			pstmt.setString(5, String.valueOf('S'));
			pstmt.setLong(6, 1002);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("NEW ACCOUNT INSERTED...\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Connection con) {
		String sql = "DELETE FROM Account WHERE aid = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, 3006);
			
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("THIS ACCOUT DELETED..\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
