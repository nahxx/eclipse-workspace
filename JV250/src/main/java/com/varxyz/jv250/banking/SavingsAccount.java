package com.varxyz.jv250.banking;

import java.util.Date;

public class SavingsAccount extends Account{
	private static final double DEFAULT_INTEREST_RATE = 0.03;
	private double interestRate;
	private long aid;
	
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, DEFAULT_INTEREST_RATE);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	public String getAccountNum() {
		return super.getAccountNum();
	}
	
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(balance - amount < 0) { // 현재 잔고가 출금액보다 부족하다면 에러 발생
		throw new InsufficientBalanceException("현재 잔고: " + balance + ", 잔고 부족으로 인해 출금이 불가능합니다.");
		}
		super.balance -= amount;
		System.out.println("총 출금액: " + amount + ", 현재 잔고: " + balance);
	}

	@Override
	public void setCustomer(Customer c) {
		super.customer = c;
	}

	@Override
	public Customer getCustomer() {
		return super.customer;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
	}

	public String toString() {
		String str = "계좌No: " + aid;
		str += "\n계좌번호: " + accountNum;
		str += "\n현재잔액: " + balance;
		str += "\n이자율: " + interestRate;
		str += "\n계좌타입: " + accountType;
		str += "\n=====================\n";
		return str;
	}
	
}
