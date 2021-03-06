package com.lec.gui.component.admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lec.lib.repo.model.Subject;

@SuppressWarnings("serial")
public class SubjectListTableModel extends AbstractTableModel {

	// 제목
	private final String[] header = { "Code", "Name" };
	
	// 내용
	private List<Subject> data;

	public SubjectListTableModel(List<Subject> data) {
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
			return data.get(rowIndex).getName();
		default:
			return "default";
		}
	}

	public Subject getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
