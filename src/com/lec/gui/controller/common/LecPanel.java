package com.lec.gui.controller.common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lec.gui.SwingApp;
import com.lec.lib.repo.UserInfoRepo;

@SuppressWarnings("serial")
public class LecPanel extends JPanel {
	protected SwingApp frame;
	protected static UserInfoRepo db = UserInfoRepo.getInstance();

	// component
	private JOptionPane op = new JOptionPane();

	public LecPanel(SwingApp frame) {
		this.frame = frame;
	}

	protected void showMessageBox(String message) {
		op.showMessageDialog(this, message);
	}
}
