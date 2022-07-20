package com.varxyz.jv251.domain;

import java.util.Date;

import com.varxyz.jv251.exception.InsufficientBalanceException;

public class SavingsAccount extends Account{
	private double interestRate;
	
	/**
	 * 생성자
	 */
	public SavingsAccount() {
		
	}
	
	public SavingsAccount(String accountNum, double balance) {
		this(accountNum, balance, 0.0);
	}
	
	public SavingsAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(balance - amount < 0) { // 현재 잔고가 출금액보다 부족하다면 에러 발생
		throw new InsufficientBalanceException("현재 잔고: " + balance + ", 잔고 부족으로 인해 출금이 불가능합니다.");
		}
		super.balance -= amount;
		System.out.println("총 출금액: " + amount + ", 현재 잔고: " + balance);
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
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
