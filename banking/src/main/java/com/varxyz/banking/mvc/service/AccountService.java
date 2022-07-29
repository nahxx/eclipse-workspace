package com.varxyz.banking.mvc.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.CheckingAccount;
import com.varxyz.banking.mvc.domain.SavingsAccount;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

@Service("service/accountService")
public class AccountService {
	
	@Autowired
	AccountDao accountdao;
	
	// 오퍼레이션명 addAccount
	public void addAccount(Account account) {
		accountdao.addAccount(account);
	}
	
	public void updateBalance(Account account) {
		accountdao.updateBalance(account);
	}
	
	public List<Account> getAccountsBySsn(String ssn) {
		return accountdao.findAccountsBySsn(ssn);
	}
	
	public List<Account> getAccountsByUserId(String userId) {
		return accountdao.findAccountsByUserId(userId);
	}
	
	public List<Account> getAccountsByCustomerId(long customerId) {
		return accountdao.findAccountsByCustomerId(customerId);
	}
	
	public Account getAccountByAccountNum(String accountNum) {
		return accountdao.findAccountByAccountNum(accountNum);
	}
	
	public boolean isValidAccountByAccountNum(String accountNum) {
		return accountdao.isValidAccountByAccountNum(accountNum);
	}
	
	public void transferAmount(Account a1, Account a2, double amount) throws InsufficientBalanceException {
		if(a1.getAccType() == 'S') {
			SavingsAccount sa = (SavingsAccount)a1;
			sa.withdraw(amount);
			updateBalance(sa);
		} else {
			CheckingAccount ca = (CheckingAccount)a1;
			ca.withdraw(amount);
			updateBalance(ca);
		}
		
		if(a2.getAccType() == 'S') {
			SavingsAccount sa = (SavingsAccount)a2;
			sa.deposite(amount);
			updateBalance(sa);
		} else {
			CheckingAccount ca = (CheckingAccount)a2;
			ca.deposite(amount);
			updateBalance(ca);
		}
	}
	
	// 오퍼레이션명 saveInterest
	public void saveInterest(String AccountNum) {
		// 이자 지급 구현하는 곳
	}
	
}
