package com.lec.my.cli;

import com.lec.my.api.UserAPI;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

public class CommonLogin implements Runnable  {
	@Parameters(paramLabel = "Role", description = "The role")
    private String role;
	
	@Option(names = { "-i", "--id" }, description = "The ID", required = true)
	private String id;
	
	@Option(names = { "-p", "--password" }, description = "The student Password", required = true)
	private String password;
	
	@ParentCommand
	CliCommands parent;
	
	public void run() {
		int result = 0;
		switch(role) {
			case "student":
				UserAPI api = new UserAPI();
				result = api.login(id, password);
				break;
			case "professor":
				break;
			case "employee":
				break;
			default:
				break;
		}
		
		if (result != 0) {
			parent.out.printf("fail to login %s\n", id);
		}
	}
}
