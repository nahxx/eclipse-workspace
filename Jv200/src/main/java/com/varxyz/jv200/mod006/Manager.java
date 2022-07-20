package com.varxyz.jv200.mod006;

public class Manager extends Employee {
	protected String department;
	
	// method overriding
	@Override
	public String getDetails() {
		return super.getDetails() + "\nDepartment: " + department;
	}
}
