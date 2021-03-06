package com.lec.lib.repo;

import javax.persistence.EntityTransaction;

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

	public Student register(User user) {
		try {
			Student student = new Student();
			student.setUser(user);

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
}
