package com.varxyz.banking.mvc.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.mvc.dao.AccountDao;
import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.domain.Account;
import com.varxyz.banking.mvc.domain.CheckingAccount;
import com.varxyz.banking.mvc.domain.Customer;
import com.varxyz.banking.mvc.domain.SavingsAccount;
import com.varxyz.banking.mvc.exception.InsufficientBalanceException;

@Service("test/BankingServiceImpl")
public class BankingServiceImpl implements BankingService{
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountService accountService;
	
	@Override
	public void addCustomer(String userId, String passwd, String name, String ssn, String phone) {
		Customer customer = new Customer();
		customer.setUserId(userId);
		customer.setPasswd(passwd);
		customer.setName(name);
		customer.setSsn(ssn);
		customer.setPhone(phone);
		
		if(!customerDao.isValidUserId(userId)) {
			customerDao.addCustomer(customer);
			System.out.println("가입이 완료되었습니다.");
		} else {
			System.out.println("존재하는 아이디입니다. 아이디를 다시 입력해주세요.");
		}
		
	}

	@Override
	public Account addAccount(char accType, String userId, double initBalance) {
		
		double balance = initBalance;
		double interestRate = 0.0;
		double overdraftAmount = 0.0;
		if(accType == 'S') {
			interestRate = 0.2;
		} else {
			overdraftAmount = 50000;
		}
		
		// userId로 customer 찾기
		Customer customer = customerService.getCustomerByUserId(userId);
		// 랜덤 계좌번호 생성
		String accountNum = "";
		for(int i = 0; i < 11; i++) {
			if(i == 3 || i ==  6) {
				accountNum += "-";
			} else {
				Random random = new Random();
				int num = random.nextInt(10 - 1) + 1;
				accountNum += String.valueOf(num);
			}
		}
		
		// 서비스 호출해서 값넣기 (타입에 따라 다르게)
		Account account = null;
		if(accType == 'S') {
			account = new SavingsAccount();
			SavingsAccount sa = (SavingsAccount) account;
			sa.setInterestRate(interestRate);
		} else {
			account = new CheckingAccount();
			CheckingAccount ca = (CheckingAccount) account;
			ca.setOverdraftAmount(overdraftAmount);
		}
		account.setAccountNum(accountNum);
		account.setAccType(accType);
		account.setBalance(balance);
		account.setCustomer(customer);
		
		accountDao.addAccount(account);
		
		return account;
	}

	@Override
	public List<Account> getAccounts(String userId) {
		return accountDao.findAccountsByUserId(userId);
	}

	@Override
	public void transfer(double amount, String withdrawNum, String depositNum) throws InsufficientBalanceException {
		Account withdrawAcc = accountService.getAccountByAccountNum(withdrawNum);
		Account depositAcc = accountService.getAccountByAccountNum(depositNum);
		
		if(withdrawAcc.getAccType() == 'S') {
			SavingsAccount sa = (SavingsAccount)withdrawAcc;
			sa.withdraw(amount);
			accountService.updateBalance(sa);
		} else {
			CheckingAccount ca = (CheckingAccount)withdrawAcc;
			ca.withdraw(amount);
			accountService.updateBalance(ca);
		}
		
		if(depositAcc.getAccType() == 'S') {
			SavingsAccount sa = (SavingsAccount)depositAcc;
			sa.deposite(amount);
			accountService.updateBalance(sa);
		} else {
			CheckingAccount ca = (CheckingAccount)depositAcc;
			ca.deposite(amount);
			accountService.updateBalance(ca);
		}
	}

	@Override
	public boolean saveInterest(double interestRate, String AccountNum) {
		// 이자 구현 영역
		return false;
		
	}

	@Override
	public double getBalance(String accountNum) {
		return accountService.getAccountByAccountNum(accountNum).getBalance();
	}
	
}
