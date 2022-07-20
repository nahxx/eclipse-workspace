package com.varxyz.jv300.mod010;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private static final UserService service = new UserService();
	UserDao ud = new UserDao();
	
	public static UserService getInstance() {
		return service;
	}
	
	public void addUser(User user) {
		ud.addUser(user);
	}
	
	public List<User> getAllUsers() {
		List<User> userList = ud.findAllUsers();
		return userList;
	}
	
	public User getUser(String userId) {
		User user = ud.findUser(userId);
		return user;
	}
	
	public void updateUser(User user) {
		ud.updateUserInfo(user);
	}
}
