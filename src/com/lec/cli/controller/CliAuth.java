package com.lec.cli.controller;

import com.lec.lib.model.User;

public class CliAuth {
	private static CliAuth instance;
	private User loginUser;
	
	// Singleton Pattern
	public static CliAuth getInstance() {
		if(instance == null) {
			instance = new CliAuth();
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
