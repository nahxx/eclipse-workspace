package com.varxyz.banking.mvc.exception;

public class InsufficientBalanceException extends Exception {
	private double balance;
	
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
	
	public InsufficientBalanceException(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "현재 잔고는 " + balance + " 입니다.";
	}
}
