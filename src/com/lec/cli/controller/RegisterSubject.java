package com.lec.cli.controller;

import com.lec.lib.auth.UserAuth;
import com.lec.lib.service.SubjectService;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "register_subject")
public class RegisterSubject implements Runnable {
	@Parameters(paramLabel = "Code", description = "The subject code", index = "0")
	private String code;

	@Parameters(paramLabel = "Name", description = "The subject name", index = "1")
	private String name;

	@ParentCommand
	CliCommands parent;

	private SubjectService subjectService = SubjectService.getInstance();

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

		// 과목 추가
		if (subjectService.registerSubejct(code, name)) {
			parent.out.println("register success");
		} else {
			parent.out.println("register fail");
		}
	}
}
