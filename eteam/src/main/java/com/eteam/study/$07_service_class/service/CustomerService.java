package com.eteam.study.$07_service_class.service;

import java.util.*;

import com.eteam.study.$07_service_class.domain.Customer;
/**
 * 고객정보를 관리할 수 있는 Service 객체 생성
 * @author park
 *
 */
public class CustomerService {
	private List<Customer> aList = new ArrayList<Customer>();

	public void addCustomer(Customer c) {
		if(getCustomerBySsn(c.getSsn()) == null) {
			aList.add(c);
		}
	}
	/**
	 * 고객의 주민번호로 고객이 존재하는지 확인 후에 존재하는 고객을 넘겨준다.
	 * @param ssn
	 * @return
	 */
	public Customer getCustomerBySsn(String ssn) {
		for(Customer cc : aList) {
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
		return aList;
	}
	/**
	 * 총 고객의 수를 확인하는 메소드
	 * @return
	 */
	public int getNumOfCustomers() {
		return aList.size();
	}
}
