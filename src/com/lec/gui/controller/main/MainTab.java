package com.lec.gui.controller.main;

import javax.swing.JTabbedPane;

import com.lec.gui.SwingApp;
import com.lec.gui.controller.admin.RegisterPanel;

@SuppressWarnings("serial")
public class MainTab extends JTabbedPane {
	public MainTab(SwingApp frame) {
		addTab("로그인", new LoginPanel(frame));
	}
}
