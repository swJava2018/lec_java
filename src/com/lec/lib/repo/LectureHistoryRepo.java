package com.lec.lib.repo;

import java.util.List;

import com.lec.lib.repo.model.LectureHistory;
import com.lec.lib.repo.model.QLectureHistory;
import com.querydsl.jpa.impl.JPAQuery;

public class LectureHistoryRepo extends BaseRepo {
	private static LectureHistoryRepo instance;

	public static LectureHistoryRepo getInstance() {
		if (instance == null) {
			instance = new LectureHistoryRepo();
		}
		return instance;
	}

	/**
	 * 학생의 수강하는 모든 강의 내역 읽기
	 * 
	 * @param studentID
	 * @return
	 */
	public List<LectureHistory> readLectureHistoryByID(String id) {
		QLectureHistory lecH = QLectureHistory.lectureHistory;
		List<LectureHistory> result = new JPAQuery<LectureHistory>(em).from(lecH).where(lecH.student.user.id.eq(id))
				.fetch();
		return result;
	}
}
