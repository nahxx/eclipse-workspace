package com.varxyz.jv200.mod008.practice;

public class CheckingAccount extends Account {
	private String accountNum;
	private double balance;
	private double minusLimit;
	
	public CheckingAccount(String accountNum, double initBalance, double minusLimit) {
		this.accountNum = accountNum;
		this.balance = initBalance;
		this.minusLimit = minusLimit;
	}

	@Override
	public double withDraw(double amt) throws Exception {
		if(balance - amt < 0) {
			try {
				balance -= amt;
			} catch (Exception e) {
				System.out.println("출금 가능 금액 부족");
			} finally {
				System.out.println("현재 잔액: " + balance);
			}
		} else {
			balance -= amt;
		}
		return amt;
	}

	
	
}
