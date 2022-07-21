package com.varxyz.jvx330.di.example4.ex1;

public class DmsNamingServiceImpl implements NamingService {

	@Override
	public Object lookup(String name) {
		return "DMS: " + name;
	}

}
