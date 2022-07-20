package com.eteam.study.$04_inheritance_class;

/**
 * Account 객체를 상속받아서 이자율을 가지는 일반계좌 객체생성
 * 추가적으로 이자율이라는 변수가 추가되었기 때문에 그거에 맞는 변수 및 메소드를 추가한다.
 * @author park
 *
 */
public class SavingAccount extends Account {
	private double interestRate; //이자율
	
	public SavingAccount(String accountNum, double balance, double interestRate) {
		super(accountNum, balance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
