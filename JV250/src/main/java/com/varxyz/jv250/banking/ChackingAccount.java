package com.varxyz.jv250.banking;

public class ChackingAccount extends Account {
	private double overdraftAmount;
	private long aid;
	
	public ChackingAccount() {
		
	}
	
	public ChackingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
	}
	
	@Override
	public void withdraw(double amount) {
		if(balance < amount) { // 잔고가 부족하다면
			double addWithdraw = amount - balance; // 추가 출금액을 변수에 담는다.
			if(overdraftAmount < addWithdraw) { // 만약 한도액보다 추가 출금액이 더 크다면 예외발생시킨다.
				try {
					throw new InsufficientBalanceException("현재 마이너스 한도액: " + overdraftAmount + ", 마이너스 한도액 초과로 인해 출금이 불가능합니다.");
				} catch(InsufficientBalanceException e) {
					e.getStackTrace();
				}
			}
			balance = 0.0; // 우선 잔고를 전부 출금했으니 0.0으로 비워준다.
			overdraftAmount -= addWithdraw; // 한도액에서 추가 출금액을 빼준다.
		} else {
			super.balance -= amount;
		}
		System.out.println("총 출금액: " + amount + ", 현재 잔고: " + balance + ", 마이너스 대출 한도액: " + overdraftAmount);
	}

	@Override
	public void setCustomer(Customer c) {
		super.customer = c;
	}

	@Override
	public Customer getCustomer() {
		return super.customer;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	public long getAid() {
		return aid;
	}

	public void setAid(long aid) {
		this.aid = aid;
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
