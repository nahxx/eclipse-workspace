package com.varxyz.jvx330.jdbc.example5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.*;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.varxyz.jvx330.jdbc.Account;

@Repository("AccountDao")
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
	
/*
	public void addAccunt(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VAlUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, account.getCustomerId());
				pstmt.setString(2, account.getAccountNum());
				pstmt.setString(3, account.getAccType());
				pstmt.setDouble(4, account.getBalance());
				pstmt.setDouble(5, account.getInterestRate());
				pstmt.setDouble(6, account.getOverAmount());
				return pstmt;
			}
		});
	}
	
	public void addAccunt2(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VAlUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, account.getCustomerId(), account.getAccountNum(), 
				account.getAccType(), account.getBalance(), account.getInterestRate(),
				account.getOverAmount());
	}
	
	public long addAccunt3(Account account) {
		String sql = "INSERT INTO Account (customerId, accountNum, accType, balance, interestRate, overAmount)"
				+ " VAlUES (?, ?, ?, ?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		PreparedStatementCreator creator = (connection) -> {
			PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"aid"});
			pstmt.setLong(1, account.getCustomerId());
			pstmt.setString(2, account.getAccountNum());
			pstmt.setString(3, account.getAccType());
			pstmt.setDouble(4, account.getBalance());
			pstmt.setDouble(5, account.getInterestRate());
			pstmt.setDouble(6, account.getOverAmount());
			return pstmt;
		};
		jdbcTemplate.update(creator, keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	public List<Account> findAllAccounts() {
		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, regDate FROM Account";
		
		return jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"),
						rs.getString("accountNum"), rs.getString("accType"), rs.getDouble("balance"),
						rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
				
				return account;
			}	
		});
	}
	
	public List<Account> findAccountByRegDate(Date regDate) {
		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, regDate"
				+ " FROM Account WHERE DATE(regDate)=?";
		return jdbcTemplate.query(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"),
						rs.getString("accountNum"), rs.getString("accType"), rs.getDouble("balance"),
						rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
				
				return account;
			}
			
		}, regDate);
	}
	
	public Account findAccountByAccountNum(String accountNum) {
		String sql = "SELECT aid, customerId, accountNum, accType, balance, interestRate, overAmount, regDate"
				+ " FROM Account WHERE accountNum=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account account = new Account(rs.getLong("aid"), rs.getLong("customerId"),
						rs.getString("accountNum"), rs.getString("accType"), rs.getDouble("balance"),
						rs.getDouble("interestRate"), rs.getDouble("overAmount"), rs.getTimestamp("regDate"));
				
				return account;
			}
			
		}, accountNum); 
	}
	
	public long countAccounts() {
		String sql = "SELECT count(*) FROM Account";
		return jdbcTemplate.queryForObject(sql, long.class);
	}
	
	// 위까지는 CustomerDao 참고해서 내가 만든 메소드
*/

	// 아래부터는 수업
	
	public void addAccount4(Account account) {
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
	
	public List<Account> findAccountsBySsn(String ssn) { // 시스템 외부에서 쓰는거(사용자 인터페이스)
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE c.ssn = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), ssn);
	}
	
	public List<Account> findAccountsByCustomerId(long customerId) { // 시스템 내부에서 쓰는거
		String sql = "SELECT a.aid, a.customerId, a.accountNum, a.accType, a.balance,"
				+ " a.interestRate, a.overAmount, a.regDate FROM Account a INNER JOIN Customer c"
				+ " ON a.customerId = c.cid"
				+ " WHERE a.customerId = ?";
		
		return jdbcTemplate.query(sql, new CustomerAccountRowMapper(), customerId);
	}
}
