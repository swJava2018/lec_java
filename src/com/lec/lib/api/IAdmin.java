package com.lec.lib.api;

import java.util.List;

import com.lec.lib.api.config.Permission;
import com.lec.lib.model.User;

public interface IAdmin {
	// 회원 등록
	boolean register(String id, String name, String password, Permission role);

	// 모든 회원정보 읽기
	List<User> readAll();
}
