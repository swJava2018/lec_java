package com.lec.gui.component.student.grade;

import java.awt.Graphics;
import java.util.List;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.StudentGradeLayout;
import com.lec.gui.layout.common.LecTableView;
import com.lec.lib.repo.model.LectureHistory;

@SuppressWarnings("serial")
public class GradeActivity extends LecPanel {
	// components
	private LecTableView list;

	public GradeActivity(MainGui frame) {
		super(frame);

		// set layout
		StudentGradeLayout layout = new StudentGradeLayout();
		add(layout);

		// set list
		list = layout.getList();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			String id = auth.getUser().getId();
			List<LectureHistory> lecH = studentService.readLectureHistoryByStudentID(id);
			list.setModel(new GradeListTableAdapter(lecH));
		}
	}
}
