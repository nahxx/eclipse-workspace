package com.varxyz.jvx330.di.example5.ex2;

public class SessionCartService implements CartService {

	@Override
	public void addItem() {
		System.out.println("SessionCartService: addItem() is called");
	}

}
