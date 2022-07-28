package com.varxyz.banking.mvc.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Customer {
	private long cid;
	private String userId;
	private String passwd;
	private String name;
	private String ssn;
	private String phone;
	private Date regDate;
	
	public Customer() {
		super();
	}
	
	public Customer(long cid) {
		this.cid = cid;
	}
}
