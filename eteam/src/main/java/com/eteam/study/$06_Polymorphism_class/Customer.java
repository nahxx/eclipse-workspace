package com.eteam.study.$06_Polymorphism_class;

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
	private List<SavingAccount> savingAccountList; //변경되는 부분
	private List<CheckingAccount> checkingAccountList; //변경되는 부분
	
	public Customer(String name, String ssn, String phone, String userId, String passwd) {
		this.name = name;
		this.ssn = ssn;
		this.phone = phone;
		this.userId = userId;
		this.passwd = passwd;
		savingAccountList = new ArrayList<SavingAccount>();
		checkingAccountList = new ArrayList<CheckingAccount>();
	}
	
	/**
	 * 객체를 추가함으로써 추가해줘야 하는 메소드
	 * @return
	 */
	public List<SavingAccount> getSavingAccount() {
		return savingAccountList;
	}
	
	public void setSavingAccount(SavingAccount ac) {
		savingAccountList.add(ac);
	}
	
	public List<CheckingAccount> getCheckingAccount() {
		return checkingAccountList;
	}
	
	public void setCheckingAccount(CheckingAccount ac) {
		checkingAccountList.add(ac);
	}
	
	public int getSavingAccountListCount() {
		return savingAccountList.size();
	}
	
	public int getCheckinAccountListCount() {
		return checkingAccountList.size();
	}
	/******************************************************************/
	
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
