package com.varxyz.jv200.mod006;

import java.util.Date;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "유비";
		e.salary = 500.0;
//		e.birthDate = new Date();
		String detail = e.getDetails();
		System.out.println(detail);
//		System.out.println(e.birthDate);
		System.out.println();
		
		Manager m1 = new Manager();
		m1.name = e.name;
		m1.salary = e.salary;
		m1.department = "인사부";
		System.out.println(m1.getDetails());
		System.out.println();
		
		Manager m2 = new Manager();
		m2.name = "관우";
		m2.salary = 400.0;
		m2.department = "관리부";
		System.out.println(m2.getDetails());
		System.out.println();
		
		Manager m3 = new Manager();
		m3.name = "장비";
		m3.salary = 300.0;
		m3.department = "영업부";
		System.out.println(m3.getDetails());
		System.out.println();
		
		Director d = new Director();
		d.name = "조조";
		d.salary = 1000.0;
		d.department = "기획부";
		System.out.println(d.getDetails());
		System.out.println();
		
		Engineer en = new Engineer();
		en.name = "조자룡";
		en.salary = 300.0;
		System.out.println(en.getDetails());
	}

}
