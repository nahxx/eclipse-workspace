package com.varxyz.jv250.banking;

import java.util.*;

/*
 * Customer (고객)
 * 이름 name
 * 주민번호 ssn
 * 연락처 phone
 * 고객id customerId
 * 비밀번호 passwd
 * 보유계좌 List<Account> 혹은 Collection<Account>
 * 
 * CustomerService : Customer에 대한 서비스를 처리하는 클래스
 * 1. 주요 메서드
 *	.addCustomer() : 신규 고객추가
 *	.getCustomerBySsn : 주민번호 고객 조회
 *	.getAllCustomers() : 전체 고객 목록
 *	.getNumberOfCustomers() : 전체 고객 수
 *
 * 2. 기타
 * 	- .CustomerService는 고객의 정보를 보거나 할 수 있는 속성을 유지해야 한다.
 * 	- 고객의 정보를 유지할 수 있는 속성을 정의하라.	
 */
public class Customer {
	private long cid;
	private String name;
	private String ssn;
	private String phone;
	private String customerId;
	private String passwd;
	List<Account> accountList = new ArrayList<Account>();
	
	public Customer() {
		
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
	
	public Customer(String name, String ssn, String phone) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public Customer(String name, String ssn, String phone, String customerId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.customerId = customerId;
		this.passwd = passwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String getSsn() {
		return ssn;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setAccount(Account a) { // 해당 고객이 가진 계좌 추가
		accountList.add(a); // 파라미터로 받은 계좌 리스트에 추가
	}
	
	public List<Account> getAccountList() { // 해당 고객이 가진 계좌 리스트 가져오기
		return accountList; // 리스트 채로 반환하므로 for문으로 출력하기
	}

	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}
	
	@Override
	public String toString() {
		String str = "cid: " + cid;
		str += "\n고객명: " + name;
		str += "\n주민번호: " + ssn;
		str += "\n연락처: " + phone;
		str += "\n고객ID: " + customerId;
		str += "\n==========================\n";
		return str;
	}
}
