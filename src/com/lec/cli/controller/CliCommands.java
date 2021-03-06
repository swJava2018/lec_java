package com.lec.cli.controller;

import java.io.PrintWriter;

import org.jline.reader.LineReader;
import org.jline.reader.impl.LineReaderImpl;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Top-level command that just prints help.
 */
@Command(name = "", description = {
		"Example interactive shell with completion. Hit @|magenta <TAB>|@ to see available commands. Type `@|bold,yellow keymap ^[s tailtip-toggle|@`, "
				+ "then hit @|magenta ALT-S|@ to toggle tailtips.",
		"" }, footer = { "", "Press Ctl-D to exit." }, subcommands = { ClearScreen.class, CommandLine.HelpCommand.class,
				RegisterUser.class, ReadUser.class, UpdateUser.class, LoginUser.class, LogoutUser.class,
				RegisterSubject.class })
public class CliCommands implements Runnable {
	LineReaderImpl reader;
	PrintWriter out;

	public CliCommands() {
	}

	public void setReader(LineReader reader) {
		this.reader = (LineReaderImpl) reader;
		out = reader.getTerminal().writer();
	}

	public void run() {
		out.println(new CommandLine(this).getUsageMessage());
	}
}
