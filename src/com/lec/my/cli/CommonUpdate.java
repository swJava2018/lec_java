package com.lec.my.cli;

import com.lec.my.api.UserAPI;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "update")
public class CommonUpdate implements Runnable  {
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
				if(id == "")
					break;
				UserAPI api = new UserAPI();
				boolean result = api.update(id, name, password, address);
				if (result) {
					parent.out.println("update success");
				} else {
					parent.out.println("update fail");
				}
				break;
			default:
				parent.out.printf("'%s' is not support\n", role);
				break;
		}
	}
}
