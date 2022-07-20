package com.varxyz.jv250.banking;

import java.util.*;

public class AccountDaoTest {
	public static void main(String[] args) {
		// 새계좌 등록
		AccountDao dao = new AccountDao();
//		Account account = new SavingsAccount("777-77-7777", 6000.0);
//		account.setAccountType('S');
//		account.setCustomerId(1002);
//		dao.addAccount(account);
		
		// 전체 계좌 정보 조회
//		List<Account> accountList = dao.findAllAccounts();
//		System.out.println(accountList);
//		for(Account a : accountList) {
//			System.out.println(a.toString());
//		}
		
		// 새계좌 등록
//		SavingsAccount sa = new SavingsAccount();
//		sa.setAccountNum("666-66-6666");
//		sa.setBalance(4500.0);
//		sa.setInterestRate(0.04);
//		sa.setCustomer(new Customer(1023));
//		sa.setRegDate(new Date());
//		sa.setAccountType('S');
//		dao.addAccount(sa);
		
		// 주민번호 통해서 계좌정보 조회
		List<Account> accountList2 = dao.findAccountsBySsn("901212-1234567");
		for(Account a : accountList2) {
			System.out.println(a);
		}
	}
}
