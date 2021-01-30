package com.lec.cli.controller;

import com.lec.lib.api.UserAuth;
import com.lec.lib.api.AdminAPI;
import com.lec.lib.api.StudentAPI;
import com.lec.lib.api.UserAPI;
import com.lec.lib.model.User;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "login")
public class CommonLogin implements Runnable {
	@Parameters(paramLabel = "ID", description = "The ID", index = "0")
	private String id;

	@Parameters(paramLabel = "Password", description = "The Password", index = "1")
	private String password;

	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();
		if(auth.isLogin()) {
			parent.out.println("it's need to logout");
			return;
		}
		
		UserAPI api = new UserAPI();
		User user = api.login(id, password);
		if (user != null) {
			UserAuth.getInstance().login(user);
			parent.out.println("login success");
		} else {
			parent.out.println("login fail");
		}
	}
}
