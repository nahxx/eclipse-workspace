package com.varxyz.jv200.mod008.practice;

public class AccountTest {

	public static void main(String[] args) throws Exception {
		Account a1 = new SavingsAccount("123-456-789", 10000, 3);
		Account a2 = new CheckingAccount("987-654-321", 10000, 1000000);
		
		if(a1 instanceof SavingsAccount) {
			SavingsAccount s = (SavingsAccount) a1;
			System.out.println("출금액: " + s.withDraw(5000));
			System.out.println("출금액: " + s.withDraw(3000));
			System.out.println("출금액: " + s.withDraw(3000));
		}
	}

}
