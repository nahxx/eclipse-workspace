package com.eteam.study.$08_interface.service;

import java.util.Collection;

import com.eteam.study.$08_interface.domain.Customer;

public interface CustomerService {
	void addCustomer(Customer c);	
	Customer getCustomerBySsn(String ssn);
	Collection<Customer> getAllCustomer();
	int getNumOfCustomers();
}
