package com.lec.gui.component.admin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.lec.MainGui;
import com.lec.gui.component.common.LecPanel;
import com.lec.lib.auth.Permission;
import com.lec.lib.auth.UserAuth;
import com.lec.lib.service.UserService;

@SuppressWarnings("serial")
public class RegisterPanel extends LecPanel {
	// components
	private JTextField idField;
	private JTextField nameField;
	private JTextField pwdField;
	private JTextField roleField;
	private JButton signUpBtn;

	private UserService userService = UserService.getInstance();

	public RegisterPanel(MainGui frame) {
		super(frame);

		idField = new JTextField("아이디");
		idField.setPreferredSize(new Dimension(200, 30));
		nameField = new JTextField("이름");
		nameField.setPreferredSize(new Dimension(200, 30));
		pwdField = new JTextField("비밀번호");
		pwdField.setPreferredSize(new Dimension(200, 30));
		roleField = new JTextField("권한");
		roleField.setPreferredSize(new Dimension(200, 30));
		signUpBtn = (new JButton("회원가입"));

		add(idField);
		add(nameField);
		add(pwdField);
		add(roleField);
		add(signUpBtn);
		signUpBtn.addActionListener(signUpListener);
	}

	private ActionListener signUpListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String name = nameField.getText();
			String password = pwdField.getText();
			String role = roleField.getText();

			if (id == "" || name == "" || password == "")
				return;

			// 사용자 추가
			if (userService.register(id, name, password, role, null)) {
				showMessageBox("회원등록 성공");
			} else {
				showMessageBox("회원등록 실패");
			}
		}
	};
}