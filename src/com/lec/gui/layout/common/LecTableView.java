package com.lec.gui.layout.common;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.lec.gui.layout.UserInfoView;

@SuppressWarnings("serial")
public class LecTableView extends JTable implements ListSelectionListener {
	private LecView detailPanel;

	public LecTableView(LecView detailPanel) {
		this.detailPanel = detailPanel;

		// 선택 방법 세팅
		ListSelectionModel selectModel = this.getSelectionModel();

		// 1개만 선택 가능한 모드
		selectModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selectModel.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {

			// 선택된 레코드가 없을 경우 -1을 반환
			int row = this.getSelectedRow();
			if (row != -1) {
				Object obj = ((LecTableAdapter) this.getModel()).getRow(row);

				// 선택된 레코드로 정보 변경
				detailPanel.setData(obj);
			}
		}
	}
}
