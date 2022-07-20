package com.eteam.study.$09_static_singleton_class.service;

import java.util.Collection;

import com.eteam.study.$09_static_singleton_class.domain.Customer;

public interface CustomerService {
	void addCustomer(Customer c);	
	Customer getCustomerBySsn(String ssn);
	Collection<Customer> getAllCustomer();
	int getNumOfCustomers();
}
