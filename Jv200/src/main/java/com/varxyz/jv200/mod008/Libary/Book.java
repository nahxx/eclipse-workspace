package com.varxyz.jv200.mod008.Libary;

public class Book {
	private int serial;
	private String name;
	
	public Book() {
		
	}
	public Book(String name) {
		this.name = name;
//		serial++;
	}

	public String getName() {
		return name;
	}
	
	public void setSerial(int serial) {
		this.serial = serial;
	}
	
	public int getSerial() {
		return serial;
	}
	
}
