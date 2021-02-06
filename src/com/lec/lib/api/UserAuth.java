package com.lec.lib.api;

import com.lec.lib.api.config.Permission;
import com.lec.lib.api.impl.AdminImpl;
import com.lec.lib.api.impl.EmployeeImpl;
import com.lec.lib.api.impl.ProfessorImpl;
import com.lec.lib.api.impl.StudentImpl;
import com.lec.lib.model.User;
import com.lec.lib.service.UserDatabase;

public class UserAuth {
	private static UserAuth instance;
	private User user;
	private IUser userAPI;
	private static UserDatabase db = UserDatabase.getInstance();

	// Singleton Pattern
	public static UserAuth getInstance() {
		if (instance == null) {
			instance = new UserAuth();
		}
		return instance;
	}

	public boolean login(String id, String pwd) {
		// 로그인 사용자 준비
		User loginUser = db.login(id, pwd);
		if (loginUser == null) {
			System.out.println("login fail");
			return false;
		}
		user = loginUser;

		// 로그인 사용자 API 준비
		switch (user.getRole()) {
		case Student:
			userAPI = new StudentImpl();
			break;
		case Professor:
			userAPI = new ProfessorImpl();
			break;
		case Admin:
			userAPI = new AdminImpl();
			break;
		case Employee:
			userAPI = new EmployeeImpl();
			break;
		default:
			System.out.println("login fail");
			return false;
		}
		return true;
	}

	public boolean isLogin() {
		return (user != null) ? true : false;
	}

	public boolean hasAdminPermission() {
		Permission role = user.getRole();
		if (Permission.Admin.equals(role) || Permission.Employee.equals(role)) {
			return true;
		}
		return false;
	}

	public String getLoginName() {
		return user.getRole() + ":" + user.getId() + "(" + user.getName() + ")";
	}

	public User getUser() {
		return user;
	}

	public IUser getUserAPI() {
		return userAPI;
	}

	public boolean logout() {
		user = null;
		userAPI = null;
		return true;
	}
}
