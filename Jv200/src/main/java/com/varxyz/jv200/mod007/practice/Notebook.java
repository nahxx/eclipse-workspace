package com.varxyz.jv200.mod007.practice;

public class Notebook extends Computer {
	@Override
	public String setOs() {
		return "MAC";
	}
	
	@Override
	public double setSalary() {
		return 800.0;
	}
	
	@Override
	public void turnOn() {
		System.out.println("종료");
	}
	
	public void setUser() {
		System.out.println("Kim");
	}
}
