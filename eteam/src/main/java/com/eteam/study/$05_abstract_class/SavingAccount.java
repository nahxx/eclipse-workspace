package com.eteam.study.$05_abstract_class;

/**
 * 추상클래스인 Account 객체를 상속받아서 이자율을 가지는 일반계좌 객체생성
 * 상속받는 부모객체가 추상클래스 이기 때문에 추상메소드를 무조건 오버라이딩 해야 된다.
 * @author park
 *
 */
public class SavingAccount extends Account {
	private double interestRate; //이자율
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	public void deposite(double amount) {
		this.balance += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			System.out.println("잔고부족");
		}
		this.balance -= amount;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
