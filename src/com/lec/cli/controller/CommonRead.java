package com.lec.cli.controller;

import com.lec.lib.api.UserAuth;
import com.lec.lib.model.User;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "read")
public class CommonRead implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();
		if(!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		User user = auth.getUser();
		parent.out.println(user.toString());
	}
}
