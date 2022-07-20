package com.varxyz.jv300.mod011;

import java.util.List;

public class UserService {
	private static final UserService service = new UserService();
	UserDao userDao = new UserDao();
	
	public static UserService getInstance() {
		return service;
	}
	
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	public List<User> getAllUsers() {
		List<User> userList = userDao.findAllUsers();
		return userList;
	}
	
	public User getUser(String userId) {
		User user = userDao.findUser(userId);
		return user;
	}
	
	public void updateUser(User user) {
		userDao.updateUserInfo(user);
	}

	public boolean isValidUser(String userId, String passwd) {
		if(!userDao.isValidUser(userId, passwd)) {
			return false;
		}
		return true;
	}
}
