package com.lec.ui.controller.student;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StudentInfoPanel extends JPanel {
	// component
	private JLabel idLabel;
		
	public StudentInfoPanel() {
		idLabel = new JLabel("로그인 이름");
		idLabel.setPreferredSize(new Dimension(200, 30));
		add(idLabel);
	}
}
