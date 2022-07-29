package com.varxyz.banking.mvc.domain;

import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	private double interestRate;
	
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if(balance - amount < 0) { // 현재 잔고가 출금액보다 부족하다면 에러 발생
		throw new InsufficientBalanceException("현재 잔고: " + balance + ", 잔고 부족으로 인해 출금이 불가능합니다.");
		}
		super.balance -= amount;
	}
}
