package com.varxyz.jv300.mod006;

import java.util.*;

public class UserService {
	private static final UserService service = new UserService();
	List<User> userList = new ArrayList<>();
	
	public static UserService getInstance() {
		return service;
	}
	public void addUser(User user) {
		userList.add(user);
	}

}
