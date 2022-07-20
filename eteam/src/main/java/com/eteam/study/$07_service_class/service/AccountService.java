package com.eteam.study.$07_service_class.service;

import java.util.*;

import com.eteam.study.$07_service_class.domain.Account;
import com.eteam.study.$07_service_class.domain.CheckingAccount;
import com.eteam.study.$07_service_class.domain.Customer;
import com.eteam.study.$07_service_class.domain.SavingAccount;

public class AccountService {
	
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerservice;
	
	public AccountService(CustomerService cs) {
		customerservice = cs;
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
		Customer customer = customerservice.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	public List<Account> getAccountBySsn(String ssn){
		Customer customer = customerservice.getCustomerBySsn(ssn);
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
