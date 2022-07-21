package com.varxyz.jvx330.di.example2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
// 모든 아규먼트를 가지는 생성자 만들어주는 어노테이션
public class Date {
	private int year;
	private int month;
	private int day;
	
	public String toString() {
		return year + "-" + month + "-" + day;
	}
	
	public int hashCode() {
		return (day ^ month ^ year);
	}
}
