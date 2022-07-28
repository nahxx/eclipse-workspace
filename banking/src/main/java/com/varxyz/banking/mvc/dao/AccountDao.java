package com.varxyz.banking.mvc.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import static java.sql.Types.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.CheckingAccount;
import com.varxyz.banking.mvc.domain.SavingsAccount;

@Repository("dao/accountDao")
/*
@Component("accountDao")로 해도 상관없지만 좀더 명확하게 하기 위해
@Repository로 했다.
=> @Repository는 예외를 세세하게 나눠놓았고, RuntimeException으로 처리되어 있어서 편하다.

dao는 @Repository
service는 @Service
*/
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void addAccount(Account account) {
		String sql = "INSERT INTO Account(accountNum, accType, balance, interestRate, overAmount, customerId) VALUES (?, ?, ?, ?, ?, ?)";
		SavingsAccount sa = null;
		CheckingAccount ca = null;
		Object[] args = null; // insert할 데이터를 넣겠다
		int[] types = new int[] {CHAR, CHAR, DOUBLE, DOUBLE, DOUBLE, BIGINT}; // 넣을 데이터의 타입 지정
		
		if(account instanceof SavingsAccount) {
			sa = (SavingsAccount)account;
			args = new Object[] {
					sa.getAccountNum(), String.valueOf(sa.getAccType()),
					sa.getBalance(), sa.getInterestRate(), 
					0.0, sa.getCustomer().getCid()
			};
			
		}else {
			ca = (CheckingAccount)account;
			args = new Object[] {
					ca.getAccountNum(), String.valueOf(ca.getAccType()),
					ca.getBalance(), 0.0,
					ca.getOverdraftAmount(), ca.getCustomer().getCid()
			};
		}
		jdbcTemplate.update(sql, args, types);
	}
	
	public void updateBalance(Account account) {
		String sql = "UPDATE Account SET balance = ? WHERE aid = ?";
		Object[] args = null;
		int[] types = new int[] {DOUBLE, BIGINT};
		
		args = new Object[] {account.getBalance(), account.getAid()};
		jdbcTemplate.update(sql, args, types);
	}
	
	public List<Account> findAccountsBySsn(String ssn) { // 시스템 외부에서 쓰는거(사용자 인터페이스)
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE c.ssn = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}
	
	public List<Account> findAccountsByUserId(String userId) { // 시스템 외부에서 쓰는거(사용자 인터페이스)
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE c.userId = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), userId);
	}
	
	public List<Account> findAccountsByCustomerId(long customerId) { // 시스템 내부에서 쓰는거
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE a.customerId = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE a.accountNum = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerAccountRowMapper(), accountNum);
	}
	
	public boolean isValidAccountByAccountNum(String accountNum) {
		String sql = "SELECT * FROM Account WHERE accountNum = ?";
		List<Account> list = jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = null;
				if(rowNum > 0) {
					account = new Account();
					account.setAccountNum(accountNum);
				}
				return account;
			}
			
		}, accountNum);
		
		if(list.size() == 0) {
			return false;
		}
		return true;
	}
}
