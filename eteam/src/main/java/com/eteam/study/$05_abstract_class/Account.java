package com.eteam.study.$05_abstract_class;

/**
 * Account 계좌 클래스를 추상클래스로 변경
 * 추상클래스는 부연설명이 필요할듯 추상클래스는 객체가 될수 없다.
 * protected의 개념을 생각하기.
 * @author park
 *
 */
public abstract class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	/**
	 * 입금과 추상은 객체특성에 맞춰서 필수적으로 들어가야되는 메소드 이며
	 * 각 객체 특정에 맞게 변경할 수 있기때문에 추상메소드로 구현.
	 * @param amount
	 */
	public abstract void deposite(double amount);
	public abstract void withdraw(double amount);

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
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
}
