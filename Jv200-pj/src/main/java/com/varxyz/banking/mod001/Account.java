package com.varxyz.banking.mod001;

/**
 * 계좌정보를 캡슐화
 * @author goodh
 *
 */
public class Account {
	double balance; // 변수 생성
	
	//constructors
	public Account(double initBalance) {
		balance = initBalance;
	}
	
	//methods
	
	/**
	 * 현재 잔고를 리턴
	 * @return 현재 잔고
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 전달된 amt를 현재 잔고에 적립
	 * @param amt 입금액
	 */
	public void deposit(double amt) {
		
	}
	
	/**
	 * 전달된 amt를 현재잔고에서 출금
	 * @param amt 출금액
	 */
	public void widthdraw(double amt) {
		// 잔고가 부족할 때
		if(balance - amt < 0) {
			
		}
	}
}
