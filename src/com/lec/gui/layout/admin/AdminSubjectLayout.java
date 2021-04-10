package com.lec.gui.layout.admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class AdminSubjectLayout extends JPanel {
	// components
	private LayoutManager layout;

	private JScrollPane scrollPane;
	private LecTableView list;
	private LecView subjectInfo;
	private JButton loadBtn;
	private JButton updateBtn;
	private JButton registerBtn;
	private JButton deleteBtn;

	public AdminSubjectLayout() {
		// 선택된 과목 정보
		subjectInfo = new AdminSubjectInfoView();
		subjectInfo.setPreferredSize(new Dimension(400, 400));

		// 과목 리스트
		list = new LecTableView(subjectInfo);
		scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		loadBtn = (new JButton("과목 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));

		updateBtn = (new JButton("과목 정보 변경하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));

		registerBtn = (new JButton("과목 정보 추가하기"));
		registerBtn.setPreferredSize(new Dimension(200, 30));

		deleteBtn = (new JButton("과목 정보 삭제하기"));
		deleteBtn.setPreferredSize(new Dimension(200, 30));

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
		add(subjectInfo, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 3;
		add(registerBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 4;
		add(deleteBtn, c);
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

	public LecView getSubjectInfo() {
		return subjectInfo;
	}

	public JButton getLoadBtn() {
		return loadBtn;
	}

	public JButton getUpdateBtn() {
		return updateBtn;
	}

	public JButton getRegisterBtn() {
		return registerBtn;
	}

	public JButton getDeleteBtn() {
		return deleteBtn;
	}
}
