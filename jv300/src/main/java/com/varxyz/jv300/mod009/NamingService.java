package com.varxyz.jv300.mod009;

import java.util.HashMap;
import java.util.Map;

public class NamingService {
	private static NamingService obj = new NamingService();
	private Map<String, Object> nameValuePairs;
	
	private NamingService() {
		nameValuePairs = new HashMap<String, Object>();
	}
	
	public static NamingService getInstance() {
		return obj;
	}
	
	public void setAttribute(String name, Object obj) {
		if(!nameValuePairs.containsKey(name)) {
			nameValuePairs.put(name, obj);
		} else {
			throw new IllegalArgumentException("This name, " + name + ", is already is use.");
		}
	}
	
	public Object getAttribute(String name) {
		return nameValuePairs.get(name);
	}
	
	public void removeAttribute(String name) {
		nameValuePairs.remove(name);
	}
}
