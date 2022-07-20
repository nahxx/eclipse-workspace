package com.varxyz.jv250.banking;

import java.util.*;

public abstract class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	protected char accountType;
	protected long customerId;
	protected long aid;
	protected Date date;

	public Account() {
		
	}
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	public void deposite(double amount) {
		this.balance += amount;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public abstract void withdraw(double amount) throws InsufficientBalanceException;
	public abstract void setCustomer(Customer customer); // 해당 계좌를 가진 고객 지정
	public abstract Customer getCustomer();
	
	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
		this.accountType = accountType;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public Date getRegDate() {
		return date;
	}

	public void setRegDate(Date date) {
		this.date = date;
	}
	

}
