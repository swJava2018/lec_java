package com.lec.gui.controller.admin;

import javax.swing.JTabbedPane;

import com.lec.gui.SwingApp;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane {
	public AdminTab(SwingApp frame) {
		addTab("회원 등록", new RegisterPanel(frame));
		addTab("회원 정보", new UserListPanel(frame));
		addTab("과목 정보", new SubjectListPanel(frame));
		addTab("강의 정보", new LectureListPanel(frame));
		addTab("학부 정보", new DivisionListPanel(frame));
		addTab("학과 정보", new DepartmentListPanel(frame));
	}
}
