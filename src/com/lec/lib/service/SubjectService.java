package com.lec.lib.service;

import java.util.List;

import com.lec.lib.repo.SubjectRepo;
import com.lec.lib.repo.model.Subject;

public class SubjectService {
	private static SubjectService instance;
	protected static SubjectRepo repo = SubjectRepo.getInstance();

	public static SubjectService getInstance() {
		if (instance == null) {
			instance = new SubjectService();
		}
		return instance;
	}

	public boolean register(String code, String name) {
		return repo.register(code, name);
	}

	public Subject read(String code) {
		return repo.read(code);
	}

	public List<Subject> readAll() {
		return repo.readAll();
	}

	public boolean update(String code, String name) {
		return repo.update(code, name);
	}

	public boolean delete(String code) {
		return repo.delete(code);
	}
}
