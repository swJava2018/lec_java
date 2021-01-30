package com.lec.lib.api;

import com.lec.lib.model.User;

public class UserAuth {
	private static UserAuth instance;
	private User loginUser;
	private UserAPI loginAPI;
	
	// Singleton Pattern
	public static UserAuth getInstance() {
		if(instance == null) {
			instance = new UserAuth();
		}
		return instance;
	}
	
	public void login(User user) {
		this.loginUser = user;
		switch(user.getRole()) {
		case "student": 
			loginAPI = new StudentAPI(); break;
		case "professor": 
			loginAPI = new ProfessorAPI(); break;
		case "admin": 
			loginAPI = new AdminAPI(); break;
		case "employee": 
			loginAPI = new EmployeeAPI(); break;
		default: break;
		}
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
	
	public UserAPI getUserAPI() {
		return loginAPI;
	}
	
	public void logout() {
		loginUser = null;
		loginAPI = null;
	}
}
