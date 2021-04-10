package com.lec.gui.layout.student;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.lec.gui.layout.common.LecView;

@SuppressWarnings("serial")
public class StudentScheduleLectureView extends LecView {

	private JLabel subjectLbl;

	public StudentScheduleLectureView() {
		super();

		subjectLbl = new JLabel(".");

		setLayout(new BorderLayout());
		add(subjectLbl);
	}

	@Override
	public void setData(Object model) {
		String name = (String) model;
		subjectLbl.setText(name);

	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return null;
	}
}
