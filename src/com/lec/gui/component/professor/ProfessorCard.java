package com.lec.gui.component.professor;

import com.lec.MainGui;
import com.lec.gui.component.common.LecCardPanel;

@SuppressWarnings("serial")
public class ProfessorCard extends LecCardPanel {

	public ProfessorCard(MainGui frame) {
		super(frame);

		this.setPanel(new ProfessorTab(frame));
	}
}
