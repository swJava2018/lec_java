package com.lec.lib.service;

import java.util.List;

import com.lec.lib.api.config.Permission;
import com.lec.lib.repo.UserInfoRepo;
import com.lec.lib.repo.model.User;

public class UserService {
	private static UserService instance;
	protected static UserInfoRepo db = UserInfoRepo.getInstance();

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	public boolean register(String id, String name, String password, Permission role) {
		return db.register(id, name, password, role);
	}
	
	public boolean update(String id, String name, String password, String address) {
		return db.update(id, name, password, address);
	}

	public User read(String id) {
		return db.read(id);
	}
	
	public List<User> readAll() {
		return db.readAll();
	}
}