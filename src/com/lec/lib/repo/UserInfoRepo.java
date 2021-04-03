package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.Professor;
import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

public class UserInfoRepo extends BaseRepo {
	private static UserInfoRepo instance;

	public static UserInfoRepo getInstance() {
		if (instance == null) {
			instance = new UserInfoRepo();
		}
		return instance;
	}

	/**
	 * 사용자 등록하기
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param role
	 * @return
	 */
	public User register(String id, String name, String password, Permission role) {
		try {
			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			transaction.commit();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User registerWithStudent(User user, Student student) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			em.persist(student);
			transaction.commit();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User registerWithProfessor(User user, Professor professor) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(user);
			em.persist(professor);
			transaction.commit();

			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 사용자 수정하기
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param address
	 * @return
	 */
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

	/**
	 * 사용자 로그인하기
	 * 
	 * @param id
	 * @param pwd
	 * @return
	 */
	public User login(String id, String pwd) {
		CriteriaQuery<User> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(User.class);
			Root<User> from = query.from(User.class);
			Predicate where1 = builder.equal(from.get("id"), id);
			Predicate where2 = builder.equal(from.get("password"), pwd);
			Predicate whereFinal = builder.and(where1, where2);
			query.where(whereFinal);
		}

		List<User> result = em.createQuery(query).getResultList();

		if (result.size() == 1) {
			return result.get(0);
		} else
			return null;
	}

	/**
	 * 사용자 삭제하기
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(String id) {
		try {
			User user = em.find(User.class, id);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(user);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 사용자 읽기
	 * 
	 * @param id
	 * @return
	 */
	public User read(String id) {
		CriteriaQuery<User> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(User.class);
			Root<User> from = query.from(User.class);
			Predicate where = builder.equal(from.get("id"), id);
			query.where(where);
		}

		List<User> result = em.createQuery(query).getResultList();

		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}

	/**
	 * 모든 사용자 읽기
	 * 
	 * @return
	 */
	public List<User> readAll(Permission role) {
		CriteriaQuery<User> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(User.class);
			Root<User> from = query.from(User.class);
			if (role != null) {
				Predicate where = builder.equal(from.get("role"), role);
				query.where(where);
			}
		}

		List<User> result = em.createQuery(query).getResultList();

		if (result.size() > 0)
			return result;
		else
			return new ArrayList<User>();
	}
}
