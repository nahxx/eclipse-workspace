package com.varxyz.banking.mvc.test;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.CheckingAccount;
import com.varxyz.banking.mvc.domain.SavingsAccount;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

@Service("test/transferAccount")
public class TransferAccount implements BankService {
	
	/**
	 * 이체하는 메소드
	 */
	@Override
	@Transactional
	public boolean transfer(double amount, String withdrawNum, String depositNum) throws InsufficientBalanceException {
		Account withdrawAcc = getAccountByAccountNum(withdrawNum);
		Account depositAcc =getAccountByAccountNum(depositNum);
		
		if(amount != 0.0 && withdrawNum != null && depositNum != null) {
			if(withdrawAcc.getAccType() == 'S') {
				SavingsAccount sa = (SavingsAccount)withdrawAcc;
				sa.withdraw(amount);
				updateBalance(sa);
			} else {
				CheckingAccount ca = (CheckingAccount)withdrawAcc;
				ca.withdraw(amount);
				updateBalance(ca);
			}
			
			if(depositAcc.getAccType() == 'S') {
				SavingsAccount sa = (SavingsAccount)depositAcc;
				sa.deposite(amount);
				updateBalance(sa);
			} else {
				CheckingAccount ca = (CheckingAccount)depositAcc;
				ca.deposite(amount);
				updateBalance(ca);
			}
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * 해당 계좌번호를 가지는 계좌 반환하는 메소드
	 * @param withdrawNum
	 * @return Account
	 */
	private Account getAccountByAccountNum(String withdrawNum) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 계좌잔고를 수정하는 메소드
	 * @param account
	 */
	private void updateBalance(Account account) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean addCustomer(String userId, String passwd, String name, String ssn, String phone) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Account addAccount(char accType, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAccounts(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveInterest(double interestRate, String AccountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getBalance(String accountNum) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
