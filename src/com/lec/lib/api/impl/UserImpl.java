package com.lec.lib.api.impl;

import com.lec.lib.api.IUser;
import com.lec.lib.model.User;
import com.lec.lib.service.UserDatabase;

abstract public class UserImpl implements IUser {
	protected static UserDatabase db = UserDatabase.getInstance();

	@Override
	public boolean update(String id, String name, String password, String address) {
		return db.update(id, name, password, address);
	}

	@Override
	public User read(String id) {
		return db.read(id);
	}
}
