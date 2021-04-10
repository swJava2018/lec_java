package com.lec.gui.component.admin.user;

import java.util.List;

import com.lec.gui.layout.common.LecTableAdapter;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserListTableAdapter extends LecTableAdapter {

	// 제목
	private final String[] header = { "학번", "이름", "권한" };

	// 내용
	private List<User> data;

	public UserListTableAdapter(List<User> data) {
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
			return data.get(rowIndex).getId();
		case 1:
			return data.get(rowIndex).getName();
		case 2:
			return data.get(rowIndex).getRole();
		default:
			return "default";
		}
	}

	@Override
	public Object getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
