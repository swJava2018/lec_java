package com.lec.ui.controller.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lec.lib.api.UserAuth;
import com.lec.lib.api.impl.UserImpl;
import com.lec.lib.model.User;
import com.lec.ui.SwingApp;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private SwingApp frame;

	// component
	private JTextField idField;
	private JTextField pwdField;
	private JButton loginBtn;

	// api
	private UserImpl api;
	private UserAuth auth;

	public LoginPanel(SwingApp frame) {
		this.frame = frame;

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

		api = new UserImpl();
		auth = UserAuth.getInstance();
	}

	private ActionListener loginListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String password = pwdField.getText();
			if (id == "" || password == "")
				return;

			User user = api.login(id, password);
			JOptionPane op1 = new JOptionPane();
			if (user != null) {
				auth.login(user);
				frame.changeStudentTab();
				op1.showMessageDialog(null, user.getName() + " 로그인 성공");
			} else {
				op1.showMessageDialog(null, user.getName() + " 로그인 실패");
			}
		}
	};
}
