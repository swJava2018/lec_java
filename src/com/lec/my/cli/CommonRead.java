package com.lec.my.cli;

import com.lec.my.api.UserAPI;
import com.lec.my.model.User;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "read")
public class CommonRead implements Runnable {
	@Parameters(paramLabel = "Role", description = "The role")
	private String role;

	@Option(names = { "-i", "--id" }, description = "The ID")
	private String id;

	@Option(names = { "-al", "--all" }, description = "The student Password")
	private Boolean isAll;

	@ParentCommand
	CliCommands parent;

	public void run() {
		switch (role) {
		case "student":
			UserAPI api = new UserAPI();
			User user = api.read(id);
			if (user != null) {
				parent.out.println(user.toString());
			} else {
				parent.out.printf("%s is not exist\n", id);
			}
			break;
		case "professor":
			break;
		case "employee":
			break;
		default:
			parent.out.printf("'%s' is not support\n", role);
			break;
		}
	}
}
