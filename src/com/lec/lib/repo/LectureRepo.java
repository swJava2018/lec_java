package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 학생의 수강하는 모든 과목 읽기
	 * 
	 * @param studentID
	 * @return
	 */
	public List<Lecture> readWithHistoryByStudentID(String studentID) {
		CriteriaBuilder builder = em.getCriteriaBuilder();

		// User 조회
		CriteriaQuery<User> query;
		{
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
