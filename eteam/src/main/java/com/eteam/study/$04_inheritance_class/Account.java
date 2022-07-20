package com.eteam.study.$04_inheritance_class;

/**
 * Account 계좌 클래스를 상속받아서 객체를 세분화 한다. 
 * 공통으로 쓰이는 변수체크와 오버라이딩 할 메소드를 확인한다.
 * protected의 개념을 생각하기.
 * @author park
 *
 */
public class Account {
	protected String accountNum;
	protected double balance;
	protected Customer customer;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}

	public void deposite(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (balance - amount < 0) {
			System.out.println("잔고부족");
		}
		this.balance -= amount;
	}

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
