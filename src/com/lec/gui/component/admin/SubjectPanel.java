package com.lec.gui.component.admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.lec.gui.SwingApp;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Subject;

@SuppressWarnings("serial")
public class SubjectPanel extends LecPanel {
	// components
	private JScrollPane scrollPane;
	private SubjectListTable list;
	private SubjectInfoPanel selected;
	private JButton loadBtn;

	public SubjectPanel(SwingApp frame) {
		super(frame);

		// 선택된 과목 정보
		selected = new SubjectInfoPanel(frame);
		selected.setPreferredSize(new Dimension(400, 400));

		// 과목 리스트
		list = new SubjectListTable(selected);
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		loadBtn = (new JButton("사용자 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
		loadBtn.addActionListener(loadListener);

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

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<Subject> subjects = subjectService.readAll();
			list.setModel(new SubjectListTableModel(subjects));
		}
	};
}
