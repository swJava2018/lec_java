package com.lec.gui.layout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentGradeLayout extends JPanel {
	// components
	private LayoutManager layout;
	private JScrollPane scrollPane;
	private LecTableView list;
	private LecView selected;

	public StudentGradeLayout() {

		// 선택된 성적 정보
		selected = new StudentGradeInfoView();
		selected.setPreferredSize(new Dimension(400, 400));

		// 성적 정보
		list = new LecTableView(selected);
		scrollPane = new JScrollPane(list);
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

	public LayoutManager getLayout() {
		return layout;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public LecTableView getList() {
		return list;
	}

	public LecView getSelected() {
		return selected;
	}
}
