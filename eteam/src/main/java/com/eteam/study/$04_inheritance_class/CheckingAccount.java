package com.eteam.study.$04_inheritance_class;

/**
 * Account 객체를 상속받아서 대출한도를 가지는 마이너스 계좌 객체생성
 * 대출한도로는 변수 때문에 출금방식과 입금방식의 기존 부모 객체에서 수정을 한다. 이것을 Override라고 부른다.
 * 추가적으로 대출한도라는 변수가 추가되었기 때문에 그거에 맞는 변수 및 메소드를 추가한다.
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
				System.out.println("잔고부족");
			}
			else {
				flag = true; //마이너스 대출 진행
				balance = balance + overdraftAmount; //잔액을 한도금액만큼 더해준다.
			}
		}
		this.balance -= amount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}
	
	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
