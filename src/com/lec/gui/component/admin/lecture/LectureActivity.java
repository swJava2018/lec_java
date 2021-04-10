package com.lec.gui.component.admin.lecture;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.admin.AdminLectureLayout;
import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.Lecture;

@SuppressWarnings("serial")
public class LectureActivity extends LecPanel {
	private LecTableView list;
	private LecView info;

	public LectureActivity(MainGui frame) {
		super(frame);

		// set layout
		AdminLectureLayout layout = new AdminLectureLayout();
		add(layout);

		// set button
		JButton loadBtn = layout.getLoadBtn();
		JButton updateBtn = layout.getUpdateBtn();
		JButton registerBtn = layout.getRegisterBtn();
		JButton deleteBtn = layout.getDeleteBtn();
		loadBtn.addActionListener(loadListener);
		updateBtn.addActionListener(updateListener);
		registerBtn.addActionListener(registerListener);
		deleteBtn.addActionListener(deleteListener);

		// set list
		list = layout.getList();
		info = layout.getSelected();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		refresh();
	}

	private void refresh() {
		if (auth.isLogin()) {
			List<Lecture> lectures = lectureService.readAll();
			list.setModel(new LectureListTableAdapter(lectures));
		}
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = (Lecture) info.getData();
			if (lectureService.update(lecture.getCode(), lecture)) {
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = (Lecture) info.getData();
			if (lectureService.register(lecture.getCode(), lecture)) {
				refresh();
			}
		}
	};

	private ActionListener deleteListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture Lecture = (Lecture) info.getData();
			if (userService.delete(Lecture.getCode())) {
				refresh();
			}
		}
	};
}
