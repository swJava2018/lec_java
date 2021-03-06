package com.lec.lib.service;

import com.lec.lib.repo.SubjectRepo;

public class SubjectService {
	private static SubjectService instance;
	protected static SubjectRepo db = SubjectRepo.getInstance();

	public static SubjectService getInstance() {
		if (instance == null) {
			instance = new SubjectService();
		}
		return instance;
	}

	public boolean registerSubejct(String code, String name) {
		return db.registerSubject(code, name);
	}
}
