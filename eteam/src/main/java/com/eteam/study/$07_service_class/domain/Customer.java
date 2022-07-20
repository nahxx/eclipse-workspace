package com.eteam.study.$07_service_class.domain;

import java.util.*;
/**
 * 고객 정보를 담을 수 있는 클래스.
 * 한명의 고객은 여러개의 계좌를 가질 수 있기 때문에 
 * 여러개의 계좌를 담을 수 있는 List를 활용
 * @author park
 * 
 */
public class Customer {
	private String name;
	private String ssn;
	private String phone;
	private String userId;
	private String passwd;
	private List<Account> accountList; //변경되는 부분
	
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
		accountList = new ArrayList<Account>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccount(Account ac) {
		accountList.add(ac);
	}
}
