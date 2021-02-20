package com.lec.gui.controller.student;

import java.awt.Frame;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane {
	public StudentTab(Frame frame) {
		addTab("내 정보", new StudentInfoPanel());
	}
}