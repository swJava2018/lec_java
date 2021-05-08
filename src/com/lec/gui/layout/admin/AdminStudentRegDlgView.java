package com.lec.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.Department;
import com.lec.lib.repo.model.Division;
import com.lec.lib.repo.model.Student;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class AdminStudentRegDlgView extends LecView {
	private HashMap<String, JComponent> infoMap = new HashMap<String, JComponent>();

	public AdminStudentRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genTextFieldPair("id", "학생 학번", row++);
		genTextFieldPair("name", "이름", row++);
		genTextFieldPair("address", "주소", row++);
		genTextFieldPair("phone", "전화번호", row++);
		genTextFieldPair("country", "국적", row++);
		genTextFieldPair("regdent", "주민등록번호", row++);
		genTextFieldPair("email", "이메일", row++);
		genTextFieldPair("birth", "생년월일", row++);
		genTextFieldPair("pwd", "비밀번호", row++);
		genComboBoxPair("dep", "학부", row++);
		genComboBoxPair("div", "학과", row++);
	}

	private void genTextFieldPair(String id, String name, int row) {
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

	private void genComboBoxPair(String id, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JComboBox<String> comboBox = new JComboBox<String>();
		c.gridx = 1;
		c.gridy = row;
		add(comboBox, c);

		infoMap.put(id, comboBox);
	}

	@Override
	public void setData(Object model) {
		Student student = (Student) model;
		User user = student.getUser();
		((JTextField) infoMap.get("id")).setText(user.getId());
		((JTextField) infoMap.get("name")).setText(user.getName());
		((JTextField) infoMap.get("address")).setText(user.getAddress());
		((JTextField) infoMap.get("phone")).setText(user.getPhoneNumber());
		((JTextField) infoMap.get("country")).setText(user.getCountry());
		((JTextField) infoMap.get("regdent")).setText(user.getRegdentNumber());
		((JTextField) infoMap.get("email")).setText(user.getEmail());
		((JTextField) infoMap.get("birth")).setText(user.getBirthDate());
		((JTextField) infoMap.get("pwd")).setText(user.getPassword());
		((JTextField) infoMap.get("dep")).setText(student.getDep().getName());
		((JTextField) infoMap.get("div")).setText(student.getDiv().getName());
	}

	@Override
	public Object getData() {
		Student student = new Student();
		User user = new User();
		user.setId(((JTextField) infoMap.get("id")).getText());
		user.setName(((JTextField) infoMap.get("name")).getText());
		user.setAddress(((JTextField) infoMap.get("address")).getText());
		user.setPhoneNumber(((JTextField) infoMap.get("phone")).getText());
		user.setCountry(((JTextField) infoMap.get("country")).getText());
		user.setRegdentNumber(((JTextField) infoMap.get("regdent")).getText());
		user.setEmail(((JTextField) infoMap.get("email")).getText());
		user.setBirthDate(((JTextField) infoMap.get("birth")).getText());
		user.setPassword(((JTextField) infoMap.get("pwd")).getText());
		student.setUser(user);

		Division div = new Division();
		div.setCode("code");
		div.setName("name");
		student.setDiv(div);

		Department dep = new Department();
		dep.setCode("code");
		dep.setName("name");
		student.setDep(dep);
		return student;
	}

	@SuppressWarnings("unchecked")
	public JComboBox<Division> getDivComboBox() {
		return (JComboBox<Division>) infoMap.get("div");
	}

	@SuppressWarnings("unchecked")
	public JComboBox<Department> getDepComboBox() {
		return (JComboBox<Department>) infoMap.get("dep");
	}
}
