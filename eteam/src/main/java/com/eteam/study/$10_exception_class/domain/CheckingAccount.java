package com.eteam.study.$10_exception_class.domain;

import com.eteam.study.$10_exception_class.exception.InsufficientBalanceException;

/**
 * 추상클래스인 Account 객체를 상속받아서 대출한도를 가지는 마이너스 계좌 객체생성
 * 상속받는 부모객체가 추상클래스 이기 때문에 추상메소드를 무조건 오버라이딩 해야 된다.
 * @author park
 *
 */
public class CheckingAccount extends Account {
	private double overdraftAmount; //대출 한도
	private boolean flag; //대출 상황인지 아닌지 파악
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		super(accountNum, balance);
		this.overdraftAmount = overdraftAmount;
		this.flag = false;
	}

	@Override
	public void deposite(double amount) { 
		if(flag == true && overdraftAmount < balance + amount) {
			amount = balance + amount - overdraftAmount;
			balance = 0;
			flag = false;
		}
		this.balance += amount;
	}
	
	@Override
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			if(balance + overdraftAmount - amount < 0) {
				throw new InsufficientBalanceException("잔고부족", balance);
			}
			else {
				flag = true; //마이너스 대출 진행
				balance = balance + overdraftAmount; //잔액을 한도금액만큼 더해준다.
			}
		}
		this.balance -= amount;
	}
	/*
	 * InsufficientBalanceException2로 변경해보자.
	 * InsufficientBalanceException2는 Exception을 상속받기 때문에 예외처리를 던져줘야한다.
	 * 그리고 withdraw메소드를 요청한곳에서 try-catch문을 통해 예외처리를 받아야한다.
	 * 
	@Override
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			if(balance + overdraftAmount - amount < 0) {
				throw new InsufficientBalanceException("잔고부족", balance);
			}
			else {
				flag = true; //마이너스 대출 진행
				balance = balance + overdraftAmount; //잔액을 한도금액만큼 더해준다.
			}
		}
		this.balance -= amount;
	}
	*/
	

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
