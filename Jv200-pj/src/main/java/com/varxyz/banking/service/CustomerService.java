package com.varxyz.banking.service;

import java.util.*;

import com.varxyz.banking.domain.Customer;

public interface CustomerService {
	void addCustomer(Customer c);
	Customer getCustomerBySsn(String ssn); // ssn으로 고객 가져오기
	Collection<Customer> getAllCustomers(); // 고객 전체 가져오기
	int getNumberOfCustomers(); // 고객 전체 수 가져오기
}
