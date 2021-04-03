package com.lec.gui.layout.common;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class LecTableAdapter extends AbstractTableModel {
	abstract public Object getRow(int rowIndex);
}
