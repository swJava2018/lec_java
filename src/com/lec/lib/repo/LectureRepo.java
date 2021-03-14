package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

public class LectureRepo extends BaseRepo {
	private static LectureRepo instance;

	public static LectureRepo getInstance() {
		if (instance == null) {
			instance = new LectureRepo();
		}
		return instance;
	}

	public List<Lecture> readWithHistoryByStudentID(String studentID) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<User> cQuery = criteriaBuilder.createQuery(User.class);
		Root<User> from = cQuery.from(User.class);
		Predicate where = criteriaBuilder.equal(from.get("id"), studentID);
		cQuery.where(where);
		Query query = em.createQuery(cQuery);
		List<User> users = query.getResultList();
		if (users.size() != 1) {
			return new ArrayList<Lecture>();
		}

		List<Lecture> resultList = em.createQuery(
				"select lec from Lecture as lec right join LectureHistory as lecH on lec.code = lecH.lecture where lecH.student.user = :user",
				Lecture.class).setParameter("user", users.get(0)).getResultList();

		if (resultList.size() > 0) {
			return resultList;
		} else
			return new ArrayList<Lecture>();
	}
}
