package com.eteam.study.$01_class;

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
	private List<Account> accountList;
	
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
		accountList = new ArrayList<Account>();
	}
	
	public List<Account> getAccount() {
		return accountList;
	}
	public void setAccount(Account ac) {
		accountList.add(ac);
	}
	
	/**
	 * Q1. 한명의 고객이 가지고 있는 계좌의 숫자를 알아 볼수 있는 메소드를 만들기.
	 */
	public int getAccountListCount() {
		return accountList.size();
	}
	
	/**
	 * GET SET 속성 왜 GET SET를 쓰는지 설명해주기.
	 * 보안성, 외부에서 바로접근해서 잘못된 값 넘겨주지 않기 위해서.
	 * 메소드를 통해서 잘못된 값을 받지 않도록 처리 해줄 수 있음. 
	 */
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
}
