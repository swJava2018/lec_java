package com.lec.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentGradeLayout extends JPanel {
	private LayoutManager layout;

	private JScrollPane scrollPane;
	private LecTableView list;
	private LecView gradeInfo;
	private JComboBox<String> yearComboBox;

	public StudentGradeLayout() {

		// 선택된 성적 정보
		gradeInfo = new StudentGradeInfoView();
		gradeInfo.setPreferredSize(new Dimension(400, 400));

		// 성적 정보
		list = new LecTableView(gradeInfo);
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		// 년도 선택
		yearComboBox = new JComboBox<String>();

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
		add(gradeInfo, c);

		c.gridx = 0;
		c.gridy = 1;
		add(yearComboBox, c);
	}

	public LayoutManager getLayout() {
		return layout;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public LecTableView getList() {
		return list;
	}

	public LecView getGradeInfo() {
		return gradeInfo;
	}

	public JComboBox<String> getYearComboBox() {
		return yearComboBox;
	}
}
