package com.lec.gui.component.admin.lecture;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class LectureInfoPanel extends LecPanel {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();
	private Lecture data;

	public LectureInfoPanel(MainGui frame) {
		super(frame);

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("year", "년도", row++);
		genInfoPair("semester", "학기", row++);
		genInfoPair("code", "강의코드", row++);
		genInfoPair("desc", "강의소개", row++);
		genInfoPair("professor", "교수이름", row++);
		genInfoPair("subject", "과목이름", row++);
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

	public void setData(Lecture lecture) {
		data = lecture;
		infoMap.get("year").setText(lecture.getYear() + "");
		infoMap.get("semester").setText(lecture.getSemester() + "");
		infoMap.get("code").setText(lecture.getCode());
		infoMap.get("desc").setText(lecture.getDescription());
		infoMap.get("professor").setText(lecture.getProfessor().getUser().getName());
		infoMap.get("subject").setText(lecture.getSubject().getName());
	}

	public Lecture getData() {
		data.setYear(Integer.parseInt(infoMap.get("year").getText()));
		data.setSemester(Integer.parseInt(infoMap.get("semester").getText()));
		data.setCode(infoMap.get("code").getText());
		data.setDescription(infoMap.get("desc").getText());
		return data;
	}
}