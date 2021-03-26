package com.lec.gui.component.student.grade;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JScrollPane;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.LectureHistory;

@SuppressWarnings("serial")
public class GradePanel extends LecPanel {
	// components
	private JScrollPane scrollPane;
	private GradeListTable subjectList;
	private GradeInfoPanel selected;

	public GradePanel(MainGui frame) {
		super(frame);

		// 선택된 과목 정보
		selected = new GradeInfoPanel(frame);
		selected.setPreferredSize(new Dimension(400, 400));

		// 과목 리스트
		subjectList = new GradeListTable(selected);
		scrollPane = new JScrollPane(subjectList);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);

		c.gridx = 1;
		c.gridy = 0;
		add(selected, c);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			String id = auth.getUser().getId();
			List<LectureHistory> lecH = studentService.readLectureHistoryByID(id);
			subjectList.setModel(new GradeListTableModel(lecH));
		}
	}
}
