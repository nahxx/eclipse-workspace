package com.eteam.study.$03_div_class;

/**
 * 이자율을 가지는 일반계좌 객체
 * @author park
 *
 */
public class SavingAccount {
	private String accountNum;
	private double balance;
	private Customer customer;
	private double interestRate; //이자율
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
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
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
