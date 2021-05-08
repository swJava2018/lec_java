package com.lec.lib.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.lec.lib.repo.model.Division;

public class DivisionRepo extends BaseRepo {
	private static DivisionRepo instance;

	public static DivisionRepo getInstance() {
		if (instance == null) {
			instance = new DivisionRepo();
		}
		return instance;
	}

	public List<Division> readAll() {
		CriteriaQuery<Division> query;
		{
			CriteriaBuilder builder = em.getCriteriaBuilder();
			query = builder.createQuery(Division.class);
			query.from(Division.class);
		}

		List<Division> result = em.createQuery(query).getResultList();

		if (result.size() > 0)
			return result;
		else
			return new ArrayList<Division>();
	}
}
