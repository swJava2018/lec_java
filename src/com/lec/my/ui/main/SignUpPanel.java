package com.lec.my.ui.main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lec.my.api.UserAPI;

@SuppressWarnings("serial")
public class SignUpPanel extends JPanel {
	private Frame frame;

	// component
	private JTextField idField;
	private JTextField nameField;
	private JTextField pwdField;
	private JButton signUpBtn;

	public SignUpPanel(Frame frame) {
		this.frame = frame;

//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		idField = new JTextField("아이디");
		idField.setPreferredSize(new Dimension(200, 30));
		nameField = new JTextField("이름");
		nameField.setPreferredSize(new Dimension(200, 30));
		pwdField = new JTextField("비밀번호");
		pwdField.setPreferredSize(new Dimension(200, 30));
		signUpBtn = (new JButton("회원가입"));

		add(idField);
		add(nameField);
		add(pwdField);
		add(signUpBtn);
		signUpBtn.addActionListener(signUpListener);
	}

	private ActionListener signUpListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String id = idField.getText();
			String name = nameField.getText();
			String password = pwdField.getText();

			if (id == "" || name == "" || password == "")
				return;
			boolean result = UserAPI.getInstance().register(id, name, password);
			JOptionPane op1 = new JOptionPane();
			if (result) {
				op1.showMessageDialog(null, id + " 회원가입 성공");
			} else {
				op1.showMessageDialog(null, id + " 회원가입 실패");
			}
		}
	};
}
