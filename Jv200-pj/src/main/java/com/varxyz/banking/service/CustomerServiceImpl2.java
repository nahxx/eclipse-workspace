package com.varxyz.banking.service;

import java.util.*;

import com.varxyz.banking.domain.Customer;

public class CustomerServiceImpl2 implements CustomerService {
	private List<Customer> customerList = new ArrayList<Customer>();
	private static CustomerServiceImpl2 service = new CustomerServiceImpl2();
	// Service 객체를 한번만 생성
	
	private CustomerServiceImpl2() {
		super(); 
	}
	
	public static CustomerServiceImpl2 getInstance() {
		// main에서 객체를 호출할 때는 getInstance() 메서드를 사용
		return service;
	}
	
	public void addCustomer(Customer c) { // customerList에 고객 추가
		if(getCustomerBySsn(c.getSsn()) == null) { // 파라미터로 받은 customer 객체의 ssn이 리스트에 없다면
			customerList.add(c); // 고객 추가
		}
	}

	public Customer getCustomerBySsn(String ssn) { // 해당 주민번호를 가진 고객 얻기
		for(Customer c : customerList) { // customerList 반복
			if(ssn.equals(c.getSsn())) { // 파라미터로 받은 ssn과 같은 ssn을 가진 객체가 있다면
				return c; // 그 객체 반환
			}
		}
		return null;
	}

	public Collection<Customer> getAllCustomers() { // 리스트에 저장된 모든 고객 얻기
		return customerList; // 리스트 채로 반환(for문 돌려서 각 객체 활용하기)
	}

	public int getNumberOfCustomers() { // 리스트에 저장된 고객 수 얻기
		return customerList.size(); // 저장된 고객 수 반환
	}
	
}
