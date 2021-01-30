package com.lec.cli.controller;

import com.lec.lib.api.UserAuth;
import com.lec.lib.api.UserAPI;

import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command(name = "logout")
public class CommandLogout implements Runnable {
	@ParentCommand
	CliCommands parent;

	public void run() {
		UserAuth auth = UserAuth.getInstance();
		if(!auth.isLogin()) {
			parent.out.println("it's need to login");
			return;
		}
		
		UserAPI api = auth.getUserAPI();
		boolean isLogout = api.logout();
		if (isLogout) {
			UserAuth.getInstance().logout();
			parent.out.println("login success");
		} else {
			parent.out.println("login fail");
		}
	}
}
