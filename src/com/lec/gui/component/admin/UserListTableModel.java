package com.lec.gui.component.admin;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class UserListTableModel extends AbstractTableModel {

	// 제목
	private final String[] header = { "ID", "Name", "Role" };
	
	// 내용
	private List<User> data;

	public UserListTableModel(List<User> data) {
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

	public User getRow(int rowIndex) {
		return data.get(rowIndex);
	}
}
