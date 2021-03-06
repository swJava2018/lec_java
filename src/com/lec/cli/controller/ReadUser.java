package com.lec.cli.controller;

import com.lec.lib.auth.UserAuth;
import com.lec.lib.repo.model.User;
import com.lec.lib.service.UserService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "read")
public class ReadUser implements Runnable {
	@Option(names = { "-a", "--all" }, description = "The All Users")
	private boolean isAll;

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

		if (isAll) {
			if (auth.hasAdminPermission()) {
				// 모든 사용자 정보 출력
				for (User user : userService.readAll()) {
					parent.out.println(user.toString());
				}
			} else {
				parent.out.println("it's denided");
			}
			return;
		}

		// 사용자 정보 출력
		User user = auth.getUser();
		parent.out.println(user.toString());
	}
}
