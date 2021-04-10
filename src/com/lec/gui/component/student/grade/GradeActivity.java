package com.lec.gui.component.student.grade;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.student.StudentGradeLayout;
import com.lec.lib.repo.model.LectureHistory;
import com.lec.lib.repo.model.Student;

@SuppressWarnings("serial")
public class GradeActivity extends LecPanel {
	private LecTableView list;
	private JComboBox<String> yearComboBox;

	public GradeActivity(MainGui frame) {
		super(frame);

		// set layout
		StudentGradeLayout layout = new StudentGradeLayout();
		add(layout);

		// set combo box
		yearComboBox = layout.getYearComboBox();
		yearComboBox.addActionListener(yearListener);

		// set list
		list = layout.getList();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (auth.isLogin()) {
			onCreate();
			onRefresh();
		}
	}

	private static boolean isCalledOnCreate = false;

	private void onCreate() {
		if (!isCalledOnCreate) {
			Student student = studentService.read(auth.getUser().getId());
			Integer startYear = student.getAdmissionYear();
			Integer endYear = student.getGraduationYear();
			if (endYear == 0) {
				endYear = Calendar.getInstance().get(Calendar.YEAR);
			}
			int index = 0;
			for (int y = startYear; y <= endYear; y++, index++) {
				yearComboBox.addItem(Integer.toString(y));
			}
			yearComboBox.setSelectedIndex(index - 1);
			isCalledOnCreate = true;
		}
	}

	private void onRefresh() {
		String id = auth.getUser().getId();
		int year = Integer.parseInt((String)yearComboBox.getItemAt(yearComboBox.getSelectedIndex()));
		List<LectureHistory> lecH = studentService.readLectureHistoryByStudentIDAndYear(id, year);
		list.setModel(new GradeListTableAdapter(lecH));
	}

	private ActionListener yearListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			onRefresh();
		}
	};
}
