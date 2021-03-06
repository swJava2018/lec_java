package com.lec.lib.repo;

import javax.persistence.EntityTransaction;

import com.lec.lib.repo.model.Subject;

public class SubjectRepo extends BaseRepo {
	private static SubjectRepo instance;

	public static SubjectRepo getInstance() {
		if (instance == null) {
			instance = new SubjectRepo();
		}
		return instance;
	}

	public boolean registerSubject(String code, String name) {
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
}