package com.varxyz.jv251.service;

import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.Customer;
import com.varxyz.jv251.exception.CustomerNotFoundException;
import com.varxyz.jv251.exception.InsufficientBalanceException;

public class BankServiceTest {
	public static void main(String[] args) {
		BankService service = BankService.getInstance();
		String name = "동탁";
		String ssn = "880123-1234567";
		String phone = "010-4343-3232";
		String userId = "framework";
		String passwd = "1111";
		
		// 1. 신규 고객 등록
//		service.addCustomer(name, ssn, phone, userId, passwd);
//		try {
//			// 2. SavingsAccount 생성
//			service.addSavingsAccount(7000.0, 0.4, ssn);
//		} catch (CustomerNotFoundException e) {
//			e.printStackTrace();
//		}
		// 3. 고객 등록 확인
//		Customer customer = service.getCustomerBySsn(ssn);
//		System.out.println(customer);
		
		// 4. 고객 계좌 목록 확인
//		List<Account> myList = service.getAccountBySsn(ssn);
//		
//		for (Account account : myList) {
//			System.out.println(account);
//		}
		
		// 5. 고객 계좌에서 출금
		String accNum = "222-22-2222";
//		try {
//			service.withdraw(500, accNum);
//		} catch (InsufficientBalanceException e) {
//			e.printStackTrace();
//		}
		
		service.deposit(500, accNum);
		System.out.println(service.getAccountByAccountNum(accNum));
	}
}
