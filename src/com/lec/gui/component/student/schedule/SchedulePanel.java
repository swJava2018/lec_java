package com.lec.gui.component.student.schedule;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.admin.user.UserInfoPanel;
import com.lec.gui.component.admin.user.UserListTable;
import com.lec.gui.component.admin.user.UserListTableModel;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.auth.LectureDay;
import com.lec.lib.auth.UserAuth;
import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.LectureHistory;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class SchedulePanel extends LecPanel {
	// components
//	private JScrollPane scrollPane;
//	private UserListTable userList;
//	private UserInfoPanel selected;
	private Map<Integer, List<ScheduleSubjectPanel>> schedule;

	public SchedulePanel(MainGui frame) {
		super(frame);

		schedule = new HashMap<Integer, List<ScheduleSubjectPanel>>();
		for (int i = 0; i < 7; i++) {
			List timeList = new ArrayList<ScheduleSubjectPanel>();
			for (int j = 0; j < 23; j++) {
				ScheduleSubjectPanel panel = new ScheduleSubjectPanel(frame);
				panel.setMinimumSize(new Dimension(200, 50));
				timeList.add(panel);
			}
			schedule.put(i, timeList);
		}

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 23; j++) {
				c.gridx = i;
				c.gridy = j;
				add(schedule.get(i).get(j), c);
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateSchdulePane();
	}

	private void updateSchdulePane() {
		String id = auth.getUser().getId();
		List<Lecture> lecHistory = studentService.readByStudentID(id);

		for (Lecture lec : lecHistory) {

			Map<String, List<Integer>> time = lec.getTime();
			for (String day : time.keySet()) {
				List<Integer> subjectTimeList = time.get(day);

				for (Integer subjectTime : subjectTimeList) {
					String subjectName = subjectTime + " ";
					schedule.get(Integer.parseInt(day)).get(subjectTime).setSubjectLbl(subjectName);

				}
			}
		}
	}
}
