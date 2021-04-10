package com.lec.lib.service;

import java.util.List;

import com.lec.lib.repo.LectureRepo;
import com.lec.lib.repo.model.Lecture;

public class LectureService {
	private static LectureService instance;
	protected static LectureRepo lectureRepo = LectureRepo.getInstance();

	public static LectureService getInstance() {
		if (instance == null) {
			instance = new LectureService();
		}
		return instance;
	}

	public boolean register(String code, Lecture lecture) {
		return lectureRepo.register(code, lecture);
	}

	public boolean update(String code, Lecture lecture) {
		return lectureRepo.update(code, lecture);
	}

	public boolean delete(String code) {
		return lectureRepo.delete(code);
	}

	public Lecture read(String code) {
		return lectureRepo.read(code);
	}

	public List<Lecture> readAll() {
		return lectureRepo.readAll();
	}
}
