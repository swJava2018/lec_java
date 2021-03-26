package com.lec.lib.sample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.User;

public class DBSample2 {
	private static final String PERSISTENCE_UNIT_NAME = "mysql";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static final EntityManager em = factory.createEntityManager();

	public static void main(String[] args) {
		try {
			User user = new User();
			user.setId("test_id1");
			user.setName("test_name1");

			User user2 = new User();
			user2.setId("test_id2");
			user2.setName("test_name2");

			// insert
			register(user);
			register(user2);

			// update
			update("test_id1", "update_name1");
			update("test_id2", "update_name2");

			// select
			List<User> users = read("test_id1", "test_id2");
			for (User u : users) {
				System.out.println(u.toString());
			}

			// delete
			delete("test_id1");
			delete("test_id2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void register(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.createNativeQuery("INSERT INTO user (id, name) VALUES (?,?)").setParameter(1, user.getId())
				.setParameter(2, user.getName()).executeUpdate();
		transaction.commit();
	}

	private static void update(String id, String name) {
		User user = em.find(User.class, id);

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		user.setName(name);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	private static List<User> read(String id1, String id2) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> cQuery = builder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where1 = builder.equal(from.get("id"), id1);
		Predicate where2 = builder.equal(from.get("id"), id2);
		Predicate whereFinal = builder.or(where1, where2);
		cQuery.where(whereFinal);

		Query query = em.createQuery(cQuery);
		List<User> result = query.getResultList();
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
