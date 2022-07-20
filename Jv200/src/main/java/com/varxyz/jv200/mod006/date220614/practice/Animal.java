package com.varxyz.jv200.mod006.date220614.practice;

public class Animal {
	public String makeNoice() {
		return "";
	}
	public String color() {
		return "";
	}
	public void getChildMethod(Animal a) {
		if (a instanceof Dog) {
			Dog d = (Dog) a;
			System.out.println(d.eat());
		} else if (a instanceof Cat) {
			Cat c = (Cat) a;
			System.out.println(c.like() + " " + c.color());
		}
	}
}
