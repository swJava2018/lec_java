package com.lec.gui.component.admin.user;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.admin.AdminUserLayout;
import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;
import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserActivity extends LecPanel {
	private LecTableView list;
	private LecView info;
	private JComboBox<String> roleComboBox;

	public UserActivity(MainGui frame) {
		super(frame);

		// set layout
		AdminUserLayout layout = new AdminUserLayout();
		add(layout);

		// set combo box
		roleComboBox = layout.getRoleComboBox();
		for (Permission p : Permission.values()) {
			roleComboBox.addItem(p.getValue());
		}
		roleComboBox.setSelectedIndex(0);
		roleComboBox.addActionListener(roleListener);

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
		info = layout.getUserInfo();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			List<User> users = userService.readAll(roleComboBox.getSelectedItem().toString());
			list.setModel(new UserListTableAdapter(users));
		}
	}

	private ActionListener roleListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

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
