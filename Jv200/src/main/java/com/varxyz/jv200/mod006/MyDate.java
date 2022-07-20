package com.varxyz.jv200.mod006;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MyDate) {
			MyDate d = (MyDate) obj;
			if(d.day == day && d.month == month && d.year == year) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
//		MyDate d1 = new MyDate(1, 1, 2000);
//		MyDate d2 = new MyDate(1, 1, 2000);
//		boolean fleg = d1.equals(d2);
//		System.out.println(fleg);
	}
}
