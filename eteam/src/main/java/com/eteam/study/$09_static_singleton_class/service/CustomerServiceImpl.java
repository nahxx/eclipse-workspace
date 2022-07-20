package com.eteam.study.$09_static_singleton_class.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.eteam.study.$09_static_singleton_class.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	private List<Customer> customerList = new ArrayList<Customer>();
	// static 객체로 서비스 객체 생성
	private static CustomerServiceImpl cs = new CustomerServiceImpl();
	
	/**
	 * 생성자의 접근제한자를 private으로 하여 이 클래스 내에서만 생성가능하도록 지정
	 */
	private CustomerServiceImpl() {

	}
	
	/**
	 * 클래스 내에서 생성한 서비스 객체를 부르는 static 메서드
	 * @return
	 */
	public static CustomerServiceImpl getInstance() {
		return cs;
	}
	
	public void addCustomer(Customer c) {
		if(getCustomerBySsn(c.getSsn()) == null) {
			customerList.add(c);
		}
	}
	
	/**
	 * 고객의 주민번호로 고객이 존재하는지 확인 후에 존재하는 고객을 넘겨준다.
	 * @param ssn
	 * @return
	 */
	public Customer getCustomerBySsn(String ssn) {
		for(Customer cc : customerList) {
			if(cc.getSsn() == ssn) {
				return cc;
			}
		}
		return null;
	}
	
	/**
	 * 고객 리스트를 받을수 있는 함수
	 * @return
	 */
	public Collection<Customer> getAllCustomer() {
		return customerList;
	}
	
	/**
	 * 총 고객의 수를 확인하는 메소드
	 * @return
	 */
	public int getNumOfCustomers() {
		return customerList.size();
	}

}
