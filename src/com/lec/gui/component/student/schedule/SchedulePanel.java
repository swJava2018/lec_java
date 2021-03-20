package com.lec.gui.component.student.schedule;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class SchedulePanel extends LecPanel {
	// components
	private Map<Integer, List<ScheduleLecturePanel>> schedule;
	private static final String[] day = new String[] { "일", "월", "화", "수", "목", "금", "토" };

	public SchedulePanel(MainGui frame) {
		super(frame);

		initSchedule();
		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// 요일
		for (int x = 0; x < 7; x++) {
			c.gridx = x + 1;
			c.gridy = 0;
			add(new JLabel(day[x]), c);
		}

		// 시간
		for (int y = 0; y < 24; y++) {
			c.gridx = 0;
			c.gridy = y + 1;

			String meridiem = (y < 12) ? "am" : "pm";
			String timeStr = "";
			if (y < 12) {
				timeStr = String.format("%02d", y) + ":00 ~ " + String.format("%02d", y + 1) + ":00 " + meridiem;
			} else if (y == 12) {
				timeStr = String.format("%02d", y) + ":00 ~ " + String.format("%02d", y + 1 - 12) + ":00 " + meridiem;
			} else {
				timeStr = String.format("%02d", y - 12) + ":00 ~ " + String.format("%02d", y + 1 - 12) + ":00 "
						+ meridiem;
			}
			add(new JLabel(timeStr), c);
		}

		// 시간표
		for (int y = 0; y < 24; y++) {
			for (int x = 0; x < 7; x++) {
				c.gridx = x + 1;
				c.gridy = y + 1;
				add(schedule.get(x).get(y), c);
			}
		}
	}

	private void initSchedule() {
		schedule = new HashMap<Integer, List<ScheduleLecturePanel>>();
		for (int day = 0; day < 7; day++) {
			List<ScheduleLecturePanel> times = new ArrayList<ScheduleLecturePanel>();
			for (int t = 0; t < 24; t++) {
				ScheduleLecturePanel panel = new ScheduleLecturePanel(frame);
				panel.setMinimumSize(new Dimension(200, 50));
				times.add(panel);
			}
			schedule.put(day, times);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			String id = auth.getUser().getId();
			List<Lecture> lecH = studentService.readByStudentID(id);
			updateSchedule(lecH);
		}
	}

	private void updateSchedule(List<Lecture> lecH) {
		for (int day = 0; day < 7; day++) {
			for (int t = 0; t < 24; t++) {
				schedule.get(day).get(t).setSubjectLbl(".");
			}
		}

		// 학생이 수강한 모든 강의 읽기
		for (Lecture lec : lecH) {
			String subName = lec.getSubject().getName();

			// 강의별 시간 읽기
			Map<String, List<Integer>> time = lec.getTime();
			for (String day : time.keySet()) {
				Integer dayInt = Integer.parseInt(day);

				// 시간별 강의 과목 이름 출력
				List<Integer> times = time.get(day);
				for (int t = 0; t < 24; t++) {
					if (times.contains(t)) {
						schedule.get(dayInt).get(t).setSubjectLbl(subName);
					}
				}
			}
		}
	}
}
