package com.lec.gui.component.admin;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.lec.MainGui;
import com.lec.gui.component.admin.depart.DepartmentTab;
import com.lec.gui.component.admin.division.DivisionTab;
import com.lec.gui.component.admin.lecture.LectureTab;
import com.lec.gui.component.admin.subject.SubjectTab;
import com.lec.gui.component.admin.user.UserTab;
import com.lec.gui.component.common.LecTab;

@SuppressWarnings("serial")
public class AdminTab extends JTabbedPane implements ChangeListener {
	private List<LecTab> activities;

	public AdminTab(MainGui frame) {
		activities = new ArrayList<LecTab>();
//		activities.add(new ActivityPanel("회원 등록", new RegisterPanel(frame)));
		activities.add(new LecTab("회원 정보", new UserTab(frame)));
		activities.add(new LecTab("과목 정보", new SubjectTab(frame)));
		activities.add(new LecTab("강의 정보", new LectureTab(frame)));
		activities.add(new LecTab("학부 정보", new DivisionTab(frame)));
		activities.add(new LecTab("학과 정보", new DepartmentTab(frame)));

		for (int i = 0; i < activities.size(); i++) {
			LecTab activity = activities.get(i);
			addTab(activity.getName(), activity.getPanel());
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// 탭 변경시 반영을 위함 (현재 미사용 코드)
		activities.get(this.getSelectedIndex()).getPanel().onResumeData();
	}
}
