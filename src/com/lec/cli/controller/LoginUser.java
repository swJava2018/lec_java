package com.lec.cli.controller;

import com.lec.lib.auth.UserAuth;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "login")
public class LoginUser implements Runnable {
	@Parameters(paramLabel = "ID", description = "The ID", index = "0")
	private String id;

	@Parameters(paramLabel = "Password", description = "The Password", index = "1")
	private String password;

	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();

		// 로그인 확인
		if (auth.isLogin()) {
			parent.out.println("it's need to logout");
			return;
		}

		// 로그인
		if (!auth.login(id, password)) {
			parent.out.println("fail to login");
			return;
		}
	}
}
