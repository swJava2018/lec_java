package com.lec.gui.component.main;

import javax.swing.JTabbedPane;

import com.lec.gui.SwingApp;
import com.lec.gui.component.admin.RegisterPanel;

@SuppressWarnings("serial")
public class MainTab extends JTabbedPane {
	public MainTab(SwingApp frame) {
		addTab("로그인", new LoginPanel(frame));
	}
}
