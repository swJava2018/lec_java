package com.lec.gui.component.admin.subject;

import java.util.List;

import com.lec.gui.layout.common.LecTableAdapter;
import com.lec.lib.repo.model.Subject;

@SuppressWarnings("serial")
public class SubjectListTableAdapter extends LecTableAdapter {

	// 제목
	private final String[] header = { "과목코드", "과목이름" };
	
	// 내용
	private List<Subject> data;

	public SubjectListTableAdapter(List<Subject> data) {
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

	@Override
	public Subject getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
