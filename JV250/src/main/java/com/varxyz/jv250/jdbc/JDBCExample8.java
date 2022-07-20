package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample8 {
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
		// Account 확인(DELETE)
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER --->" + driver);
			con = DriverManager.getConnection(url, id, passwd); // static 메서드 사용하기 위해서는 driver먼저 올려야함
			System.out.println("CONNECTED TO ---> " + url);
			
			String sql = "DELETE FROM Account WHERE aid = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "3004");
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				System.out.println("DELETED...");
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
