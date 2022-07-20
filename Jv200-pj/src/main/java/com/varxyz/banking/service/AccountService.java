package com.varxyz.banking.service;

import java.util.*;

import com.varxyz.banking.domain.*;

public interface AccountService {
	Account createSavingsAccount(String accountNum, double balance, double interestRate);
	Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);
	void addAccount(Account account);
	void addAccount(Account account, String ssn);
	List<Account> getAccountBySsn(String ssn);
	Account getAccountByAccountNum(String accountNum);
}
