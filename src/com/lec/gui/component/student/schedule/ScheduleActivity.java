package com.lec.gui.component.student.schedule;

import java.awt.Graphics;
import java.util.List;
import java.util.Map;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.student.StudentScheduleLayout;
import com.lec.gui.layout.student.StudentScheduleLectureView;
import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class ScheduleActivity extends LecPanel {
	// components
	private Map<Integer, List<StudentScheduleLectureView>> schedule;

	public ScheduleActivity(MainGui frame) {
		super(frame);

		// set layout
		StudentScheduleLayout layout = new StudentScheduleLayout();
		add(layout);

		schedule = layout.getSchedule();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			String id = auth.getUser().getId();
			List<Lecture> lecList = studentService.readLectureByStudentID(id);
			updateSchedule(lecList);
		}
	}

	private void updateSchedule(List<Lecture> lecList) {
		for (int day = 0; day < 7; day++) {
			for (int t = 0; t < 24; t++) {
				schedule.get(day).get(t).setData(".");
			}
		}

		// 학생이 수강한 모든 강의
		for (Lecture lec : lecList) {
			String subName = lec.getSubject().getName();

			// 강의별 시간
			Map<String, List<Integer>> time = lec.getTime();
			for (String day : time.keySet()) {
				Integer dayInt = Integer.parseInt(day);

				// 시간별 강의 과목 이름
				List<Integer> times = time.get(day);
				for (int t = 0; t < 24; t++) {
					if (times.contains(t)) {
						schedule.get(dayInt).get(t).setData(subName);
					}
				}
			}
		}
	}
}
