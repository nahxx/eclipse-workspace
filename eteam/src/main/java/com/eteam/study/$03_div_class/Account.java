package com.eteam.study.$03_div_class;

/**
 * Account객체를 세분화 하여 SavingAccount와 CheckingAccount를 나눴기 때문에
 * Account객체를 쓸일이 없다.
 * 
 * @author park
 *
 */
public class Account {
	private String accountNum;
	private double balance;
	private Customer customer;
	private double interestRate; //이자율
	private double overdraftAmount; //대출 한도
	
	public Account(String accountNum, double balance) {
		this.accountNum = accountNum;
		this.balance = balance;
	}
	
	/**
	 * 생성자 오버로딩 설명
	 */
	public Account(String accountNum, double balance, double interestRate) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	/**
	 * Q1. 아래의 생성자의 오류가 나는 이유는 ?
	 * Q2. 두가지의 해결방법은 ?
	 *     - 방법1 : 생성자에 accountType 변수로 일반계좌 , 마이너스 계좌를 구분지어 준다.
	 *     - 방법2 : 새로운 생성자를 만들지 않고, get set 메소드를 활용하여 초기값을 셋팅해준다. 
	 */
	/* 
	public Account(String accountNum, double balance, double overdraftAmount) {
		this.accountNum = accountNum;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	*/
	/* 정답1
	public Account(String accountNum, double balance, double var, char accountType ) {
		this.accountNum = accountNum;
		this.balance = balance;
		if(flag == 'S') {
			this.interestRate = var;
		}
		else if(flag == 'C') {
			this.overdraftAmount = var;
		}
	}
	*/
	
	
	/**
	 * 입금하는 메소드
	 * @param amount		입금할 금액 
	 */
	public void deposite(double amount) {
		this.balance += amount;
	}
	/**
	 * 출금하는 메소드
	 * @param amount		출금할 금액
	 */
	public void withdraw(double amount) {
		if (balance - amount < 0) {
			System.out.println("잔고부족");
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
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
