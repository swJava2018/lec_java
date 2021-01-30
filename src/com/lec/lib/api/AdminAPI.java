package com.lec.lib.api;

import javax.persistence.EntityTransaction;

import com.lec.lib.model.User;

public class AdminAPI extends UserAPI {
	@Override
	public boolean register(String id, String name, String password) {
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setRole("admin");

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
