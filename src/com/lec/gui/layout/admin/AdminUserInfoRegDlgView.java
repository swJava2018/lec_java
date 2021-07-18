package com.lec.gui.layout.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.auth.Permission;

@SuppressWarnings("serial")
public class AdminUserInfoRegDlgView extends LecView {
	private JComboBox<Permission> roleCbx = new JComboBox<Permission>();
	private AdminStudentRegDlgView studRegDlg = new AdminStudentRegDlgView();
	private AdminProfessorRegDlgView profRegDlg = new AdminProfessorRegDlgView();

	public AdminUserInfoRegDlgView() {
		super();

		initLayout();
		setBackground(new Color(200, 200, 200));

		changeToStudent();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genComboBoxPair("권한", roleCbx, row++);
		genView(studRegDlg, row);
		genView(profRegDlg, row);
	}

	private void genView(JComponent view, int row) {
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = row;
		add(view, c);
	}

	private void genComboBoxPair(String name, JComboBox<Permission> cbx, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		c.gridx = 1;
		c.gridy = row;
		add(cbx, c);
	}

	@Override
	public void setData(Object model) {
	}

	@Override
	public Object getData() {
		return null;
	}

	public JComboBox<Permission> getRoleComboBox() {
		return roleCbx;
	}

	public AdminStudentRegDlgView getStudent() {
		return studRegDlg;
	}

	public AdminProfessorRegDlgView getProfessor() {
		return profRegDlg;
	}

	public void changeToStudent() {
		profRegDlg.setVisible(false);
		studRegDlg.setVisible(true);
	}

	public void changeToProfessor() {
		profRegDlg.setVisible(true);
		studRegDlg.setVisible(false);
	}
}
