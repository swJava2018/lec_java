package com.lec.lib.api;

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

import com.lec.lib.model.User;

public class UserAPI implements IUserAPI {
	private static final String PERSISTENCE_UNIT_NAME = "h2";
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	protected static final EntityManager em = factory.createEntityManager();

//	private static UserAPI instance; 
//	
//	public static UserAPI getInstance() {
//		if(instance == null) {	
//			instance = new UserAPI();
//		}
//		return instance;
//	}

	@Override
	public boolean register(String id, String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User login(String id, String pwd) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where1 = criteriaBuilder.equal(from.get("id"), id);
		Predicate where2 = criteriaBuilder.equal(from.get("password"), pwd);
		Predicate whereFinal = criteriaBuilder.and(where1, where2);
		cQuery.where(whereFinal);
		
		Query query = em.createQuery(cQuery);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1) {
			return resultList.get(0);
		}
		else
			return null;
	}
	
	@Override
	public boolean logout() {
		return true;
	}

	@Override
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
	@Override
	public User read(String id) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where = criteriaBuilder.equal(from.get("id"), id);
		cQuery.where(where);
		
		Query query = em.createQuery(cQuery);
		List<User> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}

	@Override
	public List<User> readAll() {
		return null;
	}
}
