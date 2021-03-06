package com.lec.cli.controller;

import com.lec.lib.api.config.Permission;
import com.lec.lib.auth.UserAuth;
import com.lec.lib.service.UserService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "register")
public class RegisterUser implements Runnable {
	@Parameters(paramLabel = "Role", description = "The role")
	private String role;

	@Option(names = { "-id" }, description = "The student ID")
	private String id;

	@Option(names = { "-n", "--name" }, description = "The student Name")
	private String name;

	@Option(names = { "-p", "--password" }, description = "The student Password")
	private String password;

	@Option(names = { "-a", "--address" }, description = "The student Address")
	private String address;

	@ParentCommand
	CliCommands parent;

	private UserService userService = UserService.getInstance();
	
	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}

		// 권한 확인
		if (!auth.hasAdminPermission()) {
			parent.out.println("your account have not register permission");
			return;
		}

		// 입력 내용 확인
		Permission p = Permission.valueOfType(role);
		if (p == null) {
			parent.out.println("role is wrong");
			return;
		}

		// 사용자 추가
		if (userService.register(id, name, password, p)) {
			parent.out.println("register success");
		} else {
			parent.out.println("register fail");
		}
	}
}
