package com.lec.gui.component.login;

import javax.swing.JTabbedPane;

import com.lec.MainGui;

@SuppressWarnings("serial")
public class LoginTab extends JTabbedPane {
	public LoginTab(MainGui frame) {
		addTab("로그인", new LoginPanel(frame));
	}
}
