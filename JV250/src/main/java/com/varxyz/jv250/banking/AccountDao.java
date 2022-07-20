package com.varxyz.jv250.banking;

import java.sql.*;
import java.util.*;

public class AccountDao {
	protected static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	protected static final String JDBC_URL = "jdbc:mysql://localhost:3306/jv250?serverTimezone=Asia/Seoul";
	protected static final String JDBC_USER = "jv250";
	protected static final String JDBC_PASSWORD = "jv250";
	
	public AccountDao() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Loaded Driver ---> " + JDBC_DRIVER);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB에서 전체 계좌 정보 조회
	 * @return
	 */
	public List<Account> findAllAccounts() {
		String sql = "SELECT * FROM Account";
		List<Account> accountList = new ArrayList<Account>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//				con = Dao.getCon();
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						SavingsAccount sa = new SavingsAccount();
						sa.setAid(rs.getLong("aid"));
						sa.setAccountNum(rs.getString("AccountNum"));
						sa.setBalance(rs.getDouble("balance"));
						sa.setInterestRate(rs.getDouble("interestRate"));
						sa.setAccountType(rs.getString("accountType").charAt(0));
						sa.setCustomerId(rs.getLong("customerId"));
						accountList.add(sa);
					} else if(rs.getString("accountType").charAt(0) == 'C') {
						ChackingAccount ca = new ChackingAccount();
						ca.setAid(rs.getLong("aid"));
						ca.setAccountNum(rs.getString("AccountNum"));
						ca.setBalance(rs.getDouble("balance"));
						ca.setOverdraftAmount(rs.getDouble("overdraft"));
						ca.setAccountType(rs.getString("accountType").charAt(0));
						ca.setCustomerId(rs.getLong("customerId"));
						accountList.add(ca);
					}
				}
			} finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	/**
	 * DB에서 주민번호 통해서 계좌정보 찾기
	 * inner join 쿼리 사용
	 * @param ssn
	 * @return
	 */
	public List<Account> findAccountsBySsn(String ssn) {
		String sql = "SELECT a.aid, a.accountNum, a.balance, a.interestRate, "
				+ "a.overdraft, a.accountType, c.name, c.ssn, c.phone, a.regDate"
				+ " FROM Account a INNER JOIN Customer c ON a.customerId = c.cid"
				+ " WHERE c.ssn = ?";
		List<Account> accountList = new ArrayList<Account>();
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//				con = Dao.getCon();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else if(rs.getString("accountType").charAt(0) == 'C') {
						account = new ChackingAccount();
						((ChackingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("AccountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setCustomer(new Customer(rs.getString("name"),
							rs.getString("ssn"), rs.getString("phone")));
					accountList.add(account);
				}
			}finally {
				rs.close();
				pstmt.close();
				con.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	/**
	 * DB에서 계좌 찾기
	 * @param account
	 */
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId)" +
				" VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//				con = Dao.getCon();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
				} else if (account instanceof ChackingAccount){
					ChackingAccount ca = (ChackingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				System.out.println("INSERTED.....");
				pstmt.close();
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
