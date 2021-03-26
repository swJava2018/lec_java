package com.lec.gui.component.admin.lecture;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.repo.model.Lecture;
import com.lec.lib.repo.model.User;

@SuppressWarnings("serial")
public class LecturePanel extends LecPanel {
	// components
	private JScrollPane scrollPane;
	private LectureListTable userList;
	private LectureInfoPanel selected;
	private JButton loadBtn;
	private JButton updateBtn;
	private JButton registerBtn;
	private JButton deleteBtn;

	public LecturePanel(MainGui frame) {
		super(frame);

		// 선택된 사용자 정보
		selected = new LectureInfoPanel(frame);
		selected.setPreferredSize(new Dimension(400, 400));

		// 사용자 리스트
		userList = new LectureListTable(selected);
		scrollPane = new JScrollPane(userList);
		scrollPane.setPreferredSize(new Dimension(400, 400));

		loadBtn = (new JButton("강의 리스트 불러오기"));
		loadBtn.setPreferredSize(new Dimension(200, 30));
		loadBtn.addActionListener(loadListener);

		updateBtn = (new JButton("강의 정보 변경하기"));
		updateBtn.setPreferredSize(new Dimension(200, 30));
		updateBtn.addActionListener(updateListener);

		registerBtn = (new JButton("강의 정보 추가하기"));
		registerBtn.setPreferredSize(new Dimension(200, 30));
		registerBtn.addActionListener(registerListener);

		deleteBtn = (new JButton("강의 정보 삭제하기"));
		deleteBtn.setPreferredSize(new Dimension(200, 30));
		deleteBtn.addActionListener(deleteListener);

		initLayout();

		refresh();
	}

	private void initLayout() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		add(scrollPane, c);

		c.gridx = 1;
		c.gridy = 0;
		add(selected, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 1;
		add(loadBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		add(updateBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 3;
		add(registerBtn, c);

		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 4;
		add(deleteBtn, c);
	}

	private void refresh() {
		List<Lecture> lectures = lectureService.readAll();
		userList.setModel(new LectureListTableModel(lectures));
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = selected.getData();
			if (lectureService.update(lecture.getCode(), lecture)) {
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture lecture = selected.getData();
			if (lectureService.register(lecture.getCode(), lecture)) {
				refresh();
			}
		}
	};

	private ActionListener deleteListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Lecture Lecture = selected.getData();
			if (userService.delete(Lecture.getCode())) {
				refresh();
			}
		}
	};
}
