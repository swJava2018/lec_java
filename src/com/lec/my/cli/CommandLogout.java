package com.lec.my.cli;

import com.lec.my.api.UserAPI;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "logout")
public class CommandLogout implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAPI api = new UserAPI();
		boolean isLogout = api.logout();
		if (isLogout) {
			CliAuth.getInstance().logout();
			parent.out.println("login success");
		} else {
			parent.out.println("login fail");
		}
	}
}
