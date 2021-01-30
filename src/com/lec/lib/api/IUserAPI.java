package com.lec.lib.api;

import java.util.List;

import com.lec.lib.model.User;

public interface IUserAPI {
	// 회원가입 
	boolean register(String id, String name, String password);
	
	// 로그인 
	User login(String id, String pwd);
	
	// 로그아웃 
	boolean logout();
	
	// 회원정보 수정 
	boolean update(String id, String name, String password, String address);
	
	// 회원정보 읽기 
	User read(String id);
	
	// 모든 회원정보 읽기 
	List<User> readAll();
}
