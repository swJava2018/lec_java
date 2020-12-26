package com.lec.my.cli;

import com.lec.my.api.UserAPI;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "register")
public class CommonRegister implements Runnable  {
	@Parameters(paramLabel = "Role", description = "The role")
    private String role;
	
	@Option(names = { "-i", "--id" }, description = "The student ID")
	private String id;
	
	@Option(names = { "-n", "--name" }, description = "The student Name")
	private String name;
	
	@Option(names = { "-p", "--password" }, description = "The student Password")
	private String password;
	
	@Option(names = { "-a", "--address" }, description = "The student Address")
	private String address;
	
	@ParentCommand
	CliCommands parent;
	
	public void run() {
		switch(role) {
			case "student":
				UserAPI api = new UserAPI();
				if(id == "" || name == "" || password == "")
					break;
				boolean result = api.register(id, name, password);
				if (result) {
					parent.out.println("register success");
				} else {
					parent.out.println("register fail");
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
