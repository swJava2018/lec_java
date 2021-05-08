package com.lec.gui.component.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lec.MainGui;
import com.lec.gui.component.admin.depart.DepartmentActivity;
import com.lec.gui.component.admin.division.DivisionActivity;
import com.lec.gui.component.admin.lecture.LectureActivity;
import com.lec.gui.component.admin.subject.SubjectActivity;
import com.lec.gui.component.admin.user.UserActivity;
import com.lec.gui.component.common.Activity;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane implements ChangeListener {
	private List<Activity> activities;

	public AdminTab(MainGui frame) {
		activities = new ArrayList<Activity>();
//		activities.add(new ActivityPanel("회원 등록", new RegisterPanel(frame)));
		activities.add(new Activity("회원 정보", new UserActivity(frame)));
		activities.add(new Activity("과목 정보", new SubjectActivity(frame)));
		activities.add(new Activity("강의 정보", new LectureActivity(frame)));
		activities.add(new Activity("학부 정보", new DivisionActivity(frame)));
		activities.add(new Activity("학과 정보", new DepartmentActivity(frame)));

		for (int i = 0; i < activities.size(); i++) {
			Activity activity = activities.get(i);
			addTab(activity.getName(), activity.getPanel());
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// 탭 변경시 반영을 위함 (현재 미사용 코드)
		activities.get(this.getSelectedIndex()).getPanel().onResumeData();
	}
}
