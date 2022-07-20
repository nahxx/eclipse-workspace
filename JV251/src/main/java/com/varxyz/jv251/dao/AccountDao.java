	
package com.varxyz.jv251.dao;

import java.sql.*;
import java.util.*;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.CheckingAccount;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.domain.SavingsAccount;

public class AccountDao {
	
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
				con =  DataSourceManager.getConnection();
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
//						sa.setUserId(rs.getLong("userId"));
						accountList.add(sa);
					} else if(rs.getString("accountType").charAt(0) == 'C') {
						CheckingAccount ca = new CheckingAccount();
						ca.setAid(rs.getLong("aid"));
						ca.setAccountNum(rs.getString("AccountNum"));
						ca.setBalance(rs.getDouble("balance"));
						ca.setOverdraftAmount(rs.getDouble("overdraft"));
						ca.setAccountType(rs.getString("accountType").charAt(0));
//						ca.setUserId(rs.getLong("userId"));
						accountList.add(ca);
					}
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
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
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ssn);
				rs = pstmt.executeQuery();
				Account account = null;
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else if(rs.getString("accountType").charAt(0) == 'C') {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("AccountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType(rs.getString("accountType").charAt(0));
					account.setCustomer(new Customer(rs.getString("name"),
							rs.getString("ssn"), rs.getString("phone")));
					accountList.add(account);
				}
			}finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	
	/**
	 * 해당 계좌번호를 가진 계좌 찾기
	 * @param accountNum
	 * @return
	 */
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		Account account = null;
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, accountNum);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					if(rs.getString("accountType").charAt(0) == 'S') {
						account = new SavingsAccount();
						((SavingsAccount) account).setInterestRate(rs.getDouble("interestRate"));
					} else if(rs.getString("accountType").charAt(0) == 'C') {
						account = new CheckingAccount();
						((CheckingAccount) account).setOverdraftAmount(rs.getDouble("overdraft"));
					}
					account.setAid(rs.getLong("aid"));
					account.setAccountNum(rs.getString("AccountNum"));
					account.setBalance(rs.getDouble("balance"));
					account.setAccountType(rs.getString("accountType").charAt(0));
				}
			} finally {
				DataSourceManager.close(rs, pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return account;
	}
	
	/**
	 * DB에 계좌 추가
	 * @param account
	 */
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account (accountNum, balance, interestRate, overdraft, accountType, customerId)" +
				" VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1, account.getAccountNum());
				pstmt.setDouble(2, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(3, sa.getInterestRate());
					pstmt.setDouble(4, 0.0);
					pstmt.setString(5, String.valueOf('S'));
				} else if (account instanceof CheckingAccount){
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(3, 0.0);
					pstmt.setDouble(4, ca.getOverdraftAmount());
					pstmt.setString(5, String.valueOf('C'));
				}
				pstmt.setLong(6, account.getCustomer().getCid());
				pstmt.executeUpdate();
			} finally {
				System.out.println("INSERTED.....");
				DataSourceManager.close(pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deposite(Account account) {
		String sql = "UPDATE Account SET balance = ?, overdraft = ? WHERE accountNum = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDouble(1, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(2, 0.0);
				} else if(account instanceof CheckingAccount) {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(2, ca.getOverdraftAmount());
				}
				pstmt.setString(3, account.getAccountNum());
				pstmt.executeUpdate();
			} finally {
				System.out.println("DEPOSITE RESULT UPDATE COMPLETED.....");
				
				DataSourceManager.close(pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DB에 출금 이후 정보 업데이트
	 * 
	 * @param account
	 */
	public void withdraw(Account account) {
		String sql = "UPDATE Account SET balance = ?, overdraft = ? WHERE accountNum = ?";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con =  DataSourceManager.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDouble(1, account.getBalance());
				if(account instanceof SavingsAccount) {
					SavingsAccount sa = (SavingsAccount) account;
					pstmt.setDouble(2, 0.0);
				} else if(account instanceof CheckingAccount) {
					CheckingAccount ca = (CheckingAccount) account;
					pstmt.setDouble(2, ca.getOverdraftAmount());
				}
				pstmt.setString(3, account.getAccountNum());
				pstmt.executeUpdate();
			} finally {
				System.out.println("WITHDRAW RESULT UPDATE COMPLETED.....");
				
				DataSourceManager.close(pstmt, con);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
