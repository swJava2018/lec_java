package com.lec.lib.service;

import java.util.List;

import com.lec.lib.auth.Permission;
import com.lec.lib.repo.UserInfoRepo;
import com.lec.lib.repo.model.User;

public class UserService {
	private static UserService instance;
	protected static UserInfoRepo repo = UserInfoRepo.getInstance();

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public boolean register(String id, String name, String password, String role) {
		Permission p = Permission.valueOfType(role);
		if (p == null) {
			return false;
		}

		User user = repo.register(id, name, password, p);
		if (user == null) {
			return false;
		}

		return true;
	}

	public boolean update(String id, String name, String password, String address) {
		return repo.update(id, name, password, address);
	}

	public boolean delete(String id) {
		return repo.delete(id);
	}

	public User read(String id) {
		return repo.read(id);
	}

	public List<User> readAll() {
		return repo.readAll();
	}
}