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
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserPanel extends LecPanel {
	// components
	private JScrollPane scrollPane;
	private UserListTable userList;
	private UserInfoPanel selected;
	private JButton loadBtn;
	private JButton updateBtn;
	private JButton registerBtn;
	private JButton deleteBtn;

	public UserPanel(SwingApp frame) {
		super(frame);

		// 선택된 사용자 정보
		selected = new UserInfoPanel(frame);
		selected.setPreferredSize(new Dimension(400, 400));

		// 사용자 리스트
		userList = new UserListTable(selected);
		scrollPane = new JScrollPane(userList);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		loadBtn = (new JButton("사용자 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
		loadBtn.addActionListener(loadListener);

		updateBtn = (new JButton("사용자 정보 변경하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));
		updateBtn.addActionListener(updateListener);

		registerBtn = (new JButton("사용자 정보 추가하기"));
		registerBtn.setPreferredSize(new Dimension(200, 30));
		registerBtn.addActionListener(registerListener);

		deleteBtn = (new JButton("사용자 정보 삭제하기"));
		deleteBtn.setPreferredSize(new Dimension(200, 30));
		deleteBtn.addActionListener(deleteListener);

		initLayout();

		refresh();
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

	private void refresh() {
		List<User> users = userService.readAll();
		userList.setModel(new UserListTableModel(users));
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = selected.getData();
			if (userService.update(user.getId(), user.getName(), user.getPassword(), user.getAddress())) {
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = selected.getData();
			if (userService.register(user.getId(), user.getName(), user.getPassword(), user.getRole().getValue())) {
				refresh();
			}
		}
	};

	private ActionListener deleteListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = selected.getData();
			if (userService.delete(user.getId())) {
				refresh();
			}
		}
	};
}
