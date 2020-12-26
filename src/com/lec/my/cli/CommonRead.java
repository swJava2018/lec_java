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
		switch(role) {
			case "student":
				UserAPI api = new UserAPI();
				User user = api.read(id);
				parent.out.println(user.toString());
				break;
			case "professor":
				break;
			case "employee":
				break;
			default:
				break;
		}
	}
}
