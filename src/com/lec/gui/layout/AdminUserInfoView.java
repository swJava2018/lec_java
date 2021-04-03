package com.lec.gui.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.common.LecView;
import com.lec.lib.auth.Permission;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class AdminUserInfoView extends LecView {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

	public AdminUserInfoView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("id", "학번", row++);
		genInfoPair("name", "이름", row++);
		genInfoPair("address", "주소", row++);
		genInfoPair("phone", "전화번호", row++);
		genInfoPair("country", "국적", row++);
		genInfoPair("regdent", "주민등록번호", row++);
		genInfoPair("email", "이메일", row++);
		genInfoPair("birth", "생년월일", row++);
		genInfoPair("pwd", "비밀번호", row++);
		genInfoPair("role", "권한", row++);
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

	@Override
	public void setData(Object model) {
		User user = (User) model;
		infoMap.get("id").setText(user.getId());
		infoMap.get("name").setText(user.getName());
		infoMap.get("address").setText(user.getAddress());
		infoMap.get("phone").setText(user.getPhoneNumber());
		infoMap.get("country").setText(user.getCountry());
		infoMap.get("regdent").setText(user.getRegdentNumber());
		infoMap.get("email").setText(user.getEmail());
		infoMap.get("birth").setText(user.getBirthDate());
		infoMap.get("pwd").setText(user.getPassword());
		infoMap.get("role").setText(user.getRole().getValue());
	}

	@Override
	public Object getData() {
		User user = new User();
		user.setId(infoMap.get("id").getText());
		user.setName(infoMap.get("name").getText());
		user.setAddress(infoMap.get("address").getText());
		user.setPhoneNumber(infoMap.get("phone").getText());
		user.setCountry(infoMap.get("country").getText());
		user.setRegdentNumber(infoMap.get("regdent").getText());
		user.setEmail(infoMap.get("email").getText());
		user.setBirthDate(infoMap.get("birth").getText());
		user.setPassword(infoMap.get("pwd").getText());
		user.setRole(Permission.valueOfType(infoMap.get("role").getText()));
		return user;
	}
}