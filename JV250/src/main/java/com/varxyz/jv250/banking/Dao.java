package com.varxyz.jv250.banking;

import java.sql.*;

public class Dao {
	protected static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	protected static final String JDBC_USER = "jv250";
	protected static final String JDBC_PASSWORD = "jv250";
	private static Dao dao = new Dao();
	
	public Dao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Loaded Driver ---> " + JDBC_DRIVER);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Dao getInstance() {
		return dao;
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(Dao.JDBC_URL, Dao.JDBC_USER, Dao.JDBC_PASSWORD);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
