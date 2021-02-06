package com.lec.lib.api;

import com.lec.lib.model.User;

public interface IUser {
	// 회원정보 수정
	boolean update(String id, String name, String password, String address);

	// 회원정보 읽기
	User read(String id);
}
