package com.eteam.study.$08_interface.service;

import java.util.ArrayList;
import java.util.List;

import com.eteam.study.$08_interface.domain.Account;
import com.eteam.study.$08_interface.domain.CheckingAccount;
import com.eteam.study.$08_interface.domain.Customer;
import com.eteam.study.$08_interface.domain.SavingAccount;


public class AccountServiceImpl implements AccountService {
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerService;
	
	public AccountServiceImpl(CustomerService cs) {
		customerService = cs;
	}
	
	public Account createSavingAccount(String accountNum, double balance, double interestRate) {
		return new SavingAccount(accountNum, balance, interestRate);
	}
	
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount) {
		return new CheckingAccount(accountNum, balance, overdraftAmount);
	}
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	public void addAccount(Account account, String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	public List<Account> getAccountBySsn(String ssn){
		Customer customer = customerService.getCustomerBySsn(ssn);
		List<Account> alist = new ArrayList<Account>();
		for(Account ac : accountList) {
			if(ac.getCustomer().getSsn() == customer.getSsn() ) {
				alist.add(ac);
			}
		}
		return alist;
	}
	
	public Account getAccountByAccountNum(String accountNum){
		for(Account ac : accountList) {
			if (ac.getAccountNum().equals(accountNum) ) {
				return ac;
			}
		}
		return null;
	}
}
