package com.varxyz.banking.mod001;

public class TestAccount {
	public static void main(String[] args) {
		Account myAccount = new Account(10000.5);
		System.out.println(myAccount.getBalance());
	}
}
