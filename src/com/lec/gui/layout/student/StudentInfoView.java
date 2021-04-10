package com.lec.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.Student;

@SuppressWarnings("serial")
public class StudentInfoView extends LecView {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

	public StudentInfoView() {
		super();

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("id", "ID", row++);
		genInfoPair("div_code", "학부", row++);
		genInfoPair("dep_code", "학과", row++);
		genInfoPair("status", "학적 상태", row++);
		genInfoPair("disability", "장애 여부", row++);
		genInfoPair("admission_year", "입학년도", row++);
		genInfoPair("admission_semester", "입학학기", row++);
		genInfoPair("graduation_year", "졸업년도", row++);
		genInfoPair("graduation_semester", "졸업학기", row++);
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
		Student student = (Student) model;
		infoMap.get("id").setText(student.getUser().getId());
		infoMap.get("div_code").setText(student.getDiv().getCode());
		infoMap.get("dep_code").setText(student.getDep().getCode());
		infoMap.get("status").setText(student.getStatus());
		infoMap.get("disability").setText(student.getDisability().toString());
		infoMap.get("admission_year").setText(student.getAdmissionYear().toString());
		infoMap.get("admission_semester").setText(student.getAdmissionSemester().toString());
		infoMap.get("graduation_year").setText(student.getGraduationYear().toString());
		infoMap.get("graduation_semester").setText(student.getGraduationSemester().toString());
	}

	@Override
	public Object getData() {
		return null;
	}
}