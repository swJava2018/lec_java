package com.lec.gui.component.admin.user;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.UserLayout;
import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserActivity extends LecPanel {
	private LecTableView list;
	private LecView info;

	public UserActivity(MainGui frame) {
		super(frame);

		// set layout
		UserLayout layout = new UserLayout();
		add(layout);

		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton registerBtn = layout.getRegisterBtn();
		JButton deleteBtn = layout.getDeleteBtn();
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		registerBtn.addActionListener(registerListener);
		deleteBtn.addActionListener(deleteListener);

		// set list
		list = layout.getUserList();
		info = layout.getSelected();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			List<User> users = userService.readAll();
			list.setModel(new UserListTableAdapter(users));
		}
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) info.getData();
			if (userService.update(user.getId(), user.getName(), user.getPassword(), user.getAddress())) {
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) info.getData();
			if (userService.register(user.getId(), user.getName(), user.getPassword(), user.getRole().getValue(),
					null)) {
				refresh();
			}
		}
	};

	private ActionListener deleteListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			User user = (User) info.getData();
			if (userService.delete(user.getId())) {
				refresh();
			}
		}
	};
}
