package com.eteam.study.$09_static_singleton_class.service;

import java.util.ArrayList;
import java.util.List;

import com.eteam.study.$09_static_singleton_class.domain.*;

/**
 * static과 싱글톤 설명 필요
 * 
 * AccountService 객체를 한번만 생성하고
 * 메인에서는 getInstance 메서드를 통해 한번만 생성된 객체를
 * 불러와서 사용하도록 싱글톤을 적용해준다.
 *
 * 이때 getInstance 메서드를 사용하기 위해
 * 따로 서비스 객체를 생성하는 것이 불가능하므로(생성자의 접근 제한자가 private 이므로)
 * static메서드로 적옹하여 객체 생성없이 메서드 사용이 가능하도록 해줌
 * 
 * @author knh
 *
 */
public class AccountServiceImpl implements AccountService {
	private List<Account> accountList = new ArrayList<Account>();
	private CustomerService customerService;
	// static 객체로 서비스 객체 생성
	private static AccountServiceImpl as = new AccountServiceImpl();
	
	/**
	 * 생성자의 접근제한자를 private으로 하여 이 클래스 내에서만 생성가능하도록 지정
	 */
	private AccountServiceImpl() {
		customerService = CustomerServiceImpl.getInstance();
	}
	
	/**
	 * 클래스 내에서 생성한 서비스 객체를 부르는 static 메서드
	 * @return
	 */
	public static AccountServiceImpl getInstance() {
		return as;
	}
	
	public Account createSavingAccount(String accountNum, double balance, double interestRate) {
		return new SavingAccount(accountNum, balance, interestRate);
	}
	
	public Account createCheckingAccount(String accountNum, double balance, double overdraftAmount) {
		return new CheckingAccount(accountNum, balance, overdraftAmount);
	}
	
	public void addAccount(Account account) {
		accountList.add(account);
	}
	
	public void addAccount(Account account, String ssn) {
		Customer customer = customerService.getCustomerBySsn(ssn);
		account.setCustomer(customer);
	}
	
	public List<Account> getAccountBySsn(String ssn){
		Customer customer = customerService.getCustomerBySsn(ssn);
		List<Account> alist = new ArrayList<Account>();
		for(Account ac : accountList) {
			if(ac.getCustomer().getSsn() == customer.getSsn() ) {
				alist.add(ac);
			}
		}
		return alist;
	}
	
	public Account getAccountByAccountNum(String accountNum){
		for(Account ac : accountList) {
			if (ac.getAccountNum().equals(accountNum) ) {
				return ac;
			}
		}
		return null;
	}
}
