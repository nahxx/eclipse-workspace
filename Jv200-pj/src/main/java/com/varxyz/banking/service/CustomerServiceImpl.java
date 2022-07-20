package com.varxyz.banking.service;

import java.util.*;

import com.varxyz.banking.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	private Map<String, Customer> map = new HashMap();
	private static CustomerServiceImpl service = new CustomerServiceImpl();
	
	private CustomerServiceImpl() {
		super();
	}
	
	private CustomerServiceImpl getInstance() {
		return service;
	}

	public void addCustomer(Customer c) { // map에 고객 추가
		if(!map.containsKey(c.getSsn())) { // 고객 주민번호가 없다면
			map.put(c.getSsn(), c); // map에 추가(키값: 주민번호, value값: customer객체)
		}
	}

	public Customer getCustomerBySsn(String ssn) { // ssn으로 고객 얻기
		if(map.containsKey(ssn)) {
			return map.get(ssn); // 해당 ssn을 키값으로 가지는 customer 객체 반환
		}
		return null;
	}

	public Collection<Customer> getAllCustomers() { // map에 저장된 모든 고객 얻기
		return map.values(); // 모든 고객 객체 반환
	}

	public int getNumberOfCustomers() { // map에 저장된 고객 수 얻기
		return map.size(); // map 길이 반환
	}
}
