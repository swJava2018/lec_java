package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.Subject;

public class SubjectRepo extends BaseRepo {
	private static SubjectRepo instance;

	public static SubjectRepo getInstance() {
		if (instance == null) {
			instance = new SubjectRepo();
		}
		return instance;
	}

	/**
	 * 과목 등록하기
	 * 
	 * @param code
	 * @param name
	 * @return
	 */
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

	/**
	 * 과목 갱신하기
	 * 
	 * @param code
	 * @param name
	 * @return
	 */
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

	/**
	 * 과목 삭제하기
	 * 
	 * @param code
	 * @return
	 */
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

	/**
	 * 과목 읽기
	 * 
	 * @param code
	 * @return
	 */
	public Subject read(String code) {
		CriteriaQuery<Subject> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Subject.class);
			Root<Subject> from = query.from(Subject.class);
			Predicate where = builder.equal(from.get("code"), code);
			query.where(where);
		}
		List<Subject> result = em.createQuery(query).getResultList();

		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}

	/**
	 * 모든 과목 읽기
	 * 
	 * @return
	 */
	public List<Subject> readAll() {
		CriteriaQuery<Subject> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Subject.class);
			query.from(Subject.class);
		}

		List<Subject> result = em.createQuery(query).getResultList();

		if (result.size() > 0)
			return result;
		else
			return new ArrayList<Subject>();
	}
}