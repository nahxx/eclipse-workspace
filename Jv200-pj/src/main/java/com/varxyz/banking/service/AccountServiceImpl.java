package com.varxyz.banking.service;

import java.util.*;
import com.varxyz.banking.domain.*;

public class AccountServiceImpl implements AccountService {
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerService; // customerService를 참조하는 객체
	private static AccountService as = new AccountServiceImpl();
	// Service 객체를 한번만 생성
	
	// 싱글톤
	private AccountServiceImpl() {
		customerService = CustomerServiceImpl2.getInstance();
		// list형태의 customerService 클래스 객체 만들기
	}
	
	public static AccountService getInstance() {
		// main에서 객체를 호출할 때는 getInstance() 메서드를 사용
		return as;
	}
	
	// 예적금계좌 생성하는 메서드
	public Account createSavingsAccount(String accountNum, double balance, double interestRate) {
		return new SavingsAccount(accountNum, balance, interestRate);
	}
	
	// 당좌계좌(마이너스통장) 생성하는 메서드
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount) {
		return new ChackingAccount(accountNum, balance, overdraftAmount);
	}
	
	/**
	 * 신규 계좌 등록 => 계좌 정보와 고객 정보 전체를 캡슐화
	 * @param account
	 */
	public void addAccount(Account account) { // 파라미터로 받은 계좌 객체를 계좌리스트에 추가
		accountList.add(account);
	}
	
	/**
	 * 전달된 ssn을 통해 고객을 조회한 후 입금 계좌 등록
	 * @param account
	 * @param ssn
	 */
	public void addAccount(Account account, String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		// 파라미터로 받은 ssn 주민번호를 가진 고객을 customer 객체에 담기
//		System.out.println(customer.getName());
		account.setCustomer(customer); // 해당 계좌의 고객으로 지정
//		customer.setAccount(account);
	}
	
	public List<Account> getAccountBySsn(String ssn) {
		// 해당 ssn을 가진 customer가 없을 경우의 조건문 추가할 것!
//		List<Account> ssnAccountLi = new ArrayList<>();
		Customer customer = customerService.getCustomerBySsn(ssn);
		List<Account> ssnAccountLi = customer.getAccountList();
		return ssnAccountLi;
	}
	
	public Account getAccountByAccountNum(String accountNum) { // 파라미터로 받은 계좌번호를 가진 계좌 객체 얻기
		for(Account a : accountList) { // 계좌리스트 반복
			if(accountNum.equals(a.getAccountNum())) { // 파라미터로 받은 계좌번호와 동일한 계좌번호를 가진 계좌 객체가 있다면
				return a; // 해당 계좌 반환
			}
		}
		return null;
	}
	
}
