package com.lec.cli.controller;

import com.lec.lib.api.AdminAPI;
import com.lec.lib.api.EmployeeAPI;
import com.lec.lib.api.ProfessorAPI;
import com.lec.lib.api.StudentAPI;
import com.lec.lib.api.UserAPI;
import com.lec.lib.api.UserAuth;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "register")
public class CommonRegister implements Runnable {
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
		
		String permission = auth.getUser().getRole();
		if(permission.equals("professor") || permission.equals("student")) {
			parent.out.println("your account have not register permission");
			return;
		}
		
		UserAPI api = null;
		switch(role) {
		case "admin": api = new AdminAPI(); break;
		case "employee": api = new EmployeeAPI(); break;
		case "professor": api = new ProfessorAPI(); break;
		case "student": api = new StudentAPI(); break;
		default: return;
		}
		
		boolean result = api.register(id, name, password);
		if (result) {
			parent.out.println("register success");
		} else {
			parent.out.println("register fail");
		}
	}
}
