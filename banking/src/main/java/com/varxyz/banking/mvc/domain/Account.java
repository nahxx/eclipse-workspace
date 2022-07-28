package com.varxyz.banking.mvc.domain;

import java.util.Date;

import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Account {
	private long aid;
	private Customer customer; // customerId보다는 객체로 보관하는 것이 더 좋음
	private String accountNum;
	private char accType;
	protected double balance;
	private Date regDate;
	
	public Account() {
		
	}

	public void deposite(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException {
		
	}
}
