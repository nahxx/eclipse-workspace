package com.varxyz.banking.mvc.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varxyz.banking.mvc.dao.CustomerDao;
import com.varxyz.banking.mvc.domain.Customer;

@Service("service/customerService")
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;
	
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer getCustomerByUserId(String userId) {
		return customerDao.findCustomerByUserId(userId);
	}
	
	public boolean isValidCustomer(String userId, String passwd) {
		return customerDao.isValidCustomer(userId, passwd);
	}
}
