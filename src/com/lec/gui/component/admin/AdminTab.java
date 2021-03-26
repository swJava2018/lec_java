package com.lec.gui.component.admin;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.admin.depart.DepartmentPanel;
import com.lec.gui.component.admin.division.DivisionPanel;
import com.lec.gui.component.admin.lecture.LecturePanel;
import com.lec.gui.component.admin.subject.SubjectPanel;
import com.lec.gui.component.admin.user.UserPanel;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane {
	public AdminTab(MainGui frame) {
//		addTab("회원 등록", new RegisterPanel(frame));
		addTab("회원 정보", new UserPanel(frame));
		addTab("과목 정보", new SubjectPanel(frame));
		addTab("강의 정보", new LecturePanel(frame));
		addTab("학부 정보", new DivisionPanel(frame));
		addTab("학과 정보", new DepartmentPanel(frame));
	}
}
