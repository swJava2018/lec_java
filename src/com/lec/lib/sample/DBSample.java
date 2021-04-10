package com.lec.lib.sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.User;

public class DBSample {
	private static final String PERSISTENCE_UNIT_NAME = "mysql";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static final EntityManager em = factory.createEntityManager();

	public static void main(String[] args) {
//		try {
//			User user = new User();
//			user.setId("test_id");
//			user.setName("test_name");
//			user.setPassword("test_password");
//			user.setRole(Permission.STUDENT);
//
//			// insert
//			register(user);
//
//			// select
//			List<User> users = read("test_id");
//			for (User u : users) {
//				System.out.println(u.toString());
//			}
//
//			// delete
//			delete("test_id");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			// select
			List<Lecture> lectures = readAll("prof001");
			for (Lecture lec : lectures) {
				System.out.println(lec.toString());
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

	@SuppressWarnings("unchecked")
	private static List<User> read(String id) {
		Query query = em.createQuery("select u from User u where u.id = '" + id + "'");
		List<User> result = query.getResultList();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private static List<Lecture> readAll(String professorId) {
		Query query = em.createQuery("select lec from Lecture lec where lec.professor.user.id = '" + professorId + "'");
		List<Lecture> result = query.getResultList();
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
