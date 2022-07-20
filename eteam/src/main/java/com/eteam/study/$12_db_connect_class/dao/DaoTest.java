package com.eteam.study.$12_db_connect_class.dao;

import java.util.*;

import com.eteam.study.$12_db_connect_class.domain.Account;
import com.eteam.study.$12_db_connect_class.domain.CheckingAccount;
import com.eteam.study.$12_db_connect_class.domain.SavingAccount;

public class DaoTest {
	public static void main(String[] args) {
		CustomerDao cDao = new CustomerDao();
		AccountDao aDao = new AccountDao();
		/*
		//=========================================== CustomerDao TEST		
		//findAllCustomer() Test
		//고객 정보 모두 출력하는 함수
		List<Customer> customerList = cDao.findAllCustomers();
		for(Customer csutomer : customerList) {
			System.out.println(csutomer.toString());
		}
		
		//findCustomerBySsn() Test
		//"770321-1585447"의 고객 정보를 출력하는 함수
		System.out.println("================================");
		Customer customer = cDao.findCustomerBySsn("770321-1585447");
		System.out.println(customer.toString());
		
		//addCustomer() Test
		//Customer 객체를 생성후 DB에 INSERT 하는 함수
		System.out.println("================================");
		customer = new Customer("강호동","700505-1625744","010-7785-8548","onestay","twoday");
		cDao.addCustomer(customer);
		*/
		
		//Customer customer = cDao.findCustomerBySsn("700505-1625744");
		/*
		//=========================================== AccountDao TEST
		//addAccount() Test
		//위에서 생성한 강호동 객체를 셋팅해준다.
		System.out.println("================================");
		Account s_account = new SavingAccount("444-44-4444", 6000.0, 2.0);
		s_account.setAccountType('S');
		s_account.setCustomer(customer);
		
		Account c_account = new CheckingAccount("555-55-5555", 40000.0, 50000.0);
		c_account.setAccountType('C');
		c_account.setCustomer(customer);
		
		aDao.addAccount(s_account);
		aDao.addAccount(c_account);
		
		//findAllAccount() Test
		//전체 계좌 출력하는 함수
		List<Account> accountList = aDao.findAllAccount();
		for(Account account : accountList) {
			if(account instanceof SavingAccount) {
				System.out.println("진입1:" + ((SavingAccount)account).toString());
			}
			else if(account instanceof CheckingAccount) {
				System.out.println("진입2:" + ((CheckingAccount)account).toString());
			}
		}
		*/
		//findAccountBySsn() Test
		//주민번호 "700505-1625744"인 사람이 가진 계좌의 목록 출력하는 함수
		List<Account> aList = aDao.findAccountBySsn("700505-1625744");
		for(Account account : aList) {
			if(account instanceof SavingAccount) {
				System.out.println(((SavingAccount)account).toString());
			}
			else if(account instanceof CheckingAccount) {
				System.out.println(((CheckingAccount)account).toString());
			}
		}
	}
}
