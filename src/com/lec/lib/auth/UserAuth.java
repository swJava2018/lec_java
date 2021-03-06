package com.lec.lib.auth;

import com.lec.lib.repo.UserInfoRepo;
import com.lec.lib.repo.model.User;

public class UserAuth {
	private static UserAuth instance;
	private User user;
	private static UserInfoRepo db = UserInfoRepo.getInstance();

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
		return true;
	}

	public boolean isLogin() {
		return (user != null) ? true : false;
	}

	public boolean hasAdminPermission() {
		Permission role = user.getRole();
		if (Permission.ADMIN.equals(role) || Permission.EMPLOYEE.equals(role)) {
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

	public boolean logout() {
		user = null;
		return true;
	}
}
