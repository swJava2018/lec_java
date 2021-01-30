package com.lec.lib.api;

import javax.persistence.EntityTransaction;

import com.lec.lib.model.User;

public class StudentAPI extends UserAPI {
	@Override
	public boolean register(String id, String name, String password) {
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setRole("student");

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
