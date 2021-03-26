package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.User;

public class LectureRepo extends BaseRepo {
	private static LectureRepo instance;

	public static LectureRepo getInstance() {
		if (instance == null) {
			instance = new LectureRepo();
		}
		return instance;
	}

	public boolean register(String code, Lecture lecture) {
		try {
			Lecture lec = new Lecture();
			lec.setCode(code);
			lec.setDescription(lecture.getDescription());
			lec.setSemester(lecture.getSemester());
			lec.setTime(lecture.getTime());
			lec.setYear(lecture.getYear());
			lec.setProfessor(lecture.getProfessor());
			lec.setSubject(lecture.getSubject());

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(lec);
			transaction.commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(String code, Lecture lecture) {
		try {
			Lecture lec = em.find(Lecture.class, code);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			if (!lecture.getDescription().isEmpty())
				lec.setDescription(lecture.getDescription());
			if (lecture.getSemester() != 0)
				lec.setSemester(lecture.getSemester());
			if (!lecture.getTime().isEmpty())
				lec.setTime(lecture.getTime());
			if (lecture.getYear() != 0)
				lec.setYear(lecture.getYear());
			if (lecture.getProfessor() != null)
				lec.setProfessor(lecture.getProfessor());
			if (lecture.getSubject() != null)
				lec.setSubject(lecture.getSubject());
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String code) {
		try {
			Lecture lecture = em.find(Lecture.class, code);

			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(lecture);
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Lecture read(String code) {
		CriteriaQuery<Lecture> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Lecture.class);
			Root<Lecture> from = query.from(Lecture.class);
			Predicate where = builder.equal(from.get("code"), code);
			query.where(where);
		}

		List<Lecture> result = em.createQuery(query).getResultList();

		if (result.size() == 1)
			return result.get(0);
		else
			return null;
	}

	public List<Lecture> readAll() {
		CriteriaQuery<Lecture> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Lecture.class);
			query.from(Lecture.class);
		}

		List<Lecture> result = em.createQuery(query).getResultList();

		if (result.size() > 0)
			return result;
		else
			return new ArrayList<Lecture>();
	}

	/**
	 * 학생의 수강하는 모든 과목 읽기
	 * 
	 * @param studentID
	 * @return
	 */
	public List<Lecture> readWithHistoryByStudentID(String studentID) {
		// User 조회
		CriteriaQuery<User> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(User.class);
			Root<User> from = query.from(User.class);
			Predicate where = builder.equal(from.get("id"), studentID);
			query.where(where);
		}
		List<User> users = em.createQuery(query).getResultList();
		if (users.size() != 1) {
			return new ArrayList<Lecture>();
		}

		// Lecture 조회
		List<Lecture> result = em.createQuery(
				"select lec from Lecture as lec right join LectureHistory as lecH on lec.code = lecH.lecture where lecH.student.user = :user",
				Lecture.class).setParameter("user", users.get(0)).getResultList();
		if (result.size() > 0) {
			return result;
		} else
			return new ArrayList<Lecture>();
	}
}
