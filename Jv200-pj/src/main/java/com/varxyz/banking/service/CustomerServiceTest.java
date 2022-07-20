package com.varxyz.banking.service;

import com.varxyz.banking.domain.*;


public class CustomerServiceTest {

	public static void main(String[] args) {
		CustomerService cs = CustomerServiceImpl2.getInstance();
//		Customer
		
		// 고객 생성
		Customer c1 = new Customer("홍길동", "1234-5678", "010-1111-2222", "001", "1234");
		Customer c2 = new Customer("김길동", "4567-8912", "010-2222-3333", "002", "4567");
		Customer c3 = new Customer("이길동", "6789-1234", "010-3333-4444", "003", "8912");
		
		// 고객 추가
		cs.addCustomer(c1);
		cs.addCustomer(c2);
		cs.addCustomer(c3);
		
		// 제대로 고객이 추가됐는지 확인
		for(Customer c : cs.getAllCustomers()) {
			System.out.println(c.getName() + "의 주민번호: " + c.getSsn());
		}
		System.out.println();
		
		
		AccountService as = AccountServiceImpl.getInstance();
		
		// 계좌 생성
		Account a1 = as.createSavingsAccount("111-1111-11", 1000, 0.01);
		Account a2 = as.createCheckingAccount("222-2222-22", 2000, 0.02);
		Account a3 = as.createSavingsAccount("333-3333-33", 3000, 3000);
		Account a4 = as.createCheckingAccount("444-4444-44", 4000, 4000);
		
		// 계좌담기
		as.addAccount(a1); as.addAccount(a2); as.addAccount(a3); as.addAccount(a4);
		
		c1.setAccount(a1); c1.setAccount(a2); c2.setAccount(a3); c3.setAccount(a4);
		// 해당 계좌의 계좌주인(고객) 지정
		as.addAccount(a1, c1.getSsn());
		as.addAccount(a2, c1.getSsn());
		as.addAccount(a3, "4567-8912");
		as.addAccount(a4, "6789-1234");
		
		
		// getAccountByAccountNum 메서드 확인
		Account aa = as.getAccountByAccountNum("444-4444-44");
		Customer c = aa.getCustomer();
		System.out.println("444-4444-44 계좌 주인 " + c.getName() + "의 주민번호는 " + c.getSsn());
		System.out.println();
		
		// getAccountBySsn 메서드 확인
		System.out.println("주민번호 1234-5678 의 계좌는");
		for(Account a : as.getAccountBySsn("1234-5678")) {
			System.out.println(a.getAccountNum());
		}
		System.out.println();
		
		System.out.println("주민번호 4567-8912 의 계좌는");
		for(Account a : as.getAccountBySsn("4567-8912")) {
			System.out.println(a.getAccountNum());
		}
		System.out.println();
		
		System.out.println("주민번호 6789-1234 의 계좌는");
		for(Account a : as.getAccountBySsn("6789-1234")) {
			System.out.println(a.getAccountNum());
		}
	}

}
