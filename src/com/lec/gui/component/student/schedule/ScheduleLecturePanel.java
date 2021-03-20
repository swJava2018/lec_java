package com.lec.gui.component.student.schedule;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;

@SuppressWarnings("serial")
public class ScheduleLecturePanel extends LecPanel {

	private JLabel subjectLbl;

	public ScheduleLecturePanel(MainGui frame) {
		super(frame);

		subjectLbl = new JLabel(".");

		this.setLayout(new BorderLayout());
		this.add(subjectLbl);
	}

	public void setSubjectLbl(String name) {
		subjectLbl.setText(name);
	}
}
