package com.lec.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StudentScheduleLayout extends JPanel {
	private static final String[] day = new String[] { "일", "월", "화", "수", "목", "금", "토" };

	// components
	private LayoutManager layout;
	private Map<Integer, List<StudentScheduleLectureView>> schedule;

	public StudentScheduleLayout() {

		// 시간표
		schedule = new HashMap<Integer, List<StudentScheduleLectureView>>();
		for (int day = 0; day < 7; day++) {
			List<StudentScheduleLectureView> times = new ArrayList<StudentScheduleLectureView>();
			for (int t = 0; t < 24; t++) {
				StudentScheduleLectureView panel = new StudentScheduleLectureView();
				panel.setMinimumSize(new Dimension(200, 50));
				times.add(panel);
			}
			schedule.put(day, times);
		}

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

	public LayoutManager getLayout() {
		return layout;
	}

	public Map<Integer, List<StudentScheduleLectureView>> getSchedule() {
		return schedule;
	}
}
