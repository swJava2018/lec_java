package com.lec.gui.component.main;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.admin.RegisterPanel;

@SuppressWarnings("serial")
public class MainTab extends JTabbedPane {
	public MainTab(MainGui frame) {
		addTab("로그인", new LoginPanel(frame));
	}
}
