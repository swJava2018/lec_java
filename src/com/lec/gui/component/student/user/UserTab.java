package com.lec.gui.component.student.user;

import java.awt.Graphics;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.common.LecView;
import com.lec.gui.layout.student.StudentUserLayout;
import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserTab extends LecPanel {
	private LecView userInfo;
	private LecView studentInfo;

	public UserTab(MainGui frame) {
		super(frame);

		// set layout
		StudentUserLayout layout = new StudentUserLayout();
		add(layout);

		// set info
		userInfo = layout.getUserInfo();
		studentInfo = layout.getStudentInfo();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Student student = studentService.read(auth.getUser().getId());
			studentInfo.setData(student);

			User user = userService.read(auth.getUser().getId());
			userInfo.setData(user);
		}
	}
}
