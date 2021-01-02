package com.lec.my.cli;

import com.lec.my.model.User;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "read")
public class CommonRead implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		CliAuth auth = CliAuth.getInstance();
		if(!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		User user = CliAuth.getInstance().getUser();
		
		switch (user.getRole()) {
		case "student":
			parent.out.println(user.toString());
			break;
		case "professor":
			break;
		case "employee":
			break;
		}
	}
}
