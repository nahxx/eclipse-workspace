package com.varxyz.jv251.domain;

import com.varxyz.jv251.exception.InsufficientBalanceException;
import com.varxyz.jv251.exception.OverdraftException;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount() {
		
	}
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	@Override
	public void withdraw(double amount) throws OverdraftException {
		if(balance < amount) { // 잔고가 부족하다면
			double overdraftNeeded = amount - balance;
			if(overdraftAmount < overdraftNeeded) {
				throw new OverdraftException("에러 : 대출금 초과", balance, overdraftNeeded);
			} else {
//				balance = overdraftNeeded*-1.0;
				balance = 0.0;
				overdraftAmount = overdraftAmount - overdraftNeeded;
			}
		}else {
			balance = balance - amount;
		}
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
	
	public String toString() {
		String str = "계좌No: " + aid;
		str += "\n계좌번호: " + accountNum;
		str += "\n현재잔액: " + balance;
		str += "\n마이너스 한도: " + overdraftAmount;
		str += "\n계좌타입: " + accountType;
		str += "\n=====================\n";
		return str;
	}
	
}
