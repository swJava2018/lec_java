package com.lec.gui.component.admin;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.admin.depart.DepartmentActivity;
import com.lec.gui.component.admin.division.DivisionActivity;
import com.lec.gui.component.admin.lecture.LectureActivity;
import com.lec.gui.component.admin.subject.SubjectActivity;
import com.lec.gui.component.admin.user.UserActivity;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane {
	public AdminTab(MainGui frame) {
//		addTab("회원 등록", new RegisterPanel(frame));
		addTab("회원 정보", new UserActivity(frame));
		addTab("과목 정보", new SubjectActivity(frame));
		addTab("강의 정보", new LectureActivity(frame));
		addTab("학부 정보", new DivisionActivity(frame));
		addTab("학과 정보", new DepartmentActivity(frame));
	}
}
