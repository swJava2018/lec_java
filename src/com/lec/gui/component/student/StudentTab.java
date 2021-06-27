package com.lec.gui.component.student;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.student.grade.GradeTab;
import com.lec.gui.component.student.schedule.ScheduleTab;
import com.lec.gui.component.student.user.UserTab;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane {
	public StudentTab(MainGui frame) {
		addTab("내 정보", new UserTab(frame));
		addTab("내 시간표", new ScheduleTab(frame));
		addTab("내 성적", new GradeTab(frame));
	}
}