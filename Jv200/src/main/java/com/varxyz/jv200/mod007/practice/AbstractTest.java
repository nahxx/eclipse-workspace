package com.varxyz.jv200.mod007.practice;

public class AbstractTest {

	public static void main(String[] args) {
		Computer c1 = new Desktop();
		Computer c2 = new Notebook();
		c1.turnOff(); // Turn Off
		c1.turnOn(); // Turn On
		c2.turnOff(); // Turn Off
		c2.turnOn(); // 종료
		if(c2 instanceof Notebook) {
			Notebook n = (Notebook) c2; // 다운캐스팅
			n.setUser(); // Kim
		}
		System.out.println(c1.setOs()); // Samsung Computer
		System.out.println(c1.setSalary()); // 1000.0
		System.out.println(c2.setOs()); // MAC
		System.out.println(c2.setSalary()); // 800.0
	}

}
