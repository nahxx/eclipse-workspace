package com.varxyz.jv200.mod008.practice;

public abstract class Account {
	private String accountNum;
	private double balance;
	
	public abstract double withDraw(double amt) throws Exception;
}
