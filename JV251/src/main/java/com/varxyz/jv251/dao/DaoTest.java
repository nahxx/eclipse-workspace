package com.varxyz.jv251.dao;

import java.util.List;

import com.varxyz.jv251.domain.Account;
import com.varxyz.jv251.domain.Customer;

public class DaoTest {
	public static void main(String[] args) {
		CustomerDao cd = new CustomerDao();
		List<Customer> cusList = cd.findAllCustomers();
		for(Customer c : cusList) {
			System.out.println(c.toString());
		}
		
		AccountDao ad = new AccountDao();
		List<Account> accList = ad.findAllAccounts();
		for(Account a : accList) {
			System.out.println(a.toString());
		}
	}
}
