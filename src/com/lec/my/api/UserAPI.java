package com.lec.my.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lec.my.cli.CliAuth;
import com.lec.my.model.User;

public class UserAPI {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static final EntityManager em = factory.createEntityManager();

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

	@SuppressWarnings("unchecked")
	public boolean login(String id, String pwd) {
		Query query = em.createQuery("select t from User t where id = " + id + " and password = " + pwd);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1) {
			CliAuth.getInstance().login(resultList.get(0));
			return true;
		}
		else
			return false;
	}

	public boolean update(String id, String name, String password, String address) {
		try {
			User user = em.find(User.class, id);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			user.setName(name);
			user.setPassword(password);
			user.setAddress(address);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public User read(String id) {
		Query query = em.createQuery("select u from User u where id = " + id);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}

	public List<User> readAll() {
		return null;
	}
}
