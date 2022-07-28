package com.varxyz.banking.mvc.domain;



import com.varxyz.banking.mvc.exception.OverdraftException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckingAccount extends Account {
	private double overdraftAmount;
	
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
}
