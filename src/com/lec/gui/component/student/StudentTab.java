package com.lec.gui.component.student;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.student.grade.GradePanel;
import com.lec.gui.component.student.schedule.SchedulePanel;
import com.lec.gui.component.student.user.UserPanel;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane {
	public StudentTab(MainGui frame) {
		addTab("내 정보", new UserPanel(frame));
		addTab("내 시간표", new SchedulePanel(frame));
		addTab("내 성적", new GradePanel(frame));
	}
}