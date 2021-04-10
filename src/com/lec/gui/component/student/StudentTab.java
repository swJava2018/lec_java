package com.lec.gui.component.student;

import javax.swing.JTabbedPane;

import com.lec.MainGui;
import com.lec.gui.component.student.grade.GradeActivity;
import com.lec.gui.component.student.schedule.ScheduleActivity;
import com.lec.gui.component.student.user.UserActivity;

@SuppressWarnings("serial")
public class StudentTab extends JTabbedPane {
	public StudentTab(MainGui frame) {
		addTab("내 정보", new UserActivity(frame));
		addTab("내 시간표", new ScheduleActivity(frame));
		addTab("내 성적", new GradeActivity(frame));
	}
}