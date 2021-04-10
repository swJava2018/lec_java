package com.lec.gui.layout.admin;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class AdminLectureInfoView extends LecView {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();
	private Lecture data;

	public AdminLectureInfoView() {
		super();

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

	@Override
	public void setData(Object lecture) {
		data = (Lecture) lecture;
		infoMap.get("year").setText(data.getYear() + "");
		infoMap.get("semester").setText(data.getSemester() + "");
		infoMap.get("code").setText(data.getCode());
		infoMap.get("desc").setText(data.getDescription());
		infoMap.get("professor").setText(data.getProfessor().getUser().getName());
		infoMap.get("subject").setText(data.getSubject().getName());
	}

	@Override
	public Object getData() {
		data.setYear(Integer.parseInt(infoMap.get("year").getText()));
		data.setSemester(Integer.parseInt(infoMap.get("semester").getText()));
		data.setCode(infoMap.get("code").getText());
		data.setDescription(infoMap.get("desc").getText());
		return data;
	}
}