package com.varxyz.jv250.banking;

import java.util.*;

public class CustomerDaoTest {
	public static void main(String[] args) {
		CustomerDao dao = new CustomerDao();
		
//		 findAllCustomers() Test
		List<Customer> customerList = dao.findAllCustomers();
		for(Customer customer : customerList) {
			System.out.println(customer.toString());
		}
		
		AccountDao dao2 = new AccountDao();
		List<Account> accountList2 = dao2.findAccountsBySsn("901212-1234567");
		for(Account a : accountList2) {
			System.out.println(a);
		}
	}
}
