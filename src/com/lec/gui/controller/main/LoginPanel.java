package com.lec.gui.controller.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.lec.gui.SwingApp;
import com.lec.gui.controller.common.LecPanel;
import com.lec.lib.api.UserAuth;

@SuppressWarnings("serial")
public class LoginPanel extends LecPanel {
	// component
	private JTextField idField;
	private JTextField pwdField;
	private JButton loginBtn;

	public LoginPanel(SwingApp frame) {
		super(frame);

//		setLayout(new GridLayout(5, 1));
		idField = new JTextField("아이디");
		idField.setPreferredSize(new Dimension(200, 30));
		pwdField = new JTextField("비밀번호");
		pwdField.setPreferredSize(new Dimension(200, 30));
		loginBtn = (new JButton("로그인"));
		loginBtn.setPreferredSize(new Dimension(200, 30));

		add(idField);
		add(pwdField);
		add(loginBtn);
		loginBtn.addActionListener(loginListener);
	}

	private ActionListener loginListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String password = pwdField.getText();
			if (id == "" || password == "")
				return;

			UserAuth auth = UserAuth.getInstance();

			// 로그인 확인
			if (auth.isLogin()) {
				showMessageBox("it's need to logout");
				return;
			}

			// 로그인
			if (!auth.login(id, password)) {
				showMessageBox("로그인 실패");
			} else {
				showMessageBox("로그인 성공");
				switch (auth.getUser().getRole()) {
				case Student:
					frame.changeStudentTab();
					break;
				case Professor:
					frame.changeProfessorTab();
					break;
				case Employee:
					frame.changeEmployeeTab();
					break;
				case Admin:
					frame.changeAdminTab();
					break;
				default:
					break;
				}

			}
		}
	};
}
