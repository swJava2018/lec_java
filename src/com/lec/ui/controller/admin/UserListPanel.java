package com.lec.ui.controller.admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.lec.lib.model.User;
import com.lec.ui.SwingApp;
import com.lec.ui.controller.common.LecPanel;

@SuppressWarnings("serial")
public class UserListPanel extends LecPanel {
	// component
	private JTable userTbl;
	private JButton loadBtn;

	public UserListPanel(SwingApp frame) {
		super(frame);

		userTbl = new JTable();

		loadBtn = (new JButton("사용자 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
		loadBtn.addActionListener(loadListener);

		add(new JScrollPane(userTbl));
		add(loadBtn);
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			List<User> users = db.readAll();
			String[][] data = new String[users.size()][];
			for (int i = 0; i < users.size(); i++) {
				String[] cols = new String[4];
				cols[0] = users.get(i).getId();
				cols[1] = users.get(i).getName();
				cols[2] = users.get(i).getPassword();
				cols[3] = users.get(i).getRole().getValue();
				data[i] = cols;
			}

			userTbl.setModel(new UserListTable(data));
		}
	};
}
