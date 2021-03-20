package com.lec.gui.component.admin;

import java.awt.Color;

import com.lec.MainGui;
import com.lec.gui.component.common.LecCardPanel;

@SuppressWarnings("serial")
public class AdminCard extends LecCardPanel {
	public AdminCard(MainGui frame) {
		super(frame);

		setBackground(new Color(204, 204, 255));
		setPanel(new AdminTab(frame));
	}
}
