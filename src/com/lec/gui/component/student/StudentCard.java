package com.lec.gui.component.student;

import java.awt.Color;

import com.lec.MainGui;
import com.lec.gui.component.common.LecCardPanel;

@SuppressWarnings("serial")
public class StudentCard extends LecCardPanel {
	public StudentCard(MainGui frame) {
		super(frame);

		setBackground(new Color(153, 204, 255));
		setPanel(new StudentTab(frame));
	}
}
