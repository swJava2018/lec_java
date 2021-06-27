package com.lec.gui.component.common;

public class LecTab {
	private String name;
	private LecTabPanel panel;

	public LecTab(String name, LecTabPanel panel) {
		this.name = name;
		this.panel = panel;
	}

	public String getName() {
		return name;
	}

	public LecTabPanel getPanel() {
		return panel;
	}
}
