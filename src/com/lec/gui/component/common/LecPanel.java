package com.lec.gui.component.common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lec.MainGui;
import com.lec.lib.service.SubjectService;
import com.lec.lib.service.UserService;

@SuppressWarnings("serial")
public class LecPanel extends JPanel {
	protected MainGui frame;
	protected static UserService userService = UserService.getInstance();
	protected static SubjectService subjectService = SubjectService.getInstance();

	// component
	private JOptionPane op = new JOptionPane();

	public LecPanel(MainGui frame) {
		this.frame = frame;
	}

	protected void showMessageBox(String message) {
		op.showMessageDialog(this, message);
	}
}
