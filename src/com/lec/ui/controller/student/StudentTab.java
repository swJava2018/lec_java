package com.lec.ui.controller.student;

import java.awt.Frame;

import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane {
	// component
	private StudentInfoPanel studentInfoPanel = new StudentInfoPanel();
	
	public StudentTab(Frame frame) {
		addTab("내 정보", studentInfoPanel);
	}
}