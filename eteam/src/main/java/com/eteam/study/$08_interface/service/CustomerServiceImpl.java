package com.eteam.study.$08_interface.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.eteam.study.$08_interface.domain.Customer;

public class CustomerServiceImpl implements CustomerService {
	private List<Customer> customerList = new ArrayList<Customer>();
	
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
