package com.lec.cli.controller;

import com.lec.lib.auth.UserAuth;
import com.lec.lib.service.UserService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "update")
public class UpdateUser implements Runnable {
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

		// 사용자 정보 갱신
		if (userService.update(auth.getUser().getId(), name, password, address)) {
			parent.out.println("update success");
		} else {
			parent.out.println("update fail");
		}
	}
}
