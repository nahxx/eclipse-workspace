package com.varxyz.banking.mvc.service;

import java.util.List;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

public interface BankingService {

	void addCustomer(String userId, String passwd, String name, String ssn, String phone);
	
	Account addAccount(char accType, String userId, double initBalance);
	
	List<Account> getAccounts(String userId);
	
	void transfer(double amount, String withdrawNum, String depositNum) throws InsufficientBalanceException;
	
	boolean saveInterest(double interestRate, String AccountNum);
	
	double getBalance(String accountNum);
}
