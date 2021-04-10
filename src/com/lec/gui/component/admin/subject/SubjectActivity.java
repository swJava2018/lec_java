package com.lec.gui.component.admin.subject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.gui.layout.admin.AdminSubjectLayout;
import com.lec.gui.layout.common.LecTableView;
import com.lec.gui.layout.common.LecView;
import com.lec.lib.repo.model.Subject;

@SuppressWarnings("serial")
public class SubjectActivity extends LecPanel {
	private LecTableView list;
	private LecView info;

	public SubjectActivity(MainGui frame) {
		super(frame);

		// set layout
		AdminSubjectLayout layout = new AdminSubjectLayout();
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
			List<Subject> subjects = subjectService.readAll();
			list.setModel(new SubjectListTableAdapter(subjects));
		}
	}

	private ActionListener loadListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			refresh();
		}
	};

	private ActionListener updateListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Subject subject = (Subject) info.getData();
			if (subjectService.update(subject.getCode(), subject.getName())) {
				refresh();
			}
		}
	};

	private ActionListener registerListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Subject subject = (Subject) info.getData();
			if (subjectService.register(subject.getCode(), subject.getName())) {
				refresh();
			}
		}
	};

	private ActionListener deleteListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Subject subject = (Subject) info.getData();
			if (subjectService.delete(subject.getCode())) {
				refresh();
			}
		}
	};
}
