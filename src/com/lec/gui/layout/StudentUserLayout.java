package com.lec.gui.layout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import com.lec.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentUserLayout extends JPanel {
	// components
	private LayoutManager layout;

	private LecView userInfo;
	private LecView studentInfo;

	public StudentUserLayout() {

		// 사용자 정보
		userInfo = new StudentUserInfoView();
		userInfo.setPreferredSize(new Dimension(400, 400));

		// 학생 정보
		studentInfo = new StudentInfoView();
		studentInfo.setPreferredSize(new Dimension(400, 400));

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(userInfo, c);

		c.gridx = 1;
		c.gridy = 0;
		add(studentInfo, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public LecView getUserInfo() {
		return userInfo;
	}

	public LecView getStudentInfo() {
		return studentInfo;
	}
}
