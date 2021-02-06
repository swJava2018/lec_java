package com.lec.lib.api.impl;

import java.util.List;

import com.lec.lib.api.IAdmin;
import com.lec.lib.api.config.Permission;
import com.lec.lib.model.User;

public class AdminImpl extends UserImpl implements IAdmin {
	@Override
	public boolean register(String id, String name, String password, Permission role) {
		return db.register(id, name, password, role);
	}

	@Override
	public List<User> readAll() {
		return db.readAll();
	}
}
