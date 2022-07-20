package com.varxyz.jv250.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample4 {
	public static void main(String[] args) {
		// DB 부르기(원격이든 로컬이든 상관X)
		// 초기 설정
		String driver = "com.mysql.cj.jdbc.Driver"; // 어떤 DB의 드라이버를 쓰느냐에 따라 이름이 달라짐(지금은 mysql의 드라이버 사용)
		String url = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul"; // 마찬가지로 DB에 따라 달라짐(인터넷 찾으면 나옴) 주소 다음 jv250은 접근할 db이름
		String id = "jv250";
		String passwd = "jv250";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// DB 연결 (checked Exception 이라서 try/catch 필요)
		// Customer 테이블 확인(DELETE)
		try {
			Class.forName(driver);
			System.out.println("LOADED DRIVER --->" + driver);
			con = DriverManager.getConnection(url, id, passwd); // static 메서드 사용하기 위해서는 driver먼저 올려야함
			System.out.println("CONNECTED TO ---> " + url);
			
			String sql = "DELETE FROM Customer WHERE cid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "1004");
			
			stmt.executeUpdate();
			
		} catch (Exception e) { // 지금처럼 아버지인 Exception e로 받아서 catch를 한번만 작성할 수도 있고, 자식 exception을 여러번 catch로 받을 수도 있음
			e.printStackTrace();
		} finally {
			// connection 관련된건 다 사용한 다음 close를 반드시 해줘야 한다.(위의 순서와 반대로 거꾸로 닫아줌) => 위에서 에러가 날 수도 있으므로 finally에서 닫아줘야 함
			try {
//				rs.close();
				System.out.println("DELETED...");
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
