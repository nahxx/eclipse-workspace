package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample7 {
	public static void main(String[] args) {
		// DB 부르기(원격이든 로컬이든 상관X)
		// 초기 설정
		String driver = "com.mysql.cj.jdbc.Driver"; // 어떤 DB의 드라이버를 쓰느냐에 따라 이름이 달라짐(지금은 mysql의 드라이버 사용)
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // 마찬가지로 DB에 따라 달라짐(인터넷 찾으면 나옴) 주소 다음 jv250은 접근할 db이름
		String id = "jv250";
		String passwd = "jv250";
		Connection con = null;
		PreparedStatement stmt = null;
		
		// DB 연결 (checked Exception 이라서 try/catch 필요)
		// Account 확인(INSERT)
		try {
			try {
				Class.forName(driver);
				System.out.println("LOADED DRIVER --->" + driver);
				con = DriverManager.getConnection(url, id, passwd); // static 메서드 사용하기 위해서는 driver먼저 올려야함
				System.out.println("CONNECTED TO ---> " + url);
				
				String sql = "INSERT INTO Account (accountNum, balance, interestRate, accountType, customerId)" +
						"VALUES (?, ?, ?, ?, ?)";
				stmt = con.prepareStatement(sql);
				stmt.setString(1, "444-44-4444");
				stmt.setDouble(2, 4000);
				stmt.setDouble(3, 0.04);	
				stmt.setString(4, "S");	
				stmt.setLong(5, 1002);		
				stmt.executeUpdate();
			} finally {
				System.out.println("INSERTED...");
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
