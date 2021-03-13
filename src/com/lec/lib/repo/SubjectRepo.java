package com.lec.lib.repo;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.Subject;
import com.lec.lib.repo.model.User;

public class SubjectRepo extends BaseRepo {
	private static SubjectRepo instance;

	public static SubjectRepo getInstance() {
		if (instance == null) {
			instance = new SubjectRepo();
		}
		return instance;
	}

	public boolean register(String code, String name) {
		try {
			Subject subject = new Subject();
			subject.setCode(code);
			subject.setName(name);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(subject);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(String code, String name) {
		try {
			Subject subject = em.find(Subject.class, code);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			subject.setCode(code);
			subject.setName(name);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String code) {
		try {
			Subject subject = em.find(Subject.class, code);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(subject);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Subject read(String code) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Subject> cQuery = criteriaBuilder.createQuery(Subject.class);
		Root<Subject> from = cQuery.from(Subject.class);
		Predicate where = criteriaBuilder.equal(from.get("code"), code);
		cQuery.where(where);

		Query query = em.createQuery(cQuery);
		List<Subject> resultList = query.getResultList();

		if (resultList.size() == 1)
			return resultList.get(0);
		else
			return null;
	}

	public List<Subject> readAll() {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Subject> cQuery = criteriaBuilder.createQuery(Subject.class);
		cQuery.from(Subject.class);

		Query query = em.createQuery(cQuery);
		List<Subject> resultList = query.getResultList();

		if (resultList.size() > 0)
			return resultList;
		else
			return null;
	}
}