package com.varxyz.jv200.mod003;

public class MyDate {
	private int day;
	private int month;
	private int year;
	
	// 첫번째 생성자
	public MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	// 두번째 생성자
	public MyDate(MyDate date) {
		this.day = date.day;
		this.month = date.month;
		this.year = date.year;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public String toString() {
		return "day=" + day + ", month=" + month + ", year=" + year;
	}
	
	public MyDate addDays(int moreDays) {
		MyDate newDate = new MyDate(this); // 두번째 생성자 사용하여 객체 생성
		newDate.day = moreDays; // 기존의 day값에 새로 받은 moreDays 값을 더해줌
		// Not Yet Implemented: wrap around code...
		return newDate;
	}
}
