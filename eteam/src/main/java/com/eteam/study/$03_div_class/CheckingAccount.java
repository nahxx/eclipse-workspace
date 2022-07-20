package com.eteam.study.$03_div_class;

/**
 * 대출한도를 가지는 마이너스 계좌 객체. 
 * @author park
 *
 */
public class CheckingAccount {
	private String accountNum;
	private double balance;
	private Customer customer;
	private double overdraftAmount; //대출 한도
	private boolean flag; //대출 상황인지 아닌지 파악
	
	public CheckingAccount(String accountNum, double balance, double overdraftAmount) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.overdraftAmount = overdraftAmount;
		this.flag = false;
	}

	/**
	 * 입금하는 메소드
	 * @param amount		입금할 금액 
	 */
	public void deposite(double amount) {
		//대출진행중인 상황에서 입금을 하게 되면 잔액과 입금금액이 한도를 넘어서면 대출상황을 원상복귀 하고 남은 잔액은 더해준다. 
		if(flag == true && overdraftAmount < balance + amount) {
			amount = balance + amount - overdraftAmount;
			balance = 0;
			flag = false;
		}
		this.balance += amount;
	}
	/**
	 * 출금하는 메소드
	 * @param amount		출금할 금액
	 */
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			if(balance + overdraftAmount - amount < 0) {
				//대출한도를 더해도 출금할 금액이 많다면 잔고부족
				System.out.println("잔고부족");
			}
			else {
				flag = true; //마이너스 대출 진행
				balance = balance + overdraftAmount; //잔액을 한도금액만큼 더해준다.
			}
		}
		this.balance -= amount;
	}
	/**
	 * 계좌정보에 고객객체를 담는 메소드 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * 고객 객체를 담는 메소드
	 * @return			고객 객체
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	public String getAccountNum() {
		return accountNum;
	}
	
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
