package com.lec.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.auth.Permission;

@SuppressWarnings("serial")
public class AdminUserInfoRegDlgView extends LecView {

	private HashMap<String, JComponent> infoMap = new HashMap<String, JComponent>();

	public AdminUserInfoRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));

		changeToStudent();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genComboBoxPair("role", "권한", row++);
		genView("student", new AdminStudentRegDlgView(), row);
		genView("professor", new AdminProfessorRegDlgView(), row);
	}

	private void genView(String id, JComponent view, int row) {
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = row;
		add(view, c);

		infoMap.put(id, view);
	}

	private void genComboBoxPair(String id, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JComboBox<Permission> comboBox = new JComboBox<Permission>();
		c.gridx = 1;
		c.gridy = row;
		add(comboBox, c);

		infoMap.put(id, comboBox);
	}

	@Override
	public void setData(Object model) {
	}

	@Override
	public Object getData() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public JComboBox<Permission> getRoleComboBox() {
		return (JComboBox<Permission>) infoMap.get("role");
	}

	public AdminStudentRegDlgView getStudent() {
		return (AdminStudentRegDlgView) infoMap.get("student");
	}

	public AdminProfessorRegDlgView getProfessor() {
		return (AdminProfessorRegDlgView) infoMap.get("professor");
	}

	public void changeToStudent() {
		infoMap.get("professor").setVisible(false);
		infoMap.get("student").setVisible(true);
	}

	public void changeToProfessor() {
		infoMap.get("professor").setVisible(true);
		infoMap.get("student").setVisible(false);
	}
}
