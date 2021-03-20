package com.lec.lib.repo;

public class LectureHistoryRepo extends BaseRepo {
	private static LectureHistoryRepo instance;

	public static LectureHistoryRepo getInstance() {
		if (instance == null) {
			instance = new LectureHistoryRepo();
		}
		return instance;
	}

//	public List<LectureHistory> readLectureTimeByStudentID(String studentID) {
//		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//
////		CriteriaQuery<Tuple> cQuery = criteriaBuilder.createTupleQuery();
////		Root<LectureHistory> lecH = cQuery.from(LectureHistory.class);
////		Join<LectureHistory, Lecture> lec = lecH.join("lecture", JoinType.INNER);
////		cQuery.multiselect(lecH.alias("lecH"), lec.alias("lec"))
////				.where(criteriaBuilder.equal(lecH.get("student"), studentID));
////
////		TypedQuery<Tuple> tQuery = em.createQuery(cQuery);
////		List<Tuple> resultList = tQuery.getResultList();
//
//		List<LectureHistory> resultList = em.createQuery("from LectureHistory as lecH left join Lecture as lec on lecH.lecture_code = lec.code where lecH.student.id = :student_id", LectureHistory.class)
//				.setParameter("student_id", studentID)
//				.getResultList();
//		
//
//		if (resultList.size() > 0) {
////			List<LectureHistory> lecHList = new ArrayList<LectureHistory>();
////			for (LectureHistory tuple : resultList) {
////				LectureHistory lecHR = tuple.get("lecH", LectureHistory.class);
////				Lecture lecR = tuple.get("lec", Lecture.class);
////				lecHList.add(lecHR);
////			}
//			return resultList;
//		} else
//			return new ArrayList<LectureHistory>();
//	}
}
