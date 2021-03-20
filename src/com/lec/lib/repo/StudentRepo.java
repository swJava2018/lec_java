package com.lec.lib.repo;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

public class StudentRepo extends BaseRepo {
	private static StudentRepo instance;

	public static StudentRepo getInstance() {
		if (instance == null) {
			instance = new StudentRepo();
		}
		return instance;
	}

	/**
	 * 학생 등록하기
	 * 
	 * @param user
	 * @return
	 */
	public Student register(Student student) {
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(student);
			transaction.commit();

			return student;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 학생 읽기
	 * 
	 * @param id
	 * @return
	 */
	public Student read(String id) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		CriteriaQuery<Student> query;
		{
			query = builder.createQuery(Student.class);
			Root<Student> from = query.from(Student.class);
			Join<Student, User> join = from.join("user");
			Predicate where = builder.equal(join.get("id"), id);
			query.where(where);
		}

		List<Student> result = em.createQuery(query).getResultList();

		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}
}
