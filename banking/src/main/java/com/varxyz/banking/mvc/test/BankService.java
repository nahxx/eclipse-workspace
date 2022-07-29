package com.varxyz.banking.mvc.test;

import java.util.List;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

public interface BankService {
	
	/**
	 * 고객 추가하는 메소드
	 * @param userId
	 * @param passwd
	 * @param name
	 * @param ssn
	 * @param phone
	 * @return
	 */
	boolean addCustomer(String userId, String passwd, String name, String ssn, String phone);
	
	/**
	 * 계좌 추가하는 메소드
	 * @param accType
	 * @param userId
	 * @return
	 */
	Account addAccount(char accType, String userId);
	
	/**
	 * 해당 유저아이디를 가지는 고객의 계좌리스트 반환하는 메소드
	 * @param userId
	 * @return
	 */
	List<Account> getAccounts(String userId);
	
	/**
	 * 이체하는 메소드
	 * @param amount
	 * @param withdrawNum
	 * @param depositNum
	 * @return
	 * @throws InsufficientBalanceException
	 */
	boolean transfer(double amount, String withdrawNum, String depositNum) throws InsufficientBalanceException;
	
	/**
	 * 이자 지급하는 메소드
	 * @param interestRate
	 * @param AccountNum
	 * @return
	 */
	boolean saveInterest(double interestRate, String AccountNum);
	
	/**
	 * 해당 계좌번호를 가진 계좌의 잔액을 반환하는 메소드
	 * @param accountNum
	 * @return
	 */
	double getBalance(String accountNum);
}
