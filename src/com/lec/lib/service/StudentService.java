package com.lec.lib.service;

import java.util.List;

import com.lec.lib.repo.LectureHistoryRepo;
import com.lec.lib.repo.LectureRepo;
import com.lec.lib.repo.StudentRepo;
import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.LectureHistory;
import com.lec.lib.repo.model.Student;

public class StudentService {
	private static StudentService instance;

	protected static LectureHistoryRepo lhRepo = LectureHistoryRepo.getInstance();
	protected static LectureRepo lRepo = LectureRepo.getInstance();
	protected static StudentRepo sRepo = StudentRepo.getInstance();

	public static StudentService getInstance() {
		if (instance == null) {
			instance = new StudentService();
		}
		return instance;
	}

	public Student read(String studentID) {
		return sRepo.read(studentID);
	}

	public List<Lecture> readByStudentID(String studentID) {
		return lRepo.readWithHistoryByStudentID(studentID);
	}
	
	public List<LectureHistory> readLectureHistoryByID(String studentID) {
		return lhRepo.readLectureHistoryByID(studentID);
	}
}
