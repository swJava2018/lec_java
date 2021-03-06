package com.lec.gui.controller.admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.SwingApp;
import com.lec.gui.controller.common.LecPanel;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserListInfoPanel extends LecPanel {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

	public UserListInfoPanel(SwingApp frame) {
		super(frame);

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		genInfoPair("id", "ID", 0);
		genInfoPair("name", "이름", 1);
		genInfoPair("address", "주소", 2);
		genInfoPair("phone", "전화번호", 3);
		genInfoPair("country", "국적", 4);
		genInfoPair("country", "주민등록번호", 5);
		genInfoPair("email", "이메일", 6);
		genInfoPair("birth", "생년월일", 7);
		genInfoPair("pwd", "비밀번호", 8);
		genInfoPair("role", "권한", 9);
	}

	private void genInfoPair(String id, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(field, c);

		infoMap.put(id, field);
	}

	public void setData(User user) {
		infoMap.get("id").setText(user.getId());
		infoMap.get("name").setText(user.getName());
		infoMap.get("phone").setText(user.getPhoneNumber());
		infoMap.get("country").setText(user.getCountry());
		infoMap.get("email").setText(user.getEmail());
		infoMap.get("birth").setText(user.getBirthDate());
		infoMap.get("pwd").setText(user.getPassword());
		infoMap.get("address").setText(user.getAddress());
	}
}