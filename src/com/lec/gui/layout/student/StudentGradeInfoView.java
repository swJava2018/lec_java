package com.lec.gui.layout.student;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.LectureHistory;

@SuppressWarnings("serial")
public class StudentGradeInfoView extends LecView {
	private HashMap<String, JTextField> infoMap = new HashMap<String, JTextField>();
	private LectureHistory data;

	public StudentGradeInfoView() {
		super();

		initLayout();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());

		int row = 0;
		genInfoPair("year", "강의 연도", row++);
		genInfoPair("semester", "강의 학기", row++);
		genInfoPair("code", "과목 코드", row++);
		genInfoPair("name", "과목 이름", row++);
		genInfoPair("professor", "교수 이름", row++);
		genInfoPair("grade", "점수", row++);
		genInfoPair("status", "상태", row++);
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
	public void setData(Object model) {
		data = (LectureHistory) model;
		infoMap.get("year").setText(data.getLecture().getYear() + "");
		infoMap.get("semester").setText(data.getLecture().getSemester() + "");
		infoMap.get("code").setText(data.getLecture().getSubject().getCode());
		infoMap.get("name").setText(data.getLecture().getSubject().getName());
		infoMap.get("professor").setText(data.getLecture().getProfessor().getUser().getName());
		infoMap.get("grade").setText(data.getGrade());
		infoMap.get("status").setText(data.getStatus().getValue());
	}

	@Override
	public LectureHistory getData() {
		return data;
	}
}