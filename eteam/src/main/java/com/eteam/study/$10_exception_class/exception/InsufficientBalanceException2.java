package com.eteam.study.$10_exception_class.exception;

@SuppressWarnings("serial")
public class InsufficientBalanceException2 extends Exception {
	private double balance;
	
	public InsufficientBalanceException2(String msg) {
		super(msg);
	}
	
	public InsufficientBalanceException2(String msg, double balance) {
		super(msg);
		this.balance = balance;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + "현재 잔고는 " + balance + "입니다.";
	}
}

