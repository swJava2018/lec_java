package com.lec.cli.controller;

import com.lec.lib.api.IAdmin;
import com.lec.lib.api.UserAuth;
import com.lec.lib.model.User;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParentCommand;

@Command(name = "read")
public class CommonRead implements Runnable {
	@Option(names = { "-a", "--all" }, description = "The All Users")
	private boolean isAll;

	@ParentCommand
	CliCommands parent;

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
				for (User user : ((IAdmin) auth.getUserAPI()).readAll()) {
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
