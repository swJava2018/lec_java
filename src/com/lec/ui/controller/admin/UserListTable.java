package com.lec.ui.controller.admin;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class UserListTable extends AbstractTableModel {

	private Object[][] data;

	public UserListTable(Object[][] data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

}
