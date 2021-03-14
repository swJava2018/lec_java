package com.lec.gui.component.student.schedule;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;

@SuppressWarnings("serial")
public class ScheduleSubjectPanel extends LecPanel {

	private JLabel subjectLbl;

	public ScheduleSubjectPanel(MainGui frame) {
		super(frame);

		subjectLbl = new JLabel("과목");

		this.setLayout(new BorderLayout());
		this.add(subjectLbl);
	}

	public void setSubjectLbl(String name) {
		subjectLbl.setText(name);
	}
}
