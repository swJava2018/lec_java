package com.lec.gui.component.student.grade;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lec.lib.repo.model.LectureHistory;

@SuppressWarnings("serial")
public class GradeListTableModel extends AbstractTableModel {

	// 제목
	private final String[] header = { "Year", "Semester", "Subject Name", "Grade" };

	// 내용
	private List<LectureHistory> data;

	public GradeListTableModel(List<LectureHistory> data) {
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
			return data.get(rowIndex).getLecture().getYear();
		case 1:
			return data.get(rowIndex).getLecture().getSemester();
		case 2:
			return data.get(rowIndex).getLecture().getSubject().getName();
		case 3:
			return data.get(rowIndex).getGrade();
		default:
			return "default";
		}
	}

	public LectureHistory getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
