package com.lec.my.cli;

import com.lec.my.api.UserAPI;
import com.lec.my.model.User;

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
		UserAPI api = new UserAPI();
		User user = api.login(id, password);
		if (user != null) {
			CliAuth.getInstance().login(user);
			parent.out.println("login success");
		} else {
			parent.out.println("login fail");
		}
	}
}
