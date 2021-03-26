package com.lec.lib.sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.QUser;
import com.lec.lib.repo.model.User;
import com.querydsl.jpa.impl.JPAQuery;

public class QueryDSLSample {
	private static final String PERSISTENCE_UNIT_NAME = "mysql";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static final EntityManager em = factory.createEntityManager();

	public static void main(String[] args) {
		try {
			User user = new User();
			user.setId("test_id");
			user.setName("test_name");
			user.setPassword("test_password");
			user.setRole(Permission.STUDENT);

			// insert
			register(user);

			// select
			List<User> users = read("test_id");
			for (User u : users) {
				System.out.println(u.toString());
			}

			// delete
			delete("test_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void register(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(user);
		transaction.commit();
	}

	private static List<User> read(String id) {
		QUser user = QUser.user;

		List<User> result = new JPAQuery<User>(em).from(user).where(user.id.eq(id)).fetch();
		return result;
	}

	public static void delete(String id) {
		User user = em.find(User.class, id);

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(user);
		transaction.commit();
	}
}
