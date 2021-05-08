package com.lec.lib.service;

import java.util.List;

import com.lec.lib.repo.DepartmentRepo;
import com.lec.lib.repo.DivisionRepo;
import com.lec.lib.repo.model.Department;
import com.lec.lib.repo.model.Division;

public class SchoolService {
	private static SchoolService instance;

	protected static DivisionRepo divRepo = DivisionRepo.getInstance();
	protected static DepartmentRepo depRepo = DepartmentRepo.getInstance();

	public static SchoolService getInstance() {
		if (instance == null) {
			instance = new SchoolService();
		}
		return instance;
	}

	public List<Division> readAllDiv() {
		return divRepo.readAll();
	}

	public List<Department> readAllDep() {
		return depRepo.readAll();
	}
}
