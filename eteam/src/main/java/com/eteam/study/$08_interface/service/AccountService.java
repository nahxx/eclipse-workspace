package com.eteam.study.$08_interface.service;
import java.util.Collection;

import com.eteam.study.$08_interface.domain.Account;

/**
 * 인터페이스 사용 이유 설명 필요
 * 인터페이스에는 메서드 선언만 하고
 * 실제 로직은 인터페이스를 상속받은 클래스에서 구현
 * @author knh
 *
 */
public interface AccountService {
	Account createSavingAccount(String accountNum, double balance, double interestRate);
	Account createCheckingAccount(String accountNum, double balance, double overdraftAmount);
	void addAccount(Account account);
	void addAccount(Account account, String ssn);
	Collection<Account> getAccountBySsn(String ssn);
	Account getAccountByAccountNum(String accountNum);
}
