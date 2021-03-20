package com.lec.gui.component.login;

import com.lec.MainGui;
import com.lec.gui.component.common.LecCardPanel;

@SuppressWarnings("serial")
public class LoginCard extends LecCardPanel {
	public LoginCard(MainGui frame) {
		super(frame);

		setPanel(new LoginTab(frame));
	}
}
