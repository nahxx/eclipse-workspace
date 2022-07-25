package com.varxyz.jvx330.jdbc.example5;

import com.varxyz.jvx330.jdbc.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	private double interestRate;
	
	public void withdraw(double amount) {
		
	}
}
