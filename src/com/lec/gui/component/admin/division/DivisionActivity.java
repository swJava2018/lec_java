package com.lec.gui.component.admin.division;

import java.awt.Graphics;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;

@SuppressWarnings("serial")
public class DivisionActivity extends LecPanel {

	public DivisionActivity(MainGui frame) {
		super(frame);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {

	}
}
