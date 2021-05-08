package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.lec.lib.repo.model.Department;

public class DepartmentRepo extends BaseRepo {
	private static DepartmentRepo instance;
	
	public static DepartmentRepo getInstance() {
		if (instance == null) {
			instance = new DepartmentRepo();
		}
		return instance;
	}

	public List<Department> readAll() {
		CriteriaQuery<Department> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Department.class);
			query.from(Department.class);
		}

		List<Department> result = em.createQuery(query).getResultList();

		if (result.size() > 0)
			return result;
		else
			return new ArrayList<Department>();
	}
}
