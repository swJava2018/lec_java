package com.lec.gui.component.admin.subject;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Subject;

@SuppressWarnings("serial")
public class SubjectInfoPanel extends LecPanel {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();

	public SubjectInfoPanel(MainGui frame) {
		super(frame);

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("code", "과목코드", row++);
		genInfoPair("name", "과목이름", row++);
	}

	private void genInfoPair(String id, String name, int row) {
		GridBagConstraints c = new GridBagConstraints();

		JLabel label = new JLabel(name);
		label.setPreferredSize(new Dimension(100, 30));
		c.gridx = 0;
		c.gridy = row;
		add(label, c);

		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(200, 30));
		c.gridx = 1;
		c.gridy = row;
		add(field, c);

		infoMap.put(id, field);
	}

	public void setData(Subject obj) {
		infoMap.get("code").setText(obj.getCode());
		infoMap.get("name").setText(obj.getName());
	}

	public Subject getData() {
		Subject subject = new Subject();
		subject.setCode(infoMap.get("code").getText());
		subject.setName(infoMap.get("name").getText());
		return subject;
	}
}