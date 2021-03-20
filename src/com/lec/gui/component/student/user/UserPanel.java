package com.lec.gui.component.student.user;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;

@SuppressWarnings("serial")
public class UserPanel extends LecPanel {
	public UserPanel(MainGui frame) {
		super(frame);
		
		initLayout();
	}
	
	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(new UserInfoPanel(frame), c);
		
		c.gridx = 1;
		c.gridy = 0;
		add(new StudentInfoPanel(frame), c);
	}
}
