package com.lec.cli.controller;

import com.lec.lib.api.UserAPI;
import com.lec.lib.api.UserAuth;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "update")
public class CommonUpdate implements Runnable {
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
		UserAuth auth = UserAuth.getInstance();
		if(!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		UserAPI api = auth.getUserAPI();
		boolean result = api.update(id, name, password, address);
		if (result) {
			parent.out.println("update success");
		} else {
			parent.out.println("update fail");
		}
	}
}
