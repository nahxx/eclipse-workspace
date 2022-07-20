package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample5 {
	public static void main(String[] args) {
		// DB 부르기(원격이든 로컬이든 상관X)
		// 초기 설정
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
		String id = "jv250";
		String passwd = "jv250";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// DB 연결 (checked Exception 이라서 try/catch 필요)
		// Account 확인(SELECT 전체)
		try {
			Class.forName(driver);
			System.out.println("Loaded Driver ---> " + driver);
			con = DriverManager.getConnection(url, id, passwd);
			System.out.println("Connected to ---> " + url);
			
			String sql = "SELECT * FROM Account";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long aid = rs.getLong("aid");
				String accountNum = rs.getString("accountNum"); // customerId 칼럼의 데이터를 String타입으로 받아서 customerId에 넣어주겠다는 의미(여기서부터 자바로 넘어감)
				double balance = rs.getDouble("balance");
				double interestRate = rs.getDouble("interestRate");
				double overdraft = rs.getDouble("overdraft");
				String accountType = rs.getString("accountType");
				long customerId = rs.getLong("customerId");
				System.out.println(aid);
				System.out.println(accountNum);
				System.out.println(balance);
				System.out.println(interestRate);
				System.out.println(overdraft);
				System.out.println(accountType);
				System.out.println(customerId);
				System.out.println("---------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
