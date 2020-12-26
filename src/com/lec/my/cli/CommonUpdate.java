package com.lec.my.cli;

import com.lec.my.api.UserAPI;
import com.lec.my.model.User;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

public class CommonUpdate implements Runnable  {
	@Parameters(paramLabel = "Operation", description = "The operation")
    private String op;
	
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
		UserAPI api = new UserAPI();
		int result = 0;
		
		switch(op) {
			case "stduent":
				if(id == "")
					break;
				result = api.update(id, name, password, address);
				break;
			default:
				break;
		}
		
		if (result != 0) {
			parent.out.printf("fail to register %s\n", name);
		}
	}
}
