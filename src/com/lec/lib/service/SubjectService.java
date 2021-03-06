package com.lec.lib.service;

import java.util.List;

import com.lec.lib.repo.SubjectRepo;
import com.lec.lib.repo.model.Subject;

public class SubjectService {
	private static SubjectService instance;
	protected static SubjectRepo db = SubjectRepo.getInstance();

	public static SubjectService getInstance() {
		if (instance == null) {
			instance = new SubjectService();
		}
		return instance;
	}

	public boolean register(String code, String name) {
		return db.register(code, name);
	}
	
	public Subject read(String code) {
		return db.read(code);
	}
	
	public List<Subject> readAll() {
		return db.readAll();
	}
	
	public boolean update(String code, String name) {
		return db.update(code, name);
	}
}
