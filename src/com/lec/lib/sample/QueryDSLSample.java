package com.lec.lib.sample;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.QUser;
import com.lec.lib.repo.model.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;

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
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			em.flush();
			transaction.commit();
				
			// select
			User readUser = read("test_id");
			System.out.println(readUser.toString());
			
			// update
			update("test_id", "update name", null);
			readUser = read("test_id");
			System.out.println(readUser.toString());

			// delete
			delete("test_id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<User> readAll(String id) {
		QUser user = QUser.user;

		List<User> result = new JPAQuery<User>(em).from(user).where(user.id.eq(id)).fetch();
		return result;
	}
	
	private static User read(String id) {
		QUser user = QUser.user;

		User result = new JPAQuery<User>(em)
				.from(user)
				.where(user.id.eq(id))
				.fetchOne();
		return result;
	}

	private static void update(String id, String name, String password) {
		QUser user = QUser.user;

//		em.getTransaction().begin();
//		new JPAUpdateClause(em, user)
//				.set(user.name, name)
//				.where(user.id.eq(id))
//				.execute();
//		em.getTransaction().commit();
		
		JPAUpdateClause update = new JPAUpdateClause(em, user);
		
		if (name != null) {
			update.set(user.name, name);
		} else if (password != null) {
			update.set(user.password, password);
		}
		
		update.where(user.id.eq(id)).execute();
		em.refresh(user);
	}

	public static void delete(String id) {
		User user = em.find(User.class, id);

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(user);
		transaction.commit();
	}
}
