package com.lec.lib.api;

import com.lec.lib.model.User;

public class UserAuth {
	private static UserAuth instance;
	private User loginUser;
	
	// Singleton Pattern
	public static UserAuth getInstance() {
		if(instance == null) {
			instance = new UserAuth();
		}
		return instance;
	}
	
	public void login(User user) {
		this.loginUser = user;
	}
	
	public boolean isLogin() {
		return (loginUser != null) ? true : false;
	}
	
	public String getLoginName() {
		return loginUser.getName();
	}
	
	public User getUser() {
		return loginUser;
	}
	
	public void logout() {
		loginUser = null;
	}
}
