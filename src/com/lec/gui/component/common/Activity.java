package com.lec.gui.component.common;

public class Activity {
	private String name;
	private LecActivityPanel panel;

	public Activity(String name, LecActivityPanel panel) {
		this.name = name;
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public LecActivityPanel getPanel() {
		return panel;
	}
}
