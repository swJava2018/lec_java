package com.lec.gui.component.common;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lec.MainGui;
import com.lec.lib.auth.UserAuth;
import com.lec.lib.service.LectureService;
import com.lec.lib.service.SchoolService;
import com.lec.lib.service.StudentService;
import com.lec.lib.service.SubjectService;
import com.lec.lib.service.UserService;

@SuppressWarnings("serial")
public class LecPanel extends JPanel {
	protected MainGui frame;
	protected static UserService userService = UserService.getInstance();
	protected static SubjectService subjectService = SubjectService.getInstance();
	protected static StudentService studentService = StudentService.getInstance();
	protected static LectureService lectureService = LectureService.getInstance();
	protected static SchoolService schoolService = SchoolService.getInstance();
	protected static UserAuth auth = UserAuth.getInstance();

	// component
	private JOptionPane op = new JOptionPane();

	public LecPanel(MainGui frame) {
		this.frame = frame;
	}

	@SuppressWarnings("static-access")
	protected void showMessageBox(String message) {
		op.showMessageDialog(this, message);
	}
}
