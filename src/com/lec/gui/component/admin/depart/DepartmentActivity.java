package com.lec.gui.component.admin.depart;

import java.awt.Graphics;

import com.lec.MainGui;
import com.lec.gui.component.common.LecActivityPanel;

@SuppressWarnings("serial")
public class DepartmentActivity extends LecActivityPanel {

	public DepartmentActivity(MainGui frame) {
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
