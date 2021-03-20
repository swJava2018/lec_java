package com.lec.gui.component.student.user;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Student;

@SuppressWarnings("serial")
public class StudentInfoPanel extends LecPanel {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

	public StudentInfoPanel(MainGui frame) {
		super(frame);

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		genInfoPair("id", "ID", 0);
		genInfoPair("div_code", "학부", 1);
		genInfoPair("dep_code", "학과", 2);
		genInfoPair("status", "학적 상태", 3);
		genInfoPair("disability", "장애 여부", 4);
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
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			Student student = studentService.read(auth.getUser().getId());
			setData(student);
		}
	}

	public void setData(Student student) {
		infoMap.get("id").setText(student.getUser().getId());
		infoMap.get("div_code").setText(student.getDiv().getCode());
		infoMap.get("dep_code").setText(student.getDep().getCode());
		infoMap.get("status").setText(student.getStatus());
		infoMap.get("disability").setText(student.getDisability().toString());
	}

//	public Student getData() {
//		Student student = new Student();
//		student.setUser(infoMap.get("id").getText());
//		student.setName(infoMap.get("name").getText());
//		student.setAddress(infoMap.get("address").getText());
//		student.setPhoneNumber(infoMap.get("phone").getText());
//		student.setCountry(infoMap.get("country").getText());
//		user.setRegdentNumber(infoMap.get("regdent").getText());
//		user.setEmail(infoMap.get("email").getText());
//		user.setBirthDate(infoMap.get("birth").getText());
//		user.setPassword(infoMap.get("pwd").getText());
//		user.setRole(Permission.valueOfType(infoMap.get("role").getText()));
//		return user;
//	}
}