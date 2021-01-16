package com.lec.ui.controller.main;

import java.awt.Frame;

import javax.swing.JTabbedPane;

import com.lec.ui.SwingApp;

@SuppressWarnings("serial")
public class MainTab extends JTabbedPane {
	public MainTab(SwingApp frame) {
		addTab("로그인", new SignInPanel(frame));
        addTab("회원가입", new SignUpPanel(frame));
	}
}
