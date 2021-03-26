package com.lec.lib.service;

import java.util.List;

import com.lec.cli.input.UserInfoInput;
import com.lec.lib.auth.Permission;
import com.lec.lib.repo.StudentRepo;
import com.lec.lib.repo.UserInfoRepo;
import com.lec.lib.repo.model.Department;
import com.lec.lib.repo.model.Division;
import com.lec.lib.repo.model.Professor;
import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

public class UserService {
	private static UserService instance;
	protected static UserInfoRepo repo = UserInfoRepo.getInstance();
	protected static StudentRepo studentRepo = StudentRepo.getInstance();

	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	public boolean register(String id, String name, String password, String role, UserInfoInput info) {
		Permission p = Permission.valueOfType(role);
		if (p == null) {
			return false;
		}

		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setRole(p);

		if (info == null) {
			if (repo.register(id, name, password, p) == null) {
				return false;
			}
			return true;
		}

		switch (p) {
		case STUDENT: {
			Student student = new Student();
			student.setUser(user);

			Department dep = new Department();
			dep.setCode(info.getDepCode());
			student.setDep(dep);

			Division div = new Division();
			div.setCode(info.getDivCode());
			student.setDiv(div);

			student.setStatus(info.getStatus());
			student.setDisability(info.getDisability());

			if (repo.registerWithStudent(user, student) == null) {
				return false;
			}
		}
		case PROFESSOR: {
			Professor professor = new Professor();
			professor.setUser(user);

			Department dep = new Department();
			dep.setCode(info.getDepCode());
			professor.setDep(dep);

			Division div = new Division();
			div.setCode(info.getDivCode());
			professor.setDiv(div);

			if (repo.registerWithProfessor(user, professor) == null) {
				return false;
			}
		}
		default:
			break;
		}
		return true;
	}

	public boolean update(String id, String name, String password, String address) {
		return repo.update(id, name, password, address);
	}

	public boolean delete(String id) {
		return repo.delete(id);
	}

	public User read(String id) {
		return repo.read(id);
	}

	public List<User> readAll() {
		return repo.readAll();
	}
}