package com.varxyz.jv200.mod008.practice;

public class SavingsAccount extends Account {
	private String accountNum;
	private double balance;
	private double interestRate;
	
	public SavingsAccount(String accountNum, double initBalance, double interestRate) {
		this.accountNum = accountNum;
		this.balance = initBalance;
		this.interestRate = interestRate;
	}

	@Override
	public double withDraw(double amt) throws Exception {
		try {
			if(balance > amt) { // 예외처리 어떻게 해야하지?
				balance -= amt;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage() + "출금 가능 금액이 모자랍니다.");
		} finally {
			System.out.println("현재 잔액: " + balance);
		}
		return amt;
	}

	
	

	

}
