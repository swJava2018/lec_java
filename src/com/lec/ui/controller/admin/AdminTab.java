package com.lec.ui.controller.admin;

import javax.swing.JTabbedPane;

import com.lec.ui.SwingApp;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane {
	public AdminTab(SwingApp frame) {
		addTab("회원등록", new RegisterPanel(frame));
		addTab("회원리스트", new UserListPanel(frame));
	}
}
