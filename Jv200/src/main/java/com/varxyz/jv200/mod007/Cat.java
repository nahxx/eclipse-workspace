package com.varxyz.jv200.mod007;

public class Cat extends Animal {
	public String type = "포유류";
	public boolean eatable = false;
	
	@Override
	public void makeSound() {
		System.out.println("야옹");
	}
	
}
