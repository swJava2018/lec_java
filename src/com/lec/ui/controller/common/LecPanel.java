package com.lec.ui.controller.common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lec.lib.service.UserDatabase;
import com.lec.ui.SwingApp;

@SuppressWarnings("serial")
public class LecPanel extends JPanel {
	protected SwingApp frame;
	protected static UserDatabase db = UserDatabase.getInstance();

	// component
	private JOptionPane op = new JOptionPane();

	public LecPanel(SwingApp frame) {
		this.frame = frame;
	}

	protected void showMessageBox(String message) {
		op.showMessageDialog(this, message);
	}
}
