package com.lec.gui.component.admin.lecture;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class LectureListTableModel extends AbstractTableModel {

	// 제목
	private final String[] header = { "강의코드", "과목이름", "강의소개" };

	// 내용
	private List<Lecture> data;

	public LectureListTableModel(List<Lecture> data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return header.length;
	}

	@Override
	public String getColumnName(int col) {
		return header[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return data.get(rowIndex).getCode();
		case 1:
			return data.get(rowIndex).getSubject().getName();
		case 2:
			return data.get(rowIndex).getDescription();
		default:
			return "default";
		}
	}

	public Lecture getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
