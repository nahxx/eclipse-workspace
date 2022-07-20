package com.eteam.study.$01_class;

/**
 * 계좌정보를 담을수 있는 클래스
 * @author park
 *
 */
public class Account {
	private String accountNum;
	private double balance;
	private Customer customer;
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	/**
	 * 입금하는 메소드
	 * @param amount		입금할 금액 
	 */
	public void deposite(double amount) {
		this.balance += amount;
	}
	/**
	 * 출금하는 메소드
	 * @param amount		출금할 금액
	 */
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			System.out.println("잔고부족");
		}
		this.balance -= amount;
	}
	/**
	 * 계좌정보에 고객객체를 담는 메소드 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * 고객 객체를 담는 메소드
	 * @return			고객 객체
	 */
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
