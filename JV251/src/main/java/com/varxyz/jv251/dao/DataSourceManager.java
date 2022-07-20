package com.varxyz.jv251.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceManager {
	// final 키워드가 붙으면 생성과 동시에 초기화를 해주어야 한다.
	// 최소한 생성자 안에서라도 초기화를 해야 한다.(객체 생성 전에 반드시 초기화 필요)
	// static 키워드가 붙으면 생성자에서 초기화를 해도 안된다. -> static initializer 사용하면 가능
	
	private static final String JDBC_URL;
	private static final String JDBC_USER;
	private static final String JDBC_PASSWD;
	
	/*
	이렇게 사용하는 이유 : 값을 외부 파일에 보관하고, 그 파일의 값을 불러오기 위해서
	이유 1) 보안을 위해서
	이유 2) 실리를 위해서(값이 바뀌는 경우 이렇게 안하면 컴파일을 새로 해야 하고 그런경우 서버가 다운될 수 있으며, 소스를 찾아 작성해야한다는 단점이 있다.)
	*/
	static {
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(props.getProperty("JDBC_DRIVER"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JDBC_URL = props.getProperty("JDBC_URL");
		JDBC_USER = props.getProperty("JDBC_USER");
		JDBC_PASSWD = props.getProperty("JDBC_PASSWD");
		
		System.out.println("JDBC_URL = " + JDBC_URL);
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null) {
			rs.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public static void close(PreparedStatement pstmt, Connection con) throws SQLException {
		close(null, pstmt, con);
	}

	
	public static void main(String[] args) {
		DataSourceManager manager = new DataSourceManager();
		
	}
}
