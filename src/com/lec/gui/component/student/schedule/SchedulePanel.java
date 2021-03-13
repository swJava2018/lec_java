package com.lec.gui.component.student.schedule;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

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
import com.lec.lib.auth.UserAuth;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class SchedulePanel extends LecPanel {
	// components
	private JScrollPane scrollPane;
	private UserListTable userList;
	private UserInfoPanel selected;

	public SchedulePanel(MainGui frame) {
		super(frame);

		// 선택된 사용자 정보
		selected = new UserInfoPanel(frame);
		selected.setPreferredSize(new Dimension(400, 400));

		// 사용자 리스트
		userList = new UserListTable(selected);
		scrollPane = new JScrollPane(userList);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		initLayout();

//		refresh();
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
}
